// Generated from lambda.g4 by ANTLR 4.7.1
package com.wangdxh;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link lambdaParser}.
 */
public interface lambdaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link lambdaParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(lambdaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link lambdaParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(lambdaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code definestat}
	 * labeled alternative in {@link lambdaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDefinestat(lambdaParser.DefinestatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code definestat}
	 * labeled alternative in {@link lambdaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDefinestat(lambdaParser.DefinestatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code substat}
	 * labeled alternative in {@link lambdaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterSubstat(lambdaParser.SubstatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code substat}
	 * labeled alternative in {@link lambdaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitSubstat(lambdaParser.SubstatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprstat}
	 * labeled alternative in {@link lambdaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterExprstat(lambdaParser.ExprstatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprstat}
	 * labeled alternative in {@link lambdaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitExprstat(lambdaParser.ExprstatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blankstat}
	 * labeled alternative in {@link lambdaParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlankstat(lambdaParser.BlankstatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blankstat}
	 * labeled alternative in {@link lambdaParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlankstat(lambdaParser.BlankstatContext ctx);
	/**
	 * Enter a parse tree produced by {@link lambdaParser#define}.
	 * @param ctx the parse tree
	 */
	void enterDefine(lambdaParser.DefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link lambdaParser#define}.
	 * @param ctx the parse tree
	 */
	void exitDefine(lambdaParser.DefineContext ctx);
	/**
	 * Enter a parse tree produced by {@link lambdaParser#substitution}.
	 * @param ctx the parse tree
	 */
	void enterSubstitution(lambdaParser.SubstitutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link lambdaParser#substitution}.
	 * @param ctx the parse tree
	 */
	void exitSubstitution(lambdaParser.SubstitutionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funnoparenth}
	 * labeled alternative in {@link lambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunnoparenth(lambdaParser.FunnoparenthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funnoparenth}
	 * labeled alternative in {@link lambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunnoparenth(lambdaParser.FunnoparenthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code applywithpareth}
	 * labeled alternative in {@link lambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterApplywithpareth(lambdaParser.ApplywithparethContext ctx);
	/**
	 * Exit a parse tree produced by the {@code applywithpareth}
	 * labeled alternative in {@link lambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitApplywithpareth(lambdaParser.ApplywithparethContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funwithpareth}
	 * labeled alternative in {@link lambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFunwithpareth(lambdaParser.FunwithparethContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funwithpareth}
	 * labeled alternative in {@link lambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFunwithpareth(lambdaParser.FunwithparethContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varexpr}
	 * labeled alternative in {@link lambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVarexpr(lambdaParser.VarexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varexpr}
	 * labeled alternative in {@link lambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVarexpr(lambdaParser.VarexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code applynopareth}
	 * labeled alternative in {@link lambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterApplynopareth(lambdaParser.ApplynoparethContext ctx);
	/**
	 * Exit a parse tree produced by the {@code applynopareth}
	 * labeled alternative in {@link lambdaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitApplynopareth(lambdaParser.ApplynoparethContext ctx);
	/**
	 * Enter a parse tree produced by {@link lambdaParser#scope}.
	 * @param ctx the parse tree
	 */
	void enterScope(lambdaParser.ScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link lambdaParser#scope}.
	 * @param ctx the parse tree
	 */
	void exitScope(lambdaParser.ScopeContext ctx);
}