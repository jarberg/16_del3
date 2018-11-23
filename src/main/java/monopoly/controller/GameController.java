package monopoly.controller;

import monopoly.model.Die;
import monopoly.model.board.Board;
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
        this.board.setupBoard(fileReader.getFieldsText(languageFilepath),fileReader.getFieldDescriptions(languageFilepath),fileReader.getFieldMessages(languageFilepath));
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
        for(Player player : players.getPlayerDeque()){
            viewController.addPlayer(player);
        }
    }

    public void playGame(){
        while(players.noWinnerYet()){
            playTurn();
        }
    }

    private void playTurn() {
        Player currentPlayer = players.getNextPlayer();
        //view.makeUserPressButtonHueHue();
        die.roll();
        int value = die.getValue();
        viewController.showDie(value);

        viewController.movePlayer(currentPlayer, value);
        currentPlayer.movePosition(value, board.getFields().length);
        int position = currentPlayer.getPosition();

        Field currentField = board.getFields()[position];
        getFieldType(currentField, currentPlayer);
        mainCon.resolveEffect(currentPlayer);
        viewController.setGUIPlayerBalance(currentPlayer, currentPlayer.getBalance());
        //currentField.resolveEffect(currentPlayer);
        viewController.landedOnFieldMessage(currentField);

        players.changePlayerTurn();
    }

    public Field[] getFields(){
        return board.getFields();
    }

    private void getFieldType(Field field, Player player){

        if (field instanceof PropertyField){
            this.mainCon = new PropertyFieldController(board, player);
        }
        if (field instanceof StartField){
            this.mainCon = new StartFieldController();
        }
        if (field instanceof JailField){
            this.mainCon = new JailFieldController();
        }
        if (field instanceof GoToJailField){
            this.mainCon = new GoToJailFieldController();
        }
        if (field instanceof ParkingField){
            this.mainCon = new ParkingFieldController();
        }
        if (field instanceof ChanceField){
            this.mainCon = new ChanceFieldController();
        }
    }

    public void endGame() {

    }
}
