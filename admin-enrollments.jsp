<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Enrollments</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
        }

        .container {
            width: 90%;
            margin: 20px auto;
            padding: 20px;
            background-color: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        table th, table td {
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }

        table th {
            background-color: #007bff;
            color: #fff;
        }

        table tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        table tr:hover {
            background-color: #f1f1f1;
        }

        .action-links a {
            text-decoration: none;
            padding: 8px 16px;
            border-radius: 4px;
            color: #fff;
            margin-right: 8px;
        }

        .approve {
            background-color: #28a745;
        }

        .reject {
            background-color: #dc3545;
        }

        .message {
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 4px;
        }

        .message.success {
            background-color: #d4edda;
            color: #155724;
        }

        .message.error {
            background-color: #f8d7da;
            color: #721c24;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Danh sách học viên đăng ký khóa học</h1>

        <!-- Hiển thị thông báo -->
        <c:if test="${not empty param.message}">
            <div class="message success">${param.message}</div>
        </c:if>
        <c:if test="${not empty param.error}">
            <div class="message error">${param.error}</div>
        </c:if>

        <!-- Bảng hiển thị danh sách enrollments -->
        <table>
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Course ID</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="enrollment" items="${enrollments}">
                    <tr>
                        <td>${enrollment.userId}</td>
                        <td>${enrollment.courseId}</td>
                        <td>${enrollment.status}</td>
                        <td class="action-links">
                            <a href="AdminServlet?action=approve&userId=${enrollment.userId}&courseId=${enrollment.courseId}" class="approve">Approve</a>
                            <a href="AdminServlet?action=reject&userId=${enrollment.userId}&courseId=${enrollment.courseId}" class="reject">Reject</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
