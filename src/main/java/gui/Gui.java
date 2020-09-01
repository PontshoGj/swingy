package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gui extends JFrame implements ActionListener {

    private boolean startV = true;
    private boolean NewV = false;
    private static final int	SCREEN_HEIGHT = 500;
	private static final int	SCREEN_WIDTH = 500;
    private JFrame frame = new JFrame("My First GUI");
 
    public void Gui(){

    }
    public void start(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(this.SCREEN_HEIGHT,this.SCREEN_WIDTH);
        this.getContentPane().setLayout(new GridLayout(3, 1)); // Adds Button to content pane of frame
        JButton CreateButton = new JButton("Create new user");
        CreateButton.setSize(30,30);
        CreateButton.addActionListener(this);
        this.getContentPane().add(CreateButton); // Adds Button to content pane of frame

        JButton SelectButton = new JButton("Select from list");
        this.getContentPane().add(SelectButton); // Adds Button to content pane of frame

        JButton SwitchButton = new JButton("Switch to Console");
        this.getContentPane().add(SwitchButton); // Adds Button to content pane of frame
        // frame.pack();
        this.setVisible(this.startV);
    }
    
    public void NewUser(){
        this.getContentPane().removeAll();
        this.repaint();
    //     JFrame frame = new JFrame("My First GUI");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setSize(this.SCREEN_HEIGHT,this.SCREEN_WIDTH);

        frame.getContentPane().setLayout(new GridLayout(3, 1)); // Adds Button to content pane of frame
    //     JButton CreateButton = new JButton("Create new use");
    //     CreateButton.setSize(30,30);
    //     frame.getContentPane().add(CreateButton); // Adds Button to content pane of frame

        JButton SelectButton = new JButton("Select from list");
        this.getContentPane().add(SelectButton); // Adds Button to content pane of frame

    //     // JButton SwitchButton = new JButton("Switch to Console");
    //     // frame.getContentPane().add(SwitchButton); // Adds Button to content pane of frame
    //     // frame.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        // this.startV = false;
        // this.NewV = true;
        this.NewUser();
        System.out.println(e);
    }
}

// private class Nuser implements ActionListener{
//     public void actionPerformed(ActionEvent e){
//     //     this.getContentPane().removeAll();
//     //     this.repaint();
//     // //     JFrame frame = new JFrame("My First GUI");
//     // //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     // //     frame.setSize(this.SCREEN_HEIGHT,this.SCREEN_WIDTH);

//     //     this.getContentPane().setLayout(new GridLayout(3, 1)); // Adds Button to content pane of frame
//     // //     JButton CreateButton = new JButton("Create new use");
//     // //     CreateButton.setSize(30,30);
//     // //     frame.getContentPane().add(CreateButton); // Adds Button to content pane of frame

//     //     JButton SelectButton = new JButton("Select from list");
//     //     this.getContentPane().add(SelectButton); // Adds Button to content pane of frame

//     // //     // JButton SwitchButton = new JButton("Switch to Console");
//     // //     // frame.getContentPane().add(SwitchButton); // Adds Button to content pane of frame
//     // //     // frame.pack();
//     //     this.setVisible(true);
//         System.out.println(e);

//     }
// }