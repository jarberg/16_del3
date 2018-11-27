package monopoly.model.board;


import monopoly.controller.Visitor;

import java.awt.*;

public class JailField extends Field {

    public JailField(String title, String subtitle, String description, String message, Color color){
        super(title, subtitle, description, message, color);
    }

    public JailField() {

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
