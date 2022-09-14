package utility;

import interfaces.IPriceable;

public class PriceLogger {

    public static void displayPrice(IPriceable priceable) {
        System.out.println("For: " + priceable);
        System.out.println("Price is: " + priceable.getPrice());
    }
}
