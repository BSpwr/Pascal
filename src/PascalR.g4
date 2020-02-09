grammar PascalR;

// Generate: antlr4 PascalR.g4
// Compile: javac PascalR*.java
// Run: grun PascalR program -tree gol.pascal

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
     else {
        this.throwE("Undefined symbol.");
        return null;
     }
  }

  Boolean debug = new Boolean(false);
  Boolean toggle = new Boolean(false);
  Boolean hasMoreVars = new Boolean(false);

  HashMap<String,Object> variables = new HashMap<String,Object>();
  HashMap<String,Object> constants = new HashMap<String,Object>();
}

debug
   : {debug = new Boolean(true);} program;

program
   : (comment)? programHeading (comment)? (ITR)? (comment)? (programImports)? block DOT EOF;

programHeading returns[Boolean b, String s]
   : (PRM identifier (LPA identifierList RPA)? SEM)
   | (UNI identifier)
;

programImports
   : USE identifier SEM
   ;

identifier returns[String s]:
   IDE {$s = $IDE.text;}
   ;

identifierList
   : identifier (COM identifier)*
   ;

block: (comment)?
       (typeLab)?
       (comment)?
       ((varLab(comment)?(constLab)?)|(constLab(comment)?(varLab)?))
       (progLab)*
       (comment)?
       ;

/** Program Blocks */

comment: LPA MUL (~'*)')* '*)';

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

typeDef:;

varDef:
    varList COL varType SEM (varDef)? {
        this.variables.putAll(IntStream.range(0, $varList.s.size())
                               .collect(HashMap::new,
                               (map, i) -> map.put($varList.s.get(i), $varType.o),
                               Map::putAll));
        //print out the variable map
        if( this.debug == true){
            System.out.println("VARs defined:");
            ArrayList<String> varNames = $varList.s;
            for(int i = 0; i < varNames.size(); i++){
                System.out.println("\tIdentifier:" + varNames.get(i));
                System.out.println("\tValue:" + this.variables.get(varNames.get(i)));
            }
        }
    };

varList returns[ArrayList<String> s]:
    identifier (COM varList{ this.hasMoreVars = new Boolean(true); })? {
        $s = new ArrayList<String>();
        $s.add($identifier.s);
        if(hasMoreVars == true){
            $s.addAll($varList.s);
            this.hasMoreVars = new Boolean(false);
        }
    };

varType returns[Object o]:(
        INT {
            $o = new Integer(0);
        }
        | REL {
            $o = new Double(0);
        }
        | BOL {
            $o = new Boolean(false);
        }
        | CHR {
            $o = new Character('\0');
        }
        | STR ('[' INV ']')?{
            $o = new String();
        }
        | arrayAlloc {
            $o = $arrayAlloc.o;
        }
);

arrayAlloc returns[ArrayList<Object> o]:
    ARR '[' low=INV '..' hi=INV ']' OF varType{
        Integer length = Integer.parseInt($hi.text) - Integer.parseInt($low.text);
        $o = new ArrayList<Object>(length + 1);
        $o.add(length);
        for(int i = 0; i < length; i++){
            $o.add($varType.o);
        }
    }
;

constDef:
    varList EQU expr SEM {
        this.constants.putAll(IntStream.range(0, $varList.s.size())
                               .collect(HashMap::new,
                               (map, i) -> map.put($varList.s.get(i), $expr.o),
                               Map::putAll));
        //Print out constants from hashmap
        if( this.debug == true){
            System.out.println("CONSTs defined:");
            ArrayList<String> varNames = $varList.s;
            for(int i = 0; i < varNames.size(); i++){
                System.out.println("\tIdentifier:" + varNames.get(i));
                System.out.println("\tValue:" + this.constants.get(varNames.get(i)));
            }
        }
    } (constDef)?
;

/* Logic */
implementation:
    branch
    | case
    | comment
    | singleStatement SEM
    ;

singleStatement:
    assignment
    | expr
    | writeln
    | readln
    ;

branch:
    IF expr{
        if(this.toggle != true){
            this.toggle = new Boolean(!(Boolean)$expr.o);
        }
    } THN {
        if( this.debug == true){
            System.out.println("Entering inner case.");
        }
    } ((BGN (implementation)* END)|singleStatement){this.toggle = new Boolean(!this.toggle);} (SEM{this.toggle = new Boolean(false);})? {
        if( this.debug == true){
            System.out.println("Exiting inner case.");
        }
    } (ELS ((BGN (implementation)* END)|singleStatement))? SEM{this.toggle = new Boolean(false);}
    ;

case:
    CAS expr OF caseList{
        if(this.toggle != true){
            if($expr.o instanceof Character || $expr.o instanceof Integer){
                
            }
        }
    }
    ;

caseList returns[<Object,Object>]:
    CAS
    ;

