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
import hibernate.model.Compratore;
import hibernate.model.docAuto;
import hibernate.model.docCompr;

/**
 * Servlet implementation class newDocCompr
 */
@WebServlet("/newDocCompr")
public class newDocCompr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newDocCompr() {
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
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = (SessionFactory) request.getServletContext().getAttribute("SessionFactory");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Integer id= Integer.parseInt(request.getParameter("id"));
		String documento= request.getParameter("documento");
		try{
			Compratore compr = (Compratore)session.get(Compratore.class, id);
			System.out.println(compr==null);
			docCompr docCompr = new docCompr();
			docCompr.setCompratore(compr);
			docCompr.setDocumento(documento);
			session.save(docCompr);
			tx.commit();
			request.getRequestDispatcher("/success.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			request.getRequestDispatcher("/erroreDocCompr.jsp").forward(request, response);
		}
	}

}
