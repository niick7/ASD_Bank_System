package framework.bank;

public class CheckingAccount implements AccountType {
    @Override
    public double AddInterest(double balance) {
        if(balance>1000){
            return balance*0.025;
        }else return balance*0.015;
    }

    @Override
    public String getAccountTypeName() {
        return "CheckingAccount";
    }

}
