package matadorspil.model;

public class Die {

    private int value;

    public Die(){
        random();
    }

    public int getValue(){
        return this.value;
    }

    public void random(){
        this.value = (int)(Math.random()*6+1);
    }

}