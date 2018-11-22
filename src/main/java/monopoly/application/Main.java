package monopoly.application;

import monopoly.controller.GameController;
import monopoly.controller.ViewController;

public class Main {

    public static void main(String[] args){
        GameController gameCont = new GameController();
        ViewController viewCon = new ViewController();

       gameCont.setupGame();
       //viewCon.showEmptyGUI();
    }

}
