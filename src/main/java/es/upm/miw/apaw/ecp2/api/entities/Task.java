package es.upm.miw.apaw.ecp2.api.entities;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private int id;

    private State state;

    private List<User> users;

    public Task() {

    }

    public Task(int id) {
        assert id >= 0;
        this.id = id;
        this.state = State.CREATED;
    }

    public Task(int id, State state, List<User> listFixedUsers) {
        assert id > 0;
        assert listFixedUsers != null;
        this.id = id;
        this.state = state;
        this.users = new ArrayList<User>(listFixedUsers);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + "]";
    }
}
