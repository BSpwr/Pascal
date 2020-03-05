package pascal;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Pair;

import java.util.*;
import java.util.stream.IntStream;

public class ContextManager {
    private static ContextManager ctxInst = null;

    private Stack<Context> varContainer;
    private Integer state;
    private HashMap<Integer,ArrayList<String>> delta;
    private Boolean debug = false;

    private ContextManager(){
        this.varContainer = new Stack<Context>();
        // Initialize base context
        this.varContainer.add(new Context());
        this.state = 0;
        this.delta = new HashMap<Integer,ArrayList<String>>();
        // Init base delta
        this.delta.put(0, new ArrayList<String>());
    }

    private ContextManager(Boolean debug){
        this.varContainer = new Stack<Context>();
        // Initialize base context
        this.varContainer.add(new Context());
        this.state = 0;
        this.delta = new HashMap<Integer,ArrayList<String>>();
        // Init base delta
        this.delta.put(0, new ArrayList<String>());
        this.debug = debug;
    }

    public static ContextManager getInstance(){
        if (ctxInst == null) {
            ctxInst = new ContextManager();
        }
        return ctxInst;
    }

    public static ContextManager getInstance(Boolean debug){
        if (ctxInst == null) {
            ctxInst = new ContextManager(debug);
        }
        return ctxInst;
    }

    public Stack<Context> getVarContainer() {
        return varContainer;
    }

    public void enterScope(){
        ++this.state;
    }

    private void unsafeExitScope(){
        this.delta.remove(state);
        --this.state;
    }

    public void exitScope(){
        for(String variable : this.delta.getOrDefault(this.state, new ArrayList<String>())){
            deleteIdentifier(variable);
        }
        this.unsafeExitScope();
    }

    public void addToDelta(ArrayList<String> idents){
        if(this.delta.containsKey(this.state)){
            ArrayList<String> temp = this.delta.get(this.state);
            temp.addAll(idents);
            this.delta.replace(this.state,temp);
        }
        else{
            this.delta.put(this.state, idents);
        }
    }

    public void overrideGlobals(ArrayList<String> idents){
        if (this.state > 0) {
            for (String ident : idents) {
                if (this.delta.get(0).contains(ident)) {
                    this.varContainer.get(this.state).overrides.add(ident);
                }
            }
        }
    }

    public void createVariable(ArrayList<String> varNames, Value varType){
        this.addToDelta(varNames);
        this.overrideGlobals(varNames);
        //Check if it's an enum type
        if(this.varContainer.peek().enumDataType.containsKey(varType.asString())) {
            this.varContainer.peek().enumVariableType.putAll(IntStream.range(0, varNames.size())
                    .collect(HashMap::new,
                            (map, i) -> map.put(varNames.get(i), varType.asString()),
                            Map::putAll));
            this.varContainer.peek().enumVariableValue.putAll(IntStream.range(0, varNames.size())
                    .collect(HashMap::new,
                            (map, i) -> map.put(varNames.get(i), this.varContainer.peek().enumDataType.get(varType.asString()).get(0)),
                            Map::putAll));
        }
        else {
            this.varContainer.peek().variables.putAll(IntStream.range(0, varNames.size())
                    .collect(HashMap::new,
                            (map, i) -> map.put(varNames.get(i), varType),
                            Map::putAll));
        }
    }

    public void createConst(ArrayList<String> varNames, Value expr){
        this.addToDelta(varNames);
        this.overrideGlobals(varNames);

        this.varContainer.peek().constants.putAll(IntStream.range(0, varNames.size())
                .collect(HashMap::new,
                        (map, i) -> map.put(varNames.get(i), expr),
                        Map::putAll));
    }

    public void createEnum(Value ident, ArrayList<String> enumTypes){
        ArrayList<String> idents = new ArrayList<String>();
        idents.add(ident.asString());
        this.addToDelta(idents);
        this.overrideGlobals(idents);

        this.varContainer.peek().enumDataType.put(ident.asString(), enumTypes);
    }

    /**
     * Deletes anything with matching key
     * @param key
     */
    public void deleteIdentifier(String key){
        if (this.varContainer.peek().variables.containsKey(key)) {
            this.varContainer.peek().variables.remove(key);
        } else if (this.varContainer.peek().enumVariableValue.containsKey(key)) {
            this.varContainer.peek().enumDataType.remove(this.varContainer.peek().enumVariableType.get(key));
            this.varContainer.peek().enumVariableType.remove(key);
            this.varContainer.peek().enumVariableValue.remove(key);
        } else if (this.varContainer.peek().constants.containsKey(key)) {
            this.varContainer.peek().constants.remove(key);
        } else {
            Util.throwE("Undefined symbol -> " + key + ".");
        }
    }

