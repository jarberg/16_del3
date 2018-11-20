package monopoly.controller;

import monopoly.model.board.Board;
import monopoly.view.MonopolyView;

public class GameController {

    private MonopolyView view;
    private MonopolyFileReader fileReader;
    private Board board ;
    private String filepath = "TextFiles/";
    private static final String defaultLanguage = "English";

    public GameController(){
        setFilepathLanguage(defaultLanguage);
        view = new MonopolyView();

    }

    public void setupGame(){
        setupLanguage();
    }

    private void setupLanguage(){
        view.showEmptyGUI();
        String[] languageChoices = fileReader.getDirectoriesStringArray();
        String userLanguage = view.getUserLanguage(languageChoices);
        setFilepathLanguage(userLanguage);
    }

    private void setFilepathLanguage(String language){
        filepath = "TextFiles/" + language;
    }


}
