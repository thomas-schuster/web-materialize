package de.hspf.sysdev.web.materialize.view.util;

import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * A simple class to deal with context of views in JSF. This class literally
 * provides some short hands to common calls of session and faces context
 * objects.
 *
 * @author thomas.schuster
 */
public class ViewContextUtil {

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
        return (HttpServletRequest) getExternalContext().getRequest();
    }

    public static void redirect(String url) throws IOException {
        getExternalContext().redirect(url);
    }
}
