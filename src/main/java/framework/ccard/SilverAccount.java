package framework.ccard;

public class SilverAccount extends AccountType {
    @Override
    double getMonthlyInterest(double credit) {
//        System.out.println(credit * 0.08);
        return credit * 0.08;
    }

    @Override
    double getMonthlyMinimumPayment(double credit) {
//        System.out.println(credit * 0.12);
        return credit * 0.12;
    }

    @Override
    public String toString() {
        return "SilverAccount";
    }
}
