<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Concessionaria</title>
</head>
<body>
<h1 style="text-align:center">CONCESSIONARIA</h1>
<div style="display:block;text-align:center">
<h1>Automobili</h1>
<form action="getAuto" method="get">
<input type="text" name="targa"/>
<input type="submit" value="visualizza auto"/>
</form>
<form action="newAuto.jsp" method="get">
<input type="submit" value="aggiungi auto"/>
</form>
</div>
<div style="display:block;text-align:center">
<h1>Documenti auto</h1>
<form action="getDocAuto" method="get">
<input type="text" name="id"/>
<input type="submit" value="visualizza documento"/>
</form>
<form action="newDoc.jsp" method="get">
<input type="submit" value="aggiungi documento"/>
</form>
</div>
</body>
</html>