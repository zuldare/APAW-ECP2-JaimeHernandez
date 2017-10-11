package es.upm.miw.apaw.ecp2.api.dtos;

import es.upm.miw.apaw.ecp2.api.entities.Task;
import model.State;

public class TaskDto {

    private int id;

    private State state;

    public TaskDto() {

    }

    public TaskDto(Task task) {
        assert task != null;
        id = task.getId();
        state = task.getState();
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + "}";
    }
    
    public String toStringWithState() {
        return "{\"id\":" + id + ", \"state\":\"" + this.state + "\"}";
    }

}
