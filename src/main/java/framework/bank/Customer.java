package framework.bank;

import java.time.LocalDate;

public interface Customer extends Observer {
    String getFullName();
    LocalDate getAge();
    String getEmail();
    int getPhoneNumber();
    String getAddress();
}
