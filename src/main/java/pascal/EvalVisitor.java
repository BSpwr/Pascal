package pascal;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.Pair;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class EvalVisitor extends PascalBaseVisitor<Value> {

    String filePath = "";

    // if-else and case statements, DO NOT TOUCH unless ready to refactor whole
    // system
    Boolean debug = false;

    Stack<Boolean> branchHistory = new Stack<Boolean>();

    Boolean toggle = false;
    Boolean breakCase = false;
    Value caseSel = Value.VOID;

    // Create the ContextManager singleton
    ContextManager ctxManager = ContextManager.getInstance(debug);

    public EvalVisitor(String path) {
        this.filePath = path;
    };

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
    public Value visitProgramInternal(PascalParser.ProgramInternalContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitUnitInternal(PascalParser.UnitInternalContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitDefs(PascalParser.DefsContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitProgramHeading(PascalParser.ProgramHeadingContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitUnitHeading(PascalParser.UnitHeadingContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitProgramImports(PascalParser.ProgramImportsContext ctx) {
        Value ident = this.visit(ctx.identifier());

        File currentFile = new File(filePath);
        String parentPath = currentFile.getParent();

       String workDir = System.getProperty("user.dir");

       String relativeImportFilePath = parentPath + "/" + ident.asString() + ".pas";
       String absoluteImportFilePath = workDir + "/" + relativeImportFilePath;

        File importFile = new File(absoluteImportFilePath);
        if (!importFile.exists()) Util.throwE("File -> "+ absoluteImportFilePath + " <- does not exist.");

        CharStream charStream = null;
        try {
            charStream = CharStreams.fromFileName(relativeImportFilePath);
        } catch (IOException e) {
            System.out.println("File -> "+ absoluteImportFilePath + " <- does not exist.");
            e.printStackTrace();
        }

        PascalLexer lexer = new PascalLexer(charStream);
        PascalParser parser = new PascalParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.start();
        EvalVisitor visitor = new EvalVisitor(relativeImportFilePath);
        visitor.visit(tree);

//        ---- The below code is not needed, because ctxManager is a singleton! ----
//        HashMap<String, Function> importFuncMap = visitor.ctxManager.getVarContainer().peek().functionMap;
//
//        Iterator<Map.Entry<String, Function>> funcMapIterator = importFuncMap.entrySet().iterator();
//
//        while (funcMapIterator.hasNext()) {
//            Map.Entry<String, Function> funcElem = funcMapIterator.next();
//            this.ctxManager.createFunction(funcElem.getKey(), funcElem.getValue());
//        }
//
//        if (ctx.programImports() != null)
//            this.visit(ctx.programImports());

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
    public Value visitDecBlocks(PascalParser.DecBlocksContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitDecBlock(PascalParser.DecBlockContext ctx) {
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
    public Value visitProgBlock(PascalParser.ProgBlockContext ctx) {
        Value statements = this.visit(ctx.statements());
        if (statements.isBreak() || statements.isContinue())
            return statements;

        return Value.VOID;
    }

    @Override
    public Value visitTypeDef(PascalParser.TypeDefContext ctx) {
        Value ident = this.visit(ctx.identifier());
        Value typeType = this.visit(ctx.typeType());

        ArrayList<String> enumTypes = typeType.asStringArrayList();

        this.ctxManager.createEnum(ident, enumTypes);

        // print out the variable map
        if (debug) {
            for (HashMap.Entry<String, ArrayList<String>> a : this.ctxManager.exposeEnums().entrySet()) {
                System.out.println("\tType:" + a.getKey());
                for (String s : a.getValue()) {
                    System.out.println("\tValue:" + s);
                }
            }
        }

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

        Value varList = this.visit(ctx.varList());
        Value varType = this.visit(ctx.varType());

        ArrayList<String> varNames = varList.asStringArrayList();

        Value expr = Value.VOID;

        if (ctx.expr() != null) {
            expr = this.visit(ctx.expr());
        }

        if (varType.equalType(expr))
            this.ctxManager.createVariable(varNames, expr);
        else
            this.ctxManager.createVariable(varNames, varType);

        // print out the variable map
        if (debug) {
            System.out.println("VARs defined:");

            for (int i = 0; i < varNames.size(); i++) {
                System.out.println("\tIdentifier:" + varNames.get(i));
                System.out.println("\tValue:" + this.ctxManager.getVariable(varNames.get(i)));
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

        // It's an array type
    //    if (ctx.varType() != null)

        if (ctx.arrayAlloc() != null) {
            Value arrayAlloc = this.visit(ctx.arrayAlloc());
            return arrayAlloc;

        } else if (ctx.identifier() != null) {
            Value ident = this.visit(ctx.identifier());
            return ident;
        }

        return Value.VOID;
    }

    @Override
    public Value visitArrayAlloc(PascalParser.ArrayAllocContext ctx) {
        Value range = this.visit(ctx.range());
        Value varType = this.visit(ctx.varType());

        Integer length = range.asIntegerArrayList().get(1) - range.asIntegerArrayList().get(0);
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
        ArrayList<Integer> ret = new ArrayList<Integer>() {
            {
                add(low);
                add(high);
            }
        };
        return new Value(ret);
    }

    @Override
    public Value visitConstDef(PascalParser.ConstDefContext ctx) {

        Value varList = this.visit(ctx.varList());
        ArrayList<String> varNames = varList.asStringArrayList();

        Value expr = this.visit(ctx.expr());

        this.ctxManager.createConst(varNames, expr);

        if (debug) {
            System.out.println("CONSTs defined:");
            for (int i = 0; i < varNames.size(); i++) {
                System.out.println("\tIdentifier:" + varNames.get(i));
                System.out.println("\tValue:" + this.ctxManager.getVariable(varNames.get(i)));
            }
        }

        if (ctx.constDef() != null)
            this.visit(ctx.constDef());

        return Value.VOID;
    }

    @Override
    public Value visitStatements(PascalParser.StatementsContext ctx) {

        Value impl = this.visit(ctx.implMaybe());
        if (impl.isBreak() || impl.isContinue())
            return impl;

        Value statements = Value.VOID;

        if (ctx.statements() != null)
            statements = this.visit(ctx.statements());
        if (statements.isBreak() || statements.isContinue())
            return statements;

        return Value.VOID;
    }

    @Override
    public Value visitImplMaybe(PascalParser.ImplMaybeContext ctx) {

        if (ctx.implementation() != null)
            return this.visit(ctx.implementation());

        return Value.VOID;
    }

    @Override
    public Value visitImplementation(PascalParser.ImplementationContext ctx) {
        Value impl;

        if (ctx.assignment() != null) {
            this.visit(ctx.assignment());
        }
        if (ctx.expr() != null) {
            this.visit(ctx.expr());
        }
        if (ctx.writeln() != null) {
            this.visit(ctx.writeln());
        }
        if (ctx.readln() != null) {
            this.visit(ctx.readln());
        }
        if (ctx.branch() != null) {
            impl = this.visit(ctx.branch());
            if (impl.isBreak() || impl.isContinue())
                return impl;
        }
        if (ctx.cases() != null) {
            impl = this.visit(ctx.cases());
            if (impl.isBreak() || impl.isContinue())
                return impl;
        }
        if (ctx.progBlock() != null) {
            impl = this.visit(ctx.progBlock());
            if (impl.isBreak() || impl.isContinue())
                return impl;
        }
        if (ctx.whileLoop() != null) {
            impl = this.visit(ctx.whileLoop());
            if (impl.isBreak() || impl.isContinue())
                return impl;
        }
        if (ctx.forLoop() != null) {
            impl = this.visit(ctx.forLoop());
            if (impl.isBreak() || impl.isContinue())
                return impl;
        }
        if (ctx.repeatUntilLoop() != null) {
            impl = this.visit(ctx.repeatUntilLoop());
            if (impl.isBreak() || impl.isContinue())
                return impl;
        }
        if (ctx.codeExec() != null) {
            impl = this.visit(ctx.codeExec());
            if (impl.isBreak() || impl.isContinue())
                return impl;
        }

        if (ctx.getText().toLowerCase().equals("break"))
            return Value.BREAK;

        if (ctx.getText().toLowerCase().equals("continue"))
            return Value.CONTINUE;

        return Value.VOID;
    }

    @Override
    public Value visitBranch(PascalParser.BranchContext ctx) {
        Value expr = this.visit(ctx.expr());
        Value impl;

        if (expr.isBoolean()) {
            if (expr.asBoolean()) {
                impl = this.visit(ctx.implMaybe());
                if (impl.isBreak() || impl.isContinue())
                    return impl;
            } else {
                if (ctx.elseBranch() != null) {
                    impl = this.visit(ctx.elseBranch());
                    if (impl.isBreak() || impl.isContinue())
                        return impl;
                }
            }
        }

        return Value.VOID;
    }

    @Override
    public Value visitElseBranch(PascalParser.ElseBranchContext ctx) {
        Value impl = this.visit(ctx.implMaybe());
        if (impl.isBreak() || impl.isContinue())
            return impl;

        return Value.VOID;
    }

    @Override
    public Value visitCases(PascalParser.CasesContext ctx) {
        Value expr = this.visit(ctx.expr());

        List<PascalParser.CaseStatementContext> statements = ctx.caseStatement();

        boolean executed = false;
        for (PascalParser.CaseStatementContext statement : statements) {
            if (executed)
                break;
            Value control = execCase(statement, expr);
            if (control.isBreak() || control.isContinue())
                return control;
            executed = control.asBoolean();
        }

        if (!executed && ctx.elseCase() != null)
            this.visit(ctx.elseCase());

        return Value.VOID;
    }

    // return true if statement matched expr and executed, false otherwise
    public Value execCase(PascalParser.CaseStatementContext ctx, Value expr) {

        Value impl = Value.FALSE;

        if (ctx.expr() != null) {
            Value statementExpr = this.visit(ctx.expr());
            if (expr.equals(statementExpr)) {
                if (ctx.implementation() != null)
                    impl = this.visit(ctx.implementation());
                if (impl.isBreak() || impl.isContinue())
                    return impl;
                else {
                    return Value.TRUE;
                }
            } else
                return Value.FALSE;
        }

        if (ctx.range() != null) {
            Value range = this.visit(ctx.expr());
            // assuming only integer ranges
            int lo = range.asIntegerArrayList().get(0);
            int high = range.asIntegerArrayList().get(1);
            if (expr.asInteger() <= high && expr.asInteger() >= lo) {
                if (ctx.implementation() != null)
                    impl = this.visit(ctx.implementation());
                if (impl.isBreak() || impl.isContinue())
                    return impl;
                return Value.TRUE;
            } else
                return Value.FALSE;
        }

        return Value.FALSE;
    }

    @Override
    public Value visitCaseStatement(PascalParser.CaseStatementContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitElseCase(PascalParser.ElseCaseContext ctx) {
        Value impl = Value.VOID;

        if (ctx.implementation() != null)
            impl = this.visit(ctx.implementation());

        if (impl.isBreak() || impl.isContinue())
            return impl;
        else
            return Value.VOID;
    }

    @Override
    public Value visitAssignment(PascalParser.AssignmentContext ctx) {
        Value ident = this.visit(ctx.identifier());
        Value expr = this.visit(ctx.expr());

        this.ctxManager.setVariable(ident.asString(), expr);

        return Value.VOID;
    }

    @Override
    public Value visitWhileLoop(PascalParser.WhileLoopContext ctx) {
        this.ctxManager.enterScope();
        Value expr = this.visit(ctx.expr());
        Value impl = Value.VOID;

        while (expr.asBoolean()) {
            impl = this.visit(ctx.implMaybe());
            if (impl.isBreak())
                break;
            expr = this.visit(ctx.expr());
        }

        this.ctxManager.exitScope();
        return Value.VOID;
    }

    @Override
    public Value visitForLoop(PascalParser.ForLoopContext ctx) {
        this.ctxManager.enterScope();
        Value ident = this.visit(ctx.identifier());
        Value initial = this.visit(ctx.initial);
        Value target = this.visit(ctx.target);

        String loopVar = ident.asString();

        Value impl;

        if (ctx.TO() != null) {
            for (int i = initial.asInteger(); i <= target.asInteger(); i++) {
                this.ctxManager.setVariable(loopVar, new Value(i));
                impl = this.visit(ctx.implMaybe());
                if (impl.isBreak())
                    break;
            }
        } else {
            for (int i = initial.asInteger(); i < target.asInteger(); i--) {
                this.ctxManager.setVariable(loopVar, new Value(i));
                impl = this.visit(ctx.implMaybe());
                if (impl.isBreak())
                    break;
            }
        }

        this.ctxManager.exitScope();
        return Value.VOID;
    }

    @Override
    public Value visitRepeatUntilLoop(PascalParser.RepeatUntilLoopContext ctx) {
        this.ctxManager.enterScope();
        Value expr = this.visit(ctx.expr());

        Value impl;

        while (!expr.asBoolean()) {
            impl = this.visit(ctx.statements());
            if (impl.isBreak())
                break;
            expr = this.visit(ctx.expr());
        }

        this.ctxManager.exitScope();
        return Value.VOID;
    }

    @Override
    public Value visitCodeExec(PascalParser.CodeExecContext ctx) {
        Value ident = this.visit(ctx.identifier());

        String name = ident.asString();

        ArrayList<Value> argsList = new ArrayList<>();
        if (ctx.args() != null)
            argsList = this.visit(ctx.args()).asValueArrayList();

        return this.ctxManager.doFunction(this, name, argsList);
    }

    @Override
    public Value visitCodeDefs(PascalParser.CodeDefsContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    // Brainstorming what a function needs
    // need to save a ArrayList<Pair<String,Value>> for argslist
    // ArrayList<ParserRuleContext> for the decBlock and progBlock saving
    // Need to know what to return
    // can either return if value in val decBlock is called return
    // or if variable with same name as function is assigned to
    // Note: functions always run until the end
    public Value visitFunctionDef(PascalParser.FunctionDefContext ctx) {
        Value ident = this.visit(ctx.identifier());
        Value varType = this.visit(ctx.varType());
        // save the code inside the function into a function table to be used later

        String funcName = ident.asString();

        ArrayList<Pair<String, Value>> argsList = new ArrayList<>();
        if (ctx.argsTypeList() != null)
            argsList = this.visit(ctx.argsTypeList()).asArgsTypeList();

        ArrayList<ParserRuleContext> functionContent = new ArrayList<>();

        if (ctx.decBlocks() != null)
            functionContent.add(ctx.decBlocks());
        if (ctx.progBlock() != null)
            functionContent.add(ctx.progBlock());

        return this.ctxManager.createFunction(funcName, argsList, functionContent, varType);
    }

    @Override
    public Value visitProcedureDef(PascalParser.ProcedureDefContext ctx) {
        Value ident = this.visit(ctx.identifier());
        // save the code inside the procedure into a function table to be used later

        String procName = ident.asString();

        ArrayList<Pair<String, Value>> argsList = new ArrayList<>();
        if (ctx.argsTypeList() != null)
            argsList = this.visit(ctx.argsTypeList()).asArgsTypeList();

        ArrayList<ParserRuleContext> procContent = new ArrayList<>();

        if (ctx.decBlocks() != null)
            procContent.add(ctx.decBlocks());

        procContent.add(ctx.progBlock());

        return this.ctxManager.createFunction(procName, argsList, procContent, Value.VOID);
    }

    @Override
    // returns an ArrayList of pairs of arg names to value types
    public Value visitArgsTypeList(PascalParser.ArgsTypeListContext ctx) {
        // TODO : This function doesn't check if varType is a valid enum

        Value varList = this.visit(ctx.varList());
        Value varType = this.visit(ctx.varType());

        ArrayList<String> varNames = varList.asStringArrayList();

        ArrayList<Pair<String, Value>> ret = new ArrayList<>();

        for (String name : varNames) {
            ret.add(new Pair<>(name, varType));
        }

        if (ctx.argsTypeList() != null)
            ret.addAll(this.visit(ctx.argsTypeList()).asArgsTypeList());

        // print out the (name, type) pairs
        if (debug) {
            System.out.println("Args,type list content:");
            for (Pair<String, Value> a : ret) {
                System.out.print(a.toString() + " ");
            }
            System.out.println();
        }

        return new Value(ret);
    }

    @Override
    public Value visitArgs(PascalParser.ArgsContext ctx) {

        ArrayList<Value> args = new ArrayList<Value>();

        if (ctx.expr() != null) {
            args.add(this.visit(ctx.expr()));
        }

        if (ctx.args() != null) {
            args.addAll(this.visit(ctx.args()).asValueArrayList());
        }

        return new Value(args);
    }

    @Override
    public Value visitWriteln(PascalParser.WritelnContext ctx) {

        BufferedWriter foutput = new BufferedWriter(new OutputStreamWriter(System.out));

        Value args = this.visit(ctx.args());

        for (Value arg : args.asValueArrayList()) {

            boolean isPrintableType = arg.isInteger() || arg.isDouble() || arg.isBoolean() || arg.isCharacter()
                    || arg.isString();

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

        return Value.VOID;
    }

    @Override
    public Value visitReadln(PascalParser.ReadlnContext ctx) {

        Scanner uInput = new Scanner(System.in);

        Value args = this.visit(ctx.typeType());

        if (args.asStringArrayList().size() == 0)
            uInput.nextLine();

        Value v = Value.VOID;

        for (String arg : args.asStringArrayList()) {
            if (this.ctxManager.getVariable(arg).isInteger()) {
                v = new Value(uInput.nextInt());
            } else if (this.ctxManager.getVariable(arg).isBoolean()) {
                v = new Value(uInput.nextLine());
                if (v.isString()
                        && (v.asString().toLowerCase().equals("true") || v.asString().toLowerCase().equals("false"))) {
                    v = new Value(Boolean.parseBoolean(v.asString()));
                } else {
                    try {
                        v = new Value(Integer.parseInt(v.asString()));
                    } catch (NumberFormatException e) {
                        v = new Value(0);
                    }
                    v = new Value(v.asInteger() >= 1);
                }
            } else if (this.ctxManager.getVariable(arg).isDouble()) {
                v = new Value(uInput.nextDouble());
            } else if (this.ctxManager.getVariable(arg).isCharacter()) {
                v = new Value(uInput.next().charAt(0));
            } else if (this.ctxManager.getVariable(arg).isString()) {
                v = new Value(uInput.nextLine());
            } else {
                Util.throwE("Illegal Operation: Variable cannot be set from stdin!");
            }

            this.ctxManager.setVariable(arg, v);
        }

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

        Util.throwE("Illegal Operation: Incompatible Type! bitWiseNotExpr");
        return Value.VOID;
    }

    @Override
    public Value visitNotExpr(PascalParser.NotExprContext ctx) {
        Value expr = this.visit(ctx.expr());

        if (expr.isBoolean()) {
            return new Value(!expr.asBoolean());
        }

        Util.throwE("Illegal Operation: Incompatible Type! notExpr");
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

        Util.throwE("Illegal Operation: Incompatible Type! mulExpr");
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

        Util.throwE("Illegal Operation: Incompatible Type! divExpr");
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

        Util.throwE("Illegal Operation: Incompatible Type! modExpr");
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

        Util.throwE("Illegal Operation: Incompatible Type! andExpr");
        return Value.VOID;
    }

    @Override
    public Value visitBitwiseShiftLeftExpr(PascalParser.BitwiseShiftLeftExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isCharacter() && er.isCharacter()) {
            return new Value(el.asCharacter() << er.asCharacter());
        } else if (el.isInteger() && el.isInteger()) {
            return new Value(el.asInteger() << er.asInteger());
        }

        Util.throwE("Illegal Operation: Incompatible Type! bitwiseShiftLeftExpr");
        return Value.VOID;
    }

    @Override
    public Value visitBitwiseShiftRightExpr(PascalParser.BitwiseShiftRightExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isCharacter() && er.isCharacter()) {
            return new Value(el.asCharacter() >> er.asCharacter());
        } else if (el.isInteger() && el.isInteger()) {
            return new Value(el.asInteger() >> er.asInteger());
        }

        Util.throwE("Illegal Operation: Incompatible Type! bitwiseShiftRightExpr");
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

        Util.throwE("Illegal Operation: Incompatible Type! orExpr");
        return Value.VOID;
    }

    @Override
    public Value visitXorExpr(PascalParser.XorExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isCharacter() && er.isCharacter()) {
            return new Value((char) (el.asCharacter() ^ er.asCharacter()));
        } else if (el.isInteger() && el.isInteger()) {
            return new Value(el.asInteger() ^ er.asInteger());
        }

        Util.throwE("Illegal Operation: Incompatible Type! xorExpr");
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

        Util.throwE("Illegal Operation: Incompatible Type! addExpr");
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

        Util.throwE("Illegal Operation: Incompatible Type! subExpr");
        return Value.VOID;
    }

    @Override
    public Value visitEquExpr(PascalParser.EquExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        return new Value(el.equals(er));
    }

    @Override
    public Value visitNotEquExpr(PascalParser.NotEquExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        return new Value(!el.equals(er));
    }

    @Override
    public Value visitLesExpr(PascalParser.LesExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isNumber() && er.isNumber()) {
            return new Value(el.asDouble() < er.asDouble());
        }

        return Value.VOID;
    }

    @Override
    public Value visitLeqExpr(PascalParser.LeqExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isNumber() && er.isNumber()) {
            return new Value(el.asDouble() <= er.asDouble());
        }

        return Value.VOID;
    }

    @Override
    public Value visitGrtExpr(PascalParser.GrtExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isNumber() && er.isNumber()) {
            return new Value(el.asDouble() > er.asDouble());
        }

        return Value.VOID;
    }

    @Override
    public Value visitGeqExpr(PascalParser.GeqExprContext ctx) {
        Value el = this.visit(ctx.el);
        Value er = this.visit(ctx.er);

        if (el.isNumber() && er.isNumber()) {
            return new Value(el.asDouble() >= er.asDouble());
        }

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

        Util.throwE("Illegal Operation: Incompatible Type!");
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

        Util.throwE("Illegal Operation: Incompatible Type!");
        return Value.VOID;
    }

    @Override
    public Value visitIdentifierExpr(PascalParser.IdentifierExprContext ctx) {
        Value indent = this.visit(ctx.identifier());
        return this.ctxManager.getVariable(indent.asString());
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

    @Override
    public Value visitCodeExpr(PascalParser.CodeExprContext ctx) {
        Value codeRet = this.visit(ctx.codeExec());
        return codeRet;
    }

    // EXPR END

    @Override
    public Value visitString(PascalParser.StringContext ctx) {
        // drop the quotes surrounding the string
        String ret = ctx.getText().substring(1, ctx.getText().length() - 1);
        return new Value(ret);
    }

}