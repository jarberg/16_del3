package matadorspil.model;

import java.util.Deque;
import java.util.ArrayDeque;

public class Playerlist {

    private Deque<Player> playerList;

    public Playerlist(String... playerNames){
        playerList = new ArrayDeque<>();
        createAndAddPlayers(playerNames);
    }

    private void createAndAddPlayers(String... names){
        for(String name : names){
            playerList.addLast(new Player(name));
        }
    }

    public Player getCurrentPlayer(){
        return playerList.getFirst();
    }

    public void changePlayerTurn(){
        Player currentPlayer = getCurrentPlayer();
        boolean playerHasBonusTurn = currentPlayer.hasBonusTurn();

        if(playerHasBonusTurn){
            currentPlayer.setBonusTurn(false);
            return;
        }

        // need to add descriptive names, sorry.
        // this line below takes the first player in the queue and puts him in the back of the queue.
        playerList.addLast(playerList.pollFirst());
    }


}
