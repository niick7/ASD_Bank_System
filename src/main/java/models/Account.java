package models;

import java.util.Collection;

public interface Account {
	String getAccountName();
	AccountType getAccountType();
	String getAccountNumber();
	void setAccountNumber(String accountNumber);
	double getBalance();
	void deposit(double amount);
	void withdraw(double amount);
	void addEntry(AccountEntry entry);
	void transferFunds(Account toAccount, double amount, String description);
	Customer getCustomer();
	void setCustomer(Customer customer);
	Collection<AccountEntry> getEntryList();
}
