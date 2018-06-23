package de.hspf.sysdev.web.materialize.view.util;

import de.hspf.sysdev.web.materialize.model.Task;
import de.hspf.sysdev.web.materialize.model.Task.TaskType;
import de.hspf.sysdev.web.materialize.model.User;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * This class is a helper which will be removed later on, it only serves to
 * create mock objects.
 *
 * @author thomas.schuster
 */
@Named(value = "creatorBean")
@RequestScoped
public class CreatorUtil {

    private User user;

    public Collection<User> createUserList() {
        Collection<User> users = new ArrayList<>();
        users.add(createUser("thomas", "test"));
        users.add(createUser("werner", "test123"));
        users.add(createUser("stephan", "admin"));
        return users;
    }

    public User createUser(String name, String password) {
        User user = new User();
        user.setUserName(name);
        user.setPassword(password);

        Task task1 = createTask("Eine einfache Aufgabe", TaskType.Epic, 12);
        Task task2 = createTask("Eine schwierige Aufgabe", TaskType.Task, 8);
        Task task3 = createTask("Donald etwas Vernunft beibringen", TaskType.SubTask, 2);
        Collection<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        user.setTaskList(tasks);

        return user;
    }

    public Task createTask(String name, TaskType type, int offset) {
        Task task = new Task();
        task.setTaskName(name);
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DATE, offset);
        task.setDueDate(date.getTime());
        task.setType(type);

        return task;
    }
    
    public Task createTask(String name, TaskType type, Date date) {
        Task task = new Task();
        task.setTaskName(name);
        task.setDueDate(date);
        task.setType(type);

        return task;
    }

}
