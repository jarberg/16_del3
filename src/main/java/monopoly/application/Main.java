package monopoly.application;

import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import monopoly.view.MonopolyView;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        MonopolyView view = new MonopolyView();
        view.showEmptyGUI();
        GUI_Field[] fields = new GUI_Field[1];
        fields[0] = new GUI_Street();
        view.showGameGUI(fields);
        view.addPlayer("timmy", Color.black);
    }

}
