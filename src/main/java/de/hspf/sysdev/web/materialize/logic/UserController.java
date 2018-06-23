/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hspf.sysdev.web.materialize.logic;

import de.hspf.sysdev.web.materialize.logic.dao.TaskFacade;
import de.hspf.sysdev.web.materialize.logic.dao.UserFacade;
import de.hspf.sysdev.web.materialize.model.Task;
import de.hspf.sysdev.web.materialize.model.User;
import de.hspf.sysdev.web.materialize.view.util.CreatorUtil;
import java.util.Collection;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author thomas.schuster
 */
@Stateless
@Path("usercontroller")
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    //TODO remove again
    @Inject
    CreatorUtil util;

    @EJB
    private UserFacade userManager;
    @EJB
    private TaskFacade taskManager;

    @PostConstruct
    private void init() {
    }

    public boolean registerUser(User user2register) {
        userManager.edit(user2register);
        return true;
    }

    /**
     * *
     * This method will return true, if a user was found and the password
     * matches the users password.
     *
     * @param username
     * @param password
     * @return true if credentials match, false otherwise
     */
    public boolean validateUser(String username, String password) {
        logger.debug("initiate user validation for user: " + username);
        return getUser(username, password) != null;
    }

    /**
     * *
     * This method will return a user object, if a user was found and the
     * password matches the users password.
     *
     * @param username
     * @param password
     * @return user object in case credentials are valid
     */
    public User getUser(String username, String password) {
        User user = getUser(username);
        if (user != null && user.getPassword().equals(password)) {
            logger.info("user validation was successfull");
            return user;
        }
        logger.warn("user validation was not successfull");
        return null;
    }

    private User getUser(String username) {
        return userManager.findByName(username);
    }

    @GET
    @Path("getuserbyname")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByName(@PathParam("username") String username) {
        return userManager.findByName(username);
    }

    /**
     * *
     * This method will return a list of users
     *
     * @return
     */
    @GET
    @Path("getuserlist")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getListOfUsers() {
        return userManager.findAll();
    }

    /**
     * *
     * This method will create a new task for a given user.
     *
     * @param user - the user object
     * @param name - the name of the new task
     * @param due - date when task is due
     * @param type - type of task
     */
    public void createUserTask(User user, String name, Date due, Task.TaskType type) {
        Task userTask = util.createTask(name, type, due);
        taskManager.edit(userTask);
        user.getTaskList().add(userTask);
        userManager.edit(user);
    }
}
