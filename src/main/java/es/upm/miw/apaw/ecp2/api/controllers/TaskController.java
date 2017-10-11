package es.upm.miw.apaw.ecp2.api.controllers;

import java.util.IntSummaryStatistics;
import java.util.List;

import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.dtos.TaskDto;
import es.upm.miw.apaw.ecp2.api.entities.Task;

public class TaskController {

    public TaskDto getTask(int id) {
        return new TaskDto(DaoFactory.getFactory().getTaskDao().read(id));
    }

    public void createTask() {
        List<Task> tasks = DaoFactory.getFactory().getTaskDao().findAll();
        int id = 0;
        if (!tasks.isEmpty()) {
            IntSummaryStatistics summary = tasks.stream().mapToInt(Task::getId).summaryStatistics();
            id = summary.getMax() + 1;
        }
        DaoFactory.getFactory().getTaskDao().create(new Task(id));
    }

}
