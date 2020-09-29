package control;

import model.tracker.*;
import model.data.*;
import view.gui.*;
import view.console.*;
import javax.validation.Valid;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
            gui.start();
        }else{
            views = "console";
            console.start();
        }
        while (i < 3){
            switch (views){
                case "console":{
                    consoleview();
                    break;
                }
            }
            if (views == null || views == "gui")
                break;
        }
    }
    
    public static void guiview(){
        switch (i){
            case 0:{
                gui.NewUser();
                    i++;
                break;
            }
            case 1:{
                gui.NewClass();
                i++;
                break;
            }
        }
    }

    public static void consoleview(){
        try {
            switch (i){
                case 0:{
                    // @Valid
                    username = console.newUser();
                    // BindingResult result;
                    userid = person.UserName(username);
                    i++;
                    break;
                }
                case 1:{
                    person.options();
                    userclass = console.userClass();
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    info = person.UserClass(userclass, userid);
                    level = Integer.parseInt(info[5]);
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
                            System.out.println("choose the correct value");
                    }
                    i++;
                    
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
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
        info = person.UserClass(userclass, userid);
        level = Integer.parseInt(info[5]);
        guistage++;
        i++;
    }
    public static int getuser(){
        return userid;
    }
    public static int getlevel(){
        return level;
    }
    public static void setuser(int id){
        info = person.getplayer(id);
        level = Integer.parseInt(info[5]);
        // System.out.println(id);
        userid = id;
    }
    // public static int setlevel(){

    // }
    // public static void setid(){

    // }
}
