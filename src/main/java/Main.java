package src.main.java;

// import javax.swing.*;
import control.Control;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1 || (!args[0].equals("console") && !args[0].equals("gui"))) {
            System.out.println("Usage: program console | gui");
            System.exit(1);
        }
        Control game = Control.getInc();
        game.start(args[0]);

    }
}
