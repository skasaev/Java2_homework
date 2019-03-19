package calculator_oop;

import java.util.Locale;
import java.util.Scanner;

public class CalcualtorWithOOP {

    /**
     * Print result of 2 numbers addition, subtraction, multiplication or division without input validation
     *
     * @param scanner using for read system console input stream
     */
    public static void calculate(Scanner scanner) {
        System.out.println("Enter the first number (double): ");
        double firstNumber = scanner.nextDouble();
        System.out.println("Enter the second number (double): ");
        double secondNumber = scanner.nextDouble();
        System.out.println("Enter operations symbol (+ - * /):");
        String symbol = scanner.next();

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
                if (secondNumber == 0) {
                    System.err.println("Wrong value of the second number");
                    System.exit(0);
                }
                Division div = new Division();
                result = div.execute(firstNumber, secondNumber);
                break;
            default:
                System.err.println("Wrong operations symbol " + symbol);
                System.exit(0);
        }
        System.out.printf(Locale.ENGLISH,"Result of operation %f %s %f = %.4f", firstNumber, symbol, secondNumber, result);
    }
}
