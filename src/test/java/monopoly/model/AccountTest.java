package monopoly.model;

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
    public void shouldReturnBalance(){
        assertTrue(account.getBalance()==0);

    }

    @Test
    public void shouldAddToBalance(){
        int accountBalance = account.getBalance();
        int addAmount = 7;
        account.addToBalance(addAmount);
        assertTrue(account.getBalance()==accountBalance+addAmount);

    }


}