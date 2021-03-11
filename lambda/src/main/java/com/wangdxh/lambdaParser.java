// Generated from ./lambda.g4 by ANTLR 4.7.1
package com.wangdxh;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lambdaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, VARIABLE=9, 
		NEWLINE=10, WS=11;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_define = 2, RULE_substitution = 3, 
		RULE_expression = 4, RULE_scope = 5;
	public static final String[] ruleNames = {
		"program", "stat", "define", "substitution", "expression", "scope"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'['", "'/'", "']'", "'^'", "'.'", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "VARIABLE", "NEWLINE", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "lambda.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public lambdaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lambdaVisitor ) return ((lambdaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12);
				stat();
				}
				}
				setState(15); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__4) | (1L << T__6) | (1L << VARIABLE) | (1L << NEWLINE))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprstatContext extends StatContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(lambdaParser.NEWLINE, 0); }
		public ExprstatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).enterExprstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).exitExprstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lambdaVisitor ) return ((lambdaVisitor<? extends T>)visitor).visitExprstat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlankstatContext extends StatContext {
		public TerminalNode NEWLINE() { return getToken(lambdaParser.NEWLINE, 0); }
		public BlankstatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).enterBlankstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).exitBlankstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lambdaVisitor ) return ((lambdaVisitor<? extends T>)visitor).visitBlankstat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubstatContext extends StatContext {
		public SubstitutionContext substitution() {
			return getRuleContext(SubstitutionContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(lambdaParser.NEWLINE, 0); }
		public SubstatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).enterSubstat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).exitSubstat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lambdaVisitor ) return ((lambdaVisitor<? extends T>)visitor).visitSubstat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefinestatContext extends StatContext {
		public DefineContext define() {
			return getRuleContext(DefineContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(lambdaParser.NEWLINE, 0); }
		public DefinestatContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).enterDefinestat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).exitDefinestat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lambdaVisitor ) return ((lambdaVisitor<? extends T>)visitor).visitDefinestat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		try {
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new DefinestatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				define();
				setState(19);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(18);
					match(NEWLINE);
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new SubstatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
				substitution();
				setState(23);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(22);
					match(NEWLINE);
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new ExprstatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(25);
				expression(0);
				setState(27);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(26);
					match(NEWLINE);
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new BlankstatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(29);
				match(NEWLINE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefineContext extends ParserRuleContext {
		public TerminalNode VARIABLE() { return getToken(lambdaParser.VARIABLE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).enterDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).exitDefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lambdaVisitor ) return ((lambdaVisitor<? extends T>)visitor).visitDefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefineContext define() throws RecognitionException {
		DefineContext _localctx = new DefineContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_define);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(VARIABLE);
			setState(33);
			match(T__0);
			setState(34);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubstitutionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> VARIABLE() { return getTokens(lambdaParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(lambdaParser.VARIABLE, i);
		}
		public SubstitutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_substitution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).enterSubstitution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).exitSubstitution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lambdaVisitor ) return ((lambdaVisitor<? extends T>)visitor).visitSubstitution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubstitutionContext substitution() throws RecognitionException {
		SubstitutionContext _localctx = new SubstitutionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_substitution);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(36);
				match(T__1);
				setState(37);
				expression(0);
				setState(38);
				match(T__2);
				setState(39);
				match(VARIABLE);
				setState(40);
				match(T__3);
				}
				}
				setState(44); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__1 );
			setState(46);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FunnoparenthContext extends ExpressionContext {
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public List<TerminalNode> VARIABLE() { return getTokens(lambdaParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(lambdaParser.VARIABLE, i);
		}
		public FunnoparenthContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).enterFunnoparenth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).exitFunnoparenth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lambdaVisitor ) return ((lambdaVisitor<? extends T>)visitor).visitFunnoparenth(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ApplywithparethContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ApplywithparethContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).enterApplywithpareth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).exitApplywithpareth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lambdaVisitor ) return ((lambdaVisitor<? extends T>)visitor).visitApplywithpareth(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunwithparethContext extends ExpressionContext {
		public ScopeContext scope() {
			return getRuleContext(ScopeContext.class,0);
		}
		public List<TerminalNode> VARIABLE() { return getTokens(lambdaParser.VARIABLE); }
		public TerminalNode VARIABLE(int i) {
			return getToken(lambdaParser.VARIABLE, i);
		}
		public FunwithparethContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).enterFunwithpareth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).exitFunwithpareth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lambdaVisitor ) return ((lambdaVisitor<? extends T>)visitor).visitFunwithpareth(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarexprContext extends ExpressionContext {
		public TerminalNode VARIABLE() { return getToken(lambdaParser.VARIABLE, 0); }
		public VarexprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).enterVarexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).exitVarexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lambdaVisitor ) return ((lambdaVisitor<? extends T>)visitor).visitVarexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ApplynoparethContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ApplynoparethContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).enterApplynopareth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).exitApplynopareth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lambdaVisitor ) return ((lambdaVisitor<? extends T>)visitor).visitApplynopareth(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new FunnoparenthContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(49);
				match(T__4);
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(50);
					match(VARIABLE);
					}
					}
					setState(53); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VARIABLE );
				setState(55);
				match(T__5);
				setState(56);
				scope();
				}
				break;
			case 2:
				{
				_localctx = new FunwithparethContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(57);
				match(T__6);
				setState(58);
				match(T__4);
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(59);
					match(VARIABLE);
					}
					}
					setState(62); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==VARIABLE );
				setState(64);
				match(T__5);
				setState(65);
				scope();
				setState(66);
				match(T__7);
				}
				break;
			case 3:
				{
				_localctx = new VarexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				match(VARIABLE);
				}
				break;
			case 4:
				{
				_localctx = new ApplywithparethContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				match(T__6);
				setState(70);
				expression(0);
				setState(71);
				expression(0);
				setState(72);
				match(T__7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(80);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ApplynoparethContext(new ExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(76);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(77);
					expression(2);
					}
					} 
				}
				setState(82);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ScopeContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).enterScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lambdaListener ) ((lambdaListener)listener).exitScope(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lambdaVisitor ) return ((lambdaVisitor<? extends T>)visitor).visitScope(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopeContext scope() throws RecognitionException {
		ScopeContext _localctx = new ScopeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_scope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\rX\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\20\n\2\r\2\16\2\21\3\3\3\3"+
		"\5\3\26\n\3\3\3\3\3\5\3\32\n\3\3\3\3\3\5\3\36\n\3\3\3\5\3!\n\3\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\6\5-\n\5\r\5\16\5.\3\5\3\5\3\6\3\6\3"+
		"\6\6\6\66\n\6\r\6\16\6\67\3\6\3\6\3\6\3\6\3\6\6\6?\n\6\r\6\16\6@\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6M\n\6\3\6\3\6\7\6Q\n\6\f\6\16\6"+
		"T\13\6\3\7\3\7\3\7\2\3\n\b\2\4\6\b\n\f\2\2\2_\2\17\3\2\2\2\4 \3\2\2\2"+
		"\6\"\3\2\2\2\b,\3\2\2\2\nL\3\2\2\2\fU\3\2\2\2\16\20\5\4\3\2\17\16\3\2"+
		"\2\2\20\21\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2\23\25\5\6"+
		"\4\2\24\26\7\f\2\2\25\24\3\2\2\2\25\26\3\2\2\2\26!\3\2\2\2\27\31\5\b\5"+
		"\2\30\32\7\f\2\2\31\30\3\2\2\2\31\32\3\2\2\2\32!\3\2\2\2\33\35\5\n\6\2"+
		"\34\36\7\f\2\2\35\34\3\2\2\2\35\36\3\2\2\2\36!\3\2\2\2\37!\7\f\2\2 \23"+
		"\3\2\2\2 \27\3\2\2\2 \33\3\2\2\2 \37\3\2\2\2!\5\3\2\2\2\"#\7\13\2\2#$"+
		"\7\3\2\2$%\5\n\6\2%\7\3\2\2\2&\'\7\4\2\2\'(\5\n\6\2()\7\5\2\2)*\7\13\2"+
		"\2*+\7\6\2\2+-\3\2\2\2,&\3\2\2\2-.\3\2\2\2.,\3\2\2\2./\3\2\2\2/\60\3\2"+
		"\2\2\60\61\5\n\6\2\61\t\3\2\2\2\62\63\b\6\1\2\63\65\7\7\2\2\64\66\7\13"+
		"\2\2\65\64\3\2\2\2\66\67\3\2\2\2\67\65\3\2\2\2\678\3\2\2\289\3\2\2\29"+
		":\7\b\2\2:M\5\f\7\2;<\7\t\2\2<>\7\7\2\2=?\7\13\2\2>=\3\2\2\2?@\3\2\2\2"+
		"@>\3\2\2\2@A\3\2\2\2AB\3\2\2\2BC\7\b\2\2CD\5\f\7\2DE\7\n\2\2EM\3\2\2\2"+
		"FM\7\13\2\2GH\7\t\2\2HI\5\n\6\2IJ\5\n\6\2JK\7\n\2\2KM\3\2\2\2L\62\3\2"+
		"\2\2L;\3\2\2\2LF\3\2\2\2LG\3\2\2\2MR\3\2\2\2NO\f\3\2\2OQ\5\n\6\4PN\3\2"+
		"\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\13\3\2\2\2TR\3\2\2\2UV\5\n\6\2V\r"+
		"\3\2\2\2\f\21\25\31\35 .\67@LR";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}