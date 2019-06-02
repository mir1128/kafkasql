// Generated from KafkaSql.g4 by ANTLR 4.7.2
package com.looboo.kafkasql.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KafkaSqlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, NUMBER_LIST=4, CHARS_LIST=5, WS=6, SELECT=7, IN=8, 
		OFFSETS=9, PARTITIONS=10, CONSUMERS=11, CONSUMER_OFFSET=12, ID=13, SPACE=14, 
		CHARS=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "NUMBER_LIST", "CHARS_LIST", "WS", "SELECT", 
			"IN", "OFFSETS", "PARTITIONS", "CONSUMERS", "CONSUMER_OFFSET", "ID", 
			"SPACE", "NUMBER", "CHARS", "ID_LITERAL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'.'", "')'", null, null, null, "'SELECT'", "'IN'", "'OFFSETS'", 
			"'PARTITIONS'", "'CONSUMERS'", "'CONSUMER_OFFSET'", null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "NUMBER_LIST", "CHARS_LIST", "WS", "SELECT", 
			"IN", "OFFSETS", "PARTITIONS", "CONSUMERS", "CONSUMER_OFFSET", "ID", 
			"SPACE", "CHARS"
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


	public KafkaSqlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "KafkaSql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21\u00a9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\7\5/\n\5\f\5\16\5\62\13\5\3"+
		"\5\7\5\65\n\5\f\5\16\58\13\5\3\6\3\6\3\6\3\6\3\6\7\6?\n\6\f\6\16\6B\13"+
		"\6\3\6\3\6\3\6\3\6\7\6H\n\6\f\6\16\6K\13\6\3\7\6\7N\n\7\r\7\16\7O\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\6\20\u0090\n\20\r"+
		"\20\16\20\u0091\3\21\6\21\u0095\n\21\r\21\16\21\u0096\3\22\7\22\u009a"+
		"\n\22\f\22\16\22\u009d\13\22\3\22\6\22\u00a0\n\22\r\22\16\22\u00a1\3\22"+
		"\7\22\u00a5\n\22\f\22\16\22\u00a8\13\22\4\u009b\u00a1\2\23\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\2!\21#\2"+
		"\3\2\7\5\2\13\f\17\17\"\"\3\2\62;\5\2\62;C\\c|\6\2&&\62;C\\aa\5\2&&C\\"+
		"aa\2\u00b0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2!\3\2\2\2\3%\3\2\2\2"+
		"\5\'\3\2\2\2\7)\3\2\2\2\t+\3\2\2\2\139\3\2\2\2\rM\3\2\2\2\17S\3\2\2\2"+
		"\21Z\3\2\2\2\23]\3\2\2\2\25e\3\2\2\2\27p\3\2\2\2\31z\3\2\2\2\33\u008a"+
		"\3\2\2\2\35\u008c\3\2\2\2\37\u008f\3\2\2\2!\u0094\3\2\2\2#\u009b\3\2\2"+
		"\2%&\7*\2\2&\4\3\2\2\2\'(\7\60\2\2(\6\3\2\2\2)*\7+\2\2*\b\3\2\2\2+\66"+
		"\5\37\20\2,\60\7.\2\2-/\5\35\17\2.-\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\60"+
		"\61\3\2\2\2\61\63\3\2\2\2\62\60\3\2\2\2\63\65\5\37\20\2\64,\3\2\2\2\65"+
		"8\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\n\3\2\2\28\66\3\2\2\29:\7)\2"+
		"\2:;\5!\21\2;I\7)\2\2<@\7.\2\2=?\5\35\17\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2"+
		"\2@A\3\2\2\2AC\3\2\2\2B@\3\2\2\2CD\7)\2\2DE\5!\21\2EF\7)\2\2FH\3\2\2\2"+
		"G<\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\f\3\2\2\2KI\3\2\2\2LN\t\2\2"+
		"\2ML\3\2\2\2NO\3\2\2\2OM\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\b\7\2\2R\16\3\2"+
		"\2\2ST\7U\2\2TU\7G\2\2UV\7N\2\2VW\7G\2\2WX\7E\2\2XY\7V\2\2Y\20\3\2\2\2"+
		"Z[\7K\2\2[\\\7P\2\2\\\22\3\2\2\2]^\7Q\2\2^_\7H\2\2_`\7H\2\2`a\7U\2\2a"+
		"b\7G\2\2bc\7V\2\2cd\7U\2\2d\24\3\2\2\2ef\7R\2\2fg\7C\2\2gh\7T\2\2hi\7"+
		"V\2\2ij\7K\2\2jk\7V\2\2kl\7K\2\2lm\7Q\2\2mn\7P\2\2no\7U\2\2o\26\3\2\2"+
		"\2pq\7E\2\2qr\7Q\2\2rs\7P\2\2st\7U\2\2tu\7W\2\2uv\7O\2\2vw\7G\2\2wx\7"+
		"T\2\2xy\7U\2\2y\30\3\2\2\2z{\7E\2\2{|\7Q\2\2|}\7P\2\2}~\7U\2\2~\177\7"+
		"W\2\2\177\u0080\7O\2\2\u0080\u0081\7G\2\2\u0081\u0082\7T\2\2\u0082\u0083"+
		"\7a\2\2\u0083\u0084\7Q\2\2\u0084\u0085\7H\2\2\u0085\u0086\7H\2\2\u0086"+
		"\u0087\7U\2\2\u0087\u0088\7G\2\2\u0088\u0089\7V\2\2\u0089\32\3\2\2\2\u008a"+
		"\u008b\5#\22\2\u008b\34\3\2\2\2\u008c\u008d\7\"\2\2\u008d\36\3\2\2\2\u008e"+
		"\u0090\t\3\2\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092 \3\2\2\2\u0093\u0095\t\4\2\2\u0094\u0093"+
		"\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\"\3\2\2\2\u0098\u009a\t\5\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2"+
		"\u009b\u009c\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b"+
		"\3\2\2\2\u009e\u00a0\t\6\2\2\u009f\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a6\3\2\2\2\u00a3\u00a5\t\5"+
		"\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7$\3\2\2\2\u00a8\u00a6\3\2\2\2\r\2\60\66@IO\u0091\u0096"+
		"\u009b\u00a1\u00a6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}