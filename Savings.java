public class Savings extends Account {

    private int safetyDepositBoxId;
    private int safetyDepositBoxKey;

    public Savings(String name, String ssn, double initialDeposit) {
        super(name, ssn, initialDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() - 0.25;
    }

    private void setSafetyDepositBox() {
        safetyDepositBoxId = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
    }

    public void showInfo() {
        super.showInfo();
        System.out.println(
            "ACCOUNT TYPE: Savings" + 
            "\n  Safety Deposit Box ID: " + safetyDepositBoxId + 
            "\n  Safety Deposit Box Key: " + safetyDepositBoxKey
        );
    }

}