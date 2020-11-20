package ui.bank;

import framework.Common.Account;
import framework.Common.AccountType;
import framework.Common.Address;
import framework.Common.Customer;
import framework.bank.AccountServiceImpl;

public abstract class TemplateToCreateAccount {
    private Address address;
    private Customer customer;
    private AccountType accountType;
    AccountServiceImpl accountService;

    public TemplateToCreateAccount(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    public Account create(String name, String street, String city, String state, String zip, String email, String ID, String dateOfBirth, String customerType, String accountType, String accountNumber){
        address = createAddress(street,city,state,zip);
        customer = createCustomer(name, ID, email, dateOfBirth, address, customerType);
        this.accountType = createAccountType(accountType);
        return createAccount(customer,this.accountType,accountNumber);
    }
    abstract Address createAddress(String street, String city, String state, String zip);
    abstract Customer createCustomer(String name, String ID, String email, String dateOfBirth,Address address, String customerType);
    abstract AccountType createAccountType(String accountType);
    abstract Account createAccount(Customer customer, AccountType accountType,String accountNumber);
}
