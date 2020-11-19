package ui.ccard;

import framework.ccard.*;

public class AccountDeposit extends CommanderPage  {
    public AccountDeposit(AccountServiceImpl accountService) {
        super(accountService);
    }

    @Override
    public double execute(String ID, double amount) {
        accountService.deposit(ID,amount);
        return accountService.getAccount(ID).getBalance();
    }
}
