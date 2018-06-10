package de.hspf.sysdev.web.materialize.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author thomas.schuster
 */
public class User {

    private String userID;
    private String userName;
    private String userDescription;
    private String password;
    private String salutation;
    private String name;
    private String surName;
    private String email;
    private Collection<Task> taskList;

    public User() {
        taskList = new ArrayList<>();
    }
    
    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(Collection<Task> taskList) {
        this.taskList = taskList;
    }

}
