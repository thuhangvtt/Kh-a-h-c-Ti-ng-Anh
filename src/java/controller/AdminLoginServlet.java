/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.AdminAccount;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.AdminDAO;

/**
 *
 * @author Admin
 */
@WebServlet(name = "AdminLogin", urlPatterns = {"/AdminLogin"})
public class AdminLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin email và password từ form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Tạo một đối tượng DAO để xử lý truy vấn cơ sở dữ liệu
        AdminDAO adminDAO = new AdminDAO();
        AdminAccount admin = adminDAO.login(email, password);

        if (admin != null && email.equals(admin.getEmail())) {
            // Đăng nhập thành công
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin); // Lưu admin vào session

            // Chuyển hướng đến trang home.jsp
            response.sendRedirect("adminhome.jsp");
        } else {
            // Đăng nhập thất bại
            String error = "Email hoặc mật khẩu không chính xác!";
            request.setAttribute("error", error);

            // Quay lại trang đăng nhập
            request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Chuyển hướng đến trang adminlogin.jsp
        response.sendRedirect("adminlogin.jsp");
    }
}