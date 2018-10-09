package ch16.com.springrecipes.bank.dao;

import ch16.com.springrecipes.bank.domain.Account;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcAccountDao extends JdbcDaoSupport implements AccountDao {

    @Override
    public void createAccount(Account account) {
        String sql = "INSERT INTO ACCOUNT (ACCOUNT_NO, BALANCE) VALUES (?, ?)";
        getJdbcTemplate().update(
                sql, account.getAccountNo(), account.getBalance());
    }

    public void updateAccount(Account account) {
        String sql = "UPDATE ACCOUNT SET BALANCE = ? WHERE ACCOUNT_NO = ?";
        getJdbcTemplate().update(
                sql, account.getBalance(), account.getAccountNo());
    }

    public void removeAccount(Account account) {
        String sql = "DELETE FROM ACCOUNT WHERE ACCOUNT_NO = ?";
        getJdbcTemplate().update(sql, account.getAccountNo());
    }

    public Account findAccount(String accountNo) {
        String sql = "SELECT BALANCE FROM ACCOUNT WHERE ACCOUNT_NO = ?";
        double balance = getJdbcTemplate().queryForObject(
                sql, Double.class, accountNo);
        return new Account(accountNo, balance);
    }
}
