package monopoly.model.board;

import monopoly.model.player.Player;

import java.awt.*;

public class JailField extends Field {

    public JailField(String title, String subtitle, String description, String message, Color color){
        super(title, subtitle, description, message, color);
    }

    @Override
    public void resolveEffect(Player player) {
    }
}
