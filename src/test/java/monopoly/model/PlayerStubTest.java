package monopoly.model;

import monopoly.model.player.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerStubTest {

    private PlayerWithFakeAccount player;

    @Before
    public void setUp(){
        player = new PlayerWithFakeAccount("John", 18);
    }

    @After
    public void tearDown(){
        player = null;
    }

    @Test
    public void shouldGetFakeValue(){
        assertEquals(5,player.getBalance());
    }

    @Test
    public void shouldNotChangeBalance(){
        player.addToBalance(100);
        assertEquals(5,player.getBalance());
    }

    @Test
    public void shouldNotMove(){
        int position = player.getPosition();
        player.movePosition(0,24);
        assertEquals(position, player.getPosition());
    }

    @Test
    public void shouldRemainWithingBoard(){
        int position = player.getPosition();
        int boardsize = 24;
        player.movePosition(boardsize+1, boardsize);
        assertEquals(position + 1, player.getPosition());
    }



}
