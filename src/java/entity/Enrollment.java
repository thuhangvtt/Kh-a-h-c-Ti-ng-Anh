
package entity;

/**
 *
 * @author Admin
 */
import java.util.Date;

public class Enrollment {
    private int userId;
    private int courseId;
    private Date enrolledAt;
     private String status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Enrollment{" + "userId=" + userId + ", courseId=" + courseId + ", enrolledAt=" + enrolledAt + ", status=" + status + '}';
    }
    
}
