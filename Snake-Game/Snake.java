import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;
import java.text.*;
import java.awt.*;
import javax.swing.Timer;

public class Snake extends JPanel implements Comparable
{
	private Point pointSnakeHead;
	long t = System.currentTimeMillis();
	private Random random = new Random(t);
	private Point snakeHead;
	private ImageIcon appleIcon;
	private ImageIcon snakeIcon_one;
	private ImageIcon snakeIcon_two;
	private ImageIcon background;
	private int size_one=2;
	private int size_two=2;
	private int max_size=16;
	private ImageIcon [] snake_Body_one = new ImageIcon[max_size];
	private ImageIcon [] snake_Body_two = new ImageIcon[max_size];
	private int [] tempX_Snake_one =new int[16];
	private int [] tempY_Snake_one =new int[16];
	private int [] tempX_Snake_two =new int[16];
	private int [] tempY_Snake_two =new int[16];
	private int tempX_Apple;
	private int tempY_Apple;
	private boolean left_one=false;
	private boolean background_picture_draw=true;
	private boolean right_one=true;
	private boolean up_one=false;
	private boolean down_one=false;
	private boolean left_two=false;
	private boolean right_two=true;
	private boolean up_two=false;
	private boolean down_two=false;
	private boolean stop=false;
	private boolean game_over=false;
	private int is_two_player_game;
	private String color;
	private int length;
	
	public Snake()
	{
		background=new ImageIcon("background.png");
        snakeIcon_one = new ImageIcon("rightmouth.png");
	    appleIcon = new ImageIcon("Apple.png");
	    for(int i=0;i<max_size;i++)
	    {
	    	snake_Body_one[i]=new ImageIcon("snakebody.png");
	    }
		
	    tempX_Snake_one[0]=(random.nextInt(40))*25;//save Head x information..
	    tempY_Snake_one[0]=(random.nextInt(40))*25;//save Head y information..
		tempX_Apple=(random.nextInt(15))*25;
		tempY_Apple=(random.nextInt(15))*25;
		

	} 
	public Snake(int is_two_player_game)
	{
		background=new ImageIcon("background.png");
		this.is_two_player_game=is_two_player_game;
        if(is_two_player_game==1)
        {
        	snakeIcon_one = new ImageIcon("rightmouth.png");
	        appleIcon = new ImageIcon("Apple.png");
	        for(int i=0;i<max_size;i++)
	        {
	    	  snake_Body_one[i]=new ImageIcon("snakebody.png");
	        }
	        tempX_Snake_one[0]=(random.nextInt(40))*25;//save Head x information..
	        tempY_Snake_one[0]=(random.nextInt(40))*25;//save Head y information..
		    tempX_Apple=(random.nextInt(15))*25;
		    tempY_Apple=(random.nextInt(15))*25;
        }
	    else if(is_two_player_game==2)
		{
            snakeIcon_one = new ImageIcon("rightmouth.png");
            snakeIcon_two = new ImageIcon("leftmouth_snake_two.png");
	        appleIcon = new ImageIcon("Apple.png");
	        for(int i=0;i<max_size;i++)
	        {
	    	  snake_Body_one[i]=new ImageIcon("snakebody.png");
	    	  snake_Body_two[i]=new ImageIcon("snakebody_snake_two.png");
	        }
	        tempX_Snake_one[0]=(random.nextInt(40))*25;//save Head x information..
	        tempY_Snake_one[0]=(random.nextInt(40))*25;//save Head y information..
	        tempX_Snake_two[0]=(random.nextInt(40))*25;
	        tempY_Snake_two[0]=(random.nextInt(40))*25;
	    //Make Sure Sanke One and Snake two are not in the same place...
	        while(tempX_Snake_one[0]==tempX_Snake_two[0]&&tempY_Snake_one[0]==tempY_Snake_two[0])
	        {
	    	  tempX_Snake_two[0]=(random.nextInt(40))*25;
	          tempY_Snake_two[0]=(random.nextInt(40))*25;
	        }
		    tempX_Apple=(random.nextInt(15))*25;
		    tempY_Apple=(random.nextInt(15))*25;
	    }
} 
	public int compareTo(Object s)
	{
		return (this.length - ((Snake)s).length);
	}
	
