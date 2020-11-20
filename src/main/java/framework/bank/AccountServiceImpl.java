package framework.bank;


import framework.Common.*;

import java.util.ArrayList;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO;
    private CustomerDAO customerDAO;

    private AccountServiceImpl(){
        accountDAO = new BankingAccountDAO();
        customerDAO = new BankingCustomerDAO();
    }
    private final static AccountServiceImpl accountService = new AccountServiceImpl();

    public static AccountServiceImpl myAccountService(){
        return accountService;
    }

    public Account createAccount(Customer client, AccountType accountType, String accountNumber) {

        if(!customerDAO.findCustomer(client)){
            Account account = new BankingAccount(client,accountType,0,accountNumber);
            accountDAO.addAccount(account.getAccountNumber(),account);
            customerDAO.addCustomer(client);
            return account;
        }else {

            Customer a = customerDAO.getCustomer(client);
            Account account = new BankingAccount(a,accountType,0,accountNumber);
            a.setAccount(account);
            customerDAO.updateCustomer(a);
            accountDAO.addAccount(account.getAccountNumber(),account);
            return account;
        }
    }

    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.getAccount(accountNumber);
        if(account==null){
            System.out.println("No account with this ID");
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
    double interest = 0;
    @Override
    public void addInterest(String accountNumber) {
        double interest =0;
        Account account = getAccount(accountNumber);
        double[] a =account.getAccountType().execute(account.getBalance());
        interest= a[0];
//        System.out.println("this is your interest: " + interest);
        deposit(accountNumber,interest);
    }

    @Override
    public String generateReport(String accountNumber) {
        String result="";
        List<AccountEntry> List = new ArrayList<>();
        Account account = getAccount(accountNumber);
        List= account.getEntryList();
        for(AccountEntry e: List){
            result+=(e.report()+ " \n");
        }
        System.out.println(result);
        return result;
    }

}
