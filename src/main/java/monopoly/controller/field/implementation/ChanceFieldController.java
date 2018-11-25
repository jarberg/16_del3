package monopoly.controller.field.implementation;

import monopoly.controller.GameController;
import monopoly.controller.MonopolyFileReader;
import monopoly.controller.ViewController;
import monopoly.controller.field.FieldController;
import monopoly.model.board.Field;
import monopoly.model.deck.CardEffect;
import monopoly.model.deck.Deck;
import monopoly.model.deck.effects.MoneyEffekt;
import monopoly.model.player.Player;

public class ChanceFieldController extends FieldController {

    private ViewController viewController = ViewController.getInstance();
    private Deck deck;
    private CardEffect effect;
    private int ID;
    private GameController gameController = GameController.getInstance();
    private static ChanceFieldController singleInstance = null;
    private String filePath;

    private ChanceFieldController(){
        deck = new Deck(19);
        deck.makeDeck(MonopolyFileReader.getInstance().getChanceCards(gameController.getLanguageFilepath()));
        deck.shuffleDeck();
    }

    public static ChanceFieldController getInstance(){
        if(singleInstance == null)
            singleInstance = new ChanceFieldController();

        return singleInstance;
    }

    @Override
    public void resolveEffect(Player player, Field field) {
        viewController.showFieldMessage(player.getName(), field.getMessage());
        //viewController.showFieldMessage(player.getName(), deck.getTopCard().getDescription());

        setID(deck.getTopCard().getEffectID());
        System.out.println(deck.getTopCard().getDescription());
        System.out.println(deck.getTopCard().getEffectID());


        deck.putTopCardtoBack();
    }


    private void setID(int ID){this.ID=ID;}

    public void setFilePath(String filePath){this.filePath = filePath;}

}
