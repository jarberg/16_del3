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
        die.roll();
        int returnValue = die.getValue();
        assertTrue(returnValue <= 6 && returnValue >=1);
    }

    @Test
    public void shouldAlwaysHaveValue(){
        int returnValueOnCreation = die.getValue();
        assertTrue(returnValueOnCreation <= 6 && returnValueOnCreation >=1);
    }

    @Test
    public void shouldBeRandomOver60000Rolls(){
        int[] results = new int[6];
        int testAmount = 60000;
        int minAcceptable = testAmount / 6 - testAmount / 60;
        int maxAcceptable = testAmount / 6 + testAmount / 60;

        for (int i = 0; i < testAmount; i++) {
            die.roll();
            int resultIndex = die.getValue() - 1;
            results[resultIndex]++;
        }

        for (int result : results) {
            boolean resultIsReasonable = (result >= minAcceptable && result <= maxAcceptable);
            assertTrue(resultIsReasonable);
        }

    }

    @Test
    public void shouldWorkWithMultipleDice(){
        Die die2 = new Die();

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            die.roll();
            die2.roll();
            sum += die.getValue();
            sum += die2.getValue();
        }
        assertTrue(sum <= 60 && sum >= 10);
    }


}