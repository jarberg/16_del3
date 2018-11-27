package monopoly.model.board;


import monopoly.model.player.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PropertyFieldTest {

    PropertyField field;
    Player player;
    Player owner;
    Field[] board;

    @Before
    public void setup(){
        field= new PropertyField();
        player = new Player("bob", 1, Color.CYAN);
        owner = new Player("dylan", 2,Color.red );
        board = new Board().getFields();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void playerCantPay(){

        player.addToBalance(-100000);
        ((PropertyField) board[23]).setOwner(owner);
        ((PropertyField) board[24]).setOwner(owner);
        ((PropertyField) board[1]).setOwner(player);
        ((PropertyField) board[2]).setOwner(player);
        ((PropertyField) board[4]).setOwner(player);
        ((PropertyField) board[5]).setOwner(player);
        assertEquals(owner,((PropertyField) board[1]).getOwner());
        assertEquals(owner,((PropertyField) board[1]).getOwner());
        assertEquals(player,((PropertyField) board[1]).getOwner());
        assertEquals(player,((PropertyField) board[2]).getOwner());
        assertEquals(player,((PropertyField) board[4]).getOwner());
        assertEquals(player,((PropertyField) board[5]).getOwner());

        ((PropertyField) board[24]).resolveEffect(player);

        assertEquals(null,((PropertyField) board[1]).getOwner());
        assertEquals(null,((PropertyField) board[2]).getOwner());
        assertEquals(null,((PropertyField) board[4]).getOwner());
        assertEquals(null,((PropertyField) board[5]).getOwner());



    }
}