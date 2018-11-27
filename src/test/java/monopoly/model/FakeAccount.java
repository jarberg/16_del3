package monopoly.model;

import monopoly.model.player.Account;

public class FakeAccount extends Account {

    @Override
    public int getBalance(){
        return 5;
    }

    @Override
    public void addToBalance(int amount){
    }

}
