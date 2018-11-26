package monopoly.controller.field.implementation;

import monopoly.controller.ViewController;
import monopoly.controller.field.FieldController;
import monopoly.model.board.Field;
import monopoly.model.player.Player;

public class JailFieldController extends FieldController {

    private ViewController viewController = ViewController.getInstance();

    @Override
    public void resolveEffect(Player player, Field field) {
        viewController.showFieldMessage(player.getName(), field.getMessage());
    }

}
