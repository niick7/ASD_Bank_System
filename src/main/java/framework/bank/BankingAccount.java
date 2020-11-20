package framework.bank;


import framework.Common.Account;
import framework.Common.AccountEntry;
import framework.Common.AccountType;
import framework.Common.Customer;

import java.util.ArrayList;
import java.util.List;

public class BankingAccount implements Account {
    private Customer customer;
    private double balance;
    private AccountType accountType;
    private String accoutTypeName;
    private String accountNumber;

    private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

    public BankingAccount(Customer customer, AccountType accountType, double balance,String accountNumber) {
        this.customer = customer;
        this.accountType = accountType;
        this.balance = balance;
        this.accoutTypeName = this.accountType.toString();
        customer.setAccount(this);
        this.accountNumber=accountNumber;
    }

    public String getAccountName() {
        return accoutTypeName;
    }
    public AccountType getAccountType(){
        return accountType;
    }

    public String getAccountID() {
        return customer.getID();
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }


    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : entryList) {
            balance += entry.getAmount();
        }
        return balance;
    }

    public void deposit(double amount) {
        balance+=amount;
        AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
        entryList.add(entry);
        if(!checker()){
            notifyObserver();
        }else personalRule(amount);
    }

    public void withdraw(double amount) {
        balance-=amount;
        AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
        entryList.add(entry);
        if(!checker()){
            notifyObserver();
        }else personalRule(amount);
    }

    public void addEntry(AccountEntry entry) {
        entryList.add(entry);
    }

    public void transferFunds(Account toAccount, double amount, String description) {
        AccountEntry fromEntry = new AccountEntry(-amount, description, toAccount.getAccountID(),
                toAccount.getCustomer().getFullName());
        AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountID(),
                toAccount.getCustomer().getFullName());

        entryList.add(fromEntry);

        toAccount.addEntry(toEntry);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<AccountEntry> getEntryList() {
        return entryList;
    }

    @Override
    public String generateBill() {
        return null;
    }


    @Override
    public void notifyObserver() {

    }

    private boolean checker(){
        if(customer instanceof PersonalAccount){
            return true;
        }return false;
    }

    private boolean personalRule(double amount){
        if(amount>400){
            notifyObserver();
            return true;
        }else if(balance<0){
            notifyObserver();
            return true;
        }
        return false;
    }

}
