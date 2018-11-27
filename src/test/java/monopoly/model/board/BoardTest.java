package monopoly.model.board;

import monopoly.controller.FakeMonopolyFileReader;
import monopoly.controller.MonopolyFileReader;
import monopoly.model.player.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class BoardTest {
private String filePath = "TextFiles/Dansk";

    private Board board;
    private FakeMonopolyFileReader fakeMonoReader;
    MonopolyFileReader fileReader = new MonopolyFileReader();
    Field[] fields;



    @Before
    public void setup(){
        board = new Board();
        board.setupBoard(fileReader.getFieldsText(filePath),fileReader.getFieldDescriptions(filePath) ,fileReader.getFieldMessages(filePath) );
        fields = board.getFields();
        fakeMonoReader = FakeMonopolyFileReader.getInstance();

    }

    @After
    public void tearDown(){
        Board board = null;
        MonopolyFileReader monoReader = null;
        FakeMonopolyFileReader fakeMonoReader = null;
    }



    @Test
    public void getBoard() {
        board.setupBoard(fileReader.getFieldsText(filePath),fileReader.getFieldDescriptions(filePath) ,fileReader.getFieldMessages(filePath));
        assertEquals(24,board.getFields().length);

        assertEquals("START",board.getFields()[0].getTitle());
        assertEquals("MODTAG $2 NÅR DU PASSERER", board.getFields()[0].getDescription());
        assertEquals("modtager sin SU. nasserøv!", board.getFields()[0].getMessage());
        assertEquals("1", board.getFields()[0].getSubtitle());

        assertEquals("SKATER-PARKEN",board.getFields()[10].getTitle());
        assertEquals("HER KOMMER MAN TIL SKADE", board.getFields()[10].getDescription());
        assertEquals("væltede på sit board og slog sin aksel.", board.getFields()[10].getMessage());
        assertEquals("2", board.getFields()[10].getSubtitle());
    }

    @Test
    public void setupBoard(){
/*
        for (int i = 0; i <board.getFields().length ; i++) {
            if(board.getFields()[i]instanceof StartField){
                assertEquals(new StartField(), board.getFields()[i].getClass());
            }
            else if(board.getFields()[i]instanceof ChanceField){
                assertEquals(new ChanceField(), board.getFields()[i].getClass());
            }
            else if(board.getFields()[i]instanceof JailField){
                assertEquals(new JailField(), board.getFields()[i].getClass());
            }
            else if(board.getFields()[i]instanceof ChanceField){
                assertEquals(new GoToJailField(), board.getFields()[i].getClass());
            }
            else if(board.getFields()[i]instanceof ChanceField){
                assertEquals(new ParkingField(), board.getFields()[i].getClass());
            }
            else if(board.getFields()[i]instanceof ChanceField){
                assertEquals(new PropertyField(), board.getFields()[i].getClass());
            }
        }
        */
    }

    @Test
    public void TestCase01(){
        allPropertyFieldsStartWithoutOwner();
        playerBuysField();
    }

    @Test
    public void allPropertyFieldsStartWithoutOwner(){
        Field[] fields = board.getFields();
        for (Field f:fields) {
            if(f instanceof PropertyField){
                assertEquals(null, ((PropertyField) f).getOwner());
                assertNotEquals("", ((PropertyField) f).getOwner());
            }
        }
    }

    @Test
    public void playerBuysField() {

        Player player = new Player("bob", 1, Color.red);
        assertEquals("START", fields[player.getPosition()].getTitle());
        player.setPosition(1);
        assertEquals("BURGER- BAREN", fields[player.getPosition()].getTitle());

        if (fields[player.getPosition()] instanceof PropertyField){
            //fields[player.getPosition()].
            assertEquals(null, ((PropertyField) fields[player.getPosition()]).getOwner());
            ((PropertyField) fields[player.getPosition()]).setOwner(player);

            assertEquals(player, ((PropertyField) fields[player.getPosition()]).getOwner());
        }


    }

}