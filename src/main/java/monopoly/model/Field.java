package monopoly.model;

import java.awt.*;

public class Field {

    private String owner;
    private int value;
    private String title;
    private String subtitle;
    private String description;
    private Color color;
    private Color borderColor;
    private boolean buyable;
    private String message;

    public Field(String title, String subtitle, String description, String message, Color color, int value){
        this.title = title;
        this.subtitle = subtitle;
        this.message = message;
        this.color = color;
        this.value = value;
        this.description = description;
        this.borderColor = Color.black;
        this.buyable = false;
        this.owner = "none";

        }

        public boolean isOwner(String name){
            return(this.owner==name);
    }

}

