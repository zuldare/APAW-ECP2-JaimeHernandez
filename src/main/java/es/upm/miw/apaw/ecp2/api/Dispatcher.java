package es.upm.miw.apaw.ecp2.api;

import es.upm.miw.apaw.ecp2.http.HttpRequest;
import es.upm.miw.apaw.ecp2.http.HttpResponse;
import es.upm.miw.apaw.ecp2.http.HttpStatus;

public class Dispatcher {

    private void responseError(HttpResponse response, Exception e) {
        response.setBody("{\"error\":\"" + e + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
    }

    public void doPost(HttpRequest request, HttpResponse response) {
    }

    public void doPut(HttpRequest request, HttpResponse response) {
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
    }

}
