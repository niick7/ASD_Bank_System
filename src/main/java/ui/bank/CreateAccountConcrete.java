package ui.bank;

import framework.Common.Account;
import framework.Common.AccountType;
import framework.Common.Address;
import framework.Common.Customer;
import framework.bank.*;

public class CreateAccountConcrete extends TemplateToCreateAccount {
    public CreateAccountConcrete(AccountServiceImpl accountService) {
        super(accountService);
    }

    @Override
    Address createAddress(String street, String city, String state, String zip) {
        return new Address(street,city,state,zip);
    }

    @Override
    Customer createCustomer(String name, String ID, String email, String dateOfBirth, Address address, String customerType) {
        if(customerType.equalsIgnoreCase("company")){
            return new CompanyAccount(name,ID,email,address,dateOfBirth);
        }else return new PersonalAccount(name,ID,email,dateOfBirth,address);
    }

    @Override
    AccountType createAccountType(String accountType) {
        if(accountType.equalsIgnoreCase("Checking")){
            return new CheckingAccount();
        }else return new SavingAccount();
    }

    @Override
    Account createAccount(Customer customer, AccountType accountType, String accountNumber) {
        return accountService.createAccount(customer,accountType,accountNumber);
    }
}
