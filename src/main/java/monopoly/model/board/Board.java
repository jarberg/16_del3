package monopoly.model.board;
import java.awt.Color;
public class Board {
    Field[] Fields= new Field[24];

    public void setupBoard(String[][] fields, String[] descrip, String[] mess){
        for (int i = 0; i <fields.length ; i++) {
            if (i==0){
                Fields[i] = new StartField(fields[i][0], fields[i][1],descrip[i], mess[i], Color.white);
            }
            else if(i==3 || i==9 || i == 15|| i==21){
                Fields[i] = new ChanceField(fields[1][0], fields[1][1],descrip[1], mess[1], Color.white);
            }
            else if(i==6){
                Fields[i] = new JailField(fields[2][0], fields[2][1],descrip[2], mess[2], Color.white);
            }
            else if(i==12){
                Fields[i]= new ParkingField(fields[4][0], fields[4][1],descrip[4], mess[4], Color.white);
            }
            else if(i==18){
                Fields[i]= new GoToJailField(fields[3][0], fields[3][1],descrip[3], mess[3], Color.white);
            }
            else {
                for (int j = 5; j <fields.length ; j++) {
                    Fields[j] = new PropertyField(fields[j][0], fields[j][1],descrip[j], mess[j], Color.getColor(fields[j][3]), null, Integer.valueOf(fields[j][1]));
                }
            }
        }
    }

    public Field[] getBoard(){return Fields;}
}
