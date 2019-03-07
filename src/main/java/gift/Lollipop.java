package gift;

public class Lollipop extends Sweets {
    private String taste;

    public Lollipop(int weight, double price, String taste) {
        super("gift.Lollipop", weight, price);
        this.taste = taste;
    }

    public String getTaste() {
        return taste;
    }
}
