import java.util.Locale;
import java.util.Scanner;

/**
 * Addition, subtraction, multiplication and division of 2 numbers without input validation
 *
 * @author Sanal Kasaev
 */

public class Base {
    public static void main(String[] args) {
        System.out.println("Calculator 0.1");

        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);

        System.out.println("Enter the first number (double): ");
        double firstNumber = scanner.nextDouble();
        System.out.println("Enter the second number (double): ");
        double secondNumber = scanner.nextDouble();
        System.out.println("Enter operations symbol (+ - * /):");
        String symbol = scanner.next();

        double result = 0;

        switch (symbol) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    System.err.println("Wrong value of the second number");
                    System.exit(0);
                }
                result = firstNumber / secondNumber;
                break;
            default:
                System.err.println("Wrong operations symbol " + symbol);
                System.exit(0);
        }
        System.out.printf(Locale.ENGLISH,"Result of operation %f %s %f = %.4f", firstNumber, symbol, secondNumber, result);

        scanner.close();
    }
}
