package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerChoice extends JFrame implements ActionListener{
	public String room_type;
	public String bed_type;
	
	JLabel bed,room_typ;
	JComboBox jb;
	JRadioButton jd1,jd2;
	JButton btn;
	public CustomerChoice()
	{
		getContentPane().setBackground(Color.WHITE);
		setTitle("Customer's Room Choice");
		setBounds(500,200,500,400);
		Font f1=new Font("Tahoma",Font.BOLD,16);
		room_typ=new JLabel("Room type");
		room_typ.setBounds(10,30,100,50);
		room_typ.setFont(f1);
		add(room_typ);
		String rooms[]= {"AC","Non-AC","Deluxe","Balcony view"};
		jb=new JComboBox(rooms);
		jb.setBounds(140,40,300,30);
		jb.setFont(f1);
		add(jb);
		bed=new JLabel("Bed");
		bed.setBounds(10,150,100,50);
		bed.setFont(f1);
		add(bed);
		jd1=new JRadioButton("Single");
		jd1.setBounds(140,160,70,27);
		add(jd1);
		jd2=new JRadioButton("Double");
		jd2.setBounds(250,160,75,27);
		add(jd2);
		btn=new JButton("Next");
		btn.setBounds(200,270,100,50);
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
			room_type=String.valueOf(jb.getItemAt(jb.getSelectedIndex()));
			if(jd1.isSelected())
				bed_type="Single";
			else
				bed_type="Double";
			new NewCustomerForm(room_type,bed_type);
		}
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CustomerChoice();
	}
}
