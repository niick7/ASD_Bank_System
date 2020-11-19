package framework.ccard;

public class SilverAccount extends AccountType {
    @Override
    double getMonthlyInterest(double credit) {
        return credit * 0.08;
    }

    @Override
    double getMonthlyMinimumPayment(double credit) {
        return credit * 0.12;
    }

    @Override
    public String getAccountTypeName() {
        return "Silver";
    }
}
