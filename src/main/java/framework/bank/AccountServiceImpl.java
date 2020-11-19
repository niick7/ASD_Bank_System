package framework.bank;



import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;

    private AccountServiceImpl(){
        accountDAO = new BankingAccountDAO();
    }
    private final static AccountServiceImpl accountService = new AccountServiceImpl();

    public static AccountServiceImpl myAccountService(){
        return accountService;
    }

    public Account createAccount(Customer client, AccountType accountType) {
        Customer customer = client;
        if(!accountDAO.findAccount(customer.getID())){
            Account account = new BankingAccount(customer,accountType,0);

            accountDAO.addAccount(customer.getID(),account);
            return account;
        }else {
            Customer a = getAccount(customer.getID()).getCustomer();
            Account account = new BankingAccount(a,accountType,0);
            a.setAccount(account);
            accountDAO.addAccount(a.getID(),account);
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
        double interest =0;
        Account account = getAccount(accountNumber);
        interest= account.getAccountType().AddInterest(account.getBalance());
//        System.out.println("this is your interest: " + interest);
        deposit(accountNumber,interest);
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
