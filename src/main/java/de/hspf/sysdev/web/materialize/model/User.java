package de.hspf.sysdev.web.materialize.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author thomas.schuster
 */
@Entity
@NamedQueries({
    @NamedQuery(name="User.findByName", query="SELECT u FROM User u WHERE u.userName = :name"),
})
@Table(name = "MaterialUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;
    private String userName;
    private String userDescription;
    private String password;
    private String salutation;
    private String name;
    private String surName;
    private String email;
    
    @OneToMany(cascade={CascadeType.ALL})
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

    
    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
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
