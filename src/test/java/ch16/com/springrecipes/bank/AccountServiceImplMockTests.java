package ch16.com.springrecipes.bank;

import ch16.com.springrecipes.bank.dao.AccountDao;
import ch16.com.springrecipes.bank.domain.Account;
import ch16.com.springrecipes.bank.service.AccountService;
import ch16.com.springrecipes.bank.service.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class AccountServiceImplMockTests {

    private static final String TEST_ACCOUNT_NO = "1234";

    private AccountDao accountDao;
    private AccountService accountService;

    @Before
    public void init() {
        accountDao = mock(AccountDao.class);
        accountService = new AccountServiceImpl(accountDao);
    }

    @Test
    public void deposit() {
        // 설정
        Account account = new Account(TEST_ACCOUNT_NO, 100);
        when(accountDao.findAccount(TEST_ACCOUNT_NO)).thenReturn(account);

        //실행
        accountService.deposit(TEST_ACCOUNT_NO, 50);

        //확인
        verify(accountDao, times(1)).findAccount(any(String.class));
        verify(accountDao, times(1)).updateAccount(account);
    }

    @Test
    public void withdrawSufficientBalance() {

        //설정
        Account account = new Account(TEST_ACCOUNT_NO, 100);
        when(accountDao.findAccount(TEST_ACCOUNT_NO)).thenReturn(account);

        //실행
        accountService.withdraw(TEST_ACCOUNT_NO, 50);

        //확인
        verify(accountDao, times(1)).findAccount(any(String.class));
        verify(accountDao, times(1)).updateAccount(account);
    }

    @Test(expected = InsufficientBalanceException.class)
    public void testWithdrawWithInsufficientBalance() {
        //설정
        Account account = new Account(TEST_ACCOUNT_NO, 100);
        when(accountDao.findAccount(TEST_ACCOUNT_NO)).thenReturn(account);

        //실행
        accountService.withdraw(TEST_ACCOUNT_NO, 150);

    }
}
