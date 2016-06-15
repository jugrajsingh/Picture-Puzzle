package pp;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


public class Picture extends JFrame implements ActionListener
{   JButton pic1,pic2;
    Label msg1,msg2;
    int send;
	Picture()
	{
		setTitle("Welcome to Picture Puzzle");
		  setSize(900,650);
		  setVisible(true);
		  setResizable(false);
		  setLayout(null);
		  addWindowListener(new WindowAdapter(){public void WindowClosing(WindowEvent we){System.exit(0);}});
		  pic1=new JButton();
		  pic2=new JButton();
		  add(pic1);
		  add(pic2);
		  msg1=new Label("Welcome to Picture Puzzle");
		  msg2=new Label("Select your Picture");
		  add(msg1);
		  add(msg2);
		  pic1.addActionListener(this);
		  pic2.addActionListener(this);
		  msg1.setFont(new Font("Times New Roman",Font.BOLD+Font.ITALIC,40));
		  msg1.setBounds(170, 50, 550, 30);
		  msg2.setBounds(320,120,200,30);
		  msg2.setFont(new Font("Times New Roman",Font.BOLD,20));
		  ImageIcon p1=new ImageIcon("Pictures//deser10.jpg");
		  pic1.setIcon(p1);
		  ImageIcon p2=new ImageIcon("Pictures//hors10.jpg");
		  pic2.setIcon(p2);
		  pic1.setBounds(100,200,300,300);
		  pic2.setBounds(450,200,300,300);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==pic1)
		{
			send=1;
			new Initial(send);
			setVisible(false);
		}
		else if(arg0.getSource()==pic2)
		{
			send=2;
			new Initial(send);
			setVisible(false);
		}
		
	}
	
	public static void main(String a1[])
	{ new Picture();
	
	}
}