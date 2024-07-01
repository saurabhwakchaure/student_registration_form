import java.awt.*;
import java.awt.event.*;

public class Login extends Frame implements ActionListener
{
	String username;
	String password;
	
	Button submit,back;
	TextField txtusername,txtpassword;
	
	Login()
	{
		username="saurabh1412";
		password="123";
		setTitle("Login Page");
		Font namefont=new Font("TimesRoman",Font.BOLD,25);
		Font firstname=new Font("arial",Font.PLAIN,15);
		
		Label projectname=new Label("Login page");
		projectname.setBounds(450,50,310,100);
		projectname.setFont(namefont);
		projectname.setForeground(Color.GREEN);
		add(projectname);
		
		//add username
		Label username=new Label("Username:");
		username.setBounds(350,100,80,150);
		username.setFont(firstname);
		username.setForeground(Color.YELLOW);
		add(username);
		//textfield for username
		txtusername=new TextField();
		txtusername.setBounds(500,164,200,25);
		txtusername.setFont(firstname);
		add(txtusername);	
		
		//Add password
		Label password=new Label("Password:");
		password.setBounds(350,180,80,150);
		password.setFont(firstname);
		password.setForeground(Color.YELLOW);
		add(password);
		//textfield for password
		txtpassword=new TextField();
		txtpassword.setBounds(500,240,200,25);
		txtpassword.setFont(firstname);
		add(txtpassword);
		//submit button
		submit=new Button("SUBMIT");
		submit.setBounds(600,300,100,25);
		submit.setFont(firstname);
		submit.setBackground(Color.GREEN);
		submit.setForeground(Color.WHITE);
		add(submit);
		//back button
		back=new Button("EXIT");
		back.setBounds(470,300,100,25);
		back.setFont(firstname);
		back.setBackground(Color.RED);
		back.setForeground(Color.WHITE);
		add(back);
		
		submit.addActionListener(this);
		back.addActionListener(this);
		
		Color formColor = new Color(53, 59, 72);
		setBackground(formColor);
		setSize(1000,600);
		setLayout(null);
		setVisible(true);

		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==submit)
		{
			try
			{
				String user_name=txtusername.getText();
				String pass=txtpassword.getText();
				if(user_name.equals(username) && pass.equals(password))
				{
					new Show_table();
				}
				else
				{
					throw new Exception("username or password is incorrect");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}	
		else if(ae.getSource()==back)
		{
			System.exit(0);
		}
	}
	
	public static void main(String args[])
	{
		Login l=new Login();
	}
	
}

