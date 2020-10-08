package control;

import model.tracker.*;
import model.data.*;
import view.gui.*;
import view.console.*;
import java.util.ArrayList;
import java.util.List;

public class GameControl {

    private static int          limitHori = 0;
    private static int          limitVirt;
    private static List<int[]>  start = new ArrayList<>();
    private static GameControl  gamecontrol = null;
    private static int          midpoint = 0;
    private static boolean      play = true;
    private static Control      control = Control.getInc();
    private static Db           conn = new Db();

    private GameControl() {}
    
    public static GameControl getInc(){
        if (gamecontrol == null)
            gamecontrol = new GameControl();
        return (gamecontrol);
    }

    public static boolean getPlay(){
        return play;
    }

    public static int  getPositionY (){
        return start.get(0)[0];
    }

    public static int  getPositionX (){
        return start.get(0)[1];
    }

    public static void level (int level){
        int map = (level - 1) * 5 + 10 - (level % 2);
        midpoint = (map / 2) + 1;
        start.add(new int[]{midpoint, midpoint});
        limitVirt = map;
    }

    public static void moveUp (int level, int id){
        if ((start.get(0)[0] == 0 || start.get(0)[1] == 0 || start.get(0)[0] > limitVirt || start.get(0)[1] > limitVirt) && control.getlevel() < 7){
            // System.out.println("aaa");
            conn.updateLevel(level, id);
            control.updatelevel();

            play = false;
        }else if(control.getlevel() >= 7){
        }
        int newValues = start.get(0)[0] - 1;
        int oldValue = start.get(0)[1];
        start = new ArrayList<>();
        start.add(new int[]{newValues, oldValue});
    }

    public static void moveDown (int level, int id){
        if ((start.get(0)[0] == 0 || start.get(0)[1] == 0 || start.get(0)[0] > limitVirt || start.get(0)[1] > limitVirt) && control.getlevel() < 7){
            // System.out.println("aaa");
            conn.updateLevel(level, id);
            control.updatelevel();

            play = false;
        }else if(control.getlevel() >= 7){
        }
        int newValues = start.get(0)[0] + 1;
        int oldValue = start.get(0)[1];
        start = new ArrayList<>();
        start.add(new int[]{newValues, oldValue});
    }

    public static void moveLeft (int level,int id){
        if ((start.get(0)[0] == 0 || start.get(0)[1] == 0 || start.get(0)[0] > limitVirt || start.get(0)[1] > limitVirt) && control.getlevel() < 7){
            // System.out.println("aaa");
            conn.updateLevel(level, id);
            control.updatelevel();
            
            play = false;
        }else if(control.getlevel() >= 7){
        }
        int newValues = start.get(0)[1] - 1;
        int oldValue = start.get(0)[0];
        start = new ArrayList<>();
        start.add(new int[]{oldValue, newValues});
    }

    public static void moveRight (int level, int id){
        if ((start.get(0)[0] == 0 || start.get(0)[1] == 0 || start.get(0)[0] > limitVirt || start.get(0)[1] > limitVirt) && control.getlevel() < 7){
            // System.out.println("aaa");
            conn.updateLevel(level, id);
            control.updatelevel();

            play = false;
        }else if(control.getlevel() >= 7){
        }
        int newValues = start.get(0)[1] + 1;
        int oldValue = start.get(0)[0];
        start = new ArrayList<>();
        start.add(new int[]{oldValue, newValues});
    }
}