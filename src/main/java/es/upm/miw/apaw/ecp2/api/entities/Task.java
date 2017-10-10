package es.upm.miw.apaw.ecp2.api.entities;

public class Task {
    private int id;

    public Task(int id) {
        assert id >= 0;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + "]";
    }
}
