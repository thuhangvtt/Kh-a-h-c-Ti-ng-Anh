package entity;

public class Rating {
    private int id;
    private int userId;
    private int courseId;
    private String reviewText;
    private String createdAt;

    // Constructor
    public Rating(int id, int userId, int courseId, String reviewText, String createdAt) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.reviewText = reviewText;
        this.createdAt = createdAt;
    }

    // Getters và Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
