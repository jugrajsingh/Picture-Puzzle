package pp;
import java.awt.Color;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

class Initial extends JFrame implements ActionListener
{   Panel pic;
	JPanel grid;
	JLabel p;
	int n,count=0;
	JLabel fina;
	int pass;
	JButton res,temp,solve,submit;
	JButton buttons[]=new JButton[9];
	ImageIcon images[]=new ImageIcon[8];
	ImageIcon image[]=new ImageIcon[8];
	Label display;
	boolean yn;
	Initial( int a)
	{ 
	  pass=a;
	  setTitle("Picture Puzzle");
	  setSize(900,650);
	  setVisible(true);
	  setResizable(false);
	  addWindowListener(new WindowAdapter(){public void WindowClosing(WindowEvent we){System.exit(0);}});
	  JMenuBar menu=new JMenuBar();
	  JMenu file= new JMenu("File");
	  JMenu help=new JMenu("Help");
	  JMenuItem ng= new JMenuItem("New Game");
	  JMenuItem cp=new JMenuItem("Change Picture");
	  JMenuItem rule=new JMenuItem("Rules");
	  JMenuItem about=new JMenuItem("About");
	  file.setMnemonic(KeyEvent.VK_F);
	  menu.add(file);
	  menu.add(help);
	  file.add(ng);
	  file.add(cp);
	  help.add(rule);
	  help.add(about);
	  help.setMnemonic(KeyEvent.VK_H);
	  setJMenuBar(menu);
	  setLayout(null);
	  pic=new Panel();
	  grid= new JPanel();
	  add(pic);
	  add(grid);
	  grid.setBounds(30,70,400,450);
	  pic.setBounds(460, 70, 400, 450);
	  n=3;
	  grid.setLayout(new GridLayout(n,n));
	  for( int k=0; k<n;k++)
	  { for( int j=0; j<n;j++)
	  { 
	    { int y= k*n+j;  	
	    
	  grid.add(buttons[y]=new JButton());
	  buttons[y].addActionListener(this);
	  buttons[y].setBackground(Color.black);
	    } 
	  }
	  }
	  if(a==1)
	  { ImageIcon i= new ImageIcon("Pictures//Desert.jpg");
	  	p= new JLabel(i);
	  	pic.add(p,"img");
	  	images[0]=new ImageIcon("Pictures//pic1.jpg");
	  	images[1]=new ImageIcon("Pictures//pic2.jpg");
	  	images[2]=new ImageIcon("Pictures//pic3.jpg");
	  	images[3]=new ImageIcon("Pictures//pic4.jpg");
	  	images[4]=new ImageIcon("Pictures//pic5.jpg");
	  	images[5]=new ImageIcon("Pictures//pic6.jpg");
	  	images[6]=new ImageIcon("Pictures//pic7.jpg");
	  	images[7]=new ImageIcon("Pictures//pic8.jpg");
	  	image[0]=new ImageIcon("Pictures//pic1.jpg");
	  	image[1]=new ImageIcon("Pictures//pic2.jpg");
	  	image[2]=new ImageIcon("Pictures//pic3.jpg");
	  	image[3]=new ImageIcon("Pictures//pic4.jpg");
	  	image[4]=new ImageIcon("Pictures//pic5.jpg");
	  	image[5]=new ImageIcon("Pictures//pic6.jpg");
	  	image[6]=new ImageIcon("Pictures//pic7.jpg");
	  	image[7]=new ImageIcon("Pictures//pic8.jpg");
	  }
	  else if(a==2)
	  {   ImageIcon i= new ImageIcon("Pictures//Horse.jpg");
	      p= new JLabel(i);
	      pic.add(p,"img");
		  images[0]=new ImageIcon("Pictures//h1.jpg");
		  images[1]=new ImageIcon("Pictures//h2.jpg");
		  images[2]=new ImageIcon("Pictures//h3.jpg");
		  images[3]=new ImageIcon("Pictures//h4.jpg");
		  images[4]=new ImageIcon("Pictures//h5.jpg");
		  images[5]=new ImageIcon("Pictures//h6.jpg");
		  images[6]=new ImageIcon("Pictures//h7.jpg");
		  images[7]=new ImageIcon("Pictures//h8.jpg");
		  image[0]=new ImageIcon("Pictures//h1.jpg");
		  image[1]=new ImageIcon("Pictures//h2.jpg");
		  image[2]=new ImageIcon("Pictures//h3.jpg");
		  image[3]=new ImageIcon("Pictures//h4.jpg");
		  image[4]=new ImageIcon("Pictures//h5.jpg");
		  image[5]=new ImageIcon("Pictures//h6.jpg");
		  image[6]=new ImageIcon("Pictures//h7.jpg");
		  image[7]=new ImageIcon("Pictures//h8.jpg");
	  }
	
	  Collections.shuffle(Arrays.asList(images));
	  for(int vy=0; vy<8;vy++)
	  { if(vy!=0)
	  { for(int rep=0;rep<=vy;rep++)
	  	{
		 if( buttons[vy].getIcon()!=buttons[rep].getIcon())
		 {
			 buttons[vy].setIcon(images[vy]); 
		 }
	  	}
	  }
	  buttons[vy].setIcon(images[vy]); 
	  }  
	  submit=new JButton("Check if done");
	  solve=new JButton("Solve");
	  res=new JButton("Reset");
	  submit.addActionListener(this);
	  res.addActionListener(this);
	  solve.addActionListener(this);
	  add(submit);
	  add(solve);
	  add(res);
	  submit.setBounds(480,550,120,30);
	  res.setBounds(280,550, 80, 30);
	  solve.setBounds(380,550,80,30);
	  fina=new JLabel();
	  display=new Label();
	  add(display);
	  add(fina);
	  fina.setBounds(550,20,500,40);
	  display.setBounds(300, 20, 200, 40);
	  display.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,20));
	  display.setForeground(Color.blue);
	  fina.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,20));
	  fina.setForeground(Color.blue);
	  about.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){ new About();}});
	  rule.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){ fina.setText(null); new Rule();}});
	  cp.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){fina.setText(null);
	  new Picture();
	  setVisible(false);}});
	  ng.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae){
		  fina.setText(null);
		  count=0;
	   display.setText(null);
		for(int remo=0;remo<9;remo++)
	{
		buttons[remo].setIcon(null);
	}
		Collections.shuffle(Arrays.asList(images));
		  for(int vy=0; vy<8;vy++)
		  { if(vy!=0)
		  { for(int rep=0;rep<=vy;rep++)
		  	{
			 if( buttons[vy].getIcon()!=buttons[rep].getIcon())
			 {
				 buttons[vy].setIcon(images[vy]); 
			 }
		  	}
		  }
		  buttons[vy].setIcon(images[vy]); 
		  }  }});
	  
	}
		
	public void actionPerformed(ActionEvent arg0) { 
		if(arg0.getActionCommand()=="Reset")
		{  fina.setText(null);
			count=0;
		   display.setText(null);
			for(int remo=0;remo<9;remo++)
		{
			buttons[remo].setIcon(null);
		}
			Collections.shuffle(Arrays.asList(images));
			  for(int vy=0; vy<8;vy++)
			  { if(vy!=0)
			  { for(int rep=0;rep<=vy;rep++)
			  	{
				 if( buttons[vy].getIcon()!=buttons[rep].getIcon())
				 {
					 buttons[vy].setIcon(images[vy]); 
				 }
			  	}
			  }
			  buttons[vy].setIcon(images[vy]); 
			  }  
		}
		else if(arg0.getActionCommand()=="Solve")
		{   fina.setText(null);
			for(int remo=0;remo<9;remo++)
			{
				buttons[remo].setIcon(null);
			}
			for(int x=0;x<8;x++)
			{
				buttons[x].setIcon(image[x]);
			}
		}
		else if(arg0.getActionCommand()=="Check if done")
		{
			isgameover();
		}
		else 
		{int ch;
		
		for(ch=0; ch<8; ch++)
		{
			if(arg0.getSource()==buttons[ch])
			{
				break;
			}
		}
		 
		islegal(ch);
		}
	}
	
