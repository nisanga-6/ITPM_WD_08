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
	<h1>Code Complexity Of Methods</h1>
	<table id="customers">
	<tr>
	<thead>
		<th>Line no</th>
		<th>Program statements</th>
		<th>Wmrt</th>
		<th>Npdtp</th>
		<th>Ncdtp</th>
		<th>Cm</th>
	</tr>
	</thead>
	<tbody>
	
	<%
			Method test2 = new Method();
				ArrayList<Methods_model> arrayList2 = test2.method(session.getAttribute("test_code").toString());
				
				for (Methods_model methods : arrayList2) {
			
			int Wmrt =(methods.getComposite_method()*Integer.parseInt(session.getAttribute("methodComposite").toString()))+(methods.getPrimitive_method()*Integer.parseInt(session.getAttribute("methodPrimitive").toString()));
				          
		          	int Cm = Wmrt+((methods.getPrimitive_parameters()*Integer.parseInt(session.getAttribute("methodPrimitiveData").toString()))+(methods.getComposite_parameters()*Integer.parseInt(session.getAttribute("methodCompositeData").toString())));
		%>
		<tr>
			<td><%=methods.getLineNumber() %></td>
			<td><%=methods.getLine() %></td>
			<td><%=Wmrt %></td>
			<td><%=methods.getPrimitive_parameters() %></td>
			<td><%=methods.getComposite_parameters() %></td>
			<td><%=Cm %></td>
		</tr>
		<% 
		}	
		%>
	
	</tbody>
	</table>
	</center>
</body>
</html>