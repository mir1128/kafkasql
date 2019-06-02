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
		BETWEEN=10, PARTITION=11, TIMESTAMP=12, OFFSET=13, OFFSETS=14, PARTITIONS=15, 
		CONSUMERS=16, CONSUMER_OFFSET=17, BYTE=18, JSON=19, STR=20, STAR=21, EQUAL=22, 
		SEMICOLON=23, ID=24, SPACE=25, NUMBER=26, CHARS=27;
	public static final int
		RULE_selectStatement = 0, RULE_offsetStatement = 1, RULE_partitionsStatement = 2, 
		RULE_consumersStatement = 3, RULE_consumerOffsetStatement = 4, RULE_querySpecification = 5, 
		RULE_value = 6, RULE_whereClause = 7, RULE_inCluase = 8, RULE_betweenCluase = 9, 
		RULE_equationClause = 10, RULE_partitionsEquslCluase = 11, RULE_timestampEquslCluase = 12, 
		RULE_valueEqualClause = 13, RULE_byteFunction = 14, RULE_jsonFunction = 15, 
		RULE_strFunction = 16, RULE_numberList = 17, RULE_charsList = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"selectStatement", "offsetStatement", "partitionsStatement", "consumersStatement", 
			"consumerOffsetStatement", "querySpecification", "value", "whereClause", 
			"inCluase", "betweenCluase", "equationClause", "partitionsEquslCluase", 
			"timestampEquslCluase", "valueEqualClause", "byteFunction", "jsonFunction", 
			"strFunction", "numberList", "charsList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'.'", "','", "')'", null, "'SELECT'", "'FROM'", "'IN'", 
			"'WHERE'", "'BETWEEN'", "'PARTITION'", "'TIMESTAMP'", "'OFFSET'", "'OFFSETS'", 
			"'PARTITIONS'", "'CONSUMERS'", "'CONSUMER_OFFSET'", "'BYTE'", "'JSON'", 
			"'STR'", "'*'", "'='", "';'", null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "WS", "SELECT", "FROM", "IN", "WHERE", 
			"BETWEEN", "PARTITION", "TIMESTAMP", "OFFSET", "OFFSETS", "PARTITIONS", 
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
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				match(SELECT);
				setState(39);
				offsetStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				match(SELECT);
				setState(41);
				partitionsStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				match(SELECT);
				setState(43);
				consumersStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				match(SELECT);
				setState(45);
				consumerOffsetStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(46);
				match(SELECT);
				setState(47);
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
		enterRule(_localctx, 2, RULE_offsetStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(OFFSETS);
			setState(51);
			match(T__0);
			setState(52);
			match(ID);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(53);
				match(T__1);
				setState(54);
				match(NUMBER);
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(55);
					match(T__2);
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACE) {
						{
						{
						setState(56);
						match(SPACE);
						}
						}
						setState(61);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(62);
					match(NUMBER);
					}
					}
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(70);
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
		enterRule(_localctx, 4, RULE_partitionsStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(PARTITIONS);
			setState(73);
			match(T__0);
			setState(74);
			match(ID);
			setState(75);
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
		enterRule(_localctx, 6, RULE_consumersStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(CONSUMERS);
			setState(78);
			match(T__0);
			setState(79);
			match(ID);
			setState(80);
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
		enterRule(_localctx, 8, RULE_consumerOffsetStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(CONSUMER_OFFSET);
			setState(83);
			match(T__0);
			setState(84);
			match(ID);
			setState(85);
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
		enterRule(_localctx, 10, RULE_querySpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				{
				setState(87);
				match(STAR);
				}
				break;
			case BYTE:
			case JSON:
			case STR:
			case ID:
				{
				setState(88);
				value();
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(89);
					match(T__2);
					setState(90);
					value();
					}
					}
					setState(95);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(98);
			match(FROM);
			setState(99);
			match(ID);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(100);
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
		public TerminalNode ID() { return getToken(KafkaSqlParser.ID, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BYTE:
				{
				setState(103);
				byteFunction();
				}
				break;
			case JSON:
				{
				setState(104);
				jsonFunction();
				}
				break;
			case STR:
				{
				setState(105);
				strFunction();
				}
				break;
			case ID:
				{
				setState(106);
				match(ID);
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
		enterRule(_localctx, 14, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(WHERE);
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(110);
				equationClause();
				}
				break;
			case 2:
				{
				setState(111);
				inCluase();
				}
				break;
			case 3:
				{
				setState(112);
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
		enterRule(_localctx, 16, RULE_inCluase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PARTITION) | (1L << TIMESTAMP) | (1L << OFFSET))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(116);
			match(IN);
			setState(117);
			match(T__0);
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				{
				setState(118);
				match(NUMBER);
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(119);
					match(T__2);
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACE) {
						{
						{
						setState(120);
						match(SPACE);
						}
						}
						setState(125);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(126);
					match(NUMBER);
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case CHARS:
				{
				setState(132);
				match(CHARS);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(133);
					match(T__2);
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==SPACE) {
						{
						{
						setState(134);
						match(SPACE);
						}
						}
						setState(139);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(140);
					match(CHARS);
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(148);
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
		enterRule(_localctx, 18, RULE_betweenCluase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PARTITION) | (1L << TIMESTAMP) | (1L << OFFSET))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(151);
			match(BETWEEN);
			setState(152);
			match(T__0);
			setState(153);
			match(NUMBER);
			setState(154);
			match(T__2);
			setState(155);
			match(NUMBER);
			setState(156);
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
		enterRule(_localctx, 20, RULE_equationClause);
		try {
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PARTITION:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				partitionsEquslCluase();
				}
				break;
			case TIMESTAMP:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				timestampEquslCluase();
				}
				break;
			case BYTE:
			case JSON:
			case STR:
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(160);
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
		enterRule(_localctx, 22, RULE_partitionsEquslCluase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(PARTITION);
			setState(164);
			match(EQUAL);
			setState(165);
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
		enterRule(_localctx, 24, RULE_timestampEquslCluase);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(TIMESTAMP);
			setState(168);
			match(EQUAL);
			setState(169);
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
		enterRule(_localctx, 26, RULE_valueEqualClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			value();
			setState(172);
			match(EQUAL);
			setState(173);
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
		enterRule(_localctx, 28, RULE_byteFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(BYTE);
			setState(176);
			match(T__0);
			setState(177);
			match(ID);
			setState(178);
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
		enterRule(_localctx, 30, RULE_jsonFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(JSON);
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
		enterRule(_localctx, 32, RULE_strFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(STR);
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
		enterRule(_localctx, 34, RULE_numberList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(NUMBER);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(191);
				match(T__2);
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(192);
					match(SPACE);
					}
					}
					setState(197);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(198);
				match(NUMBER);
				}
				}
				setState(203);
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
		enterRule(_localctx, 36, RULE_charsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(CHARS);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(205);
				match(T__2);
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SPACE) {
					{
					{
					setState(206);
					match(SPACE);
					}
					}
					setState(211);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(212);
				match(CHARS);
				}
				}
				setState(217);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00dd\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\63\n"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3<\n\3\f\3\16\3?\13\3\3\3\7\3B\n\3\f"+
		"\3\16\3E\13\3\5\3G\n\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7^\n\7\f\7\16\7a\13\7\5\7c\n\7"+
		"\3\7\3\7\3\7\5\7h\n\7\3\b\3\b\3\b\3\b\5\bn\n\b\3\t\3\t\3\t\3\t\5\tt\n"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\7\n|\n\n\f\n\16\n\177\13\n\3\n\7\n\u0082\n"+
		"\n\f\n\16\n\u0085\13\n\3\n\3\n\3\n\7\n\u008a\n\n\f\n\16\n\u008d\13\n\3"+
		"\n\7\n\u0090\n\n\f\n\16\n\u0093\13\n\5\n\u0095\n\n\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\5\f\u00a4\n\f\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\7\23\u00c4"+
		"\n\23\f\23\16\23\u00c7\13\23\3\23\7\23\u00ca\n\23\f\23\16\23\u00cd\13"+
		"\23\3\24\3\24\3\24\7\24\u00d2\n\24\f\24\16\24\u00d5\13\24\3\24\7\24\u00d8"+
		"\n\24\f\24\16\24\u00db\13\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&\2\4\3\2\r\17\3\2\34\35\2\u00e3\2\62\3\2\2\2\4\64\3\2\2"+
		"\2\6J\3\2\2\2\bO\3\2\2\2\nT\3\2\2\2\fb\3\2\2\2\16m\3\2\2\2\20o\3\2\2\2"+
		"\22u\3\2\2\2\24\u0098\3\2\2\2\26\u00a3\3\2\2\2\30\u00a5\3\2\2\2\32\u00a9"+
		"\3\2\2\2\34\u00ad\3\2\2\2\36\u00b1\3\2\2\2 \u00b6\3\2\2\2\"\u00bb\3\2"+
		"\2\2$\u00c0\3\2\2\2&\u00ce\3\2\2\2()\7\b\2\2)\63\5\4\3\2*+\7\b\2\2+\63"+
		"\5\6\4\2,-\7\b\2\2-\63\5\b\5\2./\7\b\2\2/\63\5\n\6\2\60\61\7\b\2\2\61"+
		"\63\5\f\7\2\62(\3\2\2\2\62*\3\2\2\2\62,\3\2\2\2\62.\3\2\2\2\62\60\3\2"+
		"\2\2\63\3\3\2\2\2\64\65\7\20\2\2\65\66\7\3\2\2\66F\7\32\2\2\678\7\4\2"+
		"\28C\7\34\2\29=\7\5\2\2:<\7\33\2\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2"+
		"\2\2>@\3\2\2\2?=\3\2\2\2@B\7\34\2\2A9\3\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3"+
		"\2\2\2DG\3\2\2\2EC\3\2\2\2F\67\3\2\2\2FG\3\2\2\2GH\3\2\2\2HI\7\6\2\2I"+
		"\5\3\2\2\2JK\7\21\2\2KL\7\3\2\2LM\7\32\2\2MN\7\6\2\2N\7\3\2\2\2OP\7\22"+
		"\2\2PQ\7\3\2\2QR\7\32\2\2RS\7\6\2\2S\t\3\2\2\2TU\7\23\2\2UV\7\3\2\2VW"+
		"\7\32\2\2WX\7\6\2\2X\13\3\2\2\2Yc\7\27\2\2Z_\5\16\b\2[\\\7\5\2\2\\^\5"+
		"\16\b\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`c\3\2\2\2a_\3\2\2\2bY"+
		"\3\2\2\2bZ\3\2\2\2cd\3\2\2\2de\7\t\2\2eg\7\32\2\2fh\5\20\t\2gf\3\2\2\2"+
		"gh\3\2\2\2h\r\3\2\2\2in\5\36\20\2jn\5 \21\2kn\5\"\22\2ln\7\32\2\2mi\3"+
		"\2\2\2mj\3\2\2\2mk\3\2\2\2ml\3\2\2\2n\17\3\2\2\2os\7\13\2\2pt\5\26\f\2"+
		"qt\5\22\n\2rt\5\24\13\2sp\3\2\2\2sq\3\2\2\2sr\3\2\2\2t\21\3\2\2\2uv\t"+
		"\2\2\2vw\7\n\2\2w\u0094\7\3\2\2x\u0083\7\34\2\2y}\7\5\2\2z|\7\33\2\2{"+
		"z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2"+
		"\u0080\u0082\7\34\2\2\u0081y\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3"+
		"\2\2\2\u0083\u0084\3\2\2\2\u0084\u0095\3\2\2\2\u0085\u0083\3\2\2\2\u0086"+
		"\u0091\7\35\2\2\u0087\u008b\7\5\2\2\u0088\u008a\7\33\2\2\u0089\u0088\3"+
		"\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0090\7\35\2\2\u008f\u0087\3"+
		"\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0094x\3\2\2\2\u0094\u0086\3\2\2\2"+
		"\u0095\u0096\3\2\2\2\u0096\u0097\7\6\2\2\u0097\23\3\2\2\2\u0098\u0099"+
		"\t\2\2\2\u0099\u009a\7\f\2\2\u009a\u009b\7\3\2\2\u009b\u009c\7\34\2\2"+
		"\u009c\u009d\7\5\2\2\u009d\u009e\7\34\2\2\u009e\u009f\7\6\2\2\u009f\25"+
		"\3\2\2\2\u00a0\u00a4\5\30\r\2\u00a1\u00a4\5\32\16\2\u00a2\u00a4\5\34\17"+
		"\2\u00a3\u00a0\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\27"+
		"\3\2\2\2\u00a5\u00a6\7\r\2\2\u00a6\u00a7\7\30\2\2\u00a7\u00a8\7\34\2\2"+
		"\u00a8\31\3\2\2\2\u00a9\u00aa\7\16\2\2\u00aa\u00ab\7\30\2\2\u00ab\u00ac"+
		"\7\34\2\2\u00ac\33\3\2\2\2\u00ad\u00ae\5\16\b\2\u00ae\u00af\7\30\2\2\u00af"+
		"\u00b0\t\3\2\2\u00b0\35\3\2\2\2\u00b1\u00b2\7\24\2\2\u00b2\u00b3\7\3\2"+
		"\2\u00b3\u00b4\7\32\2\2\u00b4\u00b5\7\6\2\2\u00b5\37\3\2\2\2\u00b6\u00b7"+
		"\7\25\2\2\u00b7\u00b8\7\3\2\2\u00b8\u00b9\7\32\2\2\u00b9\u00ba\7\6\2\2"+
		"\u00ba!\3\2\2\2\u00bb\u00bc\7\26\2\2\u00bc\u00bd\7\3\2\2\u00bd\u00be\7"+
		"\32\2\2\u00be\u00bf\7\6\2\2\u00bf#\3\2\2\2\u00c0\u00cb\7\34\2\2\u00c1"+
		"\u00c5\7\5\2\2\u00c2\u00c4\7\33\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7\3"+
		"\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00ca\7\34\2\2\u00c9\u00c1\3\2\2\2\u00ca\u00cd\3"+
		"\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc%\3\2\2\2\u00cd\u00cb"+
		"\3\2\2\2\u00ce\u00d9\7\35\2\2\u00cf\u00d3\7\5\2\2\u00d0\u00d2\7\33\2\2"+
		"\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4"+
		"\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d8\7\35\2\2"+
		"\u00d7\u00cf\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da"+
		"\3\2\2\2\u00da\'\3\2\2\2\u00db\u00d9\3\2\2\2\25\62=CF_bgms}\u0083\u008b"+
		"\u0091\u0094\u00a3\u00c5\u00cb\u00d3\u00d9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}