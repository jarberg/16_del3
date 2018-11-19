package monopoly.model;

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

    public void setDescription(String description){
        this.description = description;
    }

    public void setEffectID(int effectID){
       this.effectID = effectID;
    }

}
