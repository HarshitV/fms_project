package fms_project;

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

import java.lang.*;
import java.io.*;
import java.util.*;
// table and sp are staff lists to view or delete
// table 2 and sp2 are user request lists
// table 3 and sp3 are leave requests
// table 4 and sp4 are logistic requests
public class Supervisor extends User{
	ArrayList<String> deletedusers=new ArrayList<String>();
	ArrayList<String> newusers=new ArrayList<String>();
	ArrayList<String> newusers2=new ArrayList<String>();
	
	String department=null;
	private static JComboBox<String> staffm,staffm2,request,logdept,fwdtask;
	private static JTextArea area,area2;
	private static JTable table,table2,table3,table4,table5,table6,table7;
	private static JScrollPane scrollPane2,scrollPane,sp,sp2,sp3,sp4,sp5,sp6,sp7;
	private static JFrame frame4,frame6,frame7,frame8,frame9,frame10,frame11;
	private static JPanel fpane2,pane1,pane2,fpane3,fpane4,fpane5,fpane6,fpane7;
	private static JButton cancel2,submit,ok6,leaveapply,inventory,log2gm,ok4,viewbtn3,createtask,ok3,viewrep,aclgbtn,rjlgbtn,aclvbtn,rjlvbtn,acusrbtn,rjusrbtn,viewbtn,viewbtn2,deletebtn ,btn1,btn2,btn3,btn4,btn5,btn6,btn7,ok2,ok,cancel,repsbtn,reqsbtn,taskbtn,loutbtn,logsbtn,staffbtn;
	private static JLabel warning,lv1,lv2,lv3,lv4,lv5,task1,task2,task3,task4,fms,logo,date,welcome,l1,l2,l3,l4,l5,l6,disphome,loggeduser;
	private static ImageIcon imageIcon;
	private static JTextField t2,t4,lt1,lt2,lt3,lt4;
	private String viewuser;
	ArrayList<String> tasklist=new ArrayList<String>();
	
	//ArrayList<logistic_req> req_list=new ArrayList<logistic_req>();
	//ArrayList<leave> leave_list=new ArrayList<leave>();
	
	Supervisor(){

	}

	Supervisor(String[] a){
		username=a[0];
		name=a[1];
		passwd=a[2];
		userid=a[3];
		type=a[4];
		dob=a[5];
		address=a[6];
		department=a[7];
	}
	
	public void createGUI()
	{
		Main m3=new Main();
		m3.read_database();
		ArrayList<Staff> allstaff=null;
		ArrayList<Task> tasksl=null;
		if(department.equals("electricity"))
		{
			allstaff=m3.electricity.staff;
			tasksl=m3.electricity.task_list;
		}
		else if(department.equals("hvac"))
		{
			allstaff=m3.hvac.staff;
			tasksl=m3.hvac.task_list;
		}
		else if(department.equals("av"))
		{
			allstaff=m3.av.staff;
			tasksl=m3.av.task_list;
		}
		else if(department.equals("security"))
		{
			allstaff=m3.security.staff;
			tasksl=m3.security.task_list;
		}
		else if(department.equals("housekeeping"))
		{
			allstaff=m3.housekeeping.staff;
			tasksl=m3.housekeeping.task_list;
		}
		ArrayList<String> stafflist=new ArrayList<String>();
		stafflist.add("Select staff member: ");
		tasklist.add("Select task: ");
		
		for(int i=0;i<allstaff.size();i++)
		{	
			stafflist.add(allstaff.get(i).username.concat("-").concat(allstaff.get(i).status));
		}
		for(int i=0;i<tasksl.size();i++)
		{	
			tasklist.add(tasksl.get(i).task_name);
		}
		//System.out.println(allstaff);
		area=new JTextArea(5,20);
		area.setColumns(29);
		area.setLineWrap (true);
		area.setWrapStyleWord (false);
		area.setFont(new Font("Serif", Font.PLAIN, 24));
		scrollPane = new JScrollPane(area);
		area2=new JTextArea(5,20);
		area2.setColumns(29);
		area2.setLineWrap (true);
		area2.setWrapStyleWord (false);
		area2.setFont(new Font("Serif", Font.PLAIN, 24));
		scrollPane2 = new JScrollPane(area2);
		
		
		lv1=new JLabel("Date today: ");
		lv2=new JLabel("Leave duration: ");
		lv3=new JLabel("Start Date: ");
		lv4=new JLabel("End Date: ");
		lv5=new JLabel("Leave Application: ");
		task1=new JLabel("Task id: " + Task.taskcount);
		task2=new JLabel("Task Name: ");
		task3=new JLabel("Task Description: ");
		task4=new JLabel("Task Deadline: ");
		lv1.setFont(new Font("Serif", Font.PLAIN, 24));
		lv2.setFont(new Font("Serif", Font.PLAIN, 24));
		lv3.setFont(new Font("Serif", Font.PLAIN ,24));
		lv4.setFont(new Font("Serif", Font.PLAIN ,24));
		lv5.setFont(new Font("Serif", Font.PLAIN ,34));
		task1.setFont(new Font("Serif", Font.PLAIN, 34));
		task2.setFont(new Font("Serif", Font.PLAIN, 34));
		task3.setFont(new Font("Serif", Font.PLAIN ,34));
		task4.setFont(new Font("Serif", Font.PLAIN ,34));
		task1.setHorizontalAlignment(SwingConstants.LEFT);
		task2.setHorizontalAlignment(SwingConstants.LEFT);
		task3.setHorizontalAlignment(SwingConstants.LEFT);
		task4.setHorizontalAlignment(SwingConstants.LEFT);
		lv1.setHorizontalAlignment(SwingConstants.LEFT);
		lv2.setHorizontalAlignment(SwingConstants.LEFT);
		lv3.setHorizontalAlignment(SwingConstants.LEFT);
		lv4.setHorizontalAlignment(SwingConstants.LEFT);
		lv5.setHorizontalAlignment(SwingConstants.LEFT);
		lt1=new JTextField("DD/MM/YYYY");
		lt2=new JTextField("");
		lt3=new JTextField("DD/MM/YYYY");
		lt4=new JTextField("DD/MM/YYYY");
		t2=new JTextField("");
		t4=new JTextField("DD/MM/YYYY");
        t2.setPreferredSize( new Dimension( 330, 35 ) );
        t4.setPreferredSize( new Dimension( 305, 35 ) );
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
	    viewbtn3=new JButton("View");
	    viewbtn3.setPreferredSize(new Dimension(120,40));
	    log2gm=new JButton("Demand new");
	    log2gm.setPreferredSize(new Dimension(120,40));
	    inventory=new JButton("Inventory");
	    inventory.setPreferredSize(new Dimension(120,40));
	    viewrep=new JButton("View");
	    viewrep.setPreferredSize(new Dimension(150,60));
		GridBagConstraints gbc = new GridBagConstraints();
		request=new JComboBox<String>();
		staffm=new JComboBox<String>();
		staffm2=new JComboBox<String>();
		fwdtask=new JComboBox<String>();
		logdept=new JComboBox<String>();
		request.addItem("Select option");
		request.addItem("New Users");
		request.addItem("Leave Requests");
		request.addItem("Request for leave");
		staffm.setModel(new DefaultComboBoxModel(stafflist.toArray()));
		fwdtask.setModel(new DefaultComboBoxModel(tasklist.toArray()));
		staffm2.setModel(new DefaultComboBoxModel(stafflist.toArray()));
		logdept.addItem("Select Department");
		logdept.addItem("Electricity");
		logdept.addItem("HVAC");
		logdept.addItem("AV");
		logdept.addItem("Security");
		logdept.addItem("Housekeeping");
		frame6=new JFrame("REQUESTS");
		frame6.setVisible(false);
		frame6.setSize(350,120);
		frame6.setLocationRelativeTo(null);
		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane1=new JPanel();
		pane2=new JPanel();
		fpane6=new JPanel();
		fpane7=new JPanel();
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
		ok6=new JButton("OK");
		ok6.setPreferredSize(new Dimension(350,60));

		pane2.add(ok);
		pane2.add(cancel);
		frame6.add(pane1);
		//frame6.add(pane2);
		frame7=new JFrame("User Data");
		frame8=new JFrame("TASK REPORTS");
		frame9=new JFrame("View Logistics");
		//frame6.setVisible(false);
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
		frame11=new JFrame("Logistic Inventory");
		frame11.setSize(600,575);
		frame11.setLocationRelativeTo(null);
		frame11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fpane3=new JPanel();
		fpane3.setLayout(new GridLayout(7,1));
		fpane4=new JPanel();
		fpane5=new JPanel();
		fpane5.add(ok4,gbc);
		warning=new JLabel("* You cannot request for more than 10 items at once");
			
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
		
		loggeduser=new JLabel("Logged in as Supervisor");
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
					return String.class;
				case 1:
					return String.class;
				case 2:
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
		final DefaultTableModel model5 = new DefaultTableModel() {

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
					return Integer.class;
				default: 
					return String.class;
				}
			}
		};
		
		sp=new JScrollPane(); 
		sp2=new JScrollPane();
		sp3=new JScrollPane();
		sp4=new JScrollPane();
		sp5=new JScrollPane();
		sp6=new JScrollPane();
		sp7=new JScrollPane();
		sp.setPreferredSize(new Dimension(500, 320));
		sp2.setPreferredSize(new Dimension(500,320));
		sp3.setPreferredSize(new Dimension(500,320));
		sp4.setPreferredSize(new Dimension(500,320));
		sp5.setPreferredSize(new Dimension(500,320));
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
		table.setModel(model);
		table2.setModel(model2);
		table3.setModel(model3);
		table4.setModel(model4);
		table5.setModel(model5);
		table6.setModel(model6);
		table7.setModel(model7);
		/*table.setEnabled(false);
		table2.setEnabled(false);
		table3.setEnabled(false);*/
		model.addColumn("Select");
		model.addColumn("User Name");
		
		model2.addColumn("Select");
		model2.addColumn("User Name");
		
		model3.addColumn("User Name");
		model3.addColumn("Start Date");
		model3.addColumn("End Date");
		
		model4.addColumn("Select");
		model4.addColumn("ID");
		model4.addColumn("Equipment list");
		model4.addColumn("Task ID");
		
		model5.addColumn("Select");
		model5.addColumn("Task ID");
		model5.addColumn("Task Name");
		model5.addColumn("Status");
		
		model6.addColumn("S No.");
		model6.addColumn("Items");
		model6.addColumn("Quantity");
		
		model7.addColumn("S No.");
		model7.addColumn("Items");
		model7.addColumn("Quantity");
		
