
/**
 * An item in the 'shop'
 *
 * @author Modupe Jonathan Robson (mjr40@kent.ac.uk)
 * @version 2018.11.05
 */
public enum Item {
    A("A", 8.00), B("B", 12.00), C("C", 4.00), D("D", 7.00), E("E", 5.00);

    private double price;

    /**
     * Constructor for enum class Item
     * Pre-condition: 'name' is not null
     * Pre-condition: 'price' is greater than 0
     *
     * @param name  The name of the item
     * @param price The cost of the item
     */
    Item(String name, double price) {
        assert name != null : "Item.Item has no name";
        assert price > 0 : "Item.Item has no price";
        this.price = price;
        assert toString().equals(name) : "Item.Item produces wrong toString";
    }

    /**
     * Returns the cost of the item
     *
     * @return price The item cost
     */
    public double getPrice() {
        return price;
    }
}