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
 * Servlet implementation class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete"})
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The referral. */
	JavaBeans referral = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();

	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println("This is the action: " + action);
		// If we receive the "main", we redirect to this method
		if (action.equals("/main")) {
			referrals(request, response);
		} else if (action.equals("/insert")) {
			newReferral(request, response);
		} else if (action.equals("/select")) {
			listReferral(request, response);
		} else if (action.equals("/update")) {
			editReferral(request, response);
		} else if (action.equals("/delete")) {
			deleteReferral(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Referrals.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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

	/**
	 * New referral.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
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
		// Evoque method "insertReferral" using the object referral as a parameter
		dao.insertReferral(referral);

		// Redirect to the document agenda.jsp to list our contacts
		response.sendRedirect("main");
	}

	/**
	 * List referral.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Edit referral
	protected void listReferral(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set variable JavaBeans
		referral.setEnqnumber(request.getParameter("idcon"));

		// Execute method selectReferral(DAO)
		dao.selectReferral(referral);

		// Set atributtes of our form with the JavaBeans
		request.setAttribute("enquiryno", referral.getEnqnumber());
		request.setAttribute("txt_firstname", referral.getFirstname());
		request.setAttribute("txt_lastname", referral.getLastname());
		request.setAttribute("txt_role", referral.getWrole());
		request.setAttribute("txt_phone", referral.getWphone());
		request.setAttribute("txt_email", referral.getWemail());
		request.setAttribute("txt_refnumber", referral.getWrefnumber());
		request.setAttribute("txt_hear", referral.getWhear());
		request.setAttribute("txt_dbirth", referral.getWdatebirth());
		request.setAttribute("txt_todo", referral.getWtodo());
		request.setAttribute("txt_pdiagnosis", referral.getWpdiagnosis());
		request.setAttribute("txt_sdiagnosis", referral.getWsdiagnosis());
		request.setAttribute("float_hours", referral.getWeekhours());
		request.setAttribute("txt_reasonref", referral.getWreasonref());
		request.setAttribute("txt_fundingbody", referral.getWfunding());
		request.setAttribute("txt_draty", referral.getWdraty());
		request.setAttribute("txt_preflocation", referral.getWplocation());
		request.setAttribute("txt_acomneeds", referral.getWacomneeds());
		request.setAttribute("txt_dstart", referral.getWdatestart());

		// Forward data to the edit_referral.jsp
		RequestDispatcher rd = request.getRequestDispatcher("edit_referral.jsp");
		rd.forward(request, response);

	}

	/**
	 * Edits the referral.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Update
	protected void editReferral(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set the variables JavaBeans
		referral.setEnqnumber(request.getParameter("enquiryno"));
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

		// Execute method updateReferral
		dao.updateReferral(referral);

		// Redirect to the "agenda.jsp" document, updating the changes
		response.sendRedirect("main");
	}

	/**
	 * Delete referral.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Remove a referral
	protected void deleteReferral(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Set variable enquirynumber JavaBeans
		referral.setEnqnumber(request.getParameter("idcon"));

		// Execute method deleteReferral(DAO) passing the object "referral"
		dao.deleteReferral(referral);

		// Redirect to the "agenda.jsp" document, updating the changes
		response.sendRedirect("main");
	}
}

