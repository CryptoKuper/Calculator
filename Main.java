import java.util.logging.Logger;

interface CalculatorOperation {
    double calculate(double x, double y);
}

class Addition implements CalculatorOperation {
    @Override
    public double calculate(double x, double y) {
        return x + y;
    }
}

class Multiplication implements CalculatorOperation {
    @Override
    public double calculate(double x, double y) {
        return x * y;
    }
}

class Division implements CalculatorOperation {
    @Override
    public double calculate(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Division by zero!");
        }
        return x / y;
    }
}

class Calculator {
    private static final Logger logger = Logger.getLogger(Calculator.class.getName());
    
    private CalculatorOperation operation;

    public Calculator(CalculatorOperation operation) {
        this.operation = operation;
    }

    public double calculate(double x, double y) {
        double result = operation.calculate(x, y);
        logger.info("Calculation: " + x + " " + operation.getClass().getSimpleName() + " " + y + " = " + result);
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        CalculatorOperation addition = new Addition();
        CalculatorOperation multiplication = new Multiplication();
        CalculatorOperation division = new Division();

        Calculator calculator = new Calculator(addition);
        System.out.println("2 + 3 = " + calculator.calculate(2, 3));

        calculator = new Calculator(multiplication);
        System.out.println("2 * 3 = " + calculator.calculate(2, 3));

        calculator = new Calculator(division);
        System.out.println("6 / 3 = " + calculator.calculate(6, 3));
    }
}

