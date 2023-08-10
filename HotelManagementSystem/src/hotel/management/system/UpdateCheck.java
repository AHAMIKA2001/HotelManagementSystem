package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class UpdateCheck extends JFrame implements ActionListener {
	
	JLabel id,Cname,room_No,Time,deposit,payableAmt,paidAmt;
	JLabel id_no,C_name,room,time,payable,paid;
	JTextField amt;
	JButton btn;
	public UpdateCheck(String id_num,String name,String roomNo,String checkinTime,String depos)
	{
		/*String mon=checkinTime.substring(4,7);
		int date=Integer.parseInt(checkinTime.substring(8,10));
		Date dte=new Date();
		String currdate=""+dte;
		String currmon=currdate.substring(4,7);
		int d=Integer.parseInt(currdate.substring(8,10));
		int cost=1;
		try {
			Conn c=new Conn();
			String q="select price from roomdetails where room_no='"+roomNo+"'";
			ResultSet rs=c.s.executeQuery(q);
			while(rs.next())
				cost=rs.getInt("price");
			
		}catch(Exception ae) {
			ae.printStackTrace();
		}
		int pay=0;
		if(mon.equals(currmon))
		{
			pay=((d-date)+1)*cost;
		}
		else
		{
			int lastdate=noOfDays(mon);
			pay=((lastdate-date)+(d-1)+1)*cost;
		}*/
		//System.out.println(pay);
		new CalculatePayableAmount(roomNo,checkinTime);
		int pay=CalculatePayableAmount.payableAmt();
		
		getContentPane().setBackground(Color.WHITE);
		setTitle("Update Payment Status of Customer");
		setBounds(300,150,1000,570);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/pics/update.jpg"));
    	Image i2=i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
    	ImageIcon i3=new ImageIcon(i2);
    	JLabel l1=new JLabel(i3);
    	l1.setBounds(500,0,500,500);
    	add(l1);
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
		room=new JLabel(roomNo);
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
		payableAmt=new JLabel("Payable Amount");
    	payableAmt.setBounds(10,270,140,50);
		payableAmt.setFont(f1);
		add(payableAmt);
		payable=new JLabel(""+pay);
		payable.setBounds(145,270,200,50);
		payable.setFont(f2);
		add(payable);
		paidAmt=new JLabel("Paid Amount");
    	paidAmt.setBounds(10,330,140,50);
		paidAmt.setFont(f1);
		add(paidAmt);
		paid=new JLabel(depos);
		paid.setBounds(145,330,200,50);
		paid.setFont(f2);
		add(paid);
		deposit=new JLabel("Deposit");
    	deposit.setBounds(10,390,140,50);
		deposit.setFont(f1);
		add(deposit);
		amt=new JTextField();
		amt.setBounds(145,400,200,30);
		add(amt);
		btn=new JButton("Update");
		btn.setBounds(190,450,100,40);
		btn.setFont(new Font("Tahoma",Font.BOLD,15));
		add(btn);
		btn.addActionListener(this);
		
		setLayout(null);
		setVisible(true);
		
	}
	/*public int noOfDays(String mon)
	{
		switch(mon) {
		case "Jan":
		case "Mar":
		case "May":
		case "Jul":
		case "Aug":
		case "Oct":
		case "Dec":
			return 31;
		case "Feb":
			return 28;
		case "Apr":
		case "Jun":
		case "Sep":
		case "Nov":
			return 30;
		}
		return 0;
	}*/
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn)
		{
			String id=id_no.getText();
			int amount=Integer.parseInt(paid.getText())+Integer.parseInt(amt.getText());
			try {
				Conn c=new Conn();
				String q="update customerdetails set deposit='"+amount+"' where id_number='"+id+"'";
				c.s.executeUpdate(q);
				JOptionPane.showMessageDialog(null,"Records are successfully updated");
			}catch(Exception ae)
			{
				ae.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
	
	}
}
