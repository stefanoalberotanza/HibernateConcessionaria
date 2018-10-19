<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="newDocCompr" method="post">
		<p>
			<label>INSERIRE DATI DOCUMENTO DI COMPRATORE <%= request.getParameter("nome") %> <%= request.getParameter("cognome") %><br /> <br /></label>
		</p>
		<label>DOCUMENTO<br></label><td><input type="text" name="documento" /><br />
		<input type='text' name='id' value=<%=request.getParameter("id")%>>
		<input type="submit" value="Aggiungi documento">
	</form>

</body>
</html>