package monopoly.controller.field.implementation;

import monopoly.controller.GameController;
import monopoly.controller.ViewController;
import monopoly.controller.field.FieldController;
import monopoly.model.board.Field;
import monopoly.model.board.JailField;
import monopoly.model.player.Player;

public class GoToJailFieldController extends FieldController {

    private GameController gameController;
    private ViewController viewController;

    public GoToJailFieldController(){
        this.gameController = GameController.getInstance();
        this.viewController = ViewController.getInstance();
    }

    @Override
    public void resolveEffect(Player player, Field field) {
        viewController.showFieldMessage(player.getName(), field.getMessage());
        movePlayerToClosestJail(player);
    }

    private void movePlayerToClosestJail(Player player){
        Field[] fields = gameController.getFields();
        int position = player.getPosition();
        Field currentField = fields[position];
        while(!(currentField instanceof JailField)){
            position++;
            position = position % fields.length;
            currentField = fields[position];
            viewController.movePlayer(player, 1);
            player.setPosition(position);
        }

    }

}
