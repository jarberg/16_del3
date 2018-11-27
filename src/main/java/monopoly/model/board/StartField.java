package monopoly.model.board;

import monopoly.model.Visitor;

import java.awt.*;

public class StartField extends Field{

    public StartField(String title, String subtitle, String description, String message, Color color) {
        super(title, subtitle, description, message, color);
    }

    public StartField() {
        super();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
