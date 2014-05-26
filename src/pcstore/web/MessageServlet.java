
package pcstore.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.jms.*;
import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MessageServlet
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String destinationName = "queue/order";
		PrintWriter out = response.getWriter();
		Context ic = null;
		ConnectionFactory cf = null;
		Connection connection =  null;
		try {        
		ic = new InitialContext();
		cf = (ConnectionFactory)ic.lookup("/ConnectionFactory");
		Queue queue = (Queue)ic.lookup(destinationName);
		connection = cf.createConnection();
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		MessageProducer publisher = session.createProducer(queue);
		connection.start();
		String itemname = request.getParameter("item");
		TextMessage message = session.createTextMessage(itemname);
		publisher.send(message);
		out.println("<p>Orders submitted successfully</p>");
		System.out.println(itemname);
		}
		catch (Exception exc) {
		exc.printStackTrace();
		}
		finally {        
		if (connection != null)   {
		try {
		connection.close();
		} catch (JMSException e) {                   
		e.printStackTrace();
		}
		}
		}
		*/
	}

}
