package monopoly.model.board;

import monopoly.controller.FakeMonopolyFileReader;
import monopoly.controller.MonopolyFileReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
private String filePath = "TextFiles/Dansk";

    private Board board;
    private MonopolyFileReader monoReader;
    private FakeMonopolyFileReader fakeMonoReader;



    @Before
    public void setup(){
        board = new Board();
        monoReader = MonopolyFileReader.getInstance();
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
        board.setupBoard(monoReader.getFieldsText(filePath), monoReader.getFieldDescriptions(filePath), monoReader.getFieldMessages(filePath));
        assertEquals(24,board.getFields().length);

        assertEquals("START",board.getFields()[0].getTitle());
        assertEquals("MODTAG $2 N�R DU PASSERER", board.getFields()[0].getDescription());
        assertEquals("Hey! Du landede p� \"START\"- Du modtager SU! Din nasser�v", board.getFields()[0].getMessage());
        assertEquals("1", board.getFields()[0].getSubtitle());

        assertEquals("SKATER-PARKEN",board.getFields()[10].getTitle());
        assertEquals("HER KOMMER MAN TIL SKADE", board.getFields()[10].getDescription());
        assertEquals("Du landede p� \"SKATERPARKEN\" - �h nej! Du faldt og slog din ankel.", board.getFields()[10].getMessage());
        assertEquals("2", board.getFields()[10].getSubtitle());
    }
    @Test
    public void setupBoard(){

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
    }
}