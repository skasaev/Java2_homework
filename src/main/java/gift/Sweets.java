package gift;

import java.util.Locale;

public abstract class Sweets {
    private String name;
    private int weight;
    private double price;

    Sweets(String name, int weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    String getParams() {
        return String.format(Locale.ENGLISH, "Weight = %d g, price = %.2f $", this.getWeight(), this.getPrice());
    }
}
