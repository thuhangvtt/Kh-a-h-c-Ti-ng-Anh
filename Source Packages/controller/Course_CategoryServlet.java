
package controller;
import entity.Course_Category;
import jakarta.servlet.RequestDispatcher;
import model.CourseDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import model.CategoryDAO;

@WebServlet(name = "Course_CategoryServlet", urlPatterns = {"/Course_CategoryServlet"})
public class Course_CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private   CategoryDAO categoryDAO ;

    public Course_CategoryServlet() { 
        super();
    }
    @Override
    public void init() throws ServletException {
        // Khởi tạo categoryDAO trong init()
        this.categoryDAO = new CategoryDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy danh sách các khóa học từ CategoryDAO
        List<Course_Category> courses = categoryDAO.getAllCategory();

        // Đặt danh sách các khóa học vào request attribute
        request.setAttribute("courses", courses);

        // Forward tới trang JSP để hiển thị các khóa học
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }
}