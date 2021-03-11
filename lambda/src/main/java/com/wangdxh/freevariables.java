package com.wangdxh;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class freevariables extends lambdaBaseVisitor<String>
{
    String freelist = "";
    String argslist = "";

    @Override
    public String visitProgram(lambdaParser.ProgramContext ctx)
    {
        return super.visitProgram(ctx);
    }

    @Override
    public String visitExprstat(lambdaParser.ExprstatContext ctx)
    {
        freelist = "";
        argslist = "";
        String strret = this.visit(ctx.expression());

        StringBuilder strout = new StringBuilder();
        for (int i = 0; i < freelist.length(); i++){
            strout.append(freelist.charAt(i));
            if (i != (freelist.length()-1)){
                strout.append(',');
            }
        }

        System.out.println(ctx.getText() + "  ->  " + "{" + strout.toString() + "}");
        return strret;
    }

    @Override
    public String visitSubstitution(lambdaParser.SubstitutionContext ctx)
    {
        return super.visitSubstitution(ctx);
    }

    @Override
    public String visitVarexpr(lambdaParser.VarexprContext ctx)
    {
        String varname = ctx.VARIABLE().getText();

        if (this.argslist.indexOf(varname) == -1 && this.freelist.indexOf(varname) == -1){
            this.freelist += varname;
        }
        return "";
    }


    private  String visitapply(ParserRuleContext ctxinput)
    {
        lambdaParser.ExpressionContext left = ctxinput.getRuleContext(lambdaParser.ExpressionContext.class, 0);
        lambdaParser.ExpressionContext right = ctxinput.getRuleContext(lambdaParser.ExpressionContext.class, 1);
        this.visit(left);
        this.visit(right);
        return "";
    }

    @Override
    public String visitApplynopareth(lambdaParser.ApplynoparethContext ctx)
    {
        return visitapply(ctx);
    }
    @Override
    public String visitApplywithpareth(lambdaParser.ApplywithparethContext ctx)
    {
        return visitapply(ctx);
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
        List<TerminalNode> varlist = ctx.getTokens(lambdaParser.VARIABLE);
        lambdaParser.ScopeContext scope = ctx.getRuleContext(lambdaParser.ScopeContext.class, 0);
        //访问函数体之前，把参数增加到参数列表，
        for(TerminalNode node : varlist){
            this.argslist += node.getText();
        }
        this.visit(scope);

        // 访问完，跳出函数之后，把该函数的参数信息踢出去
        this.argslist = this.argslist.substring(0, this.argslist.length()-varlist.size());
        return "";
    }

    @Override
    public String visitScope(lambdaParser.ScopeContext ctx)
    {
        return this.visit(ctx.expression());
    }
}