//function to shift cells
	public void move(int nul,int ini)
	{  
		Icon temp= new ImageIcon();
	    temp=buttons[ini].getIcon();
	    buttons[nul].setIcon(temp);
		buttons[ini].setIcon(null);
		count=count+1;
		display.setText("No. Of Moves: "+count);
		fina.setText(null);
	}	
//function to check is any surrounding cell empty and if yes then what cell is empty	
	public void islegal(int t)
	{ switch(t)
		{
	        case 0:
	        { if(buttons[t+1].getIcon()==null)
	        {
	        	move(t+1,t);
	        }
	        else if(buttons[t+3].getIcon()==null)
	        {
	        	move(t+3,t);
	        }
	        break;
	        }
	        case 1:
	        { if(buttons[t-1].getIcon()==null)
	        {
	        	move(t-1,t);
	        }
	        else if(buttons[t+1].getIcon()==null)
	        {
	        	move(t+1,t);
	        }
	        else if(buttons[t+3].getIcon()==null)
	        {
	        	move(t+3,t);
	        }
	        break;
	        }
	        case 2:
	        { if(buttons[t-1].getIcon()==null)
	        {
	        	move(t-1,t);
	        }
	        else if(buttons[t+3].getIcon()==null)
	        {move(t+3,t);
	        }
	        break;
	        }
	        case 3:
	        { if(buttons[t+1].getIcon()==null)
	        {
	        	move(t+1,t);
	        }
	        else if(buttons[t+3].getIcon()==null)
	        {
	        	move(t+3,t);
	        }
	        else if(buttons[t-3].getIcon()==null)
	        {
	        	move(t-3,t);
	        }
	        break;
	        }
	        case 4:
	        { if(buttons[t+1].getIcon()==null)
	        {
	        	move(t+1,t);
	        }
	        else if(buttons[t+3].getIcon()==null)
	        {
	        	move(t+3,t);
	        }
	        else if(buttons[t-3].getIcon()==null)
	        {
	        	move(t-3,t);
	        }
	        if(buttons[t-1].getIcon()==null)
	        {
	        	move(t-1,t);
	        }
	        break;
	        }
	        case 5:
	        { if(buttons[t-1].getIcon()==null)
	        {
	        	move(t-1,t);
	        }
	        else if(buttons[t+3].getIcon()==null)
	        {
	        	move(t+3,t);
	        }
	        if(buttons[t-3].getIcon()==null)
	        {
	        	move(t-3,t);
	        }
	        break;
	        } 
	        case 6:
	        { if(buttons[t-3].getIcon()==null)
	        {
	        	move(t-3,t);
	        }
	        else if(buttons[t+1].getIcon()==null)
	        {
	        	move(t+1,t);
	        }
	        break;
	        }
	        case 7:
	        { if(buttons[t+1].getIcon()==null)
	        {
	        	move(t+1,t);
	        }
	        else if(buttons[t-3].getIcon()==null)
	        {
	        	move(t-3,t);
	        }
	        if(buttons[t-1].getIcon()==null)
	        {
	        	move(t-1,t);
	        }
	        break;
	        }
	        case 8:
	        { if(buttons[t-1].getIcon()==null)
	        {
	        	move(t-1,t);
	        }
	        else if(buttons[t-3].getIcon()==null)
	        {
	        	move(t-3,t);
	        }
	        break;
	        }
		}
	}
	public void isgameover()
	{ 
		for(int im=0;im<8;im++)
		{ 
		if(buttons[im].getIcon()==image[im] && buttons[8].getIcon()==null)
		{ 
			yn=true;
			
		}
		else
		{   
			yn=false;
			
		}
		}
	   if(yn==true)
	   {
		   
		   fina.setText("Congratulations!! You Win!!");
	   }
	   else
	   {
		   fina.setText("Keep Trying");
	   }
	}
}
	
