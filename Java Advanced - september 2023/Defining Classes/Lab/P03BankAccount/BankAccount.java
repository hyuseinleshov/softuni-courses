package P03BankAccount;

public class BankAccount {

    private int id;
    private double balance;

    private static double interestRate = 0.02;

    private static int bankAccountCount = 1;

    public int getId() {
        return id;
    }

    public BankAccount() {
        this.id = bankAccountCount;
        bankAccountCount++;
    }

    public double getInterest(int years) {

        return BankAccount.interestRate * years * balance;
    }


    public static void setInterestRate(double interestRate) {

        BankAccount.interestRate = interestRate;
    }

    public void deposit(double amount) {

        this.balance += amount;
    }


}
