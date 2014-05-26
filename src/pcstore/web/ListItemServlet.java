package pcstore.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ListItemServlet
 */
@WebServlet("/ListItem")
public class ListItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rtn_json = "";
		String drive = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/PCStore";
		Connection conn = null;
		try {
			rtn_json += "{\"Item\":[";
			Class.forName(drive);
		    conn = DriverManager.getConnection(url, "root", "asdfg123");     
		    PreparedStatement ps = conn.prepareStatement("SELECT * FROM Item");
            ResultSet rs = ps.executeQuery();
            boolean flag = true;
            while (rs.next()){
            	if (flag){
            		flag = false;
            		rtn_json = rtn_json + "{\"Name\":\"" + rs.getString(2) + "\",\"Price\":\"" + rs.getDouble(3) +  "\",\"Stock\":\"" + rs.getInt(4) + "\"}";
            	}
            	else{
            		rtn_json += ",";
            		rtn_json = rtn_json + "{\"Name\":\"" + rs.getString(2) + "\",\"Price\":\"" + rs.getDouble(3) +  "\",\"Stock\":\"" + rs.getInt(4) + "\"}";
            	}
            }
            rtn_json += "]}";
            response.setContentType("application/x-json");
            PrintWriter out = response.getWriter();
            out.println(rtn_json);
           } catch (ClassNotFoundException e) {
		    System.out.println(e.getMessage());
		   } catch (SQLException e) {
		    System.out.println(e.getMessage());
		   }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
