import java.util.Scanner;

public class PrintString {

    /**
     * Print string with maximal length in a array of a given size
     *
     * @param scanner using for read system console input stream
     */
    public static void printStringWithMaxLength(Scanner scanner) {
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
