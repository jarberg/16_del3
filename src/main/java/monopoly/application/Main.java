package monopoly.application;

import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import monopoly.view.MonopolyView;
import monopoly.model.Deck;
import monopoly.model.MonopolyReader;
import java.awt.*;

public class Main {
    public static String filePath="TextFiles/Dansk";

    private static MonopolyReader monoRead = new MonopolyReader();
    private static Deck deck = new Deck(11);

    public static void main(String[] args){
            deck.makeDeck(monoRead.getChanceCards(filePath));
    }

}
