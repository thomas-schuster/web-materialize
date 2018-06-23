package de.hspf.sysdev.web.materialize;

import de.hspf.sysdev.web.materialize.logic.UserController;
import de.hspf.sysdev.web.materialize.model.User;
import de.hspf.sysdev.web.materialize.view.util.CreatorUtil;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author thomas.schuster
 */
@Singleton
@Startup
public class AppInitializerBean {

    private static final Logger logger = LogManager.getLogger(AppInitializerBean.class);

    @Inject
    CreatorUtil util;

    @EJB
    UserController userService;

    @PostConstruct
    public void init() {
        logger.info("initiated startup sequence");
        createSampleData();
    }

    private void createSampleData() {
        logger.info("create sample user data");
        Collection<User> users = util.createUserList();
        users.forEach((user) -> {
            userService.registerUser(user);
        });
    }

}
