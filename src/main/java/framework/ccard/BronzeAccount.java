package framework.ccard;

public class BronzeAccount extends AccountType {

    @Override
    double getMonthlyInterest(double credit) {
//        System.out.println(credit * 0.1);
        return credit * 0.1;
    }

    @Override
    double getMonthlyMinimumPayment(double credit) {
//        System.out.println(credit * 0.14);
        return credit * 0.14;
    }

    @Override
    public String toString() {
        return "BronzeAccount";
    }
}
