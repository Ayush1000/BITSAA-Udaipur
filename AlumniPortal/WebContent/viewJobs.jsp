<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%><%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href='https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic'
	rel='stylesheet' type='text/css'>





<link rel="stylesheet" type="text/css"
	href="https://static.almabaseapp.com/css/foundation.2b833b7b678a.css" />
<link rel="stylesheet" type="text/css"
	href="https://static.almabaseapp.com/css/normalize.7caceed67722.css" />
<link rel="stylesheet" type="text/css"
	href="https://static.almabaseapp.com/css/index.8902e9d1857c.css" />





<link rel="stylesheet" type="text/css"
	href="https://static.almabaseapp.com/css/tools.5b65da64994d.css" />


<link rel="stylesheet" type="text/css"
	href="https://static.almabaseapp.com/css/themes/second/base.cbb6ef235786.css" />
<link rel="stylesheet" type="text/css" href="viewJob.css" />


<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<title>View Job</title>
</head>
<body>

	<br>
	<br>
	<a href="jobs.jsp"><button>Post a job</button></a>
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
				String jobid = rs.getString("jobID");
				System.out.println("job id : "+jobid);
	%>



<%-- 	<form name="viewjobs" action="apply.jsp?jobid=<%= jobid%>"> --%>

		<div id="job_cards_container">
			<div class="row">

				<div class="column small-12 medium-6 large-4 ">
					<div class="job_card">
						<div class="deadline">
							<p class="deadline text-right">
								<span>Apply by </span><span class="highlight"><%=rs.getString("last_date")%></span>
							</p>
						</div>

						<p class="title">
							Profile
							<%=rs.getString("designation")%></p>
						<p class="categories">Technology</p>


						<p class="tag">Pay not specified</p>

						<p class="tag">
							Experience
							<%=rs.getString("total_expirence")%>
						</p>


						<div class="bottom">
							<p class="company text-right">
								<span class="highlight">Company: <%=rs.getString("companyname")%>
								</span>, <span> <%
 	rs.getString("city");
 %> <%
 	rs.getString("state");
 %>
								</span>
							</p>
							<br />
							<br />


						</div>
						<div>
							<a href="apply.jsp?jobid=<%= jobid %>"><input type="submit" class="button"></a>
						</div>

					</div>

				</div>
				
<!-- 	</form> -->

	<%
		}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>

	</div>
	</div>



</body>
</html>