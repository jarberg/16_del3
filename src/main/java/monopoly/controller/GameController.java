package monopoly.controller;

import monopoly.model.board.Board;
import monopoly.model.player.Player;
import monopoly.model.player.Playerlist;
import monopoly.view.MonopolyView;

import java.awt.*;

public class GameController {

    private ViewController viewController;
    private MonopolyFileReader fileReader;
    private Board board ;
    private String languageFilepath;
    private static final String defaultLanguage = "English";
    private int playerAmount = 0;
    private Playerlist players;

    public GameController(){
        viewController = new ViewController();
        setFilepathLanguage(defaultLanguage);
    }

    public void setupGame(){
        setupLanguage();
        createGameBoard();
        playerAmount = getPlayerAmount();
        createAndAddPlayers();
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




    private void createAndAddPlayers(){
        Playerlist players = new Playerlist();
        for (int i = 0; i < getPlayerAmount(); i++) {
            String name = viewController.getPlayerName();
            int age = viewController.getPlayerAge();
            Color color = Color.red;
            players.addPlayer(new Player(name, age, color));
        }
        this.players = players;

        for(Player player : players.getPlayerDeque()){
            viewController.addPlayer(player);
        }
    }

    private int getPlayerAmount(){
        if(playerAmount == 0){
            playerAmount = viewController.getPlayerAmount();
        }
        return playerAmount;
    }

    private void showGameBoard(){

    }


    private void setFilepathLanguage(String language){
        languageFilepath = "TextFiles/" + language;
        viewController.setFilepath(languageFilepath);
    }


}
