package tracker;

import data.*;
import java.util.Scanner;

public class User{
    public void createUser(){
        options();
    }
    
    public void createHero(String name){
        Logs log = new Logs().getLogs();
        log.wirteLog(name);
    }

    public void options(){
        System.out.println("Enter your name: ");
        Scanner inputname = new Scanner(System.in);
        String name = inputname.nextLine();
        System.out.println("Classes:\tattack\tdefense\thp");
        System.out.println("Warrior\t\t40\t20\t100");
        System.out.println("Shaman\t\t30\t15\t90");
        System.out.println("Priest\t\t25\t25\t90");
        System.out.println("Paladin\t\t40\t30\t120");
        System.out.println("Mage\t\t45\t10\t80");
        System.out.println("Hunter\t\t25\t20\t110");
        System.out.println("Enter class name: ");
        Scanner inputclass = new Scanner(System.in);
        String heroClass = inputclass.nextLine();
        switch (heroClass){
            case "warrior":{
                createHero(name+":warrior:40:20:100");
                // person.createHero("attack:40");
                // person.createHero("defence:20");
                // person.createHero("hp:100");
                createHero("");
                break;
            }
            case "shaman":{
                createHero(name+":shaman:30:15:90");
                // person.createHero("attack:30");
                // person.createHero("defence:15");
                // person.createHero("hp:90");
                createHero("");
                break;
            }
            case "priest":{
                createHero(name+":priest:25:25:90");
                // person.createHero("attack:25");
                // person.createHero("defence:25");
                // person.createHero("hp:90");
                createHero("");
                break;
            }
            case "paladin":{
                createHero(name+":paladin:40:30:120");
                // person.createHero("attack:40");
                // person.createHero("defence:30");
                // person.createHero("hp:120");
                createHero("");
                break;
            }
            case "mage":{
                createHero(name+":mage:45:10:80");
                // person.createHero("attack:45");
                // person.createHero("defence:10");
                // person.createHero("hp:80");
                createHero("");
                break;
            }
            case "hunter":{
                createHero(name+":hunter:25:20:110");
                // person.createHero("attack:25");
                // person.createHero("defence:20");
                // person.createHero("hp:110");
                createHero("");
                break;
            }
        }
    }
}