assignment:
    identifier COL EQU expr{
        if(this.toggle != true){
            setVariable($identifier.s, $expr.o);
        }
    }
    ;
/* Arguments */

args returns[LinkedHashMap<String,Object> o]:
    v=expr {
        if(this.toggle != true){
           $o = new LinkedHashMap<String,Object>();
           $o.put($v.text,$v.o);
        }
    } (COM args {
        if(this.toggle != true){
           $o.putAll($args.o);
        }
    })?
    ;

/* Print Statements */

writeln:
    WRL LPA writelnFunc RPA
    ;

writelnFunc:
    args{
        if(this.toggle != true){
            BufferedWriter foutput = new BufferedWriter(new OutputStreamWriter(System.out));
            for(HashMap.Entry<String, Object> arg : $args.o.entrySet()){
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
    ;

readln:
    RDL LPA readlnFunc RPA
    ;

readlnFunc:
    args{
        if(this.toggle != true){
           Scanner uinput = new Scanner(System.in);
           Object v;
           for(HashMap.Entry<String, Object> arg : $args.o.entrySet()){
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
    ;

/* Math */

sqrt returns[Double d]:
    SQR LPA expr RPA{
        if(this.toggle != true){
            if($expr.o instanceof Double){
                $d = Math.sqrt((Double)$expr.o);
            }
            else if($expr.o instanceof Integer){
                $d = Math.sqrt(Double.valueOf((Integer)$expr.o));
            }
            else{
                throwE("Illegal Operation: Type is not a Real or an Integer!");
            }
        }
    }
    ;

ln returns[Double d]:
    LN LPA expr RPA{
        if(this.toggle != true){
            if($expr.o instanceof Double){
                $d = Math.sqrt((Double)$expr.o);
            }
            else if($expr.o instanceof Integer){
                $d = Math.sqrt(Double.valueOf((Integer)$expr.o));
            }
            else{
                throwE("Illegal Operation: Type is not a Real or an Integer!");
            }
        }
    }
    ;

exp returns[Double d]:
    EXP LPA expr RPA{
        if(this.toggle != true){
            if($expr.o instanceof Double){
                $d = Math.exp((Double)$expr.o);
            }
            else if($expr.o instanceof Integer){
                $d = Math.exp(Double.valueOf((Integer)$expr.o));
            }
            else{
                throwE("Illegal Operation: Type is not a Real or an Integer!");
            }
        }
    }
    ;

sine returns[Double d]:
    SIN LPA expr RPA{
        if(this.toggle != true){
            if($expr.o instanceof Double){
                $d = Math.sin((Double)$expr.o);
            }
            else if($expr.o instanceof Integer){
                $d = Math.sin(Double.valueOf((Integer)$expr.o));
            }
            else{
                throwE("Illegal Operation: Type is not a Real or an Integer!");
            }
        }
    }
    ;

cosine returns[Double d]:
    COS LPA expr RPA{
        if(this.toggle != true){
            if($expr.o instanceof Double){
                $d = Math.cos((Double)$expr.o);
            }
            else if($expr.o instanceof Integer){
                $d = Math.cos(Double.valueOf((Integer)$expr.o));
            }
            else{
                throwE("Illegal Operation: Type is not a Real or an Integer!");
            }
        }
    }
    ;

/* Arithmetic */
expr returns[Object o]:
    LPA e=expr RPA {
        if(this.toggle != true){
            $o = $e.o;
        }
    }
    | BOC el=expr {
        if(this.toggle != true){
            if($el.o instanceof Integer || $el.o instanceof Character){
                $o = ~(Integer)$el.o;
            }
            else if($el.o instanceof Boolean){
                $o = !(Boolean)$el.o;
            }
            else{
                $o = null;
                throwE("Illegal Operation: Incompatible Type!");
            }
        }
    }
    | NOT el=expr {
        if(this.toggle != true){
            if($el.o instanceof Integer || $el.o instanceof Character){
                $o = ~(Integer)$el.o;
            }
            else if($el.o instanceof Boolean){
                $o = !(Boolean)$el.o;
            }
            else{
                $o = null;
                throwE("Illegal Operation: Incompatible Type!");
            }
        }
    }
    || el=expr MUL er=expr {
        if(this.toggle != true){
            if((($el.o instanceof Integer) && ($er.o instanceof Integer)) || (($el.o instanceof Character) && ($er.o instanceof Character))){
                $o = (Integer)$el.o * (Integer)$er.o;
            }
            else if(($el.o instanceof Double) && ($er.o instanceof Double)){
                $o = (Double)$el.o * (Double)$er.o;
            }
            else{
                $o = null;
                throwE("Illegal Operation: Incompatible Type!");
            }
        }
    }
    | el=expr DIV er=expr {
        if(this.toggle != true){
            if((($el.o instanceof Integer) && ($er.o instanceof Integer)) || (($el.o instanceof Character) && ($er.o instanceof Character))){
                $o = (Integer)$el.o / (Integer)$er.o;
            }
            else if(($el.o instanceof Double) && ($er.o instanceof Double)){
                $o = (Double)$el.o / (Double)$er.o;
            }
            else{
                $o = null;
                throwE("Illegal Operation: Incompatible Type!");
            }
        }
    }
    | el=expr MOD er=expr {
        if(this.toggle != true){
            if((($el.o instanceof Integer) && ($er.o instanceof Integer)) || (($el.o instanceof Character) && ($er.o instanceof Character))){
                $o = (Integer)$el.o % (Integer)$er.o;
            }
            else if(($el.o instanceof Double) && ($er.o instanceof Double)){
                $o = (Double)$el.o % (Double)$er.o;
            }
            else{
                $o = null;
                throwE("Illegal Operation: Incompatible Type!");
            }
        }
    }
    | el=expr (BND|AND) er=expr {
        if(this.toggle != true){
            if((($el.o instanceof Integer) && ($er.o instanceof Integer)) || (($el.o instanceof Character) && ($er.o instanceof Character))){
                $o = (Integer)$el.o & (Integer)$er.o;
            }
            else if(($el.o instanceof Double) && ($er.o instanceof Double)){
                $o = (Boolean)$el.o & (Boolean)$er.o;
            }
            else{
                $o = null;
                throwE("Illegal Operation: Incompatible Type!");
            }
        }
    }
    | el=expr (SHL|BSL) er=expr {
        if(this.toggle != true){
            if((($el.o instanceof Integer) && ($er.o instanceof Integer)) || (($el.o instanceof Character) && ($er.o instanceof Character))){
                $o = (Integer)$el.o << (Integer)$er.o;
            }
            else{
                $o = null;
                throwE("Illegal Operation: Incompatible Type!");
            }
        }
    }
    | el=expr (SHR|BSR) er=expr{
        if(this.toggle != true){
            if((($el.o instanceof Integer) && ($er.o instanceof Integer)) || (($el.o instanceof Character) && ($er.o instanceof Character))){
                $o = (Integer)$el.o >> (Integer)$er.o;
            }
            else{
                $o = null;
                throwE("Illegal Operation: Incompatible Type!");
            }
        }
    }
    || el=expr (BOR|'!'|OR) er=expr {
        if(this.toggle != true){
            if((($el.o instanceof Integer) && ($er.o instanceof Integer)) || (($el.o instanceof Character) && ($er.o instanceof Character))){
                $o = (Integer)$el.o | (Integer)$er.o;
            }
            else if(($el.o instanceof Double) && ($er.o instanceof Double)){
                $o = (Boolean)$el.o | (Boolean)$er.o;
            }
            else{
                $o = null;
                throwE("Illegal Operation: Incompatible Type!");
            }
        }
    }
    | el=expr XOR er=expr {
        if(this.toggle != true){
            if((($el.o instanceof Integer) && ($er.o instanceof Integer)) || (($el.o instanceof Character) && ($er.o instanceof Character))){
                $o = (Integer)$el.o ^ (Integer)$er.o;
            }
            else if(($el.o instanceof Double) && ($er.o instanceof Double)){
                $o = (Boolean)$el.o ^ (Boolean)$er.o;
            }
            else{
                $o = null;
                throwE("Illegal Operation: Incompatible Type!");
            }
        }
    }
    | el=expr ADD er=expr {
        if(this.toggle != true){
            if((($el.o instanceof Integer) && ($er.o instanceof Integer)) || (($el.o instanceof Character) && ($er.o instanceof Character))){
                $o = (Integer)$el.o + (Integer)$er.o;
            }
            else if(($el.o instanceof Double) && ($er.o instanceof Double)){
                $o = (Double)$el.o + (Double)$er.o;
            }
            else{
                $o = null;
                throwE("Illegal Operation: Incompatible Type!");
            }
        }
    }
    | el=expr SUB er=expr {
        if(this.toggle != true){
            if((($el.o instanceof Integer) && ($er.o instanceof Integer)) || (($el.o instanceof Character) && ($er.o instanceof Character))){
                $o = (Integer)$el.o - (Integer)$er.o;
            }
            else if(($el.o instanceof Double) && ($er.o instanceof Double)){
                $o = (Double)$el.o - (Double)$er.o;
            }
            else{
                $o = null;
                throwE("Illegal Operation: Incompatible Type!");
            }
        }
    }
    || el=expr EQU er=expr {
        if(this.toggle != true){
            if($el.o instanceof Boolean && $er.o instanceof Integer){
                $o = ((Boolean)$el.o.equals((Integer)$er.o >= 1));
            }
            else if($er.o instanceof Boolean && $el.o instanceof Integer){
                $o = ((Boolean)$er.o.equals((Integer)$el.o >= 1));
            }
            else{
                $o = $el.o.equals($er.o);
            }
        }
    }
    | el=expr NEQ er=expr {
        if(this.toggle != true){
            if($el.o instanceof Boolean && $er.o instanceof Integer){
                $o = !((Boolean)$el.o.equals((Integer)$er.o >= 1));
            }
            else if($er.o instanceof Boolean && $el.o instanceof Integer){
                $o = !((Boolean)$er.o.equals((Integer)$el.o >= 1));
            }
            else{
                $o = !($el.o.equals($er.o));
            }
        }
    }
    | el=expr LES er=expr {
        if(this.toggle != true){
            if((($el.o instanceof Integer) && ($er.o instanceof Integer)) || (($el.o instanceof Character) && ($er.o instanceof Character))){
                $o = (Integer)$el.o < (Integer)$er.o;
            }
            else if(($el.o instanceof Double) && ($er.o instanceof Double)){
                $o = (Double.compare((Double)$el.o, (Double)$er.o) < 0);
            }
            else{
                $o = null;
                throwE("Illegal Operation: Incompatible Type!");
            }
        }
    }
    | el=expr LEQ er=expr {
        if(this.toggle != true){
            if((($el.o instanceof Integer) && ($er.o instanceof Integer)) || (($el.o instanceof Character) && ($er.o instanceof Character))){
                $o = (Integer)$el.o <= (Integer)$er.o;
            }
            else if(($el.o instanceof Double) && ($er.o instanceof Double)){
                $o = (Double.compare((Double)$el.o, (Double)$er.o) <= 0);
            }
            else{
                $o = null;
                throwE("Illegal Operation: Incompatible Type!");
            }
        }
    }
    | el=expr GRT er=expr {
        if(this.toggle != true){
            if((($el.o instanceof Integer) && ($er.o instanceof Integer)) || (($el.o instanceof Character) && ($er.o instanceof Character))){
                $o = (Integer)$el.o > (Integer)$er.o;
            }
            else if(($el.o instanceof Double) && ($er.o instanceof Double)){
                $o = (Double.compare((Double)$el.o, (Double)$er.o) > 0);
            }
            else{
                $o = null;
                throwE("Illegal Operation: Incompatible Type!");
            }
        }
    }
    | el=expr GEQ er=expr {
        if(this.toggle != true){
            if((($el.o instanceof Integer) && ($er.o instanceof Integer)) || (($el.o instanceof Character) && ($er.o instanceof Character))){
                $o = (Integer)$el.o >= (Integer)$er.o;
            }
            else if(($el.o instanceof Double) && ($er.o instanceof Double)){
                $o = (Double.compare((Double)$el.o, (Double)$er.o) >= 0);
            }
            else{
                $o = null;
                throwE("Illegal Operation: Incompatible Type!");
            }
        }
    }
    || el=expr OR ELS er=expr {
        if(this.toggle != true){
            if(($el.o instanceof Boolean) && ($er.o instanceof Boolean)){
                $o = (Boolean)$el.o || (Boolean)$er.o;
            }
        }
    }
    | el=expr AND THN er=expr {
        if(this.toggle != true){
            if(($el.o instanceof Boolean) && ($er.o instanceof Boolean)){
                $o = (Boolean)$el.o && (Boolean)$er.o;
            }
        }
    }
    || identifier {
        if(this.toggle != true){
            $o = getVariable($identifier.s);
        }
    }
    || PI{
        if(this.toggle != true){
            $o = new Double(Math.PI);
        }
    }
    || TRU {
        if(this.toggle != true){
            $o = new Boolean(true);
        }
    }
    || FLS {
        if(this.toggle != true){
            $o = new Boolean(false);
        }
    }
    || INV {
        if(this.toggle != true){
            $o = new Integer(Integer.parseInt($INV.text));
        }
    }
    || DBV {
        if(this.toggle != true){
            $o = new Double(Double.parseDouble($DBV.text));
        }
    }
    || string {
        if(this.toggle != true){
            $o = new String($string.s);
        }
    }
    || sqrt {
        if(this.toggle != true){
            $o = new Double($sqrt.d);
        }
    }
    || sine {
        if(this.toggle != true){
            $o = new Double($sine.d);
        }
    }
    || cosine {
        if(this.toggle != true){
            $o = new Double($cosine.d);
        }
    }
    || ln {
        if(this.toggle != true){
            $o = new Double($ln.d);
        }
    }
    || exp {
        if(this.toggle != true){
            $o = new Double($exp.d);
        }
    }
    ;

string returns[String s]:
    STV{
        //drop the quotes surrounding the string
         String st = $STV.text;
         $s = new String(st.substring(1,st.length()-1));
    }
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
LDO: D O;
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