    /**
     * Sets the variable and returns the previous value
     * @param key
     * @param val
     * @return the previous value of var in the map
     */
    public Value setVariable(String key, Value val){
        Value ret = null;
        if (this.varContainer.peek().variables.containsKey(key)) {
            Value v = val;
            Value k = getVariable(key);
            if (v.equalType(k)) {
                ret = this.varContainer.peek().variables.get(key);
                this.varContainer.peek().variables.replace(key, v);
            } else if (v.isNonFloatNumber() && k.isDouble()) {
                ret = this.varContainer.peek().variables.get(key);
                this.varContainer.peek().variables.replace(key, new Value(v.asDouble()));
            } else {
                Util.throwE("Unmatched types on assignment");
            }
        } else if (this.varContainer.peek().enumVariableValue.containsKey(key)) {
            boolean isValid = false;
            ArrayList<String> arr = this.varContainer.peek().enumDataType.get(this.varContainer.peek().enumVariableType.get(key));
            for (String s : arr) {
                if (val.isString() && val.asString().equals(s)) {
                    isValid = true;
                    break;
                }
            }
            if (isValid) {
                this.varContainer.peek().enumVariableValue.replace(key, val.asString());
            } else {
                Util.throwE("Attempted to assign an enum of a different or undefined type.");
            }
        } else if (this.varContainer.peek().constants.containsKey(key)) {
            Util.throwE("Attempted to assign to a constant.");
        } else {
            Util.throwE("Undefined symbol -> " + key + ".");
        }
        return ret;
    }

    /**
     * Gets the variable and returns the current value
     * @param key
     * @return the current value of var in the map
     */
    public Value getVariable(String key){
        if (this.varContainer.peek().variables.containsKey(key)) {
            return this.varContainer.peek().variables.get(key);
        } else if (this.varContainer.peek().constants.containsKey(key)) {
            return this.varContainer.peek().constants.get(key);
        } else if (this.varContainer.peek().enumVariableValue.containsKey(key)) {
            return new Value(this.varContainer.peek().enumVariableValue.get(key));
        } else {
            if (this.debug) {
                System.out.println("Checking if the identifier: " + key + " is an enum.");
            }
            for (HashMap.Entry<String, ArrayList<String>> a : this.varContainer.peek().enumDataType.entrySet()) {
                for (String s : a.getValue()) {
                    if (s.equals(key)) {
                        return new Value(key);
                    }
                }
            }
            if (this.debug) {
                System.out.println(key + " <-- Not an enum!");
            }
            return Value.VOID;
        }
    }

    /**
     * Duplicates the variables into a new context and returns that context
     * @param vars
     * @return
     */
    public Context dupContext(ArrayList<String> vars){
        Context nCtx = new Context();
        //copy variables to the new context, new contexts do not inherit overrides
        for (String var : vars){
            if (this.varContainer.peek().variables.containsKey(var)) {
                nCtx.variables.put(var, this.varContainer.peek().variables.get(var));
            } else if (this.varContainer.peek().constants.containsKey(var)) {
                nCtx.constants.put(var, this.varContainer.peek().constants.get(var));
            } else if (this.varContainer.peek().enumVariableValue.containsKey(var)) {
                nCtx.enumVariableValue.put(var, this.varContainer.peek().enumVariableValue.get(var));
                nCtx.enumVariableType.put(var, this.varContainer.peek().enumVariableType.get(var));
                nCtx.enumDataType.put(this.varContainer.peek().enumVariableType.get(var), this.varContainer.peek().enumDataType.get(this.varContainer.peek().enumVariableType.get(var)));
            }
        }
        //copy all function definitions
        nCtx.functionMap = this.varContainer.peek().functionMap;
        return nCtx;
    }

