package es.upm.miw.apaw.ecp2.api.controllers;

import java.util.IntSummaryStatistics;
import java.util.List;

import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.entities.Task;

public class TaskController {

    public Task getTask(int id) {
        return DaoFactory.getFactory().getTaskDao().read(id);
    }

    public Task createTask() {
        List<Task> tasks = DaoFactory.getFactory().getTaskDao().findAll();
        int id = 1;
        if (!tasks.isEmpty()) {
            IntSummaryStatistics summary = tasks.stream().mapToInt(Task::getId).summaryStatistics();
            id = summary.getMax() + 1;
        }
        DaoFactory.getFactory().getTaskDao().create(new Task(id));
        return getTask(id);
    }

    public void deleteTask(int id) {
        DaoFactory.getFactory().getTaskDao().deleteById(id);
    }

}
