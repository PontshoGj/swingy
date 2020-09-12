package view.console;

import model.tracker.*;
import java.util.Scanner;

import model.data.*;
import view.gui.*;
import control.*;
import java.util.ArrayList;
import java.util.List;


public class Console {
    private static Db       conn = new Db();
    private static GameControl game = GameControl.getInc();

    public void start (){
        System.out.println("u -- New user: ");
        System.out.println("s -- Select user: ");
        System.out.println("v -- Switch views: ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        switch (choice){
            case "u":{
                // User person = new User();
                // person.createUser();
                break;
            }
            case "s":
                selecUser();
                System.exit(1);
                break;
            case "v":{
                Gui gui = new Gui();
                gui.start();
                break;
            }
        }
    }

    public String newUser(){

        System.out.println("Enter your name: ");
        Scanner inputname = new Scanner(System.in);
        String name = inputname.nextLine();
        return name;
    }

    public String userClass(){
        
        Scanner inputclass = new Scanner(System.in);
        String heroClass = inputclass.nextLine();
        return heroClass;
    }

    public void selecUser(){
        conn.getPlayers();
    }

    public char move(){
        int Y = game.getPositionY();
        int X = game.getPositionX();
        System.out.println("Your current position is: " + Y + ", " + X);
        System.out.println("Press n or s or e or w to move:");
        Scanner inputclass = new Scanner(System.in);
        char heroClass = inputclass.next().charAt(0);

        return (heroClass);
    }
}