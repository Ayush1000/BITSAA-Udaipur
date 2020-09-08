<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String jobid = request.getParameter("jobid");
session.setAttribute("jobid", jobid);
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply for jobs </title>
</head>
<jsp:include page="header1.jsp" />
<body>
<form action="applyServlet" method="post" enctype="multipart/form-data">
<br><br>
<label>Email:</label>
<input name="email" id="email" >
<h1> Upload the resume </h1>
 <input type="file" id="myfile" name="myfile"><br><br>
<input type="submit" name ="submit" value="submit"> 
</form>

<br><br>

</body>
<jsp:include page="footer.jsp" />
</html>