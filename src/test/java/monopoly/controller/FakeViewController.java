package monopoly.controller;

import monopoly.model.board.Field;
import monopoly.model.board.PropertyField;
import monopoly.model.player.Player;
import monopoly.view.MonopolyView;

import java.awt.*;

public class FakeViewController extends ViewController{

    private TranslatorController translator;
    private MonopolyFileReader fileReader;
    private MonopolyView view;
    private static FakeViewController singletonInstance = null;

    private FakeViewController() {
        super();
    }


    public static FakeViewController getInstance(){
        if(singletonInstance == null)
            singletonInstance = new FakeViewController();
        return singletonInstance;
    }
    @Override
    public void showEmptyGUI(){
        view.showEmptyGUI();
    }

    @Override
    public String getUserLanguage(){
    return "/Dansk";
    }

    @Override
    public void setFilepath(String filepath){
        this.translator = new TranslatorController(filepath);
    }

    @Override
    public int getPlayerAmount(){
        String[] playerOptions = {"2", "3", "4"};
        String message = translator.getPlayerAmountChoiceMessage();
        return view.getPlayerAmount(message, playerOptions);
    }

    @Override
    public String getPlayerName() {

        return "bb";
    }

    @Override
    public int getPlayerAge() {
        String message = translator.getPlayerAgeMessage();
        return view.getUserAge(message);

    }

    @Override
    public void showGameGUI(Field[] fieldsToGUIFields){

    }

    @Override
    public void addPlayer(Player player){

    }

    @Override
    public void showUserTurnMessage(Player player) {

    }

    @Override
    public void showDie(int value) {

    }

    @Override
    public void movePlayer(Player currentPlayer, int value) {

    }

    @Override
    public void setGUIPlayerBalance(Player player,int amount){

    }

    @Override
    public void landedOnFieldMessage(Field currentField) {
    }

    @Override
    public Color getUserColor(String name) {

        return Color.green;
    }
    @Override
    public int getMaxAge() {
        return view.getMaxAge();
    }
    @Override
    public void showFieldMessage(String name, String fieldMessage){

    }
    @Override
    public void boughtFromBankMessage(String name, Field field, int cost) {

    }
    @Override
    public void boughtFromBankMessage(String name, PropertyField field) {

    }
    @Override
    public void notEnoughMoneyMessage(String name)  {

    }
    @Override
    public void soldPropertyMessage(String name, String title, int balance) {

    }
    @Override
    public void paidRentMessage(String name, String ownerName, int cost) {

    }
    @Override
    public void pairPropertyMessage(String name) {

    }
    @Override
    public void showWinAnimation(String name){

    }
    @Override
    public void setFieldColor(Color color, int fieldIndex){}
}
