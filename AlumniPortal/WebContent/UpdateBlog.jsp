<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update a Blog</title>
<%
int  blog_id = Integer.parseInt(request.getParameter("blog_id"));
System.out.println(blog_id);
session.setAttribute("blog_id", blog_id);
%>
</head>
<body>
<%
		String url = "jdbc:mysql://localhost/jobs";

		Class.forName("com.mysql.cj.jdbc.Driver");

		try {

			Connection con = DriverManager.getConnection(url, "root",
					"Ranu31@dec");
			System.out.println("CONNECTED");
			Statement st = con.createStatement();
			String qry = "select * from blog where blog_id = "+blog_id;
			/* PreparedStatement pst=con.prepareStatement(qry);
			pst.setInt(1,blog_id);
			 */

			ResultSet rs = st.executeQuery(qry);
			System.out.println(rs);
			while (rs.next()) {
				// String blog_id = rs.getString("blog_id");
			
				
			%>
			
			
			<form action ="UpdateBlogServlet?blog_id=<%=blog_id %>" method="post">
				<br><br>
			<label>date:</label>
			<input  type="text"  name ="date" id="date" value="<%=rs.getString("blog_date") %>">
				<br><br>
			<label>Author:</label>
			<input  type="text"  name ="author" id="author" value="<%=rs.getString("blog_author") %>">
				<br><br>
			<label>title:</label>
			<input  type="text"  name ="title" id="title" value="<%=rs.getString("blog_title") %>">
			<br><br>
			<label>Content:</label>
			<input type="text" name ="content" id="content" value="<%=rs.getString("blog_Content") %>">
				<br><br>
				<input type="submit" name ="submit" value="submit">
			
			</form>
			<%
		}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>

</body>
</html>