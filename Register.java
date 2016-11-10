package fms_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Register {
	public static int idcount=0;
	
	private JFrame frame2;
	private JPanel fpane,bpane;
	private JButton ok,cancel;
	private int check_result;
	private String[] info=new String[7];
	
	public void generate_id()
	{
		idcount++;
		User.userid=idcount;
	}
	
	public void createGUI()
	{
		//frame1.setVisible(false);
				Border border = BorderFactory.createLineBorder(Color.RED, 2);
				JTextField usname,names,dobs,addr;
				JPasswordField pswd;
				usname=new JTextField("");
				pswd=new JPasswordField();
				names=new JTextField("");
		        //types=new JTextField("");
		        dobs=new JTextField("");
		        addr=new JTextField("");
				frame2=new JFrame("FMS REGISTER");
				//frame2.setLayout(new GridLayout(6,1));
				frame2.setVisible(true);
				frame2.setSize(450,250);
				frame2.setLocationRelativeTo(null);
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				bpane=new JPanel();
				fpane=new JPanel();
				JComboBox<String> depts=new JComboBox<String>();
				depts.addItem("Select option");
				depts.addItem("Electricity");
				depts.addItem("HVAC");
				depts.addItem("AV");
				depts.addItem("Security");
				depts.addItem("Housekeeping");
				JComboBox<String> deptypes = new JComboBox<String>();
				deptypes.addItem("Select option");
				deptypes.addItem("Staffer");
				deptypes.addItem("Supervisor");
				JLabel name=new JLabel("Enter your name: ");
				name.setFont (name.getFont ().deriveFont (15.0f));
				JLabel uname=new JLabel("Enter username: ");
				uname.setFont (uname.getFont ().deriveFont (15.0f));
				JLabel dept=new JLabel("Enter department");
				dept.setFont(dept.getFont().deriveFont(15.0f));
				JLabel type=new JLabel("Enter type:");
				type.setFont (type.getFont ().deriveFont (15.0f));
				JLabel pwd=new JLabel("Enter password: ");
				pwd.setFont (pwd.getFont ().deriveFont (15.0f));
				JLabel DOB=new JLabel("Enter date of birth (DDMMYY)");
				DOB.setFont (DOB.getFont ().deriveFont (15.0f));
				JLabel address=new JLabel("Enter your address: ");
				address.setFont (address.getFont ().deriveFont (15.0f));
				Border original = usname.getBorder();
				ok = new JButton("OK");
				ok.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						
						usname.setBorder(original);
						pswd.setBorder(original);
						names.setBorder(original);
						dobs.setBorder(original);
						addr.setBorder(original);
						deptypes.setBorder(original);
						depts.setBorder(original);
						// TODO Auto-generated method stub
						if(usname.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Username field blank");
							usname.setBorder(border);
						}
						if(pswd.getPassword().length<6)
						{
							JOptionPane.showMessageDialog(null, "Password must be atleast 6 characters in length");
							pswd.setBorder(border);
						}
						if(names.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Name field blank");
							names.setBorder(border);
						}
						if(!(dobs.getText().length()==6))
						{
							JOptionPane.showMessageDialog(null, "DOB format not acceptable! Enter in <DDMMYY>");
							dobs.setBorder(border);
						}
						if(depts.getSelectedIndex()==0)
						{
							JOptionPane.showMessageDialog(null, "Department field is empty");
							depts.setBorder(border);
						}
						if(deptypes.getSelectedIndex()==0)
						{
							JOptionPane.showMessageDialog(null, "Type field is empty");
							deptypes.setBorder(border);
						}
						if(addr.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "Address field empty");
							addr.setBorder(border);
						}
						if(!(usname.getText().equals("")) && !(pswd.getPassword().length<6) && !(names.getText().equals("")) && (dobs.getText().length()==6) && !(addr.getText().equals("")) && !(depts.getSelectedIndex()==0) && !(deptypes.getSelectedIndex()==0))
						{
							frame2.setVisible(false);
							generate_id();
							JOptionPane.showMessageDialog(frame2,
							    "Your unique user id is "+(User.userid),
							    "USER ID GENERATOR",
							    JOptionPane.WARNING_MESSAGE);
						}
					}
					
				});
				
		        cancel = new JButton("Cancel");
		        cancel.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						frame2.dispose();
					
					}
					
				});
		        fpane.setLayout(new GridLayout(7,1));
		        bpane.setLayout(new FlowLayout());
		       
		        
		       // Font bigFont = usname.getFont().deriveFont(Font.PLAIN, 500f);
		        //usname.setFont(bigFont);
		        usname.setPreferredSize( new Dimension( 200, 24 ) );
		       
		        //pswd=new JTextField("");
		        
		        fpane.add(uname);
		        fpane.add(usname);
		        fpane.add(pwd);
		        fpane.add(pswd);
		        fpane.add(name);
		        fpane.add(names);
		        fpane.add(dept);
		        fpane.add(depts);
		        fpane.add(type);
		        fpane.add(deptypes);
		        //fpane.add(types);
		        fpane.add(DOB);
		        fpane.add(dobs);
		        fpane.add(address);
		        fpane.add(addr);
		        bpane.add(ok);
		        bpane.add(cancel);
		        frame2.getContentPane().add(fpane);
		        frame2.add(bpane, BorderLayout.PAGE_END);
	}
	
	public String generate_userID()
	{
		return null;		
	}
	
	public void get_info()
	{
		
	}
	
	public void check_info()
	{
		
	}
	
	public void sendfor_approval(String recipient)
	{
		
	}
	
	public void display_homepage()
	{
		
	}
	
}
