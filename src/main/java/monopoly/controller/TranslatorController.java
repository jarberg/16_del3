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

    private String getMenuStringByKey(String key){
        return fileReader.getMenuMessage(filePath, key);
    }
}
