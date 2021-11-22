//<!DOCTYPE html>
//<html>
//<head>
//<meta charset="UTF-8">
//<title>Insert title here</title>
//</head>
//<body>
//<h1>Employee Database</h1>
//<form action="employee" method="post">
//	<h2>
//		Enter EmpID:<input type="number" name="emp_id"><br>
//		Enter Name:<input type="text" name="name"><br>
//		Enter Address:<input type="text" name="addr"><br>
//		Enter DOB:<input type="date" name="dob"><br>
//		<input type="submit" value="submit">
//	</h2>
//</form>
//</body>
//</html>

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class employee
 */
@WebServlet("/employee")
public class employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String jdbcurl="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="";
		Connection con=null;
		try {
			con = DriverManager.getConnection(jdbcurl,username,password);
			int id = Integer.parseInt(request.getParameter("emp_id"));
			String name = request.getParameter("name");
			String addr = request.getParameter("addr");
			String dob = request.getParameter("dob");
			String query="INSERT INTO employee VALUES('"+id+"','"+name+"','"+addr+"','"+dob+"')";
			PreparedStatement st = con.prepareStatement(query);
			st.execute();
			PrintWriter out = response.getWriter();
			String query1="SELECT * FROM employee";
			ResultSet rs = st.executeQuery(query1);
			out.println("<table border=1> <tr><th>ID</th><th>Name</th><th>Address</th><th>DOB</th>");
			while(rs.next())
			{
				out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
