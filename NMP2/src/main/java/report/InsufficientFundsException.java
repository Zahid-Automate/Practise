package report;

public class InsufficientFundsException {
    private final int amount;

    public InsufficientFundsException(int amt) {
        this.amount = amt;
    }

    public int getAmt() {
        return amount;
    }
}
