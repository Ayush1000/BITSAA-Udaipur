<%@page session="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>project</title>
<meta name="description" content="">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

<!-- <link href="css/bootstrap.min.css" rel="stylesheet">
 -->
<style>
#img{
height:50%;
width:100%;
}

</style>

</head>
<jsp:include page="header1.jsp" /> 
<body>

<!--  
<header id="header">
  <nav class="navbar navbar-inverse" role="banner">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
       <div id="topbar">
<h2 id="sitename"><font color="white">ALUMNI PORTAL FOR CUTM</font></h2></div></div>
      <div class="collapse navbar-collapse navbar-right">
	  <div id="topbarnav"> 
        <ul class="nav navbar-nav pull-right">
          
          <li class="active"><a href="Home.jsp">Home</a></li>
          <li><a href="ProfileRead">Profile</a></li>
          <li><a href="ChangePassword.jsp">Change Password</a></li>
          <li><a href="contact.jsp">Alumni List</a></li>
           <li><a href="jobs.html">Jobs</a></li>
          <li><a href="Login.jsp">Logout</a>
        </ul>
      </div>
    </div>
    </div>
  </nav>
</header>
-->
 
<div id="main-slide">
    <div class="item"> <img class="img-responsive" src="images/slider/alumni.jpg" id="img">
      <div class="slider-content">
      </div>
    </div>
  </div>

  <!--  
<footer class="footer">
      <div class="container">
        <p><font color="white"><center>Designed By &copy; 2015 A Different View</center></font></p>
      </div>
    </footer>
    -->
<script type="text/javascript" src="js/jquery.js"></script> 
<script type="text/javascript" src="js/bootstrap.min.js"></script> 

</body>
  <jsp:include page="footer.jsp" />
 
</html>