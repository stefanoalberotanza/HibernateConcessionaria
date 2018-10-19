package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.*;

import hibernate.model.Auto;
import hibernate.model.Compratore;
/**
 * Servlet implementation class newAuto
 */
@WebServlet("/newCompr")
public class newCompr extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newCompr() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = (SessionFactory) request.getServletContext().getAttribute("SessionFactory");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String nome= request.getParameter("nome");
		String cognome= request.getParameter("cognome");
		String startDateStr = request.getParameter("data");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//surround below line with try catch block as below code throws checked exception
		java.util.Date data = null;
		try {
			data = sdf.parse(startDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//do further processing with Date object
		Compratore compratore = new Compratore();
		
		
		compratore.setNome(nome);
		compratore.setCognome(cognome);
		compratore.setData(data);
		session.save(compratore);
		tx.commit();
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

}
