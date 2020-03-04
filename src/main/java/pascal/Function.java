package pascal;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

public class Function {
    public final String name;
    public final ArrayList<Pair<String,Value>> argsList;
    public final ArrayList<ParserRuleContext> functionContent;
    public final Value returnType;

    public Function(String name, ArrayList<Pair<String,Value>> argsList, ArrayList<ParserRuleContext> functionContent, Value returnType) {
        this.name = name;
        this.argsList = argsList;
        this.functionContent = functionContent;
        this.returnType = returnType;
    }
}