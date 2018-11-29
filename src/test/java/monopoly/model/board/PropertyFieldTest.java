package monopoly.model.board;


import monopoly.controller.*;

import monopoly.model.Visitor;
import monopoly.model.player.Player;
import monopoly.model.player.PlayerList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PropertyFieldTest {

    private Player player;
    private Player player2;
    private Player owner;

    PlayerList players = new PlayerList();
    private Field[] board;
    GameController gamcon = GameController.getInstance();
    ViewController viewController =FakeViewController.getInstance();


    @Before
    public void setup(){

        player = new Player("bob", 1, Color.CYAN);
        player2 = new Player("bobby", 1, Color.CYAN);
        owner = new Player("dylan", 2,Color.red );
        players.addPlayer(player);
        players.addPlayer(player2);
        players.addPlayer(owner);

        gamcon.createGameBoard();
        board = gamcon.getFields();

    }

    @After
    public void tearDown(){

    }

    @Test
    public void playerCantPay(){

        player.addToBalance(-100000);
        assertFalse(player.isLoser());

        ((PropertyField) board[22]).setOwner(owner);
        ((PropertyField) board[23]).setOwner(owner);
        ((PropertyField) board[1]).setOwner(player);
        ((PropertyField) board[2]).setOwner(player);
        ((PropertyField) board[4]).setOwner(player);
        ((PropertyField) board[5]).setOwner(player);
        assertEquals(owner,((PropertyField) board[22]).getOwner());
        assertEquals(owner,((PropertyField) board[23]).getOwner());
        assertEquals(player,((PropertyField) board[1]).getOwner());
        assertEquals(player,((PropertyField) board[2]).getOwner());
        assertEquals(player,((PropertyField) board[4]).getOwner());
        assertEquals(player,((PropertyField) board[5]).getOwner());


        Visitor visitor = new FakeFieldVisitor(player);
        board[23].accept(visitor);


        assertNull(((PropertyField) board[1]).getOwner());
        assertNull(((PropertyField) board[2]).getOwner());
        assertNull(((PropertyField) board[4]).getOwner());
        assertNull(((PropertyField) board[5]).getOwner());

        player.setLoser(true);
        assertTrue(player.isLoser());
        System.out.println(player.getName() + " isLoser = " + player.isLoser());

    }
}