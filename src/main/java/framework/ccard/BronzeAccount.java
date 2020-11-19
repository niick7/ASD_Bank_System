package framework.ccard;

public class BronzeAccount extends AccountType {

    @Override
    double getMonthlyInterest(double credit) {
        return credit * 0.1;
    }

    @Override
    double getMonthlyMinimumPayment(double credit) {
        return credit * 0.14;
    }

    @Override
    public String getAccountTypeName() {
        return "Bronze";
    }

}
