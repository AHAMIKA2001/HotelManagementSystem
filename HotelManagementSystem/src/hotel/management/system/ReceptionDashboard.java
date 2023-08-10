package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReceptionDashboard extends JFrame implements ActionListener {
    
	JButton btn1,btn2,btn3,btn4,btn5;
	public ReceptionDashboard() {
		setTitle("Dashboard");
    	setBounds(0,0,1950,900);
    	JLabel l2=new JLabel("Welcome to Our Hotel");
    	l2.setBounds(500,50,600,200);
    	l2.setForeground(Color.CYAN);
    	l2.setFont(new Font("Times New Roman",Font.BOLD,60));
    	add(l2);
    	btn1=new JButton("Add New Customer");
    	btn1.setBounds(170,200,300,40);
    	btn1.setBackground(Color.BLACK);
    	btn1.setForeground(Color.WHITE);
    	btn1.setFont(new Font("Times New Roman",Font.BOLD,20));
    	add(btn1);
    	btn2=new JButton("Payment");
    	btn2.setBounds(170,300,300,40);
    	btn2.setBackground(Color.BLACK);
    	btn2.setForeground(Color.WHITE);
    	btn2.setFont(new Font("Times New Roman",Font.BOLD,20));
    	add(btn2);
    	btn3=new JButton("View Employee Details");
    	btn3.setBounds(1150,200,320,42);
    	btn3.setBackground(Color.BLACK);
    	btn3.setForeground(Color.WHITE);
    	btn3.setFont(new Font("Times New Roman",Font.BOLD,20));
    	add(btn3);
    	btn4=new JButton("View Customer Details");
    	btn4.setBounds(1150,300,320,42);
    	btn4.setBackground(Color.BLACK);
    	btn4.setForeground(Color.WHITE);
    	btn4.setFont(new Font("Times New Roman",Font.BOLD,20));
    	add(btn4);
    	btn5=new JButton("Check-Out");
    	btn5.setBounds(170,400,300,40);
    	btn5.setBackground(Color.BLACK);
    	btn5.setForeground(Color.WHITE);
    	btn5.setFont(new Font("Times New Roman",Font.BOLD,20));
    	add(btn5);
    	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/pics/reception.jpg"));
    	Image i2=i1.getImage().getScaledInstance(1950,900,Image.SCALE_DEFAULT);
    	ImageIcon i3=new ImageIcon(i2);
    	JLabel l1=new JLabel(i3);
    	l1.setBounds(0,0,1950,900);
    	add(l1);
    	
    	setLayout(null);
    	btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
    	setVisible(true);
    	
    	
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn1)
			new CustomerChoice().setVisible(true);
		else if(e.getSource()==btn2)
			new CustomerIDInput().setVisible(true);
		else if(e.getSource()==btn3)
			new ViewEmployeeDetails().setVisible(true);
		else if(e.getSource()==btn4)
			new ViewCustomerDetails().setVisible(true);
		/*else
			new CheckOut().setVisible(true);*/
		this.setVisible(false);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ReceptionDashboard();

	}

}
