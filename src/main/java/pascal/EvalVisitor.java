package pascal;

import org.graalvm.compiler.debug.CSVUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.IntStream;

public class EvalVisitor extends PascalBaseVisitor<Value> {

    Boolean debug = false;

    Stack<Boolean> branchHistory = new Stack<Boolean>();

    Boolean toggle = false;
    Boolean breakCase = false;
    Value caseSel = Value.VOID;

    HashMap<String, Value> variables = new HashMap<String, Value>();
    HashMap<String, Value> constants = new HashMap<String, Value>();
    HashMap<String, ArrayList<String>> enums = new HashMap<String, ArrayList<String>>();

    HashMap<String, String> enumVariableType = new HashMap<String, String>();
    HashMap<String, String> reserved = new HashMap<String, String>();

    // util

    public void throwE(String msg) {
        System.out.println(msg);
        System.exit(1);
    }

    public void setVariable(String key, Value val) {
        if (variables.containsKey(key)) {
            Value v = val;
            Value k = getVariable(key);
            if (v.equalType(k)) {
                variables.replace(key, v);
            } else
                this.throwE("Unmatched types");
        } else if (reserved.containsKey(key)) {
            boolean isValid = false;
            ArrayList<String> arr = enums.get(this.enumVariableType.get(key));
            for (String s : arr) {
                if (val.isString() && val.asString().equals(s)) {
                    isValid = true;
                    break;
                }
            }
            if (isValid) {
                this.reserved.replace(key, val.asString());
            } else {
                this.throwE("Attempted to assign an enum of a different or undefined type.");
            }
        } else if (this.constants.containsKey(key)) {
            this.throwE("Attempted to assign to a constant.");
        } else {
            this.throwE("Undefined symbol.");
        }
    }

    public Value getVariable(String key) {
        if (this.variables.containsKey(key)) {
            return this.variables.get(key);
        } else if (this.constants.containsKey(key)) {
            return this.constants.get(key);
        } else if (this.reserved.containsKey(key)) {
            return new Value(reserved.get(key));
        } else {
            if (debug) {
                System.out.println("Checking if the identifier is an enum.");
            }

            for (HashMap.Entry<String, ArrayList<String>> a : enums.entrySet()) {
                for (String s : a.getValue()) {
                    if (s.equals((String) key)) {
                        return new Value(key);
                    }
                }
            }

            this.throwE("Undefined symbol.");
            return Value.VOID;
        }
    }

    // visitor start

