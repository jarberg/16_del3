package monopoly.view;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.util.ArrayList;

public class MonopolyView {

    private GUI gui;
    private GUI_Field[] guiBoard;
    private String[] playerAmounts;
    private ArrayList<Color> colors;
    private ArrayList<GUI_Player> guiPlayers;
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 120;

    public MonopolyView(){
        //Consider de-hardcoding language choices and player numbers.
        this.playerAmounts = new String[]{"2", "3", "4"};
        this.colors = new ArrayList<>();
        this.guiPlayers = new ArrayList<>();
        //Consider de-hardcoding colors.
        this.colors.add(Color.BLUE);
        this.colors.add(Color.ORANGE);
        this.colors.add(Color.WHITE);
        this.colors.add(Color.BLACK);
    }

    public void showEmptyGUI(){
        GUI_Field[] emptyFieldArray = new GUI_Field[0];
        this.gui = new GUI(emptyFieldArray);
    }

    public void showGameGUI(GUI_Field[] board){
        //This should need a dependency to board or field with a method making gui board.
        this.gui.close();
        this.gui = new GUI(board, Color.green);
    }

    public void addPlayer(String name, Color color){
        //The uniqueness of names should be controlled in controller (player object names also need uniqueness)
        GUI_Player player = new GUI_Player(name);
        player.getCar().setPrimaryColor(color);
        this.guiPlayers.add(player);
        this.gui.addPlayer(player);
    }

    public void spawnPlayer(String name){
        GUI_Player player = getGUIplayerByName(name);
        showPlayer(player,0);
    }

    public void movePlayer(String name, int position, int movement) throws InterruptedException {
        GUI_Player player = getGUIplayerByName(name);
        for (int i = 0; i < movement ; i++) {
            removePlayer(player, position);
            position++;
            position = position % guiBoard.length;
            showPlayer(player, position);
            Thread.sleep(150);
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

    public Color getUserColor(String message){
        ColorHandler colorHandler = new ColorHandler(gui, colors);
        return colorHandler.getUserColor(message);
    }

    public int getPlayerAmount(String message){
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


}
