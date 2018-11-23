package monopoly.controller.field.implementation;

import monopoly.controller.field.FieldController;
import monopoly.model.board.Board;
import monopoly.model.board.Field;
import monopoly.model.board.PropertyField;
import monopoly.model.player.Player;

public class PropertyFieldController extends FieldController {

    Board board;
    Player player;
    PropertyField p;

    public PropertyFieldController(Board board,Player player) {
        this.board = board;
        this.player = player;
        checkifProp();
    }

    @Override
    public void resolveEffect(Player player, Field field) {
        checkifProp();
        int pos = player.getPosition();
        Player owner = getOwner();

        if(owner == null){
            buyField(player);
        }
        else if(owner!=player&& owner!=null){
            if(checkIfPair()&& owner!=null){
                if(player.getBalance()>2*p.getValue()){
                    player.addToBalance(-2*(p.getValue()));
                    p.getOwner().addToBalance(2*p.getValue());
                }
                else{
                    Field[] fields = getFieldsOwnedByPlayer(player);
                    for (int i = 0; i <fields.length ; i++) {
                        if(player.getBalance()<2*p.getValue()){
                            sellField(player, fields);
                        }
                        else{
                            break;
                        }
                        player.addToBalance(-2*(p.getValue()));
                        p.getOwner().addToBalance(2*p.getValue());
                    }
                }
            }
            else{
                if(player.getBalance()>p.getValue()){
                    player.addToBalance(-(p.getValue()));
                    p.getOwner().addToBalance(p.getValue());
                }
                else{
                    Field[] fields = getFieldsOwnedByPlayer(player);
                    for (int i = 0; i <fields.length ; i++) {
                        if(player.getBalance()<p.getValue()){
                            sellField(player, fields);
                        }
                        else{
                            break;
                        }
                    }
                    player.addToBalance(-(p.getValue()));
                    p.getOwner().addToBalance(p.getValue());
                }
            }
        }
    }

    public Player getOwner(){
        return p.getOwner();
    }

    public int getPos(){ return player.getPosition(); }

    public void checkifProp(){
        Field field = board.getFields()[getPos()];
        if (field instanceof PropertyField){
            this.p = (PropertyField) field;
        }
    }

    public boolean checkIfPair(){
        boolean isOwner=false;
        Player fOwner = p.getOwner();
        PropertyField pp= null;
        Field field = board.getFields()[p.getPairIndex()];
        if (field instanceof PropertyField){
             pp = (PropertyField) field;

            if(fOwner == pp.getOwner() ){
                if(fOwner==null){
                 isOwner=false;
                }
                else {
                    isOwner = true;
                }
            }
            else{
                isOwner = false;
            }
        }
        return isOwner;
    }

    public void buyField(Player player){
        if(player.getBalance()>p.getValue()){
            player.addToBalance(-(p.getValue()));
        }
    }

    public void sellField(Player player, Field[] fields){
        if(fields.length >0){
            player.addToBalance(p.getValue());
            p.setOwner(null);
        }
    }

    public Field[] getFieldsOwnedByPlayer(Player player){

        Field[] unknownFields = board.getFields();
        Field[] tempPlayerOwnedArray = new Field[unknownFields.length];

        for (int i = 0; i <unknownFields.length ; i++) {
            checkifProp();
            if(p.getOwner()==player){
                tempPlayerOwnedArray[i]= p;
            }
        }
        int counter=0;
        for (int i = 0; i <tempPlayerOwnedArray.length ; i++) {
            if(tempPlayerOwnedArray[i]==null){
                break;
            }
            else{
             counter++;
            }
        }
        Field[] playerOwnedArray = new Field[counter];
        for (int i = 0; i <playerOwnedArray.length ; i++) {
            playerOwnedArray[i]= tempPlayerOwnedArray[i];
        }
        return playerOwnedArray;
    }
}
