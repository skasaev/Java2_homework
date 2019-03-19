package gift;

public class Candy extends Sweets {
    private static String SWEETS_TYPE = "Candies";
    private String filling;

    public Candy(String name, int weight, double price, String filling) {
        super(name, weight, price);
        this.filling = filling;
    }

    public String getFilling() {
        return filling;
    }

    @Override
    public String toString() {
        return SWEETS_TYPE + " '"+ this.getName()+"' with " + this.getFilling() + ". " + getParams();
    }
}
