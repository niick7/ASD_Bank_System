package ui.bank;

import framework.bank.AccountServiceImpl;
import framework.bank.AccountType;
import framework.bank.Address;
import framework.bank.Customer;
import framework.bank.Account;

public abstract class TemplateToCreateAccount {
    private Address address;
    private Customer customer;
    private AccountType accountType;
    AccountServiceImpl accountService;

    public TemplateToCreateAccount(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    public Account create(String name, String street, String city, String state, String zip, String email, String ID, String dateOfBirth, String customerType, String accountType){
        address = createAddress(street,city,state,zip);
        customer = createCustomer(name, ID, email, dateOfBirth, address, customerType);
        this.accountType = createAccountType(accountType);
        return createAccount(customer,this.accountType);
    }
    abstract Address createAddress(String street, String city, String state, String zip);
    abstract Customer createCustomer(String name, String ID, String email, String dateOfBirth,Address address, String customerType);
    abstract AccountType createAccountType(String accountType);
    abstract Account createAccount(Customer customer, AccountType accountType);
}
