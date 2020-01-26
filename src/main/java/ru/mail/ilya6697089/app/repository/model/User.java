package ru.mail.ilya6697089.app.repository.model;

public class User {

    private Integer id;
    private String username;
    private String password;
    //private Boolean isActive;
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() { return username; }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }
    //    public Boolean getActive() {
    //        return isActive;
    //    }
    //
    //    public void setActive(Boolean active) {
    //        isActive = active;
    //    }

}
