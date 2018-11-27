package monopoly.model.deck.effects;

import monopoly.model.player.Player;
import monopoly.model.player.PlayerList;

public class MoneyEffekt extends CardEffect {

    private Player player;
    private PlayerList players;


    public void getMoneyFromOtherAllPlayers(Player player, PlayerList playerList){


        for (Player f : playerList.getPlayerDeque()) {
            if(player.getName().contains(player.getName())){

            }
            else{
                f.addToBalance(-1);
                player.addToBalance(1);
            }
        }
    }

    public void payMoneytoBank(Player player,int amount){
        player.addToBalance(amount);
    }

    public void gainMoneyFromBank(Player player,int amount){
        player.addToBalance(amount);
    }

    @Override
    public void resolveEffect(int ID) {
        switch(ID){
            case 1: payMoneytoBank(player,-2);
                break;
            case 2: gainMoneyFromBank(player,2);
                break;
            case 3: getMoneyFromOtherAllPlayers(player,players);
                break;
        }

    }
}
