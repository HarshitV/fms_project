package fms_project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;

public class GM extends User{

	private static JFrame frame4;
	private static JPanel fpane2,bpane2;
	private static JButton btn1;
	private static JLabel date;
	
	//ArrayList<logistic_req> req_list=new ArrayList<logistic_req>();
	//ArrayList<leave> leave_list=new ArrayList<leave>();
	
	public static void createGUI()
	{
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss, dd MMM yyyy ");
		Calendar cal = Calendar.getInstance();
		date=new JLabel("Logged in at: " + dateFormat.format(cal.getTime()));		
		date.setFont (date.getFont ().deriveFont (15.0f));
		date.setHorizontalAlignment(JLabel.RIGHT);
		ImageIcon imageIcon = new ImageIcon("C:/Users/Harshit/workspace/fms_project/src/fms_project/logonew.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(250, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		
		frame4=new JFrame("Admin Home");
		frame4.setVisible(true);
		frame4.setSize(350,120);
		frame4.setLocationRelativeTo(null);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fpane2=new JPanel();
		bpane2=new JPanel();
		//fpane2.setLayout(new BoxLayout);
		//fpane2.add(date);
		JLabel logo = new JLabel(imageIcon);
		logo.setVerticalAlignment(JLabel.TOP);
		frame4.add(logo,BorderLayout.CENTER);
		frame4.add(date,BorderLayout.NORTH);
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		frame4.setSize(xSize,ySize);
		frame4.setLocationRelativeTo(null);
	}
	
	public void approve_user()
	{
		
	}
	
	public void reject_user()
	{
		
	}
	
	public void view_user()
	{
		
	}
	
	public void delete_user()
	{
		
	}
	
	public void assign_task()
	{
		
	}
	
	public void accept()
	{
		
	}
	
	public void reject()
	{
		
	}
	
	
	
}
