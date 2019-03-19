import calculator_oop.CalcualtorWithOOP;
import gift.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

/**
 * Homework tests
 * run the one of homework tests
 * 1 - print "Hello, world",
 * 2 - run simple calculator
 * 3 - search string with max length in array
 * 4 - change position of elements in array
 * 5 - generate gift and print it
 * 6 - run calculator with OOP
 * 7 - run test for Collections
 * 8 - run calculator with try-catch blocks
 *
 *
 * @author Sanal Kasaev
 */

public class Base {
    private static final int SIZE_OF_ARRAY = 10;
    private static final int ARRAY_ELEMENT_MIN_VALUE = -10;
    private static final int ARRAY_ELEMENT_MAX_VALUE = 10;

    private static final int SWEETS_MIN_WEIGHT = 10;
    private static final int SWEETS_MAX_WEIGHT = 500;
    private static final double SWEETS_MIN_PRICE = 0.01;
    private static final double SWEETS_MAX_PRICE = 5.00;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Homework tests");
        System.out.println("choose one of homework tests\n" +
                " * 1 - print \"Hello, world\",\n" +
                " * 2 - run simple calculator\n" +
                " * 3 - search string with max length in array\n" +
                " * 4 - change position of elements in array\n" +
                " * 5 - generate gift and print it\n" +
                " * 6 - run calculator with OOP\n" +
                " * 7 - run test for Collections\n" +
                " * 8 - run calculator with try-catch blocks\n" +
                " * 9 - run Unit tests");
        Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH);

        String taskNumber = scanner.next();
        System.out.println("Start homework test #" + taskNumber);
        switch (taskNumber) {
            case "1":
                System.out.println("Hello, world!");
                break;
            case "2":
                Calcualtor.calculator(scanner);
                break;
            case "3":
                PrintString.printStringWithMaxLength(scanner);
                break;
            case "4":
                getArrayAndChangePosition();
                break;
            case "5":
                generateGift().printGiftComposition();
                break;
            case "6":
                CalcualtorWithOOP.calculate(scanner);
                break;
            case "7":
//                String s = "asd фыв\n вава, ва - ав: апа. ФФФ? ава! 99 вавава";
//                System.out.println(s);
//                System.out.println(s.replaceAll("[^A-Za-zА-Яа-я_0-9]", " "));
                List<String> list = new ArrayList<>();
                try (Scanner s = new Scanner(new FileReader(".\\textFile"))) {
                    while (s.hasNext()) {
                        String str = s.next().toLowerCase().replaceAll("[^A-Za-zА-Яа-я_0-9]", "");
                        list.add(str);
                    }
                    System.out.println(list);
                    System.out.println(list.stream().sorted().collect(Collectors.toList()));
//                    List<String> listDistinct = list.stream().distinct().collect(Collectors.toList());
//                    System.out.println(listDistinct);
                    BinaryOperator<Integer> summ = (a,b) -> a+b;
                    //HashMap<String, Integer> result =
                    list.stream().collect(Collectors
                            .toMap(Function.identity(), i -> 1, summ, HashMap::new)).entrySet().stream()
                            .sorted(Comparator.comparingInt(Map.Entry::getValue)).forEach(System.out::println);
                    s.close();
                }
                break;
            case "8":
                break;
            default:
                System.out.println("Wrong task number " + taskNumber);
                break;
        }
        scanner.close();
    }

    private static Gift generateGift() {
        System.out.println("Generate and print a gift for the New Year");
        ThreadLocalRandom random = ThreadLocalRandom.current();
        List<Sweets> sweetsList = new ArrayList<>();
        sweetsList.add(new Candy(
                "Алёнка",
                random.nextInt(SWEETS_MIN_WEIGHT, SWEETS_MAX_WEIGHT + 1),
                Double.parseDouble(String.format(Locale.ENGLISH, "%.2f",
                        random.nextDouble(SWEETS_MIN_PRICE, SWEETS_MAX_PRICE + 0.01))),
                "Chocolate"));
        sweetsList.add(new Candy(
                "Красный Октябрь",
                random.nextInt(SWEETS_MIN_WEIGHT, SWEETS_MAX_WEIGHT + 1),
                Double.parseDouble(String.format(Locale.ENGLISH, "%.2f",
                        random.nextDouble(SWEETS_MIN_PRICE, SWEETS_MAX_PRICE + 0.01))),
                "Apple jam"));
        sweetsList.add(new Donut(
                "Krispy Kreme",
                random.nextInt(SWEETS_MIN_WEIGHT, SWEETS_MAX_WEIGHT + 1),
                Double.parseDouble(String.format(Locale.ENGLISH, "%.2f",
                        random.nextDouble(SWEETS_MIN_PRICE, SWEETS_MAX_PRICE + 0.01))),
                'L'));
        sweetsList.add(new JellyBean(
                "Starbusrt",
                random.nextInt(SWEETS_MIN_WEIGHT, SWEETS_MAX_WEIGHT + 1),
                Double.parseDouble(String.format(Locale.ENGLISH, "%.2f",
                        random.nextDouble(SWEETS_MIN_PRICE, SWEETS_MAX_PRICE + 0.01))),
                (byte) random.nextInt(5, 31)));
        sweetsList.add(new Lollipop(
                "Chupa Chups",
                random.nextInt(SWEETS_MIN_WEIGHT, SWEETS_MAX_WEIGHT + 1),
                Double.parseDouble(String.format(Locale.ENGLISH, "%.2f",
                        random.nextDouble(SWEETS_MIN_PRICE, SWEETS_MAX_PRICE + 0.01))),
                "Orange"));
        Gift gift = new Gift();
        gift.setSweets(sweetsList);
        return gift;
    }

    private static void  getArrayAndChangePosition() {
        System.out.println("Get random array and Change position of first minimal positive and first maximal negative element in array");
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int[] intArray;
        intArray = new int[SIZE_OF_ARRAY];
        for (int i=0; i< intArray.length; i++) {
            intArray[i] = random.nextInt(ARRAY_ELEMENT_MIN_VALUE, ARRAY_ELEMENT_MAX_VALUE + 1);
        }
        System.out.println("Array of random integer numbers:");
        printIntArray(intArray);
        System.out.println("After changing: ");
        printIntArray(changePositionOfMinOrMaxElementInArray(intArray));
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
