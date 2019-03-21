package calculator_oop;

public class DivisionByZeroException extends Exception {
    @Override
    public String getMessage() {
        return "The divider must not be 0";
    }
}
