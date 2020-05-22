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
	<h1>Code Complexity Of Couplings</h1>
	<table id="customers">
	<tr>
	<thead>
		<th>Line no</th>
		<th>Program statements</th>
		<th>Nr</th>
		<th>Nmcms</th>
		<th>Nmcmd</th>
		<th>Nmcrms</th>
		<th>Nmcrmd</th>
		<th>Nrmcrms</th>
		<th>Nrmcrmd</th>
		<th>Nrmcms</th>
		<th>Nrmcmd</th>
		<th>Nmrgvs</th>
		<th>Nmrgvd</th>
		<th>Nrmrgvs</th>
		<th>Nrmrgvd</th>
		<th>Ccp</th>
	</tr>
	</thead>
	<tbody>
		<%
			Coupling test5 = new Coupling();
			ArrayList<Couplings_model> arrayList5 = test5.coupling(session.getAttribute("test_code").toString());
			
			for (Couplings_model coupling : arrayList5) {
				
				int Nr=coupling.getRecursive()*Integer.parseInt(session.getAttribute("recursive").toString());
				
				int Nmcms=coupling.getRegular_regular()*Integer.parseInt(session.getAttribute("regularRegular").toString());
				
				int Nmcrms=coupling.getRegular_recursive()*Integer.parseInt(session.getAttribute("regularRecursive").toString());
				
				int Nrmcrms=coupling.getRecursive_recursive()*Integer.parseInt(session.getAttribute("recursiveRecursive").toString());
				
				int Nrmcms=coupling.getRecursive_regular()*Integer.parseInt(session.getAttribute("recursiveRegular").toString());
				
				int total =Nr+Nmcms+Nmcrms+Nrmcrms+Nrmcms+(coupling.getRegular_global()*Integer.parseInt(session.getAttribute("regularGlobal").toString()))+(coupling.getRegular_regular()*Integer.parseInt(session.getAttribute("recursiveGlobal").toString()));
		%>
				<tr>
					<td><%=coupling.getLineNumber() %></td>
					<td><%=coupling.getLine() %></td>
					<td><%=coupling.getRecursive() %></td>
					<td><%=coupling.getRegular_regular() %></td>
					<td>0</td>
					<td><%=coupling.getRegular_recursive() %></td>
					<td>0</td>
					<td><%=coupling.getRecursive_recursive() %></td>
					<td>0</td>
					<td><%=coupling.getRecursive_regular() %></td>
					<td>0</td>
					<td><%=coupling.getRegular_global() %></td>
					<td>0</td>
					<td><%=coupling.getRegular_regular() %></td>
					<td>0</td>
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