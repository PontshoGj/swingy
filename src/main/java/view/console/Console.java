 package view.console;

import model.tracker.*;
import java.util.Scanner;

import model.data.*;
import view.gui.*;
import control.*;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Console {
    private static Db           conn = new Db();
    private static GameControl  game = GameControl.getInc();
    
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be null")
    private String              name;

    public String start (){
        System.out.println("u -- New user: ");
        System.out.println("s -- Select user: ");
        System.out.println("v -- Switch views: ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        switch (choice){
            case "u":{
                // User person = new User();
                // person.createUser();
                return "console";
                // break;
            }
            case "s":
                return "select";
                // selecUser();
                // System.exit(1);
                // break;
            // case "v":{
            //     Gui gui = new Gui();
            //     gui.start();
            //     break;
            // }
        }
        return "console";
    }

    public String newUser(){

        System.out.println("Enter your name: ");
        Scanner inputname = new Scanner(System.in);
        name = inputname.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        return name;
    }
    public String userClass(){
        
        Scanner inputclass = new Scanner(System.in);
        String heroClass = inputclass.nextLine();
        return heroClass;
    }

    public void selecUser(){
        conn.getPlayers();

        // int player = input.
    }

    public int getplayernum(){
        System.out.println("Please enter the number to select player");
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.next());
        return num;
    }
    public char move(){
        int Y = game.getPositionY();
        int X = game.getPositionX();
        System.out.println("Your current position is: " + Y + ", " + X);
        System.out.println("Press n or s or e or w to move:");
        Scanner inputclass = new Scanner(System.in);
        char heroClass = inputclass.next().charAt(0);
        System.out.print("\033[H\033[2J");
        System.out.flush();
        return (heroClass);
    }
}