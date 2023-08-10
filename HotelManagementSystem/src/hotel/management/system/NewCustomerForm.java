package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;



public class NewCustomerForm extends JFrame implements ActionListener {
	
	JLabel id_type,id_number,name,gender,country,room_no,checkin_time,deposit,dte;
	JTextField jtidn,jtn,jtc,jtd;
	JComboBox jcidt;
	JRadioButton jd1,jd2;
	Choice croom;
	JButton btn;
	NewCustomerForm(String room_type,String bed_type)
	{
		getContentPane().setBackground(Color.WHITE);
		setTitle("New Customer Details Form");
		setBounds(300,70,650,750);
		
		Font f1=new Font("Tahoma",Font.BOLD,16);
		id_type=new JLabel("ID type");
		id_type.setBounds(10,30,100,50);
		id_type.setFont(f1);
		add(id_type);
		String idtype[]= {"Aadhar Card","Passport","Voter-id Card","Driving License"};
		jcidt=new JComboBox(idtype);
		jcidt.setBounds(140,40,300,30);
		jcidt.setFont(f1);
		add(jcidt);
		id_number=new JLabel("ID Number");
		id_number.setBounds(10,100,100,50);
		id_number.setFont(f1);
		add(id_number);
		jtidn=new JTextField();
		jtidn.setBounds(140,110,300,30);
		add(jtidn);
		name=new JLabel("Name");
		name.setBounds(10,170,100,50);
		name.setFont(f1);
		add(name);
		jtn=new JTextField();
		jtn.setBounds(140,180,300,30);
		add(jtn);
		gender=new JLabel("Gender");
		gender.setBounds(10,240,100,50);
		gender.setFont(f1);
		add(gender);
		jd1=new JRadioButton("MALE");
		jd1.setBounds(140,250,70,27);
		add(jd1);
		jd2=new JRadioButton("FEMALE");
		jd2.setBounds(250,250,75,27);
		add(jd2);
		country=new JLabel("Country");
		country.setBounds(10,310,100,50);
		country.setFont(f1);
		add(country);
		jtc=new JTextField();
		jtc.setBounds(140,320,300,30);
		add(jtc);
		room_no=new JLabel("Room Number");
		room_no.setBounds(10,380,120,50);
		room_no.setFont(f1);
		add(room_no);
		croom=new Choice();
		try {
			Conn conn=new Conn();
			String query="Select * from roomdetails where availability='available' and room_type='"+room_type+"' and bed='"+bed_type+"'";
			ResultSet rs=conn.s.executeQuery(query);
			while(rs.next()) {
				croom.add(rs.getString("room_no"));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		croom.setBounds(140,395,300,50);
		croom.setFont(f1);
		add(croom);
		checkin_time=new JLabel("Check-in Time");
		checkin_time.setBounds(10,450,120,50);
		checkin_time.setFont(f1);
		add(checkin_time);
		Date date=new Date();
		dte=new JLabel(""+date);
		dte.setBounds(140,450,150,50);
		dte.setFont(new Font("Times new roman",Font.BOLD,15));
		add(dte);
		deposit=new JLabel("Deposit");
		deposit.setBounds(10,520,120,50);
	    deposit.setFont(f1);
		add(deposit);
		jtd=new JTextField();
		jtd.setBounds(140,530,300,30);
		add(jtd);
		btn=new JButton("Submit");
		btn.setBounds(200,570,100,50);
		btn.setFont(f1);
		add(btn);
		btn.addActionListener(this);
		setLayout(null);
		setVisible(true);
	}
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==btn)
    	{
    		String id_type=String.valueOf(jcidt.getItemAt(jcidt.getSelectedIndex()));
    		String id_num=jtidn.getText();
    		String name=jtn.getText();
    		String gender="";
    		if(jd1.isSelected())
    			gender="M";
    		else
    			gender="F";
    		String country=jtc.getText();
    		String room_no=croom.getSelectedItem();
    		String time=dte.getText();
    		String depos=jtd.getText();
    		String query1="Insert into customerdetails values('"+id_type+"','"+id_num+"','"+name+"','"+gender+"','"+room_no+"','"+time+"','"+depos+"','"+country+"')";
    		String query2="Update roomdetails set availability='occupied' where room_no='"+room_no+"'";
    		Conn c=new Conn();
    		try {
    			c.s.executeUpdate(query1);
    			c.s.executeUpdate(query2);
    			JOptionPane.showMessageDialog(null,"Records are entered successfully");
    		}catch(Exception ex)
    		{
    			ex.printStackTrace();;
    		}
    	}
    }
}
