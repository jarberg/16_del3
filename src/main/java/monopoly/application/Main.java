package monopoly.application;

import gui_fields.GUI_Field;
import gui_fields.GUI_Street;
import monopoly.view.MonopolyView;

public class Main {

    public static void main(String[] args) {

        MonopolyView view = new MonopolyView();
        view.showEmptyGUI();
        view.getUserLanguage();
        view.getPlayerAmount("pick");
        view.getUserColor("pick ur color lol");
        view.getUserColor("pick ur color lol2");
        view.getUserColor("pick ur color lol");
        view.getUserAge("pick age lol");
        GUI_Field[] fields = new GUI_Field[1];
        fields[0] = new GUI_Street();
        view.showGameGUI(fields);
    }

}
