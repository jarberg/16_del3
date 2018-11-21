package monopoly.model;

public class Die {

private int value;

    //consider making dynamic with sides int or result array

    public Die(){
        roll();
    }

    public void roll(){
        this.value = 1 + (int)(Math.random() * 6);
    }
    public int getValue(){
        return value;
    }
}