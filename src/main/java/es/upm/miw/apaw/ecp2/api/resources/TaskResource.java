package es.upm.miw.apaw.ecp2.api.resources;

import es.upm.miw.apaw.ecp2.api.controllers.TaskController;
import es.upm.miw.apaw.ecp2.resources.exceptions.TaskIdNotFoundException;

public class TaskResource {
    private int id;

    public TaskResource() {

    }

    public TaskResource(int id) {
        assert id > 0;
        this.id = id;
    }

    public void getTask(int id) throws TaskIdNotFoundException {
        new TaskController().getTask(id);
    }
}
