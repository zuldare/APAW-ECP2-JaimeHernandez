package es.upm.miw.apaw.ecp2.api.daos.memory;

import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.daos.TaskDao;

public class DaoMemoryFactory extends DaoFactory {

    private TaskDao taskDao;

    @Override
    public TaskDao getTaskDao() {
        if (taskDao == null) {
            taskDao = new TaskDaoMemory();
        }
        return taskDao;
    }
}
