package jdbc_appln002;
import java.sql.*;
import java.util.*;
public class jdbc_001 {
	public static void createTable()
	{
		Connection con = null;
		Scanner sc = new Scanner(System.in);
		Statement st = null;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle","c##praveen","7661009017");
			st = con.createStatement();
			String q = "create table";
			System.out.print("enter Table name : ");
			String tname=sc.next();
			q=q+" "+tname+"(";
			String primary_key="";
			while(true)
			{
				System.out.print("If you want to add column [yes/no] : ");
				String op=sc.next();
				if(op.equalsIgnoreCase("yes"))
				{
					System.out.print("Enter col name : ");
					String col_name=sc.next();
					System.out.print("Enter col datatype with size : ");
					String col_datatype=sc.next();
					q=q+col_name+" "+col_datatype+",";
					System.out.print("it is primary key [yes/no] : ");
					String pk=sc.next();
					if(pk.equalsIgnoreCase("yes"))
						primary_key+=col_name+",";
				}
				else
				{
					q=q+"primary key("+primary_key.substring(0,primary_key.length()-1)+"))";
					break;
				}
			}
			st.executeUpdate(q);
			System.out.println(q);
			System.out.println("table created sucessfully");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				System.out.println("Con closed sucessfully");
				st.close();
				System.out.println("St closed sucessfully");
				sc.close();
				System.out.println("scanner closed sucessfully");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void insertvalues()
	{
		Connection con=null;
		Statement st = null;
		Scanner sc = new Scanner(System.in);
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle", "c##praveen","7661009017");
			st = con.createStatement();
			
			while(true)
			{
				System.out.println("Did u want to add the data [yes/no] : ");
				String op=sc.next();
				if(op.equalsIgnoreCase("yes"))
				{
					System.out.print("Enter student id : ");
					int id=sc.nextInt();
					System.out.print("Enter student Student Name : ");
					String name=sc.next();
					System.out.print("Enter student Student class : ");
					String c_name=sc.next();
					System.out.print("Enter student Student Mobile no : ");
					Long num = sc.nextLong();
					sc.nextLine();
					System.out.print("Enter student Student Address : ");
					String add=sc.next();
					String q = "insert into stu values(";
					q = q+id+",'"+name+"','"+c_name+"',"+num+",'"+add+"')";
					st.executeUpdate(q);
					System.out.println(q+" Data inserted Sucessfully");
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
				System.out.println("Statement closed sucessfully");
				sc.close();
				System.out.println("Scanner closed sucessfully");
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" if you want to insert data in to the student table [yes/no] : ");
		String op=sc.next();
		if(op.equalsIgnoreCase("yes"))
		{
			insertvalues();
		}
		else
		{
			sc.close();
			System.out.println("pgm executed sucessfully");
		}
	}

}
