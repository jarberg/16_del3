package monopoly.controller;

public class TranslatorController {

    private MonopolyFileReader fileReader;
    private String filePath;

    public TranslatorController(String filePath){
        this.fileReader = new MonopolyFileReader();
        this.filePath = filePath;
    }

    public String getPlayerAmountChoiceMessage(){
        return getMenuStringByKey("PLAYER_AMOUNT");
    }

    public String getPlayerNameMessage() {
        return getMenuStringByKey("ASK_PLAYER_NAME");
    }

    public String getPlayerAgeMessage() {
        return getMenuStringByKey("ASK_PLAYER_AGE");
    }

    private String getMenuStringByKey(String key){
        return fileReader.getMenuMessageBeMessageKey(filePath, key);
    }



}
