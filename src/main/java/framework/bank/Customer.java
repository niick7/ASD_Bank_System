package framework.bank;

public interface Customer extends Observer {
    String getFullName();
    String  getAge();
    String getEmail();
    Address getAddress();
    String getID();
    void  setAccount(Account account);

}
