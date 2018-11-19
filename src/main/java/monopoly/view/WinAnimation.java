package monopoly.view;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;

public class WinAnimation {

    private GUI gui;
    private GUI_Player player;

    public WinAnimation(GUI gui, GUI_Player player){
        this.gui = gui;
        this.player = player;
        runWinAnimation();
    }

    private void runWinAnimation(){
        GUI_Field[] fields = gui.getFields();
        Color playerColor = player.getPrimaryColor();

        for(GUI_Field field : fields){
            field.removeAllCars();
            sleep();
        }

        for(GUI_Field field : fields){
            field.setBackGroundColor(playerColor);
            sleep();
        }

        for(GUI_Field field : fields){
            field.setTitle(player.getName());
            field.setSubText(player.getName() + "!!!");
            sleep();
        }


    }

    private void sleep(){
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
