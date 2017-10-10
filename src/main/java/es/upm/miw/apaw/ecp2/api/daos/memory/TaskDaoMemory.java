package es.upm.miw.apaw.ecp2.api.daos.memory;

import java.util.HashMap;

import es.upm.miw.apaw.ecp2.api.daos.TaskDao;
import es.upm.miw.apaw.ecp2.api.entities.Task;

public class TaskDaoMemory extends GenericDaoMemory<Task> implements TaskDao {

    public TaskDaoMemory() {
        this.setMap(new HashMap<Integer, Task>());
    }

    @Override
    protected Integer getId(Task entity) {
        return entity.getId();
    }

    @Override
    protected void setId(Task entity, Integer id) {
        entity.setId(id);
    }

}
