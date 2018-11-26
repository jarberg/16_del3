package monopoly.controller.field.implementation;

import monopoly.controller.GameController;
import monopoly.controller.ViewController;
import monopoly.controller.field.FieldController;
import monopoly.model.board.Board;
import monopoly.model.board.Field;
import monopoly.model.board.PropertyField;
import monopoly.model.player.Player;

import java.awt.*;
import java.util.List;

public class PropertyFieldController extends FieldController {

    private GameController gameController;
    private ViewController viewController;
    private Player player;
    private PropertyField field;
    private Board board;
    private Field[] boardArray;
    private static final int PROPERTY_MULTIPLIER = 2;

    public PropertyFieldController() {
        this.gameController = GameController.getInstance();
        this.viewController = ViewController.getInstance();
        boardArray=this.gameController.getFields();
        board = new Board();
    }

    @Override
    public void resolveEffect(Player player, Field field) {
        viewController.showFieldMessage(player.getName(), field.getMessage());
        this.player = player;
        this.field = (PropertyField) field;
        Player owner = this.field.getOwner();

        boolean fieldHasNoOwner = (owner == null);
        //boolean playerIsOwner = (owner != null && owner.equals(player));
        boolean otherPlayerIsOwner = (owner != null && !owner.equals(player));
        boolean pairPropertyOwned = checkIfPair(this.field, owner);

        if(fieldHasNoOwner){
            int cost = this.field.getValue();
            attemptToBuyFromBank(player, cost);
        }
        else if(otherPlayerIsOwner){
            if(pairPropertyOwned){
                viewController.pairPropertyMessage(owner.getName());
                int cost = this.field.getValue()*PROPERTY_MULTIPLIER;
                payRentToProperty(player, owner, cost);
                viewController.setGUIPlayerBalance(owner, owner.getBalance());
            }
            else{
                int cost = this.field.getValue();
                payRentToProperty(player, owner, cost);
                viewController.setGUIPlayerBalance(owner, owner.getBalance());
            }
        }
        viewController.setGUIPlayerBalance(player, player.getBalance());
    }

    private void attemptToBuyFromBank(Player player, int cost) {
        if(playerHasMoney(this.player, cost)){
            player.addToBalance(-cost);
            this.field.setOwner(player);
            viewController.setFieldColor(player.getColor(),getFieldIndex(boardArray[player.getPosition()]));
            this.player.setOwnedFields((PropertyField) gameController.getFields()[this.player.getPosition()]);
            viewController.boughtFromBankMessage(player.getName(), this.field, cost);

        }
        else{
            PropertyField[] fields = getOwnedFields().toArray(new PropertyField[0]);
            sellFieldsUntilRichEnough(player, cost, fields);
            if(!playerHasMoney(this.player, cost)){
                viewController.notEnoughMoneyMessage(player.getName());
            }
            player.addToBalance(-cost);
            this.field.setOwner(player);
            viewController.setFieldColor(player.getColor(),getFieldIndex(boardArray[player.getPosition()]));
            this.player.setOwnedFields((PropertyField) gameController.getFields()[this.player.getPosition()]);
            viewController.boughtFromBankMessage(player.getName(), this.field, cost);
        }
    }

    private void payRentToProperty(Player player, Player owner, int cost) {
        if(playerHasMoney(this.player, cost)){
            player.addToBalance(-cost);
            owner.addToBalance(cost);
            viewController.paidRentMessage(player.getName(), owner.getName(), cost);
            viewController.setGUIPlayerBalance(player, player.getBalance());
            viewController.setGUIPlayerBalance(owner, owner.getBalance());

        }
        else{
            PropertyField[] fields = getOwnedFields().toArray(new PropertyField[0]);
            sellFieldsUntilRichEnough(player, cost, fields);
            if(!playerHasMoney(this.player, cost)){
                viewController.notEnoughMoneyMessage(player.getName());
                //player.setLoser(true);
            }
            player.addToBalance(-cost);
            owner.addToBalance(cost);
            viewController.paidRentMessage(player.getName(), owner.getName(), cost);
            viewController.setGUIPlayerBalance(owner, owner.getBalance());
        }
    }

    private void sellFieldsUntilRichEnough(Player player, int cost, PropertyField[] fields) {
        for (PropertyField f : fields) {
            if (!playerHasMoney(this.player, cost)) {
                viewController.notEnoughMoneyMessage(player.getName());
                sellField(f);
                viewController.soldPropertyMessage(player.getName(), f.getTitle(), player.getBalance());

            }
        }
    }

    private boolean playerHasMoney(Player player, int amount){
        return player.getBalance() >= amount;
    }

    public boolean checkIfPair(Field field, Player player){
        PropertyField f = (PropertyField) field;
        boolean ownsBothProperties = false;
        if(((PropertyField)gameController.getFields()[f.getPairIndex()]).getOwner() == player)
            ownsBothProperties = true;
        return ownsBothProperties;
    }

    private void sellField(PropertyField field){

        viewController.setFieldColor(Color.white, getFieldIndex(field));
        viewController.setGUIPlayerBalance(player, player.getBalance());
        this.player.sellField(gameController.getFields()[this.player.getPosition()], field);

    }

    private List<Field> getOwnedFields() {
        return player.getOwnedFields();
    }

    public int getFieldIndex(Field field){

        int fieldIndex = 0;
        for (int i = 0; i <boardArray.length ; i++) {
            if(boardArray[i].getTitle()==field.getTitle()){
                fieldIndex=i;
            }
        }
        return fieldIndex;
    }

        /*
        Field[] tempPlayerOwnedArray = new Field[allFields.length];

        for (int i = 0; i < allFields.length ; i++) {
            if(allFields[i] instanceof PropertyField){
                if(field.getOwner()==player){
                    tempPlayerOwnedArray[i]= field;
                }
            }
        }

        int counter = 0;
        for (Field field : tempPlayerOwnedArray) {
            if (field != null) {
                counter++;
            }
        }

        Field[] playerOwnedArray = new Field[counter];
        int counterTwo = 0;
        for (int i = 0; i < allFields.length ; i++) {
            if(tempPlayerOwnedArray[i] != null){
                playerOwnedArray[counterTwo] = tempPlayerOwnedArray[i];
                counterTwo++;
            }
        }
        return playerOwnedArray;
        */

}
