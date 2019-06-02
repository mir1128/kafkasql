// Generated from KafkaSql.g4 by ANTLR 4.7.2
package com.looboo.kafkasql.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KafkaSqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, NUMBER_LIST=4, CHARS_LIST=5, WS=6, SELECT=7, IN=8, 
		OFFSETS=9, PARTITIONS=10, CONSUMERS=11, CONSUMER_OFFSET=12, ID=13, NUMBER=14, 
		CHARS=15, SPACE=16;
	public static final int
		RULE_selectStatement = 0, RULE_offsetStatement = 1, RULE_partitionsStatement = 2, 
		RULE_consumersStatement = 3, RULE_consumerOffsetStatement = 4, RULE_inCluase = 5, 
		RULE_numberList = 6, RULE_charsList = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"selectStatement", "offsetStatement", "partitionsStatement", "consumersStatement", 
			"consumerOffsetStatement", "inCluase", "numberList", "charsList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'.'", "')'", null, null, null, "'SELECT'", "'IN'", "'OFFSETS'", 
			"'PARTITIONS'", "'CONSUMERS'", "'CONSUMER_OFFSET'", null, null, null, 
			"' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "NUMBER_LIST", "CHARS_LIST", "WS", "SELECT", 
			"IN", "OFFSETS", "PARTITIONS", "CONSUMERS", "CONSUMER_OFFSET", "ID", 
			"NUMBER", "CHARS", "SPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "KafkaSql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KafkaSqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SelectStatementContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(KafkaSqlParser.SELECT, 0); }
		public OffsetStatementContext offsetStatement() {
			return getRuleContext(OffsetStatementContext.class,0);
		}
		public PartitionsStatementContext partitionsStatement() {
			return getRuleContext(PartitionsStatementContext.class,0);
		}
		public ConsumersStatementContext consumersStatement() {
			return getRuleContext(ConsumersStatementContext.class,0);
		}
		public ConsumerOffsetStatementContext consumerOffsetStatement() {
			return getRuleContext(ConsumerOffsetStatementContext.class,0);
		}
		public SelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatement; }
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_selectStatement);
		try {
			setState(24);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				match(SELECT);
				setState(17);
				offsetStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(18);
				match(SELECT);
				setState(19);
				partitionsStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(20);
				match(SELECT);
				setState(21);
				consumersStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(22);
				match(SELECT);
				setState(23);
				consumerOffsetStatement();
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

	public static class OffsetStatementContext extends ParserRuleContext {
		public TerminalNode OFFSETS() { return getToken(KafkaSqlParser.OFFSETS, 0); }
		public TerminalNode ID() { return getToken(KafkaSqlParser.ID, 0); }
		public TerminalNode NUMBER() { return getToken(KafkaSqlParser.NUMBER, 0); }
		public OffsetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offsetStatement; }
	}

	public final OffsetStatementContext offsetStatement() throws RecognitionException {
		OffsetStatementContext _localctx = new OffsetStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_offsetStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(OFFSETS);
			setState(27);
			match(T__0);
			setState(28);
			match(ID);
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(29);
				match(T__1);
				setState(30);
				match(NUMBER);
				}
			}

			setState(33);
			match(T__2);
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

	public static class PartitionsStatementContext extends ParserRuleContext {
		public TerminalNode PARTITIONS() { return getToken(KafkaSqlParser.PARTITIONS, 0); }
		public TerminalNode ID() { return getToken(KafkaSqlParser.ID, 0); }
		public PartitionsStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionsStatement; }
	}

	public final PartitionsStatementContext partitionsStatement() throws RecognitionException {
		PartitionsStatementContext _localctx = new PartitionsStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_partitionsStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(PARTITIONS);
			setState(36);
			match(T__0);
			setState(37);
			match(ID);
			setState(38);
			match(T__2);
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

	public static class ConsumersStatementContext extends ParserRuleContext {
		public TerminalNode CONSUMERS() { return getToken(KafkaSqlParser.CONSUMERS, 0); }
		public TerminalNode ID() { return getToken(KafkaSqlParser.ID, 0); }
		public ConsumersStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_consumersStatement; }
	}

	public final ConsumersStatementContext consumersStatement() throws RecognitionException {
		ConsumersStatementContext _localctx = new ConsumersStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_consumersStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(CONSUMERS);
			setState(41);
			match(T__0);
			setState(42);
			match(ID);
			setState(43);
			match(T__2);
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

	public static class ConsumerOffsetStatementContext extends ParserRuleContext {
		public TerminalNode CONSUMER_OFFSET() { return getToken(KafkaSqlParser.CONSUMER_OFFSET, 0); }
		public TerminalNode ID() { return getToken(KafkaSqlParser.ID, 0); }
		public ConsumerOffsetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_consumerOffsetStatement; }
	}

	public final ConsumerOffsetStatementContext consumerOffsetStatement() throws RecognitionException {
		ConsumerOffsetStatementContext _localctx = new ConsumerOffsetStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_consumerOffsetStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(CONSUMER_OFFSET);
			setState(46);
			match(T__0);
			setState(47);
			match(ID);
			setState(48);
			match(T__2);
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

	public static class InCluaseContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(KafkaSqlParser.ID, 0); }
		public TerminalNode IN() { return getToken(KafkaSqlParser.IN, 0); }
		public TerminalNode NUMBER_LIST() { return getToken(KafkaSqlParser.NUMBER_LIST, 0); }
		public TerminalNode CHARS_LIST() { return getToken(KafkaSqlParser.CHARS_LIST, 0); }
		public InCluaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inCluase; }
	}

	public final InCluaseContext inCluase() throws RecognitionException {
		InCluaseContext _localctx = new InCluaseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_inCluase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(ID);
			setState(51);
			match(IN);
			setState(52);
			match(T__0);
			setState(53);
			_la = _input.LA(1);
			if ( !(_la==NUMBER_LIST || _la==CHARS_LIST) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(54);
			match(T__2);
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

	public static class NumberListContext extends ParserRuleContext {
		public TerminalNode NUMBER_LIST() { return getToken(KafkaSqlParser.NUMBER_LIST, 0); }
		public NumberListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberList; }
	}

	public final NumberListContext numberList() throws RecognitionException {
		NumberListContext _localctx = new NumberListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_numberList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(NUMBER_LIST);
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

	public static class CharsListContext extends ParserRuleContext {
		public TerminalNode CHARS_LIST() { return getToken(KafkaSqlParser.CHARS_LIST, 0); }
		public CharsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_charsList; }
	}

	public final CharsListContext charsList() throws RecognitionException {
		CharsListContext _localctx = new CharsListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_charsList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(CHARS_LIST);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22?\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\5\2\33\n\2\3\3\3\3\3\3\3\3\3\3\5\3\"\n\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\3\3\2\6\7\2:\2\32"+
		"\3\2\2\2\4\34\3\2\2\2\6%\3\2\2\2\b*\3\2\2\2\n/\3\2\2\2\f\64\3\2\2\2\16"+
		":\3\2\2\2\20<\3\2\2\2\22\23\7\t\2\2\23\33\5\4\3\2\24\25\7\t\2\2\25\33"+
		"\5\6\4\2\26\27\7\t\2\2\27\33\5\b\5\2\30\31\7\t\2\2\31\33\5\n\6\2\32\22"+
		"\3\2\2\2\32\24\3\2\2\2\32\26\3\2\2\2\32\30\3\2\2\2\33\3\3\2\2\2\34\35"+
		"\7\13\2\2\35\36\7\3\2\2\36!\7\17\2\2\37 \7\4\2\2 \"\7\20\2\2!\37\3\2\2"+
		"\2!\"\3\2\2\2\"#\3\2\2\2#$\7\5\2\2$\5\3\2\2\2%&\7\f\2\2&\'\7\3\2\2\'("+
		"\7\17\2\2()\7\5\2\2)\7\3\2\2\2*+\7\r\2\2+,\7\3\2\2,-\7\17\2\2-.\7\5\2"+
		"\2.\t\3\2\2\2/\60\7\16\2\2\60\61\7\3\2\2\61\62\7\17\2\2\62\63\7\5\2\2"+
		"\63\13\3\2\2\2\64\65\7\17\2\2\65\66\7\n\2\2\66\67\7\3\2\2\678\t\2\2\2"+
		"89\7\5\2\29\r\3\2\2\2:;\7\6\2\2;\17\3\2\2\2<=\7\7\2\2=\21\3\2\2\2\4\32"+
		"!";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}