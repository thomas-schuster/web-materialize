/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hspf.sysdev.web.materialize.logic;

import de.hspf.sysdev.web.materialize.model.User;
import de.hspf.sysdev.web.materialize.view.util.DummyUserManager;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author thomas.schuster
 */
@Stateless
@Path("usercontroller")
public class UserController {

    @EJB
    private DummyUserManager userManager;

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

    @GET
    @Path("getuserbyname")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByName(String username) {
        return null;
    }

    @GET
    @Path("getuserlist")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getListOfUsers() {
        return userManager.getUsers();
    }

}
