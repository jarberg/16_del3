package monopoly.model.board;


import monopoly.model.Visitor;

import java.awt.*;

public class ChanceField extends Field {

    public ChanceField(String title, String subtitle, String description, String message, Color color){
        super(title, subtitle, description, message, color);
    }

    public ChanceField() {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
