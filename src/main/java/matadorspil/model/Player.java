package matadorspil.model;

import java.awt.*;

public class Player {
private String name;
private Color color;
private Account account;
private int position;
private boolean isWinner;
private boolean hasGetOutOfJail;

    public Player(String name, Color color){
        this.name = name;
        this.color = color;
        this.account = new Account();
    }

    public boolean equals(String otherPlayer) {
        return (this.name==otherPlayer);
    }

    @Override
    public String toString() {
        return(name+";"+color+";"+account.getBalance());
    }

}
