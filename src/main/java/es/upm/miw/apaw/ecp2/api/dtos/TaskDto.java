package es.upm.miw.apaw.ecp2.api.dtos;

import es.upm.miw.apaw.ecp2.api.entities.Task;

public class TaskDto {

    private int id;
    
    public TaskDto() {
        
    }
    
    public TaskDto(Task task) {
        assert task != null;
        id = task.getId();
    }
    
    @Override
    public String toString() {
        return "{\"id\":" + id + "}";
    }
}
