package framework.bank;

public class SavingAccount implements AccountType {
    @Override
    public double AddInterest(double balance) {
        if(balance>5000){
            return balance*0.04;
        }else if (balance>1000 && balance<5000){
            return balance*0.02;
        }else return balance*0.01;
    }

    @Override
    public String toString() {
        return "SavingAccount";
    }
}
