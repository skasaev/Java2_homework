package calculator_oop;

public class Multiplication implements Operation {
    @Override
    public double execute(double first, double second) {
        return first * second;
    }
}
