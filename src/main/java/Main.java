package src.main.java;

// import javax.swing.*;
import gui.*;
import console.*;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1 || (!args[0].equals("console") && !args[0].equals("gui"))) {
            System.out.println("Usage: program console | gui");
            System.exit(1);
        }else if (args[0].equals("gui")){
            // System.out.println("good");
            Gui gui = new Gui();
            gui.start();
        }else{
            Console console = new Console();
            console.start();
        }

    }
}
