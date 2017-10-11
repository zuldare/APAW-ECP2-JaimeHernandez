package es.upm.miw.apaw.ecp2.api.resources;

import es.upm.miw.apaw.ecp2.api.controllers.TaskController;
import es.upm.miw.apaw.ecp2.api.dtos.TaskDto;
import es.upm.miw.apaw.ecp2.resources.exceptions.TaskIdNotFoundException;

public class TaskResource {

    public static final String TASKS = "tasks";

    public static final String ID = "/{id}";

    public static final String TASKS_ID = TASKS + ID;
    
    public static final String ID_USERS = ID + "/users";

    public TaskResource() {
    }

    public TaskDto getTask(int id) throws TaskIdNotFoundException {
        return new TaskDto(new TaskController().getTask(id));
    }

    public TaskDto createTask() {
        return new TaskDto(new TaskController().createTask());
    }

    public void deleteTask(int id) {
        new TaskController().deleteTask(id);
    }

    public TaskDto createTaskWithFixedUsers() {
        return new TaskDto(new TaskController().createTaskWithFixedUsers());
    }
}
