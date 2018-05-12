package atm;

public class ATM {
    private double balance;

    public ATM(double balance){
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public double withdraw(double amount){
        if(balance < amount){
            throw new IllegalArgumentException("Not enough balance for this withdrawal.");
        }
        balance -= amount;
        return amount;
    }

    public void deposit(double amount){
        balance += amount;
    }
}
