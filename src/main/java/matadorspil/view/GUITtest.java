package matadorspil.view;

import gui_fields.GUI_Field;
import gui_fields.GUI_Player;
import gui_main.GUI;
import matadorspil.model.Player;

public class GUITtest {
Player player1 = new Player("bob");

    public void setUpGUI(){
        GUI gui = new GUI();
        GUI_Player test = new GUI_Player("test");
        gui.addPlayer(test);

    }
}
