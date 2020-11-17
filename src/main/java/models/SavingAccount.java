package models;

public class SavingAccount implements AccountType {
  @Override
  public double computeInterest(double balance) {
    double interest = 0.0;
    if (balance >= 5000.0)
      interest = balance/25; // 4%
    else if (balance >= 1000.0 && balance < 5000.0)
      interest = balance/50; // 2%
    else
      interest = balance/100; // balance is lower than 1000 and interest will be 1%

    return interest;
  }
}
