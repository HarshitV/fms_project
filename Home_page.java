package fms_project;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Home_page implements ActionListener{
	private JPanel p,p1,p0,p2,p3;
	private JLabel label2;
	private JButton btnstart,btnexit,btnch1,btnch2,btnch3,btnch4,btnexit2;
	private JFrame frame,frame2,frame3;
	private String u1,u2;
	private int oddeven=1;
	public static char val='O';
	Home_page()
	{
		frame=new JFrame("FMS HOME");
		frame.setLayout(new GridLayout(3,1));
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p0=new JPanel(new FlowLayout());
		p=new JPanel(new FlowLayout());
		p1=new JPanel(new FlowLayout());
		btnstart=new JButton("Register");
		btnstart.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						register();
					}
				});
		btnexit=new JButton("Login");
		btnexit.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						login();
					}					
				});
		btnstart.setBackground(Color.ORANGE);
		btnexit.setBackground(Color.ORANGE);
		p.add(btnstart);
		p1.add(btnexit);
		JLabel label = new JLabel();
		label.setText("FMS");
		label.setFont (label.getFont ().deriveFont (30.0f));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		p0.add(label);
		frame.add(p0);
		frame.add(p);
		frame.add(p1);
		frame.setSize(400, 300);
	}
	
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Home_page();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String arg=e.getActionCommand();
		if(arg=="Start Game")
		{
			
			this.register();
		}
		else if(arg=="Exit");
		{
			this.login();
		}
		
	}
	public void register()
	{
		
	}
	public void login()
	{
		
	}
	
	
}
