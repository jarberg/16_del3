package monopoly.model.board;

import monopoly.model.Player;

import java.awt.*;

public class ParkingField extends Field{

    public ParkingField(String title, String subtitle, String description, String message, Color color) {
        super(title, subtitle, description, message, color);
    }

    @Override
    public void resolveEffect(Player player) {

    }
}
