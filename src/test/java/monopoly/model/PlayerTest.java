package monopoly.model;

import monopoly.model.player.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;
    private static final String name = "Bo";
    private static final int age = 18;

    @Before
    public void setUp(){
        player = new Player(name, age, Color.blue);
    }

    @After
    public void tearDown(){
        player = null;
    }

    @Test
    public void shouldReturnName(){
        assertEquals(name, player.getName());
    }

    @Test
    public void shouldStartWithZeroBalance(){
        assertEquals(0, player.getBalance());
    }

    @Test
    public void shouldAddToBalance(){
        int addAmount = 7;
        int accountBalance = player.getBalance();
        player.addToBalance(addAmount);
        assertEquals(player.getBalance(),accountBalance+addAmount);
    }

    @Test
    public void shouldReturnPlayerColor(){
        assertEquals(player.getColor(),Color.blue);
    }

    @Test
    public void shouldNotBeWinnerWhenCreated(){
        assertFalse(player.isWinner());
    }

    @Test
    public void shouldSetWinnerToTrue(){
        player.setWinner(true);
        assertTrue(player.isWinner());
    }

    @Test
    public void shouldNotHaveOOJCardWhenCreated(){
        assertFalse(player.hasGetOutOfJail());
    }

    @Test
    public void shouldSetHaveOOJCardToTrue(){
        player.setGetOutOfJail(true);
        assertTrue(player.hasGetOutOfJail());
    }

    @Test
    public void shouldBeAtPositionZeroWhenCreated(){
        assertEquals(player.getPosition(),0);
    }

    @Test
    public void shouldSetPosition(){
        int currentPosition = player.getPosition();
        int addPosition = 7;
        player.setPosition(addPosition);
        assertEquals(player.getPosition(),currentPosition+addPosition);
    }

    @Test
    public void shouldNotHaveBalanceLessThanZero() {
        int addAmount = -999;
        player.addToBalance(addAmount);
        assertEquals(player.getBalance(), 0);

    }

    @Test
    public void shouldReturnStringOfVariables(){
        assertEquals(player.toString(),player.getName()+";"+player.getColor()+";"+player.getBalance());
    }

    @Test
    public void shouldNotEqualAnotherPlayerName(){
        String otherPlayerName = "Jens";
        assertFalse(player.equals(otherPlayerName));
    }

    @Test
    public void shouldEqualSamePlayerName(){
        String samePlayerName = name;
        assertTrue(player.equals(samePlayerName));
    }

}