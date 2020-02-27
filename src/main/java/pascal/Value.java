package pascal;

public class Value {

    public static Value VOID = new Value(new Object());

    public final Object value;

    public Value(Object value) {
        this.value = value;
    }

    public Object getObject() {
        return value;
    }

    public Boolean asBoolean() {
        return (Boolean)value;
    }
    public Double asDouble() {
        return (Double)value;
    }
    public String asString() {
        return String.valueOf(value);
    }

    public boolean isVoid() {
        return this.value.equals(VOID.value);
    }
    public boolean isBoolean() {
        return value instanceof Boolean;
    }
    public boolean isDouble() {
        return value instanceof Double;
    }
    public boolean isString() {
        return value instanceof String;
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