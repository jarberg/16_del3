package monopoly.model.player;

public class Playerlist {

    private int playerAmount = 2;

    public Playerlist(int playerAmount){
        this.playerAmount=playerAmount;
    }

    Playerlist[] playerList = new Playerlist[playerAmount];

    public Playerlist[] getPlayerList(){
        return playerList;
    }

}
