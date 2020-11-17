package models;

public class CheckingAccount implements AccountType {
  @Override
  public double computeInterest(double balance) {
    double interest = 0.0;
    if (balance < 1000.0)
      interest = (balance*1.5)/100; // 1.5%
    else
      interest = (balance*2.5)/100; // 2.5%

    return interest;
  }
}
