package de.hspf.sysdev.web.materialize.view.util;

import de.hspf.sysdev.web.materialize.model.User;
import java.util.Collection;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 * This bean simulates the application's user management. It has to be replaced
 * by a real user management.
 *
 * @author thomas.schuster
 */
@Stateless
public class DummyUserManager {

    private Collection<User> users;
    private CreatorUtil util;

    @PostConstruct
    public void init() {
        util = new CreatorUtil();
        users = util.createUserList();
    }

    public boolean registerUser(User user) {
       users.add(user);
       return true;
    }
    
    public User validateUser(String username, String password) {
        Optional<User> user = users.stream().filter(u -> 
                u.getUserName().equals(username) && 
                        u.getPassword().equals(password)).findFirst();
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    public User createNewUser(String username, String password, String email) {
        return null;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

}
