package es.upm.miw.apaw.ecp2.http;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TaskResourceFunctionalTesting {
    
    private HttpRequest request;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();

    
    public void testCreateTask() {
        request = new HttpRequestBuilder().method(HttpMethod.POST).path("tasks").body("1").build();
        new HttpClientService().httpRequest(request);
    }
    @Test
    public void testGetTasksId() {
        testCreateTask();
        request = new HttpRequestBuilder().method(HttpMethod.GET).path("tasks").path("/1").build(); 
        assertEquals("[{\"id\":\"1\"}]", new HttpClientService().httpRequest(request).getBody());
    }
    
    @Test(expected = HttpException.class)
    public void testGetTaskIdNotFoundException() {
        request = new HttpRequestBuilder().method(HttpMethod.GET).path("tasks").path("/10").build();
        new HttpClientService().httpRequest(request).getBody();
    }
}
