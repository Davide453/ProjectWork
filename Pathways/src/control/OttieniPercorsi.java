package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.PercorsoDAO;
import model.Percorso;

@WebServlet("/OttieniPercorsi")
public class OttieniPercorsi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OttieniPercorsi() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ottieniPercorsi servlet");

		int idUtente = 1;

		ArrayList<Percorso> percorso = PercorsoDAO.selectPercorsoFromIdUtente(idUtente);

		System.out.println(percorso);
		response.sendRedirect("percorsiUtente.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
