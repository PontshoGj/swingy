package console;

import tracker.*;
import java.util.Scanner;

import data.*;
import gui.*;

public class Console {

    public void start (){
        System.out.println("u -- New user: ");
        System.out.println("s -- Select user: ");
        System.out.println("v -- Switch views: ");
        Scanner input = new Scanner(System.in);
        String choise = input.nextLine();
        switch (choise){
            case "u":{
                User person = new User();
                person.createUser();
                break;
            }
            case "s":
                System.exit(1);
                break;
            case "v":{
                Gui gui = new Gui();
                gui.start();
                break;
            }
        }
    }
}