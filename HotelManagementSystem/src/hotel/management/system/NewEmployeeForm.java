package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class NewEmployeeForm extends JFrame implements ActionListener {
	JLabel name,age,gender,job,salary,address,aadhar_no,mobile_no,username,email,password;
	JTextField jtna,jtag,jtsa,jtad,jtaa,jtmo,jtus,jtem;
	JComboBox jb;
	JRadioButton jd1,jd2;
	JPasswordField jp1;
	JButton btn;
	NewEmployeeForm()
	{
		    
		    getContentPane().setBackground(Color.WHITE);
			setTitle("New Employee Details Form");
			setBounds(300,150,650,650);
			Font f1=new Font("Tahoma",Font.BOLD,16);
			name=new JLabel("Name");
			name.setBounds(10,30,60,50);
			name.setFont(f1);
			add(name);
			jtna=new JTextField();
			jtna.setBounds(120,40,400,25);
			add(jtna);
			address=new JLabel("Address");
			address.setBounds(10,80,120,50);
			address.setFont(f1);
			add(address);
			jtad=new JTextField();
			jtad.setBounds(120,90,400,25);
			add(jtad);
			age=new JLabel("Age");
			age.setBounds(10,130,120,50);
			age.setFont(f1);
			add(age);
			jtag=new JTextField();
			jtag.setBounds(120,140,50,25);
			add(jtag);
			gender=new JLabel("Gender");
			gender.setBounds(10,180,120,50);
			gender.setFont(f1);
			add(gender);
			jd1=new JRadioButton("MALE");
			jd1.setBounds(120,190,70,27);
			add(jd1);
			jd2=new JRadioButton("FEMALE");
			jd2.setBounds(200,190,75,27);
			add(jd2);
			job=new JLabel("JOB");
			job.setFont(f1);
			job.setBounds(10,230,120,50);
			add(job);
			String jobs[]= {"Receptionist","Porter","Housekeeper","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
			jb=new JComboBox(jobs);
			jb.setBounds(120,240,150,25);
			add(jb);
			salary=new JLabel("Salary");
			salary.setFont(f1);
			salary.setBounds(300,230,120,50);
			add(salary);
			jtsa=new JTextField();
			jtsa.setBounds(400,240,150,25);
			add(jtsa);
			aadhar_no=new JLabel("Aadhar No");
			aadhar_no.setBounds(10,280,120,50);
			aadhar_no.setFont(f1);
			add(aadhar_no);
			jtaa=new JTextField();
			jtaa.setBounds(120,290,300,25);
			add(jtaa);
			mobile_no=new JLabel("Mobile No");
			mobile_no.setBounds(10,330,120,50);
			mobile_no.setFont(f1);
			add(mobile_no);
			jtmo=new JTextField();
			jtmo.setBounds(120,340,300,25);
			add(jtmo);
			email=new JLabel("Email");
			email.setBounds(10,380,120,50);
			email.setFont(f1);
			add(email);
			jtem=new JTextField();
			jtem.setBounds(120,390,300,25);
			add(jtem);
			username=new JLabel("Username");
			username.setBounds(10,430,120,50);
			username.setFont(f1);
			add(username);
			jtus=new JTextField();
			jtus.setBounds(120,440,300,25);
			add(jtus);
			password=new JLabel("Password");
			password.setBounds(10,480,170,50);
			password.setFont(f1);
			add(password);
			jp1=new JPasswordField();
			jp1.setBounds(120,490,300,25);
			add(jp1);
			btn=new JButton("Submit");
			btn.setBounds(250,550,120,30);
			btn.setForeground(Color.WHITE);
			btn.setBackground(Color.GRAY);
			btn.setFont(new Font("Times New Roman",Font.BOLD,16));
			add(btn);
			btn.addActionListener(this);
			setLayout(null);
			setVisible(true);
		}
    
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn)
		{
			String name=jtna.getText();
			int age=Integer.parseInt(jtag.getText());
			String gender="";
			if(jd1.isSelected())
				gender="M";
			else if(jd2.isSelected())
				gender="F";
			String address=jtad.getText();
			String job=String.valueOf(jb.getItemAt(jb.getSelectedIndex()));
			int salary=Integer.parseInt(jtsa.getText());
			String email=jtem.getText();
			String aadhar_no=jtaa.getText();
			String mobile_no=jtmo.getText();
			String username=jtus.getText();
			String password=jp1.getText();
			Conn c=new Conn();
			String str1="Insert into employeedetails values('"+name+"',"+age+",'"+gender+"','"+job+"',"+salary+",'"+address+"','"+aadhar_no+"','"+mobile_no+"','"+email+"')";
			String str2="Insert into employeelogin values('"+username+"','"+password+"')";
			try
			{
				c.s.executeUpdate(str1);
				c.s.executeUpdate(str2);
				JOptionPane.showMessageDialog(null,"Records are inserted successfully");
			}catch(Exception ex)
			{
				System.out.println("Exception while entering records");
			}
		}
	}
}
