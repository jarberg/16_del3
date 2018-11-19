package monopoly.model.board;

import monopoly.model.Player;

import java.awt.*;

public class PropertyField extends Field {

    private int value;
    private Player owner;

    public PropertyField(String title, String subtitle, String description, String message, Color color, Player owner, int value){
        super(title, subtitle, description, message, color);
        this.owner = owner;
        this.value = value;
    }

    @Override
    public void resolveEffect(Player player){
        if(this.owner == null){
            player.addToBalance(-value);
            this.owner = player;
        }
        else if(this.owner != player){
            int playerBalance = player.getBalance();
            if(playerBalance < value){
                player.addToBalance(-playerBalance);
                this.owner.addToBalance(playerBalance);
            }
            else{
                player.addToBalance(-value);
                owner.addToBalance(value);
            }
        }
    }

    public Player getOwner(){
        return this.owner;
    }

    public boolean isOwner(Player player){
        return this.owner.equals(player);
    }

}
