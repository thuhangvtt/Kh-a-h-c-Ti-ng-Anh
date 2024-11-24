package model;

/**
 *
 * @author Admin
 */
import java.util.Date;

public class Enrollment {
    private int userId;
    private int courseId;
    private Date enrolledAt;

    public Enrollment() {}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getEnrolledAt() {
        return enrolledAt;
    }

    public void setEnrolledAt(Date enrolledAt) {
        this.enrolledAt = enrolledAt;
    }
}
