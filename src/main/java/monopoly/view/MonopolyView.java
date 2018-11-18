package monopoly.view;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;
import java.util.ArrayList;

public class MonopolyView {

    private GUI gui;
    private String[] languages;
    private String[] playerAmounts;
    private ArrayList<Color> colors;
    private ArrayList<GUI_Player> guiPlayers;


    public MonopolyView(){
        //Consider de-hardcoding language choices and player numbers.
        this.languages = new String[]{"Danish", "English"};
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
        GUI emptyGUI = new GUI(emptyFieldArray);
        this.gui = emptyGUI;
    }

    public void showGameGUI(GUI_Field[] board){
        this.gui.close();
        this.gui = new GUI(board,Color.green);
    }

    public void addPlayer(String name, Color color){
        //The uniqueness of names should be controlled in controller (player object names also need uniqueness)
        GUI_Player player = new GUI_Player(name);
        player.getCar().setPrimaryColor(color);
        this.guiPlayers.add(player);
        this.gui.addPlayer(player);
    }


    private GUI_Player getGUIplayerByName(String name){
        GUI_Player player = null;
        for(GUI_Player guiPlayer : this.guiPlayers){
            if(guiPlayer.getName().equals(name))
                player = guiPlayer;
        }
        return player;
    }

    public void showPlayer(String name, int position){
        GUI_Player player = getGUIplayerByName(name);
        GUI_Field targetField = this.gui.getFields()[position];
        targetField.setCar(player,true);
    }

    public String getUserLanguage(){
        //Consider implementing default english language from controller and not hardcoding msg here.
        String languageChoice = getUserChoice("Choose a language", languages);
        return languageChoice;
    }

    public int getPlayerAmount(String message){
        String playerAmountString = getUserChoice(message, playerAmounts);
        int playerAmount = Integer.parseInt(playerAmountString);
        return playerAmount;
    }

    public String getPlayerName(String message){
        String name = this.gui.getUserString(message);
        //Add logic in Controller to make sure name doesn't match any other name + allow for 4x same name.
        return name;
    }

    public Color getUserColor(String message){
        ColorHandler colorHandler = new ColorHandler(gui, colors);
        return colorHandler.getUserColor(message);
    }



    public int getUserAge(String message){
        int userAgeInput = this.gui.getUserInteger(message, 0,120);
        return userAgeInput;
    }

    public String getUserChoice(String message, String... options){
        String userChoice = this.gui.getUserSelection(message, options);
        return userChoice;
    }





}
