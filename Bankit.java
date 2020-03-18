import java.util.*;

public class Bankit {

    public static void main(String[] args) {
        String file = "NewBankAccounts.csv";
        List<Account> accounts = new LinkedList<Account>();

        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolders) {
            String name = accountHolder[0];
            String ssn = accountHolder[1];
            String accountType = accountHolder[2];
            double initialDeposit = Double.parseDouble(accountHolder[3]);

            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, ssn, initialDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, ssn, initialDeposit));
            }
        } 

        for (Account account : accounts) {
            account.showInfo();
        }
    }

}