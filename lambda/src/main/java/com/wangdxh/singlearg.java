package com.wangdxh;

import org.antlr.v4.runtime.tree.TerminalNode;

public class singlearg extends lambdaBaseVisitor<String>
{
    @Override
    public String visitProgram(lambdaParser.ProgramContext ctx)
    {
        return super.visitProgram(ctx);
    }

    @Override
    public String visitDefinestat(lambdaParser.DefinestatContext ctx)
    {
        return super.visitDefinestat(ctx);
    }

    @Override
    public String visitSubstat(lambdaParser.SubstatContext ctx)
    {
        return super.visitSubstat(ctx);
    }

    @Override
    public String visitExprstat(lambdaParser.ExprstatContext ctx)
    {
        String strret = this.visit(ctx.expression());
        //System.out.println(ctx.getText() + " : " + strret);
        return strret;
    }

    @Override
    public String visitBlankstat(lambdaParser.BlankstatContext ctx)
    {
        return super.visitBlankstat(ctx);
    }

    @Override
    public String visitDefine(lambdaParser.DefineContext ctx)
    {
        return super.visitDefine(ctx);
    }

    @Override
    public String visitSubstitution(lambdaParser.SubstitutionContext ctx)
    {
        return super.visitSubstitution(ctx);
    }

    @Override
    public String visitApplywithpareth(lambdaParser.ApplywithparethContext ctx)
    {
        return '(' + this.visit(ctx.expression(0)) + this.visit(ctx.expression(1)) + ')';
    }

    @Override
    public String visitVarexpr(lambdaParser.VarexprContext ctx)
    {
        return ctx.VARIABLE().getText();
    }

    @Override
    public String visitApplynopareth(lambdaParser.ApplynoparethContext ctx)
    {
        return this.visit(ctx.expression(0)) + this.visit(ctx.expression(1));
    }

    @Override
    public String visitFunnoparenth(lambdaParser.FunnoparenthContext ctx)
    {
        StringBuilder build = new StringBuilder();
        for(TerminalNode a : ctx.VARIABLE())
        {
            build.append("(^").append(a.getText()).append(".");
        }

        build.append(this.visit(ctx.scope()));

        for(TerminalNode a : ctx.VARIABLE())
        {
            build.append(")");
        }
        return build.toString();
    }

    @Override
    public String visitFunwithpareth(lambdaParser.FunwithparethContext ctx)
    {
        StringBuilder build = new StringBuilder();
        for(TerminalNode a : ctx.VARIABLE())
        {
            build.append("(^").append(a.getText()).append(".");
        }

        build.append(this.visit(ctx.scope()));

        for(TerminalNode a : ctx.VARIABLE())
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
