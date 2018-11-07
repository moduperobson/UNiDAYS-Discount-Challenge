import java.util.Scanner;

/**
 * The main 'app' class
 *
 * Runs the 'app' and accepts, reads, and acts on user input
 *
 * @author Modupe Jonathan Robson (mjr40@kent.ac.uk)
 * @version 2018.11.05
 */
public class Main {
    private UnidaysDiscountChallenge udc;
    private Scanner sc;
    private boolean finished;

    /**
     * Constructor for class Main
     */
    private Main() {
        udc = new UnidaysDiscountChallenge();
        sc = new Scanner(System.in);
        finished = false;
    }

    /**
     * Runs the program
     *
     * @param args An array of command-line arguments provided by java
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    /**
     * Prints a welcome message and displays the item catalogue along with the available options
     *
     * Waits for user input
     */
    private void start() {
        System.out.println("Welcome!");
        System.out.println("Feel free to look around!");
        System.out.println("Our prices and discounts are shown below!");
        System.out.println();
        printCatalogue();
        printMenu();

        while (!finished) {
            getCommand();
        }
    }

    /**
     * Prints the item catalogue
     */
    private void printCatalogue() {
        System.out.println("========================================");
        System.out.println("| ITEM | PRICE  | DISCOUNT             |");
        System.out.println("========================================");
        System.out.println("| A    | £8.00  | NONE                 |");
        System.out.println("| B    | £12.00 | 2 for £20.00         |");
        System.out.println("| C    | £4.00  | 3 for £10.00         |");
        System.out.println("| D    | £7.00  | Buy 1 get 1 FREE     |");
        System.out.println("| E    | £5.00  | 3 for the price of 2 |");
        System.out.println("========================================");
        System.out.println();
    }

    /**
     * Prints the available options
     */
    private void printMenu() {
        System.out.println("Options:");
        System.out.println("1: Add an item (A, B, C, D or E)");
        System.out.println("2: Checkout");
        System.out.println("3: Show discounts");
        System.out.println("4: Exit");
        System.out.println("Please pick an option");
        System.out.println();
    }

    /**
     * Takes the user's input and acts on it as necessary
     *
     * Prints an error if the command doesn't exist or if the command contains errors
     * Prints a success message otherwise
     */
    private void getCommand() {
        String inputLine;
        String word;

        System.out.print("\n> ");

        inputLine = sc.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word = tokenizer.next();
            switch (word) {
                case "1":
                    String letter = parse(tokenizer);
                    if (letter != null) {
                        Item item = null;
                        switch (letter) {
                            case "A":
                                item = Item.A;
                                break;
                            case "B":
                                item = Item.B;
                                break;
                            case "C":
                                item = Item.C;
                                break;
                            case "D":
                                item = Item.D;
                                break;
                            case "E":
                                item = Item.E;
                                break;
                            default:
                                System.out.println("Item " + letter + " doesn't exit\nPlease try again...");
                                break;
                        }
                        if (item != null) {
                            System.out.println("Please enter the quantity of item " + letter + "...");
                            System.out.print("\n> ");

                            String inputLine2 = sc.nextLine();

                            Scanner tokenizer2 = new Scanner(inputLine2);

                            int qty;

                            if (tokenizer2.hasNext()) {
                                qty = Integer.parseInt(tokenizer2.next());
                                udc.addToBasket(item, qty);
                                System.out.println(qty + " Item " + item + " added to basket!");
                            } else {
                                System.out.println("No quantity entered\nPlease try again...");
                            }
                        }
                    } else {
                        System.out.println("No item entered\nPlease try again...");
                    }
                    break;
                case "2":
                    double total[] = udc.CalculateTotalPrice();
                    System.out.println("Your total is: £" + total[0]);
                    System.out.println("Total savings: £" + (total[1] - total[0]));
                    System.out.println("Delivery cost: £" + total[2]);
                    System.out.println();
                    System.out.println("Overall total to pay: £" + total[3]);
                    break;
                case "3":
                    printCatalogue();
                    break;
                case "4":
                    quit();
                    break;
                default:
                    System.out.println("Option " + word + " not recognised\nPlease try again...");
                    System.out.println();
                    printMenu();
            }
        }
    }

    /**
     * Reads the user's input one word at a time
     *
     * @param tokenizer A scanner
     * @return The next word of the user's input
     */
    private String parse(Scanner tokenizer) {
        if (tokenizer.hasNext()) {
            return tokenizer.next();
        }
        return null;
    }

    /**
     * Ends the program
     */
    private void quit() {
        System.out.println("Thank you for shopping!\nGoodbye!");
        finished = true;
    }

}

