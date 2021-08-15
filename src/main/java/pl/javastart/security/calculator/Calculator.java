package pl.javastart.security.calculator;

class Calculator {
    static Result calculate(double a, double b, String operator) {
        double result;
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Undefined operator: " + operator);
        }
        return new Result(a, b, operator, result);
    }
}