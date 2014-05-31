package pcstore.web;

import pcstore.ejb.Register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 3L;
	@EJB
	private Register register;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		if (null == type) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			register.UserRegister(username, password);
			response.sendRedirect("/PCStore/Login");
		} else {
			String username = request.getParameter("username");
			int check_rtn = register.CheckUsername(username);
			if (check_rtn == 0) {
				out.print("success");
			} else if (check_rtn == -1) {
				out.println("Please DONT include whitespace in your username!");
			} else if (check_rtn == -2) {
				out.println("Please DONT include illegal character in your username!");
			} else {
				out.println("Invalid username!");
			}
		}

	}

}
