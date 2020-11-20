package framework.ccard;

import framework.Common.Account;
import framework.Common.AccountEntry;
import framework.Common.AccountType;
import framework.Common.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreditCardAccount implements Account {
    private Customer customer;
    private double balance;
    private AccountType accountType;
    private String accountTypeName;
    private String accountNumber;

    private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

    public CreditCardAccount(Customer customer, AccountType accountType, double balance, String accountNumber) {
        this.customer = customer;
        this.accountType = accountType;
        this.balance = balance;
        accountTypeName = this.accountType.toString();
        this.accountNumber = accountNumber;
        customer.setAccount(this);
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


    public String generateBill(){
        LocalDate localDate = LocalDate.now();
        int thisMonth = localDate.getMonth().getValue() -1;
        double previousBalance=0;
        double totalCharegesOfThiMonth=0;
        double totalPaymentOfThisMonth=0;

        for(AccountEntry a: entryList){
            if(a.getDate().getMonth()<thisMonth){
                previousBalance+=a.getAmount();
            }else if (a.getDate().getMonth()==thisMonth){
                if(a.getAmount()>0) totalCharegesOfThiMonth+=a.getAmount();
                else totalPaymentOfThisMonth+=a.getAmount();
            }
        }
        double[] fromAccountType = new double[2];
        fromAccountType[0] =0;
        fromAccountType[1] =0;
        if(previousBalance>0){
            fromAccountType = accountType.execute(previousBalance -totalPaymentOfThisMonth);
        }
        double newBalance=0;
        if(previousBalance!=0){
            newBalance = previousBalance-totalPaymentOfThisMonth+totalCharegesOfThiMonth + fromAccountType[0];
        }else {
            newBalance = totalPaymentOfThisMonth+totalCharegesOfThiMonth + fromAccountType[0];

        }
        double totalDue = fromAccountType[1];


        return  "Credit card bill{ \n" +
                "your previous month balance is: "+previousBalance+
                "\nyour total charge / utilized amount: " + totalCharegesOfThiMonth+
                "\nyour total payment / deposit of this month: " +totalPaymentOfThisMonth+
                "\nyour new balance:"+ newBalance+
                "\nyour total due or minimum payment: " + totalDue +"  }";
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
