package de.hspf.sysdev.web.materialize.logic.dao;

import de.hspf.sysdev.web.materialize.model.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author thomas.schuster
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {

    private static final Logger logger = LogManager.getLogger(UserFacade.class);

    @PersistenceContext(unitName = "materialize_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    /**
     * *
     * This method will return the user specified by name. If either no or
     * multiple users are found the method will log an error and return a null
     * value.
     *
     * @param userName - user to search for
     * @return user object, if a user was found
     */
    public User findByName(@NotNull String userName) {
        logger.debug("searching user: " + userName);
        TypedQuery<User> query = em.createNamedQuery("User.findByName", User.class);
        query.setParameter("name", userName);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            logger.error("could not find user, error message was: " + e.getMessage());
            return null;
        }
    }

}
