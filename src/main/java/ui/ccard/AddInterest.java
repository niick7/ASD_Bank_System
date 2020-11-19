package ui.ccard;

import framework.ccard.*;

public class AddInterest extends CommanderPage {
    public AddInterest(AccountServiceImpl accountService) {
        super(accountService);
    }

    @Override
    public double execute(String ID, double amount) {
        accountService.addInterest(ID);
        return accountService.getAccount(ID).getBalance();
    }
}
