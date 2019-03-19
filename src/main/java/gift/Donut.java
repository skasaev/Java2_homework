package gift;

public class Donut extends Sweets {
    private static String SWEETS_TYPE = "Donut";
    private char size; //should be one of {S,M,L}

    public Donut(String name, int weight, double price, char size) {
        super(name, weight, price);
        this.size = size;
    }

    public char getSize() {
        return size;
    }

    @Override
    public String toString() {
        return SWEETS_TYPE + " '"+ this.getName()+"' with size " + this.getSize() + ". " + getParams();
    }
}
