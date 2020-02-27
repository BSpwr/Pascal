package pascal;

import java.util.ArrayList;

public class Value {

    public static Value VOID = new Value(new Object());

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
        return (Boolean)value;
    }
    public Character asCharacter() {
        return (Character)value;
    }
    public Integer asInteger() {
        return (Integer)value;
    }
    public Double asDouble() {
        return (Double)value;
    }
    public String asString() {
        return String.valueOf(value);
    }

    public ArrayList<Object> asObjectArrayList() {
        return (ArrayList<Object>)value;
    }
    public ArrayList<Boolean> asBooleanArrayList() {
        return (ArrayList<Boolean>)value;
    }
    public ArrayList<Character> asCharacterArrayList() {
        return (ArrayList<Character>)value;
    }
    public ArrayList<Integer> asIntegerArrayList() {
        return (ArrayList<Integer>)value;
    }
    public ArrayList<Double> asDoubleArrayList() {
        return (ArrayList<Double>)value;
    }
    public ArrayList<String> asStringArrayList() {
        return (ArrayList<String>)value;
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
        ArrayList<?> lst = (ArrayList<?>)value;
        if (lst.size() == 0) return true;
        if (lst.get(0) instanceof Boolean)
            return true;
        else return false;
    }
    public boolean isCharacterArrayList() {
        if (!(value instanceof ArrayList)) return false;
        ArrayList<?> lst = (ArrayList<?>)value;
        if (lst.size() == 0) return true;
        if (lst.get(0) instanceof Character)
            return true;
        else return false;
    }
    public boolean isIntegerArrayList() {
        if (!(value instanceof ArrayList)) return false;
        ArrayList<?> lst = (ArrayList<?>)value;
        if (lst.size() == 0) return true;
        if (lst.get(0) instanceof Integer)
            return true;
        else return false;
    }
    public boolean isDoubleArrayList() {
        if (!(value instanceof ArrayList)) return false;
        ArrayList<?> lst = (ArrayList<?>)value;
        if (lst.size() == 0) return true;
        if (lst.get(0) instanceof Double)
            return true;
        else return false;
    }
    public boolean isStringArrayList() {
        if (!(value instanceof ArrayList)) return false;
        ArrayList<?> lst = (ArrayList<?>)value;
        if (lst.size() == 0) return true;
        if (lst.get(0) instanceof String)
            return true;
        else return false;
    }

    @Override
    public int hashCode() {
        if(value == null) {
            return 0;
        }
        return this.value.hashCode();
    }

    @Override
    public boolean equals(Object rhs) {
        if(value == null || rhs == null || rhs.getClass() != value.getClass()) {
            return false;
        }
        return value.equals(rhs);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}