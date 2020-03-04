package pascal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Context{
    HashMap<String, Value> variables;
    HashMap<String, Value> constants;

    //the enum name and all possible values
    HashMap<String, ArrayList<String>> enumDataType;

    //the actual enum variable and its respective enum data type
    HashMap<String, String> enumVariableType;
    //the actual enum variable and its value
    HashMap<String, String> enumVariableValue;

    HashMap<String, Function> functionMap;

    public Context(){
        variables = new HashMap<String, Value>();
        constants = new HashMap<String, Value>();
        enumDataType = new HashMap<String, ArrayList<String>>();

        enumVariableType = new HashMap<String, String>();
        enumVariableValue = new HashMap<String, String>();

        functionMap = new HashMap<String, Function>();
    }

    public Context(Context ctx){
        variables = ctx.variables;
        constants = ctx.constants;
        enumDataType = ctx.enumDataType;

        enumVariableType = ctx.enumVariableType;
        enumVariableValue = ctx.enumVariableValue;
        functionMap = ctx.functionMap;
    }

}
