package de.hspf.sysdev.web.materialize.view.user;

import de.hspf.sysdev.web.materialize.logic.UserController;
import de.hspf.sysdev.web.materialize.model.Task;
import de.hspf.sysdev.web.materialize.model.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author thomas
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    @EJB
    private UserController userService;
    
    private User user;

    public UserBean() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        return user.getUserName();
    }

    public Collection<Task> getUserTasks() {
        return user.getTaskList();
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Task Edited", ((Task) event.getObject()).getTaskName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Task) event.getObject()).getTaskName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onAddNew() {
        // Add one new task to the table
        Calendar date = Calendar.getInstance();
        //TODO customize edit
        //add a new task to the current users tasklist
        userService.createUserTask(user, "test", date.getTime(), Task.TaskType.Task);
        FacesMessage msg = new FacesMessage("New Task added");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
