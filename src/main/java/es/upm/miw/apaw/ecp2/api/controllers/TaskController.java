package es.upm.miw.apaw.ecp2.api.controllers;

import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.dtos.TaskDto;

public class TaskController {

    public TaskDto getTask(int id) {
        return new TaskDto(DaoFactory.getFactory().getTaskDao().read(id));
    }

}
