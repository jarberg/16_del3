package monopoly.model.player;

import monopoly.model.board.Field;
import monopoly.model.board.PropertyField;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private Color color;
    private Account account;
    private int age;
    private int position;
    private boolean isLoser;
    private boolean isWinner;
    private boolean hasGetOutOfJail;
    private static final int START_POSITION = 0;
    private static final Color DEFAULT_COLOR = Color.black;
    private boolean payToLeaveJail =false;
    private List<Field> ownedFields =  new ArrayList<>();


    public Player(String name, int age){
        this.name = name;
        this.age = age;
        this.color = DEFAULT_COLOR;
        this.account = new Account();
        this.position = START_POSITION;
    }

    public Player(String name, int age, Color color){
        this.name = name;
        this.age = age;
        this.color = color;
        this.account = new Account();
        this.position = START_POSITION;
    }

    public boolean equals(String otherPlayerName) {
        return this.name.equals(otherPlayerName);
    }

    @Override
    public String toString() {
        return name+";"+color+";"+account.getBalance();
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void addToBalance(int amount){
        account.addToBalance(amount);
    }

    public int getPosition(){
        return position;
    }

    public void setPosition(int position){
        this.position = position;
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
    public boolean isLoser(){
        return this.isLoser;
    }

    public void setLoser(boolean isLoser){
        this.isLoser=isLoser;
    }

    public boolean hasGetOutOfJail(){
        return this.hasGetOutOfJail ;
    }

    public void setGetOutOfJail(boolean hasCard){
        this.hasGetOutOfJail=hasCard;
    }

    public void movePosition(int number, int boardSize){
        this.position = position + number;
        this.position = position % boardSize;
    }
    public boolean getPayToLeaveJail(){
        return this.payToLeaveJail;
    }
    public void setPayToLeaveJail(boolean payToLeaveJail1){ this.payToLeaveJail = payToLeaveJail1;}

    public void sellField(Field index, PropertyField field){
        this.addToBalance(field.getValue());
        this.ownedFields.remove(index);
        field.setOwner(null);
    }

    public List<Field> getOwnedFields(){
      return ownedFields;

       /* Field[] allFields = board;
        List<PropertyField> ownedFields = new ArrayList<>();
        for(Field f : allFields){
            if(f instanceof PropertyField && ((PropertyField) f).getOwner() == this)
                ownedFields.add((PropertyField)f);
        }
        return ownedFields.toArray(new PropertyField[0]);
    */
    }

    public void setOwnedFields(Field index){ownedFields.add(index);}
}

