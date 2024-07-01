import java.sql.*;
import java.awt.*;
import java.awt.*;
import java.awt.event.*;


class Demo extends Frame implements ActionListener
{
	Button clear,save,login,exit;
	TextField txtfirstname,txtlastname,txtage,txtemail;
	TextArea txtAddress;
	Checkbox male;
	Checkbox female;
	CheckboxGroup cbg;
	Choice edutype;
	Choice coursetype;
	Login l;
	Demo()
	{	
		setTitle("Student Registration form");
		//for fonts
		Font namefont=new Font("TimesRoman",Font.BOLD,25);// Font.ITALIC
		Font firstname=new Font("arial",Font.PLAIN,15);
		
		//display project name
		Label projectname=new Label("Student Registration form");
		projectname.setBounds(350,50,310,100);
		projectname.setFont(namefont);
		projectname.setForeground(Color.GREEN);
		add(projectname);
		
		//Add Student First Name
		Label first_name=new Label("First Name:");
		first_name.setBounds(70,100,80,150);
		first_name.setFont(firstname);
		first_name.setForeground(Color.YELLOW);
		add(first_name);
		//textfield for first name
		txtfirstname=new TextField();
		txtfirstname.setBounds(250,164,200,25);
		txtfirstname.setFont(firstname);
		add(txtfirstname);
		
		//Add Student Last Name
		Label last_name=new Label("Last Name:");
		last_name.setBounds(70,180,80,150);
		last_name.setFont(firstname);
		last_name.setForeground(Color.YELLOW);
		add(last_name);
		//textfield for last name
		txtlastname=new TextField();
		txtlastname.setBounds(250,240,200,25);
		txtlastname.setFont(firstname);
		add(txtlastname);
	
		//Add student age 
		Label age=new Label("Age:");
		age.setBounds(70,260,80,150);
		age.setFont(firstname);
		age.setForeground(Color.YELLOW);
		add(age);
		//textfield for age
		txtage=new TextField();
		txtage.setBounds(250,320,200,25);
		txtage.setFont(firstname);
		add(txtage);
		
		//Gender 
		Label gender=new Label("Gender:");
		gender.setBounds(70,340,80,150);
		gender.setFont(firstname);
		gender.setForeground(Color.YELLOW);
		add(gender);
		
		cbg=new CheckboxGroup();
		male=new Checkbox("male",cbg,false);
		male.setBounds(250,400,50,25);
		male.setFont(firstname);
		male.setForeground(Color.WHITE);
		add(male);
		
		female=new Checkbox("female",cbg,false);
		female.setBounds(320,400,70,25);
		female.setFont(firstname);
		female.setForeground(Color.WHITE);
		add(female);
		
		//course
		Label course=new Label("Course:");
		course.setBounds(70,430,80,150);
		course.setFont(firstname);
		course.setForeground(Color.YELLOW);
		add(course);
		
		coursetype=new Choice();
		coursetype.setBounds(250,492,200,20);
		coursetype.setFont(firstname);
		coursetype.add("--select--");
		coursetype.add("Java(FSD)");
		coursetype.add("PHP(FSD)");
		coursetype.add("Python(FSD)");
		add(coursetype);
		
		//Education
		Label education=new Label("Education:");
		education.setBounds(500,100,80,150);
		education.setFont(firstname);
		education.setForeground(Color.YELLOW);
		add(education);
		
		edutype=new Choice();
		edutype.setBounds(650,164,200,20);
		edutype.setFont(firstname);
		edutype.add("--select--");
		edutype.add("Computer Engineering");
		edutype.add("BCS");
		edutype.add("BCA");
		edutype.add("MCS");
		edutype.add("MCA");
		edutype.add("other..");
		add(edutype);
		
		//address
		Label address=new Label("Address:");
		address.setBounds(500,180,80,150);
		address.setFont(firstname);
		address.setForeground(Color.YELLOW);
		add(address);
		
		txtAddress=new TextArea(10,30);
		txtAddress.setBounds(650,244,300,80);
		txtAddress.setFont(firstname);
		add(txtAddress);
		
		//add Email
		Label email=new Label("Email:");
		email.setBounds(500,280,80,150);
		email.setFont(firstname);
		email.setForeground(Color.YELLOW);
		add(email);
		txtemail=new TextField();
		txtemail.setBounds(650,340,200,25);
		txtemail.setFont(firstname);
		add(txtemail);
		
		//save
		save=new Button("SAVE");
		save.setBounds(650,390,100,25);
		save.setFont(firstname);
		save.setBackground(Color.BLUE);
		save.setForeground(Color.WHITE);
		add(save);
		
		//clear
		clear=new Button("CLEAR");
		clear.setBounds(780,390,100,25);
		clear.setFont(firstname);
		clear.setBackground(Color.RED);
		clear.setForeground(Color.WHITE);
		add(clear);
		
		//server login
		login=new Button("LOGIN");
		login.setBounds(910,390,100,25);
		login.setFont(firstname);
		login.setBackground(Color.GREEN);
		login.setForeground(Color.WHITE);
		add(login);
		
		//EXIT
		exit=new Button("EXIT");
		exit.setBounds(650,430,100,25);
		exit.setFont(firstname);
		exit.setBackground(Color.ORANGE);
		exit.setForeground(Color.WHITE);
		add(exit);
		
		
		save.addActionListener(this);
		clear.addActionListener(this);
		login.addActionListener(this);
		exit.addActionListener(this);
		
		
		Color formColor = new Color(53, 59, 72);
		setBackground(formColor);
		setSize(1000,600);
		setLayout(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==save)
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/small_project","root","saurabh1412");
				PreparedStatement pstmt=con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?)");
				
				System.out.println("connection successfully");
				
				//for first name and last name and age
				String first_name=txtfirstname.getText();
				String last_name=txtlastname.getText();
				String age=txtage.getText();
				//for checkbox gender
				boolean male_state=male.getState();
				String male1=male.getLabel();
				boolean female_state=female.getState();
				String female1=female.getLabel();
				//for address
				String address=txtAddress.getText();
				String email=txtemail.getText();
				
				pstmt.setString(1,first_name);
				pstmt.setString(2,last_name);
				pstmt.setString(3,age);
				
				if(male_state!=false)
				{
					pstmt.setString(4,male1);
				}
				else if(female_state!=false)
				{
					pstmt.setString(4,female1);
				}
				else
				{
					pstmt.setString(4," ");
				}
				
				pstmt.setString(5,coursetype.getItem(coursetype.getSelectedIndex()));
				pstmt.setString(6,edutype.getItem(edutype.getSelectedIndex()));
				pstmt.setString(7,address);
				pstmt.setString(8,email);
				int i=pstmt.executeUpdate();
				System.out.println(first_name+" "+last_name+" "+age+" "+address+" "+male_state+" "+female_state);
			}
			else if(ae.getSource()==clear)
			{
				txtfirstname.setText(" ");
				txtlastname.setText(" ");
				txtage.setText(" ");
				txtAddress.setText(" ");
				txtemail.setText(" ");
				//male.setLable(" ");
			}
			else if(ae.getSource()==login)
			{
				new Login();
			}
			else if(ae.getSource()==exit)
			{
				System.exit(0);
			}
				
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
	}
	
		
	
	public static void main(String args[])
	{
		Demo d=new Demo();
	}
}