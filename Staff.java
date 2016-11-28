
import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.Desktop;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.table.*;

// table 4 and sp4 are logistic requests

//l2 Logistics
//l3 Reports
//l4 Requests
//l5 Task Status
//l6 Logout

public class Staff extends User{

	
	String department;
	String status="Available";
	private static JComboBox<String> staffm,request,logdept,sendleaveto;
	private static JTextArea area,area2,area3;
	private static JTable table,table2,table3,table4,table5,table6,table7;
	private static JScrollPane scrollPane,scrollPane2,scrollPane3,sp6,sp7;
	private static JFrame frame4,frame7,frame8,frame9,frame10;
	private static JPanel fpane2,pane1,pane2,fpane3,fpane4,fpane5,fpane6;
	private static JButton submit2,cancel2,submit,leaveapply,log2gm,ok4,update,ok3,aclvbtn,rjlvbtn,acusrbtn,rjusrbtn,viewbtn,viewbtn2,deletebtn ,btn1,btn3,btn4,btn5,btn6,btn7,ok2,ok,cancel,repsbtn,leavebtn,taskbtn,loutbtn,logsbtn;
	private static JLabel task1,task2,task3,task4,task5,task6,warning,lv1,lv2,lv3,lv4,lv5,fms,logo,date,welcome,l2,l3,l4,l5,l6,disphome,loggeduser;
	private static ImageIcon imageIcon;
	private static JTextField t1,t2,t3,t4,t5,lt1,lt2,lt3,lt4;
	//ArrayList<logistic_req> req_list=new ArrayList<logistic_req>();
	//ArrayList<leave> leave_list=new ArrayList<leave>();
	
	Staff(){

	}

	Staff(String[] a){
		username=a[0];
		name=a[1];
		passwd=a[2];
		userid=a[3];
		type=a[4];
		dob=a[5];
		address=a[6];
		department=a[7];
		status=a[8];
	}
	
