<%@page import="itpm_service.*"%>
<%@page import="itpm_model.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Control Result</title>
<style>
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 75%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #5c8ffb;
  
}
</style>

</head>
<body>
	<center>
	<h1>Code Complexity Of Control</h1>
	<table id="customers">
	<tr>
	<thead>
		<th>Line no</th>
		<th>Program statements</th>
		<th>Wtcs</th>
		<th>NC</th>
		<th>Ccspps</th>
		<th>Ccs</th>
	</tr>
	</thead>
	<tbody>
		<%
			Control test3 = new Control();
				int condition= Integer.parseInt(session.getAttribute("condition").toString());
				int loop = Integer.parseInt(session.getAttribute("loop").toString());
				int switchCase= Integer.parseInt(session.getAttribute("switchCase").toString());
				int caseOnly=Integer.parseInt(session.getAttribute("caseOnly").toString());
			ArrayList<Control_model> arrayList3 = test3.control(session.getAttribute("test_code").toString(),condition,loop,switchCase,caseOnly);
			
			for (Control_model control : arrayList3) {
				int total = (control.getLine_weight()*control.getNo_of_control())+control.getCspps();
		%>
		<tr>
			<td><%=control.getLineNumber() %></td>
			<td><%=control.getLine() %></td>
			<td><%=control.getLine_weight() %></td>
			<td><%=control.getNo_of_control() %></td>
			<td><%=control.getCspps() %></td>
			<td><%=total %></td>
		</tr>
		<% 
	}	
%>
	</tbody>
	</table>
	</center>
</body>
</html>