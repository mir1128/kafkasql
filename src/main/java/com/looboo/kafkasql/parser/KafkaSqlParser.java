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
		PARTITIONS=16, CONSUMERS=17, CONSUMER_OFFSET=18, BYTE=19, JSON=20, STR=21, 
		STAR=22, EQUAL=23, SEMICOLON=24, ID=25, SPACE=26, NUMBER=27, CHARS=28;
	public static final int
		RULE_selectStatement = 0, RULE_topicStatement = 1, RULE_offsetStatement = 2, 
		RULE_partitionsStatement = 3, RULE_consumersStatement = 4, RULE_consumerOffsetStatement = 5, 
		RULE_querySpecification = 6, RULE_value = 7, RULE_whereClause = 8, RULE_inCluase = 9, 
		RULE_betweenCluase = 10, RULE_equationClause = 11, RULE_partitionsEquslCluase = 12, 
		RULE_timestampEquslCluase = 13, RULE_valueEqualClause = 14, RULE_byteFunction = 15, 
		RULE_jsonFunction = 16, RULE_strFunction = 17, RULE_numberList = 18, RULE_charsList = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"selectStatement", "topicStatement", "offsetStatement", "partitionsStatement", 
			"consumersStatement", "consumerOffsetStatement", "querySpecification", 
			"value", "whereClause", "inCluase", "betweenCluase", "equationClause", 
			"partitionsEquslCluase", "timestampEquslCluase", "valueEqualClause", 
			"byteFunction", "jsonFunction", "strFunction", "numberList", "charsList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'.'", "','", "')'", null, "'SELECT'", "'FROM'", "'IN'", 
			"'WHERE'", "'BETWEEN'", "'PARTITION'", "'TIMESTAMP'", "'OFFSET'", "'TOPICS'", 
			"'OFFSETS'", "'PARTITIONS'", "'CONSUMERS'", "'CONSUMER_OFFSET'", "'BYTE'", 
			"'JSON'", "'STR'", "'*'", "'='", "';'", null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "WS", "SELECT", "FROM", "IN", "WHERE", 
			"BETWEEN", "PARTITION", "TIMESTAMP", "OFFSET", "TOPICS", "OFFSETS", "PARTITIONS", 
			"CONSUMERS", "CONSUMER_OFFSET", "BYTE", "JSON", "STR", "STAR", "EQUAL", 
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
		public SelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatement; }
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_selectStatement);
		try {
			setState(52);
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
			setState(54);
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
			setState(56);
			match(OFFSETS);
			setState(57);
			match(T__0);
			setState(58);
			match(ID);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(59);
				match(T__1);
				setState(60);
				match(NUMBER);
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(61);
					match(T__2);
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACE) {
						{
						{
						setState(62);
						match(SPACE);
						}
						}
						setState(67);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(68);
					match(NUMBER);
					}
					}
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(76);
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
			setState(78);
			match(PARTITIONS);
			setState(79);
			match(T__0);
			setState(80);
			match(ID);
			setState(81);
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
		public TerminalNode ID() { return getToken(KafkaSqlParser.ID, 0); }
		public ConsumersStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_consumersStatement; }
	}

	public final ConsumersStatementContext consumersStatement() throws RecognitionException {
		ConsumersStatementContext _localctx = new ConsumersStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_consumersStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(CONSUMERS);
			setState(84);
			match(T__0);
			setState(85);
			match(ID);
			setState(86);
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
			setState(88);
			match(CONSUMER_OFFSET);
			setState(89);
			match(T__0);
			setState(90);
			match(ID);
			setState(91);
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
		enterRule(_localctx, 12, RULE_querySpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				{
				setState(93);
				match(STAR);
				}
				break;
			case BYTE:
			case JSON:
			case STR:
				{
				setState(94);
				value();
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(95);
					match(T__2);
					setState(96);
					value();
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(104);
			match(FROM);
			setState(105);
			match(ID);
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(106);
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
		public JsonFunctionContext jsonFunction() {
			return getRuleContext(JsonFunctionContext.class,0);
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
		enterRule(_localctx, 14, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BYTE:
				{
				setState(109);
				byteFunction();
				}
				break;
			case JSON:
				{
				setState(110);
				jsonFunction();
				}
				break;
			case STR:
				{
				setState(111);
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
		enterRule(_localctx, 16, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(WHERE);
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(115);
				equationClause();
				}
				break;
			case 2:
				{
				setState(116);
				inCluase();
				}
				break;
			case 3:
				{
				setState(117);
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
		public TerminalNode OFFSET() { return getToken(KafkaSqlParser.OFFSET, 0); }
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
		enterRule(_localctx, 18, RULE_inCluase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PARTITION) | (1L << TIMESTAMP) | (1L << OFFSET))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(121);
			match(IN);
			setState(122);
			match(T__0);
			setState(151);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(123);
				match(NUMBER);
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(124);
					match(T__2);
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACE) {
						{
						{
						setState(125);
						match(SPACE);
						}
						}
						setState(130);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(131);
					match(NUMBER);
					}
					}
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case CHARS:
				{
				setState(137);
				match(CHARS);
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(138);
					match(T__2);
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACE) {
						{
						{
						setState(139);
						match(SPACE);
						}
						}
						setState(144);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(145);
					match(CHARS);
					}
					}
					setState(150);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(153);
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
		public TerminalNode OFFSET() { return getToken(KafkaSqlParser.OFFSET, 0); }
		public BetweenCluaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_betweenCluase; }
	}

	public final BetweenCluaseContext betweenCluase() throws RecognitionException {
		BetweenCluaseContext _localctx = new BetweenCluaseContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_betweenCluase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PARTITION) | (1L << TIMESTAMP) | (1L << OFFSET))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(156);
			match(BETWEEN);
			setState(157);
			match(T__0);
			setState(158);
			match(NUMBER);
			setState(159);
			match(T__2);
			setState(160);
			match(NUMBER);
			setState(161);
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
		enterRule(_localctx, 22, RULE_equationClause);
		try {
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PARTITION:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				partitionsEquslCluase();
				}
				break;
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				timestampEquslCluase();
				}
				break;
			case BYTE:
			case JSON:
			case STR:
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
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
		enterRule(_localctx, 24, RULE_partitionsEquslCluase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(PARTITION);
			setState(169);
			match(EQUAL);
			setState(170);
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
		enterRule(_localctx, 26, RULE_timestampEquslCluase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(TIMESTAMP);
			setState(173);
			match(EQUAL);
			setState(174);
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
		enterRule(_localctx, 28, RULE_valueEqualClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			value();
			setState(177);
			match(EQUAL);
			setState(178);
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
		enterRule(_localctx, 30, RULE_byteFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(BYTE);
			setState(181);
			match(T__0);
			setState(182);
			match(ID);
			setState(183);
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

	public static class JsonFunctionContext extends ParserRuleContext {
		public TerminalNode JSON() { return getToken(KafkaSqlParser.JSON, 0); }
		public TerminalNode ID() { return getToken(KafkaSqlParser.ID, 0); }
		public JsonFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsonFunction; }
	}

	public final JsonFunctionContext jsonFunction() throws RecognitionException {
		JsonFunctionContext _localctx = new JsonFunctionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_jsonFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(JSON);
			setState(186);
			match(T__0);
			setState(187);
			match(ID);
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
			setState(190);
			match(STR);
			setState(191);
			match(T__0);
			setState(192);
			match(ID);
			setState(193);
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
			setState(195);
			match(NUMBER);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(196);
				match(T__2);
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(197);
					match(SPACE);
					}
					}
					setState(202);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(203);
				match(NUMBER);
				}
				}
				setState(208);
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
			setState(209);
			match(CHARS);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(210);
				match(T__2);
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(211);
					match(SPACE);
					}
					}
					setState(216);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(217);
				match(CHARS);
				}
				}
				setState(222);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00e2\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\5\2\67\n\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4B\n\4\f\4\16"+
		"\4E\13\4\3\4\7\4H\n\4\f\4\16\4K\13\4\5\4M\n\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\bd\n\b"+
		"\f\b\16\bg\13\b\5\bi\n\b\3\b\3\b\3\b\5\bn\n\b\3\t\3\t\3\t\5\ts\n\t\3\n"+
		"\3\n\3\n\3\n\5\ny\n\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0081\n\13\f"+
		"\13\16\13\u0084\13\13\3\13\7\13\u0087\n\13\f\13\16\13\u008a\13\13\3\13"+
		"\3\13\3\13\7\13\u008f\n\13\f\13\16\13\u0092\13\13\3\13\7\13\u0095\n\13"+
		"\f\13\16\13\u0098\13\13\5\13\u009a\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\5\r\u00a9\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u00c9\n\24\f\24"+
		"\16\24\u00cc\13\24\3\24\7\24\u00cf\n\24\f\24\16\24\u00d2\13\24\3\25\3"+
		"\25\3\25\7\25\u00d7\n\25\f\25\16\25\u00da\13\25\3\25\7\25\u00dd\n\25\f"+
		"\25\16\25\u00e0\13\25\3\25\2\2\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(\2\4\3\2\r\17\3\2\35\36\2\u00e7\2\66\3\2\2\2\48\3\2\2\2\6:\3"+
		"\2\2\2\bP\3\2\2\2\nU\3\2\2\2\fZ\3\2\2\2\16h\3\2\2\2\20r\3\2\2\2\22t\3"+
		"\2\2\2\24z\3\2\2\2\26\u009d\3\2\2\2\30\u00a8\3\2\2\2\32\u00aa\3\2\2\2"+
		"\34\u00ae\3\2\2\2\36\u00b2\3\2\2\2 \u00b6\3\2\2\2\"\u00bb\3\2\2\2$\u00c0"+
		"\3\2\2\2&\u00c5\3\2\2\2(\u00d3\3\2\2\2*+\7\b\2\2+\67\5\4\3\2,-\7\b\2\2"+
		"-\67\5\6\4\2./\7\b\2\2/\67\5\b\5\2\60\61\7\b\2\2\61\67\5\n\6\2\62\63\7"+
		"\b\2\2\63\67\5\f\7\2\64\65\7\b\2\2\65\67\5\16\b\2\66*\3\2\2\2\66,\3\2"+
		"\2\2\66.\3\2\2\2\66\60\3\2\2\2\66\62\3\2\2\2\66\64\3\2\2\2\67\3\3\2\2"+
		"\289\7\20\2\29\5\3\2\2\2:;\7\21\2\2;<\7\3\2\2<L\7\33\2\2=>\7\4\2\2>I\7"+
		"\35\2\2?C\7\5\2\2@B\7\34\2\2A@\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D"+
		"F\3\2\2\2EC\3\2\2\2FH\7\35\2\2G?\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2"+
		"JM\3\2\2\2KI\3\2\2\2L=\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7\6\2\2O\7\3\2\2"+
		"\2PQ\7\22\2\2QR\7\3\2\2RS\7\33\2\2ST\7\6\2\2T\t\3\2\2\2UV\7\23\2\2VW\7"+
		"\3\2\2WX\7\33\2\2XY\7\6\2\2Y\13\3\2\2\2Z[\7\24\2\2[\\\7\3\2\2\\]\7\33"+
		"\2\2]^\7\6\2\2^\r\3\2\2\2_i\7\30\2\2`e\5\20\t\2ab\7\5\2\2bd\5\20\t\2c"+
		"a\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fi\3\2\2\2ge\3\2\2\2h_\3\2\2\2"+
		"h`\3\2\2\2ij\3\2\2\2jk\7\t\2\2km\7\33\2\2ln\5\22\n\2ml\3\2\2\2mn\3\2\2"+
		"\2n\17\3\2\2\2os\5 \21\2ps\5\"\22\2qs\5$\23\2ro\3\2\2\2rp\3\2\2\2rq\3"+
		"\2\2\2s\21\3\2\2\2tx\7\13\2\2uy\5\30\r\2vy\5\24\13\2wy\5\26\f\2xu\3\2"+
		"\2\2xv\3\2\2\2xw\3\2\2\2y\23\3\2\2\2z{\t\2\2\2{|\7\n\2\2|\u0099\7\3\2"+
		"\2}\u0088\7\35\2\2~\u0082\7\5\2\2\177\u0081\7\34\2\2\u0080\177\3\2\2\2"+
		"\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0087\7\35\2\2\u0086~\3\2\2\2\u0087"+
		"\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u009a\3\2"+
		"\2\2\u008a\u0088\3\2\2\2\u008b\u0096\7\36\2\2\u008c\u0090\7\5\2\2\u008d"+
		"\u008f\7\34\2\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3"+
		"\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093"+
		"\u0095\7\36\2\2\u0094\u008c\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3"+
		"\2\2\2\u0096\u0097\3\2\2\2\u0097\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0099"+
		"}\3\2\2\2\u0099\u008b\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c\7\6\2\2"+
		"\u009c\25\3\2\2\2\u009d\u009e\t\2\2\2\u009e\u009f\7\f\2\2\u009f\u00a0"+
		"\7\3\2\2\u00a0\u00a1\7\35\2\2\u00a1\u00a2\7\5\2\2\u00a2\u00a3\7\35\2\2"+
		"\u00a3\u00a4\7\6\2\2\u00a4\27\3\2\2\2\u00a5\u00a9\5\32\16\2\u00a6\u00a9"+
		"\5\34\17\2\u00a7\u00a9\5\36\20\2\u00a8\u00a5\3\2\2\2\u00a8\u00a6\3\2\2"+
		"\2\u00a8\u00a7\3\2\2\2\u00a9\31\3\2\2\2\u00aa\u00ab\7\r\2\2\u00ab\u00ac"+
		"\7\31\2\2\u00ac\u00ad\7\35\2\2\u00ad\33\3\2\2\2\u00ae\u00af\7\16\2\2\u00af"+
		"\u00b0\7\31\2\2\u00b0\u00b1\7\35\2\2\u00b1\35\3\2\2\2\u00b2\u00b3\5\20"+
		"\t\2\u00b3\u00b4\7\31\2\2\u00b4\u00b5\t\3\2\2\u00b5\37\3\2\2\2\u00b6\u00b7"+
		"\7\25\2\2\u00b7\u00b8\7\3\2\2\u00b8\u00b9\7\33\2\2\u00b9\u00ba\7\6\2\2"+
		"\u00ba!\3\2\2\2\u00bb\u00bc\7\26\2\2\u00bc\u00bd\7\3\2\2\u00bd\u00be\7"+
		"\33\2\2\u00be\u00bf\7\6\2\2\u00bf#\3\2\2\2\u00c0\u00c1\7\27\2\2\u00c1"+
		"\u00c2\7\3\2\2\u00c2\u00c3\7\33\2\2\u00c3\u00c4\7\6\2\2\u00c4%\3\2\2\2"+
		"\u00c5\u00d0\7\35\2\2\u00c6\u00ca\7\5\2\2\u00c7\u00c9\7\34\2\2\u00c8\u00c7"+
		"\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00cf\7\35\2\2\u00ce\u00c6\3"+
		"\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1"+
		"\'\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3\u00de\7\36\2\2\u00d4\u00d8\7\5\2"+
		"\2\u00d5\u00d7\7\34\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8"+
		"\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\3\2\2\2\u00da\u00d8\3\2"+
		"\2\2\u00db\u00dd\7\36\2\2\u00dc\u00d4\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de"+
		"\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df)\3\2\2\2\u00e0\u00de\3\2\2\2"+
		"\25\66CILehmrx\u0082\u0088\u0090\u0096\u0099\u00a8\u00ca\u00d0\u00d8\u00de";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}