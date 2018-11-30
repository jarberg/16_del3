package monopoly.model;

import monopoly.model.player.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    private Account account;

    @Before
    public void setUp(){
        account = new Account();
    }

    @After
    public void tearDown(){
        account = null;
    }

    @Test
    public void ShouldHaveZeroBalanceWhenCreated(){
        assertEquals(0,account.getBalance());
    }

    @Test
    public void shouldAddToBalance(){
        int accountBalance = account.getBalance();
        int addAmount = 7;
        account.addToBalance(addAmount);
        assertEquals(accountBalance + addAmount, account.getBalance());
    }

    @Test
    public void shouldSubtractFromBalance(){
        account.addToBalance(100);
        int accountBalance = account.getBalance();
        int subtractAmount = -72;
        account.addToBalance(subtractAmount);
        assertEquals(accountBalance + subtractAmount, account.getBalance());
    }

    @Test
    public void shouldNotHaveBalanceLessThanZero(){
        int addAmount = -999;
        account.addToBalance(addAmount);
        assertEquals(account.getBalance(),0);

    }


}