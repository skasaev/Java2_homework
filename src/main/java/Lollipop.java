public class Lollipop extends Sweets {
    private String taste;

    Lollipop(int weight, double price, String taste) {
        super("Lollipop", weight, price);
        this.taste = taste;
    }

    public String getTaste() {
        return taste;
    }
}
