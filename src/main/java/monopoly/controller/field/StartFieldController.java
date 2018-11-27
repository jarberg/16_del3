package monopoly.controller.field;

import monopoly.controller.ViewController;
import monopoly.controller.field.FieldController;
import monopoly.model.board.Field;
import monopoly.model.player.Player;

public class StartFieldController extends FieldController {

    private ViewController viewController = ViewController.getInstance();

    @Override
    public void resolveEffect(Player player, Field field) {
        viewController.showFieldMessage(player.getName(), field.getMessage());
        getStartMoney(player);
    }
    public void getStartMoney(Player player){
        if(player.getPosition()==0){
            player.addToBalance(2);
        }
    }
}
