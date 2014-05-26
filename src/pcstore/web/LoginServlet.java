package pcstore.web;

import pcstore.ejb.Login;
import pcstore.util.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/Login")
    

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    @EJB
    private Login login;
    private MD5Tool myMd5;
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // Output the results
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<title>LoginServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet LoginServlet at " +
                request.getContextPath() + "</h1>");
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
 
            if (username != null && password != null) {
            	myMd5 = new MD5Tool();
                String passMd5 = myMd5.MD5Encrypt(password);  
            	int userId = login.UserLogin(username, passMd5);
            	if (userId != 0){
            	response.sendRedirect("/PCStore/ListItem.html"); 
            	}else
            	{
            		out.println("<p> Wrong UserName or Password.</p>");
            		out.println("<p>Enter your UserName and Password to Login:</p>");
                    out.println("<form method=\"get\">");
                    out.println("<p><input title=\"UserName\" type=\"text\" name=\"username\" size=\"25\"></p>");  
                    out.println("<br/>");
                    out.println("<p><input title=\"PassWord\" type=\"password\" name=\"password\" size=\"25\"></p>");
                    out.println("<br/>");
                    out.println("<input type=\"submit\" value=\"Submit\">" +
                            "<input type=\"reset\" value=\"Reset\">");
                    out.println("</form>");
            	}
            } else {
                out.println("<p>Enter your UserName and Password to Login:</p>");
                out.println("<form method=\"get\">");
                out.println("<p><input title=\"UserName\" type=\"text\" name=\"username\" size=\"25\"></p>");  
                out.println("<br/>");
                out.println("<p><input title=\"PassWord\" type=\"password\" name=\"password\" size=\"25\"></p>");
                out.println("<br/>");
                out.println("<input type=\"submit\" value=\"Submit\">" +
                        "<input type=\"reset\" value=\"Reset\">");
                out.println("</form>");
            }

        } finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
