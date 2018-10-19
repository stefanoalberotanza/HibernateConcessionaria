<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*, hibernate.model.docCompr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<docCompr> docComprList = (List<docCompr>) request.getAttribute("docList"); %>
<table border=\"1\" cellspacing=10 cellpadding=5 style='text-align:center;margin: auto;'>
		<caption><h4>Documenti nel DB</h4></caption>
		<thead>
			<tr>
				<th>Cognome</th>
				<th>Nome</th>
				<th>Documento</th>
			</tr>
		</thead>
		<tbody>
	<% for (docCompr c : docComprList) { %>
		<tr>
				<td><%= c.getCompratore().getNome() %></td>
				<td><%= c.getCompratore().getCognome() %></td>
				<td><%= c.getDocumento() %>
				<td><form action='deleteDocCompr' method='post'>
					<input type='hidden' name='id' value=<%=c.getId()%>>		
				<input type="submit" value="Elimina documento">
				</form>
		</tr>
	<% } %>
</body>
</html>