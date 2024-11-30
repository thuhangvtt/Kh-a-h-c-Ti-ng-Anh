package entity;

public class Course {

    private int id;
    private String name;
    private String description;
    private String image;  // Thêm thuộc tính image

    // Hàm khởi tạo đầy đủ cho đối tượng Course
    public Course(int id , String name , String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;  // Khởi tạo image
    }

    // Hàm khởi tạo không tham số
    public Course() {
        // Bạn có thể giữ phương thức này hoặc loại bỏ nếu không cần thiết
    }

    // Getter và setter cho các thuộc tính
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", description=" + description + ", image=" + image + '}';
    }
}