    @Override
    public Value visitStart(PascalParser.StartContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitDebug(PascalParser.DebugContext ctx) {
        debug = true;
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitProgram(PascalParser.ProgramContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitProgramHeading(PascalParser.ProgramHeadingContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitProgramImports(PascalParser.ProgramImportsContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitIdentifier(PascalParser.IdentifierContext ctx) {
        return new Value(ctx.getText());
    }

    @Override
    public Value visitIdentifierList(PascalParser.IdentifierListContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitBlock(PascalParser.BlockContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitTypeLab(PascalParser.TypeLabContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitVarLab(PascalParser.VarLabContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitConstLab(PascalParser.ConstLabContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitProgLab(PascalParser.ProgLabContext ctx) {
        if (debug) System.out.println("Begin Program");
        visitChildren(ctx);
        if (debug) System.out.println("End Program");
        return Value.VOID;
    }

    @Override
    public Value visitTypeDef(PascalParser.TypeDefContext ctx) {
        Value ident = this.visit(ctx.identifier());
        Value typeType = this.visit(ctx.typeType());
        enums.put(ident.asString(), typeType.asStringArrayList());
        //print out the variable map
        if (debug) {
            for (HashMap.Entry<String, ArrayList<String>> a : enums.entrySet()) {
                System.out.println("\tType:" + a.getKey());
                for (String s : a.getValue()) {
                    System.out.println("\tValue:" + s);
                }
            }
        }
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitTypeType(PascalParser.TypeTypeContext ctx) {
        ArrayList<String> ret = new ArrayList<String>();
        Value ident = this.visit(ctx.identifier());
        ret.add(ident.asString());
        if (ctx.typeType() != null) {
            Value typeType = this.visit(ctx.typeType());
            ret.addAll(typeType.asStringArrayList());
        }
        return new Value(ret);
    }

    @Override
    public Value visitVarDef(PascalParser.VarDefContext ctx) {

        Value varType = this.visit(ctx.varType());
        Value varList = this.visit(ctx.varList());

        ArrayList<String> varNames = varList.asStringArrayList();

        if (varType.isString() && !varType.toString().isEmpty()) {
            enumVariableType.putAll(IntStream.range(0, varNames.size())
                    .collect(HashMap::new,
                            (map, i) -> map.put(varNames.get(i), varType.asString()),
                            Map::putAll));
            reserved.putAll(IntStream.range(0, varNames.size())
                    .collect(HashMap::new,
                            (map, i) -> map.put(varNames.get(i), varType.asString()),
                            Map::putAll));
        } else {
            variables.putAll(IntStream.range(0, varNames.size())
                    .collect(HashMap::new,
                            (map, i) -> map.put(varNames.get(i), varType),
                            Map::putAll));
        }
        // print out the variable map
        if (debug) {
            System.out.println("VARs defined:");

            for (int i = 0; i < varNames.size(); i++) {
                System.out.println("\tIdentifier:" + varNames.get(i));
                System.out.println("\tValue:" + variables.get(varNames.get(i)));
            }
        }

        if (ctx.varDef() != null)
            this.visit(ctx.varDef());

        return Value.VOID;
    }

    @Override
    public Value visitVarList(PascalParser.VarListContext ctx) {
        ArrayList<String> ret = new ArrayList<String>();
        Value ident = this.visit(ctx.identifier());
        ret.add(ident.asString());
        if (ctx.varList() != null) {
            Value listToAppendTo = this.visit(ctx.varList());
            ret.addAll(listToAppendTo.asStringArrayList());
        }
        return new Value(ret);
    }

    @Override
    public Value visitVarType(PascalParser.VarTypeContext ctx) {
        String text = ctx.getText().toLowerCase();
        switch (text) {
            case "integer":
                return Value.INTEGER;
            case "real":
                return Value.REAL;
            case "boolean":
                return Value.BOOLEAN;
            case "character":
                return Value.CHARACTER;
            case "string":
                return Value.STRING;
        }

        if (ctx.arrayAlloc() != null) {
            Value arrayAlloc = this.visit(ctx.arrayAlloc());
            return arrayAlloc;
        } else if (ctx.identifier() != null) {
            Value ident = this.visit(ctx.identifier());
            return ident;
        }

        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitArrayAlloc(PascalParser.ArrayAllocContext ctx) {
        Value range = this.visit(ctx.range());
        Value varType = this.visit(ctx.varType());

        Integer length = (Integer) range.asIntegerArrayList().get(1) - range.asIntegerArrayList().get(0);
        ArrayList<Object> ret = new ArrayList<Object>(length + 1);

        for (int i = 0; i <= length; i++) {
            ret.add(varType);
        }

        return new Value(ret);
    }

    @Override
    public Value visitRange(PascalParser.RangeContext ctx) {
        Integer low = Integer.parseInt(ctx.low.getText());
        Integer high = Integer.parseInt(ctx.hi.getText());
        ArrayList<Integer> ret = new ArrayList<Integer>() {{
            add(low);
            add(high);
        }};
        return new Value(ret);
    }

    @Override
    public Value visitConstDef(PascalParser.ConstDefContext ctx) {

        Value varList = this.visit(ctx.varList());
        ArrayList<String> varNames = varList.asStringArrayList();

        Value expr = this.visit(ctx.expr());

        constants.putAll(IntStream.range(0, varNames.size())
                .collect(HashMap::new,
                        (map, i) -> map.put(varNames.get(i), expr),
                        Map::putAll));

        if (debug) {
            System.out.println("CONSTs defined:");
            for (int i = 0; i < varNames.size(); i++) {
                System.out.println("\tIdentifier:" + varNames.get(i));
                System.out.println("\tValue:" + this.constants.get(varNames.get(i)));
            }
        }

        if (ctx.constDef() != null)
            this.visit(ctx.constDef());

        return Value.VOID;
    }

    @Override
    public Value visitImplementation(PascalParser.ImplementationContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitBlockStatement(PascalParser.BlockStatementContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitSingleStatement(PascalParser.SingleStatementContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitBranch(PascalParser.BranchContext ctx) {
//        Value expr = this.visit(ctx.expr());
//
//        // if condition true
//        if (true) {
//            this.visit(ctx.implementation());
//        }

        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitCases(PascalParser.CasesContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitCaseList(PascalParser.CaseListContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitCaseStatement(PascalParser.CaseStatementContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitElseCase(PascalParser.ElseCaseContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitAssignment(PascalParser.AssignmentContext ctx) {
        // System.out.println(ctx.getText());

        Value ident = this.visit(ctx.identifier());
        Value expr = this.visit(ctx.expr());

        setVariable(ident.asString(), expr);

        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitArgs(PascalParser.ArgsContext ctx) {

        ArrayList<Value> args = new ArrayList<Value>();

        if (ctx.expr() != null) {
            // System.out.println(this.visit(ctx.expr()).isVoid());
            args.add(this.visit(ctx.expr()));
        }

        if (ctx.args() != null) {
            args.addAll(this.visit(ctx.args()).asValueArrayList());
        }

        // System.out.println(args);
        return new Value(args);
    }

    @Override
    public Value visitWriteln(PascalParser.WritelnContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitWritelnFunc(PascalParser.WritelnFuncContext ctx) {
        {
            BufferedWriter foutput = new BufferedWriter(new OutputStreamWriter(System.out));

            Value args = this.visit(ctx.args());

            for (Value arg : args.asValueArrayList()) {

                boolean isPrintableType = arg.isInteger() || arg.isDouble() || arg.isBoolean() || arg.isCharacter() || arg.isString();

                if (isPrintableType) {
                    try {
                        foutput.write(arg.asObject().toString());
                    } catch (IOException e) {
                        System.out.println(e + "Could not write String to buffer!");
                    }
                } else {
                    Util.throwE("Illegal Operation: arg is not a compatible value!");
                }
            }
            try {
                foutput.write("\n");
                foutput.flush();
            } catch (IOException e) {
                System.out.println(e + "Could not flush write buffer!");
            }
            ;
        }
        return Value.VOID;
    }

    @Override
    public Value visitReadln(PascalParser.ReadlnContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitReadlnFunc(PascalParser.ReadlnFuncContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    // MATH START

    @Override
    public Value visitSqrt(PascalParser.SqrtContext ctx) {
        Value expr = this.visit(ctx.expr());
        return new Value(Math.sqrt(expr.asDouble()));
    }

    @Override
    public Value visitLn(PascalParser.LnContext ctx) {
        Value expr = this.visit(ctx.expr());
        return new Value(Math.log(expr.asDouble()));
    }

    @Override
    public Value visitExp(PascalParser.ExpContext ctx) {
        Value expr = this.visit(ctx.expr());
        return new Value(Math.exp(expr.asDouble()));
    }

    @Override
    public Value visitSine(PascalParser.SineContext ctx) {
        Value expr = this.visit(ctx.expr());
        return new Value(Math.sin(expr.asDouble()));
    }

    @Override
    public Value visitCosine(PascalParser.CosineContext ctx) {
        Value expr = this.visit(ctx.expr());
        return new Value(Math.cos(expr.asDouble()));
    }

    // MATH END

    // EXPR START

    @Override
    public Value visitParenExpr(PascalParser.ParenExprContext ctx) {
        return this.visit(ctx.expr());
    }

    @Override
    public Value visitBitwiseNotExpr(PascalParser.BitwiseNotExprContext ctx) {
        Value expr = this.visit(ctx.expr());

        if (expr.isInteger()) {
            return new Value(~expr.asInteger());
        } else if (expr.isCharacter()) {
            return new Value(~expr.asCharacter());
        }

        throwE("Illegal Operation: Incompatible Type!");
        return Value.VOID;
    }

    @Override
    public Value visitNotExpr(PascalParser.NotExprContext ctx) {
        Value expr = this.visit(ctx.expr());

        if (expr.isBoolean()) {
            return new Value(!expr.asBoolean());
        }

        throwE("Illegal Operation: Incompatible Type!");
        return Value.VOID;
    }

    @Override
    public Value visitMulExpr(PascalParser.MulExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isCharacter() && er.isCharacter()) {
            return new Value((char) (el.asCharacter() * er.asCharacter()));
        } else if (el.isNonFloatNumber() && er.isNonFloatNumber()) {
            return new Value(el.asInteger() * er.asInteger());
        } else if (el.isNonFloatNumber() && er.isDouble()) {
            return new Value(el.asInteger() * er.asDouble());
        } else if (el.isDouble() && er.isNonFloatNumber()) {
            return new Value(el.asDouble() * er.asInteger());
        } else if (el.isDouble() && er.isDouble()) {
            return new Value(el.asDouble() * er.asDouble());
        }

        throwE("Illegal Operation: Incompatible Type!");
        return Value.VOID;
    }

    @Override
    public Value visitDivExpr(PascalParser.DivExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isCharacter() && er.isCharacter()) {
            return new Value((char) (el.asCharacter() / er.asCharacter()));
        } else if (el.isNonFloatNumber() && er.isNonFloatNumber()) {
            return new Value(el.asInteger() / er.asInteger());
        } else if (el.isNonFloatNumber() && er.isDouble()) {
            return new Value(el.asInteger() / er.asDouble());
        } else if (el.isDouble() && er.isNonFloatNumber()) {
            return new Value(el.asDouble() / er.asInteger());
        } else if (el.isDouble() && er.isDouble()) {
            return new Value(el.asDouble() / er.asDouble());
        }

        throwE("Illegal Operation: Incompatible Type!");
        return Value.VOID;
    }

    @Override
    public Value visitModExpr(PascalParser.ModExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isCharacter() && er.isCharacter()) {
            return new Value((char) (el.asCharacter() % er.asCharacter()));
        } else if (el.isNonFloatNumber() && er.isNonFloatNumber()) {
            return new Value(el.asInteger() % er.asInteger());
        } else if (el.isNonFloatNumber() && er.isDouble()) {
            return new Value(el.asInteger() % er.asDouble());
        } else if (el.isDouble() && er.isNonFloatNumber()) {
            return new Value(el.asDouble() % er.asInteger());
        } else if (el.isDouble() && er.isDouble()) {
            return new Value(el.asDouble() % er.asDouble());
        }

        throwE("Illegal Operation: Incompatible Type!");
        return Value.VOID;
    }

    @Override
    public Value visitAndExpr(PascalParser.AndExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isBoolean() && er.isBoolean()) {
            return new Value(el.asBoolean() && er.asBoolean());
        } else if (el.isCharacter() && er.isCharacter()) {
            return new Value((char) (el.asCharacter() & er.asCharacter()));
        } else if (el.isInteger() && el.isInteger()) {
            return new Value(el.asInteger() & er.asInteger());
        }

        throwE("Illegal Operation: Incompatible Type!");
        return Value.VOID;
    }

    @Override
    public Value visitBitwiseShiftLeftExpr(PascalParser.BitwiseShiftLeftExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isCharacter() && er.isCharacter()) {
            return new Value((char) (el.asCharacter() << er.asCharacter()));
        } else if (el.isInteger() && el.isInteger()) {
            return new Value(el.asInteger() << er.asInteger());
        }

        throwE("Illegal Operation: Incompatible Type!");
        return Value.VOID;
    }

    @Override
    public Value visitBitwiseShiftRightExpr(PascalParser.BitwiseShiftRightExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isCharacter() && er.isCharacter()) {
            return new Value((char) (el.asCharacter() >> er.asCharacter()));
        } else if (el.isInteger() && el.isInteger()) {
            return new Value(el.asInteger() >> er.asInteger());
        }

        throwE("Illegal Operation: Incompatible Type!");
        return Value.VOID;
    }

    @Override
    public Value visitOrExpr(PascalParser.OrExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isBoolean() && er.isBoolean()) {
            return new Value(el.asBoolean() || er.asBoolean());
        } else if (el.isCharacter() && er.isCharacter()) {
            return new Value((char) (el.asCharacter() | er.asCharacter()));
        } else if (el.isInteger() && el.isInteger()) {
            return new Value(el.asInteger() | er.asInteger());
        }

        throwE("Illegal Operation: Incompatible Type!");
        return Value.VOID;
    }

    @Override
    public Value visitBitwiseXorExpr(PascalParser.BitwiseXorExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isCharacter() && er.isCharacter()) {
            return new Value((char) (el.asCharacter() ^ er.asCharacter()));
        } else if (el.isInteger() && el.isInteger()) {
            return new Value(el.asInteger() ^ er.asInteger());
        }

        throwE("Illegal Operation: Incompatible Type!");
        return Value.VOID;
    }

    @Override
    public Value visitAddExpr(PascalParser.AddExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isCharacter() && er.isCharacter()) {
            return new Value((char) (el.asCharacter() + er.asCharacter()));
        } else if (el.isNonFloatNumber() && er.isNonFloatNumber()) {
            return new Value(el.asInteger() + er.asInteger());
        } else if (el.isNonFloatNumber() && er.isDouble()) {
            return new Value(el.asInteger() + er.asDouble());
        } else if (el.isDouble() && er.isNonFloatNumber()) {
            return new Value(el.asDouble() + er.asInteger());
        } else if (el.isDouble() && er.isDouble()) {
            return new Value(el.asDouble() + er.asDouble());
        }

        throwE("Illegal Operation: Incompatible Type!");
        return Value.VOID;
    }

    @Override
    public Value visitSubExpr(PascalParser.SubExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isCharacter() && er.isCharacter()) {
            return new Value((char) (el.asCharacter() - er.asCharacter()));
        } else if (el.isNonFloatNumber() && er.isNonFloatNumber()) {
            return new Value(el.asInteger() - er.asInteger());
        } else if (el.isNonFloatNumber() && er.isDouble()) {
            return new Value(el.asInteger() - er.asDouble());
        } else if (el.isDouble() && er.isNonFloatNumber()) {
            return new Value(el.asDouble() - er.asInteger());
        } else if (el.isDouble() && er.isDouble()) {
            return new Value(el.asDouble() - er.asDouble());
        }

        throwE("Illegal Operation: Incompatible Type!");
        return Value.VOID;
    }

    @Override
    public Value visitEquExpr(PascalParser.EquExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        return new Value(el.equal(er));
    }

    @Override
    public Value visitNotEquExpr(PascalParser.NotEquExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        return new Value(!el.equal(er));
    }

    @Override
    public Value visitLesExpr(PascalParser.LesExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isNumber() && er.isNumber()) {
            return new Value(el.asDouble() < er.asDouble());
        }

        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitLeqExpr(PascalParser.LeqExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isNumber() && er.isNumber()) {
            return new Value(el.asDouble() <= er.asDouble());
        }

        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitGrtExpr(PascalParser.GrtExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isNumber() && er.isNumber()) {
            return new Value(el.asDouble() > er.asDouble());
        }

        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitGeqExpr(PascalParser.GeqExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isNumber() && er.isNumber()) {
            return new Value(el.asDouble() >= er.asDouble());
        }

        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitOrElseExpr(PascalParser.OrElseExprContext ctx) {
        Value el = this.visit(ctx.el);

        if (el.isBoolean()) {
            if (!el.asBoolean()) {
                Value er = this.visit(ctx.er);
                if (er.isBoolean()) {
                    return new Value(er.asBoolean());
                }
            } else
                return new Value(true);
        }

        throwE("Illegal Operation: Incompatible Type!");
        return Value.VOID;
    }

    @Override
    public Value visitAndThenExpr(PascalParser.AndThenExprContext ctx) {
        Value el = this.visit(ctx.el);

        if (el.isBoolean()) {
            if (el.asBoolean()) {
                Value er = this.visit(ctx.er);
                if (er.isBoolean()) {
                    return new Value(er.asBoolean());
                }
            } else
                return new Value(false);
        }

        throwE("Illegal Operation: Incompatible Type!");
        return Value.VOID;
    }

    @Override
    public Value visitIdentifierExpr(PascalParser.IdentifierExprContext ctx) {
        Value indent = this.visit(ctx.identifier());
        return getVariable(indent.asString());
    }

    @Override
    public Value visitPiLiteralExpr(PascalParser.PiLiteralExprContext ctx) {
        return new Value(Math.PI);
    }

    @Override
    public Value visitTrueLiteralExpr(PascalParser.TrueLiteralExprContext ctx) {
        return new Value(true);
    }

    @Override
    public Value visitFalseLiteralExpr(PascalParser.FalseLiteralExprContext ctx) {
        return new Value(false);
    }

    @Override
    public Value visitIntegerLiteralExpr(PascalParser.IntegerLiteralExprContext ctx) {
        return new Value(Integer.parseInt(ctx.getText()));
    }

    @Override
    public Value visitDoubleLiteralExpr(PascalParser.DoubleLiteralExprContext ctx) {
        return new Value(Double.parseDouble(ctx.getText()));
    }

    @Override
    public Value visitStringExpr(PascalParser.StringExprContext ctx) {
        Value string = this.visit(ctx.string());
        return string;
    }


    @Override
    public Value visitSqrtExpr(PascalParser.SqrtExprContext ctx) {
        Value sqrtRet = this.visit(ctx.sqrt());
        return sqrtRet;
    }

    @Override
    public Value visitSineExpr(PascalParser.SineExprContext ctx) {
        Value sineRet = this.visit(ctx.sine());
        return sineRet;
    }

    @Override
    public Value visitCosineExpr(PascalParser.CosineExprContext ctx) {
        Value cosineRet = this.visit(ctx.cosine());
        return cosineRet;
    }

    @Override
    public Value visitLnExpr(PascalParser.LnExprContext ctx) {
        Value lnRet = this.visit(ctx.ln());
        return lnRet;
    }

    @Override
    public Value visitExpExpr(PascalParser.ExpExprContext ctx) {
        Value expRet = this.visit(ctx.exp());
        return expRet;
    }

    // EXPR END

    @Override
    public Value visitString(PascalParser.StringContext ctx) {
        //drop the quotes surrounding the string
        String ret = ctx.getText().substring(1, ctx.getText().length() - 1);
        visitChildren(ctx);
        return new Value(ret);
    }

}