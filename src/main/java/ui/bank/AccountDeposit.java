package ui.bank;

import framework.bank.AccountServiceImpl;

public class AccountDeposit extends CommanderPage {
    public AccountDeposit(AccountServiceImpl accountService) {
        super(accountService);
    }

    @Override
    double execute(String ID, double amount) {
        accountService.deposit(ID,amount);
        return accountService.getAccount(ID).getBalance();
    }
}
