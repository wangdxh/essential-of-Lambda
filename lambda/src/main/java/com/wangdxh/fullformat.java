package com.wangdxh;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class fullformat extends lambdaBaseVisitor<String>
{
    @Override
    public String visitProgram(lambdaParser.ProgramContext ctx)
    {
        return super.visitProgram(ctx);
    }

    @Override
    public String visitExprstat(lambdaParser.ExprstatContext ctx)
    {
        //return super.visitExprstat(ctx);
        String strret = this.visit(ctx.expression());
        System.out.println(ctx.getText() + "  ->  " + strret);
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
        return ctx.VARIABLE().getText();
    }


    private  String visitapply(ParserRuleContext ctxinput)
    {
        lambdaParser.ExpressionContext left = ctxinput.getRuleContext(lambdaParser.ExpressionContext.class, 0);
        lambdaParser.ExpressionContext right = ctxinput.getRuleContext(lambdaParser.ExpressionContext.class, 1);
        return '(' + this.visit(left) + this.visit(right) + ')';
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
        StringBuilder build = new StringBuilder();
        for(TerminalNode a : varlist)
        {
            build.append("(^").append(a.getText()).append(".");
        }

        build.append(this.visit(scope));

        for(TerminalNode a : varlist)
        {
            build.append(")");
        }
        return build.toString();
    }

    @Override
    public String visitScope(lambdaParser.ScopeContext ctx)
    {
        return this.visit(ctx.expression());
    }
}
