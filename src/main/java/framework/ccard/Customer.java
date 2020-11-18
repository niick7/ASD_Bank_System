package framework.ccard;

public interface Customer extends Observer {
    String getFullName();
    String getEmail();
    String getAddress();
    String getID();
    void setAccount(Account account);
}
