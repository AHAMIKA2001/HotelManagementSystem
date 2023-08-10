package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class CheckOut extends JFrame implements ActionListener{
	
	JLabel id,Cname,room_No,Time;
	JLabel id_no,C_name,room,time;
	JButton btn1;
	String idNum,Name,Room_No,checkInTime;
	public CheckOut(String id_num,String name,String room_no,String checkinTime) {
		
		idNum=id_num;
		Name=name;
		Room_No=room_no;
		checkInTime=checkinTime;
		
		getContentPane().setBackground(Color.WHITE);
		setTitle("Checking Out");
		setBounds(300,150,1000,570);
		
		Font f1=new Font("Tahoma",Font.BOLD,15);
    	id=new JLabel("Customer ID");
    	id.setBounds(10,30,100,50);
		id.setFont(f1);
		add(id);
		Font f2=new Font("Times New Roman",Font.PLAIN,17);
		id_no=new JLabel(id_num);
		id_no.setBounds(120,30,200,50);
		id_no.setFont(f2);
		add(id_no);
		Cname=new JLabel("Customer Name");
    	Cname.setBounds(10,90,140,50);
		Cname.setFont(f1);
		add(Cname);
		C_name=new JLabel(name);
		C_name.setBounds(145,90,200,50);
		C_name.setFont(f2);
		add(C_name);
		room_No=new JLabel("Room No.");
    	room_No.setBounds(10,150,140,50);
		room_No.setFont(f1);
		add(room_No);
		room=new JLabel(room_no);
		room.setBounds(145,150,200,50);
		room.setFont(f2);
		add(room);
		Time=new JLabel("Check-in Time");
    	Time.setBounds(10,210,140,50);
		Time.setFont(f1);
		add(Time);
		time=new JLabel(checkinTime);
		time.setBounds(145,210,200,50);
		time.setFont(f2);
		add(time);
		
		btn1=new JButton("Proceed to Check-Out");
		btn1.setBounds(350,400,200,50);
		btn1.setFont(new Font("Tahoma",Font.BOLD,15));
		add(btn1);
		btn1.addActionListener(this);
		
		setLayout(null);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btn1) {
			String query1="update roomdetails set availability='available' where room_no='"+Room_No+"'";
			String query2="delete from customerdetails where id_number='"+idNum+"'";
			
			Conn c=new Conn();
    		try {
    			c.s.executeUpdate(query1);
    			c.s.executeUpdate(query2);
    			JOptionPane.showMessageDialog(null,"Customer has successfully Checked Out.");
    		}catch(Exception ex)
    		{
    			ex.printStackTrace();;
    		}
		}
	}
	public static void main(String[] args) {
		
	}
}
