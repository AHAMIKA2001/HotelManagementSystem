package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class ViewEmployeeDetails extends JFrame {
	JTable table;
	JLabel name,age,gender,design,salary,address,aadhar_no,mobile_no,email;
	public ViewEmployeeDetails() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("View Employee Details");
		setBounds(300,120,800,700);
		
		name=new JLabel("Name");
    	name.setFont(new Font("Times New Roman",Font.BOLD,14));
    	name.setBounds(30,20,50,20);
    	add(name);
    	age=new JLabel("Age");
    	age.setFont(new Font("Times New Roman",Font.BOLD,14));
    	age.setBounds(120,20,50,20);
    	add(age);
    	gender=new JLabel("Gender");
    	gender.setFont(new Font("Times New Roman",Font.BOLD,14));
    	gender.setBounds(200,20,50,20);
    	add(gender);
    	design=new JLabel("Designation");
    	design.setFont(new Font("Times New Roman",Font.BOLD,12));
    	design.setBounds(270,20,70,20);
    	add(design);
    	salary=new JLabel("Salary");
    	salary.setFont(new Font("Times New Roman",Font.BOLD,14));
    	salary.setBounds(360,20,50,20);
    	add(salary);
    	address=new JLabel("Address");
    	address.setFont(new Font("Times New Roman",Font.BOLD,14));
    	address.setBounds(440,20,50,20);
    	add(address);
    	aadhar_no=new JLabel("Aadhar No.");
    	aadhar_no.setFont(new Font("Times New Roman",Font.BOLD,14));
    	aadhar_no.setBounds(520,20,90,20);
    	add(aadhar_no);
    	mobile_no=new JLabel("Mobile No.");
    	mobile_no.setFont(new Font("Times New Roman",Font.BOLD,14));
    	mobile_no.setBounds(610,20,90,20);
    	add(mobile_no);
    	email=new JLabel("Email");
    	email.setFont(new Font("Times New Roman",Font.BOLD,14));
    	email.setBounds(710,20,50,20);
    	add(email);
		table=new JTable();
    	table.setBounds(20,50,750,660);
    	add(table);
		try {
    		Conn c=new Conn();
    		String query="select * from employeedetails";
    		ResultSet rs=c.s.executeQuery(query);
    		table.setModel(DbUtils.resultSetToTableModel(rs));
    		
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		setLayout(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ViewEmployeeDetails();

	}

}
