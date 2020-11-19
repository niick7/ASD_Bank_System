package framework.bank;

import java.util.HashMap;

public class BankingAccountDAO implements AccountDAO {
    private HashMap<String, Account> bankingAccountMap;
    private Account account;

    public BankingAccountDAO() {
        bankingAccountMap = new HashMap<>();
    }

    public boolean findAccount(String accountNumber){
        if(null == accountNumber) return false;
        if(bankingAccountMap.containsKey(accountNumber)) return true;
        return false;
    }
    public void addAccount(String accountNumber, Account account){
        if(!findAccount(accountNumber)){
            bankingAccountMap.put(accountNumber,account);
        }
    }

    public Account getAccount(String accountNumber){
        if(null == accountNumber) return null;
        if(findAccount(accountNumber)){
            return bankingAccountMap.get(accountNumber);
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
