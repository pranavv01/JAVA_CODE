import java.sql.*;  
class conSql{  
public static void main(String args[]){  
try
{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?characterEncoding=latin1","root","yug123");  
//here sonoo is database name, root is username and password  
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from std");  
	while(rs.next())  
	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  ");  
	con.close();  
}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
}  
}  //https://www.javatpoint.com/socket-programming