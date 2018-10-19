<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="newCompr" method="post">
		<p>
			<label>INSERIRE DATI COMPRATORE<br /> <br /></label>
		</p>

		<label>NOME<br></label><input type="text" name="nome" /><br />
		<label>COGNOME<br></label><input type="text" name="cognome" /><br />
		<label>DATA DI NASCITA<br></label><input type="number" name="data" /><br />
		<input type="submit" value="Aggiungi compratore">
	</form>
</body>
</html>