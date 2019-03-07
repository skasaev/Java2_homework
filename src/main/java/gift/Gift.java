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
        sweets.forEach(i -> {
            System.out.print(i.getName() + " with ");
            if (i.getClass().equals(Candy.class)) {
                System.out.print(((Candy) i).getFilling());
            } else if (i.getClass().equals(Donut.class)) {
                System.out.print("size " + ((Donut) i).getSize());
            } else if (i.getClass().equals(JellyBean.class)) {
                System.out.print(((JellyBean) i).getInPackQuantity() + " bean in pack");
            } else if (i.getClass().equals(Lollipop.class)) {
                System.out.print(((Lollipop) i).getTaste());
            }
            System.out.printf(Locale.ENGLISH, " and weight = %d g, price = %.2f $\n", i.getWeight(), i.getPrice());
        });
    }
}
