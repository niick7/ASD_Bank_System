package framework.ccard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CompanyAccount implements Customer {
    private String fullName;
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int ID;
    private String email;
    private Address address;
    List<Account> myAccountList;

    public CompanyAccount(String fullName, String email, Address address) {
        this.fullName = fullName;
        this.ID = count.incrementAndGet();
        this.email = email;
        this.address = address;
        myAccountList = new ArrayList<>();
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getAddress() {
        return address.toString();
    }

    @Override
    public String getID() {
        return ID + "";
    }

    @Override
    public void setAccount(Account account) {
        myAccountList.add(account);
    }

    @Override
    public void update() {

    }
}
