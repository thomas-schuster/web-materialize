package de.hspf.sysdev.web.materialize.model;

import java.io.Serializable;
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
    private Collection<Task> taskList;

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
