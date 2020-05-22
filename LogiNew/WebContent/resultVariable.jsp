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
	<h1>Code Complexity Of Variables</h1>
	<table id="customers">
	<tr>
	<thead>
		<th>Line no</th>
		<th>Program statements</th>
		<th>Wvs</th>
		<th>Npdtv</th>
		<th>Ncdtv</th>
		<th>Cv</th>
	</tr>
	</thead>
	<tbody>
		<%
			Variable test1 = new Variable();
				ArrayList<Variables_model> arrayList1 = test1.variable(session.getAttribute("test_code").toString());
				
				for (Variables_model variables : arrayList1) {
			
			int Wvs =(variables.getGlobal()*Integer.parseInt(session.getAttribute("variableGlobal").toString()))+(variables.getLocal())*Integer.parseInt(session.getAttribute("variableLocal").toString());
		            
		            int Npdtv = variables.getGlobal()+variables.getLocal();
		            
		            int Cv = Wvs*((Npdtv*Integer.parseInt(session.getAttribute("variablePrimitive").toString()))+(variables.getComposite()*Integer.parseInt(session.getAttribute("variableComposite").toString())));
		%>
			<tr>
				<td><%=variables.getLineNumber() %></td>
				<td><%=variables.getLine() %></td>
				<td><%=Wvs %></td>
				<td><%=Npdtv %></td>
				<td><%=variables.getComposite() %></td>
				<td><%=Cv %></td>
			</tr>
			<% 
		}	
	%>
	</tbody>
	</table>
	</center>
</body>
</html>