////////////////////////////////////////////
		ArrayList<Staff> staffl=null;
		ArrayList<Staff> newuser=null;
		ArrayList<Leave> leaves=null;
		ArrayList<Logistic_request> logsr=null;
		ArrayList<Task> tasks=null;
		ArrayList<Logistic> log=null;
		
		if(department.equals("electricity"))
		{
			staffl=m3.electricity.staff;
			newuser=m3.electricity.new_staff;
			leaves=m3.electricity.leave_list;
			logsr=m3.electricity.req_list;
			tasks=m3.electricity.task_list;
			log=m3.electricity.logistic_list;
		}
		else if(department.equals("hvac"))
		{
			staffl=m3.hvac.staff;
			newuser=m3.hvac.new_staff;
			leaves=m3.hvac.leave_list;
			logsr=m3.hvac.req_list;
			tasks=m3.hvac.task_list;
			log=m3.hvac.logistic_list;
		}
		else if(department.equals("av"))
		{
			staffl=m3.av.staff;
			newuser=m3.av.new_staff;
			leaves=m3.av.leave_list;
			logsr=m3.av.req_list;
			tasks=m3.av.task_list;
			log=m3.av.logistic_list;
		}
		else if(department.equals("security"))
		{
			staffl=m3.security.staff;
			newuser=m3.security.new_staff;
			leaves=m3.security.leave_list;
			logsr=m3.security.req_list;
			tasks=m3.security.task_list;
			log=m3.security.logistic_list;
		}
		else if(department.equals("housekeeping"))
		{
			staffl=m3.housekeeping.staff;
			newuser=m3.housekeeping.new_staff;
			leaves=m3.housekeeping.leave_list;
			logsr=m3.housekeeping.req_list;
			tasks=m3.housekeeping.task_list;
			log=m3.housekeeping.logistic_list;
		}
	
		
