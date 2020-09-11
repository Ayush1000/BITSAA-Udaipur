<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Blog 
</title>
</head>
<body>
<br>
	<br>
	<a href="createBlog.jsp"><button >Post a Blog </button></a>
	<%
		String url = "jdbc:mysql://localhost/jobs";

		Class.forName("com.mysql.cj.jdbc.Driver");

		try {

			Connection con = DriverManager.getConnection(url, "root",
					"Ranu31@dec");
			System.out.println("CONNECTED");
			Statement st = con.createStatement();
			String qry = "select * from blog";

			ResultSet rs = st.executeQuery(qry);
			System.out.println(rs);
			while (rs.next()) {
				String blog_id = rs.getString("blog_id");
			
				
			%>
			<span>posted by <%=rs.getString("blog_author")%> on <%=rs.getString("blog_date") %></span>
			
			<br><br>
			<h1 style="text-align:centre"><%=rs.getString("blog_title")%></h1>
			<br><br>
			<p>
			
			<img alt="#" src="<%=rs.getString("image_path")%>"><br><br>
			<%=rs.getString("blog_content")%>
			</p>
			<a href="UpdateBlog.jsp?blog_id=<%=blog_id %>"><button>Update</button></a>
			<br><br>
<%
		}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>




</body>
</html>