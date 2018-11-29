package com.wangdxh;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ctxtofvlist extends lambdaBaseVisitor<Void>
{
    public Map<String, String> ctxtofreedict = new HashMap<>();
    String freelist = "";
    String argslist = "";

    String getFreeVariableslist(ParserRuleContext expr){
        //print 'begin', expr.getText(), self.argslist, self.freelist
        String tempargslist = this.argslist;
        String tempfreelist = this.freelist;

        this.argslist = "";
        this.freelist = "";

        this.visit(expr);

        String result = this.freelist;
        this.argslist = tempargslist;
        this.freelist = tempfreelist;
        //print 'end', expr.getText(), self.argslist, self.freelist
        return result;
    }

    void getthisctxfvlist(ParserRuleContext ctx){

        //if (this.ctxtofreedict.containsKey(ctx) ==  false){
        if (this.ctxtofreedict.containsKey(ctx.toString()) == false){
            // visit 子元素
            this.ctxtofreedict.put(ctx.toString(), "");
            this.ctxtofreedict.put(ctx.toString(), this.getFreeVariableslist(ctx));
            //System.out.println("add to dict:" + ctx + "->" + ctx.getText() + ":"+ this.ctxtofreedict.get(ctx.toString()));
        }
    }


    @Override
    public Void visitExprstat(lambdaParser.ExprstatContext ctx)
    {
        this.visit(ctx.expression());
        return null;
    }

    @Override
    public Void visitFunnoparenth(lambdaParser.FunnoparenthContext ctx)
    {
        this.getthisctxfvlist(ctx);

        //访问函数体之前，把参数增加到参数列表，
        for(TerminalNode node : ctx.VARIABLE()){
            this.argslist += node.getText();
        }
        this.visit(ctx.scope());

        // 访问完，跳出函数之后，把该函数的参数信息踢出去
        this.argslist = this.argslist.substring(0, this.argslist.length()-ctx.VARIABLE().size());

        return null;
    }

    @Override
    public Void visitApplywithpareth(lambdaParser.ApplywithparethContext ctx)
    {
        this.getthisctxfvlist(ctx);
        this.visit(ctx.expression(0));
        this.visit(ctx.expression(1));
        return null;
    }

    @Override
    public Void visitFunwithpareth(lambdaParser.FunwithparethContext ctx)
    {
        this.getthisctxfvlist(ctx);

        //访问函数体之前，把参数增加到参数列表，
        for(TerminalNode node : ctx.VARIABLE()){
            this.argslist += node.getText();
        }
        this.visit(ctx.scope());

        // 访问完，跳出函数之后，把该函数的参数信息踢出去
        this.argslist = this.argslist.substring(0, this.argslist.length()-ctx.VARIABLE().size());
        return null;
    }

    @Override
    public Void visitVarexpr(lambdaParser.VarexprContext ctx)
    {
        this.getthisctxfvlist(ctx);
        String varname = ctx.VARIABLE().getText();

        if (this.argslist.indexOf(varname) == -1 && this.freelist.indexOf(varname) == -1){
            this.freelist += varname;
        }
        return null;
    }

    @Override
    public Void visitApplynopareth(lambdaParser.ApplynoparethContext ctx)
    {
        this.getthisctxfvlist(ctx);
        this.visit(ctx.expression(0));
        this.visit(ctx.expression(1));
        return null;
    }

    @Override
    public Void visitScope(lambdaParser.ScopeContext ctx)
    {
        this.getthisctxfvlist(ctx);
        this.visit(ctx.expression());
        return null;
    }
}
