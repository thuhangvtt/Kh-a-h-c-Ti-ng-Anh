package controller;

import entity.Course;
import entity.Lesson;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.CategoryDAO;
import model.CourseDAO;
import model.LessonDAO;

@WebServlet(name = "LessonServlet", urlPatterns = {"/LessonServlet"})
public class LessonServlet extends HttpServlet {
    private LessonDAO lessonDAO;

    @Override
    public void init() throws ServletException {
        lessonDAO = new LessonDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy courseId từ query parameter
        String courseIdParam = request.getParameter("courseId");

        // Lấy danh sách bài học thuộc khóa học này
        List<Lesson> lessons = lessonDAO.getLessonsByCourseId(courseIdParam);

        // Truyền dữ liệu sang JSP
        request.setAttribute("lessons", lessons);
      

        // Forward đến trang detail.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("detail.jsp");
        dispatcher.forward(request, response);
    }
}
