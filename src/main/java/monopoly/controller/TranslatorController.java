package monopoly.controller;

public class TranslatorController {

    private MonopolyFileReader fileReader;
    private String filePath;

    public TranslatorController(String filePath){
        this.fileReader = MonopolyFileReader.getInstance();
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

    public String getPlayerTurnMessage(){
        return getMenuStringByKey("PLAYER_TURN");
    }

    public String getPlayerColorMessage() {
        return getMenuStringByKey("COLOR_CHOICE");
    }

    public String getBlueColorDescription() {
        return getMenuStringByKey("BLUE_COLOR");
    }

    public String getRedColorDescription() {
        return getMenuStringByKey("RED_COLOR");
    }

    public String getGreenColorDescription() {
        return getMenuStringByKey("GREEN_COLOR");
    }

    public String getOrangeColorDescription(){
        return getMenuStringByKey("ORANGE_COLOR");
    }

    public String getBoughtFromBankMessage() {
        return getMenuStringByKey("BOUGHT_FROM_BANK");
    }

    public String getPriceMessage(){
        return getMenuStringByKey("PRICE_MESSAGE");
    }

    public String getNotEnoughMoneyMessage() {
        return getMenuStringByKey("NOT_ENOUGH_MONEY");
    }

    public String getSoldPropertyMessage() {
        return getMenuStringByKey("SOLD_PROPERTY");
    }

    public String getBalanceMessage() {
        return getMenuStringByKey("GET_BALANCE");
    }

    public String getPaidRentMessage() {
        return getMenuStringByKey("PAID_RENT");
    }

    public String getPairPropertyMessage() {
        return getMenuStringByKey("PAIR_PROPERTY");
    }

    public String landedOnFieldMessage() {
        return getMenuStringByKey("LANDED_ON_FIELD");
    }

    private String getMenuStringByKey(String key){
        return fileReader.getMenuMessageBeMessageKey(filePath, key);
    }



}
