<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="bookret.jsp" method="get">
	<h2>
	Book Retrieval System<br>
	Enter Title:<input type="text" name="title">
	<input type="submit" name="submit">
	</h2>
</form>
<%@ page import = "java.sql.*" %>
<% 
if(request.getParameter("submit") != null)
{
	String jdbcurl="jdbc:mysql://localhost:3306/test";
	String username="root";
	String password="";
	Connection con =null;
	try
	{
		con = DriverManager.getConnection(jdbcurl,username,password);
		String title = request.getParameter("title");
		String query="SELECT * FROM books WHERE TITLE='"+title+"'";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		out.println("<h2>****FOUND****</h2>");
		while(rs.next())
		{
			out.println("<br>ID:"+rs.getInt(1)+"<br>Title:"+rs.getString(2)+"<br>Author:"+rs.getString(3)+"<br>Publication"+rs.getString(4)+"<br>Price"+rs.getInt(5));
		}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
}

%>

</body>
</html>