import java.util.logging.Logger;

// Интерфейс для определения операции калькулятора
interface CalculatorOperation {
    double calculate(double x, double y);
}

// Классы реализации операций
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

// Класс калькулятора, который выполняет операции
class Calculator {
    // Логгер для записи выполненных операций
    private static final Logger logger = Logger.getLogger(Calculator.class.getName());

    // Ссылка на текущую операцию
    private CalculatorOperation operation;

    // Конструктор калькулятора, принимающий операцию в качестве аргумента
    public Calculator(CalculatorOperation operation) {
        this.operation = operation;
    }

    // Метод для выполнения операции и записи результата в лог
    public double calculate(double x, double y) {
        double result = operation.calculate(x, y);
        logger.info("Calculation: " + x + " " + operation.getClass().getSimpleName() + " " + y + " = " + result);
        return result;
    }
}

// Главный класс, содержащий метод main для запуска программы
public class Main {
    public static void main(String[] args) {
        // Создание объектов операций
        CalculatorOperation addition = new Addition();
        CalculatorOperation multiplication = new Multiplication();
        CalculatorOperation division = new Division();

        // Создание калькулятора с операцией сложения
        Calculator calculator = new Calculator(addition);
        // Вывод результата сложения
        System.out.println("2 + 3 = " + calculator.calculate(2, 3));

        // Создание калькулятора с операцией умножения
        calculator = new Calculator(multiplication);
        // Вывод результата умножения
        System.out.println("2 * 3 = " + calculator.calculate(2, 3));

        // Создание калькулятора с операцией деления
        calculator = new Calculator(division);
        // Вывод результата деления
        System.out.println("6 / 3 = " + calculator.calculate(6, 3));
    }
}
