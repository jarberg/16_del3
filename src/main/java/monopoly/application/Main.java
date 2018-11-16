package monopoly.application;

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
    }

}
