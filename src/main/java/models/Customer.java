package models;

import java.time.LocalDate;

public interface Customer {
	String getFullName();
	LocalDate getAge();
	String getEmail();
	int getPhoneNumber();
	String getAddress();
}
