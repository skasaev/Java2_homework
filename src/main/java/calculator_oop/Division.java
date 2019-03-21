package calculator_oop;

public class Division implements Operation {
    @Override
    public double execute(double first, double second) throws DivisionByZeroException {
        if (second == 0) {
            throw new DivisionByZeroException();
        } else {
            return first / second;
        }
    }
}
