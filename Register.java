package fms_project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register {
	private JFrame frame2;
	private JPanel fpane,bpane;
	private JButton ok,cancel;
	private int check_result;
	private String[] info=new String[7];
	
	public void createGUI()
	{
		//frame1.setVisible(false);
				frame2=new JFrame("FMS REGISTER");
				//frame2.setLayout(new GridLayout(6,1));
				frame2.setVisible(true);
				frame2.setSize(450,200);
				frame2.setLocationRelativeTo(null);
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				bpane=new JPanel();
				fpane=new JPanel();
				JComboBox<String> deptypes = new JComboBox<String>();
				deptypes.addItem("Select option");
				deptypes.addItem("Staffer");
				deptypes.addItem("Supervisor");
				JLabel name=new JLabel("Enter your name: ");
				name.setFont (name.getFont ().deriveFont (15.0f));
				JLabel uname=new JLabel("Enter username: ");
				uname.setFont (uname.getFont ().deriveFont (15.0f));
				JLabel type=new JLabel("Enter department:");
				type.setFont (type.getFont ().deriveFont (15.0f));
				JLabel pwd=new JLabel("Enter password: ");
				pwd.setFont (pwd.getFont ().deriveFont (15.0f));
				JLabel DOB=new JLabel("Enter date of birth");
				DOB.setFont (DOB.getFont ().deriveFont (15.0f));
				JLabel address=new JLabel("Enter your address: ");
				address.setFont (address.getFont ().deriveFont (15.0f));
				ok = new JButton("OK");
				ok.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						frame2.setVisible(false);
					
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
		        fpane.setLayout(new GridLayout(6,1));
		        bpane.setLayout(new FlowLayout());
		        JTextField usname,names,dobs,addr;
		        JPasswordField pswd;
		        usname=new JTextField("");
		       // Font bigFont = usname.getFont().deriveFont(Font.PLAIN, 500f);
		        //usname.setFont(bigFont);
		        usname.setPreferredSize( new Dimension( 200, 24 ) );
		        pswd=new JPasswordField();
		        //pswd=new JTextField("");
		        names=new JTextField("");
		        //types=new JTextField("");
		        dobs=new JTextField("");
		        addr=new JTextField("");
		        fpane.add(uname);
		        fpane.add(usname);
		        fpane.add(pwd);
		        fpane.add(pswd);
		        fpane.add(name);
		        fpane.add(names);
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
