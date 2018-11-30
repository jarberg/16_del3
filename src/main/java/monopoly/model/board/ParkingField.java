package monopoly.model.board;

import monopoly.model.Visitor;

import java.awt.*;

public class ParkingField extends Field{

    public ParkingField(String title, String subtitle, String description, String message, Color color) {
        super(title, subtitle, description, message, color);
    }

    public ParkingField() {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
