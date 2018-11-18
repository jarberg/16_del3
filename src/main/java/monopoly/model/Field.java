package monopoly.model;

import java.awt.*;

public class Field {
    private String ownerName;
    private String title;
    private String subtitle;
    private String description;
    private String message;
    private Color color;
    private Color borderColor;
    private boolean buyable;
    private int value;


    public Field(String title, String subtitle, String description, String message, Color color, int value){
        this.title = title;
        this.subtitle = subtitle;
        this.message = message;
        this.color = color;
        this.value = value;
        this.description = description;
        this.borderColor = Color.black;
        this.buyable = false;
        this.ownerName = "Bank";
        }

    public boolean isOwner(String name){
            return this.ownerName.equals(name);
    }


}

