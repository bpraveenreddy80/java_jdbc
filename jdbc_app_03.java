package jdbc_appln003;

import java.sql.DriverManager;
import java.sql.*;
import java.util.*;
import oracle.jdbc.OracleDriver;
public class jdbc_app_03 {
	public static void updatedetails()
	{
		Connection con = null;
		Statement st =null;
		Scanner sc = new Scanner(System.in);
		int r_cnt=0;
		try {
		DriverManager.registerDriver(new OracleDriver());
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle", "c##praveen","7661009017");
		st = con.createStatement();
		while(true)
		{
			System.out.print("if you want to update mobile_no [yes/no] : ");
			String op=sc.next();
			if(op.equalsIgnoreCase("yes"))
			{
				System.out.print("enter student id : ");
				int id= sc.nextInt();
				System.out.print("enter mobile no you want to update : ");
				long mobile_no=sc.nextLong();
				String q = "update stu set MOBILE_NO = "+mobile_no+" where SID = "+id;
				st.executeUpdate(q);
				System.out.println("table updated sucessfully");
				r_cnt++;
			}
			else
			{
				break;
			}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try
			{
				con.close();
				System.out.println("connection closed sucessfully");
				st.close();
				System.out.println("Statement  closed sucessfully");
				sc.close();
				System.out.println("Scanner closed sucessfully");
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Total no of rows updated : "+r_cnt);
	}
	public static void main(String[] args) {
		updatedetails();
	}

}
