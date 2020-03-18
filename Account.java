public abstract class Account implements InterestRate {

    private String name;
    private String ssn;
    private double balance;
    protected String accountNumber;
    protected double rate;

    private static int index = 10000;

    public Account(String name, String ssn, double initialDeposit) {
        this.name = name;
        this.ssn = ssn;
        balance = initialDeposit;
        setAccountNumber();
        setRate();
    }

    public abstract void setRate();

    private void setAccountNumber() {
        String lastTwoOfSsn = ssn.substring(7);
        int uniqueId = index; 
        index++;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        accountNumber = lastTwoOfSsn + uniqueId + randomNumber;
    }

    public void compound() {
        double accruedInterest = balance * (rate / 100);
        balance += accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
    }

    protected void deposit(double amount) {
        balance += amount;
        System.out.println("Depositing $" + amount);
    }

    protected void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawing $" + amount);
    }

    protected void transfer(double amount, String destination) {
        balance -= amount;
        System.out.println("Transfering $" + amount + " to " + destination);
    }

    public void showInfo() {
        System.out.println(
            "NAME: " + name +
            "\nACCOUNT NUMBER: " + accountNumber + 
            "\nBALANCE: $" + balance +
            "\nRATE: " + rate + "%"
        );
    }
}