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
		T__0=1, T__1=2, T__2=3, T__3=4, WS=5, SELECT=6, FROM=7, IN=8, WHERE=9, 
		BETWEEN=10, PARTITION=11, TIMESTAMP=12, OFFSET=13, TOPICS=14, OFFSETS=15, 
		PARTITIONS=16, CONSUMERS=17, CONSUMER_OFFSET=18, COUNT=19, BYTE=20, STR=21, 
		STAR=22, EQUAL=23, SEMICOLON=24, ID=25, SPACE=26, NUMBER=27, CHARS=28;
	public static final int
		RULE_selectStatement = 0, RULE_topicStatement = 1, RULE_offsetStatement = 2, 
		RULE_partitionsStatement = 3, RULE_consumersStatement = 4, RULE_consumerOffsetStatement = 5, 
		RULE_countStatement = 6, RULE_querySpecification = 7, RULE_value = 8, 
		RULE_whereClause = 9, RULE_inCluase = 10, RULE_betweenCluase = 11, RULE_equationClause = 12, 
		RULE_partitionsEquslCluase = 13, RULE_timestampEquslCluase = 14, RULE_valueEqualClause = 15, 
		RULE_byteFunction = 16, RULE_strFunction = 17, RULE_numberList = 18, RULE_charsList = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"selectStatement", "topicStatement", "offsetStatement", "partitionsStatement", 
			"consumersStatement", "consumerOffsetStatement", "countStatement", "querySpecification", 
			"value", "whereClause", "inCluase", "betweenCluase", "equationClause", 
			"partitionsEquslCluase", "timestampEquslCluase", "valueEqualClause", 
			"byteFunction", "strFunction", "numberList", "charsList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'.'", "','", "')'", null, "'SELECT'", "'FROM'", "'IN'", 
			"'WHERE'", "'BETWEEN'", "'PARTITION'", "'TIMESTAMP'", "'OFFSET'", "'TOPICS'", 
			"'OFFSETS'", "'PARTITIONS'", "'CONSUMERS'", "'CONSUMER_OFFSET'", "'COUNT'", 
			"'BYTE'", "'STR'", "'*'", "'='", "';'", null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "WS", "SELECT", "FROM", "IN", "WHERE", 
			"BETWEEN", "PARTITION", "TIMESTAMP", "OFFSET", "TOPICS", "OFFSETS", "PARTITIONS", 
			"CONSUMERS", "CONSUMER_OFFSET", "COUNT", "BYTE", "STR", "STAR", "EQUAL", 
			"SEMICOLON", "ID", "SPACE", "NUMBER", "CHARS"
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
		public TopicStatementContext topicStatement() {
			return getRuleContext(TopicStatementContext.class,0);
		}
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
		public QuerySpecificationContext querySpecification() {
			return getRuleContext(QuerySpecificationContext.class,0);
		}
		public CountStatementContext countStatement() {
			return getRuleContext(CountStatementContext.class,0);
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
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				match(SELECT);
				setState(41);
				topicStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				match(SELECT);
				setState(43);
				offsetStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
				match(SELECT);
				setState(45);
				partitionsStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				match(SELECT);
				setState(47);
				consumersStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(48);
				match(SELECT);
				setState(49);
				consumerOffsetStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(50);
				match(SELECT);
				setState(51);
				querySpecification();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(52);
				match(SELECT);
				setState(53);
				countStatement();
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

	public static class TopicStatementContext extends ParserRuleContext {
		public TerminalNode TOPICS() { return getToken(KafkaSqlParser.TOPICS, 0); }
		public TopicStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topicStatement; }
	}

	public final TopicStatementContext topicStatement() throws RecognitionException {
		TopicStatementContext _localctx = new TopicStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topicStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(TOPICS);
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
		public List<TerminalNode> NUMBER() { return getTokens(KafkaSqlParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(KafkaSqlParser.NUMBER, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(KafkaSqlParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(KafkaSqlParser.SPACE, i);
		}
		public OffsetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offsetStatement; }
	}

	public final OffsetStatementContext offsetStatement() throws RecognitionException {
		OffsetStatementContext _localctx = new OffsetStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_offsetStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(OFFSETS);
			setState(59);
			match(T__0);
			setState(60);
			match(ID);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(61);
				match(T__1);
				setState(62);
				match(NUMBER);
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(63);
					match(T__2);
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACE) {
						{
						{
						setState(64);
						match(SPACE);
						}
						}
						setState(69);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(70);
					match(NUMBER);
					}
					}
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(78);
			match(T__3);
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
		enterRule(_localctx, 6, RULE_partitionsStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(PARTITIONS);
			setState(81);
			match(T__0);
			setState(82);
			match(ID);
			setState(83);
			match(T__3);
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
		public TerminalNode STAR() { return getToken(KafkaSqlParser.STAR, 0); }
		public TerminalNode ID() { return getToken(KafkaSqlParser.ID, 0); }
		public ConsumersStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_consumersStatement; }
	}

	public final ConsumersStatementContext consumersStatement() throws RecognitionException {
		ConsumersStatementContext _localctx = new ConsumersStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_consumersStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(CONSUMERS);
			setState(86);
			match(T__0);
			setState(87);
			_la = _input.LA(1);
			if ( !(_la==STAR || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(88);
			match(T__3);
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
		enterRule(_localctx, 10, RULE_consumerOffsetStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(CONSUMER_OFFSET);
			setState(91);
			match(T__0);
			setState(92);
			match(ID);
			setState(93);
			match(T__3);
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

	public static class CountStatementContext extends ParserRuleContext {
		public TerminalNode COUNT() { return getToken(KafkaSqlParser.COUNT, 0); }
		public TerminalNode ID() { return getToken(KafkaSqlParser.ID, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(KafkaSqlParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(KafkaSqlParser.NUMBER, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(KafkaSqlParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(KafkaSqlParser.SPACE, i);
		}
		public CountStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_countStatement; }
	}

	public final CountStatementContext countStatement() throws RecognitionException {
		CountStatementContext _localctx = new CountStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_countStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(COUNT);
			setState(96);
			match(T__0);
			setState(97);
			match(ID);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(98);
				match(T__1);
				setState(99);
				match(NUMBER);
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(100);
					match(T__2);
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACE) {
						{
						{
						setState(101);
						match(SPACE);
						}
						}
						setState(106);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(107);
					match(NUMBER);
					}
					}
					setState(112);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(115);
			match(T__3);
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

	public static class QuerySpecificationContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(KafkaSqlParser.FROM, 0); }
		public TerminalNode ID() { return getToken(KafkaSqlParser.ID, 0); }
		public TerminalNode STAR() { return getToken(KafkaSqlParser.STAR, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public QuerySpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_querySpecification; }
	}

	public final QuerySpecificationContext querySpecification() throws RecognitionException {
		QuerySpecificationContext _localctx = new QuerySpecificationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_querySpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				{
				setState(117);
				match(STAR);
				}
				break;
			case BYTE:
			case STR:
				{
				setState(118);
				value();
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(119);
					match(T__2);
					setState(120);
					value();
					}
					}
					setState(125);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(128);
			match(FROM);
			setState(129);
			match(ID);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(130);
				whereClause();
				}
			}

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

	public static class ValueContext extends ParserRuleContext {
		public ByteFunctionContext byteFunction() {
			return getRuleContext(ByteFunctionContext.class,0);
		}
		public StrFunctionContext strFunction() {
			return getRuleContext(StrFunctionContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BYTE:
				{
				setState(133);
				byteFunction();
				}
				break;
			case STR:
				{
				setState(134);
				strFunction();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
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

	public static class WhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(KafkaSqlParser.WHERE, 0); }
		public EquationClauseContext equationClause() {
			return getRuleContext(EquationClauseContext.class,0);
		}
		public InCluaseContext inCluase() {
			return getRuleContext(InCluaseContext.class,0);
		}
		public BetweenCluaseContext betweenCluase() {
			return getRuleContext(BetweenCluaseContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(WHERE);
			setState(141);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(138);
				equationClause();
				}
				break;
			case 2:
				{
				setState(139);
				inCluase();
				}
				break;
			case 3:
				{
				setState(140);
				betweenCluase();
				}
				break;
			}
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
		public TerminalNode IN() { return getToken(KafkaSqlParser.IN, 0); }
		public TerminalNode PARTITION() { return getToken(KafkaSqlParser.PARTITION, 0); }
		public TerminalNode TIMESTAMP() { return getToken(KafkaSqlParser.TIMESTAMP, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<TerminalNode> NUMBER() { return getTokens(KafkaSqlParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(KafkaSqlParser.NUMBER, i);
		}
		public List<TerminalNode> CHARS() { return getTokens(KafkaSqlParser.CHARS); }
		public TerminalNode CHARS(int i) {
			return getToken(KafkaSqlParser.CHARS, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(KafkaSqlParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(KafkaSqlParser.SPACE, i);
		}
		public InCluaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inCluase; }
	}

	public final InCluaseContext inCluase() throws RecognitionException {
		InCluaseContext _localctx = new InCluaseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_inCluase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PARTITION:
				{
				setState(143);
				match(PARTITION);
				}
				break;
			case TIMESTAMP:
				{
				setState(144);
				match(TIMESTAMP);
				}
				break;
			case BYTE:
			case STR:
				{
				setState(145);
				value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(148);
			match(IN);
			setState(149);
			match(T__0);
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(150);
				match(NUMBER);
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(151);
					match(T__2);
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACE) {
						{
						{
						setState(152);
						match(SPACE);
						}
						}
						setState(157);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(158);
					match(NUMBER);
					}
					}
					setState(163);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case CHARS:
				{
				setState(164);
				match(CHARS);
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(165);
					match(T__2);
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACE) {
						{
						{
						setState(166);
						match(SPACE);
						}
						}
						setState(171);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(172);
					match(CHARS);
					}
					}
					setState(177);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(180);
			match(T__3);
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

	public static class BetweenCluaseContext extends ParserRuleContext {
		public TerminalNode BETWEEN() { return getToken(KafkaSqlParser.BETWEEN, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(KafkaSqlParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(KafkaSqlParser.NUMBER, i);
		}
		public TerminalNode PARTITION() { return getToken(KafkaSqlParser.PARTITION, 0); }
		public TerminalNode TIMESTAMP() { return getToken(KafkaSqlParser.TIMESTAMP, 0); }
		public BetweenCluaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_betweenCluase; }
	}

	public final BetweenCluaseContext betweenCluase() throws RecognitionException {
		BetweenCluaseContext _localctx = new BetweenCluaseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_betweenCluase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_la = _input.LA(1);
			if ( !(_la==PARTITION || _la==TIMESTAMP) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(183);
			match(BETWEEN);
			setState(184);
			match(T__0);
			setState(185);
			match(NUMBER);
			setState(186);
			match(T__2);
			setState(187);
			match(NUMBER);
			setState(188);
			match(T__3);
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

	public static class EquationClauseContext extends ParserRuleContext {
		public PartitionsEquslCluaseContext partitionsEquslCluase() {
			return getRuleContext(PartitionsEquslCluaseContext.class,0);
		}
		public TimestampEquslCluaseContext timestampEquslCluase() {
			return getRuleContext(TimestampEquslCluaseContext.class,0);
		}
		public ValueEqualClauseContext valueEqualClause() {
			return getRuleContext(ValueEqualClauseContext.class,0);
		}
		public EquationClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equationClause; }
	}

	public final EquationClauseContext equationClause() throws RecognitionException {
		EquationClauseContext _localctx = new EquationClauseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_equationClause);
		try {
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PARTITION:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				partitionsEquslCluase();
				}
				break;
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				timestampEquslCluase();
				}
				break;
			case BYTE:
			case STR:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				valueEqualClause();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class PartitionsEquslCluaseContext extends ParserRuleContext {
		public TerminalNode PARTITION() { return getToken(KafkaSqlParser.PARTITION, 0); }
		public TerminalNode EQUAL() { return getToken(KafkaSqlParser.EQUAL, 0); }
		public TerminalNode NUMBER() { return getToken(KafkaSqlParser.NUMBER, 0); }
		public PartitionsEquslCluaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_partitionsEquslCluase; }
	}

	public final PartitionsEquslCluaseContext partitionsEquslCluase() throws RecognitionException {
		PartitionsEquslCluaseContext _localctx = new PartitionsEquslCluaseContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_partitionsEquslCluase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(PARTITION);
			setState(196);
			match(EQUAL);
			setState(197);
			match(NUMBER);
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

	public static class TimestampEquslCluaseContext extends ParserRuleContext {
		public TerminalNode TIMESTAMP() { return getToken(KafkaSqlParser.TIMESTAMP, 0); }
		public TerminalNode EQUAL() { return getToken(KafkaSqlParser.EQUAL, 0); }
		public TerminalNode NUMBER() { return getToken(KafkaSqlParser.NUMBER, 0); }
		public TimestampEquslCluaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_timestampEquslCluase; }
	}

	public final TimestampEquslCluaseContext timestampEquslCluase() throws RecognitionException {
		TimestampEquslCluaseContext _localctx = new TimestampEquslCluaseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_timestampEquslCluase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(TIMESTAMP);
			setState(200);
			match(EQUAL);
			setState(201);
			match(NUMBER);
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

	public static class ValueEqualClauseContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(KafkaSqlParser.EQUAL, 0); }
		public TerminalNode CHARS() { return getToken(KafkaSqlParser.CHARS, 0); }
		public TerminalNode NUMBER() { return getToken(KafkaSqlParser.NUMBER, 0); }
		public ValueEqualClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueEqualClause; }
	}

	public final ValueEqualClauseContext valueEqualClause() throws RecognitionException {
		ValueEqualClauseContext _localctx = new ValueEqualClauseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_valueEqualClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			value();
			setState(204);
			match(EQUAL);
			setState(205);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==CHARS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class ByteFunctionContext extends ParserRuleContext {
		public TerminalNode BYTE() { return getToken(KafkaSqlParser.BYTE, 0); }
		public TerminalNode ID() { return getToken(KafkaSqlParser.ID, 0); }
		public ByteFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_byteFunction; }
	}

	public final ByteFunctionContext byteFunction() throws RecognitionException {
		ByteFunctionContext _localctx = new ByteFunctionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_byteFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(BYTE);
			setState(208);
			match(T__0);
			setState(209);
			match(ID);
			setState(210);
			match(T__3);
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

	public static class StrFunctionContext extends ParserRuleContext {
		public TerminalNode STR() { return getToken(KafkaSqlParser.STR, 0); }
		public TerminalNode ID() { return getToken(KafkaSqlParser.ID, 0); }
		public StrFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strFunction; }
	}

	public final StrFunctionContext strFunction() throws RecognitionException {
		StrFunctionContext _localctx = new StrFunctionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_strFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(STR);
			setState(213);
			match(T__0);
			setState(214);
			match(ID);
			setState(215);
			match(T__3);
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
		public List<TerminalNode> NUMBER() { return getTokens(KafkaSqlParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(KafkaSqlParser.NUMBER, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(KafkaSqlParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(KafkaSqlParser.SPACE, i);
		}
		public NumberListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberList; }
	}

	public final NumberListContext numberList() throws RecognitionException {
		NumberListContext _localctx = new NumberListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_numberList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(NUMBER);
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(218);
				match(T__2);
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(219);
					match(SPACE);
					}
					}
					setState(224);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(225);
				match(NUMBER);
				}
				}
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		public List<TerminalNode> CHARS() { return getTokens(KafkaSqlParser.CHARS); }
		public TerminalNode CHARS(int i) {
			return getToken(KafkaSqlParser.CHARS, i);
		}
		public List<TerminalNode> SPACE() { return getTokens(KafkaSqlParser.SPACE); }
		public TerminalNode SPACE(int i) {
			return getToken(KafkaSqlParser.SPACE, i);
		}
		public CharsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_charsList; }
	}

	public final CharsListContext charsList() throws RecognitionException {
		CharsListContext _localctx = new CharsListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_charsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(CHARS);
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(232);
				match(T__2);
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(233);
					match(SPACE);
					}
					}
					setState(238);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(239);
				match(CHARS);
				}
				}
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00f8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\5\29\n\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4D\n\4"+
		"\f\4\16\4G\13\4\3\4\7\4J\n\4\f\4\16\4M\13\4\5\4O\n\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\7\bi\n\b\f\b\16\bl\13\b\3\b\7\bo\n\b\f\b\16\br\13\b\5\bt\n\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\7\t|\n\t\f\t\16\t\177\13\t\5\t\u0081\n\t\3\t"+
		"\3\t\3\t\5\t\u0086\n\t\3\n\3\n\5\n\u008a\n\n\3\13\3\13\3\13\3\13\5\13"+
		"\u0090\n\13\3\f\3\f\3\f\5\f\u0095\n\f\3\f\3\f\3\f\3\f\3\f\7\f\u009c\n"+
		"\f\f\f\16\f\u009f\13\f\3\f\7\f\u00a2\n\f\f\f\16\f\u00a5\13\f\3\f\3\f\3"+
		"\f\7\f\u00aa\n\f\f\f\16\f\u00ad\13\f\3\f\7\f\u00b0\n\f\f\f\16\f\u00b3"+
		"\13\f\5\f\u00b5\n\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\5\16\u00c4\n\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\7\24\u00df\n\24\f\24\16\24\u00e2\13\24\3\24\7\24\u00e5\n\24\f\24"+
		"\16\24\u00e8\13\24\3\25\3\25\3\25\7\25\u00ed\n\25\f\25\16\25\u00f0\13"+
		"\25\3\25\7\25\u00f3\n\25\f\25\16\25\u00f6\13\25\3\25\2\2\26\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(\2\5\4\2\30\30\33\33\3\2\r\16\3\2\35"+
		"\36\2\u0102\28\3\2\2\2\4:\3\2\2\2\6<\3\2\2\2\bR\3\2\2\2\nW\3\2\2\2\f\\"+
		"\3\2\2\2\16a\3\2\2\2\20\u0080\3\2\2\2\22\u0089\3\2\2\2\24\u008b\3\2\2"+
		"\2\26\u0094\3\2\2\2\30\u00b8\3\2\2\2\32\u00c3\3\2\2\2\34\u00c5\3\2\2\2"+
		"\36\u00c9\3\2\2\2 \u00cd\3\2\2\2\"\u00d1\3\2\2\2$\u00d6\3\2\2\2&\u00db"+
		"\3\2\2\2(\u00e9\3\2\2\2*+\7\b\2\2+9\5\4\3\2,-\7\b\2\2-9\5\6\4\2./\7\b"+
		"\2\2/9\5\b\5\2\60\61\7\b\2\2\619\5\n\6\2\62\63\7\b\2\2\639\5\f\7\2\64"+
		"\65\7\b\2\2\659\5\20\t\2\66\67\7\b\2\2\679\5\16\b\28*\3\2\2\28,\3\2\2"+
		"\28.\3\2\2\28\60\3\2\2\28\62\3\2\2\28\64\3\2\2\28\66\3\2\2\29\3\3\2\2"+
		"\2:;\7\20\2\2;\5\3\2\2\2<=\7\21\2\2=>\7\3\2\2>N\7\33\2\2?@\7\4\2\2@K\7"+
		"\35\2\2AE\7\5\2\2BD\7\34\2\2CB\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F"+
		"H\3\2\2\2GE\3\2\2\2HJ\7\35\2\2IA\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2"+
		"LO\3\2\2\2MK\3\2\2\2N?\3\2\2\2NO\3\2\2\2OP\3\2\2\2PQ\7\6\2\2Q\7\3\2\2"+
		"\2RS\7\22\2\2ST\7\3\2\2TU\7\33\2\2UV\7\6\2\2V\t\3\2\2\2WX\7\23\2\2XY\7"+
		"\3\2\2YZ\t\2\2\2Z[\7\6\2\2[\13\3\2\2\2\\]\7\24\2\2]^\7\3\2\2^_\7\33\2"+
		"\2_`\7\6\2\2`\r\3\2\2\2ab\7\25\2\2bc\7\3\2\2cs\7\33\2\2de\7\4\2\2ep\7"+
		"\35\2\2fj\7\5\2\2gi\7\34\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k"+
		"m\3\2\2\2lj\3\2\2\2mo\7\35\2\2nf\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2"+
		"qt\3\2\2\2rp\3\2\2\2sd\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\7\6\2\2v\17\3\2\2"+
		"\2w\u0081\7\30\2\2x}\5\22\n\2yz\7\5\2\2z|\5\22\n\2{y\3\2\2\2|\177\3\2"+
		"\2\2}{\3\2\2\2}~\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\u0080w\3\2\2\2\u0080"+
		"x\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\7\t\2\2\u0083\u0085\7\33\2\2"+
		"\u0084\u0086\5\24\13\2\u0085\u0084\3\2\2\2\u0085\u0086\3\2\2\2\u0086\21"+
		"\3\2\2\2\u0087\u008a\5\"\22\2\u0088\u008a\5$\23\2\u0089\u0087\3\2\2\2"+
		"\u0089\u0088\3\2\2\2\u008a\23\3\2\2\2\u008b\u008f\7\13\2\2\u008c\u0090"+
		"\5\32\16\2\u008d\u0090\5\26\f\2\u008e\u0090\5\30\r\2\u008f\u008c\3\2\2"+
		"\2\u008f\u008d\3\2\2\2\u008f\u008e\3\2\2\2\u0090\25\3\2\2\2\u0091\u0095"+
		"\7\r\2\2\u0092\u0095\7\16\2\2\u0093\u0095\5\22\n\2\u0094\u0091\3\2\2\2"+
		"\u0094\u0092\3\2\2\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097"+
		"\7\n\2\2\u0097\u00b4\7\3\2\2\u0098\u00a3\7\35\2\2\u0099\u009d\7\5\2\2"+
		"\u009a\u009c\7\34\2\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0"+
		"\u00a2\7\35\2\2\u00a1\u0099\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3"+
		"\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00b5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6"+
		"\u00b1\7\36\2\2\u00a7\u00ab\7\5\2\2\u00a8\u00aa\7\34\2\2\u00a9\u00a8\3"+
		"\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b0\7\36\2\2\u00af\u00a7\3"+
		"\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u0098\3\2\2\2\u00b4\u00a6\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\7\6\2\2\u00b7\27\3\2\2\2\u00b8\u00b9"+
		"\t\3\2\2\u00b9\u00ba\7\f\2\2\u00ba\u00bb\7\3\2\2\u00bb\u00bc\7\35\2\2"+
		"\u00bc\u00bd\7\5\2\2\u00bd\u00be\7\35\2\2\u00be\u00bf\7\6\2\2\u00bf\31"+
		"\3\2\2\2\u00c0\u00c4\5\34\17\2\u00c1\u00c4\5\36\20\2\u00c2\u00c4\5 \21"+
		"\2\u00c3\u00c0\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\33"+
		"\3\2\2\2\u00c5\u00c6\7\r\2\2\u00c6\u00c7\7\31\2\2\u00c7\u00c8\7\35\2\2"+
		"\u00c8\35\3\2\2\2\u00c9\u00ca\7\16\2\2\u00ca\u00cb\7\31\2\2\u00cb\u00cc"+
		"\7\35\2\2\u00cc\37\3\2\2\2\u00cd\u00ce\5\22\n\2\u00ce\u00cf\7\31\2\2\u00cf"+
		"\u00d0\t\4\2\2\u00d0!\3\2\2\2\u00d1\u00d2\7\26\2\2\u00d2\u00d3\7\3\2\2"+
		"\u00d3\u00d4\7\33\2\2\u00d4\u00d5\7\6\2\2\u00d5#\3\2\2\2\u00d6\u00d7\7"+
		"\27\2\2\u00d7\u00d8\7\3\2\2\u00d8\u00d9\7\33\2\2\u00d9\u00da\7\6\2\2\u00da"+
		"%\3\2\2\2\u00db\u00e6\7\35\2\2\u00dc\u00e0\7\5\2\2\u00dd\u00df\7\34\2"+
		"\2\u00de\u00dd\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1"+
		"\3\2\2\2\u00e1\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e5\7\35\2\2"+
		"\u00e4\u00dc\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7"+
		"\3\2\2\2\u00e7\'\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00f4\7\36\2\2\u00ea"+
		"\u00ee\7\5\2\2\u00eb\u00ed\7\34\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3"+
		"\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0"+
		"\u00ee\3\2\2\2\u00f1\u00f3\7\36\2\2\u00f2\u00ea\3\2\2\2\u00f3\u00f6\3"+
		"\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5)\3\2\2\2\u00f6\u00f4"+
		"\3\2\2\2\318EKNjps}\u0080\u0085\u0089\u008f\u0094\u009d\u00a3\u00ab\u00b1"+
		"\u00b4\u00c3\u00e0\u00e6\u00ee\u00f4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}