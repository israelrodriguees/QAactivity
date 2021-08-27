<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>

<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> list = (ArrayList<JavaBeans>) request.getAttribute("referrals");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Referral list</title>
<link rel="icon" href="images/form.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Referrals</h1>
	<a href="new_referral.jsp" class="button1">New referral</a>
	<a href="report" class="button2">PDF</a>
	<table id="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Role</th>
				<th>Phone</th>
				<th>Email</th>
				<th>Date birth</th>
				<th>Primary Diagnosis</th>
				<th>Secundary Diagnosis</th>
				<th>Week Hours</th>
				<th>Reason</th>
				<th>Funding body</th>
				<th>D raty</th>
				<th>Accomodation needs</th>
				<th>Date of start</th>
				<th>Options</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int j = 0; j < list.size(); j++) {
			%>
			<tr>
				<td><%=list.get(j).getEnqnumber()%></td>
				<td><%=list.get(j).getFirstname()%></td>
				<td><%=list.get(j).getLastname()%></td>
				<td><%=list.get(j).getWrole()%></td>
				<td><%=list.get(j).getWphone()%></td>
				<td><%=list.get(j).getWemail()%></td>
				<td><%=list.get(j).getWdatebirth()%></td>
				<td><%=list.get(j).getWpdiagnosis()%></td>
				<td><%=list.get(j).getWsdiagnosis()%></td>
				<td><%=list.get(j).getWeekhours()%></td>
				<td><%=list.get(j).getWreasonref()%></td>
				<td><%=list.get(j).getWfunding()%></td>
				<td><%=list.get(j).getWdraty()%></td>
				<td><%=list.get(j).getWacomneeds()%></td>
				<td><%=list.get(j).getWdatestart()%></td>
				<td><a href="select?idcon=<%=list.get(j).getEnqnumber()%>"
					class="button1">Edit</a></td>

				<td><a
					href="delete?idcon=<%=list.get(j).getEnqnumber()%>"
					class="button2">Delete</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

	<script src="scripts/confirm.js"></script>
</body>
</html>