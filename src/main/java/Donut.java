public class Donut extends Sweets {
    private char size; //should be one of {S,M,L}

    Donut(int weight, double price, char size) {
        super("Donut", weight, price);
        this.size = size;
    }

    public char getSize() {
        return size;
    }
}
