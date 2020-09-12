package control;

import model.tracker.*;
import model.data.*;
import view.gui.*;
import view.console.*;
import java.util.ArrayList;
import java.util.List;

public class GameControl {

    // private static List<int[]>  limits = new ArrayList<>();
    private static int          limitHori = 1;
    private static int          limitVirt;
    private static List<int[]>  start = new ArrayList<>();
    private static GameControl  gamecontrol = null;

    private GameControl() {}
    
    public static GameControl getInc(){
        if (gamecontrol == null)
            gamecontrol = new GameControl();
        return (gamecontrol);
    }

    public static void level (int level){
        int map = (level - 1) * 5 + 10 - (level % 2);
        int midpoint = (map / 2) + 1;
        start.add(new int[]{midpoint, midpoint});
        limitVirt = map;
        // System.out.println(map);

        // System.out.println(start.get(0)[0]);
        // System.out.println(start.get(0)[1]);
    }
}