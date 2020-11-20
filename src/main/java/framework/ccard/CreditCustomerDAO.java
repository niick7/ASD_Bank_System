package framework.ccard;

import framework.Common.Customer;

import java.util.HashMap;

public class CreditCustomerDAO implements framework.Common.CustomerDAO {
    private HashMap<String, Customer> customerList;

    public CreditCustomerDAO() {
        customerList=new HashMap<>();
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
        return customerList.containsKey(customer.getID());
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