    /**
     * Restores the variables referred to in vars from their values in the top of the stack, ignoring values whose variable names overrode global def
     * @param vars
     */
    public void revertContext(ArrayList<String> vars){
        //pop off the stack
        Context dCtx = this.varContainer.pop();
        //remove overrides from the set without affecting the original
        ArrayList<String> tVars = new ArrayList<String>(vars);
        tVars.removeAll(dCtx.overrides);
        //update the variables
        for (String var : tVars){
            if (dCtx.variables.containsKey(var)) {
                this.varContainer.peek().variables.replace(var, dCtx.variables.get(var));
            } else if (dCtx.constants.containsKey(var)) {
                this.varContainer.peek().constants.replace(var, dCtx.constants.get(var));
            } else if (dCtx.enumVariableValue.containsKey(var)) {
                this.varContainer.peek().enumVariableValue.replace(var, dCtx.enumVariableValue.get(var));
                this.varContainer.peek().enumVariableType.replace(var, dCtx.enumVariableType.get(var));
                this.varContainer.peek().enumDataType.replace(dCtx.enumVariableType.get(var), dCtx.enumDataType.get(dCtx.enumVariableType.get(var)));
            }
        }
    }

    public Value createFunction(String name, Function func) {
        return this.createFunction(name, func.argsList, func.functionContent, func.returnType);
    }

    public Value createFunction(String name, ArrayList<Pair<String,Value>> argsList, ArrayList<ParserRuleContext> functionContent, Value returnType){
        // If function was defined and is now being declared, make sure the variable types match
        if (this.varContainer.peek().functionMap.containsKey(name)) {
            Function oldFunc = this.varContainer.peek().functionMap.get(name);
            if (oldFunc.argsList.size() != argsList.size())
                Util.throwE("Function -> " + name + " <- is being redefined with mismatched number of variables.");
            if (!oldFunc.returnType.equalType(returnType))
                Util.throwE("Function -> " + name + " <- is being redefined with mismatched return type.");
            for (int i = 0; i < oldFunc.argsList.size(); i++)
                if (!oldFunc.argsList.get(i).b.equalType(argsList.get(i).b))
                    Util.throwE("Function -> " + name + " <- is being redefined with mismatched types.");
        }
        Function func = new Function(name, argsList, functionContent, returnType);
        this.varContainer.peek().functionMap.put(name, func);
        return Value.VOID;
    }

    /**
     * Captures function parameters and parent, and recursively executes the contents
     * @param caller
     * @param name
     * @param argsList
     * @return
     */
    public Value doFunction(EvalVisitor caller, String name, ArrayList<Value> argsList){
        Function func = this.varContainer.peek().functionMap.getOrDefault(name, null);
        Value ret = Value.VOID;

        ArrayList<String> argsToOverride = new ArrayList<String>();

        //generate a new context
        this.varContainer.push(dupContext(this.delta.get(0)));
        //update state
        this.enterScope();

        if (func != null) {
            try {
                for (int i = 0; i < func.argsList.size(); i++) {
                    //add the args to the overrides
                    argsToOverride.add(func.argsList.get(i).a);
                    if (func.argsList.get(i).b.equalType(argsList.get(i))) {
                        this.varContainer.peek().variables.put(func.argsList.get(i).a, argsList.get(i));
                    } else if (argsList.get(i).isNonFloatNumber() && func.argsList.get(i).b.isDouble()) {
                        this.varContainer.peek().variables.put(func.argsList.get(i).a, new Value(argsList.get(i).asDouble()));
                    }
                    else
                        Util.throwE("Function -> " + name + " <- called with invalid type.");
                }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                Util.throwE("Function -> " + name + " <- called with invalid number of args.");
            }

            //override globals
            this.overrideGlobals(argsToOverride);

            // for returns
            if (!func.returnType.isVoid())
                this.varContainer.peek().variables.put(func.name, func.returnType);

            for (ParserRuleContext funcCtx : func.functionContent) {
                caller.visit(funcCtx);
            }

            if (!func.returnType.isVoid()) {
                if (this.varContainer.peek().variables.containsKey("result")) {
                    Value resultRet = this.getVariable("result");
                    if (!resultRet.isVoid() && resultRet.equalType(func.returnType)) ret = resultRet;
                    else Util.throwE("Function -> " + name + " <- returned the incorrect type.");
                }
                else {
                    Value nameRet = this.getVariable(func.name);
                    if (!nameRet.isVoid()) ret = nameRet;
                }
            }
        } else Util.throwE("Function -> " + name + " <- is not defined.");

        //destroy current context and update globals
        this.revertContext(this.delta.get(0));
        //update state without running ref removal
        this.unsafeExitScope();

        return ret;
    }

    public HashMap<String, ArrayList<String>> exposeEnums(){
        return this.varContainer.peek().enumDataType;
    }
}
