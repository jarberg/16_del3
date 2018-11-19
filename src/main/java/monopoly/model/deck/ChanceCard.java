package monopoly.model.deck;

public class ChanceCard {
    private String description ="";
    private int effectID = 0;


    public ChanceCard() {

    }

    public ChanceCard(String description, int effectID){
        this.description=description;
        this.effectID = effectID;
    }

    public String getDescription(){
        return this.description;
    }

    public int getEffectID(){
        return this.effectID;
    }

}
