package framework.ccard;

import java.util.ArrayList;
import java.util.List;

public class CreditCardAccount implements  Account {
    private Customer customer;
    private double balance;
    private AccountType accountType;
    private String accountTypeName;

    private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

    public CreditCardAccount(Customer customer, AccountType accountType, double balance) {
        this.customer = customer;
        this.accountType = accountType;
        this.balance = balance;
        accountTypeName = this.accountType.toString();
        customer.setAccount(this);
    }
    public CreditCardAccount(AccountType accountType, double balance){
        this.accountType = accountType;
        this.balance = balance;
        accountTypeName = this.accountType.toString();
    }

    public String getAccountName() {
        return accountTypeName;
    }
    public AccountType getAccountType(){
        return accountType;
    }

    public String getAccountID() {
        return customer.getID();
    }

    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : entryList) {
            balance += entry.getAmount();
        }
        return balance;
    }

    public void deposit(double amount) {
        balance-=amount;
        AccountEntry entry = new AccountEntry(-amount, "deposited / paid", "", "");
        entryList.add(entry);
        if(!checker()){
            notifyObserver();
        }else personalRule(amount);

    }

    public void withdraw(double amount) {
        balance+=amount;
        AccountEntry entry = new AccountEntry(amount, "withdrawal / charged", "", "");
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
    public void notifyObserver() {
        customer.update();
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
