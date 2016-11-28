
import java.lang.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class Home_page implements ActionListener{
	private JPanel panel3,panel2,panel1,panel4,bpane,fpane,bpane2,fpane2;
	private JButton btnregister,btnlogin,ok,ok2,cancel,cancel2;
	private JFrame frame2,frame3;
	public static JFrame frame1;
	Login lgn=new Login();
	Register rgr=new Register();
	Home_page()
	{
		final Main m= new Main();
		m.read_database();
		frame1=new JFrame("FMS HOME");
		frame1.setLayout(new GridLayout(5,1));
		frame1.setVisible(true);
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
						rgr.createGUI();
					}
				});
		btnlogin=new JButton("Login");
		btnlogin.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						lgn.createGUI();
					}					
				});
		btnregister.setBackground(Color.gray);
		btnlogin.setBackground(Color.gray);
		btnregister.setPreferredSize(new Dimension(200, 60));
		btnlogin.setPreferredSize(new Dimension(200, 60));
		btnregister.setFont(new Font("Arial", Font.PLAIN, 30));
		btnlogin.setFont(new Font("Arial", Font.PLAIN, 30));
		panel3.add(btnregister);
		panel2.add(btnlogin);
		ImageIcon imageIcon = new ImageIcon("logonew.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(250, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		frame1.add(new JLabel(imageIcon));
		JLabel label1 = new JLabel();
		label1.setText("FACILITY MANAGEMENT SERVICES");
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
			//Register rgr=new Register();
			rgr.createGUI();
			//this.register();
		}
		else if(arg=="Login");
		{
			//Login lgn=new Login();
			lgn.createGUI();
			//this.login();
		}	
	}
	
	
}
