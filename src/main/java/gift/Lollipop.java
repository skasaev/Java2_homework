package gift;

public class Lollipop extends Sweets {
    private static String SWEETS_TYPE = "Lollipop";
    private String taste;

    public Lollipop(String name, int weight, double price, String taste) {
        super(name, weight, price);
        this.taste = taste;
    }

    public String getTaste() {
        return taste;
    }

    @Override
    public String toString() {
        return SWEETS_TYPE + " '"+ this.getName()+"' with " + this.getTaste() + " taste. " + getParams();
    }
}
