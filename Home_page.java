package fms_project;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class Home_page implements ActionListener{
	private JPanel panel3,panel2,panel1,panel4,bpane,fpane;
	private JButton btnregister,btnlogin,ok,cancel;
	private JFrame frame1,frame2;
	Home_page()
	{
		frame1=new JFrame("FMS HOME");
		frame1.setLayout(new GridLayout(5,1));
		
		frame1.setVisible(true);
		frame1.setSize(1650,1080);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1=new JPanel(new FlowLayout());
		panel3=new JPanel(new FlowLayout());
		panel2=new JPanel(new FlowLayout());
		panel4=new JPanel(new FlowLayout());
		btnregister=new JButton("Register");
		btnregister.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						register();
					}
				});
		btnlogin=new JButton("Login");
		btnlogin.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						login();
					}					
				});
		btnregister.setBackground(Color.GREEN);
		btnlogin.setBackground(Color.GREEN);
		btnregister.setPreferredSize(new Dimension(200, 60));
		btnlogin.setPreferredSize(new Dimension(200, 60));
		btnregister.setFont(new Font("Arial", Font.PLAIN, 30));
		btnlogin.setFont(new Font("Arial", Font.PLAIN, 30));
		panel3.add(btnregister);
		panel2.add(btnlogin);
		ImageIcon imageIcon = new ImageIcon("C:/Users/Harshit/workspace/fms_project/src/fms_project/logonew.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(250, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		frame1.add(new JLabel(imageIcon));
		JLabel label1 = new JLabel();
		label1.setText("FACULTY MANAGEMENT SERVICES");
		label1.setFont (label1.getFont ().deriveFont (40.0f));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel label2 = new JLabel();
		label2.setText("The system maintains all tasks of Electricity, HVAC, AV, Security and Housekeeping department.");
		label2.setFont (label2.getFont ().deriveFont (25.0f));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		panel4.add(label2);
		panel1.add(label1);
		frame1.add(panel1);
		frame1.add(panel4);
		frame1.add(panel3);
		frame1.add(panel2);
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		frame1.setSize(xSize,ySize);
		frame1.setLocationRelativeTo(null);
		//frame1.setSize(600, 400);
	}     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Home_page();		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String arg=e.getActionCommand();
		if(arg=="Register")
		{
			
			this.register();
		}
		else if(arg=="Login");
		{
			this.login();
		}	
	}
	public void register()
	{
		frame1.setVisible(false);
		frame2=new JFrame("FMS REGISTER");
		//frame2.setLayout(new GridLayout(6,1));
		frame2.setVisible(true);
		frame2.setSize(450,200);
		frame2.setLocationRelativeTo(null);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bpane=new JPanel();
		fpane=new JPanel();
		JLabel name=new JLabel("Enter your name: ");
		name.setFont (name.getFont ().deriveFont (15.0f));
		JLabel uname=new JLabel("Enter username: ");
		uname.setFont (uname.getFont ().deriveFont (15.0f));
		JLabel type=new JLabel("Enter type[staffer/supervisor]:");
		type.setFont (type.getFont ().deriveFont (15.0f));
		JLabel pwd=new JLabel("Enter password: ");
		pwd.setFont (name.getFont ().deriveFont (15.0f));
		JLabel DOB=new JLabel("Enter date of birth");
		DOB.setFont (DOB.getFont ().deriveFont (15.0f));
		JLabel address=new JLabel("Enter your address: ");
		address.setFont (address.getFont ().deriveFont (15.0f));
		ok = new JButton("OK");
        cancel = new JButton("Cancel");
        fpane.setLayout(new GridLayout(6,1));
        bpane.setLayout(new FlowLayout());
        JTextField usname,pswd,names,types,dobs,addr;
        usname=new JTextField("");
       // Font bigFont = usname.getFont().deriveFont(Font.PLAIN, 500f);
        //usname.setFont(bigFont);
        usname.setPreferredSize( new Dimension( 200, 24 ) );
        pswd=new JPasswordField();
        //pswd=new JTextField("");
        names=new JTextField("");
        types=new JTextField("");
        dobs=new JTextField("");
        addr=new JTextField("");
        fpane.add(uname);
        fpane.add(usname);
        fpane.add(pwd);
        fpane.add(pswd);
        fpane.add(name);
        fpane.add(names);
        fpane.add(type);
        fpane.add(types);
        fpane.add(DOB);
        fpane.add(dobs);
        fpane.add(address);
        fpane.add(addr);
        bpane.add(ok);
        bpane.add(cancel);
        frame2.getContentPane().add(fpane);
        frame2.add(bpane, BorderLayout.PAGE_END);
	}
	public void login()
	{
		
	}
	
	
}
