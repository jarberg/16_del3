package monopoly.controller;

import monopoly.controller.field.FieldController;
import monopoly.controller.field.implementation.PropertyFieldController;
import monopoly.model.Die;
import monopoly.model.board.Board;
import monopoly.model.board.Field;
import monopoly.model.board.PropertyField;
import monopoly.model.player.Player;
import monopoly.model.player.Playerlist;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

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
        makePlayersChooseColor();
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
            int playerIdentifier = 2;
            //Name insurance here because GUI doesn't allow two players with the same name.
            String playerName = name;
            while(players.hasPlayerWithName(playerName)){
                playerName = name + "#" + playerIdentifier;
                playerIdentifier++;
            }
            players.addPlayer(new Player(playerName, age));
        }
        this.players = players;
    }

    private void makePlayersChooseColor() {
        for(int j = 0; j < players.getPlayerDeque().size(); j++){
            Player playerChoosingColor = players.getNextPlayer();
            for(Player player : players.getPlayerDeque()){
                if(playerChoosingColor.getColor() != Color.black)
                    playerChoosingColor = player;
                if(player.getAge() < playerChoosingColor.getAge() && player.getColor() == Color.black){
                    playerChoosingColor = player;
                }
            }
            playerChoosingColor.setColor(viewController.getUserColor(playerChoosingColor.getName()));
            players.changePlayerTurn();
        }
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
        //endGame(players.getWinner());
    }

    private void playTurn() {
        Player currentPlayer = players.getNextPlayer();

        //viewController.showUserTurnMessage(currentPlayer);
        die.roll();
        int value = die.getValue();
        viewController.showDie(value);

        viewController.movePlayer(currentPlayer, value);
        currentPlayer.movePosition(value, board.getFields().length);
        int position = currentPlayer.getPosition();

        Field currentField = board.getFields()[position];
        currentField.resolveEffect(currentPlayer);

        //viewController.landedOnFieldMessage(currentField);

        players.changePlayerTurn();
    }

    public Field[] getFields(){
        return board.getFields();
    }

    public void endGame(Player loser) {
        Deque<Player> playersInGame = players.getPlayerDeque();
        playersInGame.remove(loser);
        ArrayList<Player> winnerCandidates = new ArrayList<>();
        int maxPoints = 0;
        for(Player player : playersInGame){
            if(maxPoints < player.getBalance())
                maxPoints = player.getBalance();
        }
        for(Player player : playersInGame){
            if(player.getBalance() == maxPoints)
                winnerCandidates.add(player);
        }
        for(Player player : winnerCandidates){
            PropertyFieldController fc = new PropertyFieldController();
            for(PropertyField field : fc.getFieldsOwnedByPlayer(player)){
                fc.sellField(player, field);
            }
        }
        Player winner = null;
        int winningPoints = 0;
        for(Player player : winnerCandidates){
            if(winningPoints < player.getBalance()){
                winningPoints = player.getBalance();
                winner = player;
            }
        }
        viewController.showWinAnimation(winner.getName());
    }
}
