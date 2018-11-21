package monopoly.model.board;

import monopoly.controller.MonopolyFileReader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
private String filePath = "TextFiles/Dansk";

    private Board board;
    private MonopolyFileReader monoReader;


    @Before
    public void setup(){
        board = new Board();
        monoReader = new MonopolyFileReader();
    }

    @After
    public void tearDown(){
        Board board = null;
        MonopolyFileReader monoReader = null;
    }


    @Test
    public void getBoard() {
        board.setupBoard(monoReader.getFieldsText(filePath), monoReader.getFieldDescriptions(filePath), monoReader.getFieldMessages(filePath));
        assertEquals(24,board.getFields().length);

        assertEquals("START",board.getFields()[0].getTitle());
        assertEquals("MODTAG $2 NÅR DU PASSERER", board.getFields()[0].getDescription());
        assertEquals("modtager sin SU. nasserøv!", board.getFields()[0].getMessage());
        assertEquals("1", board.getFields()[0].getSubtitle());

        assertEquals("SKATERPARKEN",board.getFields()[10].getTitle());
        assertEquals("HER KOMMER MAN TIL SKADE", board.getFields()[10].getDescription());
        assertEquals("væltede p? sit board og slog sin aksel.", board.getFields()[10].getMessage());
        assertEquals("2", board.getFields()[10].getSubtitle());
    }
}