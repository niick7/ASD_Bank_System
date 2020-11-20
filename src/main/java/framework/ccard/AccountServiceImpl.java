package framework.ccard;

import framework.Common.*;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;
    private CustomerDAO customerDAO;

    private AccountServiceImpl(){
        accountDAO = new CreditCardAccountDAO();
        customerDAO = new CreditCustomerDAO();
    }

    private final static AccountServiceImpl accountService = new AccountServiceImpl();

    public static AccountServiceImpl myAccountService(){
        return accountService;
    }

    public Account createAccount(Customer client, AccountType accountType, String accountNumber) {

        if(!customerDAO.findCustomer(client)){
            Account account = new CreditCardAccount(client,accountType,0,accountNumber);
            accountDAO.addAccount(account.getAccountNumber(),account);
            customerDAO.addCustomer(client);
            return account;
        }else {
            Customer a = customerDAO.getCustomer(client);
            Account account = new CreditCardAccount(a,accountType,0,accountNumber);
            a.setAccount(account);
            customerDAO.updateCustomer(a);
            accountDAO.addAccount(account.getAccountNumber(),account);
            return account;
        }
    }

    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.getAccount(accountNumber);
        if(account==null){
            System.out.println("no account with this ID");
        }else {
            account.deposit(amount);
            accountDAO.updateAccount(account);
        }
    }


    public Account getAccount(String accountNumber) {
        return accountDAO.getAccount(accountNumber);
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
        double minimumPayment = 0;
        Account account = getAccount(accountNumber);
        double[] collector = account.getAccountType().execute(account.getBalance());
        interest = Math.floor(collector[0] * 100) / 100;;
        minimumPayment = Math.floor(collector[1] * 100) / 100;
        System.out.println("This is your interest: " + interest);
        System.out.println("This is your minimumPayment: " + minimumPayment);
        withdraw(accountNumber, interest);
    }

    @Override
    public String generateReport(String accountNumber) {
        Account account = getAccount(accountNumber);
        return account.generateBill();
    }
}
