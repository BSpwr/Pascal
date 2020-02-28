package pascal;

import java.util.ArrayList;

public class Value {

    public static Value VOID = new Value(new Object());

    public static Value FALSE = new Value(false);
    public static Value TRUE = new Value(false);

    public static Value BOOLEAN = new Value(false);
    public static Value INTEGER = new Value((int) 0);
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
        return (char) Double.parseDouble(value.toString());
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

    // java gods pls forgib
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

    public boolean isVoid() {
        return this.value.equals(VOID.value);
    }

    public boolean isBoolean() {
        return value instanceof Boolean;
    }

    public boolean isCharacter() {
        return value instanceof Character;
    }

    public boolean isInteger() {
        return value instanceof Integer;
    }

    public boolean isDouble() {
        return value instanceof Double;
    }

    public boolean isString() {
        return value instanceof String;
    }

    public boolean isArrayList() {
        return value instanceof ArrayList;
    }

    public boolean isBooleanArrayList() {
        if (!(value instanceof ArrayList)) return false;
        ArrayList<?> lst = (ArrayList<?>) value;
        if (lst.size() == 0) return true;
        if (lst.get(0) instanceof Boolean)
            return true;
        else return false;
    }

    public boolean isCharacterArrayList() {
        if (!(value instanceof ArrayList)) return false;
        ArrayList<?> lst = (ArrayList<?>) value;
        if (lst.size() == 0) return true;
        if (lst.get(0) instanceof Character)
            return true;
        else return false;
    }

    public boolean isIntegerArrayList() {
        if (!(value instanceof ArrayList)) return false;
        ArrayList<?> lst = (ArrayList<?>) value;
        if (lst.size() == 0) return true;
        if (lst.get(0) instanceof Integer)
            return true;
        else return false;
    }

    public boolean isDoubleArrayList() {
        if (!(value instanceof ArrayList)) return false;
        ArrayList<?> lst = (ArrayList<?>) value;
        if (lst.size() == 0) return true;
        if (lst.get(0) instanceof Double)
            return true;
        else return false;
    }

    public boolean isStringArrayList() {
        if (!(value instanceof ArrayList)) return false;
        ArrayList<?> lst = (ArrayList<?>) value;
        if (lst.size() == 0) return true;
        if (lst.get(0) instanceof String)
            return true;
        else return false;
    }

    public boolean isValueArrayList() {
        if (!(value instanceof ArrayList)) return false;
        ArrayList<?> lst = (ArrayList<?>) value;
        if (lst.size() == 0) return true;
        if (lst.get(0) instanceof Value)
            return true;
        else return false;
    }

    public boolean isNonFloatNumber() {
        return isCharacter() || isInteger();
    }

    public boolean isNumber() {
        return isCharacter() || isInteger() || isDouble();
    }

    @Override
    public int hashCode() {
        if (value == null) {
            return 0;
        }
        return this.value.hashCode();
    }

    // this hurt to write :)
    public boolean equalType(Value rhs) {

        if (isVoid()) {
            if (rhs.isVoid()) return true;
        }
        if (isBoolean()) {
            if (rhs.isBoolean()) return true;
        }
        if (isCharacter()) {
            if (rhs.isCharacter()) return true;
        }
        if (isDouble()) {
            if (rhs.isDouble()) return true;
        }
        if (isInteger()) {
            if (rhs.isInteger()) return true;
        }
        if (isString()) {
            if (rhs.isString()) return true;
        }
        if (isBooleanArrayList()) {
            if (rhs.isBooleanArrayList()) return true;
        }
        if (isCharacterArrayList()) {
            if (rhs.isCharacterArrayList()) return true;
        }
        if (isIntegerArrayList()) {
            if (rhs.isIntegerArrayList()) return true;
        }
        if (isDoubleArrayList()) {
            if (rhs.isDoubleArrayList()) return true;
        }
        if (isStringArrayList()) {
            if (rhs.isStringArrayList()) return true;
        }
        if (isValueArrayList()) {
            if (rhs.isValueArrayList()) return true;
        }

        return false;
    }

    // somehow this one hurt more
    public boolean equal(Value rhs) {

        if (isVoid()) {
            if (rhs.isVoid()) return true;
        }
        if (isBoolean()) {
            if (rhs.isBoolean()) return asBoolean().equals(rhs.asBoolean());
        }
        if (isCharacter()) {
            if (rhs.isCharacter()) return asCharacter().equals(rhs.asCharacter());
        }
        if (isDouble()) {
            if (rhs.isDouble()) return asDouble().equals(rhs.asDouble());
        }
        if (isInteger()) {
            if (rhs.isInteger()) return asInteger().equals(rhs.asInteger());
        }
        if (isString()) {
            if (rhs.isString()) return asString().equals(rhs.asString());
        }

        // TODO: Ill write it once it's needed
        if (isArrayList()) {
            return equalArrayList(rhs);
        }

        return false;
    }

    public boolean equalArrayList(Value rhs) {
        // TODO: Ill write it once it's needed
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}