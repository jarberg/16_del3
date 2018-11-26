package monopoly.view;

import gui_fields.GUI_Car;
import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_fields.GUI_Street;
import gui_main.GUI;
import monopoly.model.board.Field;
import monopoly.model.player.Player;

import java.awt.*;
import java.util.ArrayList;

public class MonopolyView {

    private GUI gui;
    private GUI_Field[] guiBoard;
    private ArrayList<Color> colors;
    private ArrayList<GUI_Player> guiPlayers;
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 120;

    public MonopolyView(){
        //Consider de-hardcoding language choices and player numbers.
        this.colors = new ArrayList<>();
        this.guiPlayers = new ArrayList<>();
        //Consider de-hardcoding colors.
        this.colors.add(Color.CYAN);
        this.colors.add(Color.ORANGE);
        this.colors.add(Color.RED);
        this.colors.add(Color.GREEN);
    }

    public void showEmptyGUI(){
        GUI_Field[] emptyFieldArray = new GUI_Field[0];
        this.gui = new GUI(emptyFieldArray);
    }

    public GUI_Street[] FieldToGUIField(Field[] field){
        GUI_Street[] gui_field = new GUI_Street[field.length];

        for (int i = 0; i < field.length; i++) {
            String fieldTitel= field[i].getTitle();
            Color fieldColor= field[i].getColor();
            String fieldDescrip = field[i].getDescription();
            String fieldmess = field[i].getMessage();
            String fieldSub = field[i].getSubtitle();

            gui_field[i] = new GUI_Street();
            gui_field[i].setTitle(fieldTitel);
            gui_field[i].setSubText(fieldSub);
            gui_field[i].setDescription(fieldDescrip);
            gui_field[i].setForeGroundColor(Color.BLACK);
            gui_field[i].setBackGroundColor(fieldColor);
        }
        
        return gui_field;
    }
    
    public void showGameGUI(GUI_Street[] board){
        //This should need a dependency to board or field with a method making gui board.
        this.guiBoard = board;
        this.gui.close();
        this.gui = new GUI(guiBoard, Color.green);
    }

    public void close(){
        this.gui.close();
    }

    public void addPlayer(String name, Color color){
        //The uniqueness of names should be controlled in controller (player object names also need uniqueness)
        GUI_Car playerCar = new GUI_Car();
        if(color == Color.cyan)
            playerCar = new GUI_Car(color, color, GUI_Car.Type.UFO, GUI_Car.Pattern.FILL);
        if(color == Color.orange)
            playerCar = new GUI_Car(color, color, GUI_Car.Type.TRACTOR, GUI_Car.Pattern.FILL);
        if(color == Color.red)
            playerCar = new GUI_Car(color, color, GUI_Car.Type.RACECAR, GUI_Car.Pattern.FILL);
        if(color == Color.green)
            playerCar = new GUI_Car(color, color, GUI_Car.Type.CAR, GUI_Car.Pattern.FILL);

        GUI_Player player = new GUI_Player(name, 0, playerCar);
        player.getCar().setPrimaryColor(color);
        this.guiPlayers.add(player);
        this.gui.addPlayer(player);
    }

    public void spawnPlayer(String name){
        GUI_Player player = getGUIplayerByName(name);
        showPlayer(player,0);
    }

    public void movePlayer(String name, int position, int movement){
        GUI_Player player = getGUIplayerByName(name);

        for (int i = 0; i < movement ; i++) {
            removePlayer(player, position);
            position++;
            position = position % guiBoard.length;
            showPlayer(player, position);

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private GUI_Player getGUIplayerByName(String name){
        GUI_Player player = null;
        for(GUI_Player guiPlayer : this.guiPlayers){
            if(guiPlayer.getName().equals(name))
                player = guiPlayer;
        }
        return player;
    }

    private void showPlayer(GUI_Player player, int position){
        GUI_Field targetField = this.gui.getFields()[position];
        targetField.setCar(player,true);
    }

    private void removePlayer(GUI_Player player, int position){
        GUI_Field targetField = this.gui.getFields()[position];
        targetField.setCar(player,false);
    }

    public int getPlayerAmount(String message, String[] playerAmounts){
        String playerAmountString = getUserChoice(message, playerAmounts);
        return Integer.parseInt(playerAmountString);
    }

    public String getUserLanguage(String[] languages){
        //Consider implementing default english language from controller and not hardcoding msg here.
        return getUserChoice("Choose a language", languages);
    }

    private String getUserChoice(String message, String... options){
        return gui.getUserSelection(message, options);
    }

    public ArrayList<Color> getColors(){
        return this.colors;
    }

    public String getUserColorString(String message, String[] options, String name) {
        return getUserChoice(message + " " + name, options);
    }

    public String getPlayerName(String message){
        //Add logic in Controller to make sure name doesn't match any other name + allow for 4x same name.
        return gui.getUserString(message);
    }

    public int getUserAge(String message){
        return gui.getUserInteger(message, MIN_AGE, MAX_AGE);
    }

    public void showWinner(String name){
        GUI_Player player = getGUIplayerByName(name);
        new WinAnimation(gui, player);
    }

    public void showDie(int value) {
        gui.setDie(value);
    }

    public void showMessage(String message) {
        gui.showMessage(message);
    }
    public void setPlayerBalance(Player player, int amount){
        getGUIplayerByName(player.getName()).setBalance(amount);
    }

    public int getMaxAge(){
        return MAX_AGE;
    }

    public void setFieldColor(Color color, int field){

        this.guiBoard[field].setBackGroundColor(color.darker());
        this.guiBoard[field].setForeGroundColor(color.brighter());
    }

}
