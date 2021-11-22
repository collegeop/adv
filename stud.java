import java.sql.*;
public class stud {
	public static void main(String[] args) {
		String jdbcurl="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="";
		Connection con = null;
		try {
			con=DriverManager.getConnection(jdbcurl,username,password);
			String query="SELECT * FROM student WHERE CGPA<9.0";
			String query2="SELECT * FROM student";
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			System.out.println(query);
			while(rs.next())
			{
				System.out.println("USN: "+rs.getString(1)+" Name: "+rs.getString(2)+" CGPA: "+rs.getFloat(3));
			}
			System.out.println(query2);
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery(query2);
			while(rs.next())
			{
				if(rs.getString("Name").equals("JOHN"))
				{
					rs.updateFloat(3,(float) 9.5);
					rs.updateRow();
					System.out.println("Updated..");
				}
				System.out.println("USN: "+rs.getString("USN")+" Name: "+rs.getString("Name")+" CGPA: "+rs.getDouble("CGPA"));
				
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
