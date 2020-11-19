package framework.ccard;

public abstract class AccountType {
    double[] result = new double[2];

    public double[] execute(double credit){
        result[0]= getMonthlyInterest(credit);
        result[1]= getMonthlyMinimumPayment(credit);
        return result;
    }

    abstract double getMonthlyInterest(double credit);
    abstract double getMonthlyMinimumPayment(double credit);
    abstract public String getAccountTypeName();
}
