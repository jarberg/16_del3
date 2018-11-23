package monopoly.model.player;

import java.util.ArrayDeque;
import java.util.Deque;

public class Playerlist {

    private Deque<Player> playerList;

    public Playerlist(){
        playerList = new ArrayDeque<>();
    }

    public Playerlist(Player... players){
        playerList = new ArrayDeque<>();
        addPlayers(players);
    }

    public void addPlayer(Player player){
        playerList.add(player);
    }

    private void addPlayers(Player... players){
        for(Player player : players){
            playerList.addLast(player);
        }
    }

    public Deque<Player> getPlayerDeque(){
        return playerList;
    }

    public Player getNextPlayer(){
        return playerList.getFirst();
    }

    public void changePlayerTurn(){
        playerList.addLast(playerList.pollFirst());
    }

    public boolean noWinnerYet() {
        boolean noWinnerYet = true;
        for(Player player : playerList){
            if(player.isWinner())
                noWinnerYet = false;
        }
        return noWinnerYet;
    }

    //Sort by age method?

}
