package monopoly.controller;

import monopoly.model.player.Player;
import monopoly.view.MonopolyView;

public class ViewController {

    private MonopolyFileReader fileReader;
    private MonopolyView view;
    private String filepath;
    private TranslatorController translator;

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
        this.translator = new TranslatorController(filepath);
    }

    public int getPlayerAmount(){
        String[] playerOptions = {"2", "3", "4"};
        String message = translator.getPlayerAmountChoiceMessage();
        return view.getPlayerAmount(message, playerOptions);
    }

    public String getPlayerName() {
        String message = translator.getPlayerNameMessage();
        return view.getPlayerName(message);
    }

    public int getPlayerAge() {
        String message = translator.getPlayerAgeMessage();
        return view.getUserAge(message);
    }

    public void addPlayer(Player player){
        view.addPlayer(player.getName(), player.getColor());
    }
}
