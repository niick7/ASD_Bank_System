package framework.ccard;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class CompanyAccount implements Customer {
    private String fullName;
    private String ID;
    private LocalDate dateEstablished;
    private String email;
    private int phoneNumber;
    private Address address;
    List<Account> myAccountList;

    public CompanyAccount(String fullName,String ID, String email, int phoneNumber,Address address, int yearEstablished, int monthEstablished, int dayEstablished) {
        this.fullName = fullName;
        this.ID = ID;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(yearEstablished,monthEstablished-1,dayEstablished);
        dateEstablished = gregorianCalendar.toZonedDateTime().toLocalDate();
        myAccountList = new ArrayList<>();
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public LocalDate getAge() {
        return dateEstablished;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public int getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String getAddress() {
        return address.toString();
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
