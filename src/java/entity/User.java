package entity;

public class User {
    private int id; 
    private String name;
    private String email;
    private String password;
  

    public User(int id,String name, String email, String password) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    // Getters và Setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
