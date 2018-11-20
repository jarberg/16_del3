package monopoly.model.board;

import monopoly.model.board.Field;

public class Board {
    Field[] fields;

    public Board(String[][] fieldInfo){
        this.fields = new Field[24];
    }

}
