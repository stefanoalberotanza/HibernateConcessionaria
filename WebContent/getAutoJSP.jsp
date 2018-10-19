<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@page import="org.hibernate.*,hibernate.model.Auto, java.io.PrintWriter" %>

<body>
	<%
		SessionFactory sessionFactory = (SessionFactory) request.getServletContext().getAttribute("SessionFactory");
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();
		Auto auto = (Auto)s.get(Auto.class,request.getParameter("targa"));
		tx.commit();
		PrintWriter o = response.getWriter();
        response.setContentType("text/html");
        o.print("<h1>"+ auto.getYear() +"</h1>");
        o.print("<h1>"+ auto.getMarca() + "</h1>");
	%>

</body>
</html>