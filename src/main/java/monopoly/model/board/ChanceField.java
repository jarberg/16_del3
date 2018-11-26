package monopoly.model.board;


import monopoly.controller.field.implementation.ChanceFieldController;
import monopoly.model.player.Player;

import java.awt.*;

public class ChanceField extends Field {

    public ChanceField(String title, String subtitle, String description, String message, Color color){
        super(title, subtitle, description, message, color);
    }

    public ChanceField() {

    }

    @Override
    public void resolveEffect(Player player) {
        ChanceFieldController chanceFieldController = new ChanceFieldController();
        chanceFieldController.resolveEffect(player, this);
    }

}
