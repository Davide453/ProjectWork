package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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
	private User user;
	HttpSession session;
	ArrayList<Percorso> percorso;
	RequestDispatcher rd;

	public OttieniPercorsi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
	

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Ottieni percorsi servlet 2");
		session = request.getSession(true);
		user = (User) session.getAttribute("user");
		if (user != null) {
			percorso = PercorsoDAO.selectPercorsoFromIdUtente(user);
			request.setAttribute("percorso", percorso);
			session.setAttribute("percorso", percorso);
			System.out.println("request " + request.getAttribute("percorso"));
			System.out.println("session  " + session.getAttribute("percorso"));

		}
		rd = request.getRequestDispatcher("percorsiUtente.jsp");
		rd.forward(request, response);
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
