package monopoly.controller.field;

import monopoly.controller.GameController;
import monopoly.controller.ViewController;
import monopoly.model.board.Field;
import monopoly.model.player.Player;

public abstract class FieldController {

    private GameController gameController;
    private ViewController viewController;

    public FieldController(){
        gameController = GameController.getInstance();
        viewController = ViewController.getInstance();
    }

    public abstract void resolveEffect(Player player, Field field);

}
