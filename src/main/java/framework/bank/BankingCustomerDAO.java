package framework.bank;

import framework.Common.Customer;

import java.util.HashMap;

public class BankingCustomerDAO implements framework.Common.CustomerDAO {

    private HashMap<String, Customer> customerList;

    public BankingCustomerDAO() {
        customerList = new HashMap<>();
    }

    @Override
    public void addCustomer(Customer customer) {
        if(null != customer.getID())
            if(!findCustomer(customer)){
                customerList.put(customer.getID(),customer);
            }
    }

    @Override
    public boolean findCustomer(Customer customer) {
        if(null == customer.getID()) return false;
        if(customerList.containsKey(customer.getID())) return true;
        return false;
    }

    @Override
    public Customer getCustomer(Customer customer) {
        if(null == customer.getID()) return null;
        if(findCustomer(customer)){
            return customerList.get(customer.getID());
        }return null;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        if(null == customer.getID()) return false;
        if(findCustomer(customer)){
            customerList.remove(customer.getID());
            customerList.put(customer.getID(),customer);
            return true;
        }return false;
    }
}
