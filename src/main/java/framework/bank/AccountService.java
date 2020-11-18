package framework.bank;

public interface AccountService {
    Account createAccount(String accountNumber, AccountType accountType, Customer cust);
    Account getAccount(String accountNumber);
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
    void addInterest(String accountNumber);
}
