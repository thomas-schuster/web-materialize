package de.hspf.sysdev.web.materialize.view.user;

import de.hspf.sysdev.web.materialize.logic.UserController;
import de.hspf.sysdev.web.materialize.view.util.ViewContextUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;

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

    @Inject
    UserBean userBean;
    @EJB
    UserController userController;

    public LoginBean() {
        setLoggedIn(false);
    }

    /**
     * *
     * This method will do a authentication. If the authentication is
     * successful, the user will be redirected to a personal deshboard page. If
     * the authentication is not successful the user will remain on the login
     * page.
     *
     * @return
     */
    public String authenticate() {
        if (userController.validateUser(userName, password)) {
            userBean.setUser(userController.getUser(userName, password));
            setLoggedIn(true);
            ViewContextUtil.getFacesContext().addMessage(null, new FacesMessage("Login sucessfull."));
            return "restricted/userhome";
        } else {
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
