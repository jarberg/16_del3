package monopoly.controller.field.implementation;

import monopoly.controller.GameController;
import monopoly.controller.ViewController;
import monopoly.controller.field.FieldController;
import monopoly.model.board.Field;
import monopoly.model.board.PropertyField;
import monopoly.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class PropertyFieldController extends FieldController {

    private GameController gameController;
    private ViewController viewController;
    private Player player;
    private PropertyField field;
    private static final int PROPERTY_MULTIPLIER = 2;

    public PropertyFieldController() {
        this.gameController = GameController.getInstance();
        this.viewController = ViewController.getInstance();
    }

    @Override
    public void resolveEffect(Player player, Field field) {
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
        }
        else{
            PropertyField[] fields = getFieldsOwnedByPlayer(player);
            for (PropertyField f : fields) {
                if (!playerHasMoney(this.player, cost)) {
                    sellField(player, f);
                }
            }
            if(!playerHasMoney(this.player, cost)){
                gameController.endGame();
            }
            player.addToBalance(-cost);
            this.field.setOwner(player);
        }
    }

    private void payRentToProperty(Player player, Player owner, int cost) {
        if(playerHasMoney(this.player, cost)){
            player.addToBalance(-cost);
            owner.addToBalance(cost);
        }
        else{
            PropertyField[] fields = getFieldsOwnedByPlayer(player);
            for (PropertyField f : fields) {
                if (!playerHasMoney(this.player, cost)) {
                    sellField(player, f);
                }
            }
            if(!playerHasMoney(this.player, cost)){
                gameController.endGame();
            }
            player.addToBalance(-cost);
            owner.addToBalance(cost);
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

    private void sellField(Player player, PropertyField field){
        player.addToBalance(field.getValue());
        field.setOwner(null);
    }

    private PropertyField[] getFieldsOwnedByPlayer(Player player){
        Field[] allFields = gameController.getFields();
        List<PropertyField> ownedFields = new ArrayList<>();
        for(Field f : allFields){
            if(f instanceof PropertyField && ((PropertyField) f).getOwner() == player)
                ownedFields.add((PropertyField)f);
        }
        return ownedFields.toArray(new PropertyField[0]);

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
}
