<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FORGOT PASSWORD</title>
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
  position: absolute;
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
    <div id="topbarnav">
    <ul class="nav navbar-nav pull-right">
    <li><a href="Login.jsp">Login</a></li>
    <li><a href="Signup.jsp">Sign Up</a></li>
    </ul>
    </div>
      </div>
    </div>
  </nav>
</header>
<body>
<div id="inner-page">
  <div class="jumbotron">
     <div><h2 align="center"><font face="verdana" color="3300CC">FORGOT PASSWORD</font></h2></div>
		<form name="forgot1" id="forgot1" method="post" action="ForgotPassword1" onsubmit="return forgotpass1validate()">
<center>
<div id="detail">
<table class="table">
					<tr>
						<td><label>Email:</label></td>
						<td align="center"><input type="text" name="emaile" id="email"></td>
					</tr>
					<tr>
	                    <td colspan="2" align="center"><input type="submit" name="submit" id="submit" value="NEXT"></td>
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
</html>