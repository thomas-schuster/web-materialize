package de.hspf.sysdev.web.materialize.view.user;

import de.hspf.sysdev.web.materialize.view.util.ViewContextUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;

/**
 *
 * @author thomas
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private boolean loggedIn;
    private String userName;
    private String password;

    public LoginBean() {
        setLoggedIn(false);
    }

    public String authenticate() {
        //TODO add real authentication mechanism
        if (getUserName().equals("thomas")) {
            ViewContextUtil.getSession().setAttribute("user", getUserName());
            setLoggedIn(true);
            ViewContextUtil.getSession().setAttribute("loggedIn", isLoggedIn());
            ViewContextUtil.getFacesContext().addMessage(null, new FacesMessage("Login sucessfull."));
            return "index";
        } else {
            ViewContextUtil.getSession().setAttribute("loggedIn", isLoggedIn());
            ViewContextUtil.getFacesContext().addMessage(null, new FacesMessage("Login failed, either username or password are wrong. You provided:" + getUserName()));
            return "login";
        }
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

    public boolean isLoggedIn() {
        return loggedIn;
    }
    
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

}
