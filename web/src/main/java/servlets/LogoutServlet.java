package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final String LOGIN_PAGE = "login.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Lấy session hiện tại
            HttpSession session = request.getSession(false);
            
            if (session != null) {
                // Xóa attribute "user" khỏi session
                session.removeAttribute("user");
                
                // Hủy session
                session.invalidate();
                
            }
            
            // Chuyển hướng về trang login
            response.sendRedirect(LOGIN_PAGE);
            
        } catch (Exception e) {
            // Log lỗi
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
