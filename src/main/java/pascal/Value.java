package pascal;

import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

public class Value {

    public static Value VOID = new Value(new Object());

    public static Value FALSE = new Value(false);
    public static Value TRUE = new Value(false);

    public static Value CONTINUE = new Value("__PASCAL_INTERPRETER_INTERNAL_CONTINUE_STATEMENT");
    public static Value BREAK = new Value("__PASCAL_INTERPRETER_INTERNAL_BREAK_STATEMENT");

    public static Value BOOLEAN = new Value(false);
    public static Value INTEGER = new Value(0);
    public static Value REAL = new Value((double) 0);
    public static Value CHARACTER = new Value('\0');
    public static Value STRING = new Value("\0");

    public final Object value;

    public Value(Object value) {
        if (value == null)
            this.value = Value.VOID;
        else
            this.value = value;
    }

    public Object asObject() {
        return value;
    }

    public Boolean asBoolean() {
        return (boolean) value;
    }

    public Character asCharacter() {
        return value.toString().charAt(0);
    }

    public Integer asInteger() {
        return (int) Double.parseDouble(value.toString());
    }

    public Double asDouble() {
        return Double.parseDouble(value.toString());
    }

    public String asString() {
        return String.valueOf(value);
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Object> asObjectArrayList() {
        return (ArrayList<Object>) value;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Boolean> asBooleanArrayList() {
        return (ArrayList<Boolean>) value;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Character> asCharacterArrayList() {
        return (ArrayList<Character>) value;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Integer> asIntegerArrayList() {
        return (ArrayList<Integer>) value;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Double> asDoubleArrayList() {
        return (ArrayList<Double>) value;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<String> asStringArrayList() {
        return (ArrayList<String>) value;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Value> asValueArrayList() {
        return (ArrayList<Value>) value;
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Pair<String, Value>> asArgsTypeList() {
        return (ArrayList<Pair<String, Value>>) value;
    }

    public boolean isVoid() {
        return equals(VOID);
    }

    public boolean isBoolean() {
        return value.getClass().equals(Boolean.class);
    }

    public boolean isCharacter() {
        return value.getClass().equals(Character.class);
    }

    public boolean isInteger() {
        return value.getClass().equals(Integer.class);
    }

    public boolean isDouble() {
        return value.getClass().equals(Double.class);
    }

    public boolean isString() {
        return value.getClass().equals(String.class);
    }

    public boolean isArrayList() {
        return value.getClass().equals(ArrayList.class);
    }

    public boolean isBooleanArrayList() {
        if (!isArrayList()) return false;
        ArrayList<?> lst = (ArrayList<?>) value;
        if (lst.size() == 0) return true;
        return lst.get(0).getClass().equals(Boolean.class);
    }

    public boolean isCharacterArrayList() {
        if (!isArrayList()) return false;
        ArrayList<?> lst = (ArrayList<?>) value;
        if (lst.size() == 0) return true;
        return lst.get(0).getClass().equals(Character.class);
    }

    public boolean isIntegerArrayList() {
        if (!isArrayList()) return false;
        ArrayList<?> lst = (ArrayList<?>) value;
        if (lst.size() == 0) return true;
        return lst.get(0).getClass().equals(Integer.class);
    }

    public boolean isDoubleArrayList() {
        if (!isArrayList()) return false;
        ArrayList<?> lst = (ArrayList<?>) value;
        if (lst.size() == 0) return true;
        return lst.get(0).getClass().equals(Double.class);
    }

    public boolean isStringArrayList() {
        if (!isArrayList()) return false;
        ArrayList<?> lst = (ArrayList<?>) value;
        if (lst.size() == 0) return true;
        return lst.get(0).getClass().equals(String.class);
    }

    public boolean isValueArrayList() {
        if (!isArrayList()) return false;
        ArrayList<?> lst = (ArrayList<?>) value;
        if (lst.size() == 0) return true;
        return lst.get(0).getClass().equals(Value.class);
    }

    public boolean isPairArrayList() {
        if (!isArrayList()) return false;
        ArrayList<?> lst = (ArrayList<?>) value;
        if (lst.size() == 0) return true;
        return lst.get(0).getClass().equals(Pair.class);
    }

    public boolean isNonFloatNumber() {
        return isCharacter() || isInteger();
    }

    public boolean isNumber() {
        return isCharacter() || isInteger() || isDouble();
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    public boolean equalType(Value rhs) {
        if (isVoid())
            return rhs.isVoid();
        if (isArrayList()) {
            if (isBooleanArrayList())
                return rhs.isBooleanArrayList();
            else if (isCharacterArrayList())
                return rhs.isCharacterArrayList();
            else if (isIntegerArrayList())
                return rhs.isIntegerArrayList();
            else if (isDoubleArrayList())
                return rhs.isDoubleArrayList();
            else if (isStringArrayList())
                return rhs.isStringArrayList();
            else if (isValueArrayList())
                return rhs.isValueArrayList();
            else if (isPairArrayList())
                return rhs.isPairArrayList();
        }

        return value.getClass().equals(rhs.value.getClass());
    }

    public boolean equals(Value rhs) {
        return value.equals(rhs.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}