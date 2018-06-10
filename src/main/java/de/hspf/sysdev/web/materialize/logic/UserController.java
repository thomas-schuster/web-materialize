/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hspf.sysdev.web.materialize.logic;

import de.hspf.sysdev.web.materialize.model.User;
import de.hspf.sysdev.web.materialize.view.util.CreatorUtil;
import de.hspf.sysdev.web.materialize.view.util.DummyUserManager;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.apache.http.util.Asserts;

/**
 *
 * @author thomas.schuster
 */
@Stateless
public class UserController {

    @EJB
    DummyUserManager userManager;
    
    @PostConstruct
    private void init() {
    }

    public boolean registerUser(User user2register) {
        return userManager.registerUser(user2register);
    }
    
    public boolean validateUser(String username, String password) {
        return userManager.validateUser(username, password) != null;
    }
    
    public User getUser(String username, String password) {
        return userManager.validateUser(username, password);
    }
    
    
    public User getUserByName(String username) {
        return null;
    }
    
}
