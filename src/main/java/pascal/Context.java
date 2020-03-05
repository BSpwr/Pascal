package pascal;

import java.util.ArrayList;
import java.util.HashMap;

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

    ArrayList<String> overrides;

    public Context(){
        this.variables = new HashMap<String, Value>();
        this.constants = new HashMap<String, Value>();
        this.enumDataType = new HashMap<String, ArrayList<String>>();

        this.enumVariableType = new HashMap<String, String>();
        this.enumVariableValue = new HashMap<String, String>();

        this.functionMap = new HashMap<String, Function>();
        this.overrides = new ArrayList<String>();
    }

    public Context(Context ctx){
        this.variables = ctx.variables;
        this.constants = ctx.constants;
        this.enumDataType = ctx.enumDataType;

        this.enumVariableType = ctx.enumVariableType;
        this.enumVariableValue = ctx.enumVariableValue;
        this.functionMap = ctx.functionMap;
        this.overrides = ctx.overrides;
    }

}
