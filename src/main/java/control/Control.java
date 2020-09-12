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
    private static int      level = 0;
    private static String [] info = null;
    private static GameControl game = GameControl.getInc();
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
        while (i < 3){
            switch (views){
                case "gui":{
                    guiview();
                    break;
                }
                case "console":{
                    consoleview();
                    break;
                }
            }
            if (views == null)
                break;
        }

        // GameControl game = GameControl.getInc();
        // game.level(1);
        // game.moveUp();
        // game.moveDown();

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
                info = person.UserClass(userclass, userid);
                level = Integer.parseInt(info[5]);
                // System.out.println(info[5]);
                i++;
                break;
            }
            case 2:{
                game.level(level);
                while (game.getPlay()){
                    char m = console.move();
                    if (m == 'n')
                        game.moveUp();
                    else if (m == 's')
                        game.moveDown();
                    else if (m == 'e')
                        game.moveLeft();
                    else if (m == 'w')
                        game.moveRight();
                    else
                        System.out.println("choose");
                }
                i++;
                
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
