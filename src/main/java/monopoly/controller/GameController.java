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

        playerAmount = getPlayerAmount();
        //createAndAddPlayers();
        createGameBoard();
        //showGameBoard();
    }

    private void setupLanguage(){
        viewController.showEmptyGUI();
        String userLanguage = viewController.getUserLanguage();
        setFilepathLanguage(userLanguage);
    }


    private void createGameBoard(){
        board.setupBoard(fileReader.getFieldsText(languageFilepath), fileReader.getFieldDescriptions(languageFilepath), fileReader.getFieldMessages(languageFilepath));
        this.board.setupBoard(fileReader.getFieldsText(languageFilepath),fileReader.getFieldDescriptions(languageFilepath),fileReader.getFieldMessages(languageFilepath));
        viewController.showGameGUI(board.getBoard());
    }



    private int getPlayerAmount(){
        if(playerAmount == 0){
            playerAmount = viewController.getPlayerAmount();
        }
        return playerAmount;
    }


    /*
    private void createAndAddPlayers(){

    }
     */

    private void setFilepathLanguage(String language){
        languageFilepath = "TextFiles/" + language;
        viewController.setFilepath(languageFilepath);
    }


}
