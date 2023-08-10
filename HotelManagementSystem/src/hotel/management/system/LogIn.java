package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class EmployeeLogin extends LogIn implements ActionListener
{
	EmployeeLogin()
	{
		super();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn1)
		{
			String username=jt1.getText();
			String password=jp1.getText();
			Conn c=new Conn();
			String str="select * from Employeelogin where username='"+username+"' and password='"+password+"'";
			try {
			ResultSet rs=c.s.executeQuery(str);
			if(rs.next()) {
				new ReceptionDashboard().setVisible(true);
				this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null,"Invalid username or password");
				this.setVisible(false);
			}
			}catch(Exception ep)
			{
				System.out.println("Exception caught!!");
			}
		}else if(e.getSource()==btn2)
			System.exit(0);
	}
}

class AdminLogin extends LogIn implements ActionListener
{
	AdminLogin()
	{
		super();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn1)
		{
			String username=jt1.getText();
			String password=jp1.getText();
			Conn c=new Conn();
			String str="select * from Adminlogin where username='"+username+"' and password='"+password+"'";
			try {
			ResultSet rs=c.s.executeQuery(str);
			if(rs.next()) {
				new AdminDashboard().setVisible(true);
				this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null,"Invalid username or password");
				this.setVisible(false);
			}
			}catch(Exception ep)
			{
				ep.printStackTrace();
				System.out.println("Exception caught!!");
			}
		}else if(e.getSource()==btn2)
			System.exit(0);
	}
}

public class LogIn extends JFrame implements ActionListener{
    
	JLabel username,password;
	JTextField jt1;
	JPasswordField jp1;
	JButton btn1,btn2;
	LogIn()
	{
		setBounds(300,200,550,300);
		Font btn_f=new Font("Courier",Font.BOLD,20);
		username=new JLabel("Username");
		username.setBounds(10,30,100,30);
		username.setFont(btn_f);
		add(username);
		password=new JLabel("Password");
		password.setBounds(10,80,100,30);
		password.setFont(btn_f);
		add(password);
		jt1=new JTextField();
		jt1.setBounds(130,30,350,30);
		add(jt1);
		jp1=new JPasswordField();
		jp1.setBounds(130,80,350,30);
		add(jp1);
		Font btn_l=new Font("Times New Roman",Font.BOLD,13);
		btn1=new JButton("LOGIN");
		btn1.setBounds(60,170,120,30);
		btn1.setForeground(Color.WHITE);
		btn1.setBackground(Color.GRAY);
		btn1.setFont(btn_l);
		add(btn1);
		btn2=new JButton("Cancel");
		btn2.setBounds(330,170,120,30);
		btn2.setForeground(Color.WHITE);
		btn2.setBackground(Color.GRAY);
		btn2.setFont(new Font("Times New Roman",Font.BOLD,15));
		add(btn2);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		
	}
	

}
