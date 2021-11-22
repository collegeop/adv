import java.sql.*;

public class dept {
 public static void main(String[] args) {
	String jdbcurl="jdbc:mysql://localhost:3306/test";
	String username="root";
	String password="";
	Connection con = null;
	try {
		con = DriverManager.getConnection(jdbcurl,username,password);
		System.out.println("Connected to Database..");
		String query="SELECT no_of_emp FROM department WHERE name=\"CSE\"";
		String query2="SELECT name,dept_id FROM department WHERE year_estab=2010";
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		System.out.println(query+"\n");
		while(rs.next())
		{
			System.out.println("No_Of_Emp:"+rs.getInt(1)+"\n");
		}
		ResultSet rs1 = st.executeQuery(query2);
		System.out.println(query2);
		while(rs1.next())
		{
			System.out.println("\nName: "+rs1.getString(1)+"\nDept_ID: "+rs1.getInt(2));
		}
		
	} 
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
