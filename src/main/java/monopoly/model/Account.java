package monopoly.model;

public class Account {

private int balance;

    public Account(){
        balance=0;
    }

    public int getBalance(){
        return(balance);
    }

    public void addToBalance(int amount){
        balance=balance+amount;
    }


}
