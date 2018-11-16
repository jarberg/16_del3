package monopoly.view;

import gui_fields.GUI_Field;
import gui_main.GUI;

import java.awt.*;
import java.util.ArrayList;

public class MonopolyView {

    private GUI gui;
    private String[] languages;
    private String[] playerAmounts;
    private ArrayList<Color> colors;

    public MonopolyView(){
        this.languages = new String[]{"Danish", "English"};
        this.playerAmounts = new String[]{"2", "3", "4"};
        this.colors = new ArrayList<>();
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
        String[] colorChoices = colorsAsStringArray();
        String userColorString = getUserChoice(message, colorChoices);
        Color colorChosen = stringToColor(userColorString);
        removeColorFromChoices(colorChosen);
        return colorChosen;
    }

    public int getUserAge(String message){
        int userAgeInput = this.gui.getUserInteger(message, 0,120);
        return userAgeInput;
    }

    private String[] colorsAsStringArray(){
        String[] colorsAsStringArray = new String[this.colors.size()];
        for (int i = 0; i <colorsAsStringArray.length ; i++) {
            String colorString;
            switch(this.colors.get(i).toString()){
                case "java.awt.Color[r=0,g=0,b=255]":
                    colorString = "blue";
                    break;
                case "java.awt.Color[r=255,g=200,b=0]":
                    colorString = "orange";
                    break;
                case "java.awt.Color[r=255,g=255,b=255]":
                    colorString = "white";
                    break;
                case "java.awt.Color[r=0,g=0,b=0]":
                    colorString = "black";
                    break;
                default:
                    colorString = "gray";
            }
            colorsAsStringArray[i]= colorString;
        }
        return colorsAsStringArray;
    }

    private Color stringToColor(String colorString){
        switch(colorString.toLowerCase()){
            case "blue":
                return Color.BLUE;
            case "orange":
                return Color.ORANGE;
            case "white":
                return Color.WHITE;
            case "black":
                return Color.BLACK;
            default:
                return Color.GRAY;
        }
    }

    private void removeColorFromChoices(Color color){
        for(Color colorInList : this.colors){
            if(colorInList.toString().equals(color.toString())){
                this.colors.remove(colorInList);
                break;
            }
        }
    }

    private String getUserChoice(String message, String... options){
        String userChoice = this.gui.getUserSelection(message, options);
        return userChoice;
    }





}
