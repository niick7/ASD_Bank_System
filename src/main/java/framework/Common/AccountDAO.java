package framework.Common;

public interface AccountDAO {
    boolean findAccount(String accountNumber);
    void addAccount(String accountNumber, Account account);
    Account getAccount(String accountNumber);
    boolean updateAccount(Account account);
}
