package es.upm.miw.apaw.ecp2.api.entities;

import model.State;

public class Task {
    private int id;

    private State state;

    public Task() {

    }

    public Task(int id) {
        assert id >= 0;
        this.id = id;
        this.state = State.CREATED;
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

    @Override
    public String toString() {
        return "Task [id=" + id + "]";
    }
}
