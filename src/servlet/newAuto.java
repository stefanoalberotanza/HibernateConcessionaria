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
/**
 * Servlet implementation class newAuto
 */
@WebServlet("/newAuto")
public class newAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newAuto() {
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
		String targa= request.getParameter("targa");
		String marca= request.getParameter("marca");
		int year = Integer.parseInt(request.getParameter("data"));
		int chilometri = Integer.parseInt(request.getParameter("chilometri"));
		Auto auto = new Auto();
		
		
		auto.setChilometri(chilometri);
		auto.setTarga(targa);
		auto.setMarca(marca);
		auto.setYear(year);
		session.save(auto);
		tx.commit();
		request.getRequestDispatcher("/success.jsp").forward(request, response);
	}

}
