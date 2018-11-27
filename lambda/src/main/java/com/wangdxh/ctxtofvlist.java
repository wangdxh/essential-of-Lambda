package com.wangdxh;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ctxtofvlist extends lambdaBaseVisitor<Void>
{
    public Map<ParserRuleContext, List<Character>> ctxtofreedict = new HashMap<>();
    List<Character> argslist = new ArrayList<>();
    List<Character> freelist = new ArrayList<>();

    List<Character> getFreeVariableslist(ParserRuleContext expr){
        //print 'begin', expr.getText(), self.argslist, self.freelist
        List<Character> tempargslist = this.argslist;
        List<Character> tempfreelist = this.freelist;

        this.argslist = new ArrayList<>();
        this.freelist = new ArrayList<>();

        this.visit(expr);

        List<Character> result = this.freelist;
        this.argslist = tempargslist;
        this.freelist = tempfreelist;

        //print 'end', expr.getText(), self.argslist, self.freelist
        return result;
    }

    void getthisctxfvlist(ParserRuleContext ctx){
        if (this.ctxtofreedict.containsKey(ctx) ==  false){
            //# visit 子元素
            this.ctxtofreedict.put(ctx, null);
            this.ctxtofreedict.put(ctx, this.getFreeVariableslist(ctx));
            System.out.print("add to dict:" + ctx.getText() + ":"+ this.ctxtofreedict.get(ctx));
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
        self.getthisctxfvlist(ctx)

        # 访问函数体之前，把参数增加到参数列表，
        for item in ctx.VARIABLE():
        self.argslist.append(item.getText())

        self.visit(ctx.scope())

        # 访问完，跳出函数之后，把该函数的参数信息踢出去
        # pop 应该按照变量的反序来遍历，结果一致就行
        for item in ctx.VARIABLE():
        self.argslist.pop()

        return null;
    }

    @Override
    public Void visitApplywithpareth(lambdaParser.ApplywithparethContext ctx)
    {
        self.getthisctxfvlist(ctx);
        self.visit(ctx.expression(0));
        self.visit(ctx.expression(1));
        return null;
    }

    @Override
    public Void visitFunwithpareth(lambdaParser.FunwithparethContext ctx)
    {
        this.getthisctxfvlist(ctx);

        // 访问函数体之前，把参数增加到参数列表，
        for (TerminalNode item : ctx.VARIABLE()){
            this.argslist.add(item.getText());
        }
        this.visit(ctx.scope());

        //访问完，跳出函数之后，把该函数的参数信息踢出去
        // pop 应该按照变量的反序来遍历，结果一致就行
        for (TerminalNode item : ctx.VARIABLE()){
            this.argslist.remove(this.argslist.size()-1);
        }

        return null;
    }

    @Override
    public Void visitVarexpr(lambdaParser.VarexprContext ctx)
    {
        self.getthisctxfvlist(ctx);
        varname = ctx.VARIABLE().getText()
        if (varname in self.argslist) is False and (varname in self.freelist) is False:
            self.freelist.append(varname)
        return null;
    }

    @Override
    public Void visitApplynopareth(lambdaParser.ApplynoparethContext ctx)
    {
        self.getthisctxfvlist(ctx);
        self.visit(ctx.expression(0));
        self.visit(ctx.expression(1));
        return null;
    }

    @Override
    public Void visitScope(lambdaParser.ScopeContext ctx)
    {
        self.getthisctxfvlist(ctx);

        self.visit(ctx.expression());
        return null;
    }
}
