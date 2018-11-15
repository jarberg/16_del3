package matadorspil;

import matadorspil.model.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class playerTest {
    Player player = new Player("bob");
    @Before
    public void setup(){

    }

    @After
    public void tearDown(){
        Player player = null;
    }
    @Test
    public void changeBalance(){
        //positiv test
        player.addToBalance(1000);
        assertEquals(2000,player.getBalance());
        player.addToBalance(-3000);
        assertEquals(0,player.getBalance());
    }

    @Test
    void addBalance() {
        //positiv test
        assertEquals(1000,player.getBalance());
        //negativ test
        assertNotEquals(0,player.getBalance());
    }
}