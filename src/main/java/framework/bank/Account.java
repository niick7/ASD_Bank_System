package framework.bank;

import java.util.List;

public interface Account extends Observable {
    String getAccountName();
    AccountType getAccountType();
    String getAccountID();
    double getBalance();
    void deposit(double amount);
    void withdraw(double amount);
    void addEntry(AccountEntry entry);
    void transferFunds(Account toAccount, double amount, String description);
    Customer getCustomer();
    void setCustomer(Customer customer);
    List<AccountEntry> getEntryList();

}