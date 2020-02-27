grammar Pascal;

// Generate: antlr4 Pascal.g4
// Compile: javac Pascal*.java
// Run: grun Pascal program -tree gol.pascal

/**
 * Parser
 */
@header{
  import java.io.*;
  import java.util.*;
  import java.util.stream.IntStream;
}

@members{
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
}

start : program;

debug
   : program;

program
   : programHeading (ITR)? (programImports)? block DOT EOF;

programHeading: (PRM identifier (LPA identifierList RPA)? SEM)
   | (UNI identifier)
;

programImports
   : USE identifier SEM
   ;

identifier: IDE;

identifierList
   : identifier (COM identifier)*
   ;

block: (typeLab)?
       ((varLab (constLab)?)|(constLab (varLab)?))?
       (progLab)*
       ;

/** Program Blocks */
typeLab: TYP typeDef;

varLab: VAR varDef;

constLab: CST constDef;

progLab: BGN {
    if( this.debug == true){
        System.out.println("Begin Program");
    }
} (implementation)* END{
    if( this.debug == true){
        System.out.println("End Program");
    }
};

/** Program Operations */

typeDef:
    identifier EQU LPA typeType RPA SEM (typeDef)?
    ;

typeType:
    identifier (COM typeType)?
    ;

varDef:
    varList COL varType SEM (varDef)?
    ;

varList:
    identifier (COM varList)?
    ;

varType:
        INT
        | REL
        | BOL
        | CHR
        | STR ('[' INV ']')?
        | arrayAlloc
        | identifier
    ;

arrayAlloc :
    ARR '[' range ']' OF varType
    ;

range:
    low=INV '..' hi=INV
    ;

constDef:
    varList EQU expr SEM
    (constDef)?
;

/* Logic */
implementation:
    branch
    | cases
    | singleStatement SEM
    ;

singleStatement:
    assignment
    | expr
    | writeln
    | readln
    ;

branch:
    IF expr
    THN
    ((BGN (implementation)* END)|singleStatement) (SEM| elseCase)
    ;

cases:
    CAS expr OF
    caseList
    ;

caseList:
    (caseStatement)* (elseCase)? END SEM
    ;

caseStatement:
    (expr
    |range)
    COL ((((BGN(implementation)*END SEM)|(singleStatement SEM)))|SEM)
    ;

elseCase:
    ELS (((BGN(implementation)*END SEM)|(singleStatement SEM)))
    ;

assignment:
    identifier COL EQU expr
    ;

/* Arguments */

args:
    v=expr
    (COM args)?
    ;

/* Print Statements */

writeln:
    WRL LPA writelnFunc RPA
    ;

writelnFunc:
    args
    ;

readln:
    RDL LPA readlnFunc RPA
    ;

readlnFunc:
    args
    ;

/* Math */

sqrt:
    SQR LPA expr RPA
    ;

ln:
    LN LPA expr RPA
    ;

exp:
    EXP LPA expr RPA
    ;

sine:
    SIN LPA expr RPA
    ;

cosine:
    COS LPA expr RPA
    ;

/* Arithmetic */
expr:
    LPA e=expr RPA
    | BOC el=expr
    | NOT el=expr
    || el=expr MUL er=expr
    | el=expr DIV er=expr
    | el=expr MOD er=expr
    | el=expr (BND|AND) er=expr
    | el=expr (SHL|BSL) er=expr
    | el=expr (SHR|BSR) er=expr
    || el=expr (BOR|'!'|OR) er=expr
    | el=expr XOR er=expr
    | el=expr ADD er=expr
    | el=expr SUB er=expr
    || el=expr EQU er=expr
    | el=expr NEQ er=expr
    | el=expr LES er=expr
    | el=expr LEQ er=expr
    | el=expr GRT er=expr
    | el=expr GEQ er=expr
    || el=expr OR ELS er=expr
    | el=expr AND THN er=expr
    || identifier
    || PI
    || TRU
    || FLS
    || INV
    || DBV
    || string
    || sqrt
    || sine
    || cosine
    || ln
    || exp
    ;

