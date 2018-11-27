package monopoly.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class FakeMonopolyFileReader {

    private static FakeMonopolyFileReader singleInstance = null;
    private Map<String, String> messageMap;

    private FakeMonopolyFileReader(){
    }

    public static FakeMonopolyFileReader getInstance(){
        if(singleInstance==null){
            singleInstance = new FakeMonopolyFileReader();
        }
        return singleInstance;
    }

    //reads from given filepath
    private String fileReader(String filePath){

        return (filePath+"/");
    }

    //Uses reader method to build a 2d stringArray from a given filepath+filename
    private String twoDStringArray(String filePath, String fileName){

        return filePath+fileName+"/works";
    }
    //Uses reader method to build a stringArray from a given filepath+filename
    private String oneDStringArray(String filePath, String fileName){
        return filePath+fileName+"/works";
    }

    // each method uses either 1d or 2d StringBuilder to return a specific file's content in an array
    public String getFieldsText(String filePath){ return twoDStringArray(filePath,"/Fields.txt"); }

    public String getChanceCards(String filePath){ return twoDStringArray(filePath,"/ChanceCards.txt"); }

    public String getMenuText(String filePath){return twoDStringArray(filePath,"/Menu.txt"); }

    public String getFieldMessages(String filePath){return oneDStringArray(filePath,"/FieldMessages.txt"); }

    public String getFieldDescriptions(String filePath){ return oneDStringArray(filePath, "/FieldDescriptions.txt"); }

    public String getDirectoriesStringArray(){ return fileReader("TextFiles/"); }


}
