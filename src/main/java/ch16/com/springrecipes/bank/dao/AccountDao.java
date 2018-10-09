package ch16.com.springrecipes.bank.dao;

import ch16.com.springrecipes.bank.domain.Account;

public interface AccountDao {
    public void createAccount(Account account);
    public void updateAccount(Account account);
    public void removeAccount(Account account);
    public Account findAccount(String accountNo);
}
