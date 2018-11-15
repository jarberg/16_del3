package monopoly.model;

public class ChanceCard {

    private String name;
    private int effectID;

    ChanceCard(){
    }

    ChanceCard(String name, int effektID){
        this.name = name;
        this.effectID = effektID;
    }

    public String getName(){
        return this.name;
    }

    public int getEffectID(){
        return this.effectID;
    }
}
