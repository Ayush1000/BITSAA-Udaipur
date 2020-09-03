<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>log in</title>
<meta name="description" content="">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="Js/Signup.js"></script>
<style>
body{
font-family:Verdana;
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
#login {
    padding-top: 50px
}
#login .form-group {
    margin-bottom: 25px;
}
#login .forget {
    font-size: 13px;
	text-align: center;
	display: block;
}
.form-control {
    color: #212121;
}
#login .form-wrap {
    width: 30%;
    margin: 0 auto;
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
    </ul>
    </div>
      </div>
    </div>
  </nav>
</header>
<section id="login">
    	<div class="row">
		<div class="form-wrap">
      
                         <form class="form" name="registration" method="post" action="Signup" onsubmit="return signupvalidate()">
						 <p><font face="verdana" size="6" color="blue">SIGN UP</font></p>
						 
						 <%
						 
						 String msg = null;
						 msg = (String)request.getAttribute("msg");
						 
						 if(msg != null)
							out.println(msg);						 
						 %>
						 
						 
	  <div class="form-group">
	  <label class="sr-only">First Name</label>
		<input type="name" name="firstname" class="form-control" id="firstname" placeholder="First Name">									
	  </div>
	  <div class="form-group">
	  <label class="sr-only">Last Name</label>
		<input type="name" name="lastname" class="form-control" id="lastname" placeholder="Last Name">									
	  </div>
      <div class="form-group">
	  <label class="sr-only">Type Your Email</label>
		<input type="email" name="email" class="form-control" id="email" placeholder="Type Your Email">									
	  </div>
	  <div class="form-group">
	  <label class="sr-only">Enter Your Contact-no</label>
		<input type="text" name="phonenumber" class="form-control" id="phonenumber" placeholder="Enter Your Contact-no" runat="server" onkeypress="javascript:return isNumber (event)">
<script>
function isNumber(evt)
{
var iKeyCode = (evt.which) ? evt.which : evt.keyCode
			if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode > 57))
				return false;
	return true;
	}
</script>								
	  </div>
	  <div class="form-group">
	  <label class="sr-only">Type Your Password</label>
		<input type="password" name="password" class="form-control" id="password" placeholder="Type Your Password">									
	  </div>
	  <b>Gender:</b>
			<b>Male</b><input name="gender" type="radio" style="width: 60px;height: 20px;" value="Male" checked="checked">
		  <b>Female</b><input name="gender" type="radio" style="width: 60px;height: 20px;" value="Female">
									
										<div class="form-group">
											 <button type="submit" class="btn btn-primary btn-block" >Sign Up</button>
										</div>
								
								 </form>
								 </div>
                   
				</div>
  
   </section> 
	<footer class="footer">
      <div class="container">
        <p><font color="white"><center>Designed By &copy; 2015 A Different View</center></font></p>
      </div>
    </footer>
<script type="text/javascript" src="js/jquery.js"></script> 
<script type="text/javascript" src="js/bootstrap.min.js"></script> 

</body>
</html>