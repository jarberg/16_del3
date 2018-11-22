package monopoly.controller;

import monopoly.view.MonopolyView;

import java.io.FileReader;

public class ViewController {

    private MonopolyFileReader fileReader;
    private MonopolyView view;
    private String filepath;

    public ViewController(){
        this.fileReader = new MonopolyFileReader();
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
    }

}
