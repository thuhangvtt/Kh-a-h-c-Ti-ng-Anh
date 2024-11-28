package controller;

import entity.AdminAccount;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AdminDAO;

@WebServlet(name = "AdminLogin", urlPatterns = {"/login"})
public class AdminLogin extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String remember = (String) request.getParameter("rememberme");
            HttpSession session = request.getSession();
            AdminDAO adminDAO = new AdminDAO();
            AdminAccount adminAccount = adminDAO.login(username, password);

            if (adminAccount == null || !username.equals(adminAccount.getUsername()))
            {
                String err = "Username or password incorrect!";
                request.setAttribute("err", err);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } 
            Cookie passcake = new Cookie("password", password);
            passcake.setMaxAge(300);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
