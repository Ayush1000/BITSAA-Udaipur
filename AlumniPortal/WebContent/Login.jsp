<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LOGIN</title>
<meta name="description" content="">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<script src="Js/Login.js"></script>
<style>
/* body{
font-family:Verdana;
font-size:14px;
} */
	/* .footer {
	  position: absolute;
	  bottom: 0;
	  width: 100%;
	  /* Set the fixed height of the footer here */
/* 	  height: 50px;
	  background-color: #222;
	}
	.footer > .container {
	  padding-right: 15px;
	  padding-left: 15px;
	} */
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
} */
</style>
</head>
<jsp:include page="Loginheader.jsp" />  
<body>
<!-- <header id="header">
  <nav class="navbar navbar-inverse" role="banner">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
       <div id="topbar">
<div id="TopSection">
        <h2 id="sitename"><font color="white">ALUMNI PORTAL FOR CUTM</font></h2></div></div>
	</div>
		</div>
		</nav>
		</header> -->
		<%
			String msg = (String)request.getAttribute("msg");
			if(msg!=null)
			{
				out.println("<h4>"+msg+"</h4>");
			}
		%>
<section id="login">
    	<div class="row">
    	    
			<div class="form-wrap">
       
                    <form name="login" action="Login" method="post" id="login" onsubmit="return loginvalidate()">
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="text" name="email" id="email" class="form-control" placeholder="email">
                            
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="password" id="password" class="form-control" placeholder="">
                        </div>
                        <input type="submit" id="btn-login" class="btn btn-custom btn-lg btn-block" value="Login">
                    </form>
                	 <a href="Forgotpass1.jsp" class="forget" >Forgot your password?</a>
                    	<hr>
        	    			<div id="tabs" data-tabs="tabs">
               				<p class="text-center"><a href="Signup.jsp">Create an Account?</a></p>
              				</div>
				</div>
    	</div> 
   </section> 
  
	<!-- <footer class="footer">
      <div class="container">
        <p><font color="white"><center>Designed By &copy; 2015 A Different View</center></font></p>
      </div>
    </footer> -->
<script type="text/javascript" src="Js/jquery.js"></script> 
<script type="text/javascript" src="Js/bootstrap.min.js"></script> 

</body>
 <jsp:include page="footer.jsp" />  
</html>