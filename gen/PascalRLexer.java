// Generated from /Users/Faux/IdeaProjects/Pascal/src/PascalR.g4 by ANTLR 4.8

  import java.io.*;
  import java.util.*;
  import java.util.stream.IntStream;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PascalRLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, WS=5, COL=6, SEM=7, LPA=8, RPA=9, COM=10, 
		DOT=11, BOL=12, INT=13, REL=14, CHR=15, PTR=16, ADR=17, ENM=18, SBR=19, 
		ARR=20, STR=21, RCD=22, SET=23, BSE=24, VRT=25, UNI=26, USE=27, VAR=28, 
		CST=29, TYP=30, PRM=31, BGN=32, END=33, IF=34, THN=35, ELS=36, CAS=37, 
		OF=38, WHL=39, FOR=40, DO=41, RPT=42, UTL=43, FUN=44, PRO=45, ITR=46, 
		ADD=47, SUB=48, MUL=49, DIV=50, MOD=51, EQU=52, NEQ=53, GRT=54, LES=55, 
		GEQ=56, LEQ=57, AND=58, ATH=59, OR=60, ORE=61, NOT=62, BND=63, BOR=64, 
		BNT=65, BOC=66, BSL=67, BSR=68, XOR=69, SHL=70, SHR=71, RDL=72, WRL=73, 
		SQR=74, SIN=75, COS=76, LN=77, EXP=78, PI=79, TRU=80, FLS=81, IDE=82, 
		INV=83, DBV=84, STV=85;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "DGT", "LTR", "A", "B", "C", "D", "E", 
			"F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", 
			"T", "U", "V", "W", "X", "Y", "Z", "WS", "COL", "SEM", "LPA", "RPA", 
			"COM", "DOT", "BOL", "INT", "REL", "CHR", "PTR", "ADR", "ENM", "SBR", 
			"ARR", "STR", "RCD", "SET", "BSE", "VRT", "UNI", "USE", "VAR", "CST", 
			"TYP", "PRM", "BGN", "END", "IF", "THN", "ELS", "CAS", "OF", "WHL", "FOR", 
			"DO", "RPT", "UTL", "FUN", "PRO", "ITR", "ADD", "SUB", "MUL", "DIV", 
			"MOD", "EQU", "NEQ", "GRT", "LES", "GEQ", "LEQ", "AND", "ATH", "OR", 
			"ORE", "NOT", "BND", "BOR", "BNT", "BOC", "BSL", "BSR", "XOR", "SHL", 
			"SHR", "RDL", "WRL", "SQR", "SIN", "COS", "LN", "EXP", "PI", "TRU", "FLS", 
			"IDE", "INV", "DBV", "STV"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*)'", "'['", "']'", "'..'", null, "':'", "';'", "'('", "')'", 
			"','", "'.'", null, null, null, null, "'^'", "'@'", null, "'...'", null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'='", "'<>'", "'>'", 
			"'<'", "'>='", "'<='", null, null, null, null, null, "'&'", "'|'", "'!'", 
			"'~'", "'<<'", "'>>'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "WS", "COL", "SEM", "LPA", "RPA", "COM", 
			"DOT", "BOL", "INT", "REL", "CHR", "PTR", "ADR", "ENM", "SBR", "ARR", 
			"STR", "RCD", "SET", "BSE", "VRT", "UNI", "USE", "VAR", "CST", "TYP", 
			"PRM", "BGN", "END", "IF", "THN", "ELS", "CAS", "OF", "WHL", "FOR", "DO", 
			"RPT", "UTL", "FUN", "PRO", "ITR", "ADD", "SUB", "MUL", "DIV", "MOD", 
			"EQU", "NEQ", "GRT", "LES", "GEQ", "LEQ", "AND", "ATH", "OR", "ORE", 
			"NOT", "BND", "BOR", "BNT", "BOC", "BSL", "BSR", "XOR", "SHL", "SHR", 
			"RDL", "WRL", "SQR", "SIN", "COS", "LN", "EXP", "PI", "TRU", "FLS", "IDE", 
			"INV", "DBV", "STV"
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


	  public void throwE(String msg){
	    System.out.println(msg);
	    System.exit(1);
	  }

	  public void setVariable(String key, Object val){
	      if(this.variables.containsKey(key)){
	          Object v = val;
	          Object k = getVariable(key);
	          if(k instanceof Boolean && v instanceof Integer){
	            v = new Boolean((Integer)val >= 1);
	          }
	          if(v.getClass().equals(k.getClass())){
	            this.variables.replace(key, v);
	          }
	      }
	      else if (this.reserved.containsKey(key)){
	          Boolean isValid = new Boolean(false);
	          ArrayList<String> arr = this.enums.get(this.enumVariableType.get(key));
	          for(String s : arr){
	              if(s.equals(val)){
	                  isValid = new Boolean(true);
	                  break;
	              }
	          }
	          if(isValid = true){
	              this.reserved.replace(key, (String)val);
	          }
	          else{
	              this.throwE("Attempted to assign an enum of a different or undefined type.");
	          }
	      }
	      else if (this.constants.containsKey(key)){
	          this.throwE("Attempted to assign to a constant.");
	      }
	      else {
	          this.throwE("Undefined symbol.");
	      }
	  }

	  public Object getVariable(String key){
	     if(this.variables.containsKey(key)){
	        return this.variables.get(key);
	     }
	     else if(this.constants.containsKey(key)){
	        return this.constants.get(key);
	     }
	     else if(this.reserved.containsKey(key)){
	        return this.reserved.get(key);
	     }
	     else {
	        if(this.debug == true){
	            System.out.println("Checking if the identifier is an enum.");
	        }
	        if(key instanceof String){
	            for(HashMap.Entry<String, ArrayList<String>> anenum : this.enums.entrySet()){
	                for(String s : anenum.getValue()){
	                    if(s.equals((String)key)){
	                        return key;
	                    }
	                }
	            }
	        }
	        this.throwE("Undefined symbol.");
	        return null;
	     }
	  }

	  Boolean debug = new Boolean(false);
	  Boolean toggle = new Boolean(false);

	  Stack<Boolean> branchHistory = new Stack<Boolean>();

	  Boolean breakCase = new Boolean(false);
	  Object caseSel;

	  HashMap<String,Object> variables = new HashMap<String,Object>();
	  HashMap<String,Object> constants = new HashMap<String,Object>();
	  HashMap<String,ArrayList<String>> enums = new HashMap<String,ArrayList<String>>();

	  HashMap<String,String> enumVariableType = new HashMap<String,String>();
	  HashMap<String,String> reserved = new HashMap<String,String>();


	public PascalRLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PascalR.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2W\u02ab\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\3\2\3\2\3\2\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\6\""+
		"\u0129\n\"\r\"\16\"\u012a\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3"+
		"(\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3,\3"+
		",\3,\3,\3,\3,\3,\3,\3,\3,\3-\3-\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3"+
		"\60\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3"+
		"\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3"+
		"\67\3\67\3\67\3\67\38\38\38\38\38\39\39\39\39\3:\3:\3:\3:\3:\3:\3;\3;"+
		"\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3?\3?"+
		"\3?\3@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3C\3C\3C\3D\3D\3D\3D"+
		"\3D\3D\3E\3E\3E\3E\3F\3F\3F\3G\3G\3G\3G\3G\3G\3G\3H\3H\3H\3H\3H\3H\3I"+
		"\3I\3I\3I\3I\3I\3I\3I\3I\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3J\3K\3K\3K\3K"+
		"\3K\3K\3K\3K\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3R\3S\3S"+
		"\3T\3T\3U\3U\3U\3V\3V\3V\3W\3W\3W\3W\3X\3X\3X\3X\3X\3X\3X\3X\3X\3Y\3Y"+
		"\3Y\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3[\3[\3[\3[\3\\\3\\\3]\3]\3^\3^\3_\3_\3`\3"+
		"`\3`\3a\3a\3a\3b\3b\3b\3b\3c\3c\3c\3c\3d\3d\3d\3d\3e\3e\3e\3e\3e\3e\3"+
		"e\3f\3f\3f\3f\3f\3f\3f\3f\3g\3g\3g\3g\3g\3h\3h\3h\3h\3i\3i\3i\3i\3j\3"+
		"j\3j\3k\3k\3k\3k\3l\3l\3l\3m\3m\3m\3m\3m\3n\3n\3n\3n\3n\3n\3o\7o\u0288"+
		"\no\fo\16o\u028b\13o\3o\3o\3o\3o\7o\u0291\no\fo\16o\u0294\13o\3p\6p\u0297"+
		"\np\rp\16p\u0298\3q\7q\u029c\nq\fq\16q\u029f\13q\3q\3q\3q\3r\3r\6r\u02a6"+
		"\nr\rr\16r\u02a7\3r\3r\2\2s\3\3\5\4\7\5\t\6\13\2\r\2\17\2\21\2\23\2\25"+
		"\2\27\2\31\2\33\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67"+
		"\29\2;\2=\2?\2A\2C\7E\bG\tI\nK\13M\fO\rQ\16S\17U\20W\21Y\22[\23]\24_\25"+
		"a\26c\27e\30g\31i\32k\33m\34o\35q\36s\37u w!y\"{#}$\177%\u0081&\u0083"+
		"\'\u0085(\u0087)\u0089*\u008b+\u008d,\u008f-\u0091.\u0093/\u0095\60\u0097"+
		"\61\u0099\62\u009b\63\u009d\64\u009f\65\u00a1\66\u00a3\67\u00a58\u00a7"+
		"9\u00a9:\u00ab;\u00ad<\u00af=\u00b1>\u00b3?\u00b5@\u00b7A\u00b9B\u00bb"+
		"C\u00bdD\u00bfE\u00c1F\u00c3G\u00c5H\u00c7I\u00c9J\u00cbK\u00cdL\u00cf"+
		"M\u00d1N\u00d3O\u00d5P\u00d7Q\u00d9R\u00dbS\u00ddT\u00dfU\u00e1V\u00e3"+
		"W\3\2\"\5\2\62\62;;\u2015\u2015\4\2C\\c|\4\2CCcc\4\2DDdd\4\2EEee\4\2F"+
		"Fff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4"+
		"\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWw"+
		"w\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\5\2\13\f\17\17\"\"\3\2aa\3"+
		"\2\62;\3\2))\2\u0296\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2"+
		"i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3"+
		"\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081"+
		"\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2"+
		"\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093"+
		"\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2"+
		"\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5"+
		"\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2"+
		"\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7"+
		"\3\2\2\2\2\u00b9\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd\3\2\2\2\2\u00bf\3\2\2"+
		"\2\2\u00c1\3\2\2\2\2\u00c3\3\2\2\2\2\u00c5\3\2\2\2\2\u00c7\3\2\2\2\2\u00c9"+
		"\3\2\2\2\2\u00cb\3\2\2\2\2\u00cd\3\2\2\2\2\u00cf\3\2\2\2\2\u00d1\3\2\2"+
		"\2\2\u00d3\3\2\2\2\2\u00d5\3\2\2\2\2\u00d7\3\2\2\2\2\u00d9\3\2\2\2\2\u00db"+
		"\3\2\2\2\2\u00dd\3\2\2\2\2\u00df\3\2\2\2\2\u00e1\3\2\2\2\2\u00e3\3\2\2"+
		"\2\3\u00e5\3\2\2\2\5\u00e8\3\2\2\2\7\u00ea\3\2\2\2\t\u00ec\3\2\2\2\13"+
		"\u00ef\3\2\2\2\r\u00f1\3\2\2\2\17\u00f3\3\2\2\2\21\u00f5\3\2\2\2\23\u00f7"+
		"\3\2\2\2\25\u00f9\3\2\2\2\27\u00fb\3\2\2\2\31\u00fd\3\2\2\2\33\u00ff\3"+
		"\2\2\2\35\u0101\3\2\2\2\37\u0103\3\2\2\2!\u0105\3\2\2\2#\u0107\3\2\2\2"+
		"%\u0109\3\2\2\2\'\u010b\3\2\2\2)\u010d\3\2\2\2+\u010f\3\2\2\2-\u0111\3"+
		"\2\2\2/\u0113\3\2\2\2\61\u0115\3\2\2\2\63\u0117\3\2\2\2\65\u0119\3\2\2"+
		"\2\67\u011b\3\2\2\29\u011d\3\2\2\2;\u011f\3\2\2\2=\u0121\3\2\2\2?\u0123"+
		"\3\2\2\2A\u0125\3\2\2\2C\u0128\3\2\2\2E\u012e\3\2\2\2G\u0130\3\2\2\2I"+
		"\u0132\3\2\2\2K\u0134\3\2\2\2M\u0136\3\2\2\2O\u0138\3\2\2\2Q\u013a\3\2"+
		"\2\2S\u0142\3\2\2\2U\u014a\3\2\2\2W\u014f\3\2\2\2Y\u0159\3\2\2\2[\u015b"+
		"\3\2\2\2]\u015d\3\2\2\2_\u0162\3\2\2\2a\u0166\3\2\2\2c\u016c\3\2\2\2e"+
		"\u0173\3\2\2\2g\u017a\3\2\2\2i\u0181\3\2\2\2k\u0186\3\2\2\2m\u018e\3\2"+
		"\2\2o\u0193\3\2\2\2q\u0198\3\2\2\2s\u019c\3\2\2\2u\u01a2\3\2\2\2w\u01a7"+
		"\3\2\2\2y\u01af\3\2\2\2{\u01b5\3\2\2\2}\u01b9\3\2\2\2\177\u01bc\3\2\2"+
		"\2\u0081\u01c1\3\2\2\2\u0083\u01c6\3\2\2\2\u0085\u01cb\3\2\2\2\u0087\u01ce"+
		"\3\2\2\2\u0089\u01d4\3\2\2\2\u008b\u01d8\3\2\2\2\u008d\u01db\3\2\2\2\u008f"+
		"\u01e2\3\2\2\2\u0091\u01e8\3\2\2\2\u0093\u01f1\3\2\2\2\u0095\u01fc\3\2"+
		"\2\2\u0097\u0206\3\2\2\2\u0099\u0208\3\2\2\2\u009b\u020a\3\2\2\2\u009d"+
		"\u020c\3\2\2\2\u009f\u020e\3\2\2\2\u00a1\u0210\3\2\2\2\u00a3\u0212\3\2"+
		"\2\2\u00a5\u0215\3\2\2\2\u00a7\u0217\3\2\2\2\u00a9\u0219\3\2\2\2\u00ab"+
		"\u021c\3\2\2\2\u00ad\u021f\3\2\2\2\u00af\u0223\3\2\2\2\u00b1\u022c\3\2"+
		"\2\2\u00b3\u022f\3\2\2\2\u00b5\u0237\3\2\2\2\u00b7\u023b\3\2\2\2\u00b9"+
		"\u023d\3\2\2\2\u00bb\u023f\3\2\2\2\u00bd\u0241\3\2\2\2\u00bf\u0243\3\2"+
		"\2\2\u00c1\u0246\3\2\2\2\u00c3\u0249\3\2\2\2\u00c5\u024d\3\2\2\2\u00c7"+
		"\u0251\3\2\2\2\u00c9\u0255\3\2\2\2\u00cb\u025c\3\2\2\2\u00cd\u0264\3\2"+
		"\2\2\u00cf\u0269\3\2\2\2\u00d1\u026d\3\2\2\2\u00d3\u0271\3\2\2\2\u00d5"+
		"\u0274\3\2\2\2\u00d7\u0278\3\2\2\2\u00d9\u027b\3\2\2\2\u00db\u0280\3\2"+
		"\2\2\u00dd\u0289\3\2\2\2\u00df\u0296\3\2\2\2\u00e1\u029d\3\2\2\2\u00e3"+
		"\u02a3\3\2\2\2\u00e5\u00e6\7,\2\2\u00e6\u00e7\7+\2\2\u00e7\4\3\2\2\2\u00e8"+
		"\u00e9\7]\2\2\u00e9\6\3\2\2\2\u00ea\u00eb\7_\2\2\u00eb\b\3\2\2\2\u00ec"+
		"\u00ed\7\60\2\2\u00ed\u00ee\7\60\2\2\u00ee\n\3\2\2\2\u00ef\u00f0\t\2\2"+
		"\2\u00f0\f\3\2\2\2\u00f1\u00f2\t\3\2\2\u00f2\16\3\2\2\2\u00f3\u00f4\t"+
		"\4\2\2\u00f4\20\3\2\2\2\u00f5\u00f6\t\5\2\2\u00f6\22\3\2\2\2\u00f7\u00f8"+
		"\t\6\2\2\u00f8\24\3\2\2\2\u00f9\u00fa\t\7\2\2\u00fa\26\3\2\2\2\u00fb\u00fc"+
		"\t\b\2\2\u00fc\30\3\2\2\2\u00fd\u00fe\t\t\2\2\u00fe\32\3\2\2\2\u00ff\u0100"+
		"\t\n\2\2\u0100\34\3\2\2\2\u0101\u0102\t\13\2\2\u0102\36\3\2\2\2\u0103"+
		"\u0104\t\f\2\2\u0104 \3\2\2\2\u0105\u0106\t\r\2\2\u0106\"\3\2\2\2\u0107"+
		"\u0108\t\16\2\2\u0108$\3\2\2\2\u0109\u010a\t\17\2\2\u010a&\3\2\2\2\u010b"+
		"\u010c\t\20\2\2\u010c(\3\2\2\2\u010d\u010e\t\21\2\2\u010e*\3\2\2\2\u010f"+
		"\u0110\t\22\2\2\u0110,\3\2\2\2\u0111\u0112\t\23\2\2\u0112.\3\2\2\2\u0113"+
		"\u0114\t\24\2\2\u0114\60\3\2\2\2\u0115\u0116\t\25\2\2\u0116\62\3\2\2\2"+
		"\u0117\u0118\t\26\2\2\u0118\64\3\2\2\2\u0119\u011a\t\27\2\2\u011a\66\3"+
		"\2\2\2\u011b\u011c\t\30\2\2\u011c8\3\2\2\2\u011d\u011e\t\31\2\2\u011e"+
		":\3\2\2\2\u011f\u0120\t\32\2\2\u0120<\3\2\2\2\u0121\u0122\t\33\2\2\u0122"+
		">\3\2\2\2\u0123\u0124\t\34\2\2\u0124@\3\2\2\2\u0125\u0126\t\35\2\2\u0126"+
		"B\3\2\2\2\u0127\u0129\t\36\2\2\u0128\u0127\3\2\2\2\u0129\u012a\3\2\2\2"+
		"\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d"+
		"\b\"\2\2\u012dD\3\2\2\2\u012e\u012f\7<\2\2\u012fF\3\2\2\2\u0130\u0131"+
		"\7=\2\2\u0131H\3\2\2\2\u0132\u0133\7*\2\2\u0133J\3\2\2\2\u0134\u0135\7"+
		"+\2\2\u0135L\3\2\2\2\u0136\u0137\7.\2\2\u0137N\3\2\2\2\u0138\u0139\7\60"+
		"\2\2\u0139P\3\2\2\2\u013a\u013b\5\21\t\2\u013b\u013c\5+\26\2\u013c\u013d"+
		"\5+\26\2\u013d\u013e\5%\23\2\u013e\u013f\5\27\f\2\u013f\u0140\5\17\b\2"+
		"\u0140\u0141\5)\25\2\u0141R\3\2\2\2\u0142\u0143\5\37\20\2\u0143\u0144"+
		"\5)\25\2\u0144\u0145\5\65\33\2\u0145\u0146\5\27\f\2\u0146\u0147\5\33\16"+
		"\2\u0147\u0148\5\27\f\2\u0148\u0149\5\61\31\2\u0149T\3\2\2\2\u014a\u014b"+
		"\5\61\31\2\u014b\u014c\5\27\f\2\u014c\u014d\5\17\b\2\u014d\u014e\5%\23"+
		"\2\u014eV\3\2\2\2\u014f\u0150\5\23\n\2\u0150\u0151\5\35\17\2\u0151\u0152"+
		"\5\17\b\2\u0152\u0153\5\61\31\2\u0153\u0154\5\17\b\2\u0154\u0155\5\23"+
		"\n\2\u0155\u0156\5\65\33\2\u0156\u0157\5\27\f\2\u0157\u0158\5\61\31\2"+
		"\u0158X\3\2\2\2\u0159\u015a\7`\2\2\u015aZ\3\2\2\2\u015b\u015c\7B\2\2\u015c"+
		"\\\3\2\2\2\u015d\u015e\5\27\f\2\u015e\u015f\5)\25\2\u015f\u0160\5\67\34"+
		"\2\u0160\u0161\5\'\24\2\u0161^\3\2\2\2\u0162\u0163\7\60\2\2\u0163\u0164"+
		"\7\60\2\2\u0164\u0165\7\60\2\2\u0165`\3\2\2\2\u0166\u0167\5\17\b\2\u0167"+
		"\u0168\5\61\31\2\u0168\u0169\5\61\31\2\u0169\u016a\5\17\b\2\u016a\u016b"+
		"\5? \2\u016bb\3\2\2\2\u016c\u016d\5\63\32\2\u016d\u016e\5\65\33\2\u016e"+
		"\u016f\5\61\31\2\u016f\u0170\5\37\20\2\u0170\u0171\5)\25\2\u0171\u0172"+
		"\5\33\16\2\u0172d\3\2\2\2\u0173\u0174\5\61\31\2\u0174\u0175\5\27\f\2\u0175"+
		"\u0176\5\23\n\2\u0176\u0177\5+\26\2\u0177\u0178\5\61\31\2\u0178\u0179"+
		"\5\25\13\2\u0179f\3\2\2\2\u017a\u017b\5\63\32\2\u017b\u017c\5\27\f\2\u017c"+
		"\u017d\5\65\33\2\u017d\u017e\7\"\2\2\u017e\u017f\5+\26\2\u017f\u0180\5"+
		"\31\r\2\u0180h\3\2\2\2\u0181\u0182\5\21\t\2\u0182\u0183\5\17\b\2\u0183"+
		"\u0184\5\63\32\2\u0184\u0185\5\27\f\2\u0185j\3\2\2\2\u0186\u0187\59\35"+
		"\2\u0187\u0188\5\17\b\2\u0188\u0189\5\61\31\2\u0189\u018a\5\37\20\2\u018a"+
		"\u018b\5\17\b\2\u018b\u018c\5)\25\2\u018c\u018d\5\65\33\2\u018dl\3\2\2"+
		"\2\u018e\u018f\5\67\34\2\u018f\u0190\5)\25\2\u0190\u0191\5\37\20\2\u0191"+
		"\u0192\5\65\33\2\u0192n\3\2\2\2\u0193\u0194\5\67\34\2\u0194\u0195\5\63"+
		"\32\2\u0195\u0196\5\27\f\2\u0196\u0197\5\63\32\2\u0197p\3\2\2\2\u0198"+
		"\u0199\59\35\2\u0199\u019a\5\17\b\2\u019a\u019b\5\61\31\2\u019br\3\2\2"+
		"\2\u019c\u019d\5\23\n\2\u019d\u019e\5+\26\2\u019e\u019f\5)\25\2\u019f"+
		"\u01a0\5\63\32\2\u01a0\u01a1\5\65\33\2\u01a1t\3\2\2\2\u01a2\u01a3\5\65"+
		"\33\2\u01a3\u01a4\5? \2\u01a4\u01a5\5-\27\2\u01a5\u01a6\5\27\f\2\u01a6"+
		"v\3\2\2\2\u01a7\u01a8\5-\27\2\u01a8\u01a9\5\61\31\2\u01a9\u01aa\5+\26"+
		"\2\u01aa\u01ab\5\33\16\2\u01ab\u01ac\5\61\31\2\u01ac\u01ad\5\17\b\2\u01ad"+
		"\u01ae\5\'\24\2\u01aex\3\2\2\2\u01af\u01b0\5\21\t\2\u01b0\u01b1\5\27\f"+
		"\2\u01b1\u01b2\5\33\16\2\u01b2\u01b3\5\37\20\2\u01b3\u01b4\5)\25\2\u01b4"+
		"z\3\2\2\2\u01b5\u01b6\5\27\f\2\u01b6\u01b7\5)\25\2\u01b7\u01b8\5\25\13"+
		"\2\u01b8|\3\2\2\2\u01b9\u01ba\5\37\20\2\u01ba\u01bb\5\31\r\2\u01bb~\3"+
		"\2\2\2\u01bc\u01bd\5\65\33\2\u01bd\u01be\5\35\17\2\u01be\u01bf\5\27\f"+
		"\2\u01bf\u01c0\5)\25\2\u01c0\u0080\3\2\2\2\u01c1\u01c2\5\27\f\2\u01c2"+
		"\u01c3\5%\23\2\u01c3\u01c4\5\63\32\2\u01c4\u01c5\5\27\f\2\u01c5\u0082"+
		"\3\2\2\2\u01c6\u01c7\5\23\n\2\u01c7\u01c8\5\17\b\2\u01c8\u01c9\5\63\32"+
		"\2\u01c9\u01ca\5\27\f\2\u01ca\u0084\3\2\2\2\u01cb\u01cc\5+\26\2\u01cc"+
		"\u01cd\5\31\r\2\u01cd\u0086\3\2\2\2\u01ce\u01cf\5;\36\2\u01cf\u01d0\5"+
		"\35\17\2\u01d0\u01d1\5\37\20\2\u01d1\u01d2\5%\23\2\u01d2\u01d3\5\27\f"+
		"\2\u01d3\u0088\3\2\2\2\u01d4\u01d5\5\31\r\2\u01d5\u01d6\5+\26\2\u01d6"+
		"\u01d7\5\61\31\2\u01d7\u008a\3\2\2\2\u01d8\u01d9\5\25\13\2\u01d9\u01da"+
		"\5+\26\2\u01da\u008c\3\2\2\2\u01db\u01dc\5\61\31\2\u01dc\u01dd\5\27\f"+
		"\2\u01dd\u01de\5-\27\2\u01de\u01df\5\27\f\2\u01df\u01e0\5\17\b\2\u01e0"+
		"\u01e1\5\65\33\2\u01e1\u008e\3\2\2\2\u01e2\u01e3\5\67\34\2\u01e3\u01e4"+
		"\5)\25\2\u01e4\u01e5\5\65\33\2\u01e5\u01e6\5\37\20\2\u01e6\u01e7\5%\23"+
		"\2\u01e7\u0090\3\2\2\2\u01e8\u01e9\5\31\r\2\u01e9\u01ea\5\67\34\2\u01ea"+
		"\u01eb\5)\25\2\u01eb\u01ec\5\23\n\2\u01ec\u01ed\5\65\33\2\u01ed\u01ee"+
		"\5\37\20\2\u01ee\u01ef\5+\26\2\u01ef\u01f0\5)\25\2\u01f0\u0092\3\2\2\2"+
		"\u01f1\u01f2\5-\27\2\u01f2\u01f3\5\61\31\2\u01f3\u01f4\5+\26\2\u01f4\u01f5"+
		"\5\23\n\2\u01f5\u01f6\5\27\f\2\u01f6\u01f7\5\25\13\2\u01f7\u01f8\5\67"+
		"\34\2\u01f8\u01f9\5\61\31\2\u01f9\u01fa\5\27\f\2\u01fa\u01fb\5\63\32\2"+
		"\u01fb\u0094\3\2\2\2\u01fc\u01fd\5\37\20\2\u01fd\u01fe\5)\25\2\u01fe\u01ff"+
		"\5\65\33\2\u01ff\u0200\5\27\f\2\u0200\u0201\5\61\31\2\u0201\u0202\5\31"+
		"\r\2\u0202\u0203\5\17\b\2\u0203\u0204\5\23\n\2\u0204\u0205\5\27\f\2\u0205"+
		"\u0096\3\2\2\2\u0206\u0207\7-\2\2\u0207\u0098\3\2\2\2\u0208\u0209\7/\2"+
		"\2\u0209\u009a\3\2\2\2\u020a\u020b\7,\2\2\u020b\u009c\3\2\2\2\u020c\u020d"+
		"\7\61\2\2\u020d\u009e\3\2\2\2\u020e\u020f\7\'\2\2\u020f\u00a0\3\2\2\2"+
		"\u0210\u0211\7?\2\2\u0211\u00a2\3\2\2\2\u0212\u0213\7>\2\2\u0213\u0214"+
		"\7@\2\2\u0214\u00a4\3\2\2\2\u0215\u0216\7@\2\2\u0216\u00a6\3\2\2\2\u0217"+
		"\u0218\7>\2\2\u0218\u00a8\3\2\2\2\u0219\u021a\7@\2\2\u021a\u021b\7?\2"+
		"\2\u021b\u00aa\3\2\2\2\u021c\u021d\7>\2\2\u021d\u021e\7?\2\2\u021e\u00ac"+
		"\3\2\2\2\u021f\u0220\5\17\b\2\u0220\u0221\5)\25\2\u0221\u0222\5\25\13"+
		"\2\u0222\u00ae\3\2\2\2\u0223\u0224\5\17\b\2\u0224\u0225\5)\25\2\u0225"+
		"\u0226\5\25\13\2\u0226\u0227\7\"\2\2\u0227\u0228\5\65\33\2\u0228\u0229"+
		"\5\35\17\2\u0229\u022a\5\27\f\2\u022a\u022b\5)\25\2\u022b\u00b0\3\2\2"+
		"\2\u022c\u022d\5+\26\2\u022d\u022e\5\61\31\2\u022e\u00b2\3\2\2\2\u022f"+
		"\u0230\5+\26\2\u0230\u0231\5\61\31\2\u0231\u0232\7\"\2\2\u0232\u0233\5"+
		"\27\f\2\u0233\u0234\5%\23\2\u0234\u0235\5\63\32\2\u0235\u0236\5\27\f\2"+
		"\u0236\u00b4\3\2\2\2\u0237\u0238\5)\25\2\u0238\u0239\5+\26\2\u0239\u023a"+
		"\5\65\33\2\u023a\u00b6\3\2\2\2\u023b\u023c\7(\2\2\u023c\u00b8\3\2\2\2"+
		"\u023d\u023e\7~\2\2\u023e\u00ba\3\2\2\2\u023f\u0240\7#\2\2\u0240\u00bc"+
		"\3\2\2\2\u0241\u0242\7\u0080\2\2\u0242\u00be\3\2\2\2\u0243\u0244\7>\2"+
		"\2\u0244\u0245\7>\2\2\u0245\u00c0\3\2\2\2\u0246\u0247\7@\2\2\u0247\u0248"+
		"\7@\2\2\u0248\u00c2\3\2\2\2\u0249\u024a\5=\37\2\u024a\u024b\5+\26\2\u024b"+
		"\u024c\5\61\31\2\u024c\u00c4\3\2\2\2\u024d\u024e\5\63\32\2\u024e\u024f"+
		"\5\35\17\2\u024f\u0250\5%\23\2\u0250\u00c6\3\2\2\2\u0251\u0252\5\63\32"+
		"\2\u0252\u0253\5\35\17\2\u0253\u0254\5\61\31\2\u0254\u00c8\3\2\2\2\u0255"+
		"\u0256\5\61\31\2\u0256\u0257\5\27\f\2\u0257\u0258\5\17\b\2\u0258\u0259"+
		"\5\25\13\2\u0259\u025a\5%\23\2\u025a\u025b\5)\25\2\u025b\u00ca\3\2\2\2"+
		"\u025c\u025d\5;\36\2\u025d\u025e\5\61\31\2\u025e\u025f\5\37\20\2\u025f"+
		"\u0260\5\65\33\2\u0260\u0261\5\27\f\2\u0261\u0262\5%\23\2\u0262\u0263"+
		"\5)\25\2\u0263\u00cc\3\2\2\2\u0264\u0265\5\63\32\2\u0265\u0266\5/\30\2"+
		"\u0266\u0267\5\61\31\2\u0267\u0268\5\65\33\2\u0268\u00ce\3\2\2\2\u0269"+
		"\u026a\5\63\32\2\u026a\u026b\5\37\20\2\u026b\u026c\5)\25\2\u026c\u00d0"+
		"\3\2\2\2\u026d\u026e\5\23\n\2\u026e\u026f\5+\26\2\u026f\u0270\5\63\32"+
		"\2\u0270\u00d2\3\2\2\2\u0271\u0272\5%\23\2\u0272\u0273\5)\25\2\u0273\u00d4"+
		"\3\2\2\2\u0274\u0275\5\27\f\2\u0275\u0276\5=\37\2\u0276\u0277\5-\27\2"+
		"\u0277\u00d6\3\2\2\2\u0278\u0279\5-\27\2\u0279\u027a\5\37\20\2\u027a\u00d8"+
		"\3\2\2\2\u027b\u027c\5\65\33\2\u027c\u027d\5\61\31\2\u027d\u027e\5\67"+
		"\34\2\u027e\u027f\5\27\f\2\u027f\u00da\3\2\2\2\u0280\u0281\5\31\r\2\u0281"+
		"\u0282\5\17\b\2\u0282\u0283\5%\23\2\u0283\u0284\5\63\32\2\u0284\u0285"+
		"\5\27\f\2\u0285\u00dc\3\2\2\2\u0286\u0288\t\37\2\2\u0287\u0286\3\2\2\2"+
		"\u0288\u028b\3\2\2\2\u0289\u0287\3\2\2\2\u0289\u028a\3\2\2\2\u028a\u028c"+
		"\3\2\2\2\u028b\u0289\3\2\2\2\u028c\u0292\5\r\7\2\u028d\u0291\t\37\2\2"+
		"\u028e\u0291\5\r\7\2\u028f\u0291\5\13\6\2\u0290\u028d\3\2\2\2\u0290\u028e"+
		"\3\2\2\2\u0290\u028f\3\2\2\2\u0291\u0294\3\2\2\2\u0292\u0290\3\2\2\2\u0292"+
		"\u0293\3\2\2\2\u0293\u00de\3\2\2\2\u0294\u0292\3\2\2\2\u0295\u0297\t "+
		"\2\2\u0296\u0295\3\2\2\2\u0297\u0298\3\2\2\2\u0298\u0296\3\2\2\2\u0298"+
		"\u0299\3\2\2\2\u0299\u00e0\3\2\2\2\u029a\u029c\t \2\2\u029b\u029a\3\2"+
		"\2\2\u029c\u029f\3\2\2\2\u029d\u029b\3\2\2\2\u029d\u029e\3\2\2\2\u029e"+
		"\u02a0\3\2\2\2\u029f\u029d\3\2\2\2\u02a0\u02a1\7\60\2\2\u02a1\u02a2\5"+
		"\u00dfp\2\u02a2\u00e2\3\2\2\2\u02a3\u02a5\7)\2\2\u02a4\u02a6\n!\2\2\u02a5"+
		"\u02a4\3\2\2\2\u02a6\u02a7\3\2\2\2\u02a7\u02a5\3\2\2\2\u02a7\u02a8\3\2"+
		"\2\2\u02a8\u02a9\3\2\2\2\u02a9\u02aa\7)\2\2\u02aa\u00e4\3\2\2\2\n\2\u012a"+
		"\u0289\u0290\u0292\u0298\u029d\u02a7\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}