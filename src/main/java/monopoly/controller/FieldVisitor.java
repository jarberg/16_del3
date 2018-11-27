package monopoly.controller;

import monopoly.model.board.ChanceField;
import monopoly.model.board.GoToJailField;
import monopoly.model.board.JailField;
import monopoly.model.board.ParkingField;
import monopoly.model.board.PropertyField;
import monopoly.model.board.StartField;
import monopoly.model.player.Player;

public class FieldVisitor {

    private Player player;

    public FieldVisitor(Player player){
        this.player = player;
    }

    public void visit(PropertyField field){

    }

    public void visit(JailField field){

    }

    public void visit(GoToJailField field){

    }

    public void visit(ParkingField field){

    }

    public void visit(StartField field){

    }

    public void visit(ChanceField field){

    }

}
