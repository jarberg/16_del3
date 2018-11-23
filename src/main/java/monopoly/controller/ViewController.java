package monopoly.controller;

import gui_fields.GUI_Player;
import monopoly.model.player.Player;

import monopoly.model.board.Field;
import monopoly.view.MonopolyView;
import monopoly.model.board.Board;

public class ViewController {

    private MonopolyFileReader fileReader;
    private MonopolyView view;
    private String filepath;
    private TranslatorController translator;
    private Board board;
    private static ViewController singleInstance = null;

    private ViewController(){
        this.fileReader = new MonopolyFileReader();
        this.view = new MonopolyView();
    }

    public static ViewController getInstance(){
        if(singleInstance == null)
            singleInstance = new ViewController();
        return singleInstance;
    }

    public String getUserLanguage(){
        String[] languageChoices = fileReader.getDirectoriesStringArray();
        return view.getUserLanguage(languageChoices);
    }

    public void showEmptyGUI(){
        view.showEmptyGUI();
    }

    public void setFilepath(String filepath){
        this.filepath = filepath;
        this.translator = new TranslatorController(filepath);
    }

    public int getPlayerAmount(){
        String[] playerOptions = {"2", "3", "4"};
        String message = translator.getPlayerAmountChoiceMessage();
        return view.getPlayerAmount(message, playerOptions);
    }
    public void showGameGUI(Field[] FieldToGUIField){
        //This should need a dependency to board or field with a method making gui board.
        view.showGameGUI(view.FieldToGUIField(FieldToGUIField));
    }

    public String getPlayerName() {
        String message = translator.getPlayerNameMessage();
        return view.getPlayerName(message);
    }

    public int getPlayerAge() {
        String message = translator.getPlayerAgeMessage();
        return view.getUserAge(message);
    }

    public void addPlayer(Player player){
        view.addPlayer(player.getName(), player.getColor());
        view.spawnPlayer(player.getName());
    }

    public void showDie(int value) {
        view.showDie(value);
    }

    public void movePlayer(Player currentPlayer, int value) {
        String playerName = currentPlayer.getName();
        int playerPosition = currentPlayer.getPosition();
        view.movePlayer(playerName, playerPosition, value);
    }

    public void landedOnFieldMessage(Field currentField) {
        String fieldMessage = currentField.getMessage();
        view.showMessage(fieldMessage);
    }
    public void setGUIPlayerBalance(Player player,int amount){
        view.setPlayerBalance(player, amount);
    }
}
