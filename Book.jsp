<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Book.jsp" method="get">
	<h2>
	New Book Registration Form<br>
	Enter ID:<input type="number" name="id"><br>
	Enter Title:<input type="text" name="title"><br>
	Enter Author:<input type="text" name="auth"><br>
	Enter Publication:<input type="text" name="pubs"><br>
	Enter Price:<input type="number" name="price"><br>
	<input type="submit" name="1">
	</h2>
</form>
<%@ page import="java.sql.*" %>
<%
if(request.getParameter("1")!=null)
{
	String jdbcurl="jdbc:mysql://localhost:3306/test";
	String username="root";
	String password="";
	Connection con =null;
	con = DriverManager.getConnection(jdbcurl,username,password);
	
	int id = Integer.parseInt(request.getParameter("id"));
	String title = request.getParameter("title");
	String auth = request.getParameter("auth");
	String pubs = request.getParameter("pubs");
	int price = Integer.parseInt(request.getParameter("price"));
	
	String query="INSERT INTO books VALUES('"+id+"','"+title+"','"+auth+"','"+pubs+"','"+price+"')";
	PreparedStatement st = con.prepareStatement(query);
	st.execute();
	
	String query1="SELECT * FROM books";
	ResultSet rs = st.executeQuery(query1);
	out.println("<h2>Book Registered!<h2>");
	out.println("<h1>****Books in Database****</h1>");
	while(rs.next())
	{
		out.println("<h2>*******************</h2>");
		out.println("<br>ID:"+rs.getInt(1)+"<br>Title:"+rs.getString(2)+"<br>Author:"+rs.getString(3)+"<br>Publication"+rs.getString(4)+"<br>Price"+rs.getInt(5));
	}
}




%>
</body>
</html>