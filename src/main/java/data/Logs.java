package data;

import java.io.*;  // Import the File class


public class Logs{
 
    private static Logs log = new Logs();
    public Logs(){
        try{
            File outputFile = new File("../src/main/java/tracker/userdata.txt");
            outputFile.createNewFile();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public Logs getLogs(){
        return (log);
    }

    public void wirteLog(String info){
        try{
            BufferedWriter out = new BufferedWriter( 
                   new FileWriter("../src/main/java/tracker/userdata.txt", true)); 
            out.write(info + "\n"); 
            out.close(); 
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}