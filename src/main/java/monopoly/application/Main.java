package monopoly.application;

import monopoly.model.board.Board;
import monopoly.model.deck.Deck;
import monopoly.model.MonopolyReader;



public class Main {
    public static String filePath="TextFiles/Dansk";

    private static MonopolyReader monoRead = new MonopolyReader();
    private static Deck deck = new Deck(11);
        static Board board =new Board();
    public static void main(String[] args){
        board.setupBoard(monoRead.getFieldsText(filePath), monoRead.getFieldDescriptions(filePath), monoRead.getFieldMessages(filePath));
        System.out.println(board.getBoard()[0].getTitle());
        System.out.println(board.getBoard()[0].getDescription());
        System.out.println(board.getBoard()[0].getMessage());
        System.out.println(board.getBoard()[0].getSubtitle());


    }

}
