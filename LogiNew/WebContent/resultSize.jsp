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
	<h1>Code Complexity Of Size</h1>
	<table id="customers">
	<tr>
	<thead>
		<th>Line No</th>
		<th>Program Statements</th>
		<th>Nkw</th>
		<th>Nid</th>
		<th>Nop</th>
		<th>Nnv</th>
		<th>Nsl</th>
		<th>Cs</th>
	</tr>
	</thead>
	<tbody>
    
    <%
        	Size test = new Size();
        		ArrayList<Sizes_model> arrayList = test.size(session.getAttribute("test_code").toString());
        		
        		for (Sizes_model sizes : arrayList) {
        	
        	int Nkw = sizes.getKeyword()*Integer.parseInt(session.getAttribute("sizeKeyword").toString());
        	int Nid = sizes.getIdentifier()*Integer.parseInt(session.getAttribute("sizeIdentifier").toString());
        	int Nop = sizes.getOperator()*Integer.parseInt(session.getAttribute("sizeOperator").toString());
        	int Nnv = sizes.getNumerical()*Integer.parseInt(session.getAttribute("sizeNumerical").toString());
        	int Nsl = sizes.getStringCount()*Integer.parseInt(session.getAttribute("sizeString").toString());
        	int total =Nkw+Nid+Nop+Nnv+Nsl;
        %>
			<tr>
				<td scope="row"><%=sizes.getLineNumber() %></td>
				<td><%=sizes.getLine() %></td>
				<td><%=sizes.getKeyword() %></td>
				<td><%=sizes.getIdentifier() %></td>
				<td><%=sizes.getOperator() %></td>
				<td><%=sizes.getNumerical() %></td>
				<td><%=sizes.getStringCount() %></td>
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