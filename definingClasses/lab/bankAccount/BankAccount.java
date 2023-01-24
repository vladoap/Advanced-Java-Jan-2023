package definingClasses.lab.bankAccount;

 class BankAccount {

    private static double interestRate = 0.02;
    private static int count;

    private int id;
    private double balance;

    BankAccount () {
        BankAccount.count ++;
        id = BankAccount.count;
        System.out.printf("Account ID%d created%n", id);
    }



    public void deposit (double amount) {
        this.balance += amount;
        System.out.printf("Deposited %.0f to ID%d%n", amount, id);
    }

    public double getInterest (int years) {
        return BankAccount.interestRate * years * this.balance;
    }

    public int getId () {
        return id;
    }

    public static void setInterestRate (double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public static int getCount () {
        return count;
    }

}
