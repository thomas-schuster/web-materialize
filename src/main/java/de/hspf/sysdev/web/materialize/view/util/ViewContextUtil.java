package de.hspf.sysdev.web.materialize.view.util;

import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A simple class to deal with context of views in JSF. This class literally
 * provides some short hands to common calls of session and faces context
 * objects.
 *
 * @author thomas.schuster
 */
public class ViewContextUtil {

    private static final Logger logger = LogManager.getLogger(ViewContextUtil.class);

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public static ExternalContext getExternalContext() {
        return getFacesContext().getExternalContext();
    }

    public static HttpSession getSession() {
        return (HttpSession) getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest() {
        logger.debug("requested access to HttpServletRequest");
        return (HttpServletRequest) getExternalContext().getRequest();
    }

    /**
     * *
     * This method will redirect to any url (also outside the current
     * application
     *
     * @param url
     * @throws IOException
     */
    public static void redirect(String url) throws IOException {
        logger.debug("requested redirect");
        logger.debug("current page was: " + getFacesContext().getViewRoot().getViewId());
        logger.debug("intended target is: " + url);

        getExternalContext().redirect(url);
    }

    /**
     * *
     * This method will call the application's navigation handler to implement a
     * redirect. The method will trigger a faces redirect.
     *
     * @param page to navigate to
     *
     */
    public static void internalRedirect(String page) {
        logger.debug("requested internal redirect");
        logger.debug("current page was: " + getFacesContext().getViewRoot().getViewId());
        logger.debug("intended target is: " + page);

        getFacesContext().getApplication().getNavigationHandler().handleNavigation(getFacesContext(), getFacesContext().getViewRoot().getViewId(), page + "?faces-redirect=true");
    }

}
