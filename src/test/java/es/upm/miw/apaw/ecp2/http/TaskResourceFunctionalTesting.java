package es.upm.miw.apaw.ecp2.http;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TaskResourceFunctionalTesting {
    
    private HttpRequest request;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();

    
    public void testCreateTask() {
        HttpRequest request = new HttpRequestBuilder().method(HttpMethod.POST).path("tasks").body("1").build();
        new HttpClientService().httpRequest(request);
    }
    @Test
    public void testGetTasksId() {
        testCreateTask();
        
    }

}
