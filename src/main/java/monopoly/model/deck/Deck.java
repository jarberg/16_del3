package monopoly.model.deck;

import java.util.Arrays;
import java.util.Collections;

public class Deck {

    ChanceCard[] cardArray;

    public Deck(int length){ cardArray = new ChanceCard[length]; }

    private void makeDeck(String[][] textFileInput){
        for (int i = 0; i < cardArray.length ; i++) {
            String descrip = textFileInput[i][1];
            int effektID = Integer.valueOf(textFileInput[i][0]);
            cardArray[i] = new ChanceCard(descrip, effektID);
        }
    }
    public void shuffleDeck(){
        Collections.shuffle(Arrays.asList(cardArray));
        Collections.shuffle(Arrays.asList(cardArray));
        Collections.shuffle(Arrays.asList(cardArray));
        Collections.shuffle(Arrays.asList(cardArray));
    }
    public void putTopCardtoBack(){
        ChanceCard tempCardArray = cardArray[0];

        for (int i = 0; i < cardArray.length-1 ; i++) {
            cardArray[i]=cardArray[i+1];
        }
        cardArray[cardArray.length-1]= tempCardArray;
    }
    public String getCardDescription(int ID) { return cardArray[ID].getDescription(); }
    public ChanceCard[] getDeck(){
        return cardArray;
    }
    public ChanceCard getTopCard(){return cardArray[0]; }
    public int getCardEffektID(int ID) { return cardArray[ID].getEffectID(); }

}
