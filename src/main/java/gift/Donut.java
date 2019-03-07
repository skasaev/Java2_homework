package gift;

public class Donut extends Sweets {
    private char size; //should be one of {S,M,L}

    public Donut(int weight, double price, char size) {
        super("gift.Donut", weight, price);
        this.size = size;
    }

    public char getSize() {
        return size;
    }
}
