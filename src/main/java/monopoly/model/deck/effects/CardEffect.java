package monopoly.model.deck.effects;

import monopoly.model.player.Player;
import monopoly.model.player.PlayerList;

public abstract class CardEffect {

    private Player player;
    private PlayerList players;

    public abstract void resolveEffect(int ID);


    public void setPlayer(Player player){this.player = player;}

    public void setPlayers(PlayerList players){this.players = players;}

}



