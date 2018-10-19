package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import hibernate.model.Auto;
import hibernate.model.docAuto;

/**
 * Servlet implementation class deleteDocumento
 */
@WebServlet("/deleteDocumento")
public class deleteDocumento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteDocumento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory sessionFactory = (SessionFactory) request.getServletContext().getAttribute("SessionFactory");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		docAuto docAuto = (docAuto) session.load(docAuto.class, request.getParameter("id"));
		session.delete(docAuto);
		tx.commit();
		PrintWriter out = response.getWriter();
		out.print("<h1 style='text-align:center'>Documento rimosso<h1>");
		out.print("<form action='index.jsp' method='get'><input type='submit'/></form>");
	}

}
