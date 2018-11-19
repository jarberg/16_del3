package monopoly.model;

import java.awt.*;

public abstract class Field {

    private Player owner;
    private String title;
    private String subtitle;
    private String description;
    private String message;
    private Color color;
    private Color borderColor;
    private boolean buyable;
    private int value;

    public Field(String title, String subtitle, String description, String message, Color color, int value, Player player){
        this.title = title;
        this.subtitle = subtitle;
        this.message = message;
        this.color = color;
        this.value = value;
        this.description = description;
        this.borderColor = Color.black;
        this.buyable = false;
        this.owner = player;
    }

    public boolean isOwner(Player player){
        return this.owner.equals(player);
    }

}

