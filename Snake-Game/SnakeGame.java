
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.text.*;
import java.awt.*;
import javax.swing.Timer;

class SnakeGame extends JFrame implements ActionListener
{
	private Container c;
	private int snakeLength =1;
	private LinkedList<Point> snakeBody = new LinkedList<Point>();
	private Point pointSnakeHead;
	private Random random = new Random();
	private Snake snake;
	private int is_two_player_game;
	private int difficulty;
    private Timer timer;
    
	public SnakeGame(int is_two_player_game, int difficulty)
	{

		this.is_two_player_game = is_two_player_game;

		this.difficulty = difficulty;

        timer=new Timer(difficulty,this);
		addKeyListener(new KeyInput(this));
	    Toolkit toolkit = Toolkit.getDefaultToolkit();
		c = getContentPane();
		setBackground(Color.WHITE);

		snake = new Snake(is_two_player_game);
		c.add(snake);
		setVisible(true);	
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(((int)toolkit.getScreenSize().getWidth()-1000)/2,((int)toolkit.getScreenSize().getHeight()-1000)/2,1000,1000);
        timer.start();
	
	}
	public void keyPressed(KeyEvent e)
    {
       int temp_key =e.getKeyCode();

 if(is_two_player_game==2)
       {
           if(temp_key == KeyEvent.VK_UP)
     	   {
     		 snake.setUp_two();
     	   }
     	   else if(temp_key == KeyEvent.VK_DOWN)
     	   {
     		 snake.setDown_two();
     	   }
     	   else if(temp_key == KeyEvent.VK_LEFT)
     	   {
             snake.setLeft_two();
           }
     	   else if(temp_key == KeyEvent.VK_RIGHT)
     	   {
     		  snake.setRight_two();

     	   }
     	   else if(temp_key == KeyEvent.VK_W)
     	   {
     		
               snake.setUp_one();
     	   }
     	   else if(temp_key == KeyEvent.VK_A)
     	   {
     		  snake.setLeft_one();
     	   }
     	   else if(temp_key == KeyEvent.VK_S)
     	   {
     		  snake.setDown_one();
     	   }
     	   else if(temp_key == KeyEvent.VK_D)
     	   {
     		  snake.setRight_one();
     	   }
     	   else if(temp_key == KeyEvent.VK_ENTER)
     	   {
     		  snake.reStart_the_game();
     	   }
     	   else if(temp_key ==  KeyEvent.VK_ESCAPE)
     	   {
     		  snake.setStop();

     		     if (JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit?", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION)
				 {
					 System.exit(0);
				 }
				 else
				 {
					 snake.setStart();
				 }

     	   }
        }
	 }
   
	
   @Override
   public void actionPerformed(ActionEvent args)
   {
	   snake.repaint();
   }
}

class KeyInput extends KeyAdapter
{
	 SnakeGame game;
	 public KeyInput(SnakeGame game)
	 {
         this.game = game;

	 }
     public void keyPressed(KeyEvent e)
     {
          game.keyPressed(e);

     }

}
