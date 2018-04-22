/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hspf.sysdev.web.materialize.view.user;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author thomas
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private String userName;
    private String password;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    public void authenticate() {
        //TODO add authentication mechanism
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
