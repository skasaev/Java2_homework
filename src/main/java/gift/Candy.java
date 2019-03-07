package gift;

public class Candy extends Sweets {
    private String filling;

    public Candy(int weight, double price, String filling) {
        super("Candies", weight, price);
        this.filling = filling;
    }

    public String getFilling() {
        return filling;
    }
}