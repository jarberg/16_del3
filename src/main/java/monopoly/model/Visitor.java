package monopoly.model;

import monopoly.model.board.ChanceField;
import monopoly.model.board.GoToJailField;
import monopoly.model.board.JailField;
import monopoly.model.board.ParkingField;
import monopoly.model.board.PropertyField;
import monopoly.model.board.StartField;

public interface Visitor {

    void visit(ChanceField field);
    void visit(ParkingField field);
    void visit(GoToJailField field);
    void visit(JailField field);
    void visit(StartField field);
    void visit(PropertyField field);


}
