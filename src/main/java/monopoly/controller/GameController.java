package monopoly.controller;

import monopoly.model.board.Board;
import monopoly.view.MonopolyView;

public class GameController {

    private ViewController viewController;
    private MonopolyFileReader fileReader;
    private Board board ;
    private String languageFilepath;
    private static final String defaultLanguage = "English";
    private int playerAmount = 0;

    public GameController(){
        viewController = new ViewController();
        setFilepathLanguage(defaultLanguage);
    }

    public void setupGame(){
        setupLanguage();
        //createGameBoard();
        //playerAmount = getPlayerAmount();
        //createAndAddPlayers();
        //showGameBoard();
    }

    private void setupLanguage(){
        viewController.showEmptyGUI();
        String userLanguage = viewController.getUserLanguage();
        setFilepathLanguage(userLanguage);
    }

    /*
    private void createGameBoard(){


    }
    */

    /*
    private int getPlayerAmount(){
        if(playerAmount == 0){
            playerAmount = viewController.getPlayerAmount();
        }
        return playerAmount;
        //int playerAmount = viewController.getPlayerAmount();
    }
    */

    /*
    private void createAndAddPlayers(){

    }
     */

    private void setFilepathLanguage(String language){
        languageFilepath = "TextFiles/" + language;
        viewController.setFilepath(languageFilepath);
    }


}