	protected void paintComponent(Graphics g)
	{
	  

	  if(!stop&&Check_If_Snake_Eat_Itself()==false&&!game_over&&Check_If_Snake_Touch_Each_Other()==false)
      {	
         
          super.paintComponent(g);
	      g.setColor(Color.BLACK);
	      g.fillRect(0,0,1000,1000);
	      if(background_picture_draw)
	      {
	      	background.paintIcon(this,g,0,0);
	      	//background_picture_draw=false;
	      }
	      //background.paintIcon(this,g,0,0);
	      appleIcon.paintIcon(this,g,tempX_Apple,tempY_Apple);
	      if(Check_if_Snake_Eat_Food())
	      {
		   	tempX_Apple=(random.nextInt(15))*25;
		    tempY_Apple=(random.nextInt(15))*25;
			appleIcon.paintIcon(this,g,tempX_Apple,tempY_Apple);
			
	      }
		  //For Snake one..
		  if(right_one)
		  {
		  	  snakeIcon_one= new ImageIcon("rightmouth.png");
			  if(tempX_Snake_one[0]>=1000)
			  {
				  tempX_Snake_one[0]=0;
			  }
			  snakeIcon_one.paintIcon(this,g,tempX_Snake_one[0]+25,tempY_Snake_one[0]);
			  for(int i=size_one;i>=1;i--)//Body strat from 1..
			  {
				  tempX_Snake_one[i]=tempX_Snake_one[i-1];
				  tempY_Snake_one[i]=tempY_Snake_one[i-1];
				  snake_Body_one[i-1].paintIcon(this,g,tempX_Snake_one[i],tempY_Snake_one[i]);
			  }
			  tempX_Snake_one[0]+=25;
			 
		  }
		  else if(left_one)
		  {
		  	   snakeIcon_one= new ImageIcon("leftmouth.png");
			  if(tempX_Snake_one[0]<=0)
			  {
				  tempX_Snake_one[0]=1000;
			  }
			  snakeIcon_one.paintIcon(this,g,tempX_Snake_one[0]-25,tempY_Snake_one[0]);
			  for(int i=size_one;i>=1;i--)//Body strat from 1..
			  {
				  tempX_Snake_one[i]=tempX_Snake_one[i-1];
				  tempY_Snake_one[i]=tempY_Snake_one[i-1];
				  snake_Body_one[i-1].paintIcon(this,g,tempX_Snake_one[i],tempY_Snake_one[i]);
			  }
			  tempX_Snake_one[0]-=25;
		  }
		  else if(up_one)
		  {
		  	  snakeIcon_one= new ImageIcon("upmouth.png");
			  if(tempY_Snake_one[0]<=0)
			  {
				  tempY_Snake_one[0]=1000;
			  }
			  snakeIcon_one.paintIcon(this,g,tempX_Snake_one[0],tempY_Snake_one[0]-25);
			  for(int i=size_one;i>=1;i--)//Body strat from 1..
			  {
				  tempX_Snake_one[i]=tempX_Snake_one[i-1];
				  tempY_Snake_one[i]=tempY_Snake_one[i-1];
				  snake_Body_one[i-1].paintIcon(this,g,tempX_Snake_one[i],tempY_Snake_one[i]);
			  }
			  tempY_Snake_one[0]-=25;
		  }
		  else if(down_one)
		  {
		  	   snakeIcon_one= new ImageIcon("downmouth.png");
			  if(tempY_Snake_one[0]>=1000)
			  {
				  tempY_Snake_one[0]=0;
			  }
			  snakeIcon_one.paintIcon(this,g,tempX_Snake_one[0],tempY_Snake_one[0]+25);
			  for(int i=size_one;i>=1;i--)//Body strat from 1..
			  {
				  tempX_Snake_one[i]=tempX_Snake_one[i-1];
				  tempY_Snake_one[i]=tempY_Snake_one[i-1];
				  snake_Body_one[i-1].paintIcon(this,g,tempX_Snake_one[i],tempY_Snake_one[i]);
			  }
			  tempY_Snake_one[0]+=25;
		  }


         if(is_two_player_game==2)
         {
         	 
            if(right_two)
		    {
			snakeIcon_two= new ImageIcon("rightmouth_snake_two.png");
			  if(tempX_Snake_two[0]>=1000)
			  {
				  tempX_Snake_two[0]=0;
			  }
			  snakeIcon_two.paintIcon(this,g,tempX_Snake_two[0]+25,tempY_Snake_two[0]);
			  for(int i=size_two;i>=1;i--)//Body strat from 1..
			  {
				  tempX_Snake_two[i]=tempX_Snake_two[i-1];
				  tempY_Snake_two[i]=tempY_Snake_two[i-1];
				  snake_Body_two[i-1].paintIcon(this,g,tempX_Snake_two[i],tempY_Snake_two[i]);
			  }
			  tempX_Snake_two[0]+=25;
			 
		  }
		  else if(left_two)
		  {
		  	 snakeIcon_two= new ImageIcon("leftmouth_snake_two.png");
			  if(tempX_Snake_two[0]<=0)
			  {
				  tempX_Snake_two[0]=1000;
			  }
			  snakeIcon_two.paintIcon(this,g,tempX_Snake_two[0]-25,tempY_Snake_two[0]);
			  for(int i=size_two;i>=1;i--)//Body strat from 1..
			  {
				  tempX_Snake_two[i]=tempX_Snake_two[i-1];
				  tempY_Snake_two[i]=tempY_Snake_two[i-1];
				  snake_Body_two[i-1].paintIcon(this,g,tempX_Snake_two[i],tempY_Snake_two[i]);
			  }
			  tempX_Snake_two[0]-=25;
		  }
		  else if(up_two)
		  {
		  	 snakeIcon_two= new ImageIcon("upmouth_snake_two.png");
			  if(tempY_Snake_two[0]<=0)
			  {
				  tempY_Snake_two[0]=1000;
			  }
			  snakeIcon_two.paintIcon(this,g,tempX_Snake_two[0],tempY_Snake_two[0]-25);
			  for(int i=size_two;i>=1;i--)//Body strat from 1..
			  {
				  tempX_Snake_two[i]=tempX_Snake_two[i-1];
				  tempY_Snake_two[i]=tempY_Snake_two[i-1];
				  snake_Body_two[i-1].paintIcon(this,g,tempX_Snake_two[i],tempY_Snake_two[i]);
			  }
			  tempY_Snake_two[0]-=25;
		  }
		  else if(down_two)
		  {
		  	 snakeIcon_two= new ImageIcon("downmouth_snake_two.png");
			  if(tempY_Snake_two[0]>=1000)
			  {
				  tempY_Snake_two[0]=0;
			  }
			  snakeIcon_two.paintIcon(this,g,tempX_Snake_two[0],tempY_Snake_two[0]+25);
			  for(int i=size_two;i>=1;i--)//Body strat from 1..
			  {
				  tempX_Snake_two[i]=tempX_Snake_two[i-1];
				  tempY_Snake_two[i]=tempY_Snake_two[i-1];
				  snake_Body_two[i-1].paintIcon(this,g,tempX_Snake_two[i],tempY_Snake_two[i]);
			  }
			  tempY_Snake_two[0]+=25;
		  }
		}
	  } 
	  else
	  {
		  super.paintComponent(g);
		  g.setColor(Color.BLACK);
		  g.setFont(new Font("arial",Font.BOLD,20));
		  g.drawString("Game Over",400,500);
		  g.drawString("Press enter to restart the game",350,530);
	  }
	}
	
