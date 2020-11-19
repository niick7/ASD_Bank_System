package framework.ccard;

public class GoldAccount extends AccountType {

    @Override
    double getMonthlyInterest(double credit) {
        return credit * 0.06;
    }

    @Override
    double getMonthlyMinimumPayment(double credit) {
        return credit * 0.1;
    }

    @Override
    public String getAccountTypeName() {
        return "Gold";
    }

}
