package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import hibernate.model.docAuto;

@WebServlet("/getDocAuto")
public class getDocAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getDocAuto() {
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
        	if(request.getParameter("id") == ""){
        		List<docAuto> autoList  = session.createCriteria(docAuto.class).list();
        		Iterator it = autoList.iterator();
            	out.print("<body>");
            	out.print("<div style='text-align:center'>");
            	out.print("<table border=\"1\" cellspacing=10 cellpadding=5 style='text-align:center;margin: auto;'>");
        		out.print("<th>Targa</th>");
                out.print("<th>Documento</th>");
        		out.println("<th>Rimuovi</th>");
                while(it.hasNext()){
        			docAuto docAuto = (docAuto) it.next();
        			out.print("<tr>");
        			out.print("<td>"+ docAuto.getAuto().getTarga() +"</td>");
        	        out.print("<td>"+ docAuto.getDocumento() + "</td>");
        	        out.print("<td><form action='deleteDocumento' method='post'>"+
        	        		"<input type='submit' value='Rimuovi'/>"+
        	        		"<input type='hidden' name='id' value='"+ docAuto.getId() +"' />" +
        	        		"</form></td>");
        	        out.print("</tr>");
        		}        		
        	}else{
            	out.print("<body>");
            	out.print("<div style='text-align:center'>");
            	out.print("<table border=\"1\" cellspacing=10 cellpadding=5 style='text-align:center;margin: auto;'>");
        		out.print("<th>Targa</th>");
                out.print("<th>Documento</th>");
        		out.println("<th>Rimuovi</th>");
        		Auto auto = (Auto)session.get(Auto.class,request.getParameter("id"));
        		List<docAuto> docAutoList  = auto.getDocumenti();
        		Iterator it = docAutoList.iterator();
        		tx.commit();
        		while(it.hasNext()){
        			docAuto docAuto = (docAuto) it.next();
        			out.print("<tr>");
        			out.print("<td>"+ docAuto.getAuto().getTarga() +"</td>");
        	        out.print("<td>"+ docAuto.getDocumento() + "</td>");
        	        out.print("<td><form action='deleteDocumento' method='post'>"+
        	        		"<input type='submit' value='Rimuovi'/>"+
        	        		"<input type='hidden' name='id' value='"+ docAuto.getId()+"' />" +
        	        		"</form></td>");
        	        out.print("</tr>");
        		}        		
             
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
