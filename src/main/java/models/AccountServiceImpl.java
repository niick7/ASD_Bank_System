package models;

import java.util.Collection;

public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;

	public AccountServiceImpl(){
		accountDAO = new BankingAccountDAO();
	}

	public Account createAccount(String accountNumber,AccountType accountType, Customer cust) {
		Account account = new BankingAccount(accountNumber, accountType);
		Customer customer = cust;
		account.setCustomer(customer);

		accountDAO.addAccount(accountNumber,account);

		return account;
	}

	public void deposit(String accountNumber, double amount) {
		Account account = accountDAO.getAccount(accountNumber);
		account.deposit(amount);

		accountDAO.updateAccount(account);
	}


	public Account getAccount(String accountNumber) {
		Account account = accountDAO.getAccount(accountNumber);
		return account;
	}


	public void withdraw(String accountNumber, double amount) {
		Account account = accountDAO.getAccount(accountNumber);
		account.withdraw(amount);
		accountDAO.updateAccount(account);
	}


	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.getAccount(fromAccountNumber);
		Account toAccount = accountDAO.getAccount(toAccountNumber);
		fromAccount.transferFunds(toAccount, amount, description);
		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
	}

	@Override
	public void addInterest(String accountNumber) {
		double interest = 0;
		Account account = getAccount(accountNumber);
		interest = account.getAccountType().AddInterest(account.getBalance());
//        System.out.println("this is your interest: " + interest);
		deposit(accountNumber,interest);
	}
}