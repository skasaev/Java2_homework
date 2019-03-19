import java.util.Locale;
import java.util.Scanner;

public class Calcualtor {

    /**
     * Print result of 2 numbers addition, subtraction, multiplication or division without input validation
     *
     * @param scanner using for read system console input stream
     */
    public static void calculator(Scanner scanner) {
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
    }
}
