package de.hspf.sysdev.web.materialize.view.user;

import de.hspf.sysdev.web.materialize.logic.UserController;
import de.hspf.sysdev.web.materialize.view.util.ViewContextUtil;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author thomas
 */
@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private static final Logger logger = LogManager.getLogger(LoginBean.class);
    private static final long serialVersionUID = -383992898674810212L;

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
        logger.info("start authentication for user: " + userName);
        if (userController.validateUser(userName, password)) {
            userBean.setUser(userController.getUser(userName, password));
            setLoggedIn(true);
            logger.info("authentication of user: " + userName + " successfull");
            ViewContextUtil.getFacesContext().addMessage(null, new FacesMessage("Login sucessfull."));
            return "restricted/userhome";
        } else {
            logger.info("authentication of user: " + userName + " not successfull");
            ViewContextUtil.getFacesContext().addMessage(null, new FacesMessage("Login failed, either username or password are wrong. You provided:" + getUserName()));
            return "login";
        }
    }

    /*** 
     * This method will call a user log out operation.
     * @return navigation informattion (page to redirect to)
     * @throws IOException 
     */
    public String logout() throws IOException {
        if (isLoggedIn()) {
            logger.info("initiated log out of user: " + userName);
            setLoggedIn(false);
            userBean.setUser(null);
            logger.info("log out of user: " + userName + " successfull");
            return "/index?faces-redirect=true";
        }
        logger.info("log out initiated, nevertheless no user was logged in before");
        return "/index?faces-redirect=true";
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
