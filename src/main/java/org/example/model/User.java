package org.example.model;

import java.util.List;

public class User extends BasicModel{

    private String name;
    private String lastname;

    private String age;

    private UserInfo userInfo;

    private List<Book> takenBook;



    public User(Long id, String name, String lastname, String age, UserInfo userInfo, List<Book> takenBook) {
        super(id, name);
        this.lastname = lastname;
        this.age = age;
        this.userInfo = userInfo;
        this.takenBook = takenBook;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Book> getTakenBook() {
        return takenBook;
    }

    public void setTakenBook(List<Book> takenBook) {
        this.takenBook = takenBook;
    }

    @Override
    public String toString() {
        return "User{" +
                "lastname='" + lastname + '\'' +
                ", age=" + age +
                ", userInfo=" + userInfo +
                ", takenBook=" + takenBook +
                '}';
    }
}
