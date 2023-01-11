package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.PercorsoDAO;
import data.UserDAO;
import model.Percorso;
import model.User;

/**
 * Servlet implementation class OttieniPercorsi
 */
@WebServlet("/OttieniPercorsi")
public class OttieniPercorsi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OttieniPercorsi() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Ottieni percorsi servlet 2");
		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");
		if (user != null) {
			ArrayList<Percorso> percorso = PercorsoDAO.selectPercorsoFromIdUtente(user);
			request.setAttribute("percorso", percorso);
			session.setAttribute("percorso", percorso);
			ArrayList<Percorso> percorso2 = (ArrayList<Percorso>) request.getAttribute("percorso");
			ArrayList<Percorso> percorso3 = (ArrayList<Percorso>) session.getAttribute("percorso");
			session.getAttribute("percorso");
			System.out.println("test" + percorso);
			System.out.println("request percorso " + percorso2);
			System.out.println("session percorso " + percorso3);
		}
		response.sendRedirect("percorsiUtente.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
