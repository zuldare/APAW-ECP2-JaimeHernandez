package es.upm.miw.apaw.ecp2.api;

import es.upm.miw.apaw.ecp2.http.HttpRequest;
import es.upm.miw.apaw.ecp2.http.HttpResponse;
import es.upm.miw.apaw.ecp2.http.HttpStatus;
import es.upm.miw.apaw.ecp2.resources.exceptions.RequestInvalidException;
import es.upm.miw.apaw.ecp2.resources.exceptions.TaskIdNotFoundException;

public class Dispatcher {

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        try {
            if (request.isEqualsPath("tasks/{id}")) { 
                if (request.paths()[1] == "1") {
                    String body = String.format("[{%sid%s:%s1%s}]","\"","\"","\"","\"");
                    response.setBody(body);
                } else {
                    throw new TaskIdNotFoundException();
                }
            } else {
                throw new RequestInvalidException(request.getPath());
            }
        } catch (Exception e) {
            responseError(response, e);
        }
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        if (request.isEqualsPath("/tasks")) {
            // TODO create a resource --> request.getBody
            response.setStatus(HttpStatus.CREATED);
        }
    }

    public void doPut(HttpRequest request, HttpResponse response) {
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
    }

}
