/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Course {

    private int id;
    private String name;
    private String description;
   

    // Hàm khởi tạo đầy đủ cho đối tượng Course
    public Course(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
      
       
    }

    // Các phương thức getter và setter nếu cần
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    

    

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }
    
}
