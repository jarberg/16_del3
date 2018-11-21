package monopoly.model.board;

import monopoly.model.player.Player;

import java.awt.*;

public class StartField extends Field{

    public StartField(String title, String subtitle, String description, String message, Color color) {
        super(title, subtitle, description, message, color);
    }

    @Override
    public void resolveEffect(Player player) {

    }
}
