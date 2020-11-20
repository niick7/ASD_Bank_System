package framework.ccard;

import framework.Common.Account;
import framework.Common.Address;
import framework.Common.Customer;

import java.util.ArrayList;
import java.util.List;

public class CompanyAccount implements Customer {
    private String fullName;
    private String ID;
    private String dateEstablished;
    private String email;
    private Address address;
    List<Account> myAccountList;

    public CompanyAccount(String fullName,String ID, String email, Address address, String dateEstablished) {
        this.fullName = fullName;
        this.ID = ID;
        this.email = email;
        this.address = address;
        this.dateEstablished = dateEstablished;
        myAccountList = new ArrayList<>();
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String  getAge() {
        return dateEstablished;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public void setAccount(Account account) {
        myAccountList.add(account);
    }


    @Override
    public void update() {

    }
}
