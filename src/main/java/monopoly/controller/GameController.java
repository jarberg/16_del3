package monopoly.controller;

import monopoly.model.Die;
import monopoly.model.board.Board;
import monopoly.model.board.Field;
import monopoly.model.board.PropertyField;
import monopoly.model.player.Player;
import monopoly.model.player.PlayerList;

import java.awt.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GameController {

    private ViewController viewController;
    private MonopolyFileReader fileReader;
    private PlayerList players;
    private Board board;
    private Die die;
    private int playerAmount = 0;
    private String languageFilepath;
    private static final String defaultLanguage = "English";
    private static GameController singletonInstance = null;

    private GameController(){
        viewController = ViewController.getInstance();
        fileReader = MonopolyFileReader.getInstance();
        setFilepathLanguage(defaultLanguage);
    }

    public static GameController getInstance(){
        if(singletonInstance == null)
            singletonInstance = new GameController();

        return singletonInstance;
    }

    public void setupGame(){
        this.die = new Die();
        setupLanguage();
        createGameBoard();
        playerAmount = getPlayerAmount();
        createPlayers();
        makePlayersChooseColor();
        //ChanceFieldController.getInstance().setFilePath(languageFilepath);
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

    public void createGameBoard(){
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
        PlayerList players = new PlayerList();
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
        players.makeYoungestPlayerFirst();
        viewController.showFieldMessage(players.getYoungest().getName(), " starter");
        while(players.noWinnerYet()){
            playTurn();
        }
        endGame();
    }

    private void playTurn() {
        Player currentPlayer = players.getNextPlayer();

        //viewController.showUserTurnMessage(currentPlayer);

        payBeforeLeaveJail(currentPlayer);

        die.roll();
        int value = die.getValue();
        viewController.showDie(value);

        int lastField = currentPlayer.getPosition();
        viewController.movePlayer(currentPlayer, value);
        currentPlayer.movePosition(value, board.getFields().length);
        int position = currentPlayer.getPosition();

        Field currentField = board.getFields()[position];

        checkIfPassedStart(lastField, currentPlayer);

        FieldVisitor visitor = new FieldVisitor(currentPlayer);
        currentField.accept(visitor);

        //viewController.landedOnFieldMessage(currentField);

        players.changePlayerTurn();
    }

    public Field[] getFields(){
        return board.getFields();
    }

    public void endGame() {
        Deque<Player> playersInGame = players.getPlayerDeque();

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
            List<PropertyField> ownedFields = new ArrayList<>();
            for (Field f : board.getFields()) {
                if (f instanceof PropertyField && ((PropertyField) f).getOwner() == player)
                    ownedFields.add((PropertyField) f);
            }
            PropertyField[] ownedFieldsArray = ownedFields.toArray(new PropertyField[0]);
            for(PropertyField field : ownedFieldsArray){
                if(field != null){
                    int fieldIndex = 0;
                    for (int i = 0; i <getFields().length ; i++) {
                        if(getFields()[i].getTitle().equals(field.getTitle())){
                            fieldIndex=i;
                        }
                    }
                    viewController.setFieldColor(Color.white, fieldIndex);
                    viewController.setGUIPlayerBalance(player, player.getBalance());
                    player.sellField(field.getValue());
                    field.setOwner(null);
                }
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

    public void checkIfPassedStart(int last, Player player){
        if(last > player.getPosition()){
            player.addToBalance(2);
            viewController.setGUIPlayerBalance(player, player.getBalance());
        }
    }

    public void payBeforeLeaveJail(Player player){
        if(player.getPayToLeaveJail()==true){
            if(player.getBalance()>=2){
                player.addToBalance(-2);
                viewController.setGUIPlayerBalance(player, player.getBalance());
                player.setPayToLeaveJail(false);
            }
            else{
                player.setLoser(true);
            }
        }
    }
    public PlayerList getPlayers(){return players;}

    public String getLanguageFilepath(){return this.languageFilepath;}

    public void setPlayers(PlayerList players){
        this.players = players;
    }

}
