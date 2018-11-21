package monopoly.application;

import monopoly.controller.MonopolyFileReader;
import monopoly.model.board.Board;
import monopoly.model.deck.Deck;

import java.awt.*;


public class Main {
    public static String filePath="TextFiles/Dansk";

    private static MonopolyFileReader monoRead = new MonopolyFileReader();
    private static Deck deck = new Deck(11);
        static Board board =new Board();
    public static void main(String[] args){
        board.setupBoard(monoRead.getFieldsText(filePath), monoRead.getFieldDescriptions(filePath), monoRead.getFieldMessages(filePath));
        System.out.println(board.getFields()[10].getTitle());
        System.out.println(board.getFields()[10].getDescription());
        System.out.println(board.getFields()[10].getMessage());

    for (int i = 0; i <board.getFields().length ; i++) {
            System.out.println(board.getFields()[i].getColor());
        }

    }

}
