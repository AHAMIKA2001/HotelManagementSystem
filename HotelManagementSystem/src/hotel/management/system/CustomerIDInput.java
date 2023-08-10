package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class CustomerIDInput extends JFrame implements ActionListener {
	
	JLabel id;
	Choice cid;
	JButton btn1,btn2;
	public CustomerIDInput() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Customer-ID");
		setBounds(500,150,500,350);
		
		id=new JLabel("Customer ID");
		id.setBounds(10,30,100,50);
		id.setFont(new Font("Tahoma",Font.BOLD,15));
		add(id);
		cid=new Choice();
		try {
			Conn c=new Conn();
			String query="select id_number from customerdetails";
			ResultSet rs=c.s.executeQuery(query);
			while(rs.next())
				cid.add(rs.getString("id_number"));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		cid.setBounds(140,45,300,50);
		cid.setFont(new Font("Tahoma",Font.BOLD,15));
		add(cid);
		btn1=new JButton("Pay");
		btn1.setBounds(70,200,130,50);
		btn1.setFont(new Font("Tahoma",Font.BOLD,15));
		add(btn1);
		btn2=new JButton("Check-Out");
		btn2.setBounds(270,200,130,50);
		btn2.setFont(new Font("Tahoma",Font.BOLD,15));
		add(btn2);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		setLayout(null);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		String id_num="",name="",room_no="",checkinTime="",depos="";
		try {
		Conn c=new Conn();
		String id=cid.getSelectedItem();
		String query="select * from customerdetails where id_number='"+id+"'";
		ResultSet rs=c.s.executeQuery(query);
		while(rs.next())
		{
		id_num=rs.getString("id_number");
		name=rs.getString("name");
		room_no=rs.getString("room_no");
		checkinTime=rs.getString("checkin_time");
		depos=rs.getString("deposit");
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		if(e.getSource()==btn1)
			new UpdateCheck(id_num,name,room_no,checkinTime,depos);
		else if(e.getSource()==btn2)
		{
			new CalculatePayableAmount(room_no,checkinTime);
			int pay=CalculatePayableAmount.payableAmt();
			int paid=Integer.parseInt(depos);
			
			if(paid<pay)
			   new PendingPayment();
			else if(paid==pay)
			   new CheckOut(id_num,name,room_no,checkinTime);
		}
	}

	public static void main(String[] args) {
		new CustomerIDInput();

	}

}
