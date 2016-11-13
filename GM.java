package fms_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;

public class GM extends User{

	private static JFrame frame4;
	private static JPanel fpane2;
	private static JButton btn1,btn2,btn3,btn4,btn5;
	private static JLabel date,welcome,l1,l2,l3,l4,l5,l6,disphome;
	
	//ArrayList<logistic_req> req_list=new ArrayList<logistic_req>();
	//ArrayList<leave> leave_list=new ArrayList<leave>();
	
	public static void createGUI()
	{
		fpane2=new JPanel();
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
		String[] columns = new String[] { "Home", "Staff", "Logistics", "Reports","Requests" };
		Object[][] data = new Object[][] { {1, "John", 40.0, false,"yyo" },};
		JTable table = new JTable(data, columns);
		//table.setSize(200, 300);
		//table.setBounds(30,40,200,300);
		//table.setRowHeight(1, 5);
		table.setEnabled(false);
		JScrollPane sp=new JScrollPane(table);  
		
		ImageIcon imageIcon = new ImageIcon("C:/Users/Harshit/workspace/fms_project/src/fms_project/logonew.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(150, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		JLabel logo = new JLabel(imageIcon);
		
		ImageIcon staff = new ImageIcon("staff2.png");
		Image image2 = staff.getImage(); // transform it 
		Image newimg2 = image2.getScaledInstance(170, 170,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		staff = new ImageIcon(newimg2);
	    JButton staffbtn = new JButton(staff);
	    staffbtn.setPreferredSize(new Dimension(160, 170));
	    staffbtn.setOpaque(false);
	    staffbtn.setContentAreaFilled(false);
	    staffbtn.setBorderPainted(false);
	    staffbtn.setToolTipText("Staff");
	    
	    ImageIcon logs = new ImageIcon("logistics.png");
		Image image3 = logs.getImage(); // transform it 
		Image newimg3 = image3.getScaledInstance(230, 160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		logs = new ImageIcon(newimg3);
	    JButton logsbtn = new JButton(logs);
	    logsbtn.setPreferredSize(new Dimension(160, 170));
	    logsbtn.setOpaque(false);
	    logsbtn.setContentAreaFilled(false);
	    logsbtn.setBorderPainted(false);
	    logsbtn.setToolTipText("Logistics");
	    
	    ImageIcon reps = new ImageIcon("report.png");
		Image image4 = reps.getImage(); // transform it 
		Image newimg4 = image4.getScaledInstance(170, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		reps = new ImageIcon(newimg4);
	    JButton repsbtn = new JButton(reps);
	    repsbtn.setPreferredSize(new Dimension(160, 170));
	    repsbtn.setOpaque(false);
	    repsbtn.setContentAreaFilled(false);
	    repsbtn.setBorderPainted(false);
	    repsbtn.setToolTipText("Reports");
	    
	    ImageIcon reqs = new ImageIcon("request.png");
		Image image5 = reqs.getImage(); // transform it 
		Image newimg5 = image5.getScaledInstance(180, 170,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		reqs = new ImageIcon(newimg5);
	    JButton reqsbtn = new JButton(reqs);
	    reqsbtn.setPreferredSize(new Dimension(160, 170));
	    reqsbtn.setOpaque(false);
	    reqsbtn.setContentAreaFilled(false);
	    reqsbtn.setBorderPainted(false);
	    reqsbtn.setToolTipText("Requests");
	    
	    ImageIcon task = new ImageIcon("task.png");
		Image image6 = task.getImage(); // transform it 
		Image newimg6 = image6.getScaledInstance(160, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		task = new ImageIcon(newimg6);
	    JButton taskbtn = new JButton(task);
	    taskbtn.setPreferredSize(new Dimension(160, 170));
	    taskbtn.setOpaque(false);
	    taskbtn.setContentAreaFilled(false);
	    taskbtn.setBorderPainted(false);
	    taskbtn.setToolTipText("Assign Task");
	    
	    ImageIcon lout = new ImageIcon("logout.png");
		Image image7 = lout.getImage(); // transform it 
		Image newimg7 = image7.getScaledInstance(150, 130,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		lout = new ImageIcon(newimg7);
	    JButton loutbtn = new JButton(lout);
	    loutbtn.setPreferredSize(new Dimension(160, 170));
	    loutbtn.setOpaque(false);
	    loutbtn.setContentAreaFilled(false);
	    loutbtn.setBorderPainted(false);
	    loutbtn.setToolTipText("Logout");
	    
	    l1=new JLabel("STAFF");
	    l2=new JLabel("LOGISTICS");
	    l3=new JLabel("REPORTS");
	    l4=new JLabel("REQUESTS");
	    l5=new JLabel("ASSIGN TASK");
	    l6=new JLabel("LOGOUT");
	    l1.setFont (l1.getFont ().deriveFont (20.0f));
	    l2.setFont (l2.getFont ().deriveFont (20.0f));
	    l3.setFont (l3.getFont ().deriveFont (20.0f));
	    l4.setFont (l4.getFont ().deriveFont (20.0f));
	    l5.setFont (l5.getFont ().deriveFont (20.0f));
	    l6.setFont (l6.getFont ().deriveFont (20.0f));
	    
	    logsbtn.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		fpane2.removeAll();
		
		fpane2.revalidate();
		fpane2.repaint();
		
		/*frame4.getContentPane().removeAll();
		frame4.add(btn1);
		frame4.revalidate();
		frame4.repaint();*/
		}
});
	    
		btn1=new JButton("Home");
		btn2=new JButton("Staff");
		btn3=new JButton("Logistics");
		btn4=new JButton("Reports");
		btn5=new JButton("Requests");
		btn1.setPreferredSize(new Dimension(200, 60));
		btn2.setPreferredSize(new Dimension(200, 60));
		btn3.setPreferredSize(new Dimension(200, 60));
		btn4.setPreferredSize(new Dimension(200, 60));
		btn5.setPreferredSize(new Dimension(200, 60));
		btn1.addActionListener(new ActionListener()
				{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fpane2.removeAll();
				fpane2.add(sp,new GridBagConstraints(
						0, // gridx
		                0, // gridy
		                1, // gridwidth
		                1, // gridheight
		                1, // weightx
		                1, // weighty
		                GridBagConstraints.CENTER, // anchor <------------
		                GridBagConstraints.NONE, // fill
		                new Insets(125, // inset top
		                200, // inset left
		                100, // inset bottom
		                0), // inset right
		                0, // ipadx
		                0)
						);
				fpane2.add(btn1,new GridBagConstraints(
						0, // gridx
		                0, // gridy
		                1, // gridwidth
		                1, // gridheight
		                1, // weightx
		                1, // weighty
		                GridBagConstraints.NORTHWEST, // anchor <------------
		                GridBagConstraints.NONE, // fill
		                new Insets(125, // inset top
		                20, // inset left
		                0, // inset bottom
		                0), // inset right
		                0, // ipadx
		                0)
						);
				fpane2.add(btn2,new GridBagConstraints(
						0, // gridx
		                0, // gridy
		                1, // gridwidth
		                1, // gridheight
		                1, // weightx
		                1, // weighty
		                GridBagConstraints.NORTHWEST, // anchor <------------
		                GridBagConstraints.NONE, // fill
		                new Insets(190, // inset top
		                20, // inset left
		                0, // inset bottom
		                0), // inset right
		                0, // ipadx
		                0)
						);
				fpane2.add(btn3,new GridBagConstraints(
						0, // gridx
		                0, // gridy
		                1, // gridwidth
		                1, // gridheight
		                1, // weightx
		                1, // weighty
		                GridBagConstraints.NORTHWEST, // anchor <------------
		                GridBagConstraints.NONE, // fill
		                new Insets(255, // inset top
		                20, // inset left
		                0, // inset bottom
		                0), // inset right
		                0, // ipadx
		                0)
						);
				fpane2.add(btn4,new GridBagConstraints(
						0, // gridx
		                0, // gridy
		                1, // gridwidth
		                1, // gridheight
		                1, // weightx
		                1, // weighty
		                GridBagConstraints.NORTHWEST, // anchor <------------
		                GridBagConstraints.NONE, // fill
		                new Insets(320, // inset top
		                20, // inset left
		                0, // inset bottom
		                0), // inset right
		                0, // ipadx
		                0)
						);	
				fpane2.add(btn5,new GridBagConstraints(
						0, // gridx
		                0, // gridy
		                1, // gridwidth
		                1, // gridheight
		                1, // weightx
		                1, // weighty
		                GridBagConstraints.NORTHWEST, // anchor <------------
		                GridBagConstraints.NONE, // fill
		                new Insets(385, // inset top
		                20, // inset left
		                0, // inset bottom
		                0), // inset right
		                0, // ipadx
		                0)
						);
				fpane2.add(loggeduser,new GridBagConstraints(0, // gridx
		                0, // gridy
		                1, // gridwidth
		                1, // gridheight
		                1, // weightx
		                1, // weighty
		                GridBagConstraints.NORTHWEST, // anchor <------------
		                GridBagConstraints.NONE, // fill
		                new Insets(0, // inset top
		                0, // inset left
		                0, // inset bottom
		                0), // inset right
		                0, // ipadx
		                0));
				fpane2.add(date,new GridBagConstraints(0, // gridx
		                0, // gridy
		                1, // gridwidth
		                1, // gridheight
		                1, // weightx
		                1, // weighty
		                GridBagConstraints.NORTHEAST, // anchor <------------
		                GridBagConstraints.NONE, // fill
		                new Insets(0, // inset top
		                0, // inset left
		                0, // inset bottom
		                0), // inset right
		                0, // ipadx
		                0));
				fpane2.add(logo,new GridBagConstraints(0, // gridx
		                0, // gridy
		                1, // gridwidth
		                1, // gridheight
		                1, // weightx
		                1, // weighty
		                GridBagConstraints.NORTH, // anchor <------------
		                GridBagConstraints.NONE, // fill
		                new Insets(10, // inset top
		                0, // inset left
		                0, // inset bottom
		                0), // inset right
		                0, // ipadx
		                0));
				fpane2.revalidate();
				fpane2.repaint();
				
				/*frame4.getContentPane().removeAll();
				frame4.add(btn1);
				frame4.revalidate();
				frame4.repaint();*/
				}
	});
		
		
		GridBagLayout gridbag = new GridBagLayout();
		
		frame4=new JFrame("Admin Home");
		frame4.setVisible(true);
		frame4.setSize(350,120);
		frame4.setLocationRelativeTo(null);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fpane2.setLayout(gridbag);
		
		fpane2.add(loggeduser,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                0, // inset left
                0, // inset bottom
                0), // inset right
                0, // ipadx
                0));
		fpane2.add(date,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHEAST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                0, // inset left
                0, // inset bottom
                0), // inset right
                0, // ipadx
                0));
		fpane2.add(logo,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTH, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(10, // inset top
                0, // inset left
                0, // inset bottom
                0), // inset right
                0, // ipadx
                0));
		
		fpane2.add(fms,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTH, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(90, // inset top
                0, // inset left
                0, // inset bottom
                0), // inset right
                0, // ipadx
                0));
		fpane2.add(welcome,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTH, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(130, // inset top
                0, // inset left
                0, // inset bottom
                0), // inset right
                0, // ipadx
                0));
		fpane2.add(staffbtn,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.WEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                75, // inset left
                130, // inset bottom
                0), // inset right
                0, // ipadx
                0));
		
		fpane2.add(logsbtn,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.CENTER, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                10, // inset left
                130, // inset bottom
                0), // inset right
                0, // ipadx
                0));
		fpane2.add(repsbtn,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.EAST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                0, // inset left
                130, // inset bottom
                85), // inset right
                0, // ipadx
                0));
		fpane2.add(reqsbtn,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                75, // inset left
                75, // inset bottom
                0), // inset right
                0, // ipadx
                0));
		fpane2.add(taskbtn,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTH, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                0, // inset left
                75, // inset bottom
                0), // inset right
                0, // ipadx
                0));
		fpane2.add(loutbtn,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTHEAST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                0, // inset left
                75, // inset bottom
                75), // inset right
                0, // ipadx
                0));
		
		fpane2.add(l1,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.WEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(60, // inset top
                122, // inset left
                0, // inset bottom
                0), // inset right
                0, // ipadx
                0));
		fpane2.add(l4,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                94, // inset left
                65, // inset bottom
                0), // inset right
                0, // ipadx
                0));
		fpane2.add(l2,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.CENTER, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(60, // inset top
                0, // inset left
                0, // inset bottom
                0), // inset right
                0, // ipadx
                0));
		fpane2.add(l3,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.EAST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(60, // inset top
                0, // inset left
                0, // inset bottom
                112), // inset right
                0, // ipadx
                0));
		fpane2.add(l6,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTHEAST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                0, // inset left
                65, // inset bottom
                115), // inset right
                0, // ipadx
                0));
		fpane2.add(l5,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTH, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                0, // inset left
                65, // inset bottom
                0), // inset right
                0, // ipadx
                0));
		
		//logo.setVerticalAlignment(JLabel.TOP);
		JScrollPane jsp = new JScrollPane(fpane2);
		frame4.add(jsp);
		//frame4.add(date,BorderLayout.NORTH);
		//Toolkit tk = Toolkit.getDefaultToolkit();
		//int xSize = ((int) tk.getScreenSize().getWidth());
		//int ySize = ((int) tk.getScreenSize().getHeight());
		frame4.setSize(800,690);
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
