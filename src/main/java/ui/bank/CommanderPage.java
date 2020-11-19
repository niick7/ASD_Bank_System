package ui.bank;

import framework.bank.AccountServiceImpl;

public abstract class CommanderPage {
    AccountServiceImpl accountService;

    public CommanderPage(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }
    abstract double execute(String ID, double amount);
}
