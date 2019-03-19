package calculator_oop;

public class Subtraction implements Operation {
    @Override
    public double execute(double first, double second) {
        return first - second;
    }
}
