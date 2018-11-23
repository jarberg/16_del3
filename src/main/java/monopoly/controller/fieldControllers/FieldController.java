package monopoly.controller.fieldControllers;

import monopoly.controller.GameController;
import monopoly.controller.ViewController;
import monopoly.model.board.Board;
import monopoly.model.player.Player;

public abstract class FieldController {

    private GameController gameController;
    private ViewController viewController;
    Board board;

    public FieldController(){
        gameController = GameController.getInstance();
        viewController = ViewController.getInstance();
        this.board = board;
    }

    public abstract void resolveEffect(Player player);




}
