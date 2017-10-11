package es.upm.miw.apaw.ecp2.api.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.IntSummaryStatistics;
import java.util.List;

import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.entities.State;
import es.upm.miw.apaw.ecp2.api.entities.Task;
import es.upm.miw.apaw.ecp2.api.entities.User;

public class TaskController {

    public Task getTask(int id) {
        return DaoFactory.getFactory().getTaskDao().read(id);
    }

    public Task createTask() {
        int id = getMaxIdFromTasksList();
        DaoFactory.getFactory().getTaskDao().create(new Task(id));
        return getTask(id);
    }

    private int getMaxIdFromTasksList() {
        List<Task> tasks = DaoFactory.getFactory().getTaskDao().findAll();
        int id = 1;
        if (!tasks.isEmpty()) {
            IntSummaryStatistics summary = tasks.stream().mapToInt(Task::getId).summaryStatistics();
            id = summary.getMax() + 1;
        }
        return id;
    }

    public void deleteTask(int id) {
        DaoFactory.getFactory().getTaskDao().deleteById(id);
    }
    
    public Task createTaskWithFixedUsers() {
        int id = getMaxIdFromTasksList(); 
        DaoFactory.getFactory().getTaskDao().create(new Task(id,State.IN_PROGRESS,getListFixedUsers()));
        return getTask(id);
    }

    private List<User> getListFixedUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User(1, "Robert Martin", Calendar.getInstance(), true));
        users.add(new User(1, "Kent Beck", Calendar.getInstance(), true));
        return users;
    }
}
