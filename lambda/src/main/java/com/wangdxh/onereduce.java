package com.wangdxh;

import javafx.util.Pair;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class subinfo{
    public subinfo(String varname, String subtext, String fvlist)
    {
        this.varname = varname;
        this.subtext = subtext;
        this.fvlist = fvlist;
    }

    public String varname;
    public String subtext;
    public String fvlist;
}

public class onereduce extends lambdaBaseVisitor<String>
{
    public final static String OVER = "this is over";

    private Map<String, String> m_ctxtofvstr = null;

    public onereduce(Map<String, String> ctxtofvstr)
    {
        this.m_ctxtofvstr = ctxtofvstr;
    }

    String strletter;
    char m_lastnewvar = 'a';
    private String newVar()
    {
        for(char i = m_lastnewvar; i < 'z'; i++){
            if (-1 == strletter.indexOf(i)){
                m_lastnewvar = i;
                return String.valueOf(i);
            }
        }
        return "λ";
    }

    private List<subinfo> m_sublist = new ArrayList<>();
    String m_argslist = "";

    private String subvariablefromsublist(String varname){
        // 从后往前查找替换
        for(int i = this.m_sublist.size()-1; i >= 0; i--){
            if (this.m_sublist.get(i).varname.equals(varname)){
                return this.m_sublist.get(i).subtext;
            }
        }
        return varname;
    }


    ParserRuleContext m_leftctx = null;
    ParserRuleContext m_rightctx = null;
    private void setApplyctx(ParserRuleContext left, ParserRuleContext right){
        if (m_leftctx == null && m_rightctx == null){
            m_leftctx = left;
            m_rightctx = right;
            System.out.println("apply"+m_leftctx.getText()+"->"+m_rightctx.getText());
        }
    }

    @Override
    public String visitExprstat(lambdaParser.ExprstatContext ctx)
    {
        this.strletter = ctx.getText();
        String strret = this.visit(ctx.expression());
        if (this.m_leftctx == null && this.m_rightctx == null){
            return OVER;
        }
        return strret;
    }

    @Override
    public String visitVarexpr(lambdaParser.VarexprContext ctx)
    {
        if (this.m_rightctx == ctx){
            return "";
        }
        String varname = ctx.VARIABLE().getText();
        if (this.m_argslist.indexOf(varname) == -1){
            //自由变量
            return this.subvariablefromsublist(varname);
        }
        return varname;
    }

    @Override
    public String visitFunnoparenth(lambdaParser.FunnoparenthContext ctx)
    {
        return this.visitfuntion(ctx);
    }

    @Override
    public String visitFunwithpareth(lambdaParser.FunwithparethContext ctx)
    {
        return this.visitfuntion(ctx);
    }

    private String visitfuntion(ParserRuleContext ctx)
    {
        if (this.m_rightctx == ctx){
            //System.out.println("right is here:" + ctx.getText());
            return "";
        }
        List<TerminalNode> varlist = ctx.getTokens(lambdaParser.VARIABLE);
        lambdaParser.ScopeContext scope = ctx.getRuleContext(lambdaParser.ScopeContext.class,0);
        String varname = varlist.get(0).getText();

        // 就是它，处理替换过程 只会进来一次，所以sublist清空之后，不会再次进入
        if (this.m_sublist.size() == 0 && this.m_leftctx == ctx){
            // clear the environment 备份之前的参数列表，清空参数列表
            String tempargslist = this.m_argslist;
            this.m_argslist = "";

            // add sublist and return visit
            //System.out.println("right fvlist:" + this.m_ctxtofvstr.get(this.m_rightctx.toString()));

            this.m_sublist.add(new subinfo(varname, this.m_rightctx.getText(), this.m_ctxtofvstr.get(this.m_rightctx.toString())));
            String strsub = this.visit(scope);

            // 清空
            this.m_sublist.clear();

            //恢复之前的argslist
            this.m_argslist = tempargslist;
            return strsub;
        }

        //替换过程
        String args = varname, ret = "";

        if (this.m_sublist.size() > 0){
            subinfo subitem = this.m_sublist.get(0);

            // 当前lambda定义里面的自由变量 减 去爸爸的参数 就是真正的自由变量
            //System.out.println(ctx +":"+ ctx.getText());
            String thisfvlist = this.m_ctxtofvstr.get(ctx.toString());
            //System.out.println(ctx +":"+ ctx.getText()+"->" + thisfvlist);
            String tempfv = "";
            for(int i = 0; i < thisfvlist.length(); i++){
                if (this.m_argslist.indexOf(thisfvlist.charAt(i)) == -1){
                    tempfv += String.valueOf(thisfvlist.charAt(i));
                }
            }
            //String tempfv =  list(set(this.ctxtofv[ctx]).difference(set(this.argslist)))
            if ((subitem.fvlist.indexOf(varname) != -1) && (tempfv.indexOf(subitem.varname) != -1)){
                args = this.newVar();
                this.m_sublist.add(new subinfo(varname, args, args));
                this.m_argslist += args;

                ret = this.visit(scope);

                this.m_argslist = this.m_argslist.substring(0, this.m_argslist.length()-1);
                this.m_sublist.remove(m_sublist.size()-1);
                return "(^" + args + '.' + ret + ")";
            }
        }

        this.m_argslist += varname;
        ret = this.visit(scope);
        this.m_argslist = this.m_argslist.substring(0, this.m_argslist.length()-1);
        return "(^" + args + '.' + ret + ")";
    }

    /*      ctx'sfather
              /         \
           ctx            b
          /   \
         a   (^x.M)
    */
    private  String visitapply(ParserRuleContext ctxinput)
    {
        if (this.m_rightctx == ctxinput){
            return "";
        }

        lambdaParser.ExpressionContext left = ctxinput.getRuleContext(lambdaParser.ExpressionContext.class, 0);
        lambdaParser.ExpressionContext right = ctxinput.getRuleContext(lambdaParser.ExpressionContext.class, 1);

        if ((left instanceof lambdaParser.FunnoparenthContext)
                ||(left instanceof lambdaParser.FunwithparethContext)){
            this.setApplyctx(left, right);
        }

        String strleft = this.visit(left);

        if((right instanceof lambdaParser.FunnoparenthContext)
                ||(right instanceof lambdaParser.FunwithparethContext))
        {
            ParserRuleContext parent = ctxinput.getParent();
            if((parent instanceof lambdaParser.ApplywithparethContext)
                || (parent instanceof lambdaParser.ApplynoparethContext))
            {
                this.setApplyctx(right, parent.getRuleContext(lambdaParser.ExpressionContext.class,1));
            }
        }
        String strright = this.visit(right);
        if(ctxinput instanceof lambdaParser.ApplywithparethContext){
            return "(" + strleft + strright + ")";
        }
        return strleft + strright;
    }
    @Override
    public String visitApplywithpareth(lambdaParser.ApplywithparethContext ctx)
    {
        return visitapply(ctx);
    }

    @Override
    public String visitApplynopareth(lambdaParser.ApplynoparethContext ctx)
    {
        return visitapply(ctx);
    }

    @Override
    public String visitScope(lambdaParser.ScopeContext ctx)
    {
        return this.visit(ctx.expression());
    }
}
