package monopoly.controller;

import monopoly.model.Die;
import monopoly.model.board.Board;
import monopoly.model.board.Field;
import monopoly.model.player.Player;
import monopoly.model.player.Playerlist;

import java.awt.*;

public class GameController {

    private ViewController viewController;
    private MonopolyFileReader fileReader;
    private Playerlist players;
    private Board board;
    private Die die;
    private int playerAmount = 0;
    private String languageFilepath;
    private static final String defaultLanguage = "English";
    private static GameController singleInstance = null;

    private GameController(){
        viewController = ViewController.getInstance();
        fileReader = MonopolyFileReader.getInstance();
        setFilepathLanguage(defaultLanguage);
    }

    public static GameController getInstance(){
        if(singleInstance == null)
            singleInstance = new GameController();

        return singleInstance;
    }

    public void setupGame(){
        this.die = new Die();
        setupLanguage();
        createGameBoard();
        playerAmount = getPlayerAmount();
        createPlayers();
        showGameBoard();
        addPlayersToGUI();
    }

    private void setupLanguage(){
        viewController.showEmptyGUI();
        String userLanguage = viewController.getUserLanguage();
        setFilepathLanguage(userLanguage);
    }

    private void setFilepathLanguage(String language){
        languageFilepath = "TextFiles/" + language;
        viewController.setFilepath(languageFilepath);
    }

    private void createGameBoard(){
        this.board = new Board();
        String[][] fieldTexts = fileReader.getFieldsText(languageFilepath);
        String[] fieldDescriptions = fileReader.getFieldDescriptions(languageFilepath);
        String[] fieldMessages = fileReader.getFieldMessages(languageFilepath);
        this.board.setupBoard(fieldTexts, fieldDescriptions, fieldMessages);
    }

    private int getPlayerAmount(){
        if(playerAmount == 0){
            playerAmount = viewController.getPlayerAmount();
        }
        return playerAmount;
    }

    private void createPlayers(){
        Playerlist players = new Playerlist();
        for (int i = 0; i < getPlayerAmount(); i++) {
            String name = viewController.getPlayerName();
            int age = viewController.getPlayerAge();
            Color color = Color.red;
            players.addPlayer(new Player(name, age, color));
        }
        this.players = players;
    }

    private void showGameBoard(){
        viewController.showGameGUI(board.getFields());
    }

    private void addPlayersToGUI(){
        int startAmount = 0;
        if(playerAmount == 2)
            startAmount = 20;
        if(playerAmount == 3)
            startAmount = 18;
        if(playerAmount == 4)
            startAmount = 16;

        for(Player player : players.getPlayerDeque()){
            player.addToBalance(startAmount);
            viewController.addPlayer(player);
            viewController.setGUIPlayerBalance(player, player.getBalance());
        }
    }

    public void playGame(){
        while(players.noWinnerYet()){
            playTurn();
        }
    }

    private void playTurn() {
        Player currentPlayer = players.getNextPlayer();

        viewController.showUserTurnMessage(currentPlayer);
        die.roll();
        int value = die.getValue();
        viewController.showDie(value);

        viewController.movePlayer(currentPlayer, value);
        currentPlayer.movePosition(value, board.getFields().length);
        int position = currentPlayer.getPosition();

        Field currentField = board.getFields()[position];
        currentField.resolveEffect(currentPlayer);

        viewController.landedOnFieldMessage(currentField);

        players.changePlayerTurn();
    }

    public Field[] getFields(){
        return board.getFields();
    }

    public void endGame() {
        //Not implemented yet, feel free!
    }
}
