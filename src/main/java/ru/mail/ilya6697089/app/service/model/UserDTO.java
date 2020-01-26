package ru.mail.ilya6697089.app.service.model;

public class UserDTO {

    private Integer id;
    private String username;
    private String password;
    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getName() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password=" + password +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

}
