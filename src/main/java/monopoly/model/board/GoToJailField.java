package monopoly.model.board;

import monopoly.controller.field.implementation.GoToJailFieldController;
import monopoly.model.player.Player;

import java.awt.*;

public class GoToJailField extends Field {

    private static final int bribeCharge = 2;

    public GoToJailField(String title, String subtitle, String description, String message, Color color) {
        super(title, subtitle, description, message, color);
    }

    public GoToJailField() {

    }

    public int getBribeCharge(){
        return bribeCharge;
    }

}
