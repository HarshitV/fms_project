package fms_project;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private String username;
	private String password;
	//private Logout logo;
	private JFrame frame3;
	private JPanel fpane2,bpane2;
	private JButton ok2,cancel2;
	
	public void createGUI()
	{
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
		ok2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame3.setVisible(false);
			
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
        fpane2.setLayout(new GridLayout(2,1));
        bpane2.setLayout(new FlowLayout());
        JTextField usname;
        JPasswordField pswd;
        usname=new JTextField("");
        pswd=new JPasswordField();
        fpane2.add(uname);
        fpane2.add(usname);
        fpane2.add(pwd);
        fpane2.add(pswd);
        bpane2.add(ok2);
        bpane2.add(cancel2);
        frame3.getContentPane().add(fpane2);
        frame3.add(bpane2, BorderLayout.PAGE_END);
	}
	
	public void get_info(){

	}

	public void check_info(){

	}

	//public void open_userscreen( User a){

	//}
}