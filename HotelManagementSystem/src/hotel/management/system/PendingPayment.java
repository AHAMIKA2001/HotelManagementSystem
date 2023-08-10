package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class PendingPayment extends JFrame {
	
	JLabel info;
       
	public PendingPayment() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(500,150,500,350);
		Font f1=new Font("Tahoma",Font.BOLD,15);
		info=new JLabel("Payments are Pending.");
		info.setBounds(80,50,250,50);
		info.setFont(f1);
		add(info);
		
		setLayout(null);
		setVisible(true);

	}
}
