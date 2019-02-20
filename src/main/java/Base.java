import java.util.Locale;
import java.util.Scanner;

/**
 * Homework test #3
 * run the simple calculator or search for the string with maximum length in an array of a given size
 *
 * @author Sanal Kasaev
 */

public class Base {
    public static void main(String[] args) {
        System.out.println("Homework test #3");

        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);

        System.out.println("Enter number of task: (1 - calculator, 2 - string array)");
        String taskNumber = scanner.next();
        if (taskNumber.equals("1")) {
            System.out.println("Running simple calculator");
            calculator(scanner);
        } else {
            System.out.println("Running search string with max length in array");
            printStringWithMaxLength(scanner);
        }
        scanner.close();
    }

    /**
     * Print result of 2 numbers addition, subtraction, multiplication or division without input validation
     *
     * @param scanner using for read system console input stream
     */
    private static void calculator(Scanner scanner) {
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

    /**
     * Print string with maximal length in a array of a given size
     *
     * @param scanner using for read system console input stream
     */
    private static void printStringWithMaxLength(Scanner scanner) {
        System.out.println("Enter the strings size: ");
        int arraySize = scanner.nextInt();
        String[] strings = new String[arraySize];

        for (int i=0; i<arraySize; i++) {
            System.out.println("Enter " + (i+1) + " element of string array:");
            strings[i] = scanner.next();
        }

        String maxLengthString = "";
        for (String element : strings) {
            if (element.length() > maxLengthString.length()) {
                maxLengthString = element;
            }
        }

        System.out.println("String with maximal length is " + maxLengthString
                + "\nIts length = " + maxLengthString.length());
    }
}
