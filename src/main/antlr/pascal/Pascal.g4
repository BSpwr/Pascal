grammar Pascal;

// Generate: antlr4 Pascal.g4
// Compile: javac Pascal*.java
// Run: grun Pascal program -tree gol.pascal

/**
 * Parser
 */

start
    : debug
    ;

debug
    : program
    ;

program
    : programHeading (ITR)? (programImports)? (decBlocks SEM)? (codeDefs SEM)? progBlock DOT EOF
    ;

programHeading
    : (PRM identifier (LPA identifierList RPA)? SEM)
    | (UNI identifier)
    ;

programImports
    : USE identifier SEM
    ;

identifier
    : IDE
    ;

identifierList
    : identifier (COM identifier)*
    ;

decBlocks
    : decBlock SEM decBlocks
    | decBlock
    ;

decBlock
    : typeLab
    | varLab
    | constLab
    ;

/** Declaration Blocks */
typeLab
    : TYP typeDef
    ;

varLab
    : VAR varDef
    ;

constLab
    : CST constDef
    ;

/** Code Block **/
progBlock
    : BGN statements END
    ;

/** Program Operations */

typeDef
    : identifier EQU LPA typeType RPA (SEM typeDef)?
    ;

typeType
    : identifier (COM typeType)?
    ;

varDef
    : varList COL varType (SEM varDef)?
    ;

varList
    : identifier (COM varList)?
    ;

varType
    : INT
    | REL
    | BOL
    | CHR
    | STR ('[' INV ']')?
    | arrayAlloc
    | identifier
    ;

arrayAlloc
    : ARR '[' range ']' OF varType
    ;

range
    : low=INV '..' hi=INV
    ;

constDef
    : varList EQU expr (SEM constDef)?
    ;

/* Logic */

statements
	: implMaybe SEM statements
	| implMaybe
	;

implMaybe
    : (implementation|SEM)?
    ;

implementation
    : assignment
    | expr
    | writeln
    | readln
    | branch
    | cases
    | progBlock
    | whileLoop
    | forLoop
    | repeatUntilLoop
    | codeExec
    | BRK
    | CONT
    ;

branch
    :
    IF expr
    THN
    implMaybe (elseBranch)?
    ;

elseBranch
    : ELS implMaybe
    ;

cases
    :
    CAS expr OF
    (caseStatement)* (elseCase)? END
    ;

caseStatement
    :
    (expr |range)
    COL (implementation)? SEM
    ;

elseCase
    : ELS (implementation)? SEM
    ;

assignment
    : identifier COL EQU expr
    ;

whileLoop
    :
    WHL expr DO
    implMaybe
    ;

forLoop
    :
    FOR identifier COL EQU initial=expr (TO|DOWNTO) target=expr DO
    implMaybe
    ;

repeatUntilLoop
    :
    RPT
    statements
    UTL expr
    ;

codeExec
    : identifier LPA (args)? RPA
    ;

codeDefs
    : (functionDef | procedureDef) (SEM codeDefs)?
    ;

functionDef
    :
    FUN identifier LPA (argsTypeList)? RPA COL varType SEM
    (decBlocks SEM)? progBlock
    ;

procedureDef
    :
    PRO identifier LPA (argsTypeList)? RPA SEM
    (decBlocks SEM)? progBlock
    ;

argsTypeList
    : varList COL varType (SEM argsTypeList)?
    ;

/* Arguments */

args
    : expr (COM args)?
    ;

/* Print Statements */

writeln
    : WRL LPA args RPA
    ;

readln
    : RDL LPA typeType RPA
    ;

/* Math */

sqrt
    : SQR LPA expr RPA
    ;

ln
    : LN LPA expr RPA
    ;

exp
    : EXP LPA expr RPA
    ;

sine
    : SIN LPA expr RPA
    ;

cosine
    : COS LPA expr RPA
    ;

/* Expressions */
expr
    : LPA expr RPA #parenExpr
    | BOC expr #bitwiseNotExpr
    | NOT expr #notExpr
    | el=expr MUL er=expr #mulExpr
    | el=expr DIV er=expr #divExpr
    | el=expr MOD er=expr #modExpr
    | el=expr (BND|AND) er=expr #andExpr
    | el=expr (SHL|BSL) er=expr #bitwiseShiftLeftExpr
    | el=expr (SHR|BSR) er=expr #bitwiseShiftRightExpr
    | el=expr (BOR|'!'|OR) er=expr #orExpr
    | el=expr XOR er=expr #xorExpr
    | el=expr ADD er=expr #addExpr
    | el=expr SUB er=expr #subExpr
    | el=expr EQU er=expr #equExpr
    | el=expr NEQ er=expr #notEquExpr
    | el=expr LES er=expr #lesExpr
    | el=expr LEQ er=expr #leqExpr
    | el=expr GRT er=expr #grtExpr
    | el=expr GEQ er=expr #geqExpr
    | el=expr OR ELS er=expr #orElseExpr
    | el=expr AND THN er=expr #andThenExpr
    | identifier #identifierExpr
    | PI #piLiteralExpr
    | TRU #trueLiteralExpr
    | FLS #falseLiteralExpr
    | INV #integerLiteralExpr
    | DBV #doubleLiteralExpr
    | string #stringExpr
    | sqrt #sqrtExpr
    | sine #sineExpr
    | cosine #cosineExpr
    | ln #lnExpr
    | exp #expExpr
    | codeExec #codeExpr
    ;

string
    : STV
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
TO: T O;
DOWNTO : D O W N T O;
BRK: B R E A K;
CONT: C O N T I N U E;

//Functions
FUN: F U N C T I O N;
PRO: P R O C E D U R E;
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