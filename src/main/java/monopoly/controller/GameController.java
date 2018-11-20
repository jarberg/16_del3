package monopoly.controller;

import monopoly.model.board.Board;
import monopoly.view.MonopolyView;

public class GameController {

    private MonopolyView view;
    private Board board;
    private String filepath = "TextFiles/";

    public GameController(){
        view = new MonopolyView();
    }

    public void setupGame(){
        view.showEmptyGUI();
        String language = view.getUserLanguage();
        setFilepathLanguage(language);

    }

    private void setFilepathLanguage(String language){
        filepath = filepath + language;
    }

    public void playGame(){

    }


}
