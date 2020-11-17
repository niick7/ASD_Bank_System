package models;

public interface AccountType {
  public default double computeInterest(double balance){ return 0; };
}
