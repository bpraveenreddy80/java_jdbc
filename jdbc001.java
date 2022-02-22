package jdbc_type4;
import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc001 {
	public static void main(String[] args) {
		Connection con=null;
		Statement st = null;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle","c##praveen","7661009017");
			st =con.createStatement();
			String q="create table emp4(id number,name varchar2(10),age number(3))";
			st.executeUpdate(q);
			System.out.println("table created sucessfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{	
			try {
				con.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
