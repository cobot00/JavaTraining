package calculate;

public enum Operator {
    
    ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/");
    
    private final String operator;
    
    Operator(String operator) {
        this.operator = operator;            
    }
    
    @Override
    public String toString() {
        return operator;
    }
}
