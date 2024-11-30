package entity;

import java.util.Date;

public class Lesson {
    private int id;
    private int courseId;
    private String title;
    private String slug;
    private String videoLink;
    private Date createdAt;
    private boolean isDisabled;

    public Lesson(int id, int courseId, String title, String slug, String videoLink, Date createdAt, boolean isDisabled) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.slug = slug;
        this.videoLink = videoLink;
        this.createdAt = createdAt;
        this.isDisabled = isDisabled;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }

    @Override
    public String toString() {
        return "Lesson{" + "id=" + id + ", courseId=" + courseId + ", title=" + title + ", slug=" + slug + ", videoLink=" + videoLink + ", createdAt=" + createdAt + ", isDisabled=" + isDisabled + '}';
    }
    
}