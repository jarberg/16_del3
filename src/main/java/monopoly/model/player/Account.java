package monopoly.model.player;

public class Account {

    private int balance;

    public Account(){
        this.balance = 90;
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