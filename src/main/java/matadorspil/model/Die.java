package matadorspil.model;

public class Die {

private int value;

    private void roll(){
        value = 1 + (int)(Math.random() * 6);
    }
    public int getValue(){
        return value;
    }
}