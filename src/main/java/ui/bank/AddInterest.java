package ui.bank;

import framework.bank.AccountServiceImpl;

public class AddInterest extends CommanderPage {
    public AddInterest(AccountServiceImpl accountService) {
        super(accountService);
    }

    @Override
    double execute(String ID, double amount) {
        accountService.addInterest(ID);
        return accountService.getAccount(ID).getBalance();
    }
}
