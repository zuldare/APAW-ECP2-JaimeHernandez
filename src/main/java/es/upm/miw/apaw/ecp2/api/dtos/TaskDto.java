package es.upm.miw.apaw.ecp2.api.dtos;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.apaw.ecp2.api.entities.State;
import es.upm.miw.apaw.ecp2.api.entities.Task;
import es.upm.miw.apaw.ecp2.api.entities.User;

public class TaskDto {

    private int id;

    private State state;

    private List<User> users;

    public TaskDto() {

    }

    public TaskDto(Task task) {
        assert task != null;
        id = task.getId();
        state = task.getState();
        users = new ArrayList<User>(task.getUsers());
    }

    @Override
    public String toString() {
        return "{\"id\":" + id + "}";
    }

    public String toStringWithState() {
        return "{\"id\":" + id + ", \"state\":\"" + this.state + "\"}";
    }

    public String toStringWithStateAndUsers() {
        String userString = "[" + getUserNameFromUsers() + "]";
        return "{{\"id\":" + id + ", \"state\":\"" + this.state + "\"}" + ", " + userString + "}";
    }
    
    private String getUserNameFromUsers() {
        String result = "";
        int pos = 0;
        for (User user : users) {
            result += "{\"name\":\"" + user.getName() + "\"}";
            if (pos < users.size() - 1) {
                result += ", ";
            }
            pos++;
        }
        return result;
    }
}
