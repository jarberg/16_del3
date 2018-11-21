package monopoly.model.player;

import java.util.ArrayDeque;
import java.util.Deque;

public class Playerlist {

    private Deque<Player> playerList;

    public Playerlist(Player... players){
        playerList = new ArrayDeque<>();
        addPlayers(players);
    }

    private void addPlayers(Player... players){
        for(Player player : players){
            playerList.addLast(player);
        }
    }

    public Player getNextPlayer(){
        return playerList.getFirst();
    }

    public void changePlayerTurn(){
        playerList.addLast(playerList.pollFirst());
    }

    //Sort by age method?

}
