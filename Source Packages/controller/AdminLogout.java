package controller;

import java.util.logging.Logger;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name="AdminLogout", urlPatterns={"/adminlogout"})
public class AdminLogout extends HttpServlet {

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		    response.setContentType("text/html;charset=UTF-8");
		    try {
		        HttpSession session = request.getSession(false);
		        if (session != null) {
		            String username = (String) session.getAttribute("username");
		            Logger.getLogger("LogoutServlet").info("User logged out: " + username);

		            session.invalidate();
		        }
		        
		        response.sendRedirect("adminlogin.jsp");
		    } catch (Exception e) {
		        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Logout failed");
		    }
		}

}
