package de.hspf.sysdev.web.materialize.model;

import java.util.Date;

/**
 *
 * @author thomas.schuster
 */

public class Task {

    private String taskId;
    private String taskName;
    private Date dueDate;
    private TaskType type;

    public enum TaskType {
        Epic, UserStory, SubTask, Task
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }
    
    
}
