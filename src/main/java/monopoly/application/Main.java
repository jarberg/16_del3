package monopoly.application;

import monopoly.view.MonopolyView;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MonopolyView view = new MonopolyView();
        view.showEmptyGUI();
        view.addPlayer(view.getPlayerName("name"),view.getUserColor("color"));
        view.addPlayer(view.getPlayerName("name"),view.getUserColor("color"));
        view.addPlayer(view.getPlayerName("name"),view.getUserColor("color"));
        view.addPlayer(view.getPlayerName("name"),view.getUserColor("color"));
        view.addPlayer(view.getPlayerName("name"),view.getUserColor("color"));
    }

}
