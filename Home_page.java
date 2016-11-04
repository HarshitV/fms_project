package fms_project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Home_page implements ActionListener{
	private JPanel p1,p2,p3,p4;
	private JLabel label1;
	private JButton btnregister,btnlogin;
	private JFrame frame1;
	Home_page()
	{
		frame1=new JFrame("FMS HOME");
		frame1.setLayout(new GridLayout(4,1));
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p1=new JPanel(new FlowLayout());
		p2=new JPanel(new FlowLayout());
		p3=new JPanel(new FlowLayout());
		p4=new JPanel(new FlowLayout());
		btnregister=new JButton("Register");
			
		
	}
	
	public void register()
	{
		
	}
	public void login()
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Home_page();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String arg=e.getActionCommand();
		if(arg=="Register")
		{
			
			this.register();
		}
		else if(arg=="Login");
		{
			this.login();
		}
		
}
}
