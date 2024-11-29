package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import entity.AdminAccount;
import entity.Course;
import model.AdminDAO;
import java.util.logging.Logger;
import java.util.logging.Level;

@WebServlet(name = "AdminAdd", urlPatterns = {"/add"})
public class AdminAdd extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(AdminAdd.class.getName());
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try {
            String pname = request.getParameter("name");
            String pdescription = request.getParameter("description");
            String pidString = request.getParameter("id");
            int pid;
            pid = Integer.parseInt(pidString.trim());
            HttpSession session = request.getSession();
            AdminAccount adminAccount = (AdminAccount) session.getAttribute("adminAccount");
            Course course = new Course();
            course.setId(pid);
            course.setName(pname.trim());
            course.setDescription(pdescription.trim());
            AdminDAO dao = new AdminDAO();
            dao.createCourse(course);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error in course creation process", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Đã xảy ra lỗi hệ thống");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
