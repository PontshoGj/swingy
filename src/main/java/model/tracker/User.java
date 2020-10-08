package model.tracker;

import data.*;
import java.util.Scanner;
import java.sql.*;  
import model.*;
public class User{
    private static Db       conn = new Db(); 
    private static Logs     log = new Logs().getLogs(); 
    public void createUser(){
        options();
    }
    
    public void createHero(String name){

        log.wirteLog(name);
    }


    public int UserName(String name){
        int i  = conn.newPlayer(name);
        // System.out.println(i);
        // log.wirteLog(name);
        return i;
    }

    public String [] UserClass(String userclass, int id){
        switch (userclass.toLowerCase()){
            case "warrior":{
                conn.insertClass(id,"warrior", 40, 20, 100);
                // log.wirteLog("warrior:40:20:100");
                // log.wirteLog("");
                break;
            }
            case "shaman":{
                conn.insertClass(id,"shaman", 30, 15, 90);
                // log.wirteLog("shaman:30:15:90");
                // log.wirteLog("");
                break;
            }
            case "priest":{
                conn.insertClass(id,"priest", 25, 25, 90);
                // log.wirteLog("priest:25:25:90");
                // log.wirteLog("");
                break;
            }
            case "paladin":{
                conn.insertClass(id,"paladin", 40, 30, 120);
                // log.wirteLog("paladin:40:30:120");
                // log.wirteLog("");
                break;
            }
            case "mage":{
                conn.insertClass(id,"mage", 45, 10, 80);
                // log.wirteLog("mage:45:10:80");
                // log.wirteLog("");
                break;
            }
            case "hunter":{
                conn.insertClass(id,"hunter", 25, 20, 110);
                // log.wirteLog("hunter:25:20:110");
                // log.wirteLog("");
                break;
            }
        }
        
        return conn.getPlayInfo(id);
    }
    public String[] getplayer(int id){
        return conn.getPlayInfo(id);
    }
    public void options(){
        System.out.println("Classes:\tattack\tdefense\thp");
        System.out.println("Warrior\t\t40\t20\t100");
        System.out.println("Shaman\t\t30\t15\t90");
        System.out.println("Priest\t\t25\t25\t90");
        System.out.println("Paladin\t\t40\t30\t120");
        System.out.println("Mage\t\t45\t10\t80");
        System.out.println("Hunter\t\t25\t20\t110");
        System.out.println("Enter class name: ");
    }
}

