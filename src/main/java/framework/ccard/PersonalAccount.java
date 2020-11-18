package framework.ccard;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class PersonalAccount implements Customer {
    private String firstName;
    private String lastName;
    private String ID;
    private LocalDate birthDate;
    private String email;
    private int phoneNumber;
    private Address address;
    List<Account> myAccountList;

    public PersonalAccount(String firstName, String lastName,String ID, String email, int phoneNumber,Address address, int yearBorn, int monthBorn, int dayBorn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(yearBorn,monthBorn-1,dayBorn);
        birthDate = gregorianCalendar.toZonedDateTime().toLocalDate();
        myAccountList = new ArrayList<>();
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public LocalDate getAge() {
        return birthDate;
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
