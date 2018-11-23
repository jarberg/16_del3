package monopoly.application;

import monopoly.controller.GameController;
import monopoly.controller.ViewController;

public class Main {

    public static void main(String[] args){
        GameController gameCont = GameController.getInstance();
        gameCont.setupGame();
        gameCont.playGame();
    }

}
