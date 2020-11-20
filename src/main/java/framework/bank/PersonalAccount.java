package framework.bank;
import framework.Common.Account;
import framework.Common.Address;
import framework.Common.Customer;
import framework.Common.Observer;

import java.util.ArrayList;
import java.util.List;

public class PersonalAccount implements Customer, Observer {
    private String fullName;
    private String ID;
    private String birthDate;
    private String email;
    private Address address;
    List<Account> myAccountList;

    public PersonalAccount(String fullName, String ID, String email, String birthDate, Address address) {
        this.fullName = fullName;
        this.ID = ID;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
        myAccountList = new ArrayList<>();
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getAge() {
        return birthDate;
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
//        setNotificationType(new EmailNotification());
//
//        getNotificationType().send(this.email,message);

    }
}
