package monopoly.model.board;

import monopoly.model.player.Player;

import java.awt.*;

public abstract class Field {

    private String title;
    private String subtitle;
    private String description;
    private String message;
    private Color color;
    private Color borderColor;

    public Field(String title, String subtitle, String description, String message, Color color){
        this.title = title;
        this.subtitle = subtitle;
        this.message = message;
        this.color = color;
        this.description = description;
        this.borderColor = Color.black;
    }

    public abstract void resolveEffect(Player player);

    public String getTitle(){return title;};
    public String getSubtitle(){return subtitle;};
    public String getDescription(){return description;};
    public String getMessage(){return message;};

}

