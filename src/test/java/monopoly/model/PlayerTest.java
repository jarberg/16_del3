package monopoly.model;

import monopoly.model.player.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp(){
        player = new Player("bo", Color.blue);
    }

    @After
    public void tearDown(){
        player = null;
    }

    @Test
    public void shouldReturnName(){
        assertEquals("bo",player.getName());
    }

    @Test
    public void shouldReturnZeroBalance(){
        assertEquals(player.getBalance(),0);
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
        String samePlayerName = "bo";
        assertTrue(player.equals(samePlayerName));
    }

}