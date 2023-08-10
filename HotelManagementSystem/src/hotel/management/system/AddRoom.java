package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRoom extends JFrame implements ActionListener{
	
	JLabel room_no,room_type,price,bed,avail;
	JTextField jtrn,jtp;
	JComboBox jtrt;
	JRadioButton jt1,jt2,jt3,jt4;
	JButton btn;
	public AddRoom()
	{
		getContentPane().setBackground(Color.WHITE);
		setTitle("Add New Room");
		setBounds(300,150,500,500);
		Font f1=new Font("Tahoma",Font.BOLD,16);
		room_no=new JLabel("Room No");
		room_no.setBounds(10,50,100,50);
		room_no.setFont(f1);
		add(room_no);
		jtrn=new JTextField();
		jtrn.setBounds(110,60,250,25);
		add(jtrn);
		room_type=new JLabel("Room Type");
		room_type.setBounds(10,110,100,50);
		room_type.setFont(f1);
		add(room_type);
		String rooms[]={"AC","Non-AC","Deluxe","Balcony view"};
		jtrt=new JComboBox(rooms);
		jtrt.setBounds(110,120,250,25);
		add(jtrt);
		bed=new JLabel("Bed");
		bed.setBounds(10,170,100,50);
		bed.setFont(f1);
		add(bed);
		jt1=new JRadioButton("Single");
		jt1.setBounds(110,180,100,27);
		add(jt1);
		jt2=new JRadioButton("Double");
		jt2.setBounds(220,180,100,27);
		add(jt2);
		price=new JLabel("Price");
	    price.setBounds(10,230,100,50);
		price.setFont(f1);
		add(price);
		jtp=new JTextField();
		jtp.setBounds(110,240,250,25);
		add(jtp);
		avail=new JLabel("Availability");
		avail.setBounds(10,290,100,50);
		avail.setFont(f1);
		add(avail);
		jt3=new JRadioButton("Yes");
		jt3.setBounds(110,300,100,27);
		add(jt3);
		jt4=new JRadioButton("No");
		jt4.setBounds(220,300,100,27);
		add(jt4);
		btn=new JButton("Add Room");
		btn.setBounds(150,350,150,30);
		add(btn);
		btn.addActionListener(this);
		
		setLayout(null);
		setVisible(true);
	}
    public void actionPerformed(ActionEvent e)
    {
    	if(e.getSource()==btn)
    	{
    		String room_no=jtrn.getText();
    		int price=Integer.parseInt(jtp.getText());
    		String bed="";
    		String avail="";
    		if(jt1.isSelected())
    			bed="Single";
    		else if(jt2.isSelected())
    			bed="Double";
    		if(jt3.isSelected())
    			avail="available";
    		else if(jt4.isSelected())
    			avail="unavailable";
    	   String room_typ=String.valueOf(jtrt.getItemAt(jtrt.getSelectedIndex()));
    	   Conn c=new Conn();
    	   String str="Insert into roomdetails values('"+room_no+"','"+room_typ+"','"+bed+"',"+price+",'"+avail+"')";
    	   try
			{
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null,"New Room Details are inserted successfully");
			}catch(Exception ex)
			{
				System.out.println("Exception while entering new details");
			}
    	}
    }
    public static void main(String[] args)
    {
    	new AddRoom();
    }

}
