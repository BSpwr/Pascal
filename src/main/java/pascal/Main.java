package pascal;

import java.lang.Exception;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

// using grun ---
// boris at aero15 in .../build/classes/java/main on  gradle_p2 [»!+?]
//        λ-> grun pascal.Pascal start ../../../../src/test/boris_old_tests/hello_world.pas -gui

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            return;
        }

        System.out.println("parsing: " + args[0]);

        PascalLexer lexer = new PascalLexer(new ANTLRFileStream(args[0]));
        PascalParser parser = new PascalParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.start();
        EvalVisitor visitor = new EvalVisitor();
        visitor.visit(tree);
    }
}