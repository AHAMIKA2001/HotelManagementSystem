package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class ViewRoom extends JFrame {
	JTable table;
	JLabel room_no,room_type,bed_type,price,avail;
	public ViewRoom() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("View Rooms Details");
		setBounds(300,80,1200,700);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/pics/bedroom.jpg"));
    	Image i2=i1.getImage().getScaledInstance(600,700,Image.SCALE_DEFAULT);
    	ImageIcon i3=new ImageIcon(i2);
    	JLabel l1=new JLabel(i3);
    	l1.setBounds(585,0,600,700);
    	add(l1);
    	
    	room_no=new JLabel("Room No");
    	room_no.setFont(new Font("Times New Roman",Font.BOLD,12));
    	room_no.setBounds(30,20,50,20);
    	add(room_no);
    	room_type=new JLabel("Room Type");
    	room_type.setFont(new Font("Times New Roman",Font.BOLD,12));
    	room_type.setBounds(140,20,70,20);
    	add(room_type);
    	bed_type=new JLabel("Bed Type");
    	bed_type.setFont(new Font("Times New Roman",Font.BOLD,12));
    	bed_type.setBounds(250,20,70,20);
    	add(bed_type);
    	price=new JLabel("Price");
    	price.setFont(new Font("Times New Roman",Font.BOLD,12));
    	price.setBounds(360,20,70,20);
    	add(price);
    	avail=new JLabel("Availability");
    	avail.setFont(new Font("Times New Roman",Font.BOLD,12));
    	avail.setBounds(470,20,80,20);
    	add(avail);
    	table=new JTable();
    	table.setBounds(20,50,550,700);
    	add(table);
    	try {
    		Conn c=new Conn();
    		String query="select * from roomdetails";
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
		new ViewRoom();

	}

}
