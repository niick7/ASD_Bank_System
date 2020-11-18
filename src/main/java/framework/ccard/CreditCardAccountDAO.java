package framework.ccard;

import java.util.HashMap;

public class CreditCardAccountDAO implements AccountDAO {
    private HashMap<String,Account> bankingAccountMap;
    private Account account;

    public CreditCardAccountDAO() {
        bankingAccountMap = new HashMap<>();
    }

    public boolean findAccount(String ID){
        if(null == ID) return false;
        if(bankingAccountMap.containsKey(ID)) return true;
        return false;
    }
    public void addAccount(String ID, Account account){
        if(null != ID)
        if(!findAccount(ID)){
            bankingAccountMap.put(ID,account);
        }
    }

    public Account getAccount(String ID){
        if(null == ID) return null;
        if(findAccount(ID)){
            return bankingAccountMap.get(ID);
        }return null;
    }
    public boolean updateAccount(Account account){
        if(null == account) return false;
        if(findAccount(account.getAccountID())){
            bankingAccountMap.remove(account.getAccountID());
            bankingAccountMap.put(account.getAccountID(),account);
            return true;
        }return false;
    }


}
