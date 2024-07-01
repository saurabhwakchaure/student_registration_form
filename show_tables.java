/*import java.sql.*;
class Show_table
{
	
	void display_table()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/small_project","root","saurabh1412");
			PreparedStatement pstmt=con.prepareStatement("select*from student");
			System.out.println("connection successfully");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				String fname=rs.getString("first_name");
				String lname=rs.getString("last_name");
				int age=rs.getInt("age");
				String gender=rs.getString("gender");
				String course=rs.getString("course");
				String education=rs.getString("education");
				String address=rs.getString("address");
				String email=rs.getString("email");
				
				System.out.println(fname+" "+lname+" "+age+" "+gender+" "+course+" "+education+" "+address+" "+email);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
				
				
				
	Show_table()
	{
		System.out.println("correct");
		display_table();
	}
	
	public static void main(String args[])
	{
		Show_table st=new Show_table();
	}
}*/
import java.sql.*;

class Show_table
{			
	Show_table()
	{
		/*setTitle("DATA");
		//for fonts
		Font namefont=new Font("TimesRoman",Font.BOLD,25);// Font.ITALIC
		Font firstname=new Font("arial",Font.PLAIN,15);
		TextArea output=new TextArea();
		output.setBounds(650,244,300,80);
		output.setFont(firstname);
		add(output);*/
		
		try
		{
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/small_project","root","saurabh1412");
			PreparedStatement pstmt=con.prepareStatement("select*from student");
			//output.setText("Data fetch successfully(plz see the console)");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				String fname=rs.getString("first_name");
				String lname=rs.getString("last_name");
				int age=rs.getInt("age");
				String gender=rs.getString("gender");
				String course=rs.getString("course");
				String education=rs.getString("education");
				String address=rs.getString("address");
				String email=rs.getString("email");
				

				System.out.println(fname+" "+lname+" "+age+" "+gender+" "+course+" "+education+" "+address+" "+email);
				
			}
			System.exit(0);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		Show_table st=new Show_table();
	}
}


		