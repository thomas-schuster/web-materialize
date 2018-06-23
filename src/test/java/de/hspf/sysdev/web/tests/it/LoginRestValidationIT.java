package de.hspf.sysdev.web.tests.it;

import de.hspf.sysdev.web.materialize.model.User;
import de.hspf.sysdev.web.tests.util.RestClient;
import java.util.Collection;
import javax.naming.NamingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author thomas.schuster
 */
public class LoginRestValidationIT {

    private static final Logger logger = LogManager.getLogger(LoginRestValidationIT.class);
    private static RestClient client;

    public LoginRestValidationIT() {
    }

    @BeforeClass
    public static void setUpClass() {
        client = new RestClient();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() throws NamingException {
        logger.info("try to call REST service");

        Collection<User> result = client.getUsersResponse("usercontroller/getuserlist");
        logger.info("web service response is: " + result);
        Assert.assertThat(result, hasSize(greaterThan(0)));
    }
}
