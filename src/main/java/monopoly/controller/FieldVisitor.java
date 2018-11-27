package monopoly.controller;

import monopoly.model.board.ChanceField;
import monopoly.model.board.Field;
import monopoly.model.board.GoToJailField;
import monopoly.model.board.JailField;
import monopoly.model.board.ParkingField;
import monopoly.model.board.PropertyField;
import monopoly.model.board.StartField;
import monopoly.model.player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FieldVisitor implements Visitor {

    private static final int PROPERTY_MULTIPLIER = 2;
    private GameController gameController = GameController.getInstance();
    private ViewController viewController = ViewController.getInstance();
    private Player player;

    public FieldVisitor(Player player){
        this.player = player;
    }


    public void visit(JailField field){
        viewController.showFieldMessage(player.getName(), field.getMessage());
    }

    public void visit(GoToJailField field){
        movePlayerToClosestJail(player);
    }

    private void movePlayerToClosestJail(Player player){
        Field[] fields = gameController.getFields();
        int position = player.getPosition();
        Field currentField = fields[position];
        while(!(currentField instanceof JailField)){
            position++;
            position = position % fields.length;
            currentField = fields[position];
            viewController.movePlayer(player, 1);
            player.setPosition(position);
        }
        player.setPayToLeaveJail(true);
    }

    public void visit(ParkingField field){
        viewController.showFieldMessage(player.getName(), field.getMessage());
    }

    public void visit(StartField field){
        viewController.showFieldMessage(player.getName(), field.getMessage());
    }

    public void visit(PropertyField field){
        viewController.showFieldMessage(player.getName(), field.getMessage());
        Player owner = field.getOwner();

        boolean fieldHasNoOwner = (owner == null);
        boolean otherPlayerIsOwner = (owner != null && !owner.equals(player));
        boolean pairPropertyOwned = checkIfPair(field, owner);

        if(fieldHasNoOwner){
            attemptToBuyFieldFromBank(player, field);
        }
        else if(otherPlayerIsOwner){
            if(pairPropertyOwned){
                viewController.pairPropertyMessage(owner.getName());
                int cost = field.getValue()*PROPERTY_MULTIPLIER;
                payRentToProperty(player, owner, cost);
                viewController.setGUIPlayerBalance(owner, owner.getBalance());
            }
            else{
                int cost = field.getValue();
                payRentToProperty(player, owner, cost);
                viewController.setGUIPlayerBalance(owner, owner.getBalance());
            }
        }
        viewController.setGUIPlayerBalance(player, player.getBalance());
    }

    private void attemptToBuyFieldFromBank(Player player, PropertyField field) {
        int cost = field.getValue();
        if(playerHasMoney(this.player, cost)){
            player.addToBalance(-cost);
            field.setOwner(player);
            viewController.setFieldColor(player.getColor(),getFieldIndex(gameController.getFields()[player.getPosition()]));
            viewController.boughtFromBankMessage(player.getName(), field, cost);
        }
        else{
            PropertyField[] fields = getFieldsOwnedByPlayer(player);
            sellFieldsUntilRichEnough(player, cost, fields);
            if(!playerHasMoney(this.player, cost)){
                viewController.notEnoughMoneyMessage(player.getName());
                this.player.setLoser(true);
            }
            player.addToBalance(-cost);
            field.setOwner(player);
            viewController.setFieldColor(player.getColor(),getFieldIndex(gameController.getFields()[player.getPosition()]));
            viewController.boughtFromBankMessage(player.getName(), field, cost);
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
            PropertyField[] fields = getFieldsOwnedByPlayer(player);
            sellFieldsUntilRichEnough(player, cost, fields);
            if(!playerHasMoney(this.player, cost)){
                viewController.notEnoughMoneyMessage(player.getName());
                player.setLoser(true);
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

    private boolean checkIfPair(Field field, Player player){
        PropertyField f = (PropertyField) field;
        boolean ownsBothProperties = false;
        if(((PropertyField)gameController.getFields()[f.getPairIndex()]).getOwner() == player)
            ownsBothProperties = true;
        return ownsBothProperties;
    }

    private void sellField(PropertyField field){
        viewController.setFieldColor(Color.white, getFieldIndex(field));
        viewController.setGUIPlayerBalance(player, player.getBalance());
        if(field == null)
            return;

        this.player.sellField(field.getValue());
        field.setOwner(null);
    }

    private PropertyField[] getFieldsOwnedByPlayer(Player player) {
        Field[] allFields = gameController.getFields();
        List<PropertyField> ownedFields = new ArrayList<>();
        for (Field f : allFields) {
            if (f instanceof PropertyField && ((PropertyField) f).getOwner() == player)
                ownedFields.add((PropertyField) f);
        }
        return ownedFields.toArray(new PropertyField[0]);
    }

    private int getFieldIndex(Field field){
        int fieldIndex = 0;
        for (int i = 0; i <gameController.getFields().length ; i++) {
            if(gameController.getFields()[i].getTitle()==field.getTitle()){
                fieldIndex=i;
            }
        }
        return fieldIndex;
    }

    public void visit(ChanceField field){
        viewController.showFieldMessage(player.getName(), field.getMessage());
    }



}