	public void setLeft_one()
	{
		if(!right_one)
		{
		left_one=true;
		right_one=false;
		up_one=false;
		down_one=false;
		stop=false;
		}
	}
	public void setLeft_two()
	{
		if(!right_two)
		{
		left_two=true;
		right_two=false;
		up_two=false;
		down_two=false;
		stop=false;
		}
	}
	public void setRight_one()
	{
		if(!left_one)
		{
		right_one=true;
		left_one=false;
		up_one=false;
		down_one=false;
		stop=false;
		}
	}
	public void setRight_two()
	{
		if(!left_two)
		{
		right_two=true;
		left_two=false;
		up_two=false;
		down_two=false;
		stop=false;
		}
	}
	public void setUp_one()
	{
		if(!down_one)
		{
		up_one=true;
		left_one=false;
		right_one=false;
		down_one=false;
		stop=false;
		}
	}
	public void setUp_two()
	{
		if(!down_two)
		{
		up_two=true;
		left_two=false;
		right_two=false;
		down_two=false;
		stop=false;
		}
	}
	public void setDown_one()
	{
		if(!up_one)
		{
		down_one=true;
		up_one=false;
		left_one=false;
		right_one=false;
		stop=false;
		}
	}
		public void setDown_two()
	{
		if(!up_two)
		{
		down_two=true;
		up_two=false;
		left_two=false;
		right_two=false;
		stop=false;
		}
	}

