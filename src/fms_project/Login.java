package fms_project;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Login{
	static String username;
	private String password;
	//private Logout logo;
	private JFrame frame3;
	private JPanel fpane2,bpane2;
	private JButton ok2,cancel2;
	
	public void createGUI()
	{
		Main m1=new Main();
		m1.read_database();
		frame3=new JFrame("FMS LOGIN");
		frame3.setVisible(true);
		frame3.setSize(350,120);
		frame3.setLocationRelativeTo(null);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fpane2=new JPanel();
		bpane2=new JPanel();
		JLabel uname=new JLabel("Enter username: ");
		uname.setFont (uname.getFont ().deriveFont (15.0f));
		JLabel pwd=new JLabel("Enter password: ");
		pwd.setFont (pwd.getFont ().deriveFont (15.0f));
		ok2 = new JButton("OK");
		
        fpane2.setLayout(new GridLayout(2,1));
        bpane2.setLayout(new FlowLayout());
        JTextField usname;
        JPasswordField pswd;
        usname=new JTextField("");
        pswd=new JPasswordField();
        ok2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame3.setVisible(false);
				username=usname.getText();
				//System.out.println(username);
				password=pswd.getText();
				//System.out.println(password);
				get_info(username,password);
				User check=check_info(m1);
				Home_page.frame1.setVisible(false);
				
				if(username.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Username field blank");
				}
				else if(check!=null)
				{
					if(check.type.equals("GM"))
					{
						GM g2=(GM)check;
						g2.createGUI();
					}
					else if(check.type.equals("Supervisor"))
					{
						Supervisor s2=(Supervisor)check;
						s2.createGUI();
					}
					else if(check.type.equals("Staff"))
					{
						Staff st2=(Staff)check;
						st2.createGUI();
					}
				}
				
				
				
			}
			
		});
		
        cancel2 = new JButton("Cancel");
        cancel2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame3.dispose();
			
			}
			
		});
        
        fpane2.add(uname);
        fpane2.add(usname);
        fpane2.add(pwd);
        fpane2.add(pswd);
        bpane2.add(ok2);
        bpane2.add(cancel2);
        frame3.getContentPane().add(fpane2);
        frame3.add(bpane2, BorderLayout.PAGE_END);
	}
	
	public void get_info(String us, String pswod){
		this.username=us;
		this.password=pswod;
	}

	public User check_info(Main a){ //return 1 if it exists else returns 0 if it does not exist
		int i;
		int flag=0;
		if(flag==0){
			GM g= a.admin;
			if(g.username.equals(username) && g.passwd.equals(password)){
					flag=1;
					return g;
				}
		}
		if(flag==0){
			for(i=0;i<((a.electricity).staff).size();i++){
				Staff g=((a.electricity).staff).get(i);
				if(g.username.equals(username) && g.passwd.equals(password)){
					flag=1;
					return g;
				}
			}
			if(flag==0){
				Supervisor g=(a.electricity).supervisor;
				if(g.username.equals(username) && g.passwd.equals(password)){
					flag=1;
					return g;
				}
			}
		}
		if(flag==0){
			for(i=0;i<((a.hvac).staff).size();i++){
				Staff g=((a.hvac).staff).get(i);
				if(g.username.equals(username) && g.passwd.equals(password)){
					flag=1;
					return g;
				}
			}
			if(flag==0){
				Supervisor g=(a.hvac).supervisor;
				if(g.username.equals(username) && g.passwd.equals(password)){
					flag=1;
					return g;
				}
			}
		}
		if(flag==0){
			for(i=0;i<((a.security).staff).size();i++){
				Staff g=((a.security).staff).get(i);
				if(g.username.equals(username) && g.passwd.equals(password)){
					flag=1;
					return g;
				}
			}
			if(flag==0){
				Supervisor g=(a.security).supervisor;
				if(g.username.equals(username) && g.passwd.equals(password)){
					flag=1;
					return g;
				}
			}
		}
		if(flag==0){
			for(i=0;i<((a.housekeeping).staff).size();i++){
				Staff g=((a.housekeeping).staff).get(i);
				if(g.username.equals(username) && g.passwd.equals(password)){
					flag=1;
					return g;
				}
			}
			if(flag==0){
				Supervisor g=(a.housekeeping).supervisor;
				if(g.username.equals(username) && g.passwd.equals(password)){
					flag=1;
					return g;
				}
			}
		}
		if(flag==0){
			for(i=0;i<((a.av).staff).size();i++){
				Staff g=((a.av).staff).get(i);
				if(g.username.equals(username) && g.passwd.equals(password)){
					flag=1;
					return g;
				}
			}
			if(flag==0){
				Supervisor g=(a.av).supervisor;
				if(g.username.equals(username) && g.passwd.equals(password)){
					flag=1;
					return g;
				}
			}
		}
		return null;
	}


	//public void open_userscreen( User a){

	//}
}