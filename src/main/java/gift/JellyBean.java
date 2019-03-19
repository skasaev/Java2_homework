package gift;

public class JellyBean extends Sweets {
    private static String SWEETS_TYPE = "Jelly Beans";
    private byte inPackQuantity;

    public JellyBean(String name, int weight, double price, byte inPackQuantity) {
        super(name, weight, price);
        this.inPackQuantity = inPackQuantity;
    }

    public byte getInPackQuantity() {
        return inPackQuantity;
    }

    @Override
    public String toString() {
        return SWEETS_TYPE + " '"+ this.getName()+"' with " + this.getInPackQuantity() + "bean in pack. " + getParams();
    }
}
