package monopoly.view;

import gui_main.GUI;

import java.awt.*;
import java.util.ArrayList;

public class ColorHandler {

    private GUI gui;
    private ArrayList<Color> colors;

    public ColorHandler(GUI gui, ArrayList<Color> colors){
        this.gui = gui;
        this.colors = colors;
    }

    public Color getUserColor(String message){
        String[] colorChoices = colorsAsStringArray();
        String userColorString = getUserChoice(message, colorChoices);
        Color colorChosen = stringToColor(userColorString);
        removeColorFromChoices(colorChosen);
        return colorChosen;
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

}
