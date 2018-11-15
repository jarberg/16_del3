package matadorspil.model;

public class Card {

    private String name;
    private int effektID;

    Card(){

    }

    Card(String name, int effektID){
        this.name = name;
        this.effektID = effektID;

    }

    public String getName(){ return name; }

    public int getEffektID(){ return effektID; }
}
