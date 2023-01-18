public class Transactions {
    Queue shares = new ArrayQueue<>();

    //Buys set amount of shares at set price
    public void buyShares(int bought, int price) {
        for (int i = 0; i < bought; i++) {
            shares.enqueue(price);
        }
    }

    //Sells set amount of shares at set price
    public void sellShares(int sold, int price) {
        int sharePrice = 0;
        int capitalGains = 0;
        for (int i = 0; i < sold; i++) {
            sharePrice = (int)shares.dequeue();
            capitalGains += price - sharePrice;
        }
        System.out.println("Capital Gains: " + capitalGains);
    }

    //Gets total value of account shares
    public int getTotalValue() {
        int temp, total = 0;
        for (int i = 0; i < shares.size(); i++) {
            temp = (int)shares.dequeue();
            total += temp;
            shares.enqueue(temp);
        }
        return total;
    }

    //Gets total amount of account shares
    public int getTotalShares() {
        return shares.size();
    }
}
