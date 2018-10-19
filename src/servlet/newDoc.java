package servlet;

import java.io.IOException;
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
 * Servlet implementation class newDoc
 */
@WebServlet("/newDoc")
public class newDoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newDoc() {
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
		String targa= request.getParameter("targa");
		String documento= request.getParameter("documento");
		try{
			Auto auto = (Auto)session.get(Auto.class,request.getParameter("targa"));
			docAuto docAuto = new docAuto();
			docAuto.setAuto(auto);
			docAuto.setDocumento(documento);
			session.save(docAuto);
			tx.commit();
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}catch(Exception e){
			request.getRequestDispatcher("/erroreDoc.jsp").forward(request, response);
		}
	}
}
