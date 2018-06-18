package de.hspf.sysdev.web.tests.util;

import de.hspf.sysdev.web.materialize.model.User;
import java.util.Collection;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

/**
 *
 * @author thomas.schuster
 */
public class RestClient {

    private final String baseURL = "http://localhost:50193/web-materialize/rest/";
    private ResteasyClient client = new ResteasyClientBuilder().build();

    public String getPlainResponse(String resource) {
        return client.target(baseURL + resource)
                .request()
                .get().readEntity(String.class);
    }

    public Collection<User> getUsersResponse(String resource) {

        final Response response = client.target(baseURL + resource).request(MediaType.APPLICATION_JSON_TYPE).get();
        final List<User> result = response.readEntity(new GenericType<List<User>>() {});

        return result;
    }

}
