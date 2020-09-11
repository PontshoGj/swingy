package control;

import model.tracker.*;
import model.data.*;
import view.gui.*;
import view.console.*;

public class GameControl {

    // private static int [];

    public static void level (int level){
        int map = (level - 1) * 5 + 10 - (level % 2);
        int midpoint = (map / 2) + 1;
        // System.out.println(midpoint);
        int limit [][];

        for (int i = 1; i <= map; i++){
            System.out.println(limit);
        }
    }
}