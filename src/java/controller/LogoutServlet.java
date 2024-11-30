package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Xóa session của người dùng
        request.getSession().invalidate();
        
        // Chuyển hướng người dùng về trang đăng nhập
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Đảm bảo việc đăng xuất có thể thực hiện qua POST nếu cần
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "LogoutServlet - Xử lý đăng xuất và chuyển hướng về trang đăng nhập";
    }
}
