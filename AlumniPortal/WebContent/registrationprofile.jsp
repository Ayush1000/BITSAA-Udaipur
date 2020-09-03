<%@ page session="true"%>
<%@ page import="com.alumni.registration.model.*, javax.sql.*, java.sql.*" %>
<!DOCTYPE html>
<html> 
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>profile</title>
<meta name="description" content="">
<link href="css/bootstrap.min.css" rel="stylesheet">

<style>
#inner-page {
margin:0px;
}
#detail {
margin-left:300px;
margin-right:200px;
}
.footer {
  position: relative;
  bottom: 0;
  width: 100%;
  /* Set the fixed height of the footer here */
  height: 50px;
  background-color: #222;
}
.footer > .container {
  padding-right: 15px;
  padding-left: 15px;
}
body{
font-family:Verdana;
font-size:14px;
}
</style>
</head>

<%

int userid = Integer.parseInt(request.getParameter("userid").toString());
/*int userid1 = Integer.parseInt(session.getAttribute("userid").toString());*/
session.setAttribute("userid", userid);
RegistrationProfileDB register = new RegistrationProfileDB();
RegistrationProfileBean user = register.insertProfile(userid);

%>



<body>
<header id="header">
  <nav class="navbar navbar-inverse" role="banner">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
        <div id="topbar">
<h2 id="sitename"><font color="white">ALUMNI PORTAL FOR CUTM</font></h2>
</div>
</div>
      <div class="collapse navbar-collapse navbar-right">
	  <div id="topbarnav"> 
        <ul class="nav navbar-nav pull-right">
        </ul>
	  </div>
	  </div>
    </div>
  </nav>
</header>
<div id="inner-page">

        <div>
			<h2 align="center"><font face="verdana" color="3300CC">EDIT PROFILE</font></h2></div>
			<form name="Editprofile" id="Editprofile" method="post" action="RegistrationProfile"  enctype="multipart/form-data">
<center>
<div id="detail">
<table class="table table-striped">
<tr>
<td><label><b>Name:<td></td></td>
<td></b></Label><input type="text" name="name" id="name" value="<%=user.getFirstname() %> <%=user.getLastname() %>" size="40" readonly></td>
<input type="hidden" name="userid" value="<%=userid%>">
</tr>
<tr>
<td><label><b>School:<td></td></td>
<td></b></Label><input type="text" name="school" id="name1"  size="40" required ></td>
</tr>
		
<tr>
<td><label><b>College:<td></td></td>
<td></b></Label><input type="text" name="college" id="name2"  size="40" required></td>
</tr>
<tr>
<td><label><b>University:</b></Label></td><td></td>
<td><input type="text" name="university" id="name3" size="40" required></td>
</tr>

<tr>
<td><label><b>Batch:</b></label></td><td></td>
<td>
<select name="batch" >
<option value="2008">2008</option>
<option value="2009">2009</option >
<option value="2010">2010</option >
<option value="2011">2011</option >
<option value="2012">2012</option >
<option value="2013">2013</option >
<option value="2014">2014</option >
<option value="2015">2015</option >
<option value="2016">2016</option >
<option value="2017">2017</option >
<option value="2018">2018</option >
<option value="2019">2019</option >
<option value="2020">2020</option >
</select ><td></td></tr>
<tr>
<td><label><b>Branch:</b></label></td><td></td>
<td>
<select name="branch" >
<option value="Computer Science">Computer Science</option>
<option value="Electrical ">Electrical</option >
<option value="Mechanical">Mechanical</option >
<option value="Electrical and Electronics">Electrical and Electronics</option >
<option value="Civil">Civil</option >
<option value="Electronics and Communication">Electronics and Communication</option >
</select ><td></td></td></tr>
<tr>
<td><label><b>Address:</b><td></td></td>
<td></label><input type="text" name="address" id="address" size="40" required></td>
</tr>
<tr>
<td colspan="4"><label><b><u><font size="4px"></font>Work Information:</font></u></b></label></td>
<td></td><td></td>
</tr>
<tr>
<td></td><td><label><b>Company Name:</b></td>
<td></label><input type="text" name="companyname" id="companyname" size="40" required ></td>
</tr>
<tr>
<td></td><td><label><b>Company Location:</b></td>
<td></label><input type="text" name="companylocation" id="companylocation" size="40" required></td>
</tr>
<tr>
<td></td><td><label><b>Position:</b></td>
<td></label><input type="text" name="position" id="position" size="40" required></td>
</tr>
<tr>
<td></td><td><label><b>Profile Photo:</b></td>
<td></label><input type="file" name="profilephoto" id="profilephoto" size="40" required></td>
</tr>

<tr><td><b>About:</b></td>
<td></td>
<td><textarea name="about" id="about" rows="5" cols="40" placeholder="Say something about yourself" required></textarea></td>
</tr>
<tr>
<td></td><td></td><td align="right"><input type="submit" name="save" id="save" value="SAVE" size="30" ></td>
</tr>
</table>
</div>
</center>
</form>
     
</div>
   <footer class="footer">
      <div class="container">
        <p><font color="white"><center>Designed By &copy; 2015 A Different View</center></font></p>
      </div>
    </footer>
<script type="text/javascript" src="js/jquery.js"></script> 
<script type="text/javascript" src="js/bootstrap.min.js"></script> 
</body>
</html>	
