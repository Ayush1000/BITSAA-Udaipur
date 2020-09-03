<%@ page session="true" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html> 
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>contact</title>
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
#border
{
    background-color: #80B2FF;
}
body{
font-family:Verdana;
font-size:14px;
}
</style>
<script src="jquery/jquery.min.js"></script>
<script>
$(document).ready(function()
{
	$('#search').keyup(function()
	{
		searchTable($(this).val());
	});
});

function searchTable(inputVal)
{
	var table = $('#tblData');
	table.find('tr').each(function(index, row)
	{
		var allCells = $(row).find('td');
		if(allCells.length > 0)
		{
			var found = false;
			allCells.each(function(index, td)
			{
				var regExp = new RegExp(inputVal, 'i');
				if(regExp.test($(td).text()))
				{
					found = true;
					return false;
				}
			});
			if(found == true)$(row).show();
				else $(row).hide();
		}
	});
}
</script>
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
      <div class="collapse navbar-collapse navbar-right">
	  <div id="topbarnav"> 
        <ul class="nav navbar-nav pull-right">
          
          <li><a href="Home.jsp">Home</a></li>
          <li><a href="readprofile.jsp">Profile</a></li>
          <li><a href="ChangePassword.jsp">Change Password</a></li>
          <li class="active"><a href="contact.jsp">Alumni List</a></li>
		  <li><a href="Login.jsp">Logout</a></li>
        </ul>
	  </div>
	  </div>
    </div>
  </nav>
</header>
  <div><h2 align="center"><font face="Verdana" color="3300CC">ALUMNI LIST</font></h2></div>
		   <div class="container">
            <p>&nbsp;</p><div class="col-lg-6 col-lg-offset-6">
            <input type="search" name="search" id="search" value="" class="form-control" placeholder="Search Contacts">
        </div><table class="table" cellpadding="20" id="tblData">
                <tbody> 
				 <tr id="border">

<td align="center" valign="middle"><u><b>Name</b></u></td>
<td align="center" valign="middle"><u><b>Email</b></u></td>
<td align="center" valign="middle"><u><b>Branch</b></u></td>	
<td align="center" valign="middle"><u><b>Batch</b></u></td>
<td align="center" valign="middle"><u><b>Company Name</b></u></td>	
<td align="center" valign="middle"></td>
</tr>
      
       <% try
            {
            Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            }
        String url ="jdbc:mysql://localhost/alumni"; 
            Connection con = DriverManager.getConnection(
                url, "root", "root");
           String search=request.getParameter("search");
            Statement st= con.createStatement() ;
            String qry="SELECT user.userid,user.firstname,user.lastname,user.email,profile.branch,profile.batch,profile.companyname from user inner join profile on user.userid=profile.userid";
           ResultSet rs= st.executeQuery(qry) ; 
           %>
           
           <%  while(rs.next()){
           
           		int uid = rs.getInt("userid");        	   
        	   
           %>
                <tr><td align="center" valign="middle"><%=rs.getString("firstname") %> &nbsp;
                <%=rs.getString("lastname") %></td>
                <td align="center" valign="middle"><%=rs.getString("email") %></td>
                <td align="center" valign="middle"><%=rs.getString("branch") %></td>
                <td align="center" valign="middle"><%=rs.getString("batch")%></td>
                <td align="center" valign="middle"><%=rs.getString("companyname")%></td>
                <td align="center" valign="middle">
                <form name="view" method="" action="alumniprofile.jsp">
            		<input type="hidden" name="uid" value="<%=uid %>">
                	<input type="submit" name="view" value="VIEW">
                </form>
                </td>
        
            <% } %>
            
                     
               
             
                </tbody>
            </table>
            <hr>
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
