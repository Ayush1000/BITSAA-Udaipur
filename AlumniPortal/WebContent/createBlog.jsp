<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action ="CreateBlogServlet" method="post" enctype="multipart/form-data">>
<h1><label>Post a Blog</label></h1>
<label>Author</label>
<input type="text" name ="author"><br><br>
<label>Title</label>
<input type="text" name ="title"><br><br>
<label>Content </label>
<textarea rows="10" cols="100" name="content" >
Enter text here...</textarea><br><br>

<label>upload the image </label>
<input type="file" name="myfile" id="myfile"><br><br>
<input type="submit" name ="submit" value ="submit">
</form>

</body>
</html>