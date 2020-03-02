package pascal;

import java.lang.Exception;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

// using grun ---
// boris at aero15 in .../build/classes/java/main on  gradle_p2 [»!+?]
//        λ-> grun pascal.Pascal start ../../../../src/test/t1.pas -gui

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {
            return;
        }

        System.out.println("parsing: " + args[0]);
        CharStream charStream = CharStreams.fromFileName(args[0]);
        PascalLexer lexer = new PascalLexer(charStream);
        PascalParser parser = new PascalParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.start();
        EvalVisitor visitor = new EvalVisitor();
        visitor.visit(tree);
    }
}