package monopoly.model.board;

import java.awt.Color;
public class Board {

    private Field[] fields = new Field[24];

    public void setupBoard(String[][] fields, String[] descrip, String[] mess){
        for (int i = 0; i < this.fields.length ; i++) {
            Color color = new Color(0,0,0);
            switch(Integer.valueOf(fields[i][3])){
                case 1: color= Color.white;
                    break;
                case 2: color= Color.BLUE;
                    break;
                case 3: color= Color.ORANGE;
                    break;
                case 4: color= Color.green.darker();
                    break;
                case 5: color= Color.CYAN;
                    break;
                case 6: color= Color.green;
                    break;
                case 7: color= Color.red;
                    break;
                case 8: color= Color.magenta;
                    break;
                case 9: color= Color.YELLOW;
                    break;
                case 10: color= Color.PINK;
                    break;
                case 11: color= Color.GRAY;
                    break;

            }
            switch (Integer.valueOf(fields[i][1])) {
                case 1:
                    this.fields[i] = new StartField(fields[i][0], fields[i][1], descrip[i], mess[i], color);
                    break;
                case 2:
                    this.fields[i] = new ChanceField(fields[i][0], fields[i][2], descrip[i], mess[i], color);
                    break;
                case 3:
                    this.fields[i] = new JailField(fields[i][0], fields[i][2], descrip[i], mess[i], color);
                    break;
                case 4:
                    this.fields[i] = new GoToJailField(fields[i][0], fields[i][2], descrip[i], mess[i], color);
                    break;
                case 5:
                    this.fields[i] = new ParkingField(fields[i][0], fields[i][2], descrip[i], mess[i], color);
                    break;
                case 6:
                    this.fields[i] = new PropertyField(fields[i][0], fields[i][2],descrip[i], mess[i], color, null, Integer.valueOf(fields[i][2]), Integer.valueOf(fields[i][4]));
                    break;
            }
        }
    }
    public Field[] getFields(){return fields;}


}
