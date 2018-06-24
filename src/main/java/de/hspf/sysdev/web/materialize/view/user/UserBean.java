package de.hspf.sysdev.web.materialize.view.user;

import de.hspf.sysdev.web.materialize.logic.UserController;
import de.hspf.sysdev.web.materialize.model.Task;
import de.hspf.sysdev.web.materialize.model.TaskType;
import de.hspf.sysdev.web.materialize.model.User;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author thomas
 */
@Named(value = "userBean")
@SessionScoped
public class UserBean implements Serializable {

    private static final Logger logger = LogManager.getLogger(UserBean.class);
    
    @EJB
    private UserController userService;
    
    private User user;
    private String newTaskName;
    private Date newDueDate;
    private TaskType newTaskType;
    
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

    public String getNewTaskName() {
        return newTaskName;
    }

    public void setNewTaskName(String newTaskName) {
        this.newTaskName = newTaskName;
    }

    public Date getNewDueDate() {
        return newDueDate;
    }

    public void setNewDueDate(Date newDueDate) {
        this.newDueDate = newDueDate;
    }

    public TaskType getNewTaskType() {
        return newTaskType;
    }

    public void setNewTaskType(TaskType newTaskType) {
        this.newTaskType = newTaskType;
    }
    
    public TaskType[] getTypes() {
        return TaskType.values();
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
        logger.info("initiated to add a new task");
        //add a new task to the current users tasklist
        userService.createUserTask(user, newTaskName, newDueDate, newTaskType);
        logger.info("added new task");
        FacesMessage msg = new FacesMessage("New task added");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
