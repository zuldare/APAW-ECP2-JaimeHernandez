package es.upm.miw.apaw.ecp2.http;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.upm.miw.apaw.ecp2.api.daos.DaoFactory;
import es.upm.miw.apaw.ecp2.api.daos.memory.DaoMemoryFactory;
import es.upm.miw.apaw.ecp2.api.resources.TaskResource;

public class TaskResourceFunctionalTesting {

    private HttpRequest request;

    private HttpResponse response;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoMemoryFactory());
    }

    private void testCreateSingularTask() {
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(TaskResource.TASKS).build();
        response = new HttpClientService().httpRequest(request);
    }

    @Test
    public void testCreateTask() {
        request = new HttpRequestBuilder().method(HttpMethod.POST).path(TaskResource.TASKS).build();
        response = new HttpClientService().httpRequest(request);
        assertEquals(HttpStatus.CREATED, response.getStatus());
        assertEquals("{\"id\":1}", response.getBody());

        request = new HttpRequestBuilder().method(HttpMethod.POST).path(TaskResource.TASKS).build();
        response = new HttpClientService().httpRequest(request);
        assertEquals(HttpStatus.CREATED, response.getStatus());
        assertEquals("{\"id\":2}", response.getBody());
    }

    @Test
    public void testGetTasksId() {
        testCreateTask();
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(TaskResource.TASKS).path("/1").build();
        response = new HttpClientService().httpRequest(request);
        assertEquals("{\"id\":1, \"state\":\"CREATED\"}", response.getBody());
    }

    @Test(expected = HttpException.class)
    public void testGetTaskRequestInvalidException() {
        request = new HttpRequestBuilder().method(HttpMethod.GET).path("tasks").path("/X").build();
        new HttpClientService().httpRequest(request).getBody();
    }

    @Test
    public void testDeleteTasksId() {
        testCreateSingularTask();
        request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(TaskResource.TASKS).path("/1").build();
        response = new HttpClientService().httpRequest(request); 
        assertEquals(HttpStatus.NO_CONTENT, response.getStatus());
    }
    
    @Test 
    public void testDeleteTaskNoTaskPreviouslyCreated() {
        request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(TaskResource.TASKS).path("/100").build();
        response = new HttpClientService().httpRequest(request); 
        assertEquals(HttpStatus.NO_CONTENT, response.getStatus());
    }
    
    @Test 
    public void testDeleteTaskStringId() {
        request = new HttpRequestBuilder().method(HttpMethod.DELETE).path(TaskResource.TASKS).path("/XX").build();
        response = new HttpClientService().httpRequest(request); 
        assertEquals(HttpStatus.NO_CONTENT, response.getStatus());
    }

    @Test(expected = HttpException.class)
    public void testGetUsersFromTasksIdMalFormedPath() {
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(TaskResource.TASKS_ID).expandPath("users").build();
        response = new HttpClientService().httpRequest(request);
    }
    
    @Test
    public void testGetUsersFromTasksId() {
        testCreateSingularTask();
        request = new HttpRequestBuilder().method(HttpMethod.GET).path(TaskResource.TASKS_ID).expandPath("users").build();
        response = new HttpClientService().httpRequest(request);
        String text = "{{\"id\":1,\"state\":\"IN_PROGRESS\"}, [{\"name\":\"Robert Martin\"},{\"name\":\"Kent Beck\"}]}";
        assertEquals(HttpStatus.OK, response.getStatus());
        assertEquals(text,response.getBody());
        System.out.println(response.getBody());
    }
}
