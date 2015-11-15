<!DOCTYPE html>
<%@page import="tn.esprit.gl1.mini_shop.persistence.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>NAME</th>
			<th>COST</th>
		</tr>
		<%
			List<Product> prods = (List<Product>) request.getAttribute("prods");
			for (Product p : prods) {
		%>
		<tr>
			<td><%=p.getName()%></td>
			<td><%=p.getUnitCost()%></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>