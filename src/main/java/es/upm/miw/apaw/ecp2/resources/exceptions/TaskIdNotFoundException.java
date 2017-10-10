package es.upm.miw.apaw.ecp2.resources.exceptions;

public class TaskIdNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public static final String DESCRIPTION = "El id de la tarea no existe";

    public TaskIdNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

    public TaskIdNotFoundException() {
        this("");
    }

}
