package monopoly.model;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonopolyReader {

    private String[] reader(String filePath){
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(filePath);
        Scanner scanner = new Scanner(resourceAsStream);
        List<String> stringList = new ArrayList<>();
        while (scanner.hasNext()) {
            stringList.add(scanner.nextLine());
        }
        String[] returnList = stringList.toArray(new String[0]);
        return returnList;
    }

    private String[][] twoDStringBuilder(String filePath, String fileName){
        String newFilepath = filePath+fileName;
        String[] stringList = reader(newFilepath);
        String[][] finalStringList = new String[stringList.length][5];

        for (int i = 0; i < finalStringList.length; i++) {
            finalStringList[i] = stringList[i].split(":");
        }
        return finalStringList;
    }

    private String[] oneDStringBuilder(String filePath, String fileName){
        String newFilepath = filePath+fileName;
        String[] fields = reader(newFilepath);
        String[] finalFields = new String[fields.length];

        for (int i = 0; i < finalFields.length; i++) {

            finalFields[i] = fields[i];

        }
        return finalFields;
    }


    public String[][] getFieldsText(String filePath){ return twoDStringBuilder(filePath,"/Fields.txt"); }

    public String[][] getChanceCards(String filePath){ return twoDStringBuilder(filePath,"/ChanceCards.txt"); }

    public String[][] getMenuText(String filePath){return twoDStringBuilder(filePath,"/Menu.txt"); }

    public String[] getFieldMessages(String filePath){return oneDStringBuilder(filePath,"/FieldMessages.txt"); }

    public String[] getFieldDescriptions(String filePath){ return oneDStringBuilder(filePath, "/FieldDescriptions.txt"); }

    public String[] getDirectoryList(){return reader("TextFiles"); }

}
