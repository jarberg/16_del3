package monopoly.model;

import java.awt.*;

public class Player {

    private String name;
    private Color color;
    private Account account;
    private int position;
    private boolean isWinner;
    private boolean hasGetOutOfJail;
    private static int startPosition = 0;

    public Player(String name, Color color){
        this.name = name;
        this.color = color;
        this.account = new Account();
        this.position = startPosition;
    }

    public boolean equals(String otherPlayer) {
        return this.name.equals(otherPlayer);
    }

    @Override
    public String toString() {
        return name+";"+color+";"+account.getBalance();
    }

    public String getName(){
        return this.name;
    }

    public void addToBalance(int amount){
        account.addToBalance(amount);
    }

    public int getPosition(){
        return position;
    }

    public void setPosition(int position){
        this.position=position;
    }

    public Color getColor(){
        return this.color;
    }

    public int getBalance(){
        return account.getBalance();
    }

    public boolean isWinner(){
        return this.isWinner;
    }

    public void setWinner(boolean isWinner){
        this.isWinner=isWinner;
    }

    public boolean hasGetOutOfJail(){
        return this.hasGetOutOfJail ;
    }

    public void setGetOutOfJail(boolean hasCard){
        this.hasGetOutOfJail=hasCard;
    }
}

