package monopoly.model.board;

import monopoly.model.player.Player;

import java.awt.*;

public class PropertyField extends Field {

    private int value;
    private Player owner;
    private int pairIndex;

    public PropertyField(String title, String subtitle, String description, String message, Color color, Player owner, int value, int pairIndex){
        super(title, subtitle, description, message, color);
        this.owner = owner;
        this.value = value;
        this.pairIndex = pairIndex;
    }

    @Override
    public void resolveEffect(Player player){

    }
    public void setOwner(Player player){this.owner = player;}
    public Player getOwner(){
        return this.owner;
    }
    public int getPairIndex(){return pairIndex;}
    public int getValue(){return value;}



}
