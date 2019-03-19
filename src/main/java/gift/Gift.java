package gift;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class Gift {
    private static final int SWEETS_MIN_WEIGHT = 10;
    private static final int SWEETS_MAX_WEIGHT = 500;
    private static final double SWEETS_MIN_PRICE = 0.01;
    private static final double SWEETS_MAX_PRICE = 5.00;

    private List<Sweets> sweets;

    public List<Sweets> getSweets() {
        return sweets;
    }

    public void setSweets(List<Sweets> sweets) {
        this.sweets = sweets;
    }

    public int getTotalWeight() {
        return sweets.stream().mapToInt(Sweets::getWeight).sum();
    }

    public double getTotalPrice() {
        return sweets.stream().mapToDouble(Sweets::getPrice).sum();
    }

    public void printGiftComposition() {
        System.out.println("*****************\nGift composition: ");
        System.out.println("Total weight = " + this.getTotalWeight() + " g");
        System.out.printf(Locale.ENGLISH, "Total price = %.2f $\n", this.getTotalPrice());
        sweets.forEach(System.out::println);
    }
}
