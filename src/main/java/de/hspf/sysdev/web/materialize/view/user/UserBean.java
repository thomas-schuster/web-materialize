package de.hspf.sysdev.web.materialize.view.user;

import de.hspf.sysdev.web.materialize.model.Task;
import de.hspf.sysdev.web.materialize.model.User;
import de.hspf.sysdev.web.materialize.view.util.CreatorUtil;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collection;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author thomas
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    private User user;
    @Inject
    private CreatorUtil util;
   
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
        FacesMessage msg = new FacesMessage("Task Edited", ((Task) event.getObject()).getTaskId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Task) event.getObject()).getTaskId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onAddNew() {
        // Add one new task to the table
        Task task2Add = util.createTask("id2", "test", Task.TaskType.Task, 1);
        getUserTasks().add(task2Add);
        FacesMessage msg = new FacesMessage("New Task added", task2Add.getTaskId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
