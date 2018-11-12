package matadorspil.model;
public class Field {

    private int id;
    private int points;
    private boolean bonusTurn;
    private String name;
    private String owner;

    public Field(){
        this.id = -1;
        this.points = 0;
        this.name = "Empty Field";
    }

    public Field(int id, int points, String name){
        this.id = id;
        this.points = points;
        this.name = name;
    }

    public Field(int id, int points, String name, String owner, boolean bonusTurn){
        this.id = id;
        this.owner = owner;
        this.points = points;
        this.name = name;
        this.bonusTurn = bonusTurn;
    }

    public int getID(){
        return this.id;
    }
    public String getName(){return  this.name; }
    public int getPoints() {
        return this.points;
    }
    public boolean hasBonusTurn(){ return this.bonusTurn; }
    public String getOwner(){return this.owner;};
}

