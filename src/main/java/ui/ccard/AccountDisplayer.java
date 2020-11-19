package ui.ccard;

import framework.ccard.*;

public class AccountDisplayer {
    Account account;

    public AccountDisplayer(Account account) {
        this.account = account;
    }

    public String getName(){
        return account.getCustomer().getFullName();
    }
    public String getID(){
        return account.getAccountID();
    }
    public String getCustomerType(){
        if(account.getCustomer() instanceof PersonalAccount) return "Personal Account";
        return "Company Account";
    }
    public String getAccountType(){
        return account.getAccountType().getAccountTypeName();
    }
    public double getBalance(){
        return account.getBalance();
    }
}
