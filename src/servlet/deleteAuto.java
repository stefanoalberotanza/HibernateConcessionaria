package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.*;
import hibernate.model.*;


/**
 * Servlet implementation class deleteAuto
 */
@WebServlet("/deleteAuto")
public class deleteAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public deleteAuto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory sessionFactory = (SessionFactory) request.getServletContext().getAttribute("SessionFactory");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Auto auto = (Auto) session.load(Auto.class, request.getParameter("targa"));
		session.delete(auto);
		tx.commit();
		PrintWriter out = response.getWriter();
		out.print("<h1 style='text-align:center'>Auto rimossa<h1>");
		out.print("<form action='index.jsp' method='get'><input type='submit'/></form>");
	}
}
