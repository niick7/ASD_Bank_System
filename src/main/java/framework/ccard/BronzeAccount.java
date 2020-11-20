package framework.ccard;

import framework.Common.AccountType;

public class BronzeAccount implements AccountType {
    private double getMonthlyInterest(double credit) {
        return credit * 0.1;
    }

    private double getMonthlyMinimumPayment(double credit) {
        return credit * 0.14;
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
        return "Bronze";
    }
}