string:
    STV
    ;
/**
 *Lexer
 */
fragment DGT: [0–9];
fragment LTR: [a-zA-Z];

fragment A: ('a' | 'A');
fragment B: ('b' | 'B');
fragment C: ('c' | 'C');
fragment D: ('d' | 'D');
fragment E: ('e' | 'E');
fragment F: ('f' | 'F');
fragment G: ('g' | 'G');
fragment H: ('h' | 'H');
fragment I: ('i' | 'I');
fragment J: ('j' | 'J');
fragment K: ('k' | 'K');
fragment L: ('l' | 'L');
fragment M: ('m' | 'M');
fragment N: ('n' | 'N');
fragment O: ('o' | 'O');
fragment P: ('p' | 'P');
fragment Q: ('q' | 'Q');
fragment R: ('r' | 'R');
fragment S: ('s' | 'S');
fragment T: ('t' | 'T');
fragment U: ('u' | 'U');
fragment V: ('v' | 'V');
fragment W: ('w' | 'W');
fragment X: ('x' | 'X');
fragment Y: ('y' | 'Y');
fragment Z: ('z' | 'Z');

//Operators
WS: [ \t\r\n]+ -> skip;
COL: ':';
SEM: ';';
LPA: '(';
RPA: ')';
COM: ',';
DOT: '.';

//Types
BOL: B O O L E A N;
INT: I N T E G E R;
REL: R E A L;
CHR: C H A R A C T E R;

PTR: '^';
ADR: '@';

ENM: E N U M;
SBR: '...';

ARR: A R R A Y;
STR: S T R I N G;
RCD: R E C O R D;

SET: S E T ' ' O F;
BSE: B A S E;

VRT: V A R I A N T;

//Labels
UNI: U N I T;
USE: U S E S;
VAR: V A R;
CST: C O N S T;
TYP: T Y P E;
PRM: P R O G R A M;
BGN: B E G I N;
END: E N D;

//Branch Words
IF: I F;
THN: T H E N;
ELS: E L S E;
CAS: C A S E;
OF: O F;

//Loop Words
WHL: W H I L E;
FOR: F O R;
DO: D O;
RPT: R E P E A T;
UTL: U N T I L;

//Functions
FUN: F U N C T I O N;
PRO: P R O C E D U R E S;
ITR: I N T E R F A C E;

//Arithmetic Operators
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
MOD: '%';

//Relational Operators
EQU: '=';
NEQ: '<>';
GRT: '>';
LES: '<';
GEQ: '>=';
LEQ: '<=';

//Boolean Operators
AND: A N D;
ATH: A N D ' ' T H E N;
OR: O R;
ORE: O R ' ' E L S E;
NOT: N O T;

//Bit Operators
BND: '&';
BOR: '|';
BNT: '!';
BOC: '~';
BSL: '<<';
BSR: '>>';
XOR: X O R;
SHL: S H L;
SHR: S H R;

//Special Functions
RDL: R E A D L N;
WRL: W R I T E L N;
SQR: S Q R T;
SIN: S I N;
COS: C O S;
LN: L N;
EXP: E X P;
PI: P I;

//Other Reserve Words
TRU: T R U E;
FLS: F A L S E;

//User Input
IDE: [_]*(LTR)([_]|LTR|DGT)*;
INV: [0-9]+;
DBV: [0-9]*'.'INV;
STV: '\''(~'\'')+'\'';

INLINE_COMMENT:		'//' .*? '\n'	-> skip;
INLINE_COMMENT_2:	'{' ~'\n'*? '}'	-> skip;
BLOCK_COMMENT:		'(*' .*? '*)'	-> skip;
BLOCK_COMMENT_2:	'{*' .*? '*}'	-> skip;