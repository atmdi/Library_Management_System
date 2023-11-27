package org.example.model;

public class UserInfo {
    private  Long id;

    private Long userId;
    private  String address;
    private String mobile;
    private String city;

    public UserInfo(){

    }

    public UserInfo(Long id, Long userId, String address, String mobile, String city) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.mobile = mobile;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
