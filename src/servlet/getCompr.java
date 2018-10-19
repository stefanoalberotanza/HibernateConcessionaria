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
import hibernate.model.Compratore;

/**
 * Servlet implementation class getCompr
 */
@WebServlet("/getCompr")
public class getCompr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getCompr() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		SessionFactory sessionFactory = (SessionFactory) request.getServletContext().getAttribute("SessionFactory");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		PrintWriter out = response.getWriter();
		if(request.getParameter("nome") == ""){
    		List<Compratore> comprList  = session.createCriteria(Compratore.class).list();
    		Iterator it = comprList.iterator();
    		request.setAttribute("comprList", comprList);
    		request.getRequestDispatcher("/getComprJSP.jsp").forward(request, response);
		}else{
			//List<Compratore> comprList = (List<Compratore>) session.createSQLQuery("SELECT * FROM compratori WHERE nome = " + request.getParameter("nome")).list();
			String hql = "FROM Compratore C WHERE C.nome = :compratore_nome";
			Query query = session.createQuery(hql);
			query.setParameter("compratore_nome",request.getParameter("nome"));
			List<Compratore> comprList = query.list();
			request.setAttribute("comprList", comprList);
    		request.getRequestDispatcher("/getComprJSP.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
