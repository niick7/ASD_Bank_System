package ui.bank;

import framework.bank.AccountServiceImpl;
import framework.bank.BCodeGenerator;

public class Controller {
    public static AccountServiceImpl accountService = AccountServiceImpl.myAccountService();
    public static TemplateToCreateAccount templateToCreateAccount = new CreateAccountConcrete(accountService);
    public static AccountDisplayer displayer;
    public static AccountDeposit accountDeposit;
    public static AccountWithdraw accountWithdraw;
    public static AddInterest addInterest;
    public static BCodeGenerator accountNumberGenerator = BCodeGenerator.myAccountGenerator();

    public static String[] createAccount(String name,String street,String city,String state,String zip,String email,String ID,String dateOfBirth, String customerType,String accountType){
        String code= accountNumberGenerator.generateCode();
        displayer = new AccountDisplayer(templateToCreateAccount.create(name,street,city,state,zip,email,ID,dateOfBirth, customerType,accountType,code));

        String[] result = new String[6];
        result[0] = displayer.getName();
        result[1] = displayer.getAccountNumber();
        result[2] = displayer.getCustomerType();
        result[3] = displayer.getAccountType();
        result[4] = String.valueOf(displayer.getBalance());
        result[5] = displayer.getCity();
        System.out.println(displayer.getAccountNumber());


        return result;
    }

    public static double deposit(String ID, double amount){
        accountDeposit = new AccountDeposit(accountService);
        return accountDeposit.execute(ID, amount);
    }

    public static double withdraw(String ID, double amount){
        accountWithdraw = new AccountWithdraw(accountService);
        return accountWithdraw.execute(ID, amount);
    }

    public static double addInterest(String ID, double amount){
        addInterest = new AddInterest(accountService);
        return addInterest.execute(ID, amount);
    }

    public static String generateReport(String ID){
        return accountService.generateReport(ID);
    }

}
