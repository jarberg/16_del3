package monopoly.model.board;
import java.awt.Color;
public class Board {
    Field[] Fields= new Field[24];

    public void setupBoard(String[][] fields, String[] descrip, String[] mess){
        for (int i = 0; i <Fields.length ; i++) {

            String[] colorCode = new String[3];
            colorCode = fields[i][3].split(",");
            Color color = new Color(Integer.valueOf(colorCode[0]),Integer.valueOf(colorCode[1]),Integer.valueOf(colorCode[2]));

            switch (Integer.valueOf(fields[i][1])) {
                case 1:
                    Fields[i] = new StartField(fields[i][0], fields[i][1], descrip[i], mess[i], Color.white);
                    break;
                case 2:
                    Fields[i] = new ChanceField(fields[i][0], fields[i][2], descrip[i], mess[i], Color.white);
                    break;
                case 3:
                    Fields[i] = new JailField(fields[i][0], fields[i][2], descrip[i], mess[i], Color.white);
                    break;
                case 4:
                    Fields[i] = new ParkingField(fields[i][0], fields[i][2], descrip[i], mess[i], Color.white);
                    break;
                case 5:
                    Fields[i] = new GoToJailField(fields[i][0], fields[i][2], descrip[i], mess[i], Color.white);
                    break;
                case 6:
                    Fields[i] = new PropertyField(fields[i][0], fields[i][2],descrip[i], mess[i], color, null, Integer.valueOf(fields[i][1]), Integer.valueOf(fields[i][4]));
                    break;
            }
        }
    }
    public Field[] getFields(){return Fields;}
}
