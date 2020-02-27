package pascal;

import java.util.ArrayList;

public class EvalVisitor extends PascalBaseVisitor<Value> {

    @Override public Value visitStart(PascalParser.StartContext ctx) {
        System.out.println("Hello pancake!");
        return visitChildren(ctx);
    }

    @Override public Value visitProgramHeading(PascalParser.ProgramHeadingContext ctx) {
        return Value.VOID;
    }

    @Override public Value visitIdentifier(PascalParser.IdentifierContext ctx) {
        return new Value(ctx.getText());
    }

    @Override public Value visitTypeType(PascalParser.TypeTypeContext ctx) {
        ArrayList<String> ret = new ArrayList<String>();
        Value ident = this.visit(ctx.identifier());
        ret.add(ident.asString());
        if (ctx.typeType() != null) {
            Value listToAppendTo = this.visit(ctx.typeType());
            ret.addAll(listToAppendTo.asStringArrayList());
        }
        return new Value(ret);
    }

    @Override public Value visitVarList(PascalParser.VarListContext ctx) {
        ArrayList<String> ret = new ArrayList<String>();
        Value ident = this.visit(ctx.identifier());
        ret.add(ident.asString());
        if (ctx.varList() != null) {
            Value listToAppendTo = this.visit(ctx.varList());
            ret.addAll(listToAppendTo.asStringArrayList());
        }
        return new Value(ret);
    }


}