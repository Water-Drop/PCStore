package pcstore.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
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
		String rtn_html = "";
		rtn_html = rtn_html + "<h1>" + resb.getString("welcomeTitle") + "</h1>"
				+ "<a href=Login>" + resb.getString("welcomeLogin") + "</a><br />"
				+ "<a href=Register>" + resb.getString("welcomeRegister")
				+ "</a><br />" + "<a href=http://localhost:8180/WebSocketChatroom>"
				+ resb.getString("welcomeChatroom") + "</a>";
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
		// TODO Auto-generated method stub
	}

}
