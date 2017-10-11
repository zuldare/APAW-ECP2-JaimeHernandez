package es.upm.miw.apaw.ecp2.api.entities;

import java.util.Calendar;

public class User {

    private int id;

    private String name;

    private Calendar birthdate;

    private boolean active;

    public User(int id) {
        this.id = id;
        this.name = "";
        this.birthdate = Calendar.getInstance();
        this.active = false;
    }

    public User(int id, String name, Calendar birthdate, boolean active) {
        assert name != null;
        assert birthdate != null;
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Calendar birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return String.format("User[%d,%s,%s,%s]", id, name, birthdate.getTime(), active);
    }
}
