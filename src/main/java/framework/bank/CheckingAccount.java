package framework.bank;

import framework.Common.AccountType;

public class CheckingAccount implements AccountType {

    @Override
    public double[] execute(double credit) {
        double[] a = new double[1];
        if(credit>1000){
            a[0]= credit*0.025;
            return a;
        }else{
            a[0]= credit*0.015;
            return a;
        }
    }

    @Override
    public String getAccountTypeName() {
        return "CheckingAccount";
    }

}
