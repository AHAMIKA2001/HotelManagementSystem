package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class ViewCustomerDetails extends JFrame {
	JTable table;
	JLabel id_type,id_number,name,gender,room_no,checkin_time,country;
	public ViewCustomerDetails() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("View Customer Details");
		setBounds(300,120,800,700);
		
		id_type=new JLabel("Id_type");
		id_type.setFont(new Font("Times New Roman",Font.BOLD,14));
		id_type.setBounds(30,20,50,20);
    	add(id_type);
    	id_number=new JLabel("Id_number");
    	id_number.setFont(new Font("Times New Roman",Font.BOLD,14));
    	id_number.setBounds(130,20,70,20);
    	add(id_number);
    	name=new JLabel("Name");
    	name.setFont(new Font("Times New Roman",Font.BOLD,14));
    	name.setBounds(235,20,50,20);
    	add(name);
    	gender=new JLabel("Gender");
    	gender.setFont(new Font("Times New Roman",Font.BOLD,12));
    	gender.setBounds(340,20,70,20);
    	add(gender);
    	room_no=new JLabel("Room_No");
    	room_no.setFont(new Font("Times New Roman",Font.BOLD,14));
    	room_no.setBounds(450,20,80,20);
    	add(room_no);
    	checkin_time=new JLabel("Checkin_time");
    	checkin_time.setFont(new Font("Times New Roman",Font.BOLD,14));
    	checkin_time.setBounds(550,20,100,20);
    	add(checkin_time);
    	country=new JLabel("Country");
    	country.setFont(new Font("Times New Roman",Font.BOLD,14));
    	country.setBounds(670,20,80,20);
    	add(country);
		table=new JTable();
    	table.setBounds(20,50,750,660);
    	add(table);
		try {
    		Conn c=new Conn();
    		String query="select id_type,id_number,name,gender,room_no,checkin_time,country from customerdetails";
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
		new ViewCustomerDetails();

	}

}
