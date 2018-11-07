import java.util.ArrayList;

/**
 * A simple representation of a discount app
 *
 * @author Modupe Jonathan Robson (mjr40@kent.ac.uk)
 * @version 2018.11.05
 */
class UnidaysDiscountChallenge {
    private ArrayList<Item> basket;

    /**
     * Constructor for class UnidaysDiscountChallenge
     */
    UnidaysDiscountChallenge() {
        basket = new ArrayList<>();
    }

    /**
     * Adds the input item to the basket
     *
     * @param item The item to add
     */
    void addToBasket(Item item, int quantity) {
        int i = 0;
        do {
            basket.add(item);
            i++;
        }
        while (i < quantity);
    }

    /**
     * Calculates the total price of the 'order', based on pricing rules for each item
     * Determines if there will be a delivery charge or not
     *
     * @return An array containing the total price of the items, any delivery charge, and the overall cost
     */
    double[] CalculateTotalPrice() {
        double preDiscount = 0;
        double total = 0;

        int totalA = 0;
        int totalB = 0;
        int totalC = 0;
        int totalD = 0;
        int totalE = 0;

        // Determines how many of each item has been purchased
        for (Item item : basket) {
            switch (item) {
                case A:
                    totalA++;
                    break;
                case B:
                    totalB++;
                    break;
                case C:
                    totalC++;
                    break;
                case D:
                    totalD++;
                    break;
                case E:
                    totalE++;
                    break;
            }
        }

        preDiscount += (totalA * Item.A.getPrice());
        preDiscount += (totalB * Item.B.getPrice());
        preDiscount += (totalC * Item.C.getPrice());
        preDiscount += (totalD * Item.D.getPrice());
        preDiscount += (totalE * Item.E.getPrice());

        // Item A: No discount
        total += totalA * Item.A.getPrice();

        // Item B: 2 for £20.00
        int remainderB = totalB % 2;
        total += ((totalB - remainderB) / 2.00) * 20.00;
        total += remainderB * Item.B.getPrice();

        // Item C: 3 for £10.00
        int remainderC = totalC % 3;
        total += ((totalC - remainderC) / 3.00) * 10.00;
        total += remainderC * Item.C.getPrice();

        // Item D: Buy 1 get 1 free (2 for £7.00)
        int remainderD = totalD % 2;
        total += ((totalD - remainderD)) * (Item.D.getPrice() / 2);
        total += remainderD * Item.D.getPrice();

        // Item E: 3 for the price of 2
        int remainderE = totalE % 3;
        total += ((totalE - remainderE) / 3.00) * ((Item.E.getPrice()) * 2);
        total += remainderE * Item.E.getPrice();

        // Free delivery on orders over £50.00 (inclusive)
        double deliveryCharge = 0;
        if (total > 0 && total < 50.00) {
            deliveryCharge = 7.00;
        } else {
            preDiscount += 7.00;
        }

        double overallTotal = total + deliveryCharge;

        return new double[]{total, preDiscount, deliveryCharge, overallTotal};
    }
}
