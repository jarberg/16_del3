package monopoly.model.deck.effects;

import monopoly.model.player.Player;
import monopoly.model.player.Playerlist;

public abstract class CardEffect {

    private Player player;
    private Playerlist players;

    public abstract void resolveEffect(int ID);


    public void setPlayer(Player player){this.player = player;}

    public void setPlayers(Playerlist players){this.players = players;}

}



