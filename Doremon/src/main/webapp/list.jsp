<%@page import="com.entities.Location"%>
<%@page import="com.entities.DroneShot"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="all_css_js.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Bookings</title>
</head>
<body>
	<div class="container-fluid">
		<%@ include file="navbar.jsp" %>
		<br>
		<h3 class="text-center">List Of Drone Shots</h3>
		<hr>
		<div class="row">
			<div class="col-12">
				<%
				Session s = FactoryProvider.getFactory().openSession();
				Query q = s.createQuery("from DroneShot");
				List<DroneShot> list = q.list();
				s.close();
				%>
				<div class="container">
					<br>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Sl.No</th>
								<th>Shots Name</th>
							</tr>
						</thead>
						<tbody>
							<% for (DroneShot shot : list) { %>
								<tr>
									<td><%=shot.getId() %></td>
									<td><%=shot.getName()%></td>
								</tr>
							<% } %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	
	<div class="container-fluid">
	
	<h3 class="text-center">List Of Location</h3>
		<hr>
		<div class="row">
			<div class="col-12">
				<%
				Session s1 = FactoryProvider.getFactory().openSession();
				Query q1 = s1.createQuery("from Location");
				List<Location> list1 = q1.list();
				s.close();
				%>
				<div class="container">
					<br>
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Sl.No</th>
								<th>Location Name</th>
							</tr>
						</thead>
						<tbody>
							<% for (Location shot : list1) { %>
								<tr>
									<td><%=shot.getId() %></td>
									<td><%=shot.getName()%></td>
								</tr>
							<% } %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	
	
</body>
</html>
