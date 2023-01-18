import java.util.Scanner;

public class Assign1PartB_Driver {
    private static Transactions account = new Transactions();

    public static void main(String[] args) {
        int choice = 0, number = 0, price = 0;
        
        while (true) {
            displayMenu();
            choice = userNumInput();
            switch(choice) {
                case 1:
                    System.out.println("Enter number of shares to buy:");
                    number = userNumInput();
                    System.out.println("Enter purchase price per share:");
                    price = userNumInput();
                    account.buyShares(number, price);
                    displaySummary();
                    break;
                case 2:
                    System.out.println("Enter number of shares to sell:");
                    number = userNumInput();
                    System.out.println("Enter the selling price per share:");
                    price = userNumInput();
                    account.sellShares(number, price);
                    displaySummary();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void displayMenu() {
        System.out.println("Make a selection:  \n" +
                           "1. Buy Shares \n" +
                           "2. Sell shares \n" +
                           "3. Quit");
    }

    public static void displaySummary() {
        System.out.println("Total shares: " + account.getTotalShares() +
                            "\nTotal shares value: " + account.getTotalValue());
    }

    //Catches non-int input
    public static int userNumInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (Exception e){
            System.out.println("Invalid Number: Try again");
            scanner = new Scanner(System.in);
            return userNumInput();
        }
    }
}
