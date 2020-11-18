package framework.ccard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class CreditCardAccount implements  Account {
    private Customer customer;
    private double balance;
    private AccountType accountType;
    private String accoutTypeName;

    private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

    public CreditCardAccount(Customer customer, AccountType accountType, double balance) {
        this.customer = customer;
        this.accountType = accountType;
        this.balance = balance;
        accoutTypeName = this.accountType.toString();
    }

    public String getAccountName() {
        return accoutTypeName;
    }
    public AccountType getAccountType(){
        return accountType;
    }

    public String getAccountID() {
        return customer.getID();
    }

//    public void setAccountNumber(String accountNumber) {
//        this.accountNumber = accountNumber;
//    }

    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : entryList) {
            balance += entry.getAmount();
        }
        return balance;
    }

    public void deposit(double amount) {
        balance+=amount;
        AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
        entryList.add(entry);
        notifyObserver();
    }

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
        entryList.add(entry);
        notifyObserver();
    }

    public void addEntry(AccountEntry entry) {
        entryList.add(entry);
    }

    public void transferFunds(Account toAccount, double amount, String description) {
        AccountEntry fromEntry = new AccountEntry(-amount, description, toAccount.getAccountID(),
                toAccount.getCustomer().getFullName());
        AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountID(),
                toAccount.getCustomer().getFullName());

        entryList.add(fromEntry);

        toAccount.addEntry(toEntry);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection<AccountEntry> getEntryList() {
        return entryList;
    }


    @Override
    public void notifyObserver() {
        customer.update();
    }
}
