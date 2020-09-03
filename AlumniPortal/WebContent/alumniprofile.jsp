<%@ page session="true"%>
<%@ page import="com.alumni.profileread.model.*, javax.sql.*, java.sql.*" %>
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

int userid = Integer.parseInt(session.getAttribute("userid").toString());

int uid = Integer.parseInt(request.getParameter("uid"));

ProfileRadDB alumniList = new ProfileRadDB();
ProfileReadBean user = alumniList.viewProfile(uid);

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
          
          <li><a href="Home.jsp">Home</a></li>
          <li><a href="readprofile.jsp">Profile</a></li>
          <li><a href="ChangePassword.jsp">Change Password</a></li>
          <li><a href="contact.jsp">Alumni List</a></li>
		  <li><a href="Login.jsp">Logout</a></li>
        </ul>
	  </div>
	  </div>
    </div>
  </nav>
</header>
<div id="inner-page">

        <div>
			<h2 align="center"><font face="verdana" color="3300CC">ALUMNI MEMBER</font></h2></div>
<center>
<div id="detail">
<table class="table table-striped">

<tr>
<td><label><b>Name:</b></label></td><td></td> 
<td></b></label><input type="text" name="firstname" id="fname" value="<%=user.getFirstname() %> <%=user.getLastname() %>" size="40" readonly ></td>
</tr>
<tr>
<td><label><b>School:<td></td></td>
<td></b></Label><input type="text" name="school" id="name1" value="<%=user.getSchool() %>" size="40" readonly></td>
</tr>
		
<tr>
<td><label><b>College:<td></td></td>
<td></b></Label><input type="text" name="college" id="name2" value="<%=user.getCollege() %>" size="40" readonly></td>
</tr>
<tr>
<td><label><b>University:<td></td></td>
<td></b></Label><input type="text" name="university" id="name3" value="<%=user.getUniversity() %>" size="40" readonly></td>
</tr>

<tr>
<td><label><b>Batch:</b></td><td></td>
<td>
<input type="text" name="batch" id="batch" value="<%=user.getBatch() %>" size="40" readonly>

</select ><td></td></td></tr>
<tr>
<td><label><b>Branch:</b></td><td></td>
<td>
<input type="text" name="branch" id="branch" value="<%=user.getBranch() %>" size="40" readonly >

<tr>
<td><label><b>Email:</b><td></td></td>
<td></label><input type="text" name="email" value="<%=user.getEmail() %>" id="email" size="40" readonly></td>
</tr>
<tr>
<td><label><b>Phone Number:</b><td></td></td>
<td></label><input type="text" name="phonenumber" value="<%=user.getPhonenumber() %>" id="phonenumber" size="40" readonly></td>
</tr>
<tr>
<td><label><b>Address:</b><td></td></td>
<td></label><input type="text" name="address" id="address" value="<%=user.getAddress() %>" size="40" readonly></td>
</tr>
<tr>
<td colspan="4"><label><b><u><font size="4px"></font>Work Information:</font></u></b></label></td>
<td></td><td></td>
</tr>
<tr>
<td></td><td><label><b>Company Name:</b></td>
<td></label><input type="text" name="companyname"  value="<%=user.getCompanyname() %>" id="companyname" size="40" readonly></td>
</tr>
<tr>
<td></td><td><label><b>Company Location:</b></td>
<td></label><input type="text" name="companylocation" id="companylocation" value=" <%=user.getCompanylocation() %>" size="40" readonly></td>
</tr>
<tr>
<td></td><td><label><b>Position:</b></td>
<td></label><input type="text" name="position" value="<%=user.getPosition() %>" id="position" size="40" readonly></td>
</tr>
<tr><td><b>About:</b></td>
<td></td>
<td><textarea name="about" id="about" rows="5" cols="40" placeholder="Say something about yourself" readonly><%=user.getAbout() %></textarea></td>
</tr>
<tr>
<td></td>
<td></td>
<td align="right">
		<form name="back" action="contact.jsp">
			<input type="submit" value="BACK">
		</form>
	</td>
<td></td><td></td></td>
</tr>
</table>
</div>
</center>
     
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
