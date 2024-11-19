package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String name;
    private String description;
    private List<Document> documents;
    
    public Course() {
        documents = new ArrayList<>();
    }
    
    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<Document> getDocuments() { return documents; }
    public void setDocuments(List<Document> documents) { this.documents = documents; }
}
