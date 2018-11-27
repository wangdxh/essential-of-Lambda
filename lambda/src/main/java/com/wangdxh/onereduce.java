package com.wangdxh;

public class onereduce extends lambdaBaseVisitor<String>
{
    String strletter;
    char m_lastnewvar = 'a';
    private char newVar()
    {
        for(char i = m_lastnewvar; i < 'z'; i++){
            if (-1 == strletter.indexOf(i)){
                m_lastnewvar = i;
                return i;
            }
        }
        return 'λ';
    }

    @Override
    public String visitExprstat(lambdaParser.ExprstatContext ctx)
    {
        this.strletter = ctx.getText();
        return this.visit(ctx.expression());
    }

    @Override
    public String visitFunnoparenth(lambdaParser.FunnoparenthContext ctx)
    {
        return super.visitFunnoparenth(ctx);
    }

    @Override
    public String visitApplywithpareth(lambdaParser.ApplywithparethContext ctx)
    {
        return super.visitApplywithpareth(ctx);
    }

    @Override
    public String visitFunwithpareth(lambdaParser.FunwithparethContext ctx)
    {
        return super.visitFunwithpareth(ctx);
    }

    @Override
    public String visitVarexpr(lambdaParser.VarexprContext ctx)
    {
        return super.visitVarexpr(ctx);
    }

    @Override
    public String visitApplynopareth(lambdaParser.ApplynoparethContext ctx)
    {
        return super.visitApplynopareth(ctx);
    }

    @Override
    public String visitScope(lambdaParser.ScopeContext ctx)
    {
        return this.visit(ctx.expression());
    }
}
