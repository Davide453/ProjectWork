package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.UserDAO;
import model.User;

@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Registrazione() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Registrazione servlet");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repeatPass = request.getParameter("password-repeat");
		System.out.println(email + " " + password);
		if (password.equals(repeatPass)) {
			User u = new User(email, password);
			UserDAO.insertUtente(u);
		} else {
			System.out.println("Le password non coincidono");
		}

		response.sendRedirect("home.jsp");
	}

}
