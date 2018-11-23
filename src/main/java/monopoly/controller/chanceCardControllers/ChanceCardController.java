package monopoly.controller.chanceCardControllers;

import monopoly.controller.GameController;
import monopoly.controller.ViewController;

public abstract class ChanceCardController {

    private GameController gameController;
    private ViewController viewController;

    public ChanceCardController(){
        this.gameController = GameController.getInstance();
        this.viewController = ViewController.getInstance();
    }

    public abstract void resolveEffect();

}
