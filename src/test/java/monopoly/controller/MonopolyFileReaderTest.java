package monopoly.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MonopolyFileReaderTest {

    private MonopolyFileReader monoReader;
    private FakeMonopolyFileReader fakeMonoReader;

    @Before
    public void setUp() throws Exception {
         monoReader = MonopolyFileReader.getInstance();
         fakeMonoReader = FakeMonopolyFileReader.getInstance();
    }

    @After
    public void tearDown() throws Exception {
         monoReader = null;
    }

    @Test
    public void stubGetFieldsText() {

        assertEquals("TextFiles/Dansk/Fields.txt/works", fakeMonoReader.getFieldsText("TextFiles/Dansk") );
        assertNotEquals(null, fakeMonoReader.getFieldsText("TextFiles/Dansk") );
    }

    @Test
    public void stubGetChanceCardText() {
        assertEquals("TextFiles/Dansk/ChanceCards.txt/works", fakeMonoReader.getChanceCards("TextFiles/Dansk") );
        assertNotEquals(null, fakeMonoReader.getChanceCards("TextFiles/Dansk") );

    }

    @Test
    public void stubGetFieldMessageText() {

        assertEquals("TextFiles/Dansk/FieldMessages.txt/works", fakeMonoReader.getFieldMessages("TextFiles/Dansk") );
        assertNotEquals(null, fakeMonoReader.getFieldMessages("TextFiles/Dansk") );

    }

    @Test
    public void stubGetMenuText() {

        assertEquals("TextFiles/Dansk/Menu.txt/works", fakeMonoReader.getMenuText("TextFiles/Dansk") );
        assertNotEquals(null, fakeMonoReader.getMenuText("TextFiles/Dansk") );

        assertEquals("TextFiles//", fakeMonoReader.getDirectoriesStringArray() );
        assertNotEquals(null, fakeMonoReader.getDirectoriesStringArray() );
    }

    @Test
    public void stubgetDirectoriesStringArray() {
        assertEquals("TextFiles//", fakeMonoReader.getDirectoriesStringArray() );
        assertNotEquals(null, fakeMonoReader.getDirectoriesStringArray() );
    }

    @Test
    public void stubgetFieldDescriptions() {
        assertEquals("TextFiles/Dansk/FieldDescriptions.txt/works", fakeMonoReader.getFieldDescriptions("TextFiles/Dansk") );
        assertNotEquals(null, fakeMonoReader.getFieldDescriptions("TextFiles/Dansk") );
    }

    @Test
    public void getFieldsText() {
        assertEquals("START", monoReader.getFieldsText("TextFiles/Dansk")[0][0] );
        assertNotEquals(null, monoReader.getFieldsText("TextFiles/Dansk")[0][0] );
        assertEquals("STRAND- PROMENADEN", monoReader.getFieldsText("TextFiles/Dansk")[monoReader.getFieldsText("TextFiles/Dansk").length-1][0] );
        assertNotEquals(null, monoReader.getFieldsText("TextFiles/Dansk")[monoReader.getFieldsText("TextFiles/Dansk").length-1][0]);

        //normal
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