//////////////////////////////////////////////////////////
		// Data Row
		for (int i = 0; i <staffl.size(); i++) {
			Staff y=staffl.get(i);
			model.addRow(new Object[0]);
			model.setValueAt(false, i, 0);
			model.setValueAt(y.username, i, 1);
		}
		for (int i = 0; i <newuser.size(); i++) {
			Staff y=newuser.get(i);
			model2.addRow(new Object[0]);
			model2.setValueAt(false, i, 0);
			model2.setValueAt(y.username, i, 1);
			}
		for (int i = 0; i <leaves.size(); i++) {
			Leave y=leaves.get(i);
			model3.addRow(new Object[0]);
			model3.setValueAt(y.user, i, 0);
			model3.setValueAt(y.start_date, i, 1);
			model3.setValueAt(y.end_date, i, 2);
			}
		for (int i = 0; i < 10; i++) {
			model6.addRow(new Object[0]);
			
			}
		
		for (int i = 0; i <logsr.size(); i++) {
			Logistic_request l=logsr.get(i);
			model4.addRow(new Object[0]);
			model4.setValueAt(false, i, 0);
			model4.setValueAt(l.id, i, 1);
			ArrayList<Logistic> l1=l.list_logistic;
			String str=null;
			String str2="";
			for(int j=0;j<l1.size();j++)
			{
				Logistic lgs=l1.get(j);
				str=lgs.equipment + "(" + lgs.quantity + ")  ";
				str2=str2.concat(str);
			}
			
			model4.setValueAt(str2, i, 2);
			model4.setValueAt(l.task_id, i, 3);
		
		}
	
	for (int i = 0; i <tasks.size(); i++) {
		Task t=tasks.get(i);
		model5.addRow(new Object[0]);
		model5.setValueAt(false, i, 0);
		model5.setValueAt(t.task_id, i, 1);
		model5.setValueAt(t.task_name, i, 2);
		model5.setValueAt(t.status, i, 3);
		}
	
	submit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < 10; i++) {
				model6.addRow(new Object[0]);		
				}
			String sel=logdept.getSelectedItem().toString();
			JOptionPane.showMessageDialog(null, "Logistic request sent to GM for approval");
			frame10.setVisible(false);	
			Logistic_request lreq=new Logistic_request();
			ArrayList<Logistic> arr = new ArrayList<Logistic>();
			for(int i=0;i<table6.getRowCount();i++)
			{
				Logistic lgs=new Logistic();
				if(model6.getValueAt(i, 1)!=null)
				{
				lgs.get_info(model6.getValueAt(i, 1).toString(),Integer.parseInt(model6.getValueAt(i, 2).toString()));
				arr.add(lgs);
				}
			}
			System.out.println(arr);
			lreq.get_info(userid, arr,"0", sel);
			//lreq.task_id
			/*while(model6.getRowCount() > 0)
			{
			    model6.removeRow(0);
			}*/
			send_log_req(m3,lreq);
			
		}
	});
	ok6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			frame11.setVisible(false);	
			
			
			//lreq.task_id
			/*while(model6.getRowCount() > 0)
			{
			    model6.removeRow(0);
			}*/
			
		}
	});
	
	cancel2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame10.setVisible(false);	
			
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

				for (int i = 0; i < table.getRowCount(); i++) {
					Boolean chked = Boolean.valueOf(table.getValueAt(i, 0)
							.toString());
					
					//String dataCol1 = table.getValueAt(i, 1).toString();
					if (chked) {
						viewuser=table.getValueAt(i, 1).toString();
						break;
					
					}
				}
				User u1=view_user(m3, viewuser);
				
				JLabel l1=new JLabel("Username: " + u1.username + "\n");
				JLabel l2=new JLabel("Name: " + u1.name + "\n");
				JLabel l3=new JLabel("User ID: " + u1.userid + "\n");
				JLabel l4=new JLabel("Designation: " + u1.type + "\n");
				JLabel l5=new JLabel("DOB: " + u1.dob + "\n");
				JLabel l6=new JLabel("Address: " + u1.address + "\n");
				
				fpane3.removeAll();
				
				
				fpane3.add(l1);
				fpane3.add(l2);
				fpane3.add(l3);
				fpane3.add(l4);
				fpane3.add(l5);
				fpane3.add(l6);
				fpane3.add(ok2);
				fpane3.revalidate();
				fpane3.repaint();
				frame7.add(fpane3);
				
				
				frame7.setVisible(true);	
			}
		});
		viewbtn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame9.setVisible(true);	
			}
		});
		inventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Logistic> mod=new ArrayList<Logistic>();
				if(department.equals("electricity"))
				{
					mod=m3.electricity.logistic_list;
				}
				else if(department.equals("hvac"))
				{
					mod=m3.hvac.logistic_list;
				}
				else if(department.equals("av"))
				{
					mod=m3.av.logistic_list;
				}
				else if(department.equals("security"))
				{
					mod=m3.security.logistic_list;
				}
				else if(department.equals("housekeeping"))
				{
					mod=m3.housekeeping.logistic_list;
				}
				for (int i = 0; i <mod.size(); i++) {
					Logistic lgst=mod.get(i);
					model7.addRow(new Object[0]);	
					model7.setValueAt(i+1, i, 0);
					model7.setValueAt(lgst.equipment,i,1);
					model7.setValueAt(lgst.quantity, i, 2);				
					}
				sp7.setBorder(BorderFactory.createEmptyBorder());
				fpane7.add(sp7, gbc);
				sp7.setViewportView(table7);
				fpane7.add(ok6,gbc);
				
				frame11.add(fpane7);
				frame11.setVisible(true);
	

			}
		});
		log2gm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame10.setVisible(true);
				sp5.setBorder(BorderFactory.createEmptyBorder());

				fpane2.add(sp5,new GridBagConstraints(
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
				fpane2.add(viewrep,new GridBagConstraints(
						0, // gridx
		                0, // gridy
		                1, // gridwidth
		                1, // gridheight
		                1, // weightx
		                1, // weighty
		                GridBagConstraints.SOUTH, // anchor <------------
		                GridBagConstraints.NONE, // fill
		                new Insets(0, // inset top
		                175, // inset left
		                80, // inset bottom
		                00), // inset right
		                0, // ipadx
		                0)
						);
				
				sp5.setViewportView(table5);
				

			}
		});
		
		viewrep.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {

				fpane4.add(ok3,gbc);
				for (int i = 0; i < table5.getRowCount(); i++) {
					Boolean chked = Boolean.valueOf(table5.getValueAt(i, 0)
							.toString());
					
					//String dataCol1 = table.getValueAt(i, 1).toString();
					if (chked) {
						generate_report(model5.getValueAt(i, 2).toString());
	
					}}
				
			}
		}
				);
		
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

				deletedusers.clear();
				for (int i = 0; i < table.getRowCount(); i++) {
					Boolean chked = Boolean.valueOf(table.getValueAt(i, 0)
							.toString());
					
					//String dataCol1 = table.getValueAt(i, 1).toString();
					if (chked) {
						deletedusers.add(table.getModel().getValueAt(i, 1).toString());
						model.removeRow(i);
						int l=table.getRowCount();
						l--;
						i=0;
						
	
					}
				}
				for(int i=0;i<deletedusers.size();i++)
				{
					delete_user(m3,deletedusers.get(i));
				}
				//System.out.println(deletedusers);
			}

		});
		deletebtn.setPreferredSize(new Dimension(200, 200));
		
		
		imageIcon = new ImageIcon("C:/Users/Harshit/workspace/fms_project/src/fms_project/logonew.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(150, 80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		logo = new JLabel(imageIcon);
		
		ImageIcon staff = new ImageIcon("staff2.png");
		Image image2 = staff.getImage(); // transform it 
		Image newimg2 = image2.getScaledInstance(170, 170,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		staff = new ImageIcon(newimg2);
	    staffbtn = new JButton(staff);
	    staffbtn.setPreferredSize(new Dimension(160, 170));
	    staffbtn.setOpaque(false);
	    staffbtn.setContentAreaFilled(false);
	    staffbtn.setBorderPainted(false);
	    staffbtn.setToolTipText("Staff");
	    
	    ImageIcon logs = new ImageIcon("logistics.png");
		Image image3 = logs.getImage(); // transform it 
		Image newimg3 = image3.getScaledInstance(230, 160,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		logs = new ImageIcon(newimg3);
	    logsbtn = new JButton(logs);
	    logsbtn.setPreferredSize(new Dimension(160, 170));
	    logsbtn.setOpaque(false);
	    logsbtn.setContentAreaFilled(false);
	    logsbtn.setBorderPainted(false);
	    logsbtn.setToolTipText("Logistics");
	    
	    ImageIcon reps = new ImageIcon("report.png");
		Image image4 = reps.getImage(); // transform it 
		Image newimg4 = image4.getScaledInstance(170, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		reps = new ImageIcon(newimg4);
	    repsbtn = new JButton(reps);
	    repsbtn.setPreferredSize(new Dimension(160, 170));
	    repsbtn.setOpaque(false);
	    repsbtn.setContentAreaFilled(false);
	    repsbtn.setBorderPainted(false);
	    repsbtn.setToolTipText("Reports");
	    
	    ImageIcon reqs = new ImageIcon("request.png");
		Image image5 = reqs.getImage(); // transform it 
		Image newimg5 = image5.getScaledInstance(180, 170,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		reqs = new ImageIcon(newimg5);
	    reqsbtn = new JButton(reqs);
	    reqsbtn.setPreferredSize(new Dimension(160, 170));
	    reqsbtn.setOpaque(false);
	    reqsbtn.setContentAreaFilled(false);
	    reqsbtn.setBorderPainted(false);
	    reqsbtn.setToolTipText("Requests");
	    
	    ImageIcon task = new ImageIcon("task.png");
		Image image6 = task.getImage(); // transform it 
		Image newimg6 = image6.getScaledInstance(160, 150,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		task = new ImageIcon(newimg6);
	    taskbtn = new JButton(task);
	    taskbtn.setPreferredSize(new Dimension(160, 170));
	    taskbtn.setOpaque(false);
	    taskbtn.setContentAreaFilled(false);
	    taskbtn.setBorderPainted(false);
	    taskbtn.setToolTipText("Assign Task");
	    
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
	    
	    l1=new JLabel("STAFF");
	    l2=new JLabel("LOGISTICS");
	    l3=new JLabel("REPORTS");
	    l4=new JLabel("REQUESTS");
	    l5=new JLabel("ASSIGN TASK");
	    l6=new JLabel("LOGOUT");
	    disphome=new JLabel("HOME PAGE");
	    l1.setFont (l1.getFont ().deriveFont (20.0f));
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
	    staffbtn.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		model.setRowCount(0);

		ArrayList<Staff> staffl=null;
		ArrayList<Staff> newuser=null;
		ArrayList<Leave> leaves=null;
		ArrayList<Logistic_request> logsr=null;
		ArrayList<Task> tasks=null;
		ArrayList<Logistic> log=null;
		if(department.equals("electricity"))
		{
			staffl=m3.electricity.staff;
			newuser=m3.electricity.new_staff;
			leaves=m3.electricity.leave_list;
			logsr=m3.electricity.req_list;
			tasks=m3.electricity.task_list;
			log=m3.electricity.logistic_list;
		}
		else if(department.equals("hvac"))
		{
			staffl=m3.hvac.staff;
			newuser=m3.hvac.new_staff;
			leaves=m3.hvac.leave_list;
			logsr=m3.hvac.req_list;
			tasks=m3.hvac.task_list;
			log=m3.hvac.logistic_list;
		}
		else if(department.equals("av"))
		{
			staffl=m3.av.staff;
			newuser=m3.av.new_staff;
			leaves=m3.av.leave_list;
			logsr=m3.av.req_list;
			tasks=m3.av.task_list;
			log=m3.av.logistic_list;
		}
		else if(department.equals("security"))
		{
			staffl=m3.security.staff;
			newuser=m3.security.new_staff;
			leaves=m3.security.leave_list;
			logsr=m3.security.req_list;
			tasks=m3.security.task_list;
			log=m3.security.logistic_list;
		}
		else if(department.equals("housekeeping"))
		{
			staffl=m3.housekeeping.staff;
			newuser=m3.housekeeping.new_staff;
			leaves=m3.housekeeping.leave_list;
			logsr=m3.housekeeping.req_list;
			tasks=m3.housekeeping.task_list;
			log=m3.housekeeping.logistic_list;
		}
		for (int i = 0; i <staffl.size(); i++) {
			Staff y=staffl.get(i);
			model.addRow(new Object[0]);
			model.setValueAt(false, i, 0);
			model.setValueAt(y.username, i, 1);
		}
		staffGUI();
		
		
		}
});
	  
	    cancel.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
				frame6.setVisible(false);
				
			}
		});
	    ok.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(request.getSelectedIndex()==0)
		{
			JOptionPane.showMessageDialog(null, "Select option first");
			//req.setBorder(border);
		}
		else if(request.getSelectedIndex()==1)
		{
				frame6.setVisible(false);
				fpane2.removeAll();
				otherhome();
				sp2.setBorder(BorderFactory.createEmptyBorder());

				fpane2.add(sp2,new GridBagConstraints(
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
				fpane2.add(rjusrbtn,new GridBagConstraints(
						0, // gridx
		                0, // gridy
		                1, // gridwidth
		                1, // gridheight
		                1, // weightx
		                1, // weighty
		                GridBagConstraints.SOUTHEAST, // anchor <------------
		                GridBagConstraints.NONE, // fill
		                new Insets(0, // inset top
		                00, // inset left
		                80, // inset bottom
		                100), // inset right
		                0, // ipadx
		                0)
						);
				fpane2.add(acusrbtn,new GridBagConstraints(
						0, // gridx
		                0, // gridy
		                1, // gridwidth
		                1, // gridheight
		                1, // weightx
		                1, // weighty
		                GridBagConstraints.SOUTHEAST, // anchor <------------
		                GridBagConstraints.NONE, // fill
		                new Insets(0, // inset top
		                00, // inset left
		                80, // inset bottom
		                300), // inset right
		                0, // ipadx
		                0)
						);
				sp2.setViewportView(table2);
				fpane2.revalidate();
				fpane2.repaint();
			}
		else if(request.getSelectedIndex()==2)
		{
			frame6.setVisible(false);
			fpane2.removeAll();
			otherhome();
			sp3.setBorder(BorderFactory.createEmptyBorder());

			fpane2.add(sp3,new GridBagConstraints(
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
			sp3.setViewportView(table3);
			fpane2.revalidate();
			fpane2.repaint();
		}
		else if(request.getSelectedIndex()==3)
		{
				frame6.setVisible(false);
				fpane2.removeAll();
				otherhome();
				leavechoice();
				fpane2.revalidate();
				fpane2.repaint();
			}
	}
		});
	    
		
		
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
	    
	    reqsbtn.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
				frame6.setVisible(true);
				
				
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
		btn2=new JButton("Staff");
		btn3=new JButton("Logistics");
		btn4=new JButton("Reports");
		btn5=new JButton("Requests");
		btn6=new JButton("Assign Task");
		btn7=new JButton("Logout");
		acusrbtn=new JButton("Accept");
		rjusrbtn=new JButton("Reject");
		aclvbtn=new JButton("Accept");
		rjlvbtn=new JButton("Reject");
		aclgbtn=new JButton("Approve");
		rjlgbtn=new JButton("Reject");
		createtask=new JButton("Assign to staff");
		btn1.setPreferredSize(new Dimension(200, 60));
		btn2.setPreferredSize(new Dimension(200, 60));
		btn3.setPreferredSize(new Dimension(200, 60));
		btn4.setPreferredSize(new Dimension(200, 60));
		btn5.setPreferredSize(new Dimension(200, 60));
		btn6.setPreferredSize(new Dimension(200, 60));
		btn7.setPreferredSize(new Dimension(200, 60));
		acusrbtn.setPreferredSize(new Dimension(200, 60));
		rjusrbtn.setPreferredSize(new Dimension(200, 60));
		aclvbtn.setPreferredSize(new Dimension(200, 60));
		rjlvbtn.setPreferredSize(new Dimension(200, 60));
		aclgbtn.setPreferredSize(new Dimension(200, 60));
		rjlgbtn.setPreferredSize(new Dimension(200, 60));
		createtask.setPreferredSize(new Dimension(200, 60));
		leaveapply.setPreferredSize(new Dimension(200, 60));
		createtask.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Task Assigned !");
		
		
		taskGUI();
		String x = staffm.getSelectedItem().toString();
		String y = staffm2.getSelectedItem().toString();
		String[] p1 = x.split("-");
		String[] p2 = y.split("-");
		String a1=p1[0];
		String b1=p2[0];
		String c1=fwdtask.getSelectedItem().toString();
		
		ArrayList<String> array=new ArrayList<String>();
		array.clear();
		if(staffm.getSelectedIndex()==0 && staffm2.getSelectedIndex()==0)
		{
			JOptionPane.showMessageDialog(null, "No staff selected");
		}
		else if(staffm.getSelectedIndex()==0)
		{
			array.add(b1);
			
			assign_task(m3,c1,array);
		}
		else if(staffm2.getSelectedIndex()==0)
		{
			array.add(a1);
			
			assign_task(m3,c1,array);
		}
		else
		{
			array.add(a1);
			array.add(b1);
			
			assign_task(m3,c1,array);
		}
	}
});
		leaveapply.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Leave sent for approval !");
		
		creategmhome();
		Leave lvv=new Leave();
		lvv.get_info(area2.getText(), lt1.getText(), lt3.getText(), Integer.parseInt(lt2.getText()), lt4.getText(),username, m3.admin.username);
		send_leave(m3,lvv);
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
		btn2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				table.removeAll();
				model.setRowCount(0);
				ArrayList<Staff> staffl=null;
				ArrayList<Staff> newuser=null;
				ArrayList<Leave> leaves=null;
				ArrayList<Logistic_request> logsr=null;
				ArrayList<Task> tasks=null;
				ArrayList<Logistic> log=null;
				if(department.equals("electricity"))
				{
					staffl=m3.electricity.staff;
					newuser=m3.electricity.new_staff;
					leaves=m3.electricity.leave_list;
					logsr=m3.electricity.req_list;
					tasks=m3.electricity.task_list;
					log=m3.electricity.logistic_list;
				}
				else if(department.equals("hvac"))
				{
					staffl=m3.hvac.staff;
					newuser=m3.hvac.new_staff;
					leaves=m3.hvac.leave_list;
					logsr=m3.hvac.req_list;
					tasks=m3.hvac.task_list;
					log=m3.hvac.logistic_list;
				}
				else if(department.equals("av"))
				{
					staffl=m3.av.staff;
					newuser=m3.av.new_staff;
					leaves=m3.av.leave_list;
					logsr=m3.av.req_list;
					tasks=m3.av.task_list;
					log=m3.av.logistic_list;
				}
				else if(department.equals("security"))
				{
					staffl=m3.security.staff;
					newuser=m3.security.new_staff;
					leaves=m3.security.leave_list;
					logsr=m3.security.req_list;
					tasks=m3.security.task_list;
					log=m3.security.logistic_list;
				}
				else if(department.equals("housekeeping"))
				{
					staffl=m3.housekeeping.staff;
					newuser=m3.housekeeping.new_staff;
					leaves=m3.housekeeping.leave_list;
					logsr=m3.housekeeping.req_list;
					tasks=m3.housekeeping.task_list;
					log=m3.housekeeping.logistic_list;
				}
				for (int i = 0; i <staffl.size(); i++) {
					Staff y=staffl.get(i);
					model.addRow(new Object[0]);
					model.setValueAt(false, i, 0);
					model.setValueAt(y.username, i, 1);
				}
				staffGUI();
				
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
		frame6.setVisible(true);
		
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


				newusers.clear();

				for (int i = 0; i < table2.getRowCount(); i++) {
					Boolean chked = Boolean.valueOf(table2.getValueAt(i, 0)
							.toString());
					
					//String dataCol1 = table.getValueAt(i, 1).toString();
					if (chked) {
						newusers.add(table2.getValueAt(i, 1).toString());
						model2.removeRow(i);
						int l=table2.getRowCount();
						l--;
						i=0;
					
					}
				}
				//System.out.println(newusers);
				for(int i=0;i<newusers.size();i++)
				{
					approve_user(m3,newusers.get(i));
				}
			}

		});
		rjusrbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				newusers2.clear();
				for (int i = 0; i < table2.getRowCount(); i++) {
					Boolean chked = Boolean.valueOf(table2.getValueAt(i, 0)
							.toString());
					
					//String dataCol1 = table.getValueAt(i, 1).toString();
					if (chked) {
						newusers2.add(table2.getValueAt(i, 1).toString());
						model2.removeRow(i);
						int l=table2.getRowCount();
						l--;
						i=0;
					
					}
					
				}
				//System.out.println(newusers2);
				for(int i=0;i<newusers2.size();i++)
				{
					reject_user(m3,newusers2.get(i));
				}

			}
			
		});
		
		aclgbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				for (int i = 0; i < table4.getRowCount(); i++) {
					Boolean chked = Boolean.valueOf(table4.getValueAt(i, 0)
							.toString());
					
					//String dataCol1 = table.getValueAt(i, 1).toString();
					if (chked) {
						
						int l=table4.getRowCount();
						String retid=model4.getValueAt(i, 3).toString();
						accept(m3,retid);
						model4.removeRow(i);
						l--;
						i=0;
					
					}
				}
			}

		});
		rjlgbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				for (int i = 0; i < table4.getRowCount(); i++) {
					Boolean chked = Boolean.valueOf(table4.getValueAt(i, 0)
							.toString());
					
					//String dataCol1 = table.getValueAt(i, 1).toString();
					if (chked) {
						
						int l=table4.getRowCount();
						String retid=model4.getValueAt(i, 3).toString();
						reject(m3,retid);
						model4.removeRow(i);
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
		fpane2.add(btn6,new GridBagConstraints(
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
		fpane2.add(btn7,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(515, // inset top
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
		frame6.setVisible(false);
		fpane2.removeAll();
		otherhome();
		sp4.setBorder(BorderFactory.createEmptyBorder());

		fpane2.add(sp4,new GridBagConstraints(
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
		fpane2.add(rjlgbtn,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTHEAST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                00, // inset left
                80, // inset bottom
                100), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(aclgbtn,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTHEAST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                00, // inset left
                80, // inset bottom
                300), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(viewbtn3,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTHEAST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                00, // inset left
                30, // inset bottom
                360), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(log2gm,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTHEAST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                00, // inset left
                30, // inset bottom
                240), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(inventory,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTHEAST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                00, // inset left
                30, // inset bottom
                128), // inset right
                0, // ipadx
                0)
				);
		sp4.setViewportView(table4);
		fpane2.revalidate();
		fpane2.repaint();
	}

	public static void repsGUI()
	{
		frame6.setVisible(false);
		fpane2.removeAll();
		otherhome();
		sp5.setBorder(BorderFactory.createEmptyBorder());

		fpane2.add(sp5,new GridBagConstraints(
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
		fpane2.add(viewrep,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTH, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                175, // inset left
                80, // inset bottom
                00), // inset right
                0, // ipadx
                0)
				);
		
		sp5.setViewportView(table5);
		fpane2.revalidate();
		fpane2.repaint();
	}
	
	public static void staffGUI()
	{
		fpane2.removeAll();
		
		otherhome();
		sp.setBorder(BorderFactory.createEmptyBorder());

		fpane2.add(sp,new GridBagConstraints(
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
		sp.setViewportView(table);
		
		fpane2.add(deletebtn,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTHEAST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                00, // inset left
                20, // inset bottom
                100), // inset right
                0, // ipadx
                0)
				);
		fpane2.add(viewbtn2,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTHEAST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                00, // inset left
                80, // inset bottom
                269), // inset right
                0, // ipadx
                0)
				);
		fpane2.revalidate();
		fpane2.repaint();
	}
	
	public void taskGUI()
	{
		otherhome();
		
		fpane2.add(task2,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(120, // inset top
                240, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		fwdtask.setFont(new Font("Courier", Font.ITALIC, 20));

		fpane2.add(fwdtask,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(134, // inset top
                420, // inset left
                00, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		
		fpane2.add(createtask,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.SOUTH, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                0, // inset left
                10, // inset bottom
                95), // inset right
                0, // ipadx
                0)
				);
		staffm.setFont(new Font("Courier", Font.ITALIC, 20));
		fpane2.add(staffm,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.CENTER, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(0, // inset top
                250, // inset left
                80, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		staffm2.setFont(new Font("Courier", Font.ITALIC, 20));
		fpane2.add(staffm2,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.CENTER, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(240, // inset top
                250, // inset left
                0, // inset bottom
                0), // inset right
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
                200, // inset left
                10, // inset bottom
                0), // inset right
                0, // ipadx
                0)
				);
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	public void approve_user(Main a, String q){

		//////////////////////////////////

		Staff m=null;
		int flag=0;
		if(flag==0){
			for(int i=0;i<((a.electricity).new_staff).size();i++){
				Staff g=((a.electricity).new_staff).get(i);
				
				if(g.username.equals(q) ){
					m=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.hvac).new_staff).size();i++){
				Staff g=((a.hvac).new_staff).get(i);
				if(g.username.equals(q) ){
					m=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.security).new_staff).size();i++){
				Staff g=((a.security).new_staff).get(i);
				if(g.username.equals(q) ){
					m=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.housekeeping).new_staff).size();i++){

				Staff g=((a.housekeeping).new_staff).get(i);
				
				if(g.username.equals(q) ){
					m=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.av).new_staff).size();i++){
				Staff g=((a.av).new_staff).get(i);
				if(g.username.equals(q) ){
					m=g;
					flag=1;
				}
			}
		}

		/////////////////////
		String csvfile=null;
        PrintWriter br=null;
        ArrayList<Staff> z=null;
        if(m.department.equals("electricity")){
                csvfile="electricity_new_staff.csv";
                a.electricity.add_staff(m);
                z=  ((a.electricity).new_staff);
        }

        else if(m.department.equals("hvac")){
                csvfile="hvac_new_staff.csv";
                a.hvac.add_staff(m);
                z=  ((a.hvac).new_staff);
        }

        else if(m.department.equals("security")){
                csvfile="security_new_staff.csv";
                a.security.add_staff(m);
                z=  ((a.security).new_staff);
        }

        else if(m.department.equals("av")){
                csvfile="av_new_staff.csv";
                a.av.add_staff(m);
                z=  ((a.av).new_staff);
        }

        else if(m.department.equals("housekeeping")){
                csvfile="housekeeping_new_staff.csv";
                a.housekeeping.add_staff(m);
                z=  ((a.housekeeping).new_staff);
        }
            //System.out.println(m);
            z.remove(m);
            System.out.println(z);
            int j;
            try{
                br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile)));
                for(j=0;j<z.size();j++){
                    Staff y=z.get(j);
                    br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+","+y.status+"\n");
                } 
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (br != null) {
                    br.close();
                }
            }  
            a.read_database();      
	}

	public void reject_user(Main a, String q){

		//////////////////////////////////

		Staff m=null;
		int flag=0;
		if(flag==0){
			for(int i=0;i<((a.electricity).new_staff).size();i++){
				Staff g=((a.electricity).new_staff).get(i);
				
				if(g.username.equals(q) ){
					m=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.hvac).new_staff).size();i++){
				Staff g=((a.hvac).new_staff).get(i);
				if(g.username.equals(q) ){
					m=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.security).new_staff).size();i++){
				Staff g=((a.security).new_staff).get(i);
				if(g.username.equals(q) ){
					m=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.housekeeping).new_staff).size();i++){

				Staff g=((a.housekeeping).new_staff).get(i);
				
				if(g.username.equals(q) ){
					m=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.av).new_staff).size();i++){
				Staff g=((a.av).new_staff).get(i);
				if(g.username.equals(q) ){
					m=g;
					flag=1;
				}
			}
		}

		/////////////////////
		String csvfile=null;
        PrintWriter br=null;
        ArrayList<Staff> z=null;
            if(m.department.equals("electricity")){
                csvfile="electricity_new_staff.csv";
               
                z=  ((a.electricity).new_staff);
            }

            else if(m.department.equals("hvac")){
                csvfile="hvac_new_staff.csv";
                
                z=  ((a.hvac).new_staff);
            }

            else if(m.department.equals("security")){
                csvfile="security_new_staff.csv";
                
                z=  ((a.security).new_staff);
            }

            else if(m.department.equals("av")){
                csvfile="av_new_staff.csv";
                
                z=  ((a.av).new_staff);
            }

            else if(m.department.equals("housekeeping")){
                csvfile="housekeeping_new_staff.csv";
                
                z=  ((a.housekeeping).new_staff);
            }
            z.remove(m);
            int j;
            try{
                br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile)));
                for(j=0;j<z.size();j++){
                    Staff y=z.get(j);
                    br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+","+y.status+"\n");
                } 
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (br != null) {
                    br.close();
                }
            }  
            a.read_database();
	}

	public User view_user(Main a, String q){
		User v=null;
		int flag=0;
		if(flag==0){
			for(int i=0;i<((a.electricity).staff).size();i++){
				Staff g=((a.electricity).staff).get(i);
				
				if(g.username.equals(q) ){
					v=g;
					flag=1;
				}
			}
			
		}
		if(flag==0){
			for(int i=0;i<((a.hvac).staff).size();i++){
				Staff g=((a.hvac).staff).get(i);
				if(g.username.equals(q) ){
					v=g;
					flag=1;
				}
			}
			
		}
		if(flag==0){
			for(int i=0;i<((a.security).staff).size();i++){
				Staff g=((a.security).staff).get(i);
				if(g.username.equals(q) ){
					v=g;
					flag=1;
				}
			}
			
		}
		if(flag==0){
			for(int i=0;i<((a.housekeeping).staff).size();i++){

				Staff g=((a.housekeeping).staff).get(i);
				
				if(g.username.equals(q) ){
					v=g;
					flag=1;
				}
			}
			
		}
		if(flag==0){
			for(int i=0;i<((a.av).staff).size();i++){
				Staff g=((a.av).staff).get(i);
				if(g.username.equals(q) ){
					v=g;
					flag=1;
				}
			}
			
		}
		return v;
	}

	public void delete_user(Main a, String q){
            //////////////////////////////////

		Staff m=null;
		int flag=0;
		if(flag==0){
			for(int i=0;i<((a.electricity).staff).size();i++){
				Staff g=((a.electricity).staff).get(i);
				
				if(g.username.equals(q) ){
					m=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.hvac).staff).size();i++){
				Staff g=((a.hvac).staff).get(i);
				if(g.username.equals(q) ){
					m=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.security).staff).size();i++){
				Staff g=((a.security).staff).get(i);
				if(g.username.equals(q) ){
					m=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.housekeeping).staff).size();i++){

				Staff g=((a.housekeeping).staff).get(i);
				
				if(g.username.equals(q) ){
					m=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.av).staff).size();i++){
				Staff g=((a.av).staff).get(i);
				if(g.username.equals(q) ){
					m=g;
					flag=1;
				}
			}
		}

		/////////////////////
            ArrayList<Staff> z=null;
            String csvfile=null;
            if(m.department.equals("electricity")){
                csvfile="electricity.csv";
                z=  ((a.electricity).staff);
            }

            else if(m.department.equals("hvac")){
                csvfile="hvac.csv";
                z=  ((a.hvac).staff);
            }

            else if(m.department.equals("security")){
                csvfile="security.csv"; 
                z=  ((a.security).staff);
            }

            else if(m.department.equals("av")){
                csvfile="av.csv";
                z=  ((a.av).staff);
            }

            else if(m.department.equals("housekeeping")){
                csvfile="housekeeping.csv";
                z=  ((a.housekeeping).staff);
            }
            z.remove(m);
            PrintWriter br=null;
            int j;
            try{
                br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile)));
                for(j=0;j<z.size();j++){
                    Staff y=z.get(j);
                    br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+","+y.status+"\n");
                } 
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (br != null) {
                    br.close();
                }
            }  
            a.read_database();
	}

	public void assign_task(Main a, String q, ArrayList<String> s){
		 //////////////////////////////////

		Task b=null;
		int flag=0;
		if(flag==0){
			for(int i=0;i<((a.electricity).task_list).size();i++){
				Task g=((a.electricity).task_list).get(i);
				
				if(g.task_name.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.hvac).task_list).size();i++){
				Task g=((a.hvac).task_list).get(i);
				
				if(g.task_name.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.av).task_list).size();i++){
				Task g=((a.av).task_list).get(i);
				
				if(g.task_name.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.housekeeping).task_list).size();i++){
				Task g=((a.housekeeping).task_list).get(i);
				
				if(g.task_name.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.security).task_list).size();i++){
				Task g=((a.security).task_list).get(i);
				
				if(g.task_name.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}

		/////////////////////
		ArrayList<Task> u=null;
       ArrayList<Staff> o=null;
       String csvfile=null;
       String wcsvfile=null;
       PrintWriter br=null;
       department d= null;
       if(b.department.equals("electricity")){
           u=a.electricity.task_list;
           d=a.electricity;
           o=a.electricity.staff;
           csvfile="electricity_task.csv";
           wcsvfile="electricity.csv";
       }
       else if(b.department.equals("hvac")){
           u=a.hvac.task_list;
           csvfile="hvac_task.csv";
           d=a.hvac;
           o=a.hvac.staff;
           wcsvfile="hvac.csv";
       }
       else if(b.department.equals("av")){
           u=a.av.task_list;
           csvfile="av_task.csv";
           d=a.av;
           o=a.av.staff;
           wcsvfile="av.csv";
       }
       else if(b.department.equals("housekeeping")){
           u=a.housekeeping.task_list;
           csvfile="housekeeping_task.csv";
           d=a.housekeeping;
           o=a.housekeeping.staff;
           wcsvfile="housekeeping.csv";
       }
       else if(b.department.equals("security")){
           u=a.security.task_list;
           csvfile="security_task.csv";
           d=a.security;
           o=a.security.staff;
           wcsvfile="security.csv";
       }
       
       u.remove(b);
       
       b.staff=s;
       u.add(b);
       
       try{
           int j;
           
           br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile)));
           for(j=0;j<u.size();j++){
               Task h=u.get(j);
               
               br.write(h.task_id+","+h.deadline[0]+","+h.deadline[1]+","+h.deadline[2]+","+h.task_name+","+h.task_description+","+h.department+","+h.supervisor+","+h.status);
               int i;
               for(i=0;i<h.staff.size();i++){
                   br.write(","+h.staff.get(i));
               }
               br.write("\n");
           }
       }catch (FileNotFoundException e) {
           e.printStackTrace();
       }catch (IOException e) {
           e.printStackTrace();
       }finally {
           if (br != null) {
               br.close();
           }
       }
       int i,j;
       for(i=0;i<s.size();i++){
           for(j=0;j<o.size();j++){
               Staff y= o.get(j);
               if(y.username.equals(s.get(i))){
                   y.status="Busy";
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
       a.read_database();
	}
	
	public void accept(Main a, String q){
		/////////////////////////////////////////////


		Logistic_request v=null;
		int flag=0;
		if(flag==0){
			for(int i=0;i<((a.electricity).req_list).size();i++){
				Logistic_request g=((a.electricity).req_list).get(i);
				
				if(g.task_id.equals(q) ){
					v=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.security).req_list).size();i++){
				Logistic_request g=((a.security).req_list).get(i);
				
				if(g.task_id.equals(q) ){
					v=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.av).req_list).size();i++){
				Logistic_request g=((a.av).req_list).get(i);
				
				if(g.task_id.equals(q) ){
					v=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.hvac).req_list).size();i++){
				Logistic_request g=((a.hvac).req_list).get(i);
				
				if(g.task_id.equals(q) ){
					v=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.housekeeping).req_list).size();i++){
				Logistic_request g=((a.housekeeping).req_list).get(i);
				
				if(g.task_id.equals(q) ){
					v=g;
					flag=1;
				}
			}
		}



		/////////////////////////
		ArrayList<Logistic_request> z= null;
        ArrayList<Logistic> t=null;
        ArrayList<Logistic> u= null;
        String csvfile=null;
        String wcsvfile=null;
        PrintWriter br=null;
        if(v.department.equals("electricity")){
            z=a.electricity.req_list;
            u=a.electricity.logistic_list;
            csvfile="electricity_log_req.csv";
            wcsvfile="electricity_log.csv";
        }
        else if(v.department.equals("av")){
            z=a.av.req_list;
            csvfile="av_log_req.csv";
            wcsvfile="av_log.csv";
            u=a.av.logistic_list;
        }
        else if(v.department.equals("hvac")){
            z=a.hvac.req_list;
            csvfile="hvac_log_req.csv";
            wcsvfile="hvac_log.csv";
            u=a.hvac.logistic_list;
        }
        else if(v.department.equals("security")){
            z=a.security.req_list;
            csvfile="security_log_req.csv";
            wcsvfile="security_log.csv";
            u=a.security.logistic_list;
        }
        else if(v.department.equals("housekeeping")){
            z=a.housekeeping.req_list;
            csvfile="housekeeping_log_req.csv";
            wcsvfile="housekeeping_log.csv";
            u=a.housekeeping.logistic_list;
        }
        z.remove(v);
        try {
            int j;
            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile)));
            for(j=0;j<z.size();j++){
                Logistic_request k=z.get(j);
                br.print(k.id+",");
                int i;
                for(i=0;i<k.list_logistic.size();i++){
                    br.print(k.list_logistic.get(i).equipment+","+k.list_logistic.get(i).quantity+",");
                }
                br.println(k.task_id+","+k.department);
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
        try {
            t=v.list_logistic;
            int i,j;
            for(i=0;i<t.size();i++){
                for(j=0;j<u.size();j++){
                    if(u.get(j).equipment.equals(t.get(i).equipment)){
                        u.get(j).quantity-=t.get(i).quantity;
                        break;
                    }
                }
            }
            br =new PrintWriter(new BufferedWriter(new FileWriter(wcsvfile)));
            for(i=0;i<u.size();i++){
                br.write(u.get(i).equipment+","+u.get(i).quantity+"\n");
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

	public void reject(Main a, String q){
			//////////////////////////////

		Logistic_request v=null;
		int flag=0;
		if(flag==0){
			for(int i=0;i<((a.electricity).req_list).size();i++){
				Logistic_request g=((a.electricity).req_list).get(i);
				
				if(g.task_id.equals(q) ){
					v=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.security).req_list).size();i++){
				Logistic_request g=((a.security).req_list).get(i);
				
				if(g.task_id.equals(q) ){
					v=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.av).req_list).size();i++){
				Logistic_request g=((a.av).req_list).get(i);
				
				if(g.task_id.equals(q) ){
					v=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.hvac).req_list).size();i++){
				Logistic_request g=((a.hvac).req_list).get(i);
				
				if(g.task_id.equals(q) ){
					v=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.housekeeping).req_list).size();i++){
				Logistic_request g=((a.housekeeping).req_list).get(i);
				
				if(g.task_id.equals(q) ){
					v=g;
					flag=1;
				}
			}
		}

		////////////////

		ArrayList<Logistic_request> z= null;
        String csvfile=null;
        PrintWriter br=null;
        if(v.department.equals("electricity")){
            z=a.electricity.req_list;
            csvfile="electricity_log_req.csv";
        }
        else if(v.department.equals("av")){
            z=a.av.req_list;
            csvfile="av_log_req.csv";
        }
        else if(v.department.equals("hvac")){
            z=a.hvac.req_list;
            csvfile="hvac_log_req.csv";
        }
        else if(v.department.equals("security")){
            z=a.security.req_list;
            csvfile="security_log_req.csv";
        }
        else if(v.department.equals("housekeeping")){
            z=a.housekeeping.req_list;
            csvfile="housekeeping_log_req.csv";
        }
        z.remove(v);
        try {
            int j;
            br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile)));
            for(j=0;j<z.size();j++){
                Logistic_request k=z.get(j);
                br.print(k.id+",");
                int i;
                for(i=0;i<k.list_logistic.size();i++){
                    br.print(k.list_logistic.get(i).equipment+","+k.list_logistic.get(i).quantity+",");
                }
                br.println(k.task_id+","+k.department);
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
	public void send_log_req(Main a, Logistic_request m){
		m.add_info(a);
	}
	public void send_leave(Main a, Leave b){
		b.add_info(a);
	}
	public void generate_report(String b){
        
        PrintWriter br=null;
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(b+".txt"));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
	
	public String toString(){
		return (username+name+passwd+userid+type+dob+address+department);
	}
}
