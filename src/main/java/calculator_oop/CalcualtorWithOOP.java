package calculator_oop;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class CalcualtorWithOOP {

    /**
     * Print result of 2 numbers addition, subtraction, multiplication or division
     *
     * @param scanner using for read system console input stream
     */
    public static void calculate(Scanner scanner) throws DivisionByZeroException {
        double firstNumber = 0;
        double secondNumber = 0;
        String symbol;
        try {
            System.out.println("Enter the first number (double): ");
            firstNumber = scanner.nextDouble();
            System.out.println("Enter the second number (double): ");
            secondNumber = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.err.println("You should enter only numbers");
            System.exit(0);
        }

        System.out.println("Enter operations symbol (+ - * /):");
        symbol = scanner.next();

        double result = 0;
        switch (symbol) {
            case "+":
                Addition add = new Addition();
                result = add.execute(firstNumber, secondNumber);
                break;
            case "-":
                Subtraction sub = new Subtraction();
                result = sub.execute(firstNumber, secondNumber);
                break;
            case "*":
                Multiplication mult = new Multiplication();
                result = mult.execute(firstNumber, secondNumber);
                break;
            case "/":
                try {
                    Division div = new Division();
                    result = div.execute(firstNumber, secondNumber);
                } catch (DivisionByZeroException e) {
                    System.err.println("Catch " + e.getClass().getName() +" with message: " + e.getMessage());
                    System.exit(0);
                }
                break;
            default:
                System.err.println("Wrong operations symbol " + symbol);
                System.exit(0);
        }
        System.out.printf(Locale.ENGLISH,"Result of operation %f %s %f = %.4f", firstNumber, symbol, secondNumber, result);
    }
}
