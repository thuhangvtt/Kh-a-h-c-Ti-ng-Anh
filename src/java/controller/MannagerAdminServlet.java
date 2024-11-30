package controller;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class MannagerAdminServlet extends HttpServlet {

    private Connection connection;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/khta", "root", "lovecats21.00");
        } catch (Exception e) {
            throw new ServletException("Không thể kết nối tới cơ sở dữ liệu.", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("add".equals(action)) {
                request.getRequestDispatcher("/add_course.jsp").forward(request, response);
            } else if ("edit".equals(action)) {
                editCourse(request, response);
            } else if ("delete".equals(action)) {
                deleteCourse(request, response);
            } else {
                listCourses(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException("Lỗi khi xử lý yêu cầu", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("add".equals(action)) {
                addCourse(request, response);
            } else if ("edit".equals(action)) {
                updateCourse(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException("Lỗi khi xử lý yêu cầu", e);
        }
    }

    private void listCourses(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException {
        String query = "SELECT * FROM courses";
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            request.setAttribute("courses", rs);
            request.getRequestDispatcher("/list_courses.jsp").forward(request, response);
        }
    }

    private void addCourse(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("courseName");
        String description = request.getParameter("description");
        String categoryId = request.getParameter("categoryId");

        if (name == null || description == null || categoryId == null) {
            response.sendRedirect("admin.jsp?error=Thông tin không đầy đủ!");
            return;
        }

        String query = "INSERT INTO courses (name, description, category_id) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, categoryId);
            int result = ps.executeUpdate();
            if (result > 0) {
                response.sendRedirect("admin.jsp?message=Thêm khóa học thành công!");
            } else {
                response.sendRedirect("admin.jsp?error=Thêm khóa học thất bại!");
            }
        }
    }

    private void updateCourse(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String courseId = request.getParameter("courseId");
        String name = request.getParameter("courseName");
        String description = request.getParameter("description");
        String categoryId = request.getParameter("categoryId");

        if (courseId == null || name == null || description == null || categoryId == null) {
            response.sendRedirect("admin.jsp?error=Thông tin không đầy đủ!");
            return;
        }

        String query = "UPDATE courses SET name = ?, description = ?, category_id = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, categoryId);
            ps.setString(4, courseId);
            int result = ps.executeUpdate();
            if (result > 0) {
                response.sendRedirect("admin.jsp?message=Cập nhật khóa học thành công!");
            } else {
                response.sendRedirect("admin.jsp?error=Cập nhật khóa học thất bại!");
            }
        }
    }

    private void editCourse(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String courseId = request.getParameter("courseId");
        String query = "SELECT * FROM courses WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, courseId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                request.setAttribute("course", rs);
                request.getRequestDispatcher("/edit_course.jsp").forward(request, response);
            } else {
                response.sendRedirect("admin.jsp?error=Không tìm thấy khóa học!");
            }
        }
    }

    private void deleteCourse(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String courseId = request.getParameter("courseId");
        if (courseId == null) {
            response.sendRedirect("admin.jsp?error=Không có ID khóa học!");
            return;
        }

        String query = "DELETE FROM courses WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, courseId);
            int result = ps.executeUpdate();
            if (result > 0) {
                response.sendRedirect("admin.jsp?message=Xóa khóa học thành công!");
            } else {
                response.sendRedirect("admin.jsp?error=Xóa khóa học thất bại!");
            }
        }
    }

    @Override
    public void destroy() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet quản lý khóa học admin";
    }
}
