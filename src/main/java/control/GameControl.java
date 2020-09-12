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

    public static void moveUp (){
        int newValues = start.get(0)[0] - 1;
        int oldValue = start.get(0)[1];
        start = new ArrayList<>();
        start.add(new int[]{newValues, oldValue});
        if (start.get(0)[0] == 0 || start.get(0)[1] == 0 || start.get(0)[0] == 9 || start.get(0)[1] == 9)
            play = false;
        System.out.println(start.get(0)[0]);
    }

    public static void moveDown (){
        int newValues = start.get(0)[0] + 1;
        int oldValue = start.get(0)[1];
        start = new ArrayList<>();
        start.add(new int[]{newValues, oldValue});
        if (start.get(0)[0] == 0 || start.get(0)[1] == 0 || start.get(0)[0] > limitVirt || start.get(0)[1] > limitVirt)
            play = false;
        System.out.println(start.get(0)[0]);    
    }

    public static void moveLeft (){
        int newValues = start.get(0)[1] - 1;
        int oldValue = start.get(0)[0];
        start = new ArrayList<>();
        start.add(new int[]{oldValue, newValues});
        if (start.get(0)[0] == 0 || start.get(0)[1] == 0 || start.get(0)[0] == 9 || start.get(0)[1] == 9)
            play = false;
        System.out.println(start.get(0)[1]);
    }

    public static void moveRight (){
        int newValues = start.get(0)[1] + 1;
        int oldValue = start.get(0)[0];
        start = new ArrayList<>();
        start.add(new int[]{oldValue, newValues});
        if (start.get(0)[0] == 0 || start.get(0)[1] == 0 || start.get(0)[0] == 9 || start.get(0)[1] == 9)
            play = false;
        System.out.println(start.get(0)[1]);
    }
}