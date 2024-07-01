import java.util.*;
import java.sql.*;
class Demo
{
	public static void main(String args[])throws Exception
	{ 
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/small_project","root","saurabh1412");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from student");
		if(con!=null)
		{
			System.out.println("connection establish");
		}
		else
		{
			System.out.println("connection is not establish");
		}
		while(rs.next())
		{
			System.out.println("student_id "  +  rs.getInt("s_no") + " student_name "  +  rs.getString(2) + " student_address " + rs.getString("s_address"));
			System.out.println();
		}
	
	}
}
