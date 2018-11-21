package monopoly.model.board;

import monopoly.model.player.Player;

import java.awt.*;

public class GoToJailField extends Field {

    private static final int JAIL_POSITION = 6;
    private int bribeCharge = 2;

    public GoToJailField(String title, String subtitle, String description, String message, Color color) {
        super(title, subtitle, description, message, color);
    }

    @Override
    public void resolveEffect(Player player) {
        player.setPosition(JAIL_POSITION);
    }

    public int getBribeCharge(){
        return this.bribeCharge;
    }

}
