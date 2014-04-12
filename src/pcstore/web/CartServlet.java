package pcstore.web;

import pcstore.ejb.Cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/Cart")
    

public class CartServlet extends HttpServlet{
	private static final long serialVersionUID = 2L;
    @EJB
    private Cart cart;

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
        out.println("<title>CartServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet CartServlet at " +
                request.getContextPath() + "</h1>");
        try {
        	HttpSession session = request.getSession();
        	String userid = "1";
            //String userid = request.getParameter("userid");
            //if (userid == null){
            //	userid = "0";
            //}
            if (session.getAttribute(userid) == null){
            	cart.initialize(userid);
            }else{
            	cart = (Cart) session.getAttribute(userid);
            }
            String additem = request.getParameter("additem");
            String removeitem = request.getParameter("removeitem");
            if(additem != null){
            	cart.addItem(additem);
            	response.sendRedirect("/PCStore/Cart"); 
            }
            if(removeitem != null){
            	cart.removeItem(removeitem);
            	response.sendRedirect("/PCStore/Cart"); 
            }

            out.println("<p>Enter the item you like to the cart:</p>");
            out.println("<form method=\"get\">");
            out.println("<p><input title=\"Additem:\" type=\"text\" name=\"additem\" size=\"25\"></p>");  
            out.println("<br/>");
            out.println("<input type=\"submit\" value=\"Add\">");
            out.println("</form>");
            out.println("<p>Enter the item you DONT like to remove from the cart:</p>");
            out.println("<form method=\"get\">");
            out.println("<p><input title=\"Removeitem:\" type=\"text\" name=\"removeitem\" size=\"25\"></p>");  
            out.println("<br/>");
            out.println("<input type=\"submit\" value=\"Remove\">");
            out.println("<br/>");
            out.println("</form>");
            if(cart.getContents().isEmpty() == false ){
            	out.println("<p>Cart:</p>");
            	out.println(cart.getContents());
            }else{
            	out.println("<p>There is no item in the cart!</p>");
            }
            session.setAttribute(userid, cart);
        }
            finally{
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

