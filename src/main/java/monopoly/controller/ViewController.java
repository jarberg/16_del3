package monopoly.controller;

import monopoly.controller.field.implementation.PropertyFieldController;
import monopoly.model.board.PropertyField;
import monopoly.model.player.Player;

import monopoly.model.board.Field;
import monopoly.view.MonopolyView;

import java.awt.*;

public class ViewController {

    private TranslatorController translator;
    private MonopolyFileReader fileReader;
    private MonopolyView view;
    private static ViewController singleInstance = null;

    private ViewController(){
        this.fileReader = MonopolyFileReader.getInstance();
        this.view = new MonopolyView();
    }

    public static ViewController getInstance(){
        if(singleInstance == null)
            singleInstance = new ViewController();
        return singleInstance;
    }

    public void showEmptyGUI(){
        view.showEmptyGUI();
    }

    public String getUserLanguage(){
        String[] languageChoices = fileReader.getDirectoriesStringArray();
        return view.getUserLanguage(languageChoices);
    }

    public void setFilepath(String filepath){
        this.translator = new TranslatorController(filepath);
    }

    public int getPlayerAmount(){
        String[] playerOptions = {"2", "3", "4"};
        String message = translator.getPlayerAmountChoiceMessage();
        return view.getPlayerAmount(message, playerOptions);
    }

    public String getPlayerName() {
        String message = translator.getPlayerNameMessage();
        return view.getPlayerName(message);
    }

    public int getPlayerAge() {
        String message = translator.getPlayerAgeMessage();
        return view.getUserAge(message);
    }

    public void showGameGUI(Field[] FieldToGUIField){
        //This should need a dependency to board or field with a method making gui board.
        view.showGameGUI(view.FieldToGUIField(FieldToGUIField));
    }

    public void addPlayer(Player player){
        view.addPlayer(player.getName(), player.getColor());
        view.spawnPlayer(player.getName());
    }

    public void showUserTurnMessage(Player player) {
        view.showMessage(translator.getPlayerTurnMessage() + player.getName());
    }

    public void showDie(int value) {
        view.showDie(value);
    }

    public void movePlayer(Player currentPlayer, int value) {
        String playerName = currentPlayer.getName();
        int playerPosition = currentPlayer.getPosition();
        view.movePlayer(playerName, playerPosition, value);
    }

    public void setGUIPlayerBalance(Player player,int amount){
        view.setPlayerBalance(player, amount);
    }

    public void landedOnFieldMessage(Field currentField) {
        String fieldMessage = currentField.getMessage();
        view.showMessage(fieldMessage);
    }


    public Color getUserColor(String name) {
        String message = translator.getPlayerColorMessage();
        String[] colorChoices = new String[view.getColors().size()];
        String blue = translator.getBlueColorDescription();
        String red = translator.getRedColorDescription();
        String orange = translator.getOrangeColorDescription();
        String green = translator.getGreenColorDescription();

        for (int i = 0; i < view.getColors().size(); i++) {
            String colorMessage = null;
            Color color = view.getColors().get(i);
            if(color == Color.blue)
                colorMessage = blue;
            if(color == Color.red)
                colorMessage = red;
            if(color == Color.orange)
                colorMessage = orange;
            if(color == Color.green)
                colorMessage = green;
            colorChoices[i] = colorMessage;
        }

        String colorString = view.getUserColorString(message, colorChoices, name);
        Color colorChosen = null;
        if(colorString.equals(blue))
            colorChosen = Color.blue;
        if(colorString.equals(red))
            colorChosen = Color.red;
        if(colorString.equals(orange))
            colorChosen = Color.orange;
        if(colorString.equals(green))
            colorChosen = Color.green;
        view.getColors().remove(colorChosen);
        if(colorChosen == null)
            colorChosen = Color.black;
        return colorChosen;
    }

    public int getMaxAge() {
        return view.getMaxAge();
    }

    public void showFieldMessage(String name, String fieldMessage){
        view.showMessage(name + " " + fieldMessage);
    }

    public void boughtFromBankMessage(String name, Field field, int cost) {
        view.showMessage(name + " " + translator.getBoughtFromBankMessage() + " " + field.getTitle() + translator.getPriceMessage() + cost);
    }

    public void boughtFromBankMessage(String name, PropertyField field) {
        view.showMessage(name + " " + translator.getBoughtFromBankMessage() + " " + field.getTitle());
    }

    public void notEnoughMoneyMessage(String name) {
        view.showMessage(name + translator.getNotEnoughMoneyMessage());
    }

    public void soldPropertyMessage(String name, String title, int balance) {
        view.showMessage(name + translator.getSoldPropertyMessage() + " " + title);
        view.showMessage(name + translator.getBalanceMessage() + balance);
    }

    public void paidRentMessage(String name, String ownerName, int cost) {
        view.showMessage(name + translator.getPaidRentMessage() + " " + ownerName + translator.getPriceMessage() + cost);
    }

    public void pairPropertyMessage(String name) {
        view.showMessage(translator.getPairPropertyMessage() + name);
    }

    public void showWinAnimation(String name){
        view.showWinner(name);
    }
}
