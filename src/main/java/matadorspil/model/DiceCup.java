package matadorspil.model;

public class DiceCup {

    private Die die1;
    private Die die2;

    public DiceCup(){
        this.die1 = new Die();
        this.die2 = new Die();
    }

    public void roll(){
        die1.random();
        die2.random();
    }

    public int getSum(){
        int sum = 0;
        sum += die1.getValue();
        sum += die2.getValue();
        return sum;
    }

}
