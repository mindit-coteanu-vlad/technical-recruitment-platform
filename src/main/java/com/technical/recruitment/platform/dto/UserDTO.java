package com.technical.recruitment.platform.dto;


import java.io.Serializable;

public class UserDTO implements Serializable {

    private int id;
    private String userToken;
    private String userName;
    private String userPassword;
    private String userRole;
    private String interviewStatus;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(String interviewStatus) {
        this.interviewStatus = interviewStatus;
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", userToken='" + userToken + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRole='" + userRole + '\'' +
                ", interviewStatus='" + interviewStatus + '\'' +
                '}';
    }
}
