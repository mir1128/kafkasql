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
		T__0=1, T__1=2, T__2=3, T__3=4, WS=5, SELECT=6, FROM=7, IN=8, WHERE=9, 
		BETWEEN=10, PARTITION=11, TIMESTAMP=12, OFFSET=13, TOPICS=14, OFFSETS=15, 
		PARTITIONS=16, CONSUMERS=17, CONSUMER_OFFSET=18, BYTE=19, STR=20, STAR=21, 
		EQUAL=22, SEMICOLON=23, ID=24, SPACE=25, NUMBER=26, CHARS=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "WS", "SELECT", "FROM", "IN", "WHERE", 
			"BETWEEN", "PARTITION", "TIMESTAMP", "OFFSET", "TOPICS", "OFFSETS", "PARTITIONS", 
			"CONSUMERS", "CONSUMER_OFFSET", "BYTE", "STR", "STAR", "EQUAL", "SEMICOLON", 
			"ID", "SPACE", "NUMBER", "CHARS", "ID_LITERAL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'.'", "','", "')'", null, "'SELECT'", "'FROM'", "'IN'", 
			"'WHERE'", "'BETWEEN'", "'PARTITION'", "'TIMESTAMP'", "'OFFSET'", "'TOPICS'", 
			"'OFFSETS'", "'PARTITIONS'", "'CONSUMERS'", "'CONSUMER_OFFSET'", "'BYTE'", 
			"'STR'", "'*'", "'='", "';'", null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "WS", "SELECT", "FROM", "IN", "WHERE", 
			"BETWEEN", "PARTITION", "TIMESTAMP", "OFFSET", "TOPICS", "OFFSETS", "PARTITIONS", 
			"CONSUMERS", "CONSUMER_OFFSET", "BYTE", "STR", "STAR", "EQUAL", "SEMICOLON", 
			"ID", "SPACE", "NUMBER", "CHARS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00e7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\6\6E\n\6\r\6\16\6F\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32"+
		"\3\32\3\33\6\33\u00cb\n\33\r\33\16\33\u00cc\3\34\3\34\6\34\u00d1\n\34"+
		"\r\34\16\34\u00d2\3\34\3\34\3\35\7\35\u00d8\n\35\f\35\16\35\u00db\13\35"+
		"\3\35\6\35\u00de\n\35\r\35\16\35\u00df\3\35\7\35\u00e3\n\35\f\35\16\35"+
		"\u00e6\13\35\4\u00d9\u00df\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\2\3\2\7\5\2\13\f\17\17\"\"\3\2\62;\5\2\62;C"+
		"\\c|\7\2&&//\62;C\\aa\6\2&&//C\\aa\2\u00eb\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\3;\3\2\2\2\5=\3\2\2\2\7?\3\2\2\2\tA\3\2\2\2"+
		"\13D\3\2\2\2\rJ\3\2\2\2\17Q\3\2\2\2\21V\3\2\2\2\23Y\3\2\2\2\25_\3\2\2"+
		"\2\27g\3\2\2\2\31q\3\2\2\2\33{\3\2\2\2\35\u0082\3\2\2\2\37\u0089\3\2\2"+
		"\2!\u0091\3\2\2\2#\u009c\3\2\2\2%\u00a6\3\2\2\2\'\u00b6\3\2\2\2)\u00bb"+
		"\3\2\2\2+\u00bf\3\2\2\2-\u00c1\3\2\2\2/\u00c3\3\2\2\2\61\u00c5\3\2\2\2"+
		"\63\u00c7\3\2\2\2\65\u00ca\3\2\2\2\67\u00ce\3\2\2\29\u00d9\3\2\2\2;<\7"+
		"*\2\2<\4\3\2\2\2=>\7\60\2\2>\6\3\2\2\2?@\7.\2\2@\b\3\2\2\2AB\7+\2\2B\n"+
		"\3\2\2\2CE\t\2\2\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2GH\3\2\2\2H"+
		"I\b\6\2\2I\f\3\2\2\2JK\7U\2\2KL\7G\2\2LM\7N\2\2MN\7G\2\2NO\7E\2\2OP\7"+
		"V\2\2P\16\3\2\2\2QR\7H\2\2RS\7T\2\2ST\7Q\2\2TU\7O\2\2U\20\3\2\2\2VW\7"+
		"K\2\2WX\7P\2\2X\22\3\2\2\2YZ\7Y\2\2Z[\7J\2\2[\\\7G\2\2\\]\7T\2\2]^\7G"+
		"\2\2^\24\3\2\2\2_`\7D\2\2`a\7G\2\2ab\7V\2\2bc\7Y\2\2cd\7G\2\2de\7G\2\2"+
		"ef\7P\2\2f\26\3\2\2\2gh\7R\2\2hi\7C\2\2ij\7T\2\2jk\7V\2\2kl\7K\2\2lm\7"+
		"V\2\2mn\7K\2\2no\7Q\2\2op\7P\2\2p\30\3\2\2\2qr\7V\2\2rs\7K\2\2st\7O\2"+
		"\2tu\7G\2\2uv\7U\2\2vw\7V\2\2wx\7C\2\2xy\7O\2\2yz\7R\2\2z\32\3\2\2\2{"+
		"|\7Q\2\2|}\7H\2\2}~\7H\2\2~\177\7U\2\2\177\u0080\7G\2\2\u0080\u0081\7"+
		"V\2\2\u0081\34\3\2\2\2\u0082\u0083\7V\2\2\u0083\u0084\7Q\2\2\u0084\u0085"+
		"\7R\2\2\u0085\u0086\7K\2\2\u0086\u0087\7E\2\2\u0087\u0088\7U\2\2\u0088"+
		"\36\3\2\2\2\u0089\u008a\7Q\2\2\u008a\u008b\7H\2\2\u008b\u008c\7H\2\2\u008c"+
		"\u008d\7U\2\2\u008d\u008e\7G\2\2\u008e\u008f\7V\2\2\u008f\u0090\7U\2\2"+
		"\u0090 \3\2\2\2\u0091\u0092\7R\2\2\u0092\u0093\7C\2\2\u0093\u0094\7T\2"+
		"\2\u0094\u0095\7V\2\2\u0095\u0096\7K\2\2\u0096\u0097\7V\2\2\u0097\u0098"+
		"\7K\2\2\u0098\u0099\7Q\2\2\u0099\u009a\7P\2\2\u009a\u009b\7U\2\2\u009b"+
		"\"\3\2\2\2\u009c\u009d\7E\2\2\u009d\u009e\7Q\2\2\u009e\u009f\7P\2\2\u009f"+
		"\u00a0\7U\2\2\u00a0\u00a1\7W\2\2\u00a1\u00a2\7O\2\2\u00a2\u00a3\7G\2\2"+
		"\u00a3\u00a4\7T\2\2\u00a4\u00a5\7U\2\2\u00a5$\3\2\2\2\u00a6\u00a7\7E\2"+
		"\2\u00a7\u00a8\7Q\2\2\u00a8\u00a9\7P\2\2\u00a9\u00aa\7U\2\2\u00aa\u00ab"+
		"\7W\2\2\u00ab\u00ac\7O\2\2\u00ac\u00ad\7G\2\2\u00ad\u00ae\7T\2\2\u00ae"+
		"\u00af\7a\2\2\u00af\u00b0\7Q\2\2\u00b0\u00b1\7H\2\2\u00b1\u00b2\7H\2\2"+
		"\u00b2\u00b3\7U\2\2\u00b3\u00b4\7G\2\2\u00b4\u00b5\7V\2\2\u00b5&\3\2\2"+
		"\2\u00b6\u00b7\7D\2\2\u00b7\u00b8\7[\2\2\u00b8\u00b9\7V\2\2\u00b9\u00ba"+
		"\7G\2\2\u00ba(\3\2\2\2\u00bb\u00bc\7U\2\2\u00bc\u00bd\7V\2\2\u00bd\u00be"+
		"\7T\2\2\u00be*\3\2\2\2\u00bf\u00c0\7,\2\2\u00c0,\3\2\2\2\u00c1\u00c2\7"+
		"?\2\2\u00c2.\3\2\2\2\u00c3\u00c4\7=\2\2\u00c4\60\3\2\2\2\u00c5\u00c6\5"+
		"9\35\2\u00c6\62\3\2\2\2\u00c7\u00c8\7\"\2\2\u00c8\64\3\2\2\2\u00c9\u00cb"+
		"\t\3\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\66\3\2\2\2\u00ce\u00d0\7)\2\2\u00cf\u00d1\t\4\2\2"+
		"\u00d0\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3"+
		"\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\7)\2\2\u00d58\3\2\2\2\u00d6\u00d8"+
		"\t\5\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00da\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00de\t\6"+
		"\2\2\u00dd\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00e0\u00e4\3\2\2\2\u00e1\u00e3\t\5\2\2\u00e2\u00e1\3\2"+
		"\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		":\3\2\2\2\u00e6\u00e4\3\2\2\2\t\2F\u00cc\u00d2\u00d9\u00df\u00e4\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}