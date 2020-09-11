<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--  <link href='https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic' rel='stylesheet'
        type='text/css'> -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">


<link href="viewJob.css" rel="stylesheet">


<title>View Job</title>


</head>

<jsp:include page="header1.jsp" />
<body>
	<div id="postJob">

		<a href="jobs.jsp"><button type="submit" id="post">Post a
				Job</button></a>
	</div>
	<br></br>
<div class="container">
	<div class="row">
	
			
	
	<%
			String url = "jdbc:mysql://localhost/jobs";

			Class.forName("com.mysql.cj.jdbc.Driver");

			try {

				Connection con = DriverManager.getConnection(url, "root",
						"Ranu31@dec");
				System.out.println("CONNECTED");
				Statement st = con.createStatement();
				String qry = "select * from job ";

				ResultSet rs = st.executeQuery(qry);
				System.out.println(rs);
				while (rs.next()) {
					System.out.println(rs.getString("designation") + " "
							+ rs.getString("city"));
		%>




	






	<div class="col-sm-12 col-md-6 col-lg-4 " id="cardspace">

				
					<div class=" card  lighten-2 text-left z-depth-2 " >
						<div class="card-body" >
							<div class="deadline">
								<p class="deadline text-left">
									<span><b>Apply by : </b></span><span class="highlight"><%=rs.getString("last_date")%></span>
								</p>
							</div>

							<p class="title">
								<b>Profile: </b>
								<%=rs.getString("designation")%></p>
							<p class="categories"><b>Skills : </b><%=rs.getString("skill")%>
							</p>


							

							<p class="tag">
								<b>Total Experience : </b>
								<%=rs.getString("total_expirence")%>
							</p>
							<p class="tag">
								<b>Relevant Experience : </b>
								<%=rs.getString("relative_expirence")%>
							</p>


							<div class="bottom">
								<p class="company text-left">
									<span class="highlight"><b>Company : </b> <%=rs.getString("companyname")%>
									</span>, <span> <%
rs.getString("city");
 %> <%
 	rs.getString("state");
 %>
									</span>
								</p>
								


							</div>
							<center>
							<div>
								<a href="apply.jsp"> <input type="submit"
									class="btn btn-md btn-danger" name="apply" value="apply"></a>
							</div>
							</center>
						</div>
						
					</div>
				</div>




				<%
			}
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>

			
		</div>
			<br>
	</div>
<br>



</body>
<jsp:include page="footer.jsp" />
</html>

