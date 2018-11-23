package monopoly.controller.fieldControllers;

import gui_fields.GUI_Player;
import monopoly.controller.GameController;
import monopoly.controller.ViewController;
import monopoly.model.board.Board;
import monopoly.model.board.PropertyField;
import monopoly.model.player.Player;

public abstract class FieldController {

    private GameController gameController;
    private ViewController viewController;
    private Player player;
    Board board;
    public FieldController(){
        //gameController = GameController.getInstance();
        //viewController = viewController.getInstance();
        this.board = board;
    }

    public abstract void resolveEffect(Player player);




}
