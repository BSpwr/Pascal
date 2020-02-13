// Generated from /Users/Faux/IdeaProjects/Pascal/src/PascalR.g4 by ANTLR 4.8

  import java.io.*;
  import java.util.*;
  import java.util.stream.IntStream;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PascalRParser extends Parser {
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
	public static final int
		RULE_debug = 0, RULE_program = 1, RULE_programHeading = 2, RULE_programImports = 3, 
		RULE_identifier = 4, RULE_identifierList = 5, RULE_block = 6, RULE_comment = 7, 
		RULE_typeLab = 8, RULE_varLab = 9, RULE_constLab = 10, RULE_progLab = 11, 
		RULE_typeDef = 12, RULE_typeType = 13, RULE_varDef = 14, RULE_varList = 15, 
		RULE_varType = 16, RULE_arrayAlloc = 17, RULE_range = 18, RULE_constDef = 19, 
		RULE_implementation = 20, RULE_singleStatement = 21, RULE_branch = 22, 
		RULE_cases = 23, RULE_caseList = 24, RULE_caseStatement = 25, RULE_elseCase = 26, 
		RULE_assignment = 27, RULE_args = 28, RULE_writeln = 29, RULE_writelnFunc = 30, 
		RULE_readln = 31, RULE_readlnFunc = 32, RULE_sqrt = 33, RULE_ln = 34, 
		RULE_exp = 35, RULE_sine = 36, RULE_cosine = 37, RULE_expr = 38, RULE_string = 39;
	private static String[] makeRuleNames() {
		return new String[] {
			"debug", "program", "programHeading", "programImports", "identifier", 
			"identifierList", "block", "comment", "typeLab", "varLab", "constLab", 
			"progLab", "typeDef", "typeType", "varDef", "varList", "varType", "arrayAlloc", 
			"range", "constDef", "implementation", "singleStatement", "branch", "cases", 
			"caseList", "caseStatement", "elseCase", "assignment", "args", "writeln", 
			"writelnFunc", "readln", "readlnFunc", "sqrt", "ln", "exp", "sine", "cosine", 
			"expr", "string"
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

	@Override
	public String getGrammarFileName() { return "PascalR.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public PascalRParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class DebugContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public DebugContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_debug; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterDebug(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitDebug(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitDebug(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DebugContext debug() throws RecognitionException {
		DebugContext _localctx = new DebugContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_debug);
		try {
			enterOuterAlt(_localctx, 1);
			{
			debug = new Boolean(true);
			setState(81);
			program();
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

	public static class ProgramContext extends ParserRuleContext {
		public ProgramHeadingContext programHeading() {
			return getRuleContext(ProgramHeadingContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PascalRParser.DOT, 0); }
		public TerminalNode EOF() { return getToken(PascalRParser.EOF, 0); }
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public TerminalNode ITR() { return getToken(PascalRParser.ITR, 0); }
		public ProgramImportsContext programImports() {
			return getRuleContext(ProgramImportsContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPA) {
				{
				setState(83);
				comment();
				}
			}

			setState(86);
			programHeading();
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(87);
				comment();
				}
				break;
			}
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ITR) {
				{
				setState(90);
				match(ITR);
				}
			}

			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(93);
				comment();
				}
				break;
			}
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==USE) {
				{
				setState(96);
				programImports();
				}
			}

			setState(99);
			block();
			setState(100);
			match(DOT);
			setState(101);
			match(EOF);
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

	public static class ProgramHeadingContext extends ParserRuleContext {
		public Boolean b;
		public String s;
		public TerminalNode PRM() { return getToken(PascalRParser.PRM, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEM() { return getToken(PascalRParser.SEM, 0); }
		public TerminalNode LPA() { return getToken(PascalRParser.LPA, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode RPA() { return getToken(PascalRParser.RPA, 0); }
		public TerminalNode UNI() { return getToken(PascalRParser.UNI, 0); }
		public ProgramHeadingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programHeading; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterProgramHeading(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitProgramHeading(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitProgramHeading(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramHeadingContext programHeading() throws RecognitionException {
		ProgramHeadingContext _localctx = new ProgramHeadingContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_programHeading);
		int _la;
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRM:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(103);
				match(PRM);
				setState(104);
				identifier();
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPA) {
					{
					setState(105);
					match(LPA);
					setState(106);
					identifierList();
					setState(107);
					match(RPA);
					}
				}

				setState(111);
				match(SEM);
				}
				}
				break;
			case UNI:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(113);
				match(UNI);
				setState(114);
				identifier();
				}
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

	public static class ProgramImportsContext extends ParserRuleContext {
		public TerminalNode USE() { return getToken(PascalRParser.USE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SEM() { return getToken(PascalRParser.SEM, 0); }
		public ProgramImportsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programImports; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterProgramImports(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitProgramImports(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitProgramImports(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramImportsContext programImports() throws RecognitionException {
		ProgramImportsContext _localctx = new ProgramImportsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_programImports);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(USE);
			setState(118);
			identifier();
			setState(119);
			match(SEM);
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

	public static class IdentifierContext extends ParserRuleContext {
		public String s;
		public Token IDE;
		public TerminalNode IDE() { return getToken(PascalRParser.IDE, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			((IdentifierContext)_localctx).IDE = match(IDE);
			((IdentifierContext)_localctx).s =  (((IdentifierContext)_localctx).IDE!=null?((IdentifierContext)_localctx).IDE.getText():null);
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

	public static class IdentifierListContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COM() { return getTokens(PascalRParser.COM); }
		public TerminalNode COM(int i) {
			return getToken(PascalRParser.COM, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitIdentifierList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitIdentifierList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_identifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			identifier();
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COM) {
				{
				{
				setState(125);
				match(COM);
				setState(126);
				identifier();
				}
				}
				setState(131);
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

	public static class BlockContext extends ParserRuleContext {
		public List<CommentContext> comment() {
			return getRuleContexts(CommentContext.class);
		}
		public CommentContext comment(int i) {
			return getRuleContext(CommentContext.class,i);
		}
		public TypeLabContext typeLab() {
			return getRuleContext(TypeLabContext.class,0);
		}
		public List<ProgLabContext> progLab() {
			return getRuleContexts(ProgLabContext.class);
		}
		public ProgLabContext progLab(int i) {
			return getRuleContext(ProgLabContext.class,i);
		}
		public VarLabContext varLab() {
			return getRuleContext(VarLabContext.class,0);
		}
		public ConstLabContext constLab() {
			return getRuleContext(ConstLabContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(132);
				comment();
				}
				break;
			}
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYP) {
				{
				setState(135);
				typeLab();
				}
			}

			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPA) {
				{
				setState(138);
				comment();
				}
			}

			setState(155);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				{
				{
				setState(141);
				varLab();
				setState(143);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(142);
					comment();
					}
					break;
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CST) {
					{
					setState(145);
					constLab();
					}
				}

				}
				}
				break;
			case CST:
				{
				{
				setState(148);
				constLab();
				setState(150);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(149);
					comment();
					}
					break;
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VAR) {
					{
					setState(152);
					varLab();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BGN) {
				{
				{
				setState(157);
				progLab();
				}
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPA) {
				{
				setState(163);
				comment();
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

	public static class CommentContext extends ParserRuleContext {
		public TerminalNode LPA() { return getToken(PascalRParser.LPA, 0); }
		public TerminalNode MUL() { return getToken(PascalRParser.MUL, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_comment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(LPA);
			setState(167);
			match(MUL);
			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << WS) | (1L << COL) | (1L << SEM) | (1L << LPA) | (1L << RPA) | (1L << COM) | (1L << DOT) | (1L << BOL) | (1L << INT) | (1L << REL) | (1L << CHR) | (1L << PTR) | (1L << ADR) | (1L << ENM) | (1L << SBR) | (1L << ARR) | (1L << STR) | (1L << RCD) | (1L << SET) | (1L << BSE) | (1L << VRT) | (1L << UNI) | (1L << USE) | (1L << VAR) | (1L << CST) | (1L << TYP) | (1L << PRM) | (1L << BGN) | (1L << END) | (1L << IF) | (1L << THN) | (1L << ELS) | (1L << CAS) | (1L << OF) | (1L << WHL) | (1L << FOR) | (1L << DO) | (1L << RPT) | (1L << UTL) | (1L << FUN) | (1L << PRO) | (1L << ITR) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MOD) | (1L << EQU) | (1L << NEQ) | (1L << GRT) | (1L << LES) | (1L << GEQ) | (1L << LEQ) | (1L << AND) | (1L << ATH) | (1L << OR) | (1L << ORE) | (1L << NOT) | (1L << BND))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (BOR - 64)) | (1L << (BNT - 64)) | (1L << (BOC - 64)) | (1L << (BSL - 64)) | (1L << (BSR - 64)) | (1L << (XOR - 64)) | (1L << (SHL - 64)) | (1L << (SHR - 64)) | (1L << (RDL - 64)) | (1L << (WRL - 64)) | (1L << (SQR - 64)) | (1L << (SIN - 64)) | (1L << (COS - 64)) | (1L << (LN - 64)) | (1L << (EXP - 64)) | (1L << (PI - 64)) | (1L << (TRU - 64)) | (1L << (FLS - 64)) | (1L << (IDE - 64)) | (1L << (INV - 64)) | (1L << (DBV - 64)) | (1L << (STV - 64)))) != 0)) {
				{
				{
				setState(168);
				_la = _input.LA(1);
				if ( _la <= 0 || (_la==T__0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(173);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(174);
			match(T__0);
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

	public static class TypeLabContext extends ParserRuleContext {
		public TerminalNode TYP() { return getToken(PascalRParser.TYP, 0); }
		public TypeDefContext typeDef() {
			return getRuleContext(TypeDefContext.class,0);
		}
		public TypeLabContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeLab; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterTypeLab(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitTypeLab(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitTypeLab(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeLabContext typeLab() throws RecognitionException {
		TypeLabContext _localctx = new TypeLabContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typeLab);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(TYP);
			setState(177);
			typeDef();
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

	public static class VarLabContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(PascalRParser.VAR, 0); }
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public VarLabContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varLab; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterVarLab(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitVarLab(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitVarLab(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarLabContext varLab() throws RecognitionException {
		VarLabContext _localctx = new VarLabContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varLab);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(VAR);
			setState(180);
			varDef();
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

	public static class ConstLabContext extends ParserRuleContext {
		public TerminalNode CST() { return getToken(PascalRParser.CST, 0); }
		public ConstDefContext constDef() {
			return getRuleContext(ConstDefContext.class,0);
		}
		public ConstLabContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constLab; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterConstLab(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitConstLab(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitConstLab(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstLabContext constLab() throws RecognitionException {
		ConstLabContext _localctx = new ConstLabContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_constLab);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(CST);
			setState(183);
			constDef();
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

	public static class ProgLabContext extends ParserRuleContext {
		public TerminalNode BGN() { return getToken(PascalRParser.BGN, 0); }
		public TerminalNode END() { return getToken(PascalRParser.END, 0); }
		public List<ImplementationContext> implementation() {
			return getRuleContexts(ImplementationContext.class);
		}
		public ImplementationContext implementation(int i) {
			return getRuleContext(ImplementationContext.class,i);
		}
		public ProgLabContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_progLab; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterProgLab(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitProgLab(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitProgLab(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgLabContext progLab() throws RecognitionException {
		ProgLabContext _localctx = new ProgLabContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_progLab);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(BGN);

			    if( this.debug == true){
			        System.out.println("Begin Program");
			    }

			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(187);
					implementation();
					}
					} 
				}
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(193);
			match(END);

			    if( this.debug == true){
			        System.out.println("End Program");
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

	public static class TypeDefContext extends ParserRuleContext {
		public IdentifierContext identifier;
		public TypeTypeContext typeType;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode EQU() { return getToken(PascalRParser.EQU, 0); }
		public TerminalNode LPA() { return getToken(PascalRParser.LPA, 0); }
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode RPA() { return getToken(PascalRParser.RPA, 0); }
		public TerminalNode SEM() { return getToken(PascalRParser.SEM, 0); }
		public TypeDefContext typeDef() {
			return getRuleContext(TypeDefContext.class,0);
		}
		public TypeDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterTypeDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitTypeDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitTypeDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDefContext typeDef() throws RecognitionException {
		TypeDefContext _localctx = new TypeDefContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_typeDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			((TypeDefContext)_localctx).identifier = identifier();
			setState(197);
			match(EQU);
			setState(198);
			match(LPA);
			setState(199);
			((TypeDefContext)_localctx).typeType = typeType();
			setState(200);
			match(RPA);
			setState(201);
			match(SEM);
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDE) {
				{
				setState(202);
				typeDef();
				}
			}


			        this.enums.put(((TypeDefContext)_localctx).identifier.s, ((TypeDefContext)_localctx).typeType.s);
			        //print out the variable map
			        if( this.debug == true){
			            for(HashMap.Entry<String, ArrayList<String>> anenum : this.enums.entrySet()){
			                System.out.println("\tType:" + anenum.getKey());
			                for(String s : anenum.getValue()){
			                    System.out.println("\tValue:" + s);
			                }
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

	public static class TypeTypeContext extends ParserRuleContext {
		public ArrayList<String> s;
		public IdentifierContext identifier;
		public TypeTypeContext typeType;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COM() { return getToken(PascalRParser.COM, 0); }
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TypeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterTypeType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitTypeType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitTypeType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeTypeContext typeType() throws RecognitionException {
		TypeTypeContext _localctx = new TypeTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_typeType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			((TypeTypeContext)_localctx).identifier = identifier();

			        ((TypeTypeContext)_localctx).s =  new ArrayList<String>();
			        _localctx.s.add(((TypeTypeContext)_localctx).identifier.s);
			    
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COM) {
				{
				setState(209);
				match(COM);
				setState(210);
				((TypeTypeContext)_localctx).typeType = typeType();

				        _localctx.s.addAll(((TypeTypeContext)_localctx).typeType.s);
				    
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

	public static class VarDefContext extends ParserRuleContext {
		public VarListContext varList;
		public VarTypeContext varType;
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public TerminalNode COL() { return getToken(PascalRParser.COL, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode SEM() { return getToken(PascalRParser.SEM, 0); }
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_varDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			((VarDefContext)_localctx).varList = varList();
			setState(216);
			match(COL);
			setState(217);
			((VarDefContext)_localctx).varType = varType();
			setState(218);
			match(SEM);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDE) {
				{
				setState(219);
				varDef();
				}
			}


			        if(((VarDefContext)_localctx).varType.o instanceof String && !(((String)((VarDefContext)_localctx).varType.o).isEmpty())){
			            this.enumVariableType.putAll(IntStream.range(0, ((VarDefContext)_localctx).varList.s.size())
			                                            .collect(HashMap::new,
			                                            (map, i) -> map.put(((VarDefContext)_localctx).varList.s.get(i), (String)((VarDefContext)_localctx).varType.o),
			                                            Map::putAll));
			            this.reserved.putAll(IntStream.range(0, ((VarDefContext)_localctx).varList.s.size())
			                                   .collect(HashMap::new,
			                                   (map, i) -> map.put(((VarDefContext)_localctx).varList.s.get(i), (String)((VarDefContext)_localctx).varType.o),
			                                   Map::putAll));
			        }
			        else{
			            this.variables.putAll(IntStream.range(0, ((VarDefContext)_localctx).varList.s.size())
			                                   .collect(HashMap::new,
			                                   (map, i) -> map.put(((VarDefContext)_localctx).varList.s.get(i), ((VarDefContext)_localctx).varType.o),
			                                   Map::putAll));
			        }
			        //print out the variable map
			        if( this.debug == true){
			            System.out.println("VARs defined:");
			            ArrayList<String> varNames = ((VarDefContext)_localctx).varList.s;
			            for(int i = 0; i < varNames.size(); i++){
			                System.out.println("\tIdentifier:" + varNames.get(i));
			                System.out.println("\tValue:" + this.variables.get(varNames.get(i)));
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

	public static class VarListContext extends ParserRuleContext {
		public ArrayList<String> s;
		public IdentifierContext identifier;
		public VarListContext varList;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COM() { return getToken(PascalRParser.COM, 0); }
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public VarListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterVarList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitVarList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitVarList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarListContext varList() throws RecognitionException {
		VarListContext _localctx = new VarListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_varList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			((VarListContext)_localctx).identifier = identifier();

			       ((VarListContext)_localctx).s =  new ArrayList<String>();
			       _localctx.s.add(((VarListContext)_localctx).identifier.s);
			    
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COM) {
				{
				setState(226);
				match(COM);
				setState(227);
				((VarListContext)_localctx).varList = varList();

				       _localctx.s.addAll(((VarListContext)_localctx).varList.s);
				    
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

	public static class VarTypeContext extends ParserRuleContext {
		public Object o;
		public ArrayAllocContext arrayAlloc;
		public IdentifierContext identifier;
		public TerminalNode INT() { return getToken(PascalRParser.INT, 0); }
		public TerminalNode REL() { return getToken(PascalRParser.REL, 0); }
		public TerminalNode BOL() { return getToken(PascalRParser.BOL, 0); }
		public TerminalNode CHR() { return getToken(PascalRParser.CHR, 0); }
		public TerminalNode STR() { return getToken(PascalRParser.STR, 0); }
		public ArrayAllocContext arrayAlloc() {
			return getRuleContext(ArrayAllocContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode INV() { return getToken(PascalRParser.INV, 0); }
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterVarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitVarType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitVarType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(232);
				match(INT);

				            ((VarTypeContext)_localctx).o =  new Integer(0);
				        
				}
				break;
			case REL:
				{
				setState(234);
				match(REL);

				            ((VarTypeContext)_localctx).o =  new Double(0);
				        
				}
				break;
			case BOL:
				{
				setState(236);
				match(BOL);

				            ((VarTypeContext)_localctx).o =  new Boolean(false);
				        
				}
				break;
			case CHR:
				{
				setState(238);
				match(CHR);

				            ((VarTypeContext)_localctx).o =  new Character('\0');
				        
				}
				break;
			case STR:
				{
				setState(240);
				match(STR);
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(241);
					match(T__1);
					setState(242);
					match(INV);
					setState(243);
					match(T__2);
					}
				}


				            ((VarTypeContext)_localctx).o =  new String();
				        
				}
				break;
			case ARR:
				{
				setState(247);
				((VarTypeContext)_localctx).arrayAlloc = arrayAlloc();

				            ((VarTypeContext)_localctx).o =  ((VarTypeContext)_localctx).arrayAlloc.o;
				        
				}
				break;
			case IDE:
				{
				setState(250);
				((VarTypeContext)_localctx).identifier = identifier();

				            if(this.enums.containsKey(((VarTypeContext)_localctx).identifier.s)){
				                ((VarTypeContext)_localctx).o =  ((VarTypeContext)_localctx).identifier.s;
				            }
				            else {
				                ((VarTypeContext)_localctx).o =  null;
				            }
				        
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

	public static class ArrayAllocContext extends ParserRuleContext {
		public ArrayList<Object> o;
		public RangeContext range;
		public VarTypeContext varType;
		public TerminalNode ARR() { return getToken(PascalRParser.ARR, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public TerminalNode OF() { return getToken(PascalRParser.OF, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public ArrayAllocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAlloc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterArrayAlloc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitArrayAlloc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitArrayAlloc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAllocContext arrayAlloc() throws RecognitionException {
		ArrayAllocContext _localctx = new ArrayAllocContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arrayAlloc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(ARR);
			setState(256);
			match(T__1);
			setState(257);
			((ArrayAllocContext)_localctx).range = range();
			setState(258);
			match(T__2);
			setState(259);
			match(OF);
			setState(260);
			((ArrayAllocContext)_localctx).varType = varType();

			        if(((ArrayAllocContext)_localctx).range.l instanceof Integer && ((ArrayAllocContext)_localctx).range.h instanceof Integer){
			            Integer length = (Integer)((ArrayAllocContext)_localctx).range.h - (Integer)((ArrayAllocContext)_localctx).range.l;
			            ((ArrayAllocContext)_localctx).o =  new ArrayList<Object>(length + 1);
			            _localctx.o.add(length);
			            for(int i = 0; i < length; i++){
			                _localctx.o.add(((ArrayAllocContext)_localctx).varType.o);
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

	public static class RangeContext extends ParserRuleContext {
		public Object l;
		public Object h;
		public Token low;
		public Token hi;
		public List<TerminalNode> INV() { return getTokens(PascalRParser.INV); }
		public TerminalNode INV(int i) {
			return getToken(PascalRParser.INV, i);
		}
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			((RangeContext)_localctx).low = match(INV);
			setState(264);
			match(T__3);
			setState(265);
			((RangeContext)_localctx).hi = match(INV);

			        ((RangeContext)_localctx).l =  ((RangeContext)_localctx).low;
			        ((RangeContext)_localctx).h =  ((RangeContext)_localctx).hi;
			    
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

	public static class ConstDefContext extends ParserRuleContext {
		public VarListContext varList;
		public ExprContext expr;
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public TerminalNode EQU() { return getToken(PascalRParser.EQU, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEM() { return getToken(PascalRParser.SEM, 0); }
		public ConstDefContext constDef() {
			return getRuleContext(ConstDefContext.class,0);
		}
		public ConstDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterConstDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitConstDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitConstDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDefContext constDef() throws RecognitionException {
		ConstDefContext _localctx = new ConstDefContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_constDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			((ConstDefContext)_localctx).varList = varList();
			setState(269);
			match(EQU);
			setState(270);
			((ConstDefContext)_localctx).expr = expr(0);
			setState(271);
			match(SEM);

			        this.constants.putAll(IntStream.range(0, ((ConstDefContext)_localctx).varList.s.size())
			                               .collect(HashMap::new,
			                               (map, i) -> map.put(((ConstDefContext)_localctx).varList.s.get(i), ((ConstDefContext)_localctx).expr.o),
			                               Map::putAll));
			        //Print out constants from hashmap
			        if( this.debug == true){
			            System.out.println("CONSTs defined:");
			            ArrayList<String> varNames = ((ConstDefContext)_localctx).varList.s;
			            for(int i = 0; i < varNames.size(); i++){
			                System.out.println("\tIdentifier:" + varNames.get(i));
			                System.out.println("\tValue:" + this.constants.get(varNames.get(i)));
			            }
			        }
			    
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDE) {
				{
				setState(273);
				constDef();
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

	public static class ImplementationContext extends ParserRuleContext {
		public BranchContext branch() {
			return getRuleContext(BranchContext.class,0);
		}
		public CasesContext cases() {
			return getRuleContext(CasesContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public SingleStatementContext singleStatement() {
			return getRuleContext(SingleStatementContext.class,0);
		}
		public TerminalNode SEM() { return getToken(PascalRParser.SEM, 0); }
		public ImplementationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implementation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterImplementation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitImplementation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitImplementation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImplementationContext implementation() throws RecognitionException {
		ImplementationContext _localctx = new ImplementationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_implementation);
		try {
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				branch();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(277);
				cases();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(278);
				comment();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(279);
				singleStatement();
				setState(280);
				match(SEM);
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

	public static class SingleStatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WritelnContext writeln() {
			return getRuleContext(WritelnContext.class,0);
		}
		public ReadlnContext readln() {
			return getRuleContext(ReadlnContext.class,0);
		}
		public SingleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterSingleStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitSingleStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitSingleStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleStatementContext singleStatement() throws RecognitionException {
		SingleStatementContext _localctx = new SingleStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_singleStatement);
		try {
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(286);
				writeln();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(287);
				readln();
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

	public static class BranchContext extends ParserRuleContext {
		public ExprContext expr;
		public TerminalNode IF() { return getToken(PascalRParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THN() { return getToken(PascalRParser.THN, 0); }
		public SingleStatementContext singleStatement() {
			return getRuleContext(SingleStatementContext.class,0);
		}
		public TerminalNode SEM() { return getToken(PascalRParser.SEM, 0); }
		public ElseCaseContext elseCase() {
			return getRuleContext(ElseCaseContext.class,0);
		}
		public TerminalNode BGN() { return getToken(PascalRParser.BGN, 0); }
		public TerminalNode END() { return getToken(PascalRParser.END, 0); }
		public List<ImplementationContext> implementation() {
			return getRuleContexts(ImplementationContext.class);
		}
		public ImplementationContext implementation(int i) {
			return getRuleContext(ImplementationContext.class,i);
		}
		public BranchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_branch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterBranch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitBranch(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitBranch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BranchContext branch() throws RecognitionException {
		BranchContext _localctx = new BranchContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_branch);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(IF);
			setState(291);
			((BranchContext)_localctx).expr = expr(0);

			        this.branchHistory.push(this.toggle);
			        if(this.toggle != true){
			            this.toggle = new Boolean(!(Boolean)((BranchContext)_localctx).expr.o);
			            if( this.debug == true){
			                System.out.println("Pushed to the stack.\nStack contains: ");
			                for(Boolean b : this.branchHistory){
			                    System.out.println(b + "\n");
			                }
			            }
			        }
			    
			setState(293);
			match(THN);

			        if( this.debug == true){
			            System.out.println("Entering inner case.");
			        }
			    
			setState(304);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				{
				setState(295);
				match(BGN);
				setState(299);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(296);
						implementation();
						}
						} 
					}
					setState(301);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				setState(302);
				match(END);
				}
				}
				break;
			case 2:
				{
				setState(303);
				singleStatement();
				}
				break;
			}
			this.toggle = new Boolean(!this.toggle);
			setState(310);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEM:
				{
				setState(307);
				match(SEM);

				        if( this.debug == true){
				            System.out.println("Exiting inner case.");
				        }
				    
				}
				break;
			case ELS:
				{
				setState(309);
				elseCase();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			        this.toggle = new Boolean(this.branchHistory.pop());
			        if( this.debug == true){
			            System.out.println("Popped from the stack.\nStack contains: ");
			            for(Boolean b : this.branchHistory){
			                System.out.println(b + "\n");
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

	public static class CasesContext extends ParserRuleContext {
		public ExprContext expr;
		public TerminalNode CAS() { return getToken(PascalRParser.CAS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode OF() { return getToken(PascalRParser.OF, 0); }
		public CaseListContext caseList() {
			return getRuleContext(CaseListContext.class,0);
		}
		public CasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cases; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterCases(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitCases(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitCases(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CasesContext cases() throws RecognitionException {
		CasesContext _localctx = new CasesContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_cases);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			match(CAS);
			setState(315);
			((CasesContext)_localctx).expr = expr(0);
			setState(316);
			match(OF);

			        this.branchHistory.push(this.toggle);
			        if( this.debug == true){
			            System.out.println("Pushed to the stack.\nStack contains: ");
			            for(Boolean b : this.branchHistory){
			                System.out.println(b + "\n");
			            }
			        }
			        if(this.toggle != true){
			            if(((CasesContext)_localctx).expr.o instanceof Character || ((CasesContext)_localctx).expr.o instanceof Integer || ((CasesContext)_localctx).expr.o instanceof String){
			                this.caseSel = ((CasesContext)_localctx).expr.o;
			            }
			            else{
			                throwE("Illegal Operation: Invalid type for case structure!");
			            }
			        }
			    
			setState(318);
			caseList();

			        this.toggle = new Boolean(this.branchHistory.pop());
			        if( this.debug == true){
			            System.out.println("Popped from the stack.\nStack contains: ");
			            for(Boolean b : this.branchHistory){
			                System.out.println(b + "\n");
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

	public static class CaseListContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(PascalRParser.END, 0); }
		public TerminalNode SEM() { return getToken(PascalRParser.SEM, 0); }
		public List<CaseStatementContext> caseStatement() {
			return getRuleContexts(CaseStatementContext.class);
		}
		public CaseStatementContext caseStatement(int i) {
			return getRuleContext(CaseStatementContext.class,i);
		}
		public ElseCaseContext elseCase() {
			return getRuleContext(ElseCaseContext.class,0);
		}
		public CaseListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterCaseList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitCaseList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitCaseList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseListContext caseList() throws RecognitionException {
		CaseListContext _localctx = new CaseListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_caseList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(321);
					caseStatement();
					}
					} 
				}
				setState(326);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELS) {
				{
				setState(327);
				elseCase();
				}
			}

			setState(330);
			match(END);
			setState(331);
			match(SEM);

			        this.breakCase = new Boolean(false);
			    
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

	public static class CaseStatementContext extends ParserRuleContext {
		public ExprContext expr;
		public RangeContext range;
		public TerminalNode COL() { return getToken(PascalRParser.COL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public TerminalNode SEM() { return getToken(PascalRParser.SEM, 0); }
		public TerminalNode BGN() { return getToken(PascalRParser.BGN, 0); }
		public TerminalNode END() { return getToken(PascalRParser.END, 0); }
		public SingleStatementContext singleStatement() {
			return getRuleContext(SingleStatementContext.class,0);
		}
		public List<ImplementationContext> implementation() {
			return getRuleContexts(ImplementationContext.class);
		}
		public ImplementationContext implementation(int i) {
			return getRuleContext(ImplementationContext.class,i);
		}
		public CaseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterCaseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitCaseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitCaseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseStatementContext caseStatement() throws RecognitionException {
		CaseStatementContext _localctx = new CaseStatementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_caseStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(334);
				((CaseStatementContext)_localctx).expr = expr(0);

				        if(this.toggle != true && this.breakCase != true){
				            if(this.debug == true){
				                System.out.println("The pattern to match is " + ((CaseStatementContext)_localctx).expr.o);
				                if(((CaseStatementContext)_localctx).expr.o instanceof Character){
				                    System.out.println("Its type is Character!");
				                }
				                else if(((CaseStatementContext)_localctx).expr.o instanceof Integer){
				                    System.out.println("Its type is Integer!");
				                }
				                else if(((CaseStatementContext)_localctx).expr.o instanceof String){
				                    System.out.println("Its type is String!");
				                }
				            }
				            if((((CaseStatementContext)_localctx).expr.o instanceof Character && this.caseSel instanceof Character)
				                || (((CaseStatementContext)_localctx).expr.o instanceof Integer && this.caseSel instanceof Integer)
				                || (((CaseStatementContext)_localctx).expr.o instanceof String && this.caseSel instanceof String)){

				                if(((CaseStatementContext)_localctx).expr.o.equals(this.caseSel)){
				                    this.toggle = new Boolean(false);
				                    this.breakCase = new Boolean(true);
				                }
				                else{
				                    this.toggle = new Boolean(true);
				                }
				            }
				            else{
				                throwE("Illegal Operation: Invalid type for case structure!");
				            }
				        }
				    
				}
				break;
			case 2:
				{
				setState(337);
				((CaseStatementContext)_localctx).range = range();

				        if(this.toggle != true && this.breakCase != true){
				            if((((CaseStatementContext)_localctx).range.l instanceof Character && this.caseSel instanceof Character)
				                || (((CaseStatementContext)_localctx).range.l instanceof Integer && this.caseSel instanceof Integer)){

				                if((Integer)((CaseStatementContext)_localctx).range.l < (Integer)this.caseSel || (Integer)((CaseStatementContext)_localctx).range.h > (Integer)this.caseSel){
				                    this.toggle = new Boolean(false);
				                    this.breakCase = new Boolean(true);
				                }
				                else{
				                    this.toggle = new Boolean(true);
				                }
				            }
				            else{
				                throwE("Illegal Operation: Invalid type for case structure!");
				            }
				        }
				    
				}
				break;
			}
			setState(342);
			match(COL);
			setState(358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				{
				setState(355);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
				case 1:
					{
					{
					setState(343);
					match(BGN);
					setState(347);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(344);
							implementation();
							}
							} 
						}
						setState(349);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
					}
					setState(350);
					match(END);
					setState(351);
					match(SEM);
					}
					}
					break;
				case 2:
					{
					{
					setState(352);
					singleStatement();
					setState(353);
					match(SEM);
					}
					}
					break;
				}
				}
				}
				break;
			case 2:
				{
				setState(357);
				match(SEM);
				}
				break;
			}

			        if(this.breakCase == true){
			            this.toggle = new Boolean(true);
			        }
			        else{
			            this.toggle = new Boolean(false);
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

	public static class ElseCaseContext extends ParserRuleContext {
		public TerminalNode ELS() { return getToken(PascalRParser.ELS, 0); }
		public TerminalNode BGN() { return getToken(PascalRParser.BGN, 0); }
		public TerminalNode END() { return getToken(PascalRParser.END, 0); }
		public TerminalNode SEM() { return getToken(PascalRParser.SEM, 0); }
		public SingleStatementContext singleStatement() {
			return getRuleContext(SingleStatementContext.class,0);
		}
		public List<ImplementationContext> implementation() {
			return getRuleContexts(ImplementationContext.class);
		}
		public ImplementationContext implementation(int i) {
			return getRuleContext(ImplementationContext.class,i);
		}
		public ElseCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterElseCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitElseCase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitElseCase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseCaseContext elseCase() throws RecognitionException {
		ElseCaseContext _localctx = new ElseCaseContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_elseCase);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			match(ELS);
			{
			setState(375);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				{
				setState(363);
				match(BGN);
				setState(367);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(364);
						implementation();
						}
						} 
					}
					setState(369);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				}
				setState(370);
				match(END);
				setState(371);
				match(SEM);
				}
				}
				break;
			case 2:
				{
				{
				setState(372);
				singleStatement();
				setState(373);
				match(SEM);
				}
				}
				break;
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

	public static class AssignmentContext extends ParserRuleContext {
		public IdentifierContext identifier;
		public ExprContext expr;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COL() { return getToken(PascalRParser.COL, 0); }
		public TerminalNode EQU() { return getToken(PascalRParser.EQU, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			((AssignmentContext)_localctx).identifier = identifier();
			setState(378);
			match(COL);
			setState(379);
			match(EQU);
			setState(380);
			((AssignmentContext)_localctx).expr = expr(0);

			        if(this.toggle != true){
			            setVariable(((AssignmentContext)_localctx).identifier.s, ((AssignmentContext)_localctx).expr.o);
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

	public static class ArgsContext extends ParserRuleContext {
		public LinkedHashMap<String,Object> o;
		public ExprContext v;
		public ArgsContext args;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COM() { return getToken(PascalRParser.COM, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			((ArgsContext)_localctx).v = expr(0);

			        if(this.toggle != true){
			           ((ArgsContext)_localctx).o =  new LinkedHashMap<String,Object>();
			           _localctx.o.put((((ArgsContext)_localctx).v!=null?_input.getText(((ArgsContext)_localctx).v.start,((ArgsContext)_localctx).v.stop):null),((ArgsContext)_localctx).v.o);
			        }
			    
			setState(389);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COM) {
				{
				setState(385);
				match(COM);
				setState(386);
				((ArgsContext)_localctx).args = args();

				        if(this.toggle != true){
				           _localctx.o.putAll(((ArgsContext)_localctx).args.o);
				        }
				    
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

	public static class WritelnContext extends ParserRuleContext {
		public TerminalNode WRL() { return getToken(PascalRParser.WRL, 0); }
		public TerminalNode LPA() { return getToken(PascalRParser.LPA, 0); }
		public WritelnFuncContext writelnFunc() {
			return getRuleContext(WritelnFuncContext.class,0);
		}
		public TerminalNode RPA() { return getToken(PascalRParser.RPA, 0); }
		public WritelnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writeln; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterWriteln(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitWriteln(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitWriteln(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WritelnContext writeln() throws RecognitionException {
		WritelnContext _localctx = new WritelnContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_writeln);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(WRL);
			setState(392);
			match(LPA);
			setState(393);
			writelnFunc();
			setState(394);
			match(RPA);
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

	public static class WritelnFuncContext extends ParserRuleContext {
		public ArgsContext args;
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public WritelnFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writelnFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterWritelnFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitWritelnFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitWritelnFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WritelnFuncContext writelnFunc() throws RecognitionException {
		WritelnFuncContext _localctx = new WritelnFuncContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_writelnFunc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			((WritelnFuncContext)_localctx).args = args();

			        if(this.toggle != true){
			            BufferedWriter foutput = new BufferedWriter(new OutputStreamWriter(System.out));
			            for(HashMap.Entry<String, Object> arg : ((WritelnFuncContext)_localctx).args.o.entrySet()){
			                if((arg.getValue() instanceof Integer) || (arg.getValue() instanceof Double) || (arg.getValue() instanceof Boolean) || (arg.getValue() instanceof Character) || (arg.getValue() instanceof String)){
			                    try{
			                        foutput.write(arg.getValue().toString());
			                    } catch(IOException e){
			                        System.out.println(e + "Could not write String to buffer!");
			                    };
			                }
			                else{
			                    throwE("Illegal Operation: arg is not a compatible value!");
			                }
			            }
			            try{
			                foutput.write("\n");
			                foutput.flush();
			            } catch(IOException e){
			                System.out.println(e + "Could not flush write buffer!");
			            };
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

	public static class ReadlnContext extends ParserRuleContext {
		public TerminalNode RDL() { return getToken(PascalRParser.RDL, 0); }
		public TerminalNode LPA() { return getToken(PascalRParser.LPA, 0); }
		public ReadlnFuncContext readlnFunc() {
			return getRuleContext(ReadlnFuncContext.class,0);
		}
		public TerminalNode RPA() { return getToken(PascalRParser.RPA, 0); }
		public ReadlnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readln; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterReadln(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitReadln(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitReadln(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadlnContext readln() throws RecognitionException {
		ReadlnContext _localctx = new ReadlnContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_readln);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			match(RDL);
			setState(400);
			match(LPA);
			setState(401);
			readlnFunc();
			setState(402);
			match(RPA);
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

	public static class ReadlnFuncContext extends ParserRuleContext {
		public ArgsContext args;
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ReadlnFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readlnFunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterReadlnFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitReadlnFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitReadlnFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReadlnFuncContext readlnFunc() throws RecognitionException {
		ReadlnFuncContext _localctx = new ReadlnFuncContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_readlnFunc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			((ReadlnFuncContext)_localctx).args = args();

			        if(this.toggle != true){
			           Scanner uinput = new Scanner(System.in);
			           Object v;
			           for(HashMap.Entry<String, Object> arg : ((ReadlnFuncContext)_localctx).args.o.entrySet()){
			               if(arg.getValue() instanceof Integer){
			                   v = new Integer(uinput.nextInt());
			               }
			               else if(arg.getValue() instanceof Boolean){
			                   v = new String(uinput.nextLine());
			                   if(((String)v).toLowerCase().equals("true") || ((String)v).toLowerCase().equals("false")){
			                        v = Boolean.parseBoolean((String)v);
			                   }
			                   else{
			                        try{
			                            v = Integer.parseInt((String)v);
			                        } catch (NumberFormatException e) {
			                            v = new Integer(0);
			                        }
			                        v = (Boolean)((Integer)v >= 1);
			                   }
			               }
			               else if(arg.getValue() instanceof Double){
			                   v = new Double(uinput.nextDouble());
			               }
			               else if(arg.getValue() instanceof Character){
			                   v = new Character(uinput.next().charAt(0));
			               }
			               else if(arg.getValue() instanceof String){
			                   v = new String(uinput.nextLine());
			               }
			               else{
			                   v = null;
			                   throwE("Illegal Operation: Variable cannot be set from stdin!");
			               }
			               setVariable(arg.getKey(),v);
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

	public static class SqrtContext extends ParserRuleContext {
		public Double d;
		public ExprContext expr;
		public TerminalNode SQR() { return getToken(PascalRParser.SQR, 0); }
		public TerminalNode LPA() { return getToken(PascalRParser.LPA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPA() { return getToken(PascalRParser.RPA, 0); }
		public SqrtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqrt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterSqrt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitSqrt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitSqrt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SqrtContext sqrt() throws RecognitionException {
		SqrtContext _localctx = new SqrtContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_sqrt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			match(SQR);
			setState(408);
			match(LPA);
			setState(409);
			((SqrtContext)_localctx).expr = expr(0);
			setState(410);
			match(RPA);

			        if(this.toggle != true){
			            if(((SqrtContext)_localctx).expr.o instanceof Double){
			                ((SqrtContext)_localctx).d =  Math.sqrt((Double)((SqrtContext)_localctx).expr.o);
			            }
			            else if(((SqrtContext)_localctx).expr.o instanceof Integer){
			                ((SqrtContext)_localctx).d =  Math.sqrt(Double.valueOf((Integer)((SqrtContext)_localctx).expr.o));
			            }
			            else{
			                throwE("Illegal Operation: Type is not a Real or an Integer!");
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

	public static class LnContext extends ParserRuleContext {
		public Double d;
		public ExprContext expr;
		public TerminalNode LN() { return getToken(PascalRParser.LN, 0); }
		public TerminalNode LPA() { return getToken(PascalRParser.LPA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPA() { return getToken(PascalRParser.RPA, 0); }
		public LnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ln; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterLn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitLn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitLn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LnContext ln() throws RecognitionException {
		LnContext _localctx = new LnContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_ln);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			match(LN);
			setState(414);
			match(LPA);
			setState(415);
			((LnContext)_localctx).expr = expr(0);
			setState(416);
			match(RPA);

			        if(this.toggle != true){
			            if(((LnContext)_localctx).expr.o instanceof Double){
			                ((LnContext)_localctx).d =  Math.log((Double)((LnContext)_localctx).expr.o);
			            }
			            else if(((LnContext)_localctx).expr.o instanceof Integer){
			                ((LnContext)_localctx).d =  Math.log(Double.valueOf((Integer)((LnContext)_localctx).expr.o));
			            }
			            else{
			                throwE("Illegal Operation: Type is not a Real or an Integer!");
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

	public static class ExpContext extends ParserRuleContext {
		public Double d;
		public ExprContext expr;
		public TerminalNode EXP() { return getToken(PascalRParser.EXP, 0); }
		public TerminalNode LPA() { return getToken(PascalRParser.LPA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPA() { return getToken(PascalRParser.RPA, 0); }
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			match(EXP);
			setState(420);
			match(LPA);
			setState(421);
			((ExpContext)_localctx).expr = expr(0);
			setState(422);
			match(RPA);

			        if(this.toggle != true){
			            if(((ExpContext)_localctx).expr.o instanceof Double){
			                ((ExpContext)_localctx).d =  Math.exp((Double)((ExpContext)_localctx).expr.o);
			            }
			            else if(((ExpContext)_localctx).expr.o instanceof Integer){
			                ((ExpContext)_localctx).d =  Math.exp(Double.valueOf((Integer)((ExpContext)_localctx).expr.o));
			            }
			            else{
			                throwE("Illegal Operation: Type is not a Real or an Integer!");
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

	public static class SineContext extends ParserRuleContext {
		public Double d;
		public ExprContext expr;
		public TerminalNode SIN() { return getToken(PascalRParser.SIN, 0); }
		public TerminalNode LPA() { return getToken(PascalRParser.LPA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPA() { return getToken(PascalRParser.RPA, 0); }
		public SineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterSine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitSine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitSine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SineContext sine() throws RecognitionException {
		SineContext _localctx = new SineContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_sine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			match(SIN);
			setState(426);
			match(LPA);
			setState(427);
			((SineContext)_localctx).expr = expr(0);
			setState(428);
			match(RPA);

			        if(this.toggle != true){
			            if(((SineContext)_localctx).expr.o instanceof Double){
			                ((SineContext)_localctx).d =  Math.sin((Double)((SineContext)_localctx).expr.o);
			            }
			            else if(((SineContext)_localctx).expr.o instanceof Integer){
			                ((SineContext)_localctx).d =  Math.sin(Double.valueOf((Integer)((SineContext)_localctx).expr.o));
			            }
			            else{
			                throwE("Illegal Operation: Type is not a Real or an Integer!");
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

	public static class CosineContext extends ParserRuleContext {
		public Double d;
		public ExprContext expr;
		public TerminalNode COS() { return getToken(PascalRParser.COS, 0); }
		public TerminalNode LPA() { return getToken(PascalRParser.LPA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPA() { return getToken(PascalRParser.RPA, 0); }
		public CosineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cosine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterCosine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitCosine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitCosine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CosineContext cosine() throws RecognitionException {
		CosineContext _localctx = new CosineContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_cosine);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			match(COS);
			setState(432);
			match(LPA);
			setState(433);
			((CosineContext)_localctx).expr = expr(0);
			setState(434);
			match(RPA);

			        if(this.toggle != true){
			            if(((CosineContext)_localctx).expr.o instanceof Double){
			                ((CosineContext)_localctx).d =  Math.cos((Double)((CosineContext)_localctx).expr.o);
			            }
			            else if(((CosineContext)_localctx).expr.o instanceof Integer){
			                ((CosineContext)_localctx).d =  Math.cos(Double.valueOf((Integer)((CosineContext)_localctx).expr.o));
			            }
			            else{
			                throwE("Illegal Operation: Type is not a Real or an Integer!");
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

	public static class ExprContext extends ParserRuleContext {
		public Object o;
		public ExprContext el;
		public ExprContext e;
		public IdentifierContext identifier;
		public Token INV;
		public Token DBV;
		public StringContext string;
		public SqrtContext sqrt;
		public SineContext sine;
		public CosineContext cosine;
		public LnContext ln;
		public ExpContext exp;
		public ExprContext er;
		public TerminalNode LPA() { return getToken(PascalRParser.LPA, 0); }
		public TerminalNode RPA() { return getToken(PascalRParser.RPA, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BOC() { return getToken(PascalRParser.BOC, 0); }
		public TerminalNode NOT() { return getToken(PascalRParser.NOT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode PI() { return getToken(PascalRParser.PI, 0); }
		public TerminalNode TRU() { return getToken(PascalRParser.TRU, 0); }
		public TerminalNode FLS() { return getToken(PascalRParser.FLS, 0); }
		public TerminalNode INV() { return getToken(PascalRParser.INV, 0); }
		public TerminalNode DBV() { return getToken(PascalRParser.DBV, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public SqrtContext sqrt() {
			return getRuleContext(SqrtContext.class,0);
		}
		public SineContext sine() {
			return getRuleContext(SineContext.class,0);
		}
		public CosineContext cosine() {
			return getRuleContext(CosineContext.class,0);
		}
		public LnContext ln() {
			return getRuleContext(LnContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode MUL() { return getToken(PascalRParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(PascalRParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(PascalRParser.MOD, 0); }
		public TerminalNode BND() { return getToken(PascalRParser.BND, 0); }
		public TerminalNode AND() { return getToken(PascalRParser.AND, 0); }
		public TerminalNode SHL() { return getToken(PascalRParser.SHL, 0); }
		public TerminalNode BSL() { return getToken(PascalRParser.BSL, 0); }
		public TerminalNode SHR() { return getToken(PascalRParser.SHR, 0); }
		public TerminalNode BSR() { return getToken(PascalRParser.BSR, 0); }
		public TerminalNode BOR() { return getToken(PascalRParser.BOR, 0); }
		public TerminalNode BNT() { return getToken(PascalRParser.BNT, 0); }
		public TerminalNode OR() { return getToken(PascalRParser.OR, 0); }
		public TerminalNode XOR() { return getToken(PascalRParser.XOR, 0); }
		public TerminalNode ADD() { return getToken(PascalRParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(PascalRParser.SUB, 0); }
		public TerminalNode EQU() { return getToken(PascalRParser.EQU, 0); }
		public TerminalNode NEQ() { return getToken(PascalRParser.NEQ, 0); }
		public TerminalNode LES() { return getToken(PascalRParser.LES, 0); }
		public TerminalNode LEQ() { return getToken(PascalRParser.LEQ, 0); }
		public TerminalNode GRT() { return getToken(PascalRParser.GRT, 0); }
		public TerminalNode GEQ() { return getToken(PascalRParser.GEQ, 0); }
		public TerminalNode ELS() { return getToken(PascalRParser.ELS, 0); }
		public TerminalNode THN() { return getToken(PascalRParser.THN, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(438);
				match(LPA);
				setState(439);
				((ExprContext)_localctx).e = expr(0);
				setState(440);
				match(RPA);

				        if(this.toggle != true){
				            ((ExprContext)_localctx).o =  ((ExprContext)_localctx).e.o;
				        }
				    
				}
				break;
			case 2:
				{
				setState(443);
				match(BOC);
				setState(444);
				((ExprContext)_localctx).el = expr(48);

				        if(this.toggle != true){
				            if(((ExprContext)_localctx).el.o instanceof Integer || ((ExprContext)_localctx).el.o instanceof Character){
				                ((ExprContext)_localctx).o =  ~(Integer)((ExprContext)_localctx).el.o;
				            }
				            else if(((ExprContext)_localctx).el.o instanceof Boolean){
				                ((ExprContext)_localctx).o =  !(Boolean)((ExprContext)_localctx).el.o;
				            }
				            else{
				                ((ExprContext)_localctx).o =  null;
				                throwE("Illegal Operation: Incompatible Type!");
				            }
				        }
				    
				}
				break;
			case 3:
				{
				setState(447);
				match(NOT);
				setState(448);
				((ExprContext)_localctx).el = expr(47);

				        if(this.toggle != true){
				            if(((ExprContext)_localctx).el.o instanceof Integer || ((ExprContext)_localctx).el.o instanceof Character){
				                ((ExprContext)_localctx).o =  ~(Integer)((ExprContext)_localctx).el.o;
				            }
				            else if(((ExprContext)_localctx).el.o instanceof Boolean){
				                ((ExprContext)_localctx).o =  !(Boolean)((ExprContext)_localctx).el.o;
				            }
				            else{
				                ((ExprContext)_localctx).o =  null;
				                throwE("Illegal Operation: Incompatible Type!");
				            }
				        }
				    
				}
				break;
			case 4:
				{
				}
				break;
			case 5:
				{
				}
				break;
			case 6:
				{
				}
				break;
			case 7:
				{
				}
				break;
			case 8:
				{
				}
				break;
			case 9:
				{
				setState(456);
				((ExprContext)_localctx).identifier = identifier();

				        if(this.toggle != true){
				            if(this.debug == true){
				                System.out.println(((ExprContext)_localctx).identifier.s);
				            }
				            ((ExprContext)_localctx).o =  getVariable(((ExprContext)_localctx).identifier.s);
				        }
				    
				}
				break;
			case 10:
				{
				}
				break;
			case 11:
				{
				setState(460);
				match(PI);

				        if(this.toggle != true){
				            ((ExprContext)_localctx).o =  new Double(Math.PI);
				        }
				    
				}
				break;
			case 12:
				{
				}
				break;
			case 13:
				{
				setState(463);
				match(TRU);

				        if(this.toggle != true){
				            ((ExprContext)_localctx).o =  new Boolean(true);
				        }
				    
				}
				break;
			case 14:
				{
				}
				break;
			case 15:
				{
				setState(466);
				match(FLS);

				        if(this.toggle != true){
				            ((ExprContext)_localctx).o =  new Boolean(false);
				        }
				    
				}
				break;
			case 16:
				{
				}
				break;
			case 17:
				{
				setState(469);
				((ExprContext)_localctx).INV = match(INV);

				        if(this.toggle != true){
				            ((ExprContext)_localctx).o =  new Integer(Integer.parseInt((((ExprContext)_localctx).INV!=null?((ExprContext)_localctx).INV.getText():null)));
				        }
				    
				}
				break;
			case 18:
				{
				}
				break;
			case 19:
				{
				setState(472);
				((ExprContext)_localctx).DBV = match(DBV);

				        if(this.toggle != true){
				            ((ExprContext)_localctx).o =  new Double(Double.parseDouble((((ExprContext)_localctx).DBV!=null?((ExprContext)_localctx).DBV.getText():null)));
				        }
				    
				}
				break;
			case 20:
				{
				}
				break;
			case 21:
				{
				setState(475);
				((ExprContext)_localctx).string = string();

				        if(this.toggle != true){
				            ((ExprContext)_localctx).o =  new String(((ExprContext)_localctx).string.s);
				        }
				    
				}
				break;
			case 22:
				{
				}
				break;
			case 23:
				{
				setState(479);
				((ExprContext)_localctx).sqrt = sqrt();

				        if(this.toggle != true){
				            ((ExprContext)_localctx).o =  new Double(((ExprContext)_localctx).sqrt.d);
				        }
				    
				}
				break;
			case 24:
				{
				}
				break;
			case 25:
				{
				setState(483);
				((ExprContext)_localctx).sine = sine();

				        if(this.toggle != true){
				            ((ExprContext)_localctx).o =  new Double(((ExprContext)_localctx).sine.d);
				        }
				    
				}
				break;
			case 26:
				{
				}
				break;
			case 27:
				{
				setState(487);
				((ExprContext)_localctx).cosine = cosine();

				        if(this.toggle != true){
				            ((ExprContext)_localctx).o =  new Double(((ExprContext)_localctx).cosine.d);
				        }
				    
				}
				break;
			case 28:
				{
				}
				break;
			case 29:
				{
				setState(491);
				((ExprContext)_localctx).ln = ln();

				        if(this.toggle != true){
				            ((ExprContext)_localctx).o =  new Double(((ExprContext)_localctx).ln.d);
				        }
				    
				}
				break;
			case 30:
				{
				}
				break;
			case 31:
				{
				setState(495);
				((ExprContext)_localctx).exp = exp();

				        if(this.toggle != true){
				            ((ExprContext)_localctx).o =  new Double(((ExprContext)_localctx).exp.d);
				        }
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(594);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(592);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(500);
						if (!(precpred(_ctx, 45))) throw new FailedPredicateException(this, "precpred(_ctx, 45)");
						setState(501);
						match(MUL);
						setState(502);
						((ExprContext)_localctx).er = expr(46);

						                  if(this.toggle != true){
						                      if(((((ExprContext)_localctx).el.o instanceof Integer) && (((ExprContext)_localctx).er.o instanceof Integer)) || ((((ExprContext)_localctx).el.o instanceof Character) && (((ExprContext)_localctx).er.o instanceof Character))){
						                          ((ExprContext)_localctx).o =  (Integer)((ExprContext)_localctx).el.o * (Integer)((ExprContext)_localctx).er.o;
						                      }
						                      else if((((ExprContext)_localctx).el.o instanceof Double) && (((ExprContext)_localctx).er.o instanceof Double)){
						                          ((ExprContext)_localctx).o =  (Double)((ExprContext)_localctx).el.o * (Double)((ExprContext)_localctx).er.o;
						                      }
						                      else{
						                          ((ExprContext)_localctx).o =  null;
						                          throwE("Illegal Operation: Incompatible Type!");
						                      }
						                  }
						              
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(505);
						if (!(precpred(_ctx, 44))) throw new FailedPredicateException(this, "precpred(_ctx, 44)");
						setState(506);
						match(DIV);
						setState(507);
						((ExprContext)_localctx).er = expr(45);

						                  if(this.toggle != true){
						                      if(((((ExprContext)_localctx).el.o instanceof Integer) && (((ExprContext)_localctx).er.o instanceof Integer)) || ((((ExprContext)_localctx).el.o instanceof Character) && (((ExprContext)_localctx).er.o instanceof Character))){
						                          ((ExprContext)_localctx).o =  (Integer)((ExprContext)_localctx).el.o / (Integer)((ExprContext)_localctx).er.o;
						                      }
						                      else if((((ExprContext)_localctx).el.o instanceof Double) && (((ExprContext)_localctx).er.o instanceof Double)){
						                          ((ExprContext)_localctx).o =  (Double)((ExprContext)_localctx).el.o / (Double)((ExprContext)_localctx).er.o;
						                      }
						                      else{
						                          ((ExprContext)_localctx).o =  null;
						                          throwE("Illegal Operation: Incompatible Type!");
						                      }
						                  }
						              
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(510);
						if (!(precpred(_ctx, 43))) throw new FailedPredicateException(this, "precpred(_ctx, 43)");
						setState(511);
						match(MOD);
						setState(512);
						((ExprContext)_localctx).er = expr(44);

						                  if(this.toggle != true){
						                      if(((((ExprContext)_localctx).el.o instanceof Integer) && (((ExprContext)_localctx).er.o instanceof Integer)) || ((((ExprContext)_localctx).el.o instanceof Character) && (((ExprContext)_localctx).er.o instanceof Character))){
						                          ((ExprContext)_localctx).o =  (Integer)((ExprContext)_localctx).el.o % (Integer)((ExprContext)_localctx).er.o;
						                      }
						                      else if((((ExprContext)_localctx).el.o instanceof Double) && (((ExprContext)_localctx).er.o instanceof Double)){
						                          ((ExprContext)_localctx).o =  (Double)((ExprContext)_localctx).el.o % (Double)((ExprContext)_localctx).er.o;
						                      }
						                      else{
						                          ((ExprContext)_localctx).o =  null;
						                          throwE("Illegal Operation: Incompatible Type!");
						                      }
						                  }
						              
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(515);
						if (!(precpred(_ctx, 42))) throw new FailedPredicateException(this, "precpred(_ctx, 42)");
						setState(516);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==BND) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(517);
						((ExprContext)_localctx).er = expr(43);

						                  if(this.toggle != true){
						                      if(((((ExprContext)_localctx).el.o instanceof Integer) && (((ExprContext)_localctx).er.o instanceof Integer)) || ((((ExprContext)_localctx).el.o instanceof Character) && (((ExprContext)_localctx).er.o instanceof Character))){
						                          ((ExprContext)_localctx).o =  (Integer)((ExprContext)_localctx).el.o & (Integer)((ExprContext)_localctx).er.o;
						                      }
						                      else if((((ExprContext)_localctx).el.o instanceof Double) && (((ExprContext)_localctx).er.o instanceof Double)){
						                          ((ExprContext)_localctx).o =  (Boolean)((ExprContext)_localctx).el.o & (Boolean)((ExprContext)_localctx).er.o;
						                      }
						                      else{
						                          ((ExprContext)_localctx).o =  null;
						                          throwE("Illegal Operation: Incompatible Type!");
						                      }
						                  }
						              
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(520);
						if (!(precpred(_ctx, 41))) throw new FailedPredicateException(this, "precpred(_ctx, 41)");
						setState(521);
						_la = _input.LA(1);
						if ( !(_la==BSL || _la==SHL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(522);
						((ExprContext)_localctx).er = expr(42);

						                  if(this.toggle != true){
						                      if(((((ExprContext)_localctx).el.o instanceof Integer) && (((ExprContext)_localctx).er.o instanceof Integer)) || ((((ExprContext)_localctx).el.o instanceof Character) && (((ExprContext)_localctx).er.o instanceof Character))){
						                          ((ExprContext)_localctx).o =  (Integer)((ExprContext)_localctx).el.o << (Integer)((ExprContext)_localctx).er.o;
						                      }
						                      else{
						                          ((ExprContext)_localctx).o =  null;
						                          throwE("Illegal Operation: Incompatible Type!");
						                      }
						                  }
						              
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(525);
						if (!(precpred(_ctx, 40))) throw new FailedPredicateException(this, "precpred(_ctx, 40)");
						setState(526);
						_la = _input.LA(1);
						if ( !(_la==BSR || _la==SHR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(527);
						((ExprContext)_localctx).er = expr(41);

						                  if(this.toggle != true){
						                      if(((((ExprContext)_localctx).el.o instanceof Integer) && (((ExprContext)_localctx).er.o instanceof Integer)) || ((((ExprContext)_localctx).el.o instanceof Character) && (((ExprContext)_localctx).er.o instanceof Character))){
						                          ((ExprContext)_localctx).o =  (Integer)((ExprContext)_localctx).el.o >> (Integer)((ExprContext)_localctx).er.o;
						                      }
						                      else{
						                          ((ExprContext)_localctx).o =  null;
						                          throwE("Illegal Operation: Incompatible Type!");
						                      }
						                  }
						              
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(530);
						if (!(precpred(_ctx, 38))) throw new FailedPredicateException(this, "precpred(_ctx, 38)");
						setState(531);
						_la = _input.LA(1);
						if ( !(((((_la - 60)) & ~0x3f) == 0 && ((1L << (_la - 60)) & ((1L << (OR - 60)) | (1L << (BOR - 60)) | (1L << (BNT - 60)))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(532);
						((ExprContext)_localctx).er = expr(39);

						                  if(this.toggle != true){
						                      if(((((ExprContext)_localctx).el.o instanceof Integer) && (((ExprContext)_localctx).er.o instanceof Integer)) || ((((ExprContext)_localctx).el.o instanceof Character) && (((ExprContext)_localctx).er.o instanceof Character))){
						                          ((ExprContext)_localctx).o =  (Integer)((ExprContext)_localctx).el.o | (Integer)((ExprContext)_localctx).er.o;
						                      }
						                      else if((((ExprContext)_localctx).el.o instanceof Double) && (((ExprContext)_localctx).er.o instanceof Double)){
						                          ((ExprContext)_localctx).o =  (Boolean)((ExprContext)_localctx).el.o | (Boolean)((ExprContext)_localctx).er.o;
						                      }
						                      else{
						                          ((ExprContext)_localctx).o =  null;
						                          throwE("Illegal Operation: Incompatible Type!");
						                      }
						                  }
						              
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(535);
						if (!(precpred(_ctx, 37))) throw new FailedPredicateException(this, "precpred(_ctx, 37)");
						setState(536);
						match(XOR);
						setState(537);
						((ExprContext)_localctx).er = expr(38);

						                  if(this.toggle != true){
						                      if(((((ExprContext)_localctx).el.o instanceof Integer) && (((ExprContext)_localctx).er.o instanceof Integer)) || ((((ExprContext)_localctx).el.o instanceof Character) && (((ExprContext)_localctx).er.o instanceof Character))){
						                          ((ExprContext)_localctx).o =  (Integer)((ExprContext)_localctx).el.o ^ (Integer)((ExprContext)_localctx).er.o;
						                      }
						                      else if((((ExprContext)_localctx).el.o instanceof Double) && (((ExprContext)_localctx).er.o instanceof Double)){
						                          ((ExprContext)_localctx).o =  (Boolean)((ExprContext)_localctx).el.o ^ (Boolean)((ExprContext)_localctx).er.o;
						                      }
						                      else{
						                          ((ExprContext)_localctx).o =  null;
						                          throwE("Illegal Operation: Incompatible Type!");
						                      }
						                  }
						              
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(540);
						if (!(precpred(_ctx, 36))) throw new FailedPredicateException(this, "precpred(_ctx, 36)");
						setState(541);
						match(ADD);
						setState(542);
						((ExprContext)_localctx).er = expr(37);

						                  if(this.toggle != true){
						                      if(((((ExprContext)_localctx).el.o instanceof Integer) && (((ExprContext)_localctx).er.o instanceof Integer)) || ((((ExprContext)_localctx).el.o instanceof Character) && (((ExprContext)_localctx).er.o instanceof Character))){
						                          ((ExprContext)_localctx).o =  (Integer)((ExprContext)_localctx).el.o + (Integer)((ExprContext)_localctx).er.o;
						                      }
						                      else if((((ExprContext)_localctx).el.o instanceof Double) && (((ExprContext)_localctx).er.o instanceof Double)){
						                          ((ExprContext)_localctx).o =  (Double)((ExprContext)_localctx).el.o + (Double)((ExprContext)_localctx).er.o;
						                      }
						                      else{
						                          ((ExprContext)_localctx).o =  null;
						                          throwE("Illegal Operation: Incompatible Type!");
						                      }
						                  }
						              
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(545);
						if (!(precpred(_ctx, 35))) throw new FailedPredicateException(this, "precpred(_ctx, 35)");
						setState(546);
						match(SUB);
						setState(547);
						((ExprContext)_localctx).er = expr(36);

						                  if(this.toggle != true){
						                      if(((((ExprContext)_localctx).el.o instanceof Integer) && (((ExprContext)_localctx).er.o instanceof Integer)) || ((((ExprContext)_localctx).el.o instanceof Character) && (((ExprContext)_localctx).er.o instanceof Character))){
						                          ((ExprContext)_localctx).o =  (Integer)((ExprContext)_localctx).el.o - (Integer)((ExprContext)_localctx).er.o;
						                      }
						                      else if((((ExprContext)_localctx).el.o instanceof Double) && (((ExprContext)_localctx).er.o instanceof Double)){
						                          ((ExprContext)_localctx).o =  (Double)((ExprContext)_localctx).el.o - (Double)((ExprContext)_localctx).er.o;
						                      }
						                      else{
						                          ((ExprContext)_localctx).o =  null;
						                          throwE("Illegal Operation: Incompatible Type!");
						                      }
						                  }
						              
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(550);
						if (!(precpred(_ctx, 33))) throw new FailedPredicateException(this, "precpred(_ctx, 33)");
						setState(551);
						match(EQU);
						setState(552);
						((ExprContext)_localctx).er = expr(34);

						                  if(this.toggle != true){
						                      if(((ExprContext)_localctx).el.o instanceof Boolean && ((ExprContext)_localctx).er.o instanceof Integer){
						                          ((ExprContext)_localctx).o =  ((Boolean)((ExprContext)_localctx).el.o.equals((Integer)((ExprContext)_localctx).er.o >= 1));
						                      }
						                      else if(((ExprContext)_localctx).er.o instanceof Boolean && ((ExprContext)_localctx).el.o instanceof Integer){
						                          ((ExprContext)_localctx).o =  ((Boolean)((ExprContext)_localctx).er.o.equals((Integer)((ExprContext)_localctx).el.o >= 1));
						                      }
						                      else{
						                          ((ExprContext)_localctx).o =  ((ExprContext)_localctx).el.o.equals(((ExprContext)_localctx).er.o);
						                      }
						                  }
						              
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(555);
						if (!(precpred(_ctx, 32))) throw new FailedPredicateException(this, "precpred(_ctx, 32)");
						setState(556);
						match(NEQ);
						setState(557);
						((ExprContext)_localctx).er = expr(33);

						                  if(this.toggle != true){
						                      if(((ExprContext)_localctx).el.o instanceof Boolean && ((ExprContext)_localctx).er.o instanceof Integer){
						                          ((ExprContext)_localctx).o =  !((Boolean)((ExprContext)_localctx).el.o.equals((Integer)((ExprContext)_localctx).er.o >= 1));
						                      }
						                      else if(((ExprContext)_localctx).er.o instanceof Boolean && ((ExprContext)_localctx).el.o instanceof Integer){
						                          ((ExprContext)_localctx).o =  !((Boolean)((ExprContext)_localctx).er.o.equals((Integer)((ExprContext)_localctx).el.o >= 1));
						                      }
						                      else{
						                          ((ExprContext)_localctx).o =  !(((ExprContext)_localctx).el.o.equals(((ExprContext)_localctx).er.o));
						                      }
						                  }
						              
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(560);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(561);
						match(LES);
						setState(562);
						((ExprContext)_localctx).er = expr(32);

						                  if(this.toggle != true){
						                      if(((((ExprContext)_localctx).el.o instanceof Integer) && (((ExprContext)_localctx).er.o instanceof Integer)) || ((((ExprContext)_localctx).el.o instanceof Character) && (((ExprContext)_localctx).er.o instanceof Character))){
						                          ((ExprContext)_localctx).o =  (Integer)((ExprContext)_localctx).el.o < (Integer)((ExprContext)_localctx).er.o;
						                      }
						                      else if((((ExprContext)_localctx).el.o instanceof Double) && (((ExprContext)_localctx).er.o instanceof Double)){
						                          ((ExprContext)_localctx).o =  (Double.compare((Double)((ExprContext)_localctx).el.o, (Double)((ExprContext)_localctx).er.o) < 0);
						                      }
						                      else{
						                          ((ExprContext)_localctx).o =  null;
						                          throwE("Illegal Operation: Incompatible Type!");
						                      }
						                  }
						              
						}
						break;
					case 14:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(565);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(566);
						match(LEQ);
						setState(567);
						((ExprContext)_localctx).er = expr(31);

						                  if(this.toggle != true){
						                      if(((((ExprContext)_localctx).el.o instanceof Integer) && (((ExprContext)_localctx).er.o instanceof Integer)) || ((((ExprContext)_localctx).el.o instanceof Character) && (((ExprContext)_localctx).er.o instanceof Character))){
						                          ((ExprContext)_localctx).o =  (Integer)((ExprContext)_localctx).el.o <= (Integer)((ExprContext)_localctx).er.o;
						                      }
						                      else if((((ExprContext)_localctx).el.o instanceof Double) && (((ExprContext)_localctx).er.o instanceof Double)){
						                          ((ExprContext)_localctx).o =  (Double.compare((Double)((ExprContext)_localctx).el.o, (Double)((ExprContext)_localctx).er.o) <= 0);
						                      }
						                      else{
						                          ((ExprContext)_localctx).o =  null;
						                          throwE("Illegal Operation: Incompatible Type!");
						                      }
						                  }
						              
						}
						break;
					case 15:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(570);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(571);
						match(GRT);
						setState(572);
						((ExprContext)_localctx).er = expr(30);

						                  if(this.toggle != true){
						                      if(((((ExprContext)_localctx).el.o instanceof Integer) && (((ExprContext)_localctx).er.o instanceof Integer)) || ((((ExprContext)_localctx).el.o instanceof Character) && (((ExprContext)_localctx).er.o instanceof Character))){
						                          ((ExprContext)_localctx).o =  (Integer)((ExprContext)_localctx).el.o > (Integer)((ExprContext)_localctx).er.o;
						                      }
						                      else if((((ExprContext)_localctx).el.o instanceof Double) && (((ExprContext)_localctx).er.o instanceof Double)){
						                          ((ExprContext)_localctx).o =  (Double.compare((Double)((ExprContext)_localctx).el.o, (Double)((ExprContext)_localctx).er.o) > 0);
						                      }
						                      else{
						                          ((ExprContext)_localctx).o =  null;
						                          throwE("Illegal Operation: Incompatible Type!");
						                      }
						                  }
						              
						}
						break;
					case 16:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(575);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(576);
						match(GEQ);
						setState(577);
						((ExprContext)_localctx).er = expr(29);

						                  if(this.toggle != true){
						                      if(((((ExprContext)_localctx).el.o instanceof Integer) && (((ExprContext)_localctx).er.o instanceof Integer)) || ((((ExprContext)_localctx).el.o instanceof Character) && (((ExprContext)_localctx).er.o instanceof Character))){
						                          ((ExprContext)_localctx).o =  (Integer)((ExprContext)_localctx).el.o >= (Integer)((ExprContext)_localctx).er.o;
						                      }
						                      else if((((ExprContext)_localctx).el.o instanceof Double) && (((ExprContext)_localctx).er.o instanceof Double)){
						                          ((ExprContext)_localctx).o =  (Double.compare((Double)((ExprContext)_localctx).el.o, (Double)((ExprContext)_localctx).er.o) >= 0);
						                      }
						                      else{
						                          ((ExprContext)_localctx).o =  null;
						                          throwE("Illegal Operation: Incompatible Type!");
						                      }
						                  }
						              
						}
						break;
					case 17:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(580);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(581);
						match(OR);
						setState(582);
						match(ELS);
						setState(583);
						((ExprContext)_localctx).er = expr(27);

						                  if(this.toggle != true){
						                      if((((ExprContext)_localctx).el.o instanceof Boolean) && (((ExprContext)_localctx).er.o instanceof Boolean)){
						                          ((ExprContext)_localctx).o =  (Boolean)((ExprContext)_localctx).el.o || (Boolean)((ExprContext)_localctx).er.o;
						                      }
						                  }
						              
						}
						break;
					case 18:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.el = _prevctx;
						_localctx.el = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(586);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(587);
						match(AND);
						setState(588);
						match(THN);
						setState(589);
						((ExprContext)_localctx).er = expr(26);

						                  if(this.toggle != true){
						                      if((((ExprContext)_localctx).el.o instanceof Boolean) && (((ExprContext)_localctx).er.o instanceof Boolean)){
						                          ((ExprContext)_localctx).o =  (Boolean)((ExprContext)_localctx).el.o && (Boolean)((ExprContext)_localctx).er.o;
						                      }
						                  }
						              
						}
						break;
					}
					} 
				}
				setState(596);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
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

	public static class StringContext extends ParserRuleContext {
		public String s;
		public Token STV;
		public TerminalNode STV() { return getToken(PascalRParser.STV, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalRListener ) ((PascalRListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PascalRVisitor ) return ((PascalRVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
			((StringContext)_localctx).STV = match(STV);

			        //drop the quotes surrounding the string
			         String st = (((StringContext)_localctx).STV!=null?((StringContext)_localctx).STV.getText():null);
			         ((StringContext)_localctx).s =  new String(st.substring(1,st.length()-1));
			    
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
		case 38:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 45);
		case 1:
			return precpred(_ctx, 44);
		case 2:
			return precpred(_ctx, 43);
		case 3:
			return precpred(_ctx, 42);
		case 4:
			return precpred(_ctx, 41);
		case 5:
			return precpred(_ctx, 40);
		case 6:
			return precpred(_ctx, 38);
		case 7:
			return precpred(_ctx, 37);
		case 8:
			return precpred(_ctx, 36);
		case 9:
			return precpred(_ctx, 35);
		case 10:
			return precpred(_ctx, 33);
		case 11:
			return precpred(_ctx, 32);
		case 12:
			return precpred(_ctx, 31);
		case 13:
			return precpred(_ctx, 30);
		case 14:
			return precpred(_ctx, 29);
		case 15:
			return precpred(_ctx, 28);
		case 16:
			return precpred(_ctx, 26);
		case 17:
			return precpred(_ctx, 25);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3W\u025b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\3\5\3W\n\3\3\3\3\3\5\3[\n\3\3\3\5\3^\n\3\3\3\5\3a\n\3\3\3\5\3d\n\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4p\n\4\3\4\3\4\3\4\3\4\5\4v\n"+
		"\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\7\7\u0082\n\7\f\7\16\7\u0085"+
		"\13\7\3\b\5\b\u0088\n\b\3\b\5\b\u008b\n\b\3\b\5\b\u008e\n\b\3\b\3\b\5"+
		"\b\u0092\n\b\3\b\5\b\u0095\n\b\3\b\3\b\5\b\u0099\n\b\3\b\5\b\u009c\n\b"+
		"\5\b\u009e\n\b\3\b\7\b\u00a1\n\b\f\b\16\b\u00a4\13\b\3\b\5\b\u00a7\n\b"+
		"\3\t\3\t\3\t\7\t\u00ac\n\t\f\t\16\t\u00af\13\t\3\t\3\t\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u00bf\n\r\f\r\16\r\u00c2\13\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ce\n\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00d8\n\17\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u00df\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00e9\n"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00f7"+
		"\n\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0100\n\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u0115\n\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u011d\n"+
		"\26\3\27\3\27\3\27\3\27\5\27\u0123\n\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\7\30\u012c\n\30\f\30\16\30\u012f\13\30\3\30\3\30\5\30\u0133\n\30"+
		"\3\30\3\30\3\30\3\30\5\30\u0139\n\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\32\7\32\u0145\n\32\f\32\16\32\u0148\13\32\3\32\5\32\u014b"+
		"\n\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0157\n\33"+
		"\3\33\3\33\3\33\7\33\u015c\n\33\f\33\16\33\u015f\13\33\3\33\3\33\3\33"+
		"\3\33\3\33\5\33\u0166\n\33\3\33\5\33\u0169\n\33\3\33\3\33\3\34\3\34\3"+
		"\34\7\34\u0170\n\34\f\34\16\34\u0173\13\34\3\34\3\34\3\34\3\34\3\34\5"+
		"\34\u017a\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\5\36\u0188\n\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3"+
		"!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3"+
		"&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\5(\u01f5\n(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\3(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u0253\n(\f(\16(\u0256\13(\3)\3)\3)\3)"+
		"\2\3N*\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<"+
		">@BDFHJLNP\2\7\3\2\3\3\4\2<<AA\4\2EEHH\4\2FFII\4\2>>BC\2\u0294\2R\3\2"+
		"\2\2\4V\3\2\2\2\6u\3\2\2\2\bw\3\2\2\2\n{\3\2\2\2\f~\3\2\2\2\16\u0087\3"+
		"\2\2\2\20\u00a8\3\2\2\2\22\u00b2\3\2\2\2\24\u00b5\3\2\2\2\26\u00b8\3\2"+
		"\2\2\30\u00bb\3\2\2\2\32\u00c6\3\2\2\2\34\u00d1\3\2\2\2\36\u00d9\3\2\2"+
		"\2 \u00e2\3\2\2\2\"\u00ff\3\2\2\2$\u0101\3\2\2\2&\u0109\3\2\2\2(\u010e"+
		"\3\2\2\2*\u011c\3\2\2\2,\u0122\3\2\2\2.\u0124\3\2\2\2\60\u013c\3\2\2\2"+
		"\62\u0146\3\2\2\2\64\u0156\3\2\2\2\66\u016c\3\2\2\28\u017b\3\2\2\2:\u0181"+
		"\3\2\2\2<\u0189\3\2\2\2>\u018e\3\2\2\2@\u0191\3\2\2\2B\u0196\3\2\2\2D"+
		"\u0199\3\2\2\2F\u019f\3\2\2\2H\u01a5\3\2\2\2J\u01ab\3\2\2\2L\u01b1\3\2"+
		"\2\2N\u01f4\3\2\2\2P\u0257\3\2\2\2RS\b\2\1\2ST\5\4\3\2T\3\3\2\2\2UW\5"+
		"\20\t\2VU\3\2\2\2VW\3\2\2\2WX\3\2\2\2XZ\5\6\4\2Y[\5\20\t\2ZY\3\2\2\2Z"+
		"[\3\2\2\2[]\3\2\2\2\\^\7\60\2\2]\\\3\2\2\2]^\3\2\2\2^`\3\2\2\2_a\5\20"+
		"\t\2`_\3\2\2\2`a\3\2\2\2ac\3\2\2\2bd\5\b\5\2cb\3\2\2\2cd\3\2\2\2de\3\2"+
		"\2\2ef\5\16\b\2fg\7\r\2\2gh\7\2\2\3h\5\3\2\2\2ij\7!\2\2jo\5\n\6\2kl\7"+
		"\n\2\2lm\5\f\7\2mn\7\13\2\2np\3\2\2\2ok\3\2\2\2op\3\2\2\2pq\3\2\2\2qr"+
		"\7\t\2\2rv\3\2\2\2st\7\34\2\2tv\5\n\6\2ui\3\2\2\2us\3\2\2\2v\7\3\2\2\2"+
		"wx\7\35\2\2xy\5\n\6\2yz\7\t\2\2z\t\3\2\2\2{|\7T\2\2|}\b\6\1\2}\13\3\2"+
		"\2\2~\u0083\5\n\6\2\177\u0080\7\f\2\2\u0080\u0082\5\n\6\2\u0081\177\3"+
		"\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\r\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0088\5\20\t\2\u0087\u0086\3\2\2"+
		"\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u008b\5\22\n\2\u008a"+
		"\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008e\5\20"+
		"\t\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u009d\3\2\2\2\u008f"+
		"\u0091\5\24\13\2\u0090\u0092\5\20\t\2\u0091\u0090\3\2\2\2\u0091\u0092"+
		"\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0095\5\26\f\2\u0094\u0093\3\2\2\2"+
		"\u0094\u0095\3\2\2\2\u0095\u009e\3\2\2\2\u0096\u0098\5\26\f\2\u0097\u0099"+
		"\5\20\t\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2"+
		"\u009a\u009c\5\24\13\2\u009b\u009a\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e"+
		"\3\2\2\2\u009d\u008f\3\2\2\2\u009d\u0096\3\2\2\2\u009e\u00a2\3\2\2\2\u009f"+
		"\u00a1\5\30\r\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3\2\2\2\u00a2\u00a0\3"+
		"\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a5"+
		"\u00a7\5\20\t\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\17\3\2\2"+
		"\2\u00a8\u00a9\7\n\2\2\u00a9\u00ad\7\63\2\2\u00aa\u00ac\n\2\2\2\u00ab"+
		"\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2"+
		"\2\2\u00ae\u00b0\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\7\3\2\2\u00b1"+
		"\21\3\2\2\2\u00b2\u00b3\7 \2\2\u00b3\u00b4\5\32\16\2\u00b4\23\3\2\2\2"+
		"\u00b5\u00b6\7\36\2\2\u00b6\u00b7\5\36\20\2\u00b7\25\3\2\2\2\u00b8\u00b9"+
		"\7\37\2\2\u00b9\u00ba\5(\25\2\u00ba\27\3\2\2\2\u00bb\u00bc\7\"\2\2\u00bc"+
		"\u00c0\b\r\1\2\u00bd\u00bf\5*\26\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2"+
		"\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c3\u00c4\7#\2\2\u00c4\u00c5\b\r\1\2\u00c5\31\3\2\2\2"+
		"\u00c6\u00c7\5\n\6\2\u00c7\u00c8\7\66\2\2\u00c8\u00c9\7\n\2\2\u00c9\u00ca"+
		"\5\34\17\2\u00ca\u00cb\7\13\2\2\u00cb\u00cd\7\t\2\2\u00cc\u00ce\5\32\16"+
		"\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0"+
		"\b\16\1\2\u00d0\33\3\2\2\2\u00d1\u00d2\5\n\6\2\u00d2\u00d7\b\17\1\2\u00d3"+
		"\u00d4\7\f\2\2\u00d4\u00d5\5\34\17\2\u00d5\u00d6\b\17\1\2\u00d6\u00d8"+
		"\3\2\2\2\u00d7\u00d3\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\35\3\2\2\2\u00d9"+
		"\u00da\5 \21\2\u00da\u00db\7\b\2\2\u00db\u00dc\5\"\22\2\u00dc\u00de\7"+
		"\t\2\2\u00dd\u00df\5\36\20\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e1\b\20\1\2\u00e1\37\3\2\2\2\u00e2\u00e3\5\n\6"+
		"\2\u00e3\u00e8\b\21\1\2\u00e4\u00e5\7\f\2\2\u00e5\u00e6\5 \21\2\u00e6"+
		"\u00e7\b\21\1\2\u00e7\u00e9\3\2\2\2\u00e8\u00e4\3\2\2\2\u00e8\u00e9\3"+
		"\2\2\2\u00e9!\3\2\2\2\u00ea\u00eb\7\17\2\2\u00eb\u0100\b\22\1\2\u00ec"+
		"\u00ed\7\20\2\2\u00ed\u0100\b\22\1\2\u00ee\u00ef\7\16\2\2\u00ef\u0100"+
		"\b\22\1\2\u00f0\u00f1\7\21\2\2\u00f1\u0100\b\22\1\2\u00f2\u00f6\7\27\2"+
		"\2\u00f3\u00f4\7\4\2\2\u00f4\u00f5\7U\2\2\u00f5\u00f7\7\5\2\2\u00f6\u00f3"+
		"\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u0100\b\22\1\2"+
		"\u00f9\u00fa\5$\23\2\u00fa\u00fb\b\22\1\2\u00fb\u0100\3\2\2\2\u00fc\u00fd"+
		"\5\n\6\2\u00fd\u00fe\b\22\1\2\u00fe\u0100\3\2\2\2\u00ff\u00ea\3\2\2\2"+
		"\u00ff\u00ec\3\2\2\2\u00ff\u00ee\3\2\2\2\u00ff\u00f0\3\2\2\2\u00ff\u00f2"+
		"\3\2\2\2\u00ff\u00f9\3\2\2\2\u00ff\u00fc\3\2\2\2\u0100#\3\2\2\2\u0101"+
		"\u0102\7\26\2\2\u0102\u0103\7\4\2\2\u0103\u0104\5&\24\2\u0104\u0105\7"+
		"\5\2\2\u0105\u0106\7(\2\2\u0106\u0107\5\"\22\2\u0107\u0108\b\23\1\2\u0108"+
		"%\3\2\2\2\u0109\u010a\7U\2\2\u010a\u010b\7\6\2\2\u010b\u010c\7U\2\2\u010c"+
		"\u010d\b\24\1\2\u010d\'\3\2\2\2\u010e\u010f\5 \21\2\u010f\u0110\7\66\2"+
		"\2\u0110\u0111\5N(\2\u0111\u0112\7\t\2\2\u0112\u0114\b\25\1\2\u0113\u0115"+
		"\5(\25\2\u0114\u0113\3\2\2\2\u0114\u0115\3\2\2\2\u0115)\3\2\2\2\u0116"+
		"\u011d\5.\30\2\u0117\u011d\5\60\31\2\u0118\u011d\5\20\t\2\u0119\u011a"+
		"\5,\27\2\u011a\u011b\7\t\2\2\u011b\u011d\3\2\2\2\u011c\u0116\3\2\2\2\u011c"+
		"\u0117\3\2\2\2\u011c\u0118\3\2\2\2\u011c\u0119\3\2\2\2\u011d+\3\2\2\2"+
		"\u011e\u0123\58\35\2\u011f\u0123\5N(\2\u0120\u0123\5<\37\2\u0121\u0123"+
		"\5@!\2\u0122\u011e\3\2\2\2\u0122\u011f\3\2\2\2\u0122\u0120\3\2\2\2\u0122"+
		"\u0121\3\2\2\2\u0123-\3\2\2\2\u0124\u0125\7$\2\2\u0125\u0126\5N(\2\u0126"+
		"\u0127\b\30\1\2\u0127\u0128\7%\2\2\u0128\u0132\b\30\1\2\u0129\u012d\7"+
		"\"\2\2\u012a\u012c\5*\26\2\u012b\u012a\3\2\2\2\u012c\u012f\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u0130\3\2\2\2\u012f\u012d\3\2"+
		"\2\2\u0130\u0133\7#\2\2\u0131\u0133\5,\27\2\u0132\u0129\3\2\2\2\u0132"+
		"\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0138\b\30\1\2\u0135\u0136\7"+
		"\t\2\2\u0136\u0139\b\30\1\2\u0137\u0139\5\66\34\2\u0138\u0135\3\2\2\2"+
		"\u0138\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b\b\30\1\2\u013b/\3"+
		"\2\2\2\u013c\u013d\7\'\2\2\u013d\u013e\5N(\2\u013e\u013f\7(\2\2\u013f"+
		"\u0140\b\31\1\2\u0140\u0141\5\62\32\2\u0141\u0142\b\31\1\2\u0142\61\3"+
		"\2\2\2\u0143\u0145\5\64\33\2\u0144\u0143\3\2\2\2\u0145\u0148\3\2\2\2\u0146"+
		"\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2"+
		"\2\2\u0149\u014b\5\66\34\2\u014a\u0149\3\2\2\2\u014a\u014b\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u014d\7#\2\2\u014d\u014e\7\t\2\2\u014e\u014f\b\32"+
		"\1\2\u014f\63\3\2\2\2\u0150\u0151\5N(\2\u0151\u0152\b\33\1\2\u0152\u0157"+
		"\3\2\2\2\u0153\u0154\5&\24\2\u0154\u0155\b\33\1\2\u0155\u0157\3\2\2\2"+
		"\u0156\u0150\3\2\2\2\u0156\u0153\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0168"+
		"\7\b\2\2\u0159\u015d\7\"\2\2\u015a\u015c\5*\26\2\u015b\u015a\3\2\2\2\u015c"+
		"\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0160\3\2"+
		"\2\2\u015f\u015d\3\2\2\2\u0160\u0161\7#\2\2\u0161\u0166\7\t\2\2\u0162"+
		"\u0163\5,\27\2\u0163\u0164\7\t\2\2\u0164\u0166\3\2\2\2\u0165\u0159\3\2"+
		"\2\2\u0165\u0162\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0169\7\t\2\2\u0168"+
		"\u0165\3\2\2\2\u0168\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016b\b\33"+
		"\1\2\u016b\65\3\2\2\2\u016c\u0179\7&\2\2\u016d\u0171\7\"\2\2\u016e\u0170"+
		"\5*\26\2\u016f\u016e\3\2\2\2\u0170\u0173\3\2\2\2\u0171\u016f\3\2\2\2\u0171"+
		"\u0172\3\2\2\2\u0172\u0174\3\2\2\2\u0173\u0171\3\2\2\2\u0174\u0175\7#"+
		"\2\2\u0175\u017a\7\t\2\2\u0176\u0177\5,\27\2\u0177\u0178\7\t\2\2\u0178"+
		"\u017a\3\2\2\2\u0179\u016d\3\2\2\2\u0179\u0176\3\2\2\2\u017a\67\3\2\2"+
		"\2\u017b\u017c\5\n\6\2\u017c\u017d\7\b\2\2\u017d\u017e\7\66\2\2\u017e"+
		"\u017f\5N(\2\u017f\u0180\b\35\1\2\u01809\3\2\2\2\u0181\u0182\5N(\2\u0182"+
		"\u0187\b\36\1\2\u0183\u0184\7\f\2\2\u0184\u0185\5:\36\2\u0185\u0186\b"+
		"\36\1\2\u0186\u0188\3\2\2\2\u0187\u0183\3\2\2\2\u0187\u0188\3\2\2\2\u0188"+
		";\3\2\2\2\u0189\u018a\7K\2\2\u018a\u018b\7\n\2\2\u018b\u018c\5> \2\u018c"+
		"\u018d\7\13\2\2\u018d=\3\2\2\2\u018e\u018f\5:\36\2\u018f\u0190\b \1\2"+
		"\u0190?\3\2\2\2\u0191\u0192\7J\2\2\u0192\u0193\7\n\2\2\u0193\u0194\5B"+
		"\"\2\u0194\u0195\7\13\2\2\u0195A\3\2\2\2\u0196\u0197\5:\36\2\u0197\u0198"+
		"\b\"\1\2\u0198C\3\2\2\2\u0199\u019a\7L\2\2\u019a\u019b\7\n\2\2\u019b\u019c"+
		"\5N(\2\u019c\u019d\7\13\2\2\u019d\u019e\b#\1\2\u019eE\3\2\2\2\u019f\u01a0"+
		"\7O\2\2\u01a0\u01a1\7\n\2\2\u01a1\u01a2\5N(\2\u01a2\u01a3\7\13\2\2\u01a3"+
		"\u01a4\b$\1\2\u01a4G\3\2\2\2\u01a5\u01a6\7P\2\2\u01a6\u01a7\7\n\2\2\u01a7"+
		"\u01a8\5N(\2\u01a8\u01a9\7\13\2\2\u01a9\u01aa\b%\1\2\u01aaI\3\2\2\2\u01ab"+
		"\u01ac\7M\2\2\u01ac\u01ad\7\n\2\2\u01ad\u01ae\5N(\2\u01ae\u01af\7\13\2"+
		"\2\u01af\u01b0\b&\1\2\u01b0K\3\2\2\2\u01b1\u01b2\7N\2\2\u01b2\u01b3\7"+
		"\n\2\2\u01b3\u01b4\5N(\2\u01b4\u01b5\7\13\2\2\u01b5\u01b6\b\'\1\2\u01b6"+
		"M\3\2\2\2\u01b7\u01b8\b(\1\2\u01b8\u01b9\7\n\2\2\u01b9\u01ba\5N(\2\u01ba"+
		"\u01bb\7\13\2\2\u01bb\u01bc\b(\1\2\u01bc\u01f5\3\2\2\2\u01bd\u01be\7D"+
		"\2\2\u01be\u01bf\5N(\62\u01bf\u01c0\b(\1\2\u01c0\u01f5\3\2\2\2\u01c1\u01c2"+
		"\7@\2\2\u01c2\u01c3\5N(\61\u01c3\u01c4\b(\1\2\u01c4\u01f5\3\2\2\2\u01c5"+
		"\u01f5\3\2\2\2\u01c6\u01f5\3\2\2\2\u01c7\u01f5\3\2\2\2\u01c8\u01f5\3\2"+
		"\2\2\u01c9\u01f5\3\2\2\2\u01ca\u01cb\5\n\6\2\u01cb\u01cc\b(\1\2\u01cc"+
		"\u01f5\3\2\2\2\u01cd\u01f5\3\2\2\2\u01ce\u01cf\7Q\2\2\u01cf\u01f5\b(\1"+
		"\2\u01d0\u01f5\3\2\2\2\u01d1\u01d2\7R\2\2\u01d2\u01f5\b(\1\2\u01d3\u01f5"+
		"\3\2\2\2\u01d4\u01d5\7S\2\2\u01d5\u01f5\b(\1\2\u01d6\u01f5\3\2\2\2\u01d7"+
		"\u01d8\7U\2\2\u01d8\u01f5\b(\1\2\u01d9\u01f5\3\2\2\2\u01da\u01db\7V\2"+
		"\2\u01db\u01f5\b(\1\2\u01dc\u01f5\3\2\2\2\u01dd\u01de\5P)\2\u01de\u01df"+
		"\b(\1\2\u01df\u01f5\3\2\2\2\u01e0\u01f5\3\2\2\2\u01e1\u01e2\5D#\2\u01e2"+
		"\u01e3\b(\1\2\u01e3\u01f5\3\2\2\2\u01e4\u01f5\3\2\2\2\u01e5\u01e6\5J&"+
		"\2\u01e6\u01e7\b(\1\2\u01e7\u01f5\3\2\2\2\u01e8\u01f5\3\2\2\2\u01e9\u01ea"+
		"\5L\'\2\u01ea\u01eb\b(\1\2\u01eb\u01f5\3\2\2\2\u01ec\u01f5\3\2\2\2\u01ed"+
		"\u01ee\5F$\2\u01ee\u01ef\b(\1\2\u01ef\u01f5\3\2\2\2\u01f0\u01f5\3\2\2"+
		"\2\u01f1\u01f2\5H%\2\u01f2\u01f3\b(\1\2\u01f3\u01f5\3\2\2\2\u01f4\u01b7"+
		"\3\2\2\2\u01f4\u01bd\3\2\2\2\u01f4\u01c1\3\2\2\2\u01f4\u01c5\3\2\2\2\u01f4"+
		"\u01c6\3\2\2\2\u01f4\u01c7\3\2\2\2\u01f4\u01c8\3\2\2\2\u01f4\u01c9\3\2"+
		"\2\2\u01f4\u01ca\3\2\2\2\u01f4\u01cd\3\2\2\2\u01f4\u01ce\3\2\2\2\u01f4"+
		"\u01d0\3\2\2\2\u01f4\u01d1\3\2\2\2\u01f4\u01d3\3\2\2\2\u01f4\u01d4\3\2"+
		"\2\2\u01f4\u01d6\3\2\2\2\u01f4\u01d7\3\2\2\2\u01f4\u01d9\3\2\2\2\u01f4"+
		"\u01da\3\2\2\2\u01f4\u01dc\3\2\2\2\u01f4\u01dd\3\2\2\2\u01f4\u01e0\3\2"+
		"\2\2\u01f4\u01e1\3\2\2\2\u01f4\u01e4\3\2\2\2\u01f4\u01e5\3\2\2\2\u01f4"+
		"\u01e8\3\2\2\2\u01f4\u01e9\3\2\2\2\u01f4\u01ec\3\2\2\2\u01f4\u01ed\3\2"+
		"\2\2\u01f4\u01f0\3\2\2\2\u01f4\u01f1\3\2\2\2\u01f5\u0254\3\2\2\2\u01f6"+
		"\u01f7\f/\2\2\u01f7\u01f8\7\63\2\2\u01f8\u01f9\5N(\60\u01f9\u01fa\b(\1"+
		"\2\u01fa\u0253\3\2\2\2\u01fb\u01fc\f.\2\2\u01fc\u01fd\7\64\2\2\u01fd\u01fe"+
		"\5N(/\u01fe\u01ff\b(\1\2\u01ff\u0253\3\2\2\2\u0200\u0201\f-\2\2\u0201"+
		"\u0202\7\65\2\2\u0202\u0203\5N(.\u0203\u0204\b(\1\2\u0204\u0253\3\2\2"+
		"\2\u0205\u0206\f,\2\2\u0206\u0207\t\3\2\2\u0207\u0208\5N(-\u0208\u0209"+
		"\b(\1\2\u0209\u0253\3\2\2\2\u020a\u020b\f+\2\2\u020b\u020c\t\4\2\2\u020c"+
		"\u020d\5N(,\u020d\u020e\b(\1\2\u020e\u0253\3\2\2\2\u020f\u0210\f*\2\2"+
		"\u0210\u0211\t\5\2\2\u0211\u0212\5N(+\u0212\u0213\b(\1\2\u0213\u0253\3"+
		"\2\2\2\u0214\u0215\f(\2\2\u0215\u0216\t\6\2\2\u0216\u0217\5N()\u0217\u0218"+
		"\b(\1\2\u0218\u0253\3\2\2\2\u0219\u021a\f\'\2\2\u021a\u021b\7G\2\2\u021b"+
		"\u021c\5N((\u021c\u021d\b(\1\2\u021d\u0253\3\2\2\2\u021e\u021f\f&\2\2"+
		"\u021f\u0220\7\61\2\2\u0220\u0221\5N(\'\u0221\u0222\b(\1\2\u0222\u0253"+
		"\3\2\2\2\u0223\u0224\f%\2\2\u0224\u0225\7\62\2\2\u0225\u0226\5N(&\u0226"+
		"\u0227\b(\1\2\u0227\u0253\3\2\2\2\u0228\u0229\f#\2\2\u0229\u022a\7\66"+
		"\2\2\u022a\u022b\5N($\u022b\u022c\b(\1\2\u022c\u0253\3\2\2\2\u022d\u022e"+
		"\f\"\2\2\u022e\u022f\7\67\2\2\u022f\u0230\5N(#\u0230\u0231\b(\1\2\u0231"+
		"\u0253\3\2\2\2\u0232\u0233\f!\2\2\u0233\u0234\79\2\2\u0234\u0235\5N(\""+
		"\u0235\u0236\b(\1\2\u0236\u0253\3\2\2\2\u0237\u0238\f \2\2\u0238\u0239"+
		"\7;\2\2\u0239\u023a\5N(!\u023a\u023b\b(\1\2\u023b\u0253\3\2\2\2\u023c"+
		"\u023d\f\37\2\2\u023d\u023e\78\2\2\u023e\u023f\5N( \u023f\u0240\b(\1\2"+
		"\u0240\u0253\3\2\2\2\u0241\u0242\f\36\2\2\u0242\u0243\7:\2\2\u0243\u0244"+
		"\5N(\37\u0244\u0245\b(\1\2\u0245\u0253\3\2\2\2\u0246\u0247\f\34\2\2\u0247"+
		"\u0248\7>\2\2\u0248\u0249\7&\2\2\u0249\u024a\5N(\35\u024a\u024b\b(\1\2"+
		"\u024b\u0253\3\2\2\2\u024c\u024d\f\33\2\2\u024d\u024e\7<\2\2\u024e\u024f"+
		"\7%\2\2\u024f\u0250\5N(\34\u0250\u0251\b(\1\2\u0251\u0253\3\2\2\2\u0252"+
		"\u01f6\3\2\2\2\u0252\u01fb\3\2\2\2\u0252\u0200\3\2\2\2\u0252\u0205\3\2"+
		"\2\2\u0252\u020a\3\2\2\2\u0252\u020f\3\2\2\2\u0252\u0214\3\2\2\2\u0252"+
		"\u0219\3\2\2\2\u0252\u021e\3\2\2\2\u0252\u0223\3\2\2\2\u0252\u0228\3\2"+
		"\2\2\u0252\u022d\3\2\2\2\u0252\u0232\3\2\2\2\u0252\u0237\3\2\2\2\u0252"+
		"\u023c\3\2\2\2\u0252\u0241\3\2\2\2\u0252\u0246\3\2\2\2\u0252\u024c\3\2"+
		"\2\2\u0253\u0256\3\2\2\2\u0254\u0252\3\2\2\2\u0254\u0255\3\2\2\2\u0255"+
		"O\3\2\2\2\u0256\u0254\3\2\2\2\u0257\u0258\7W\2\2\u0258\u0259\b)\1\2\u0259"+
		"Q\3\2\2\2.VZ]`cou\u0083\u0087\u008a\u008d\u0091\u0094\u0098\u009b\u009d"+
		"\u00a2\u00a6\u00ad\u00c0\u00cd\u00d7\u00de\u00e8\u00f6\u00ff\u0114\u011c"+
		"\u0122\u012d\u0132\u0138\u0146\u014a\u0156\u015d\u0165\u0168\u0171\u0179"+
		"\u0187\u01f4\u0252\u0254";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}