package pascal;

public class EvalVisitor extends PascalBaseVisitor<Value> {

    @Override public Value visitStart(PascalParser.StartContext ctx) { System.out.println("Hello pancake!");
    return visitChildren(ctx); }

}