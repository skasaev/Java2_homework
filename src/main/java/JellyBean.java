public class JellyBean extends Sweets {
    private byte inPackQuantity;

    JellyBean(int weight, double price, byte inPackQuantity) {
        super("Jelly Beans", weight, price);
        this.inPackQuantity = inPackQuantity;
    }

    public byte getInPackQuantity() {
        return inPackQuantity;
    }
}
