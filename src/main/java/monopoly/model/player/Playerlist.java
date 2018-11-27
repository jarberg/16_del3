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
            if(player.isLoser())
                noWinnerYet = false;
        }
        return noWinnerYet;
    }

    public boolean hasPlayerWithName(String name) {
        for(Player player : playerList){
            if (player.getName().equals(name))
                return true;
        }
        return false;
    }

    public Player getYoungest(){
        Player player = getNextPlayer();
        for(Player p : playerList){
            if(p.getAge() < player.getAge())
                player = p;
        }
        return player;
    }

    public void makeYoungestPlayerFirst(){
        ArrayDeque<Player> tempArrayDeque = new ArrayDeque<>();

        for(int l=playerList.size();l>0;l--){
            Player youngestTestedPlayer = playerList.getFirst();
            for(int i=playerList.size();i>0;i--){
                if(playerList.getFirst().getAge() < youngestTestedPlayer.getAge()){
                    youngestTestedPlayer = playerList.getFirst();
                }
                playerList.addLast(playerList.getFirst());
                playerList.removeFirst();
            }
            for(int j=playerList.size();j>0;j--){
                if(playerList.getFirst()!=youngestTestedPlayer){
                    playerList.addLast(playerList.getFirst());
                    playerList.removeFirst();
                }

            }
            tempArrayDeque.addLast(playerList.getFirst());
            playerList.removeFirst();
        }
        playerList = tempArrayDeque;

    }



}
