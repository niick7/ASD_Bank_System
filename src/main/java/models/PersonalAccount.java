package models;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class PersonalAccount implements Customer {
  private String firstName;
  private String lastName;
  private LocalDate birthDate;
  private String email;
  private int phoneNumber;
  private Address address;

  public PersonalAccount(String firstName, String lastName, String email, int phoneNumber,Address address, int yearBorn, int monthBorn, int dayBorn) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
    GregorianCalendar gregorianCalendar = new GregorianCalendar();
    gregorianCalendar.set(yearBorn,monthBorn-1,dayBorn);
    birthDate = gregorianCalendar.toZonedDateTime().toLocalDate();
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

}

