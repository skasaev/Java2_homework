import calculator_oop.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class CalculatorUnitTests {

    @Test
    public void additionTest() {
        double first = 123;
        double second = 456;
        double expectedResult = 579;
        Addition add = new Addition();

        double result1 = add.execute(first, second);
        Assert.assertEquals(result1, expectedResult,
                "Сложение " + first + " + " + second + " должно быть равно " + expectedResult);

        double result2 = add.execute(second, first);
        Assert.assertEquals(result2, expectedResult,
                "Сложение " + second + " + " + first + " должно быть равно " + expectedResult);
    }

    @Test
    public void subtractionTest() {
        double first = 789.1;
        double second = 456.2;
        double expectedResult = 332.9;
        Subtraction sub = new Subtraction();

        double result1 = roundNumber(sub.execute(first, second));
        Assert.assertEquals(result1, expectedResult,
                "Разность " + first + " - " + second + " должна быть равна " + expectedResult);

        double result2 = roundNumber(sub.execute(second, first));
        Assert.assertEquals(result2, -expectedResult,
                "Разность " + second + " - " + first + " должна быть равна " + -expectedResult);
    }

    @Test
    public void multiplicationTest() {
        double first = 85.43;
        double second = 0.67;
        double expectedResult = 57.2381;
        Multiplication multiplication = new Multiplication();

        double result1 = roundNumber(multiplication.execute(first, second));
        Assert.assertEquals(result1, expectedResult,
                "Произведение " + first + " * " + second + " должно быть равно " + expectedResult);

        double result2 = roundNumber(multiplication.execute(second, first));
        Assert.assertEquals(result2, expectedResult,
                "Произведение " + second + " * " + first + " должно быть равно " + expectedResult);
    }

    @Test
    public void divisionTest() throws DivisionByZeroException {
        double first = 90.50;
        double second = 136.05;
        double expectedResult = 0.6652;
        Division division = new Division();

        double result1 = roundNumber(division.execute(first, second));
        Assert.assertEquals(result1, expectedResult,
                "Частное " + first + " / " + second + " должно быть равно " + expectedResult);

        double result2 = roundNumber(division.execute(second, first));
        double expectedResult2 = roundNumber(1 / expectedResult);
        Assert.assertEquals(result2, expectedResult2,
                "Частное " + second + " / " + first + " должно быть равно " + expectedResult2);
    }

    @Test(expectedExceptions = DivisionByZeroException.class)
    public void divisionByZeroExceptionTest() throws DivisionByZeroException {
        double first = 123.456;
        double second = 0;
        Division division = new Division();

        division.execute(first, second);
    }

    private double roundNumber(double number) {
        return Double.parseDouble(String.format(Locale.ENGLISH, "%.4f", number));
    }
}
