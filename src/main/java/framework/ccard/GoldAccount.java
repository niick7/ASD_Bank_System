package framework.ccard;

public class GoldAccount extends AccountType {

    @Override
    double getMonthlyInterest(double credit) {
//        System.out.println(credit * 0.06);
        return credit * 0.06;
    }

    @Override
    double getMonthlyMinimumPayment(double credit) {
//        System.out.println(credit * 0.1);
        return credit * 0.1;
    }
    @Override
    public String toString() {
        return "GoldAccount";
    }
}
