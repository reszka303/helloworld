package pl.javastart.security.calculator;

public class Result {
    private double a;
    private double b;
    private String operator;
    private double result;

    public Result(double a, double b, String operator, double result) {
        this.a = a;
        this.b = b;
        this.operator = operator;
        this.result = result;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return a + " " + operator + " " + b + " = " + result;
    }
}