package framework.ccard;

import java.time.LocalDate;

public interface Customer extends Observer {
    String getFullName();
    LocalDate getAge();
    String getEmail();
    int getPhoneNumber();
    String getAddress();
    String getID();
    void setAccount(Account account);
}
