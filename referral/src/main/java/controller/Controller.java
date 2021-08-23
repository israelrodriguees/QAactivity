package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans referral = new JavaBeans();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("This is the action: " + action);
		// If we receive the "main", we redirect to this method
		if (action.equals("/main")) {
			referrals(request, response);
		}else if(action.equals("/insert")) {
			newReferral(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}

	// List of referrals
	protected void referrals(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Creating an object to receive the JavaBeans data
		ArrayList<JavaBeans> list = dao.listReferrals();
		
		// Forward list to the document "agenda.jsp"
		request.setAttribute("referrals", list);
		
		// To dispatch the list to another document we use the RequestDispatcher
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		
		rd.forward(request, response);
		
	}
	
	// New referral
	protected void newReferral(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set the variables JavaBeans
		referral.setFirstname(request.getParameter("txt_firstname"));
		referral.setLastname(request.getParameter("txt_lastname"));
		referral.setWrole(request.getParameter("txt_role"));
		referral.setWphone(request.getParameter("txt_phone"));
		referral.setWemail(request.getParameter("txt_email"));
		referral.setWrefnumber(request.getParameter("txt_refnumber"));
		referral.setWhear(request.getParameter("txt_hear"));
		referral.setWdatebirth(request.getParameter("txt_dbirth"));
		referral.setWtodo(request.getParameter("txt_todo"));
		referral.setWpdiagnosis(request.getParameter("txt_pdiagnosis"));
		referral.setWsdiagnosis(request.getParameter("txt_sdiagnosis"));
		referral.setWeekhours(request.getParameter("float_hours"));
		referral.setWreasonref(request.getParameter("txt_reasonref"));
		referral.setWfunding(request.getParameter("txt_fundingbody"));
		referral.setWdraty(request.getParameter("txt_draty"));
		referral.setWplocation(request.getParameter("txt_preflocation"));
		referral.setWacomneeds(request.getParameter("txt_acomneeds"));
		referral.setWdatestart(request.getParameter("txt_dstart"));
		
		System.out.println("\n Saved in the object: " + referral.getFirstname());
		// Ivoque method "insertReferral" using the object referral as a parameter
		dao.insertReferral(referral);	
		
		// Redirect to the document agenda.jsp to list our contacts
		response.sendRedirect("main");
	}
}