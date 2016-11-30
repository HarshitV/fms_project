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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
public class gm extends User{
	ArrayList<Logistic_request> req_list= new ArrayList<Logistic_request>();
	ArrayList<Leave> leave_list= new ArrayList<Leave>();
	ArrayList<Supervisor> new_Supervisor= new ArrayList<Supervisor>();
	ArrayList<String> deletedusers=new ArrayList<String>();
	ArrayList<String> newusers=new ArrayList<String>();
	ArrayList<String> newusers2=new ArrayList<String>();

	gm(String[] a){
		username=a[0];
		name=a[1];
		passwd=a[2];
		userid=a[3];
		type=a[4];
		dob=a[5];
		address=a[6];
		//department=a[7];
	}

	private static JComboBox<String> superv,request;
	private static JTextArea area;
	private static JTable table,table2,table3,table4,table5;
	private static JScrollPane scrollPane,sp,sp2,sp3,sp4,sp5;
	private static JFrame frame4,frame6,frame7,frame8;
	private static JPanel fpane2,pane1,pane2,fpane3,fpane4;
	private static JButton createtask,ok3,viewrep,aclgbtn,rjlgbtn,acusrbtn,rjusrbtn,viewbtn,viewbtn2,deletebtn ,btn1,btn2,btn3,btn4,btn5,btn6,btn7,ok2,ok,cancel,repsbtn,reqsbtn,taskbtn,loutbtn,logsbtn,staffbtn;
	private static JLabel task1,task2,task3,task4,fms,logo,date,welcome,l1,l2,l3,l4,l5,l6,disphome,loggeduser;
	private static ImageIcon imageIcon;
	private static JTextField t2,t4;
	private String viewuser;
	//ArrayList<logistic_req> req_list=new ArrayList<logistic_req>();
	//ArrayList<leave> leave_list=new ArrayList<leave>();
	
	
	public void createGUI()
	{
		
		Main m1=new Main();
		m1.read_database();
		
		area=new JTextArea(5,20);
		area.setColumns(29);
		area.setLineWrap (true);
		area.setWrapStyleWord (false);
		area.setFont(new Font("Serif", Font.PLAIN, 24));
		scrollPane = new JScrollPane(area);
		Task.taskcount=Task.read_id();
		task1=new JLabel("Task id: " + Task.taskcount);
		task2=new JLabel("Task Name: ");
		task3=new JLabel("Task Description: ");
		task4=new JLabel("Task Deadline: ");
		task1.setFont(new Font("Serif", Font.PLAIN, 34));
		task2.setFont(new Font("Serif", Font.PLAIN, 34));
		task3.setFont(new Font("Serif", Font.PLAIN ,34));
		task4.setFont(new Font("Serif", Font.PLAIN ,34));
		task1.setHorizontalAlignment(SwingConstants.LEFT);
		task2.setHorizontalAlignment(SwingConstants.LEFT);
		task3.setHorizontalAlignment(SwingConstants.LEFT);
		task4.setHorizontalAlignment(SwingConstants.LEFT);
		t2=new JTextField("");
		//t3=new JTextField("");
		t4=new JTextField("");
        t2.setPreferredSize( new Dimension( 330, 35 ) );
        t4.setPreferredSize( new Dimension( 305, 35 ) );
        //t3.setPreferredSize( new Dimension( 520, 135 ) );
		//List<String> =
		viewbtn2=new JButton("View");
	    viewbtn2.setPreferredSize(new Dimension(150,60));
	    viewrep=new JButton("View");
	    viewrep.setPreferredSize(new Dimension(150,60));
		GridBagConstraints gbc = new GridBagConstraints();
		request=new JComboBox<String>();
		superv=new JComboBox<String>();
		request.addItem("Select option");
		request.addItem("New Users");
		request.addItem("Leave requests");
		
		superv.addItem("Select Supervisor");
		superv.addItem("electricity");
		superv.addItem("hvac");
		superv.addItem("av");
		superv.addItem("security");
		superv.addItem("housekeeping");
		
		frame6=new JFrame("REQUESTS");
		frame6.setVisible(false);
		frame6.setSize(350,120);
		frame6.setLocationRelativeTo(null);
		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pane1=new JPanel();
		pane2=new JPanel();
		pane1.setLayout(new GridLayout(2,1));
		pane2.setLayout(new GridLayout(1,2));
		pane1.add(request);
		pane1.add(pane2);
		ok=new JButton("OK");
		cancel=new JButton("Cancel");
		ok2=new JButton("OK");
		ok3=new JButton("OK");
		pane2.add(ok);
		pane2.add(cancel);
		frame6.add(pane1);
		//frame6.add(pane2);
		frame7=new JFrame("User Data");
		frame8=new JFrame("TASK REPORTS");
		//frame6.setVisible(false);
		frame7.setSize(300,200);
		frame7.setLocationRelativeTo(null);
		frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame8.setSize(300,200);
		frame8.setLocationRelativeTo(null);
		frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fpane3=new JPanel();
		fpane3.setLayout(new GridLayout(7,1));
		fpane4=new JPanel();
		
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
		
		loggeduser=new JLabel("Logged in as ADMIN");
		loggeduser.setFont (loggeduser.getFont ().deriveFont (15.0f));
		
		
		//table.setSize(200, 300);
		//table.setBounds(30,40,200,300);
		//table.setRowHeight(1, 5);
		//table.setEnabled(false);
		
		final DefaultTableModel model = new DefaultTableModel() {

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
		final DefaultTableModel model2 = new DefaultTableModel() {

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
		final DefaultTableModel model3 = new DefaultTableModel() {

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;
				case 5:
					return String.class;
				default: 
					return String.class;
				}
			}
		};
		final DefaultTableModel model4 = new DefaultTableModel() {

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
				case 4:
					return String.class;
				
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
		sp.setPreferredSize(new Dimension(500, 320));
		sp2.setPreferredSize(new Dimension(500,320));
		sp3.setPreferredSize(new Dimension(500,320));
		sp4.setPreferredSize(new Dimension(500,320));
		sp5.setPreferredSize(new Dimension(500,320));
		table2 =new JTable();
		table = new JTable();
		table3=new JTable();
		table4=new JTable();
		table5=new JTable();
		table.setRowHeight(30);
		table2.setRowHeight(30);
		table3.setRowHeight(30);
		table4.setRowHeight(30);
		table5.setRowHeight(30);
		//table.setColumnWidth(20);
		//sp.setViewportView(table);
		table.setModel(model);
		table2.setModel(model2);
		table3.setModel(model3);
		table4.setModel(model4);
		table5.setModel(model5);
		/*table.setEnabled(false);
		table2.setEnabled(false);
		table3.setEnabled(false);*/
		model.addColumn("Select");
		model.addColumn("User Name");
		model.addColumn("Department");
		model.addColumn("Type");
		
		model2.addColumn("Select");
		model2.addColumn("User Name");
		model2.addColumn("Department");
		model2.addColumn("Type");
		
		model3.addColumn("User Name");
		model3.addColumn("Apply date");
		model3.addColumn("Range");	
		model3.addColumn("Start Date");
		model3.addColumn("End Date");
		model3.addColumn("Reason");
		
		model4.addColumn("Select");
		model4.addColumn("ID");
		model4.addColumn("Logistic list");
		model4.addColumn("Department");
		
		model5.addColumn("Select");
		model5.addColumn("Task ID");
		model5.addColumn("Task Name");
		model5.addColumn("Department");
		model5.addColumn("Status");
		////////////////////////////staff table///////////////////////
		ArrayList<Staff> e_staff=m1.electricity.staff;
		ArrayList<Staff> hv_staff=m1.hvac.staff;
		ArrayList<Staff> a_staff=m1.av.staff;
		ArrayList<Staff> s_staff=m1.security.staff;
		ArrayList<Staff> hk_staff=m1.housekeeping.staff;
		// Data Row
		Supervisor s1=null;
		s1=m1.electricity.supervisor;
		ArrayList<Supervisor> sur=new ArrayList<Supervisor>();
		if(s1!=null){
			sur.add(s1);
		}
		s1=m1.hvac.supervisor;
		if(s1!=null){
			sur.add(s1);
		}
		s1=m1.av.supervisor;
		if(s1!=null){
			sur.add(s1);
		}
		s1=m1.security.supervisor;
		if(s1!=null){
			sur.add(s1);
		}
		s1=m1.housekeeping.supervisor;
		if(s1!=null){
			sur.add(s1);
		}
		int count=0;
		for (int i = 0; i <sur.size(); i++){
			s1=sur.get(i);
			model.addRow(new Object[0]);
			model.setValueAt(false, 0+count, 0);
			model.setValueAt(s1.username, 0+count, 1);
			model.setValueAt(s1.department, 0+count, 2);
			model.setValueAt(s1.type, 0+count, 3);
			count++;
		}
		
		for (int i = 0; i <e_staff.size(); i++) {
			model.addRow(new Object[0]);
			Staff y=e_staff.get(i);
			model.setValueAt(false, i+count, 0);
			model.setValueAt(y.username, i+count, 1);
			model.setValueAt(y.department, i+count, 2);
			model.setValueAt(y.type, i+count, 3);
		}
		count+=e_staff.size();
		for (int i = 0; i <hv_staff.size(); i++) {
			model.addRow(new Object[0]);
			Staff y=hv_staff.get(i);
			model.setValueAt(false, i+count, 0);
			model.setValueAt(y.username, i+count, 1);
			model.setValueAt(y.department, i+count, 2);
			model.setValueAt(y.type, i+count, 3);
		}
		count+=hv_staff.size();
		for (int i = 0; i <a_staff.size(); i++) {
			model.addRow(new Object[0]);
			Staff y=a_staff.get(i);
			model.setValueAt(false, i+count, 0);
			model.setValueAt(y.username, i+count, 1);
			model.setValueAt(y.department, i+count, 2);
			model.setValueAt(y.type, i+count, 3);
		}
		count+=a_staff.size();
		for (int i = 0; i <s_staff.size(); i++) {
			model.addRow(new Object[0]);
			Staff y=s_staff.get(i);
			model.setValueAt(false, i+count, 0);
			model.setValueAt(y.username, i+count, 1);
			model.setValueAt(y.department, i+count, 2);
			model.setValueAt(y.type, i+count, 3);
		}
		count+=s_staff.size();
		for (int i = 0; i <hk_staff.size(); i++) {
			model.addRow(new Object[0]);
			Staff y=hk_staff.get(i);
			model.setValueAt(false, i+count, 0);
			model.setValueAt(y.username, i+count, 1);
			model.setValueAt(y.department, i+count, 2);
			model.setValueAt(y.type, i+count, 3);
		}
///////////////////////////////////staff table end///////////////////////////////////////////	
		
////////////////////////////////// New user table////////////////////////////////////////////////////////
		
		 e_staff=m1.electricity.new_staff;
		 hv_staff=m1.hvac.new_staff;
		 a_staff=m1.av.new_staff;
		 s_staff=m1.security.new_staff;
		 hk_staff=m1.housekeeping.new_staff;
		// Data Row
		 model2.setNumRows(0);

		ArrayList<Supervisor> superlist=m1.admin.new_Supervisor;
		for (int i = 0; i <superlist.size(); i++) {
			Supervisor y=superlist.get(i);
			model2.addRow(new Object[0]);
			model2.setValueAt(false, i, 0);
			model2.setValueAt(y.username, i, 1);
			model2.setValueAt(y.department, i, 2);
			model2.setValueAt(y.type, i, 3);
		}
		count=superlist.size();
		for (int i = 0; i <e_staff.size(); i++) {
			model2.addRow(new Object[0]);
			Staff y=e_staff.get(i);
			model2.setValueAt(false, i+count, 0);
			model2.setValueAt(y.username, i+count, 1);
			model2.setValueAt(y.department, i+count, 2);
			model2.setValueAt(y.type, i+count, 3);
		}
		count+=e_staff.size();
		for (int i = 0; i <hv_staff.size(); i++) {
			model2.addRow(new Object[0]);
			Staff y=hv_staff.get(i);
			model2.setValueAt(false, i+count, 0);
			model2.setValueAt(y.username, i+count, 1);
			model2.setValueAt(y.department, i+count, 2);
			model2.setValueAt(y.type, i+count, 3);
		}
		count+=hv_staff.size();
		for (int i = 0; i <a_staff.size(); i++) {
			model2.addRow(new Object[0]);
			Staff y=a_staff.get(i);
			model2.setValueAt(false, i+count, 0);
			model2.setValueAt(y.username, i+count, 1);
			model2.setValueAt(y.department, i+count, 2);
			model2.setValueAt(y.type, i+count, 3);
		}
		count+=a_staff.size();
		for (int i = 0; i <s_staff.size(); i++) {
			model2.addRow(new Object[0]);
			Staff y=s_staff.get(i);
			model2.setValueAt(false, i+count, 0);
			model2.setValueAt(y.username, i+count, 1);
			model2.setValueAt(y.department, i+count, 2);
			model2.setValueAt(y.type, i+count, 3);
		}
		count+=s_staff.size();
		for (int i = 0; i <hk_staff.size(); i++) {
			model2.addRow(new Object[0]);
			Staff y=hk_staff.get(i);
			model2.setValueAt(false, i+count, 0);
			model2.setValueAt(y.username, i+count, 1);
			model2.setValueAt(y.department, i+count, 2);
			model2.setValueAt(y.type, i+count, 3);
		}
		//model2.setRowCount(0);
//////////////////////////////////new user table end /////////////////////////////////////////////////////////		
		
//////////////////////////////////leave request table /////////////////////////////////////////////////////////		
		
		ArrayList<Leave> lv=m1.admin.leave_list; 
		
		
		
		
		
		
		for (int i = 0; i <lv.size(); i++) { 
			
			Leave l1=lv.get(i);
			model3.addRow(new Object[0]);
			model3.setValueAt(l1.user, i, 0);
			model3.setValueAt(l1.date, i, 1);
			model3.setValueAt(l1.range, i, 2);
			model3.setValueAt(l1.start_date, i, 3);
			model3.setValueAt(l1.end_date, i, 4);			
			model3.setValueAt(l1.reason, i, 5);

		}
///////////////////////////leave request table end/////////////////////////////////////////////////////
		
////////////////////////// logistic table /////////////////////////////////////////////////////////////////
		
		ArrayList<Logistic_request> reqlist=m1.admin.req_list;
		
	for (int i = 0; i <reqlist.size(); i++) {
		Logistic_request l=reqlist.get(i);
		model4.addRow(new Object[0]);
		model4.setValueAt(false, i, 0);
		model4.setValueAt(l.id, i, 1);
		ArrayList<Logistic> l1=l.list_logistic;
		String str=null;
		String str2="";
		for(int j=0;j<l1.size();j++)
		{
			Logistic lgs=l1.get(j);
			str=lgs.equipment + "(" + lgs.quantity + "), ";
			str2=str2.concat(str);
		}
		
		model4.setValueAt(str2, i, 2);
		model4.setValueAt(l.department, i, 3);
	
	}

////////////////////////////////////////////logistic table end////////////////////////////////////////////////////////////	
	
//////////////////////////////////////////// task report /////////////////////////////////////////////////////////////
	
	
	
	
	
	ArrayList<Task> e_task=m1.electricity.task_list;
	ArrayList<Task> hv_task=m1.hvac.task_list;
	ArrayList<Task> a_task=m1.av.task_list;
	ArrayList<Task> s_task=m1.security.task_list;
	ArrayList<Task>  hk_task=m1.housekeeping.task_list;
	// Data Row
	count=0;
	for (int i = 0; i <e_task.size(); i++) {
		Task y=e_task.get(i);
		model5.addRow(new Object[0]);
		model5.setValueAt(false, i+count, 0);
		model5.setValueAt(y.task_id, i+count, 1);
		model5.setValueAt(y.task_name, i+count, 2);
		model5.setValueAt(y.department, i+count, 3);
		model5.setValueAt(y.status, i+count, 4);
	}
	count+=e_task.size();
	for (int i = 0; i <hv_task.size(); i++) {
		Task y=hv_task.get(i);
		model5.addRow(new Object[0]);
		model5.setValueAt(false, i+count, 0);
		model5.setValueAt(y.task_id, i+count, 1);
		model5.setValueAt(y.task_name, i+count, 2);
		model5.setValueAt(y.department, i+count, 3);
		model5.setValueAt(y.status, i+count, 4);
	}
	count+=hv_task.size();
	for (int i = 0; i <a_task.size(); i++) {
		Task y=a_task.get(i);
		model5.addRow(new Object[0]);
		model5.setValueAt(false, i+count, 0);
		model5.setValueAt(y.task_id, i+count, 1);
		model5.setValueAt(y.task_name, i+count, 2);
		model5.setValueAt(y.department, i+count, 3);
		model5.setValueAt(y.status, i+count, 4);
	}
	count+=a_task.size();
	for (int i = 0; i <s_task.size(); i++) {
		Task y=s_task.get(i);
		model5.addRow(new Object[0]);
		model5.setValueAt(false, i+count, 0);
		model5.setValueAt(y.task_id, i+count, 1);
		model5.setValueAt(y.task_name, i+count, 2);
		model5.setValueAt(y.department, i+count, 3);
		model5.setValueAt(y.status, i+count, 4);
	}
	count+=s_task.size();
	for (int i = 0; i <hk_task.size(); i++) {
		Task y=hk_task.get(i);
		model5.addRow(new Object[0]);
		model5.setValueAt(false, i+count, 0);
		model5.setValueAt(y.task_id, i+count, 1);
		model5.setValueAt(y.task_name, i+count, 2);
		model5.setValueAt(y.department, i+count, 3);
		model5.setValueAt(y.status, i+count, 4);
	}
////////////////////////////////////////////task report end /////////////////////////////////////////////////////////////	
		
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
				User u1=view_user(m1, viewuser);
				
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
					delete_user(m1,deletedusers.get(i));
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
		aclgbtn=new JButton("Approve");
		rjlgbtn=new JButton("Reject");
		createtask=new JButton("Create Task");
		btn1.setPreferredSize(new Dimension(200, 60));
		btn2.setPreferredSize(new Dimension(200, 60));
		btn3.setPreferredSize(new Dimension(200, 60));
		btn4.setPreferredSize(new Dimension(200, 60));
		btn5.setPreferredSize(new Dimension(200, 60));
		btn6.setPreferredSize(new Dimension(200, 60));
		btn7.setPreferredSize(new Dimension(200, 60));
		acusrbtn.setPreferredSize(new Dimension(200, 60));
		rjusrbtn.setPreferredSize(new Dimension(200, 60));
		aclgbtn.setPreferredSize(new Dimension(200, 60));
		rjlgbtn.setPreferredSize(new Dimension(200, 60));
		createtask.setPreferredSize(new Dimension(200, 60));
		createtask.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Task tsk=new Task();
		Task.taskcount=Task.read_id();
		tsk.task_id=Integer.toString(Task.taskcount);
		tsk.task_name=t2.getText();
		tsk.task_description=area.getText();
		String dead=t4.getText();
		String[] parts = dead.split("/");
		System.out.println(parts[0]);
		System.out.println(parts[1]);
		System.out.println(parts[2]);
		tsk.deadline[0]=Integer.parseInt(parts[0]);
		tsk.deadline[1]=Integer.parseInt(parts[1]);
		tsk.deadline[2]=Integer.parseInt(parts[2]);
		tsk.department=superv.getSelectedItem().toString();
		if(tsk.department.equals("electricity"))
		{
			tsk.supervisor=m1.electricity.supervisor.username;
		}
		if(tsk.department.equals("hvac"))
		{
			tsk.supervisor=m1.hvac.supervisor.username;
		}
		if(tsk.department.equals("av"))
		{
			tsk.supervisor=m1.av.supervisor.username;
		}
		if(tsk.department.equals("security"))
		{
			tsk.supervisor=m1.security.supervisor.username;
		}
		if(tsk.department.equals("housekeeping"))
		{
			tsk.supervisor=m1.housekeeping.supervisor.username;
		}
		assign_task(m1,tsk);
		JOptionPane.showMessageDialog(null, "New Task Created !");
		Task.taskcount=Task.read_id();
		Task.taskcount++;
		Task.write_int();
		t2.setText(null);
		t4.setText(null);
		area.setText(null);
		taskGUI();
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
				System.out.println(newusers);
				//System.out.println(newusers);
				for(int i=0;i<newusers.size();i++)
				{
					approve_user(m1,newusers.get(i));
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
				System.out.println(newusers2);
				for(int i=0;i<newusers2.size();i++)
				{
					reject_user(m1,newusers2.get(i));
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
						String idget=model4.getValueAt(i, 1).toString();
						accept(m1,idget);
						model4.removeRow(i);
						int l=table4.getRowCount();
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
						String idget=model4.getValueAt(i, 1).toString();
						System.out.println(idget);
						reject(m1,idget);
						model4.removeRow(i);
						int l=table4.getRowCount();
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
	}
	
	public void taskGUI()
	{
		Task tsk=new Task();
		Task.taskcount=Task.read_id();
		task1.setText("Task id: " + Task.taskcount);
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
		fpane2.add(task2,new GridBagConstraints(
				0, // gridx
                0, // gridy
                1, // gridwidth
                1, // gridheight
                1, // weightx
                1, // weighty
                GridBagConstraints.NORTHWEST, // anchor <------------
                GridBagConstraints.NONE, // fill
                new Insets(200, // inset top
                240, // inset left
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
                new Insets(210, // inset top
                430, // inset left
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
                new Insets(260, // inset top
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
                new Insets(320, // inset top
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
                460, // inset left
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
		fpane2.add(superv,new GridBagConstraints(
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
	
		
	///////////////////////////////////////////////////////////////////////////////////
	
	
	
	public void approve_user(Main a, String q){

		/////////////////////////////////////////////////////


		User b=null;
		int flag=0;
		if(flag==0){
			for(int i=0;i<((a.electricity).new_staff).size();i++){
				Staff g=((a.electricity).new_staff).get(i);
				
				if(g.username.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.hvac).new_staff).size();i++){
				Staff g=((a.hvac).new_staff).get(i);
				if(g.username.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.security).new_staff).size();i++){
				Staff g=((a.security).new_staff).get(i);
				if(g.username.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.housekeeping).new_staff).size();i++){

				Staff g=((a.housekeeping).new_staff).get(i);
				
				if(g.username.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.av).new_staff).size();i++){
				Staff g=((a.av).new_staff).get(i);
				if(g.username.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}

		if(flag==0){
			for(int i=0;i<((a.admin).new_Supervisor).size();i++){
				Supervisor g=((a.admin).new_Supervisor).get(i);
				if(g.username.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}






		///////////////////////////////////////////////////////////
        String csvfile=null;
        PrintWriter br=null;
        if(b.type.equals("Supervisor")){
            String wcsvfile=null;
            Supervisor m= (Supervisor)b;
            csvfile="new_Supervisor.csv";
            wcsvfile="Supervisor.csv";
            a.admin.new_Supervisor.remove(m);
            try {
                br = new PrintWriter(new BufferedWriter(new FileWriter(wcsvfile,true)));
                br.write(m.username+","+m.name+","+m.passwd+","+m.userid+","+m.type+","+m.dob+","+m.address+","+m.department+"\n");
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
                int j;
                
                br = new PrintWriter(new BufferedWriter(new FileWriter(csvfile)));
                for(j=0;j< a.admin.new_Supervisor.size();j++){
                    br.write( a.admin.new_Supervisor.get(j).username+","+ a.admin.new_Supervisor.get(j).name+","+ a.admin.new_Supervisor.get(j).passwd+","+ a.admin.new_Supervisor.get(j).userid+","+ a.admin.new_Supervisor.get(j).type+","+ a.admin.new_Supervisor.get(j).dob+","+ a.admin.new_Supervisor.get(j).address+","+ a.admin.new_Supervisor.get(j).department+"\n");
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
            if(m.department.equals("electricity")){
                a.electricity.add_supervisor(m);
            }
            else if(m.department.equals("hvac")){
                a.hvac.add_supervisor(m);
            }
            else if(m.department.equals("av")){
                a.av.add_supervisor(m);
            }
            else if(m.department.equals("security")){
                a.security.add_supervisor(m);
            }
            else if(m.department.equals("housekeeping")){
                a.housekeeping.add_supervisor(m);
            }
            a.read_database();
        }

        else if(b.type.equals("Staff")){
            Staff m= (Staff)b;
            //System.out.println(m);
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
	}

	public void reject_user(Main a, String q){
		/////////////////////////////////////////////////////


		User b=null;
		int flag=0;
		if(flag==0){
			for(int i=0;i<((a.electricity).new_staff).size();i++){
				Staff g=((a.electricity).new_staff).get(i);
				
				if(g.username.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.hvac).new_staff).size();i++){
				Staff g=((a.hvac).new_staff).get(i);
				if(g.username.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.security).new_staff).size();i++){
				Staff g=((a.security).new_staff).get(i);
				if(g.username.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.housekeeping).new_staff).size();i++){

				Staff g=((a.housekeeping).new_staff).get(i);
				
				if(g.username.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}
		if(flag==0){
			for(int i=0;i<((a.av).new_staff).size();i++){
				Staff g=((a.av).new_staff).get(i);
				if(g.username.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}

		if(flag==0){
			for(int i=0;i<((a.admin).new_Supervisor).size();i++){
				Supervisor g=((a.admin).new_Supervisor).get(i);
				if(g.username.equals(q) ){
					b=g;
					flag=1;
				}
			}
		}






		///////////////////////////////////////////////////////////

        String csvfile=null;
        PrintWriter br=null;
        if(b.type.equals("Supervisor")){
            String wcsvfile=null;
            csvfile="new_Supervisor.csv";
            Supervisor m= (Supervisor)b;
            a.admin.new_Supervisor.remove(m);
            try {
                int j;
                br = new PrintWriter(new BufferedWriter(new FileWriter(csvfile)));
                for(j=0;j< a.admin.new_Supervisor.size();j++){
                    br.write( a.admin.new_Supervisor.get(j).username+","+ a.admin.new_Supervisor.get(j).name+","+ a.admin.new_Supervisor.get(j).passwd+","+ a.admin.new_Supervisor.get(j).userid+","+ a.admin.new_Supervisor.get(j).type+","+ a.admin.new_Supervisor.get(j).dob+","+ a.admin.new_Supervisor.get(j).address+","+ a.admin.new_Supervisor.get(j).department+"\n");
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

        else if(b.type.equals("Staff")){
            ArrayList<Staff> z=null;
            Staff m =(Staff)b;
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
			if(flag==0 && (a.electricity).supervisor!=null){
				Supervisor g=(a.electricity).supervisor;
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
			if(flag==0 && (a.hvac).supervisor!=null){
				Supervisor g=(a.hvac).supervisor;
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
			if(flag==0 &&(a.security).supervisor!=null){
				Supervisor g=(a.security).supervisor;
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
			if(flag==0 && (a.housekeeping).supervisor!=null){
				Supervisor g=(a.housekeeping).supervisor;
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
			if(flag==0 && (a.av).supervisor!=null){
				Supervisor g=(a.av).supervisor;
				if(g.username.equals(q) ){
					v=g;
					flag=1;
				}
			}
		}
		return v;
	}

	public void delete_user(Main a, String q){
		///////////////////////////////////////////////////////////////////
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
			if(flag==0 && (a.electricity).supervisor!=null){
				Supervisor g=(a.electricity).supervisor;
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
			if(flag==0 && (a.hvac).supervisor!=null){
				Supervisor g=(a.hvac).supervisor;
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
			if(flag==0 &&(a.security).supervisor!=null){
				Supervisor g=(a.security).supervisor;
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
			if(flag==0 && (a.housekeeping).supervisor!=null){
				Supervisor g=(a.housekeeping).supervisor;
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
			if(flag==0 && (a.av).supervisor!=null){
				Supervisor g=(a.av).supervisor;
				if(g.username.equals(q) ){
					v=g;
					flag=1;
				}
			}
		}




		////////////////////////////////////////////////////////////////////
        if(v.type.equals("Supervisor")){
            Supervisor m=(Supervisor)v;
            ArrayList<Supervisor> s= new ArrayList<Supervisor>();
            if(a.electricity.supervisor!=null)
            s.add( a.electricity.supervisor);
            if(a.hvac.supervisor!=null)
            s.add( a.hvac.supervisor);
            if(a.av.supervisor!=null)
            s.add( a.av.supervisor);
            if(a.security.supervisor!=null)
            s.add( a.security.supervisor);
            if(a.housekeeping.supervisor!=null)
            s.add( a.housekeeping.supervisor);
            if(m.department.equals("electricity")){
                s.remove( a.electricity.supervisor);
                a.electricity.supervisor=null;    
            }

            else if(m.department.equals("hvac")){
                s.remove( a.electricity.supervisor);
                a.hvac.supervisor=null; 
            }

            else if(m.department.equals("security")){
                s.remove( a.security.supervisor);
                a.security.supervisor=null; 
            }

            else if(m.department.equals("av")){
               s.remove( a.av.supervisor);            
               a.av.supervisor=null; 
            }

            else if(m.department.equals("housekeeping")){
               s.remove( a.housekeeping.supervisor);
               a.housekeeping.supervisor=null; 
            }
            String csvfile="Supervisor.csv";
            PrintWriter br=null;
            int j;
            try{
                br =new PrintWriter(new BufferedWriter(new FileWriter(csvfile)));
                for(j=0;j<s.size();j++){
                    Supervisor y=s.get(j);
                    br.write(y.username+","+y.name+","+y.passwd+","+y.userid+","+y.type+","+y.dob+","+y.address+","+y.department+"\n");
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
        else if(v.type.equals("Staff")){
            Staff m=(Staff)v;
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

	}

	public void assign_task(Main a, Task m){
        m.add_info(a);
	}

	public void accept(Main a, String q){
		//////////////////////////////////////////////////////////////////

		Logistic_request v=null;
		for(int i=0;i<((a.admin).req_list).size();i++){
			Logistic_request g=((a.admin).req_list).get(i);
			if(g.id.equals(q) ){
				v=g;
		
			}
		}
		



		/////////////////////////////////////////////////////////////////////
		
        ArrayList<Logistic_request> z= a.admin.req_list;
        ArrayList<Logistic> t=null;
        ArrayList<Logistic> u=null;
        String csvfile="gm_log_req.csv";
        String wcsvfile=null;
        PrintWriter br=null;
        if(v.department.equals("Electricity")){
            u=a.electricity.logistic_list;
            wcsvfile="electricity_log.csv";
        }
        else if(v.department.equals("AV")){
            wcsvfile="av_log.csv";
            u=a.av.logistic_list;
        }
        else if(v.department.equals("HVAC")){
            wcsvfile="hvac_log.csv";
            u=a.hvac.logistic_list;
        }
        else if(v.department.equals("Security")){
            wcsvfile="security_log.csv";
            u=a.security.logistic_list;
        }
        else if(v.department.equals("Housekeeping")){
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
                        u.get(j).quantity+=t.get(i).quantity;
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
		////////////////////////////////

		Logistic_request v=null;
		for(int i=0;i<((a.admin).req_list).size();i++){
			Logistic_request g=((a.admin).req_list).get(i);
			if(g.id.equals(q) ){
				v=g;
							}
		}

		//////////

		ArrayList<Logistic_request> z= a.admin.req_list;
        String csvfile="gm_log_req.csv";
        PrintWriter br=null;
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

    public void printkar(){
        System.out.println(username+name+passwd+userid+type+dob+address);
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
    public void view_report(String b){
        PrintWriter br=null;
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(b+".docx"));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