	public void createGUI()
	{
		Main m3=new Main();
		m3.read_database();
		ArrayList<String> stafflist=new ArrayList<String>();
		stafflist.add("Select staff member");
		stafflist.add("a");
		stafflist.add("b");
		stafflist.add("c");
		stafflist.add("d");
		stafflist.add("e");
		
		task1=new JLabel("Task id: ");
		task2=new JLabel("Task Name: ");
		task3=new JLabel("Task Description: ");
		task4=new JLabel("Comments: ");
		task5=new JLabel("Items Used: ");
		task6=new JLabel("Time Taken: ");
		area=new JTextArea(3,20);
		area.setColumns(47);
		area.setLineWrap (true);
		area.setWrapStyleWord (false);
		area.setFont(new Font("Serif", Font.PLAIN, 16));
		scrollPane = new JScrollPane(area);
		area2=new JTextArea(5,20);
		area2.setColumns(29);
		area2.setLineWrap (true);
		area2.setWrapStyleWord (false);
		area2.setFont(new Font("Serif", Font.PLAIN, 24));
		scrollPane2=new JScrollPane(area2);
		area3=new JTextArea(3,20);
		area3.setColumns(47);
		area3.setLineWrap (true);
		area3.setWrapStyleWord (false);
		area3.setFont(new Font("Serif", Font.PLAIN, 16));
		scrollPane3 = new JScrollPane(area3);
		task1.setFont(new Font("Serif", Font.PLAIN, 34));
		task2.setFont(new Font("Serif", Font.PLAIN, 34));
		task3.setFont(new Font("Serif", Font.PLAIN ,34));
		task4.setFont(new Font("Serif", Font.PLAIN ,34));
		task5.setFont(new Font("Serif", Font.PLAIN ,34));
		task6.setFont(new Font("Serif", Font.PLAIN ,34));
		task1.setHorizontalAlignment(SwingConstants.LEFT);
		task2.setHorizontalAlignment(SwingConstants.LEFT);
		task3.setHorizontalAlignment(SwingConstants.LEFT);
		task4.setHorizontalAlignment(SwingConstants.LEFT);
		task5.setHorizontalAlignment(SwingConstants.LEFT);
		task6.setHorizontalAlignment(SwingConstants.LEFT);
		lv1=new JLabel("Date today: ");
		lv2=new JLabel("Leave duration: ");
		lv3=new JLabel("Start Date: ");
		lv4=new JLabel("End Date: ");
		lv5=new JLabel("Leave Application: ");
		lv1.setFont(new Font("Serif", Font.PLAIN, 24));
		lv2.setFont(new Font("Serif", Font.PLAIN, 24));
		lv3.setFont(new Font("Serif", Font.PLAIN ,24));
		lv4.setFont(new Font("Serif", Font.PLAIN ,24));
		lv5.setFont(new Font("Serif", Font.PLAIN ,34));
		lv1.setHorizontalAlignment(SwingConstants.LEFT);
		lv2.setHorizontalAlignment(SwingConstants.LEFT);
		lv3.setHorizontalAlignment(SwingConstants.LEFT);
		lv4.setHorizontalAlignment(SwingConstants.LEFT);
		lv5.setHorizontalAlignment(SwingConstants.LEFT);
		lt1=new JTextField("DD/MM/YYYY");
		lt2=new JTextField(" #no_of_days");
		lt3=new JTextField("DD/MM/YYYY");
		lt4=new JTextField("DD/MM/YYYY");
		t1=new JTextField("");
		t2=new JTextField("");		
		t4=new JTextField("");
		t5=new JTextField("");
		t1.setPreferredSize( new Dimension( 50, 35 ) );
        t2.setPreferredSize( new Dimension( 135, 35 ) );
        t4.setPreferredSize( new Dimension( 525, 35 ) );
        t5.setPreferredSize( new Dimension( 330, 35 ) );
        lt1.setPreferredSize( new Dimension( 80, 35 ) );
        lt2.setPreferredSize( new Dimension( 80, 35 ) );
        lt3.setPreferredSize( new Dimension( 80, 35 ) );
        lt3.setPreferredSize( new Dimension( 80, 35 ) );
        lt4.setPreferredSize( new Dimension( 80, 35 ) );
        cancel2=new JButton("Cancel");
        cancel2.setPreferredSize(new Dimension(350,60));
        leaveapply=new JButton("Apply");
        viewbtn2=new JButton("View");
	    viewbtn2.setPreferredSize(new Dimension(150,60));
	    log2gm=new JButton("Request for Logistics");
	    log2gm.setPreferredSize(new Dimension(320,140));
	    GridBagConstraints gbc = new GridBagConstraints();
		request=new JComboBox<String>();
		staffm=new JComboBox<String>();
		logdept=new JComboBox<String>();
		sendleaveto=new JComboBox<String>();
		sendleaveto.setFont(new Font("Courier", Font.ITALIC, 14));
		request.addItem("Select option");
		request.addItem("New Users");
		request.addItem("Request for leave");
		staffm.setModel(new DefaultComboBoxModel(stafflist.toArray()));
		logdept.addItem("Select Department");
		logdept.addItem("Electricity");
		logdept.addItem("HVAC");
		logdept.addItem("AV");
		logdept.addItem("Security");
		logdept.addItem("Housekeeping");
		sendleaveto.addItem("Select option");
		sendleaveto.addItem("gm");
		sendleaveto.addItem("Department Supervisor");
		pane1=new JPanel();
		pane2=new JPanel();
		fpane6=new JPanel();
		pane1.setLayout(new GridLayout(2,1));
		pane2.setLayout(new GridLayout(1,2));
		pane1.add(request);
		pane1.add(pane2);
		ok=new JButton("OK");
		cancel=new JButton("Cancel");
		ok2=new JButton("OK");
		ok3=new JButton("OK");
		ok4=new JButton("OK");
		submit=new JButton("Submit");
		submit.setPreferredSize(new Dimension(350,60));
		submit2=new JButton("Submit");
		submit2.setPreferredSize(new Dimension(350,60));
		pane2.add(ok);
		pane2.add(cancel);
		frame7=new JFrame("");
		frame8=new JFrame("TASK REPORTS");
		frame9=new JFrame("View Logistics");
		frame7.setSize(300,200);
		frame7.setLocationRelativeTo(null);
		frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame8.setSize(300,200);
		frame8.setLocationRelativeTo(null);
		frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame9.setSize(300,200);
		frame9.setLocationRelativeTo(null);
		frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame10=new JFrame("Send Logistic request for inventory to gm");
		frame10.setSize(600,575);
		frame10.setLocationRelativeTo(null);
		frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fpane3=new JPanel();
		fpane3.add(ok2,gbc);
		frame7.add(fpane3);
		fpane4=new JPanel();
		fpane5=new JPanel();
		fpane4.add(ok3,gbc);
		fpane5.add(ok4,gbc);
		warning=new JLabel("* You cannot request for more than 10 items at once");
		
		frame8.add(fpane4);	
		frame9.add(fpane5);
		fpane2=new JPanel();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss, dd MMM yyyy ");
		Calendar cal = Calendar.getInstance();
		date=new JLabel("Logged in at: " + dateFormat.format(cal.getTime()));		
		date.setFont (date.getFont ().deriveFont (15.0f));		
		fms=new JLabel("FACILITY MANAGEMENT SERVICES SYSTEM");
		fms.setFont(fms.getFont ().deriveFont (30.0f));
		fms.setForeground(Color.red);
		
		welcome=new JLabel("Welcome " + Login.username + " !");
		welcome.setFont (welcome.getFont ().deriveFont (20.0f));
		
		loggeduser=new JLabel("Logged in as Staff");
		loggeduser.setFont (loggeduser.getFont ().deriveFont (15.0f));
		
		final DefaultTableModel model = new DefaultTableModel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				case 1:
					return String.class;
				default: 
					return String.class;
				}
			}
		};
		final DefaultTableModel model2 = new DefaultTableModel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				case 1:
					return String.class;
				default: 
					return String.class;
				}
			}
		};
		final DefaultTableModel model3 = new DefaultTableModel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				default: 
					return String.class;
				}
			}
		};
		final DefaultTableModel model4 = new DefaultTableModel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;
				default: 
					return String.class;
				}
			}
		};
		
		final DefaultTableModel model6 = new DefaultTableModel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Integer.class;
				case 1:
					return String.class;
				case 2:
					return Integer.class;
				default: 
					return String.class;
				}
			}
		};
		final DefaultTableModel model7 = new DefaultTableModel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Integer.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				default: 
					return String.class;
				}
			}
		};
		
		sp6=new JScrollPane();
		sp7=new JScrollPane();
		sp6.setPreferredSize(new Dimension(500,320));
		sp7.setPreferredSize(new Dimension(500,320));
		table2 =new JTable();
		table = new JTable();
		table3=new JTable();
		table4=new JTable();
		table5=new JTable();
		table6=new JTable();
		table7=new JTable();
		table.setRowHeight(30);
		table2.setRowHeight(30);
		table3.setRowHeight(30);
		table4.setRowHeight(30);
		table5.setRowHeight(30);
		table6.setRowHeight(30);
		table7.setRowHeight(30);
		//table.setColumnWidth(20);
		//sp.setViewportView(table);
				table6.setModel(model6);
		table7.setModel(model7);
		/*table.setEnabled(false);
		table2.setEnabled(false);
		table3.setEnabled(false);*/
		
		// demand logistics
		model6.addColumn("S No.");
		model6.addColumn("Items");
		model6.addColumn("Quantity");
		
		// task status
		model7.addColumn("Task ID");
		model7.addColumn("Task Name");
		model7.addColumn("Status");
		
		// Data Row
		
		for (int i = 0; i < 10; i++) {
			model6.addRow(new Object[0]);		
			}

