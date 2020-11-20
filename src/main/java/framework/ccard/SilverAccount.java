package framework.ccard;

import framework.Common.AccountType;

public class SilverAccount implements AccountType {
    private double getMonthlyInterest(double credit) {
        return credit * 0.08;
    }

    private double getMonthlyMinimumPayment(double credit) {
        return credit * 0.12;
    }

    @Override
    public double[] execute(double credit) {
        double[] a = new double[2];
        a[0] = getMonthlyInterest(credit);
        a[1] = getMonthlyMinimumPayment(credit);
        return a;
    }

    @Override
    public String getAccountTypeName() {
        return "Silver";
    }
}
