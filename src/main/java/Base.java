import gift.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Homework test #4
 * run the one of the two tasks
 * 1 - first minimal positive and first maximal negative element of array and change its position,
 * 2 - generate New Year gift and print its composition
 *
 * @author Sanal Kasaev
 */

public class Base {
    private static final int SIZE_OF_ARRAY = 20;
    private static final int ARRAY_ELEMENT_MIN_VALUE = -10;
    private static final int ARRAY_ELEMENT_MAX_VALUE = 10;

    private static final int SWEETS_MIN_WEIGHT = 10;
    private static final int SWEETS_MAX_WEIGHT = 500;
    private static final double SWEETS_MIN_PRICE = 0.01;
    private static final double SWEETS_MAX_PRICE = 5.00;

    public static void main(String[] args) {
        System.out.println("Homework test #4");

        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);
        ThreadLocalRandom random = ThreadLocalRandom.current();

        System.out.println("Enter number of task: \n" +
                "1 - find first minimal positive and first maximal negative element of array and change its position,\n" +
                "2 - generate New Year gift and print its composition");
        String taskNumber = scanner.next();
        switch (taskNumber) {
            case "1":
                System.out.println("Get random array and Change position of first minimal positive and first maximal negative element in array");
                int[] intArray;
                intArray = new int[SIZE_OF_ARRAY];
                for (int i=0; i< intArray.length; i++) {
                    intArray[i] = random.nextInt(ARRAY_ELEMENT_MIN_VALUE, ARRAY_ELEMENT_MAX_VALUE + 1);
                }
                System.out.println("Array of random integer numbers:");
                printIntArray(intArray);
                System.out.println("After changing: ");
                printIntArray(changePositionOfMinOrMaxElementInArray(intArray));
                break;
            case "2":
                System.out.println("Generate and print a gift for the New Year");
                List<Sweets> sweetsList = new ArrayList<>();
                sweetsList.add(new Candy(
                        random.nextInt(SWEETS_MIN_WEIGHT, SWEETS_MAX_WEIGHT + 1),
                        Double.parseDouble(String.format(Locale.ENGLISH, "%.2f",
                                random.nextDouble(SWEETS_MIN_PRICE, SWEETS_MAX_PRICE + 0.01))),
                        "Chocolate"));
                sweetsList.add(new Candy(
                        random.nextInt(SWEETS_MIN_WEIGHT, SWEETS_MAX_WEIGHT + 1),
                        Double.parseDouble(String.format(Locale.ENGLISH, "%.2f",
                                random.nextDouble(SWEETS_MIN_PRICE, SWEETS_MAX_PRICE + 0.01))),
                        "Apple jam"));
                sweetsList.add(new Donut(
                        random.nextInt(SWEETS_MIN_WEIGHT, SWEETS_MAX_WEIGHT + 1),
                        Double.parseDouble(String.format(Locale.ENGLISH, "%.2f",
                                random.nextDouble(SWEETS_MIN_PRICE, SWEETS_MAX_PRICE + 0.01))),
                        'L'));
                sweetsList.add(new JellyBean(
                        random.nextInt(SWEETS_MIN_WEIGHT, SWEETS_MAX_WEIGHT + 1),
                        Double.parseDouble(String.format(Locale.ENGLISH, "%.2f",
                                random.nextDouble(SWEETS_MIN_PRICE, SWEETS_MAX_PRICE + 0.01))),
                        (byte) random.nextInt(5, 31)));
                sweetsList.add(new Lollipop(
                        random.nextInt(SWEETS_MIN_WEIGHT, SWEETS_MAX_WEIGHT + 1),
                        Double.parseDouble(String.format(Locale.ENGLISH, "%.2f",
                                random.nextDouble(SWEETS_MIN_PRICE, SWEETS_MAX_PRICE + 0.01))),
                        "Orange"));
                Gift gift = new Gift();
                gift.setSweets(sweetsList);
                System.out.println("gift.Gift total weight = " + gift.getTotalWeight() + " g");
                System.out.printf(Locale.ENGLISH, "gift.Gift total price = %.2f $\n", gift.getTotalPrice());
                System.out.println("gift.Gift composition: ");
                gift.printGiftComposition();
                break;
            default:
                System.out.println("Wrong task number " + taskNumber);
                break;
        }
        scanner.close();
    }


    /**
     * find maximal negative and minimal positive element of integer's array, and change its position
     * @param ints original array of integer numbers
     * @return array of integer after changing position
     */
    private static int[] changePositionOfMinOrMaxElementInArray(int[] ints) {
        int minPositiveNumber = ARRAY_ELEMENT_MAX_VALUE;
        int maxNegativeNumber = ARRAY_ELEMENT_MIN_VALUE;
        int indexOfMinPositiveNumber = 0;
        int indexOfMaxNegativeNumber = 0;

        for (int i=0; i < ints.length; i++) {
            if (ints[i] < 0 && ints[i] > maxNegativeNumber) {
                maxNegativeNumber = ints[i];
                indexOfMaxNegativeNumber = i;
            } else if (ints[i] > 0 && ints[i] < minPositiveNumber) {
                minPositiveNumber = ints[i];
                indexOfMinPositiveNumber = i;
            }
        }
        ints[indexOfMaxNegativeNumber] = minPositiveNumber;
        ints[indexOfMinPositiveNumber] = maxNegativeNumber;
        return ints;
    }

    /**
     * print array in format [element1, element2, ..., elementN]
     * @param array which need to print
     */
    private static void printIntArray(int[] array) {
        System.out.print("[");
        int size = array.length;
        for (int i=0; i < size-1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[size-1] + "]\n");
    }
}
