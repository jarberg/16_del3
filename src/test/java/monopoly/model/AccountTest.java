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
    public void shouldHaveZeroBalanceWhenCreated(){
        assertEquals(0,account.getBalance());
    }

    @Test
    public void shouldAddToBalance(){
        int balance = account.getBalance();
        int amount = 7;
        account.addToBalance(amount);
        assertEquals(balance + amount, account.getBalance());
    }

    @Test
    public void shouldSubtractFromBalance(){
        account.addToBalance(20);
        int balance = account.getBalance();
        int amount = -9;
        account.addToBalance(amount);
        assertEquals(balance + amount, account.getBalance());
    }

    @Test
    public void shouldNotHaveBalanceLessThanZero(){
        int addAmount = -999;
        account.addToBalance(addAmount);
        assertEquals(account.getBalance(),0);

    }


}