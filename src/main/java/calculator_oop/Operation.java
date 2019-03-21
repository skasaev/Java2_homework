package calculator_oop;

public interface Operation {
    double execute(double first, double second) throws DivisionByZeroException;
}
