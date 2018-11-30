package monopoly.model;

import monopoly.model.player.Account;

public class FakeAccount extends Account {

    private int balance = 0;

    @Override
    public int getBalance(){
        return 5;
    }

    @Override
    public void addToBalance(int amount){
        this.balance += 0;
    }


}
