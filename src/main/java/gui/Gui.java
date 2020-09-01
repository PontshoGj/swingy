package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame {

    // private static JPanel       f   = new JPanel();
    private boolean startV = true;
    private boolean NewV = false;
    private static final int	SCREEN_HEIGHT = 500;
	private static final int	SCREEN_WIDTH = 500;
    private static JButton      CreateButton = new JButton("Create new user");
    private static JButton      SelectButton = new JButton("Select from list");
    private static JButton      SwitchButton = new JButton("Switch to Console"); 
    private static JButton      NextButton = new JButton("Next"); 
    private static JButton      StartButton = new JButton("Start"); 
    private static JLabel       NameLabel = new JLabel("Enter a name");
    private static JLabel       ClassLabel = new JLabel("Enter a class");
    private static JTextField   NameTextField = new JTextField();
    private static JTextField   ClassTextField = new JTextField();
    private static String       data[][] = {{"Warrior", "40", "20", "100"},
                                            {"Shaman", "30", "15", "90"},
                                            {"Priest", "25", "25","90"},
                                            {"Paladin", "40", "30", "120"},
                                            {"Mage", "45", "10", "80"},
                                            {"Hunter", "25", "20", "110"}
                                            };
    private static String       column[] = {"Classes", "attack", "defense", "hp"};
    private static JTable       ClassTable = new JTable(data, column);
    private static JScrollPane  sp = new JScrollPane(ClassTable);    
    private static JFrame       frame = new JFrame("My First GUI");
 
    public void Gui(){

    }
    public void start(){
        // f.add(frame);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(this.SCREEN_HEIGHT,this.SCREEN_WIDTH);
        this.getContentPane().setLayout(new GridLayout(3, 1)); // Adds Button to content pane of frame

        // Adds Button to content pane of frame
        CreateButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                NewUser();
                // System.out.println("a");
            }
        });
        this.getContentPane().add(CreateButton); 

        // Adds Button to content pane of frame
        SelectButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("b");
            }
        });
        this.getContentPane().add(SelectButton); 

        // Adds Button to content pane of frame
        SwitchButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("h");
            }
        });
        this.getContentPane().add(SwitchButton); 

        // frame.pack();
        this.setVisible(this.startV);
    }
    
    public void NewUser(){
        this.getContentPane().removeAll();
        this.repaint();
        this.getContentPane().add(NameLabel); // Adds Button to content pane of frame
        this.getContentPane().add(NameTextField); // Adds Button to content pane of frame
        NextButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // System.out.println("d");
                NewClass();
            }
        });
        this.getContentPane().add(NextButton); // Adds Button to content pane of frame

        this.setVisible(true);
    }

    public void NewClass(){
        this.getContentPane().removeAll();
        this.repaint();
        this.getContentPane().setLayout(new GridLayout(4, 1)); // Adds Button to content pane of frame
        this.getContentPane().add(ClassLabel); // Adds Button to content pane of frame
        // ClassLabel.setCellSelectionEnabled(true);  
        this.getContentPane().add(sp); // Adds Button to content pane of frame
        this.getContentPane().add(ClassTextField); // Adds Button to content pane of frame
        this.getContentPane().add(StartButton); // Adds Button to content pane of frame
        this.setVisible(true);

    }
}