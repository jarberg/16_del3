package monopoly.model.deck;

import monopoly.model.player.Player;

public class MoneyEffekt extends CardEffect {

    public void getMoneyFromOtherAllPlayers(Player player, Player[] playerList){

        for (int i = 0; i <playerList.length ; i++) {
            if(playerList[i].getName().contains(player.getName())){

            }
            else{
                playerList[i].addToBalance(-2);
                player.addToBalance(2);
            }
        }
    }

    public void getLoseMoneyFromBank(Player player,int amount){
        player.addToBalance(amount);
    }
}
