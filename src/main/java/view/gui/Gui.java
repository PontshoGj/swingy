package view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.*;
import control.*;
import model.tracker.*;

public class Gui extends JFrame {

    private boolean startV = true;
    private boolean NewV = false;
    private static final int	SCREEN_HEIGHT = 500;
	private static final int	SCREEN_WIDTH = 500;
    private static JButton      CreateButton = new JButton("Create new user");
    private static JButton      SelectButton = new JButton("Select from list");
    private static JButton      SwitchButton = new JButton("Switch to Console"); 
    private static JButton      NButton = new JButton("Move North"); 
    private static JButton      SButton = new JButton("Move South"); 
    private static JButton      WButton = new JButton("Move West"); 
    private static JButton      EButton = new JButton("Move East"); 
    private static JButton      NextButton = new JButton("Next"); 
    private static JButton      StartButton = new JButton("Start"); 
    private static JLabel       NameLabel = new JLabel("Enter a name");
    private static JLabel       ClassLabel = new JLabel("Select class from list");
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
    private static GameControl  game = GameControl.getInc();
    private static Control      control = Control.getInc();
    private static Db           conn = new Db(); 

    public void Gui(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(this.SCREEN_HEIGHT,this.SCREEN_WIDTH);
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
                SelectUser();
            }
        });
        this.getContentPane().add(SelectButton); 

        // Adds Button to content pane of frame
        SwitchButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // System.out.println("h");
                SwitchViews();
            }
        });
        // this.getContentPane().add(SwitchButton); 

        // frame.pack();
        this.setVisible(this.startV);
    }
    
    public void NewUser(){
        this.getContentPane().removeAll();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(this.SCREEN_HEIGHT,this.SCREEN_WIDTH);
        
        this.repaint();
        this.getContentPane().add(NameLabel); // Adds Button to content pane of frame
        this.getContentPane().add(NameTextField); // Adds Button to content pane of frame

        NextButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (NameTextField.getText() == null || NameTextField.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Please enter name");
                }else{

                    NewClass();

                    control.updateName(NameTextField.getText());
                }
            }
        });
        this.getContentPane().add(NextButton); // Adds Button to content pane of frame

        this.setVisible(true);
    }

    public void NewClass(){
        this.getContentPane().removeAll();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(this.SCREEN_HEIGHT,this.SCREEN_WIDTH);
        this.repaint();
        this.getContentPane().setLayout(new GridLayout(2, 1)); // Adds Button to content pane of frame
        this.getContentPane().add(ClassLabel); // Adds Button to content pane of frame
        // ClassLabel.setCellSelectionEnabled(true);  

        JTable       PlayTable = new JTable(data, column){
            public boolean editCellAt(int row, int column, java.util.EventObject e){
                return false;
            }
        };
        PlayTable.setFocusable(false);
        PlayTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                // System.out.println(e.getSource());
                JTable value = (JTable)e.getSource();
                int row = value.getSelectedRow();
                int column = value.getSelectedRow();
                control.updateClass(PlayTable.getValueAt(row, column - column).toString());
                game.level(control.getlevel());
                Gameplay();
                // System.out.println(PlayTable.getValueAt(row, column));
            }
        });
        JScrollPane  sps = new JScrollPane(PlayTable); 
        this.getContentPane().add(sps);
        
        this.setVisible(true);

    }
    public void Gameplay(){
        this.getContentPane().removeAll();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(this.SCREEN_HEIGHT,this.SCREEN_WIDTH);
        this.repaint();
        JLabel       PositionLabel = new JLabel("Your Position is " + game.getPositionY() + ", " + game.getPositionX());
        this.getContentPane().add(PositionLabel); // Adds Button to content pane of frame
        NButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                game.moveUp(control.getlevel(), control.id());
                Gameplay();
                if (!game.getPlay())
                    // conn.updateXp();
                    System.exit(0);
            }
        });
        this.getContentPane().add(NButton); // Adds Button to content pane of frame
        SButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                game.moveDown(control.getlevel(), control.id());
                if (!game.getPlay())
                    // conn.updateXp();
                    System.exit(0);
                Gameplay();
            }
        });
        this.getContentPane().add(SButton); // Adds Button to content pane of frame
        WButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                game.moveLeft(control.getlevel(), control.id());
                if (!game.getPlay())
                    // conn.updateXp();
                    System.exit(0);
                Gameplay();
            }
        });
        this.getContentPane().add(WButton); // Adds Button to content pane of frame
        EButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                game.moveRight(control.getlevel(), control.id());
                if (!game.getPlay())
                    // conn.updateXp();
                    System.exit(0);
                Gameplay();
            }
        });
        this.getContentPane().add(EButton); // Adds Button to content pane of frame
        this.setVisible(true);
    }

    //get and list available players for play to select
    public void SelectUser(){
        this.getContentPane().removeAll();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(this.SCREEN_HEIGHT,this.SCREEN_WIDTH);
        this.repaint();
        String       columns[] = {"id","Name","Classes", "attack", "defense", "hp", "level", "xp"};
        String       datas[][] = conn.getPlay();
        // System.out.println(datas[0][1]);
        JTable       PlayTable = new JTable(datas, columns){
            public boolean editCellAt(int row, int column, java.util.EventObject e){
                return false;
            }
        };
        PlayTable.setFocusable(false);
        PlayTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                // System.out.println(e.getSource());
                JTable value = (JTable)e.getSource();
                int row = value.getSelectedRow();
                int column = value.getSelectedRow();
                int vl = Integer.parseInt(PlayTable.getValueAt(row, column).toString());
                control.setuser(vl);
                game.level(control.getlevel());
                Gameplay();
                // System.out.println(PlayTable.getValueAt(row, column));
            }
        });
        JScrollPane  sps = new JScrollPane(PlayTable); 
        this.getContentPane().add(sps); // Adds Button to content pane of frame
        this.setVisible(true);
    }
    
    public void SwitchViews(){
        this.getContentPane().removeAll();
        this.repaint(); 

        this.setVisible(false);
    }
    
    public String getUserName(){
        return ("Pontsho");
    }
    
    public String getUserClass(){
        return "mage";
    }
}