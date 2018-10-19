package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.model.Auto;

@WebServlet("/getAuto")
public class getAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getAuto() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Get Session Factory
		SessionFactory sessionFactory = (SessionFactory) request.getServletContext().getAttribute("SessionFactory");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        try{
        	out.print("<head><link rel='stylesheet' type='text/css' href='style.css'></head>");
        	if(request.getParameter("targa") == ""){
        		List<Auto> autoList  = session.createCriteria(Auto.class).list();
        		Iterator it = autoList.iterator();
            	out.print("<body>");
            	out.print("<div style='text-align:center'>");
            	out.print("<table border=\"1\" cellspacing=10 cellpadding=5 style='text-align:center;margin: auto;'>");
        		out.print("<th>Targa</th>");
                out.print("<th>Marca</th>");
                out.print("<th>Anno</th>");
                out.print("<th>Chilometri</th>");
        		out.println("<th>Rimuovi</th>");
        		out.println("<th>Documenti</th>");
                while(it.hasNext()){
        			Auto auto = (Auto) it.next();
        			out.print("<tr>");
        			out.print("<td>"+ auto.getTarga() +"</td>");
        	        out.print("<td>"+ auto.getMarca() + "</td>");
        	        out.print("<td>"+ auto.getYear() + "</td>");
        	        out.print("<td>"+ auto.getChilometri() + "</td>");
        	        out.print("<td><form action='deleteAuto' method='post'>"+
        	        		"<input type='submit' value='Rimuovi auto'/>"+
        	        		"<input type='hidden' name='targa' value='"+auto.getTarga()+"' />" +
        	        		"</form></td>");
        	        out.print("<td><form action='getDocAuto' method='post'>"+
        	        		"<input type='submit' value='Documenti auto'/>"+
        	        		"<input type='hidden' name='id' value='"+auto.getTarga()+"' />" +
        	        		"</form></td>");
        	        out.print("</tr>");
        		}        		
        	}else{
            	out.print("<body>");
            	out.print("<div style='text-align:center'>");
            	out.print("<table border=\"1\" cellspacing=10 cellpadding=5 style='text-align:center;margin: auto;'>");
        		out.print("<th>Targa</th>");
                out.print("<th>Marca</th>");
                out.print("<th>Anno</th>");
                out.print("<th>Chilometri</th>");
        		out.println("<th>Rimuovi</th>");
                out.print("<th>Documenti</th>");
        		Auto auto = (Auto)session.get(Auto.class,request.getParameter("targa"));
        		tx.commit();
                out.print("<tr>");
    			out.print("<td>"+ auto.getTarga() +"</td>");
    	        out.print("<td>"+ auto.getMarca() + "</td>");
    	        out.print("<td>"+ auto.getYear() + "</td>");
    	        out.print("<td>"+ auto.getChilometri() + "</td>");
    	        out.print("<td><form action='deleteAuto' method='post'>"+
    	        		"<input type='submit' value='Rimuovi auto'/>"+
    	        		"<input type='hidden' name='targa' value='"+auto.getTarga()+"' />" +
    	        		"</form></td>");
    	        out.print("<td><form action='getDocAuto' method='post'>"+
    	        		"<input type='submit' value='Documenti auto'/>"+
    	        		"<input type='hidden' name='id' value='"+auto.getTarga()+"' />" +
    	        		"</form></td>");
    	        out.print("</tr>");
             
        	}
        	out.println("</table>");
        	out.print("</div>");
        	out.print("</body>");
        }catch(Exception e){
        	out.print("<html><body><h2 style='text-align:center'>Targa non trovata o non corretta</h2></body></html>");
        }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
