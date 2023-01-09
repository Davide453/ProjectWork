package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.UserDAO;
import model.User;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public login() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("login servlet");
		String email = request.getParameter("email");
		String password = request.getParameter("password");


		HttpSession session = request.getSession();
		User user = UserDAO.selectUserFromPassEmail(email, password);

		if (user != null && email.equalsIgnoreCase(user.getEmail()) && password.equals(user.getPassword())) {
			session.setAttribute("idUtente", user.getId());
			session.setAttribute("loggato", true);
			session.setAttribute("email", email);
			response.sendRedirect("home.jsp");
		} else {
			System.out.println("login fallito");
			session.setAttribute("loggato", false);
			response.sendRedirect("");

		}


		
		if (UserDAO.selectUserFromPassEmail(email, password) != null) {
			
			session.setAttribute("loggato", true);
			session.setAttribute("email", email);
			response.sendRedirect("home.jsp");
			
			
			} else {
				
				session.setAttribute("loggato", false);
				response.sendRedirect("home.jsp");
			
			}

		
		
	}

}
