package control;

import model.tracker.*;
import model.data.*;
import view.gui.*;
import view.console.*;


public class Control {

    private static String   username;
    private static String   userclass;
    private static int      i = 0;
    private static String   views;
    private static Gui      gui = new Gui();
    private static Console  console = new Console();
    private static User     person = new User(); 
    private static Control  con = null;
    private static int      guistage = 0;
    private static int      userid;

    private Control(){}

    public static Control getInc(){
        if (con == null)
            con = new Control();
        return (con);
    }
    public static void start(String args) {
        if (args.equals("gui")){
            views = "gui";
            // System.out.println("good");
            gui.start();
        }else{
            views = "console";
            console.start();
        }
        // while (i < 2){
        //     switch (views){
        //         case "gui":{
        //             guiview();
        //             break;
        //         }
        //         case "console":{
        //             consoleview();
        //             break;
        //         }
        //     }
        //     if (views == null)
        //         break;
        // }
        GameControl game = GameControl.getInc();
        game.level(1);

    }
    
    public static void guiview(){
        switch (i){
            case 0:{
                gui.NewUser();
                if (guistage == 1){
                    i++;
                    break;
                }
            }
            case 1:{
                gui.NewClass();
                if (guistage == 2){
                    i++;
                    break;
                }
            }
        }
    }

    public static void consoleview(){
        switch (i){
            case 0:{
                username = console.newUser();
                userid = person.UserName(username);
                i++;
                break;
            }
            case 1:{
                person.options();
                userclass = console.userClass();
                person.UserClass(userclass, userid);
                i++;
                break;
            }
        }
    }

    public static void updateName(String name){
        username = name;
        userid = person.UserName(username);
        guistage++;
        i++;
    }
    public static void updateClass(String name){
        userclass = name;
        person.UserClass(userclass, userid);
        guistage++;
        i++;
    }
}
