package framework.ccard;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;

    public AccountServiceImpl(){
        accountDAO = new CreditCardAccountDAO();
    }

    public Account createAccount(Customer client, AccountType accountType, double balance) {
        Customer customer = client;
        Account account = new CreditCardAccount(customer,accountType,balance);
        customer.setAccount(account);

        accountDAO.addAccount(customer.getID(),account);

        return account;
    }

    public void deposit(String accountID, double amount) {
        Account account = accountDAO.getAccount(accountID);
        account.deposit(amount);

        accountDAO.updateAccount(account);
    }


    public Account getAccount(String accountID) {
        Account account = accountDAO.getAccount(accountID);
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
    public void addInterest(String accountID) {
        double interest =0;
        double minimumPayment=0;
        Account account = getAccount(accountID);
        double[] collector = account.getAccountType().execute(account.getBalance());
        interest = collector[0];
        minimumPayment = collector[1];
//        System.out.println("this is your interest: " + interest);
        deposit(accountID,interest);
    }
}
