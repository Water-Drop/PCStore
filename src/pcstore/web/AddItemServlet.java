package pcstore.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Locale;
import java.util.ResourceBundle;

import pcstore.ejb.ItemManage;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItem")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ItemManage im;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String language = request.getParameter("language");
		Locale locale;
		if ("zh".equals(language)) {
			locale = new Locale("zh", "CN");
		} else {
			locale = new Locale("en", "US");
		}
		ResourceBundle resb = ResourceBundle.getBundle("indexStrings", locale);
		String rtn_html ="";
		rtn_html = rtn_html + "<h1>" + resb.getString("addItemTitle") + "</h1>"
				+ "<form method=post action=\"AddItem\">" 
				+ "<p>" + resb.getString("itemName") + "</p><p>"
				+ "<input title=\"Name\" type=\"text\" name=\"name\" size=\"25\" id=\"input_name\"></p><p>"
				+ resb.getString("itemPrice") + "</p><p>"
				+ "<input title=\"Price\" type=\"text\" name=\"price\" id=\"input_price\" size=\"25\"></p><p>"
				+ resb.getString("itemStock") + "</p><p>"
				+ "<input title=\"Stock\" type=\"text\" name=\"stock\" id=\"input_stock\" size=\"25\"></p><p>"
				+ resb.getString("itemDescription") + "</p><p>"
				+ "<input title=\"Description\" type=\"text\" name=\"description\"id=\"input_desc\" size=\"25\"></p>"
				+ "<br /> <input type=\"submit\" value=\"Submit\"></form>";
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(rtn_html);
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		String description = request.getParameter("description");
		im.addItem(name, price, stock, description);
		out.println("<script>alert(\"Success\")</script>");
		response.sendRedirect("/PCStore/AddItem");

	}

}
