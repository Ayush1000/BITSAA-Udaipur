 <%@ page session="true"%>
<%@ page import="com.alumni.profileread.model.*, javax.sql.*, java.sql.*" %>
<!DOCTYPE html>
<html> 
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>profile</title>
<meta name="description" content="">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<script src="Js/Edit.js"></script>
<!--  
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
-->
</head>

<%

int userid = Integer.parseInt(session.getAttribute("userid").toString());

ProfileRadDB alumniList = new ProfileRadDB();
ProfileReadBean user = alumniList.viewProfile(userid);

%>


<jsp:include page="header1.jsp" /> 
<body>
<!--  
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
          <li class="active"><a href="readprofile.jsp">Profile</a></li>
          <li><a href="ChangePassword.jsp">Change Password</a></li>
          <li><a href="contact.jsp">Alumni List</a></li>
		  <li><a href="Login.jsp">Logout</a></li>
        </ul>
	  </div>
	  </div>
    </div>
  </nav>
</header>
-->
<div class="container">
<div id="inner-page">

        <div>
			<h2 align="center"><font face="verdana" color="3300CC">PROFILE</font></h2></div>
			<form name="Editprofile" id="Editprofile" method="post" action="Profile" onsubmit="return Editprofilevalidate()">
<center>
<div id="detail">
<table class="table table-striped">
<tr>
<td><label><b>First Name:</b></label></td><td></td>
<td></b></label><input type="text" name="firstname" value="<%=user.getFirstname() %>" id="fname" size="40" ></td>

</tr>
<tr><td><label><b>Last Name:<td></td></td>
<td></b></label><input type="text" name="lastname" value="<%=user.getLastname() %>" id="lname" size="40"></td>
</tr>
<tr>
<td><label><b>School:<td></td></td>
<td></b></Label><input type="text" name="school" id="name1" value="<%=user.getSchool() %>" size="40" required></td>
</tr>
		
<tr>
<td><label><b>College:<td></td></td>
<td></b></Label><input type="text" name="college" id="name2" value="<%=user.getCollege() %>" size="40" required></td>
</tr>
<tr>
<td><label><b>University:<td></td></td>
<td></b></Label><input type="text" name="university" id="name3" value="<%=user.getUniversity() %>" size="40" required></td>
</tr>
<tr>
<td><label><b>Batch:</b></td><td></td>
<td>
<select name="batch">
<option value="2008" <%if(user.getBatch()==2008) { %> selected <%} %>>2008</option>
<option value="2009" <%if(user.getBatch()==2009) { %> selected <%} %>>2009</option >
<option value="2010" <%if(user.getBatch()==2010) { %> selected <%} %>>2010</option >
<option value="2011" <%if(user.getBatch()==2011) { %> selected <%} %>>2011</option >
<option value="2012" <%if(user.getBatch()==2012) { %> selected <%} %>>2012</option >
<option value="2013" <%if(user.getBatch()==2013) { %> selected <%} %>>2013</option >
<option value="2014" <%if(user.getBatch()==2014) { %> selected <%} %>>2014</option >
<option value="2015" <%if(user.getBatch()==2015) { %> selected <%} %>>2015</option >
<option value="2016" <%if(user.getBatch()==2016) { %> selected <%} %>>2016</option >
<option value="2017" <%if(user.getBatch()==2017) { %> selected <%} %>>2017</option >
<option value="2018" <%if(user.getBatch()==2018) { %> selected <%} %>>2018</option >
<option value="2019" <%if(user.getBatch()==2019) { %> selected <%} %>>2019</option >
<option value="2020" <%if(user.getBatch()==2020) { %> selected <%} %>>2020</option >
</select ><td></td></td></tr>
<tr>
<td><label><b>Branch:</b></td><td></td>
<td>
<select name="branch" >
<option value="Computer Science" <%if(user.getBranch().equals("Computer Science")) { %> selected <%} %>>Computer Science</option>
<option value="Electrical" <%if(user.getBranch().equals("Electrical")) { %> selected <%} %>>Electrical</option >
<option value="Mechanical" <%if(user.getBranch().equals("Mechanical")) { %> selected <%} %>>Mechanical</option >
<option value="Electrical and Electronics" <%if(user.getBranch().equals("Electrical and Electronics")) { %> selected <%} %>>Electrical and Electronics</option >
<option value="Civil" <%if(user.getBranch().equals("Civil")) { %> selected <%} %>>Civil</option >
<option value="Electronics and Communication" <%if(user.getBranch().equals("Electronics and Communication")) { %> selected <%} %>>Electronics and Communication</option >
</select ><td></td></td></tr>
<tr>
<td><label><b>Email:</b><td></td></td>
<td></label><input type="text" name="email" id="email" value="<%=user.getEmail() %>" size="40" readonly></td>
</tr>
<tr>
<td><label><b>Phone Number:</b><td></td></td>
<td></label><input type="text" name="phonenumber" id="phonenumber" value="<%=user.getPhonenumber() %>" size="40" runat="server" onkeypress="javascript:return isNumber (event)"></td>
<script>
function isNumber(evt)
{
	var iKeyCode = (evt.which) ? evt.which : evt.keyCode
			if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode > 57))
				return false;
	return true;
	}
</script>	
</tr>
<tr>
<td><label><b>Address:</b><td></td></td>
<td></label><input type="text" name="address" id="address" value="<%=user.getAddress() %>" size="40" required></td>
</tr>
<tr>
<td colspan="4"><label><b><font size="4px"><font>Work Information:</font></b></label></td>
<td></td><td></td>
</tr>
<tr>
<td></td><td><label><b>Company Name:</b></td>
<td></label><input type="text" name="companyname" id="companyname" value="<%=user.getCompanyname() %>" size="40" required></td>
</tr>
<tr>
<td></td><td><label><b>Company Location:</b></td>
<td></label><input type="text" name="companylocation" id="companylocation" value="<%=user.getCompanylocation() %>" size="40" required></td>
</tr>
<tr>
<td></td><td><label><b>Position:</b></td>
<td></label><input type="text" name="position" id="position" value="<%=user.getPosition() %>" size="40"></td>
</tr>
<tr><td><b>About:</b></td>
<td></td>
<td><textarea name="about" id="about" rows="5" cols="40" placeholder="Say something about yourself" required><%=user.getAbout() %></textarea></td>
</tr>
<tr>
<td></td><td></td><td align="right"><input type="submit" name="save" id="save" value="SAVE" size="30" ></td>
</tr>
</table>
</div>
</center>
</form>
     </div>
</div>
   <footer class="footer">
      <div class="container">
        <p><font color="white"><center>Designed By &copy; 2015 A Different View</center></font></p>
      </div>
    </footer>
<script type="text/javascript" src="js/jquery.js"></script> 
<script type="text/javascript" src="js/bootstrap.min.js"></script> 
</body>
<jsp:include page="footer.jsp" /> 
</html>	
