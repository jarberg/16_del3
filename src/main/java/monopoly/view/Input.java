package monopoly.view;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    public List<String> reader(String filePath){
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath);
        Scanner scanner = new Scanner(resourceAsStream);
        List<String> returnString = new ArrayList();
        while (scanner.hasNext()) {
            returnString.add(scanner.nextLine());
        }

        return returnString;
    }


    public String getFieldsText(String filePath){
        String newFilepath = filePath+"/Fields.txt";
        String[] fields = reader(newFilepath).toArray(new String[0]);

        for (int i = 0; i < (fields.length) ; i++) {

            fields[i] = fields[i - 2];
        }
        String[][] finalFields = new String[fields.length+2][3];

        return newFilepath;
    }
    public String getMenuText(String filePath){
        String newFilepath = filePath+"/Menu.txt";
        reader(newFilepath);
        return newFilepath;
    }
    public String getChanceCards(String filePath){
        String newFilepath = filePath+"/chanceCards.txt";
        reader(newFilepath);
        return newFilepath;
    }
    public String getFieldMessages(String filePath){
        String newFilepath = filePath+"/FieldMessages.txt";
        reader(newFilepath);
        return newFilepath;
    }
    public String getFieldDescriptions(String filePath){
        String newFilepath = filePath+"/FieldDescriptions.txt";
        reader(newFilepath);
        return newFilepath;
    }
}