////////////////////////////////////////////// Task status table ////////////////////////////////////////////////

		ArrayList<Task> tasks=null;
		
		
		if(department.equals("electricity"))
		{
			tasks=m3.electricity.task_list;
			
		}
		else if(department.equals("hvac"))
		{
			tasks=m3.hvac.task_list;
			
		}
		else if(department.equals("av"))
		{
			tasks=m3.av.task_list;
			
		}
		else if(department.equals("security"))
		{
			
			tasks=m3.security.task_list;
			
		}
		else if(department.equals("housekeeping"))
		{
			tasks=m3.housekeeping.task_list;
		}
		
		for (int i = 0; i <tasks.size(); i++) {
			Task t2=tasks.get(i);
			ArrayList<String> namelist=t2.staff;
			if(namelist.contains(username))
			{
				model7.addRow(new Object[0]);
				model7.setValueAt(t2.task_id, i, 0);
				model7.setValueAt(t2.task_name, i, 1);
				model7.setValueAt(t2.status, i, 2);
			}
		
		}
	
	submit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Logistic request sent to gm for approval");
			frame10.setVisible(false);	
			while(model6.getRowCount() > 0)
			{
			    model6.removeRow(0);
			}
			for (int i = 0; i < 10; i++) {
				model6.addRow(new Object[0]);		
				}
		}
	});
	submit2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Task Report Created!");
			t1.setText(null);
			t2.setText(null);
			area.setText(null);
			area3.setText(null);
			t4.setText(null);
			t5.setText(null);
			
		}
	});
	cancel2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame10.setVisible(false);	
			while(model6.getRowCount() > 0)
			{
			    model6.removeRow(0);
			}
			for (int i = 0; i < 10; i++) {
				model6.addRow(new Object[0]);		
				}
		}
	});
	fpane6.add(logdept,gbc);
	sp6.setBorder(BorderFactory.createEmptyBorder());
	fpane6.add(sp6, gbc);
	sp6.setViewportView(table6);
	fpane6.add(submit, gbc);
	fpane6.add(cancel2,gbc);
	fpane6.add(warning, gbc);
	frame10.add(fpane6);
		ImageIcon vb = new ImageIcon("view.png");
		Image image11 = vb.getImage(); // transform it 
		Image newimg11 = image11.getScaledInstance(155, 90,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		vb = new ImageIcon(newimg11);
	    viewbtn = new JButton(vb);
	    //deletebtn.setPreferredSize(new Dimension(100, 680));
	    viewbtn.setOpaque(false);
	    viewbtn.setContentAreaFilled(false);
	   viewbtn.setBorderPainted(false);
	    viewbtn.setToolTipText("View user");
		viewbtn.setPreferredSize(new Dimension(200, 200));
		viewbtn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame7.setVisible(true);	
			}
		});
		log2gm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame10.setVisible(true);
				}
		});
		
		 ImageIcon db = new ImageIcon("delete.png");
			Image image10 = db.getImage(); // transform it 
			Image newimg10 = image10.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
			db = new ImageIcon(newimg10);
		    deletebtn = new JButton(db);
		    //deletebtn.setPreferredSize(new Dimension(100, 680));
		    deletebtn.setOpaque(false);
		    deletebtn.setContentAreaFilled(false);
		   deletebtn.setBorderPainted(false);
		    deletebtn.setToolTipText("Delete user");
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				for (int i = 0; i < table.getRowCount(); i++) {
					Boolean chked = Boolean.valueOf(table.getValueAt(i, 0)
							.toString());
					
					//String dataCol1 = table.getValueAt(i, 1).toString();
					if (chked) {
						model.removeRow(i);
						int l=table.getRowCount();
						l--;
						i=0;
						
	
					}
				}
			}

		});
		deletebtn.setPreferredSize(new Dimension(200, 200));
		
		
		imageIcon = new ImageIcon("C:/Users/Harshit/workspace/fms_project/src/fms_project/logonew.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(150, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		logo = new JLabel(imageIcon);
		
		ImageIcon logs = new ImageIcon("logistics.png");
		Image image3 = logs.getImage(); // transform it 
		Image newimg3 = image3.getScaledInstance(230, 160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		logs = new ImageIcon(newimg3);
	    logsbtn = new JButton(logs);
	    logsbtn.setPreferredSize(new Dimension(160, 170));
	    logsbtn.setOpaque(false);
	    logsbtn.setContentAreaFilled(false);
	    logsbtn.setBorderPainted(false);
	    logsbtn.setToolTipText("Demand Logistics");
	    
	    ImageIcon reps = new ImageIcon("report.png");
		Image image4 = reps.getImage(); // transform it 
		Image newimg4 = image4.getScaledInstance(170, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		reps = new ImageIcon(newimg4);
	    repsbtn = new JButton(reps);
	    repsbtn.setPreferredSize(new Dimension(160, 170));
	    repsbtn.setOpaque(false);
	    repsbtn.setContentAreaFilled(false);
	    repsbtn.setBorderPainted(false);
	    repsbtn.setToolTipText("Generate Report");
	    
	    ImageIcon reqs = new ImageIcon("leave.png");
		Image image5 = reqs.getImage(); // transform it 
		Image newimg5 = image5.getScaledInstance(145, 140,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		reqs = new ImageIcon(newimg5);
	    leavebtn = new JButton(reqs);
	    leavebtn.setPreferredSize(new Dimension(160, 170));
	    leavebtn.setOpaque(false);
	    leavebtn.setContentAreaFilled(false);
	    leavebtn.setBorderPainted(false);
	    leavebtn.setToolTipText("Send Leave");
	    
	    ImageIcon task = new ImageIcon("task.png");
		Image image6 = task.getImage(); // transform it 
		Image newimg6 = image6.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		task = new ImageIcon(newimg6);
	    taskbtn = new JButton(task);
	    taskbtn.setPreferredSize(new Dimension(150, 150));
	    taskbtn.setOpaque(false);
	    taskbtn.setContentAreaFilled(false);
	    taskbtn.setBorderPainted(false);
	    taskbtn.setToolTipText("Change Task Status");
	    
	    ImageIcon lout = new ImageIcon("logout.png");
		Image image7 = lout.getImage(); // transform it 
		Image newimg7 = image7.getScaledInstance(150, 130,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		lout = new ImageIcon(newimg7);
	    loutbtn = new JButton(lout);
	    loutbtn.setPreferredSize(new Dimension(160, 170));
	    loutbtn.setOpaque(false);
	    loutbtn.setContentAreaFilled(false);
	    loutbtn.setBorderPainted(false);
	    loutbtn.setToolTipText("Logout");
	    
	    l2=new JLabel("LOGISTICS");
	    l3=new JLabel("REPORTS");
	    l4=new JLabel("LEAVE");
	    l5=new JLabel("TASK STATUS");
	    l6=new JLabel("LOGOUT");
	    disphome=new JLabel("HOME PAGE");
	    l2.setFont (l2.getFont ().deriveFont (20.0f));
	    l3.setFont (l3.getFont ().deriveFont (20.0f));
	    l4.setFont (l4.getFont ().deriveFont (20.0f));
	    l5.setFont (l5.getFont ().deriveFont (20.0f));
	    l6.setFont (l6.getFont ().deriveFont (20.0f));
	    disphome.setFont (disphome.getFont ().deriveFont (30.0f));
	    //disphome.setText("<HTML>H<br>O<br>M<br>E</HTML>");
	    disphome.setForeground(Color.DARK_GRAY);
	    disphome.setBackground(Color.RED);
	    //disphome.setOpaque(true);
	  
	   
	    
	    ok2.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
				frame7.dispose();
				
		
			}
		});
	    ok3.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
				frame8.dispose();
				
		
			}
		});
	    ok4.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
				frame9.dispose();
				
		
			}
		});
	    
	    leavebtn.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		lt1.setText("DD/MM/YYYY");
		lt2.setText("no_of_days");
		lt3.setText("DD/MM/YYYY");
		lt4.setText("DD/MM/YYYY");
		area2.setText(null);
		fpane2.removeAll();
		otherhome();
		leavechoice();	
		fpane2.revalidate();
		fpane2.repaint();
			}
		});
	    taskbtn.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			taskGUI();
				
			}
		});
	    
	    logsbtn.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	    logsGUI();
	}
		});
	    
	   repsbtn.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	    repsGUI();
	    
	}
		});
	    
		btn1=new JButton("Home");
		btn3=new JButton("Logistics");
		btn4=new JButton("Reports");
		btn5=new JButton("Leave");
		btn6=new JButton("Task Status");
		btn7=new JButton("Logout");
		acusrbtn=new JButton("Accept");
		rjusrbtn=new JButton("Reject");
		aclvbtn=new JButton("Accept");
		rjlvbtn=new JButton("Reject");
		update=new JButton("Update");
		btn1.setPreferredSize(new Dimension(200, 60));
		btn3.setPreferredSize(new Dimension(200, 60));
		btn4.setPreferredSize(new Dimension(200, 60));
		btn5.setPreferredSize(new Dimension(200, 60));
		btn6.setPreferredSize(new Dimension(200, 60));
		btn7.setPreferredSize(new Dimension(200, 60));
		acusrbtn.setPreferredSize(new Dimension(200, 60));
		rjusrbtn.setPreferredSize(new Dimension(200, 60));
		aclvbtn.setPreferredSize(new Dimension(200, 60));
		rjlvbtn.setPreferredSize(new Dimension(200, 60));
		update.setPreferredSize(new Dimension(200, 60));
		leaveapply.setPreferredSize(new Dimension(200, 60));
		update.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Task Status Updated !");
		Task.taskcount++;
		t2.setText(null);
		t4.setText("DD/MM/YYYY");
		area.setText(null);
		taskGUI();
	}
});
		leaveapply.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Leave sent for approval !");
		lt1.setText("DD/MM/YYYY");
		lt2.setText("no_of_days");
		lt3.setText("DD/MM/YYYY");
		lt4.setText("DD/MM/YYYY");
		area2.setText(null);
		creategmhome();
	}
});
		btn1.addActionListener(new ActionListener()
				{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				creategmhome();
				
				}
	});
		btn3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			    logsGUI();
			}
				});
		btn4.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repsGUI();
	    }
		});
		btn5.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		fpane2.removeAll();
		otherhome();
		leavechoice();	
		fpane2.revalidate();
		fpane2.repaint();
		}
});
		btn6.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		taskGUI();
		}
});
		loutbtn.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame4.dispose();
		Home_page.frame1.setVisible(true);
		
		}
});
		btn7.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame4.dispose();
		Home_page.frame1.setVisible(true);
		
		}
});
		
		acusrbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				for (int i = 0; i < table2.getRowCount(); i++) {
					Boolean chked = Boolean.valueOf(table2.getValueAt(i, 0)
							.toString());
					
					//String dataCol1 = table.getValueAt(i, 1).toString();
					if (chked) {
						model2.removeRow(i);
						int l=table2.getRowCount();
						l--;
						i=0;
					
					}
				}
			}

		});
		rjusrbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				for (int i = 0; i < table2.getRowCount(); i++) {
					Boolean chked = Boolean.valueOf(table2.getValueAt(i, 0)
							.toString());
					
					//String dataCol1 = table.getValueAt(i, 1).toString();
					if (chked) {
						model2.removeRow(i);
						int l=table2.getRowCount();
						l--;
						i=0;
					
					}
				}
			}
			
		});
		aclvbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				for (int i = 0; i < table3.getRowCount(); i++) {
					Boolean chked = Boolean.valueOf(table3.getValueAt(i, 0)
							.toString());
					
					//String dataCol1 = table.getValueAt(i, 1).toString();
					if (chked) {
						model3.removeRow(i);
						int l=table3.getRowCount();
						l--;
						i=0;
					
					}
				}
			}

		});
		rjlvbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				for (int i = 0; i < table3.getRowCount(); i++) {
					Boolean chked = Boolean.valueOf(table3.getValueAt(i, 0)
							.toString());
					
					//String dataCol1 = table.getValueAt(i, 1).toString();
					if (chked) {
						model3.removeRow(i);
						int l=table3.getRowCount();
						l--;
						i=0;
					
					}
				}
			}
			
		});
		GridBagLayout gridbag = new GridBagLayout();
		
		frame4=new JFrame("Admin Home");
		frame4.setVisible(true);
		frame4.setSize(350,120);
		frame4.setLocationRelativeTo(null);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		fpane2.setLayout(gridbag);
		creategmhome();
		
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
	
	public static void otherhome()
	{
		fpane2.removeAll();
		
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
		fpane2.add(btn6,new GridBagConstraints(
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
		fpane2.add(btn7,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(450, // inset top
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
		
	}
	
	public static void creategmhome()
	{
		fpane2.removeAll();
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
		fpane2.add(taskbtn,new GridBagConstraints(0, // gridx
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
		fpane2.add(leavebtn,new GridBagConstraints(0, // gridx
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
		fpane2.add(loutbtn,new GridBagConstraints(0, // gridx
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
		/*fpane2.add(loutbtn,new GridBagConstraints(0, // gridx
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
                0));*/
		
		fpane2.add(l5,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.WEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(60, // inset top
                81, // inset left
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
                124, // inset left
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
		/*fpane2.add(l6,new GridBagConstraints(0, // gridx
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
                0));*/
		fpane2.add(l6,new GridBagConstraints(0, // gridx
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
		fpane2.add(disphome,new GridBagConstraints(0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTHEAST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                0, // inset left
                0, // inset bottom
                0), // inset right
                0, // ipadx
                0));
				
		fpane2.revalidate();
		fpane2.repaint();
	}
	
	public static void logsGUI()
	{
		frame10.setVisible(true);
	
	}

	public static void repsGUI()
	{
		task1.setText("Task id: ");
		otherhome();
		fpane2.add(task1,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(130, // inset top
                240, // inset left
                000, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(t1,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(138, // inset top
                367, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(task2,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(130, // inset top
                450, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		
		fpane2.add(t2,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(138, // inset top
                630, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(task3,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(195, // inset top
                240, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(scrollPane,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(250, // inset top
                240, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(scrollPane3,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(382, // inset top
                240, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(task4,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(520, // inset top
                43, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(task5,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(330, // inset top
                240, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(task6,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(456, // inset top
                240, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(t4,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(530, // inset top
                240, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(t5,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(465, // inset top
                430, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(submit2,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTH, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                50, // inset left
                10, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		
	}
	

	public static void taskGUI()
	{
		otherhome();
		
		sp7.setBorder(BorderFactory.createEmptyBorder());

		fpane2.add(sp7,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.CENTER, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(22, // inset top
                200, // inset left
                100, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		sp7.setViewportView(table7);
		fpane2.add(update,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTH, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                145, // inset left
                60, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(staffm,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHEAST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(140, // inset top
                0, // inset left
                0, // inset bottom
                95), // inset right
                0, // ipadx
                0)
				);
	}
	
	public static void leavechoice()
	{
		fpane2.add(lv1,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(140, // inset top
                240, // inset left
                000, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(lt1,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(140, // inset top
                370, // inset left
                000, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(lv2,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(140, // inset top
                500, // inset left
                000, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(lt2,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(140, // inset top
                660, // inset left
                000, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(lv3,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(205, // inset top
                240, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		
		fpane2.add(lt3,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(205, // inset top
                370, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(lv4,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(205, // inset top
                500, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		
		fpane2.add(lt4,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(205, // inset top
                660, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(lv5,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(260, // inset top
                240, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(scrollPane2,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(320, // inset top
                240, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(leaveapply,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTH, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(515, // inset top
                0, // inset left
                10, // inset bottom
                100), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(sendleaveto,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTH, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(528, // inset top
                545, // inset left
                0, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void send_log_req(Main a, Logistic_request m){
		m.add_info(a);
	}

	public void send_leave(Main a, Leave b){
		//status during leave
		b.add_info(a);
		ArrayList<Staff> z= null;
        String csvfile=null;
        PrintWriter br=null;
        if(department.equals("electricity")){
            z=a.electricity.staff;
            csvfile="electricity.csv";
        }
        else if(department.equals("av")){
            z=a.av.staff;
            csvfile="av.csv";
        }
        else if(department.equals("hvac")){
            z=a.hvac.staff;
            csvfile="hvac.csv";
        }
        else if(department.equals("security")){
            z=a.security.staff;
            csvfile="security.csv";
        }
        else if(department.equals("housekeeping")){
            z=a.housekeeping.staff;
            csvfile="housekeeping.csv";
        }
        int j;
        for(j=0;j<z.size();j++){
            Staff y= z.get(j);
            if(y.username.equals(this.username)){
            	z.remove(y);
            }
        }
        this.status="On Leave( "+b.end_date+" )";
        z.add(this);
        try {
            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile)));
            for(j=0;j<z.size();j++){
            	Staff y= z.get(j);
            	br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+","+y.status+"\n");
            }
            //br=null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        a.read_database();
	}

	public void update_status(Main a, Task b, String v){
		ArrayList<Task> z= null;
		ArrayList<Staff> o=null;
        String csvfile=null;
        PrintWriter br=null;
        String wcsvfile=null;
        if(department.equals("electricity")){
            z=a.electricity.task_list;
            csvfile="electricity_task.csv";
            o=a.electricity.staff;
            wcsvfile="electricity.csv";
        }
        else if(department.equals("av")){
            z=a.av.task_list;
            csvfile="av_task.csv";
            o=a.av.staff;
            wcsvfile="av.csv";
        }
        else if(department.equals("hvac")){
            z=a.hvac.task_list;
            csvfile="hvac_task.csv";
            o=a.hvac.staff;
            wcsvfile="hvac.csv";
        }
        else if(department.equals("security")){
            z=a.security.task_list;
            csvfile="security_task.csv";
            o=a.security.staff;
            wcsvfile="security.csv";
        }
        else if(department.equals("housekeeping")){
            z=a.housekeeping.task_list;
            csvfile="housekeeping_task.csv";
            o=a.housekeeping.staff;
            wcsvfile="housekeeping.csv";
        }
        z.remove(b);
        b.status=v;
        z.add(b);
        try {
            int j;
            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile)));
            for(j=0;j<z.size();j++){
                Task h=z.get(j);
                
                br.write(h.task_id+","+h.deadline[0]+","+h.deadline[1]+","+h.deadline[2]+","+h.task_name+","+h.task_description+","+h.department+","+h.supervisor+","+h.status);
                int i;
                for(i=0;i<h.staff.size();i++){
                    br.write(","+h.staff.get(i));
                }
                br.write("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        if(v.equals("Completed")){
        	int i,j;
        	for(i=0;i<b.staff.size();i++){
            	for(j=0;j<o.size();j++){
                	Staff y= o.get(j);
                	if(y.username.equals(b.staff.get(i))){
                    	y.status="Available";
                    	break;
                	}
            	}
        	}
        	try {
            	br =new PrintWriter(new BufferedWriter(new FileWriter(wcsvfile)));
            	for(j=0;j<o.size();j++){
                	Staff y= o.get(j);
                	br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+","+y.status+"\n");
            	}
            //br=null;
        	} catch (FileNotFoundException e) {
            	e.printStackTrace();
        	} catch (IOException e) {
            	e.printStackTrace();
        	} finally {
            	if (br != null) {
                	br.close();
            	}
        	}
        }
        a.read_database();
	}

    public void generate_report(String z, String a, String b, String c, String d, String e, String f){
        File file= new File(b+".docx");
        PrintWriter br=null;
        try{
          br=new PrintWriter(new BufferedWriter(new FileWriter(file)));
          br.write("\t\tTask Report\n\n");
          br.write("\tTask Name: "+b+"\n\n");
          br.write("\tTask Id: "+a+"\n\n");
          br.write("\tReport by StaffId: "+z+"\n\n");
          br.write("\tTask Description: "+c+"\n\n");
          br.write("\tStatus of the task: Completed"+"\n\n");
          br.write("\tItems Used: "+d+"\n\n");
          br.write("\tDuration of the task: "+e+"\n\n");
          br.write("\tComments: "+f+"\n\n");
        }catch (FileNotFoundException q) {
            q.printStackTrace();
        } catch (IOException q) {
            q.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(b+".docx"));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void generate_report(String b){
        File file= new File(b+".docx");
        PrintWriter br=null;
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(b+".docx"));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
	
	public String toString(){
		return (username+name+passwd+userid+type+dob+address+department+status);
	}
}
