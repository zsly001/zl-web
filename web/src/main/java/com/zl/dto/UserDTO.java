package com.zl.dto;

public class UserDTO {

    private Integer id;

    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
