package monopoly.model.board;


import monopoly.controller.GameController;
import monopoly.controller.MonopolyFileReader;
import monopoly.model.player.Player;
import monopoly.model.player.PlayerList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class PropertyFieldTest {

    private PropertyField field;
    private Player player;
    private Player owner;
    private Player player2 = new Player("kewl",3,Color.green);
    PlayerList players = new PlayerList();
    private Board boardArray = new Board();
    private Field[] board;
    MonopolyFileReader monoReader = MonopolyFileReader.getInstance();
    String filePath="TextFiles/Dansk";
    GameController gamcon = GameController.getInstance();

    @Before
    public void setup(){
        players.addPlayer(player);
        players.addPlayer(owner);
        players.addPlayer(player2);
        gamcon.createGameBoard();
        gamcon.setPlayers(players);
        field= new PropertyField();
        player = new Player("bob", 1, Color.CYAN);
        owner = new Player("dylan", 2,Color.red );
        boardArray.setupBoard(monoReader.getFieldsText(filePath),monoReader.getFieldDescriptions(filePath) ,monoReader.getFieldMessages(filePath) );
        board = boardArray.getFields();

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

        ((PropertyField) board[23]).resolveEffect(player);

        assertNull(((PropertyField) board[1]).getOwner());
        assertNull(((PropertyField) board[2]).getOwner());
        assertNull(((PropertyField) board[4]).getOwner());
        assertNull(((PropertyField) board[5]).getOwner());

        assertTrue(player.isLoser());





    }
}