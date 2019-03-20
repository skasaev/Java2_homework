package gift;

import java.util.List;
import java.util.Locale;

public class Gift {
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
