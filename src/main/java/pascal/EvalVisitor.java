package pascal;

import java.util.*;
import java.util.stream.IntStream;

public class EvalVisitor extends PascalBaseVisitor<Value> {

    Boolean debug = false;

    Stack<Boolean> branchHistory = new Stack<Boolean>();

    Boolean breakCase = false;
    Object caseSel = Value.VOID;

    HashMap<String,Object> variables = new HashMap<String,Object>();
    HashMap<String,Object> constants = new HashMap<String,Object>();
    HashMap<String,ArrayList<String>> enums = new HashMap<String,ArrayList<String>>();

    HashMap<String,String> enumVariableType = new HashMap<String,String>();
    HashMap<String,String> reserved = new HashMap<String,String>();

    @Override
    public Value visitStart(PascalParser.StartContext ctx) {
        System.out.println("Hello pancake!");
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
        if(debug) {
            for(HashMap.Entry<String, ArrayList<String>> a : enums.entrySet()) {
                System.out.println("\tType:" + a.getKey());
                for(String s : a.getValue()) {
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

        if(varType.isString() && !varType.toString().isEmpty()) {
            enumVariableType.putAll(IntStream.range(0, varList.asStringArrayList().size())
                    .collect(HashMap::new,
                            (map, i) -> map.put(varList.asStringArrayList().get(i), varType.asString()),
                            Map::putAll));
            reserved.putAll(IntStream.range(0, varList.asStringArrayList().size())
                    .collect(HashMap::new,
                            (map, i) -> map.put(varList.asStringArrayList().get(i), varType.asString()),
                            Map::putAll));
        }
        else{
            variables.putAll(IntStream.range(0, varList.asStringArrayList().size())
                    .collect(HashMap::new,
                            (map, i) -> map.put(varList.asStringArrayList().get(i), varList.asStringArrayList()),
                            Map::putAll));
        }
        // print out the variable map
        if(debug) {
            System.out.println("VARs defined:");
            ArrayList<String> varNames = varList.asStringArrayList();
            for (int i = 0; i < varNames.size(); i++) {
                System.out.println("\tIdentifier:" + varNames.get(i));
                System.out.println("\tValue:" + this.variables.get(varNames.get(i)));
            }
        }
        visitChildren(ctx);
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
        // TODO: Deal with arrayAlloc and identifier
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitArrayAlloc(PascalParser.ArrayAllocContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitRange(PascalParser.RangeContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitConstDef(PascalParser.ConstDefContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitImplementation(PascalParser.ImplementationContext ctx) {
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
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitArgs(PascalParser.ArgsContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitWriteln(PascalParser.WritelnContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitWritelnFunc(PascalParser.WritelnFuncContext ctx) {
        visitChildren(ctx);
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

    @Override
    public Value visitSqrt(PascalParser.SqrtContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitLn(PascalParser.LnContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitExp(PascalParser.ExpContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitSine(PascalParser.SineContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitCosine(PascalParser.CosineContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitExpr(PascalParser.ExprContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

    @Override
    public Value visitString(PascalParser.StringContext ctx) {
        visitChildren(ctx);
        return Value.VOID;
    }

}