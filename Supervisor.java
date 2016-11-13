package fms_project;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.lang.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.*;

public class Supervisor extends User{
	String department;
	private static JFrame frame5;
	private static JPanel fpane2;
	private static JButton btn1;
	private JLabel label1;
	private static JLabel date,welcome;
	
	
	
	public static void createGUI()
	{
		fpane2=new JPanel();
		frame5=new JFrame("FMS SUPERVISOR");
		frame5.setLayout(new GridLayout(5,1));
		frame5.setVisible(true);
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.setSize(600, 400);
		frame5.setLocationRelativeTo(null);
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss, dd MMM yyyy ");
		Calendar cal = Calendar.getInstance();
		date=new JLabel("Logged in at: " + dateFormat.format(cal.getTime()));		
		date.setFont (date.getFont ().deriveFont (15.0f));
		
		JLabel fms=new JLabel("FACULTY MANAGEMENT SERVICES SYSTEM");
		fms.setFont(fms.getFont ().deriveFont (30.0f));
		fms.setForeground(Color.red);
		
		welcome=new JLabel("Welcome " + Login.username + " !");
		welcome.setFont (welcome.getFont ().deriveFont (20.0f));
		
		JLabel loggeduser=new JLabel("Logged in as ADMIN");
		loggeduser.setFont (loggeduser.getFont ().deriveFont (15.0f));
		ImageIcon imageIcon = new ImageIcon("C:/Users/Harshit/workspace/fms_project/src/fms_project/logonew.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(150, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		JLabel logo = new JLabel(imageIcon);
		
	}
	
	public void approve_user(){

	}

	public void reject_user(){

	}

	public void view_user(){

	}

	public void delete_user(){

	}

	public void assign_task(){

	}

	public void accept(){

	}

	public void reject(){

	}
}