package monopoly.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonopolyFileReaderTest {

    private MonopolyFileReader monoReader;
    @Before
    public void setUp() throws Exception {
         monoReader = MonopolyFileReader.getInstance();
    }

    @After
    public void tearDown() throws Exception {
         monoReader = null;
    }

    @Test
    public void getFieldsText() {
        assertEquals("START", monoReader.getFieldsText("TextFiles/Dansk")[0][0] );
        assertNotEquals(null, monoReader.getFieldsText("TextFiles/Dansk")[0][0] );
        assertEquals("STRAND- PROMENADEN", monoReader.getFieldsText("TextFiles/Dansk")[monoReader.getFieldsText("TextFiles/Dansk").length-1][0] );
        assertNotEquals(null, monoReader.getFieldsText("TextFiles/Dansk")[monoReader.getFieldsText("TextFiles/Dansk").length-1][0]);
    }

    @Test
    public void getDirectoriesStringArray() {
        assertEquals("Dansk", monoReader.getDirectoriesStringArray()[0]);
        assertEquals("English", monoReader.getDirectoriesStringArray()[1]);
        assertNotEquals(null, monoReader.getDirectoriesStringArray()[0]);
        assertNotEquals(null, monoReader.getDirectoriesStringArray()[1]);
    }

}