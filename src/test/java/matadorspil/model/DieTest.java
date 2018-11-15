package matadorspil.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DieTest {

    private Die die;

    @Before
    public void setUp(){
        die = new Die();
    }

    @After
    public void tearDown(){
        die = null;
    }

    @Test
    public void shouldReturnBetweenOneAndSix() {
        int returnValue = die.getValue();
        assertTrue(returnValue <= 6 && returnValue >=1);
    }

    @Test
    public void shouldAlwaysHaveValue(){

    }


}