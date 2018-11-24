package monopoly.model.player;

public class Account {

    private int balance;
    private static final int START_AMOUNT = 0;

    public Account(){
        this.balance = START_AMOUNT;
    }

    public int getBalance(){
        return this.balance;
    }

    public void addToBalance(int amount){
        balance += amount;

        if(balance < 0)
            balance = 0;
    }


}