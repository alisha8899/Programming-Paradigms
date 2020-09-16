import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.text.*;

public class TestMenu
{
   public static void main(String [] args)
   {
      Menu m1= new Menu();
      
   }
}



class Menu extends JFrame 
{
    private Container c;
	private JLabel titleLabel;
	private JLabel backgroundImageLabel;
	private JLabel comboxLabel;
	private JPanel comboxPanel;
	private JPanel backgroundImagePanel;
	private JPanel textFileAndLabelPanel;
	private JPanel btnPanelAndCheckBox;
	private JPanel checkboxAndComBoxPanel;
	private JPanel wholePanel;
	private JTextField textField_Of_Player_One;
	private JTextField textField_Of_Player_two;
	private JButton btn_Start_Game;
	private JButton btn_Ext_Game;
	private JLabel lable_Of_Player_One;
	private JLabel lable_Of_Player_two;

    private  JComboBox<String> combox_difficulty;
    private int difficulty;
   
    public Menu()
    {
        c=getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.CENTER));//set layout for window....
		backgroundImageLabel=new JLabel(new ImageIcon("snakeBack.png"));
		backgroundImagePanel=new JPanel();
		checkboxAndComBoxPanel = new JPanel();
		checkboxAndComBoxPanel.setLayout(new GridLayout(1,1));
		backgroundImagePanel.setLayout(new FlowLayout());
		backgroundImagePanel.add(backgroundImageLabel);
		textFileAndLabelPanel= new JPanel();
		btnPanelAndCheckBox =new JPanel();
		textFileAndLabelPanel.setLayout(new GridLayout(2,2));//set panel layout to GridLayout...
		btnPanelAndCheckBox.setLayout(new GridLayout(1,2));
		//Add textfield and label to panel...
		lable_Of_Player_One = new JLabel("Enter Player #1 Name:");
        lable_Of_Player_two = new JLabel("Enter Player #2 Name:");
		textField_Of_Player_One = new JTextField(20);
		textField_Of_Player_two = new JTextField(20);
		textField_Of_Player_two.setDisabledTextColor(Color.GRAY);
		textFileAndLabelPanel.add(lable_Of_Player_One);
		textFileAndLabelPanel.add(textField_Of_Player_One);
		textFileAndLabelPanel.add(lable_Of_Player_two);
		textFileAndLabelPanel.add(textField_Of_Player_two);
		//c.add(textFileAndLabelPanel);
		//End of add..
        btn_Start_Game = new JButton("START YOUR GAME");
		
		btn_Start_Game.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{

				  	    if(textField_Of_Player_One.getText().equals(""))
				  	   {

					           JOptionPane.showConfirmDialog(null,"Please fill the first textfield...","Warnning",JOptionPane.DEFAULT_OPTION);
				  	   }
				  	   else if(textField_Of_Player_two.getText().equals(""))
				  	   {

					           JOptionPane.showConfirmDialog(null,"Please fill the Second textfield...","Warnning",JOptionPane.DEFAULT_OPTION);
				  	   }
				  	   else
				  	   {
				  	   	       
				  	   	    difficulty=combox_difficulty.getSelectedIndex();
                            if(difficulty==0)
                            {
                            	difficulty=100;
                            }
                            else if(difficulty==1)
                            {
                            	difficulty=75;
                            }
                            else
                            {
                            	difficulty=50;
                            }
                            setVisible(false);
				  	   	    JFrame snakegame= new SnakeGame(2,difficulty);
                    

				  	   }

				  }
			}
		);
      		
		btn_Ext_Game = new JButton("Exit");
		
		
		btn_Ext_Game.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				   if (JOptionPane.showConfirmDialog(null, "Do You Really Want to exit?","Exit?", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION)
				 {
					 JOptionPane.showConfirmDialog(null,"Written By LI_HING.\n"+"04/26/2017.\n"+"LI_HING@student.smc.edu\n","See You!",JOptionPane.DEFAULT_OPTION);
					 System.exit(0);
				 }
			}
		});


        textField_Of_Player_One.addFocusListener(new FocusListener() {
           public void focusGained(FocusEvent e) 
           {
              textField_Of_Player_One.setBackground(Color.YELLOW);
           }

           public void focusLost(FocusEvent e) {
              textField_Of_Player_One.setBackground(Color.WHITE);
           }

		});


		textField_Of_Player_two.addFocusListener(new FocusListener() {
           public void focusGained(FocusEvent e) 
           {
              textField_Of_Player_two.setBackground(Color.YELLOW);
           }

           public void focusLost(FocusEvent e) {
              textField_Of_Player_two.setBackground(Color.WHITE);
           }

		});

		btnPanelAndCheckBox.add(btn_Start_Game,BorderLayout.WEST);
		btnPanelAndCheckBox.add(btn_Ext_Game,BorderLayout.EAST);

		titleLabel =  new JLabel("Welcome to the snake game");
		titleLabel.setFont(new Font("Arial",Font.BOLD,40));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setOpaque(false);

		String [] strdifficulty ={"Ez","Normal","Hard"};
        combox_difficulty=new JComboBox<String>(strdifficulty);
        comboxLabel =new JLabel("Difficulty:");
		comboxPanel = new JPanel();
		comboxPanel.setLayout(new FlowLayout());
		comboxLabel.setFont(new Font("Arial",Font.BOLD,15));

		comboxPanel.add(comboxLabel);
		comboxPanel.add(combox_difficulty);
	    checkboxAndComBoxPanel.add(comboxPanel);
	
		wholePanel = new JPanel();
		wholePanel.setLayout(new GridLayout(5,1));
		wholePanel.add(titleLabel);
		wholePanel.add(textFileAndLabelPanel);
		wholePanel.add(checkboxAndComBoxPanel);
		wholePanel.add(btnPanelAndCheckBox);
		wholePanel.setBorder(BorderFactory.createLineBorder(Color.yellow,5));
		wholePanel.setBackground(new Color(192,192,192));
		c.setBackground(new Color(192,192,192));
		c.add(backgroundImagePanel);
		c.add(wholePanel);
        setSize(1280,1000);
		setVisible(true);
    }
    
}


