package monopoly.controller.fieldControllers;

import monopoly.controller.GameController;
import monopoly.controller.ViewController;
import monopoly.model.player.Player;

public abstract class FieldController {

    private GameController gameController;
    private ViewController viewController;

    public FieldController(){
        //gameController = GameController.getInstance();
        //viewController = viewController.getInstance();
    }

    public abstract void resolveEffect(Player player);

}
