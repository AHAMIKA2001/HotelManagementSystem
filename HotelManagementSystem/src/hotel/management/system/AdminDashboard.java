package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame implements ActionListener{
	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem item1,item2,item3,item4,item5;
    AdminDashboard()
    {
    	setTitle("Dashboard");
    	setBounds(0,0,1950,900);
    	
    	JLabel l2=new JLabel("Welcome to Our Hotel");
    	l2.setBounds(450,50,600,200);
    	l2.setForeground(Color.CYAN);
    	l2.setFont(new Font("Arial",Font.BOLD,55));
    	add(l2);
    	
    	mb=new JMenuBar();
    	setJMenuBar(mb);
    	m1=new JMenu("ADD FACILITY");
    	mb.add(m1);
    	item1=new JMenuItem("ADD EMPLOYEE");
    	m1.add(item1);
    	item2=new JMenuItem("ADD ROOMS");
    	m1.add(item2);
    	m2=new JMenu("VIEW DETAILS");
    	mb.add(m2);
    	item3=new JMenuItem("VIEW ROOMS");
    	m2.add(item3);
    	item4=new JMenuItem("VIEW CUSTOMERS");
    	m2.add(item4);
    	item5=new JMenuItem("VIEW EMPLOYEES");
    	m2.add(item5);
    	
    	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/pics/dashboard.jpg"));
    	Image i2=i1.getImage().getScaledInstance(1950,900,Image.SCALE_DEFAULT);
    	ImageIcon i3=new ImageIcon(i2);
    	JLabel l1=new JLabel(i3);
    	l1.setBounds(0,0,1950,900);
    	add(l1);
    	item1.addActionListener(this);
    	item2.addActionListener(this);
    	item3.addActionListener(this);
    	item4.addActionListener(this);
    	item5.addActionListener(this);
    	
    	setLayout(null);
    	setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==item1)
    	new NewEmployeeForm();	
    	else if(e.getSource()==item2)
    	new AddRoom();
    	else if(e.getSource()==item3)
    	new ViewRoom();
    	else if(e.getSource()==item4)
    	new ViewCustomerDetails();
    	else if(e.getSource()==item5)
    	new ViewEmployeeDetails();
    }
	public static void main(String[] args) {
		new AdminDashboard();

	}

}
