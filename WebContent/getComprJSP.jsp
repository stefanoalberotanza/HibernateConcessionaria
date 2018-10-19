<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, hibernate.model.Compratore"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Compratori</title>
</head>
<body>
<% List<Compratore> compratori = (List<Compratore>) request.getAttribute("comprList"); %>
<table border=\"1\" cellspacing=10 cellpadding=5 style='text-align:center;margin: auto;'>
		<caption><h4>Clienti nel DB</h4></caption>
		<thead>
			<tr>
				<th>Cognome</th>
				<th>Nome</th>
				<th>Città</th>
				<th>Aggiungi documenti</th>
				<th>Visualizza documenti</th>
			</tr>
		</thead>
		<tbody>
	<% for (Compratore c : compratori) { %>
		<tr>
				<td><%= c.getCognome() %></td>
				<td><%= c.getNome() %></td>
				<td><%= c.getData() %></td>
				<td><form action='newDocCompr.jsp' method='post'>
					<input type='hidden' name='nome' value=<%=c.getNome()%>>
					<input type='hidden' name='cognome' value=<%=c.getCognome()%>>
					<input type='hidden' name='id' value=<%=c.getId()%>>		
				<input type="submit" value="Aggiungi documento">
				</form>
				</td>
				<td><form action='getDocCompr' method='post'>
					<input type='hidden' name='id' value=<%=c.getId()%>>		
				<input type="submit" value="Visualizza documenti">
				</form>
				</td>
		</tr>
	<% } %>
</body>
</html>