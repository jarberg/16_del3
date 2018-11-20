package monopoly.application;

import monopoly.model.deck.Deck;
import monopoly.model.MonopolyReader;



public class Main {
    public static String filePath="TextFiles/Dansk";

    private static MonopolyReader monoRead = new MonopolyReader();
    private static Deck deck = new Deck(11);

    public static void main(String[] args){

        deck.makeDeck(monoRead.getChanceCards(filePath));
        System.out.println(deck.getCardDescription(0));
    }

}
