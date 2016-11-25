package fms_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

// table and sp are staff lists to view or delete
// table 2 and sp2 are user request lists
// table 3 and sp3 are leave requests

public class GM extends User{

	private static JTable table,table2,table3;
	private static JScrollPane sp,sp2,sp3;
	private static JFrame frame4,frame6,frame7;
	private static JPanel fpane2,pane1,pane2,fpane3;
	private static JButton aclvbtn,rjlvbtn,acusrbtn,rjusrbtn,viewbtn,viewbtn2,deletebtn ,btn1,btn2,btn3,btn4,btn5,btn6,btn7,ok2,cancel2,ok,cancel,repsbtn,reqsbtn,taskbtn,loutbtn,logsbtn,staffbtn;
	private static JLabel fms,logo,date,welcome,l1,l2,l3,l4,l5,l6,disphome,loggeduser;
	private static ImageIcon imageIcon;
	//ArrayList<logistic_req> req_list=new ArrayList<logistic_req>();
	//ArrayList<leave> leave_list=new ArrayList<leave>();
	
	
	public static void createGUI()
	{
		viewbtn2=new JButton("View");
	    viewbtn2.setPreferredSize(new Dimension(150,60));
		GridBagConstraints gbc = new GridBagConstraints();
		JComboBox<String> request=new JComboBox<String>();
		request.addItem("Select option");
		request.addItem("New Users");
		request.addItem("Leave requests");
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
		pane2.add(ok);
		pane2.add(cancel);
		frame6.add(pane1);
		//frame6.add(pane2);
		frame7=new JFrame("");
		//frame6.setVisible(false);
		frame7.setSize(300,200);
		frame7.setLocationRelativeTo(null);
		frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fpane3=new JPanel();
		fpane3.add(ok2,gbc);
		frame7.add(fpane3);
		
		fpane2=new JPanel();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss, dd MMM yyyy ");
		Calendar cal = Calendar.getInstance();
		date=new JLabel("Logged in at: " + dateFormat.format(cal.getTime()));		
		date.setFont (date.getFont ().deriveFont (15.0f));
		
		fms=new JLabel("FACULTY MANAGEMENT SERVICES SYSTEM");
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
		
		DefaultTableModel model = new DefaultTableModel() {

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
		DefaultTableModel model2 = new DefaultTableModel() {

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
		DefaultTableModel model3 = new DefaultTableModel() {

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
				case 5:
					return String.class;
				default: 
					return String.class;
				}
			}
		};
		
		sp=new JScrollPane(); 
		sp2=new JScrollPane();
		sp3=new JScrollPane();
		sp.setPreferredSize(new Dimension(500, 320));
		sp2.setPreferredSize(new Dimension(500,320));
		sp3.setPreferredSize(new Dimension(500,320));
		table2 =new JTable();
		table = new JTable();
		table3=new JTable();
		table.setRowHeight(30);
		table2.setRowHeight(30);
		table3.setRowHeight(30);
		//table.setColumnWidth(20);
		//sp.setViewportView(table);
		table.setModel(model);
		table2.setModel(model2);
		table3.setModel(model3);
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
		model3.addColumn("Select");
		model3.addColumn("User Name");
		model3.addColumn("Department");
		model3.addColumn("Type");
		model3.addColumn("Department");
		model3.addColumn("Type");
		model3.addColumn("Start Date");
		model3.addColumn("End Date");
		// Data Row
		for (int i = 0; i <= 10; i++) {
			model.addRow(new Object[0]);
			model.setValueAt(false, i, 0);
			model.setValueAt("User"+ (i+1), i, 1);
			model.setValueAt("User"+ (i+1), i, 2);
			model.setValueAt("User"+ (i+1), i, 3);
		}
		for (int i = 0; i <= 10; i++) {
			model2.addRow(new Object[0]);
			model2.setValueAt(false, i, 0);
			model2.setValueAt("User req"+ (i+1), i, 1);
			model2.setValueAt("User req"+ (i+1), i, 2);
			model2.setValueAt("User req"+ (i+1), i, 3);
		}
		for (int i = 0; i <= 10; i++) {
			model3.addRow(new Object[0]);
			model3.setValueAt(false, i, 0);
			model3.setValueAt("Leave req"+ (i+1), i, 1);
			model3.setValueAt("Leave req"+ (i+1), i, 2);
			model3.setValueAt("Leave req"+ (i+1), i, 3);
			model3.setValueAt("Leave req"+ (i+1), i, 4);
			model3.setValueAt("Leave req"+ (i+1), i, 5);
		}
		
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
				fpane2.add(rjlvbtn,new GridBagConstraints(
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
				fpane2.add(aclvbtn,new GridBagConstraints(
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
	    
	    
	    reqsbtn.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
				frame6.setVisible(true);
				
				
			}
		});
	    
	    //frame6.add(ok);
	    
	    
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
		btn1.addActionListener(new ActionListener()
				{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				createGMhome();
				
				/*frame4.getContentPane().removeAll();
				frame4.add(btn1);
				frame4.revalidate();
				frame4.repaint();*/
				}
	});
		btn2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
		});
		btn3.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		otherhome();
		}
});
		btn4.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		otherhome();
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
		otherhome();
		}
});
		
		
		
		
		
		
		btn5.addActionListener(new ActionListener()
		{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		otherhome();
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
		createGMhome();
		
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
	
	public static void createGMhome()
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