class About extends JFrame
{   Label text1;
Label text2;
Label text3;
Label text4;
	About()
	{
		setTitle("About");
		  setSize(400,300);
		  setVisible(true);
		  setResizable(false);
		  setLayout(null);
		  addWindowListener(new WindowAdapter(){public void WindowClosing(WindowEvent we){System.exit(0);}});
		  text1=new Label();
		  text2=new Label();
		  text3=new Label();
		  text4=new Label();
		  add(text4);
		  add(text2);
		  add(text3);
		  add(text1);
		  text1.setText("This game is developed in Java by students of");
		  text1.setBounds(10,70,400,30);
		  text2.setText(" DeenBandhu Chottu Ram University of Science and Technology");
		  text2.setBounds(10,95,400,30);
		  text3.setText("under the guidance of Mrs. Jaspinder in Centre for Developement ");
		  text3.setBounds(10,120,400,30);
		  text4.setText(" of Advanced Computing during summer training in 2015");
		  text4.setBounds(10,145,400,30);
	}
}


class Rule extends JFrame
{   Label text1,text2,text3,text4,text5,text6;
	
	Rule()
	{
		setTitle("Rules");
		  setSize(400,300);
		  setVisible(true);
		  setResizable(false);
		  setLayout(null);
		  addWindowListener(new WindowAdapter(){public void WindowClosing(WindowEvent we){System.exit(0);}});
		  text1=new Label();
		  text2=new Label();
		  text3=new Label();
		  text4=new Label();
		  text5=new Label();
		  text6=new Label();
		  add(text4);
		  add(text5);
		  add(text2);
		  add(text3);
		  add(text1);
		  add(text6);
		  text1.setText("The rules of the game are very simple and are given below");
		  text1.setBounds(10,70,400,30);
		  text2.setText(" 1. You have to make a complete picture same as given");
		  text2.setBounds(10,95,400,30);
		  text3.setText(" 2. Pieces can move only in vertical or horizontal direction");
		  text3.setBounds(10,120,400,30);
		  text4.setText(" 3. Click on the pieces to move, only one moves at a time");
		  text4.setBounds(10,145,400,30);
		  text5.setText(" 4. When you think you are done click on check if done to know");
		  text5.setBounds(10,170,400,30);
		  text6.setText(" 5. If you want to solve or reset the puzzle click on the same anytime");
		  text6.setBounds(10,195,400,30);
	}
}