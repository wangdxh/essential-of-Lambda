// Generated from ./lambda.g4 by ANTLR 4.7.1
package com.wangdxh;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link lambdaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface lambdaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link lambdaParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(lambdaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code definestat}
	 * labeled alternative in {@link lambdaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinestat(lambdaParser.DefinestatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code substat}
	 * labeled alternative in {@link lambdaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstat(lambdaParser.SubstatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprstat}
	 * labeled alternative in {@link lambdaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprstat(lambdaParser.ExprstatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blankstat}
	 * labeled alternative in {@link lambdaParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlankstat(lambdaParser.BlankstatContext ctx);
	/**
	 * Visit a parse tree produced by {@link lambdaParser#define}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefine(lambdaParser.DefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link lambdaParser#substitution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstitution(lambdaParser.SubstitutionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funnoparenth}
	 * labeled alternative in {@link lambdaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunnoparenth(lambdaParser.FunnoparenthContext ctx);
	/**
	 * Visit a parse tree produced by the {@code applywithpareth}
	 * labeled alternative in {@link lambdaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplywithpareth(lambdaParser.ApplywithparethContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funwithpareth}
	 * labeled alternative in {@link lambdaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunwithpareth(lambdaParser.FunwithparethContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varexpr}
	 * labeled alternative in {@link lambdaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarexpr(lambdaParser.VarexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code applynopareth}
	 * labeled alternative in {@link lambdaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplynopareth(lambdaParser.ApplynoparethContext ctx);
	/**
	 * Visit a parse tree produced by {@link lambdaParser#scope}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScope(lambdaParser.ScopeContext ctx);
}