package matadorspil.model;

public class Account {

    private int balance;
    private int initialAmount = 1000;

    public Account(){
        this.balance = initialAmount;
    }

    public int getBalance(){
        return balance;
    }

    public void changeBalance(int amount){
        balance = balance + amount;

        if(balance<0)
            balance = 0;
    }

}
