package framework.bank;

import framework.Common.AccountType;

public class SavingAccount implements AccountType {
    @Override
    public double[] execute(double credit) {
        double[] a = new double[1];
        if(credit>5000){
            a[0]= credit*0.04;
            return a;
        }else if (credit>1000 && credit<5000 ){
            a[0]= credit*0.02;
            return a;
        }else {
            a[0] = credit*0.01;
            return a;
        }
    }

    @Override
    public String getAccountTypeName() {
        return "SavingAccount";
    }
}
