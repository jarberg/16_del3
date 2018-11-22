package monopoly.controller;


import monopoly.model.board.Field;
import monopoly.view.MonopolyView;
import monopoly.model.board.Board;

public class ViewController {

    private MonopolyFileReader fileReader;
    private MonopolyView view = new MonopolyView();
    private String filepath;
    private TranslatorController translator;
    private Board board;

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
    public void showGameGUI(Field[] FieldToGUIField){
        //This should need a dependency to board or field with a method making gui board.
        view.showGameGUI(view.FieldToGUIField(board.getBoard()));
    }

}