	public void setStart()
	{
		stop=false;
	}
	public void setStop()
	{
		stop=true;
	}
	public boolean Check_if_Snake_Eat_Food()
	{
		if((tempX_Snake_one[0]==tempX_Apple)&&(tempY_Apple==tempY_Snake_one[0]))
		{
			if(size_one<15)
			{
            size_one++;
            }
			return true;
		}
		if(is_two_player_game==2)
		{
		    if((tempX_Snake_two[0]==tempX_Apple)&&(tempY_Apple==tempY_Snake_two[0]))
		    {
			  if(size_two<15)
			  {
                size_two++;
              }
			  return true;
		    }
		    else
		    {
			  return false;
		    }
		 }
		 return false;
	}
	public boolean Check_If_Snake_Eat_Itself()
	{
		for(int i=1;i<size_one;i++)
		{
			if(tempX_Snake_one[0]==tempX_Snake_one[i]&&tempY_Snake_one[0]==tempY_Snake_one[i])
			{
				System.out.printf("Snake 1 eat itself\n");
				game_over=true;
				stop=true;
				return true;
			}
		}
		if(is_two_player_game==2)
        {
		   for(int i=1;i<size_two;i++)
		   {
			  if(tempX_Snake_two[0]==tempX_Snake_two[i]&&tempY_Snake_two[0]==tempY_Snake_two[i])
			  {
				    System.out.printf("Snake 2 eat itself\n");
			    	game_over=true;
				    stop=true;
				    return true;
			   }
		    }
        }
		return false;
	}
	public boolean Check_If_Snake_Touch_Each_Other()
	{

	    for(int i=0;i<size_two;i++)
	    {
	    	if(tempX_Snake_one[0]==tempX_Snake_two[i]&&tempY_Snake_one[0]==tempY_Snake_two[i])
	    	{
				System.out.printf("Snake 1 touch snake 2\n");
				System.out.printf("%d %d %d\n",i,tempX_Snake_two[0],tempX_Snake_one[i]);
				System.out.printf("%d %d %d\n",i,tempY_Snake_two[0],tempY_Snake_one[i]);
	    		game_over=true;
				stop=true;
				return true;
	    	}
	    }
	    for(int i=0;i<size_one;i++)
	    {
	    	if(tempX_Snake_two[0]==tempX_Snake_one[i]&&tempY_Snake_two[0]==tempY_Snake_one[i])
	    	{
				System.out.printf("Snake 2 touch snake 1\n");
				System.out.printf("%d %d %d\n",i,tempX_Snake_two[0],tempX_Snake_one[i]);
				System.out.printf("%d %d %d\n",i,tempY_Snake_two[0],tempY_Snake_one[i]);
	    		game_over=true;
				stop=true;
				return true;
	    	}
	    }
	    return false;
	}
	public boolean getGameOver()
	{
		return game_over;
	}
	public void reStart_the_game()
	{
		System.out.printf("haha\n");
	   if(game_over)
	   {
		 System.out.printf("haha1\n");
		for(int i=0;i<size_one;i++)
		{
			tempX_Snake_one[i]=0;
			tempY_Snake_one[i]=0;
		}
		if(is_two_player_game==2)
	    {
		   for(int i=0;i<size_two;i++)
		   {
			tempX_Snake_two[i]=0;
			tempY_Snake_two[i]=0;
		   }
           tempX_Snake_two[0]=(random.nextInt(40))*25;
	       tempY_Snake_two[0]=(random.nextInt(40))*25;
		}
   
		tempX_Snake_one[0]=(random.nextInt(40))*25;
	    tempY_Snake_one[0]=(random.nextInt(40))*25;
		System.out.printf("%d %d\n",tempX_Snake_one[0],tempX_Snake_two[0]);
		System.out.printf("%d %d\n",tempY_Snake_one[0],tempY_Snake_two[0]);
		size_one=2;
		size_two=2;
		game_over=false;
		stop=false;
	   }
	}
	public int get_X()
	{
		return tempX_Snake_one[0];
	}
	public int get_Y()
	{
		return tempY_Snake_one[0];
	}
	

}

