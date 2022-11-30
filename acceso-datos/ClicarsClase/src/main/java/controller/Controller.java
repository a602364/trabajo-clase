package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import conexion.Conexion;
import model.daos.DaoCoche;
import model.daos.DaoMarca;
import model.entities.Coche;
import model.entities.Marca;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String fav;
		String marca;
		String order;
		String search;
		Connection con = (Connection) session.getAttribute("con");
		if (con == null) {
			con = Conexion.conecta();
			session.setAttribute("con", con);
		}
		String op = request.getParameter("op");
		RequestDispatcher dispatcher;
		if (op.equals("inicio")) {
			try {
				session.setAttribute("marca", "%");
				session.setAttribute("order", "marca");
				session.setAttribute("search", "%");
				session.setAttribute("fav", "%");
				ArrayList<Coche> coches = new DaoCoche().getCoches("%", "marca", "%", "%", con);
				ArrayList<Marca> marcas = new DaoMarca().getMarcas(con);
				session.setAttribute("marcas", marcas);
				session.setAttribute("coche", coches); // ESTA ES LA s DE LOS COJONES
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (op.equals("vamarca")) {

			try {
				marca = request.getParameter("marca");
				session.setAttribute("marca", marca);
				order = (String) session.getAttribute("order");
				search = (String) session.getAttribute("search");

				session.setAttribute("fav", "%");
				fav = (String) session.getAttribute("fav");
				ArrayList<Coche> coches = new DaoCoche().getCoches(marca, order, search, fav, con);
				session.setAttribute("coche", coches);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (op.equals("vaorder")) {
			try {
				order = request.getParameter("order");
				session.setAttribute("order", order);
				marca = (String) session.getAttribute("marca");
				session.setAttribute("fav", "%");
				fav = (String) session.getAttribute("fav");
				search = (String) session.getAttribute("search");
				ArrayList<Coche> coches = new DaoCoche().getCoches(marca, order, search, fav, con);
				session.setAttribute("coche", coches);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (op.equals("vafav")) {
			try {
				fav = request.getParameter("fav");
				if (fav.equals("0"))
					fav = "%";
				session.setAttribute("fav", fav);
				marca = (String) session.getAttribute("marca");
				order = (String) session.getAttribute("order");
				search = (String) session.getAttribute("search");
				ArrayList<Coche> coches = new DaoCoche().getCoches(marca, order, search, fav, con);
				session.setAttribute("coche", coches);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (op.equals("changefav")) {
			try {
				fav = request.getParameter("fav");
				int favint = Integer.parseInt(fav);
				// favint cambia 0 por 1 o 1 por 0 con el operador ternario ?:
				favint = favint == 0 ? 1 : 0;
				String id = request.getParameter("coche");
				new DaoCoche().updateFav(Integer.parseInt(id), favint, con);
				fav = (String) session.getAttribute("fav");
				marca = (String) session.getAttribute("marca");
				order = (String) session.getAttribute("order");
				search = (String) session.getAttribute("search");
				ArrayList<Coche> coches = new DaoCoche().getCoches(marca, order, search, fav, con);
				session.setAttribute("coche", coches);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (op.equals("vafiltro")) {

			try {
				search = request.getParameter("search");
				ArrayList<Coche> coches = (ArrayList<Coche>) session.getAttribute("coches");
				marca = (String) session.getAttribute("marca");
				order = (String) session.getAttribute("order");
				fav = (String) session.getAttribute("fav");
				coches = new DaoCoche().getCoches(marca, order, search, fav, con);
				session.setAttribute("coche", coches);

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

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
