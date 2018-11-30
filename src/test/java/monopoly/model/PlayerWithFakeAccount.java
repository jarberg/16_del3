package monopoly.model;

import monopoly.model.player.Account;
import monopoly.model.player.Player;

public class PlayerWithFakeAccount extends Player {

    private Account account;

    PlayerWithFakeAccount(String name, int age){
        super(name, age);
        this.account = new FakeAccount();
    }

    @Override
    public int getBalance(){
        return this.account.getBalance();
    }

    @Override
    public void addToBalance(int amount){
        this.account.addToBalance(amount);
    }

}
