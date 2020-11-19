package framework.ccard;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;

    private AccountServiceImpl(){
        accountDAO = new CreditCardAccountDAO();
    }

    private final static AccountServiceImpl accountService = new AccountServiceImpl();

    public static AccountServiceImpl myAccountService(){
        return accountService;
    }

    public Account createAccount(Customer client, AccountType accountType) {
        Customer customer = client;
        if(!accountDAO.findAccount(customer.getID())){
            Account account = new CreditCardAccount(customer,accountType,0);

            accountDAO.addAccount(customer.getID(),account);
            return account;
        }else {
            Customer a = getAccount(customer.getID()).getCustomer();
            Account account = new CreditCardAccount(a,accountType,0);
            a.setAccount(account);
            accountDAO.addAccount(a.getID(),account);
            return account;
        }
    }

    public void deposit(String accountID, double amount) {
        Account account = accountDAO.getAccount(accountID);
        if(account==null){
            System.out.println("no account with this ID");
        }else {
            account.deposit(amount);
            accountDAO.updateAccount(account);
        }
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
        double interest = 0;
        double minimumPayment = 0;
        Account account = getAccount(accountID);
        double[] collector = account.getAccountType().execute(account.getBalance());
        interest = Math.floor(collector[0] * 100) / 100;;
        minimumPayment = Math.floor(collector[1] * 100) / 100;
        System.out.println("This is your interest: " + interest);
        System.out.println("This is your minimumPayment: " + minimumPayment);
        withdraw(accountID, interest);
    }

    @Override
    public String generateReport(String ID) {
        String result="";
        List<AccountEntry> List = new ArrayList<>();
        Account account = getAccount(ID);
        List= account.getEntryList();
        for(AccountEntry e: List){
            result+=(e.report()+ " \n");
        }
        return result;
    }
}
