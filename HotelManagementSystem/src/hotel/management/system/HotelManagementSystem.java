package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    
	JButton btn1,btn3;
	HotelManagementSystem()
	{
		setBounds(0,0,1950,900);
		
		JLabel l2=new JLabel("Hotel Management System");
		l2.setBounds(550,50,600,200);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Arial",Font.BOLD,30));
		add(l2);
		
		
		Font btn_f=new Font("Times New Roman",Font.BOLD,13);
		btn1=new JButton("Receptionist LOGIN");
		btn1.setBounds(250,600,150,50);
		btn1.setForeground(Color.BLACK);
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.setFont(btn_f);
		add(btn1);
		btn3=new JButton("Admin LOGIN");
		btn3.setBounds(1150,600,150,50);
		btn3.setForeground(Color.BLACK);
		btn3.setBackground(Color.LIGHT_GRAY);
		btn3.setFont(btn_f);
		add(btn3);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/pics/intro.jpg"));
		Image i2=i1.getImage().getScaledInstance(1950, 900, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l1=new JLabel(i3);
		l1.setBounds(0,0,1950,900);
		add(l1);
		
		setLayout(null);
		btn1.addActionListener(this);
		btn3.addActionListener(this);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn1)
			new EmployeeLogin().setVisible(true);
		else
			new AdminLogin().setVisible(true);
		this.setVisible(false);
	}
	public static void main(String[] args) {
		new HotelManagementSystem();

	}

}
