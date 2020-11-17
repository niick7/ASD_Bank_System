package models;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class CompanyAccount implements Customer {
  private String fullName;
  private LocalDate dateEstablished;
  private String email;
  private int phoneNumber;
  private Address address;

  public CompanyAccount(String fullName, String email, int phoneNumber,Address address, int yearEstablished, int monthEstablished, int dayEstablished) {
    this.fullName = fullName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
    GregorianCalendar gregorianCalendar = new GregorianCalendar();
    gregorianCalendar.set(yearEstablished,monthEstablished-1,dayEstablished);
    dateEstablished = gregorianCalendar.toZonedDateTime().toLocalDate();
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

}

