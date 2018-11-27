package monopoly.model;

import monopoly.model.board.ChanceField;
import monopoly.model.board.GoToJailField;
import monopoly.model.board.JailField;
import monopoly.model.board.ParkingField;
import monopoly.model.board.PropertyField;
import monopoly.model.board.StartField;

public interface Visitor {

    public void visit(ChanceField field);
    public void visit(ParkingField field);
    public void visit(GoToJailField field);
    public void visit(JailField field);
    public void visit(StartField field);
    public void visit(PropertyField field);


}
