package com.adrianapi.controller;

import com.adrianapi.AdrianapiApplication;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserServiceTest {

    @LocalServerPort
    private final int PORT = 8080;

//    @BeforeClass
//    public static void start() {
//        SpringApplication.run(AdrianapiApplication.class);
//    }

    @Test
    public void getAllUsers_returnsStatusCode200_simple()
    {
        given()
                .when()
                    .get("/users")
                .then()
                    .statusCode(200);
    }

    @Test
    public void getAllUsers_returnsStatusCode200()
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "http://localhost:8080";

        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        RequestSpecification httpRequest = given();

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.request(Method.GET, "/users");

        // Now let us print the body of the message to see what response
        // we have recieved from the server
        int responseStatusCode = response.getStatusCode();
        Assert.assertEquals(200, responseStatusCode);
    }


    @Test
    public void getUser35_returnsStatusCode200()
    {
        RestAssured.baseURI = "http://localhost:8080/users/";

        RequestSpecification httpRequest = given();

        Response response = httpRequest.request(Method.GET, "/35");

        int responseStatusCode = response.getStatusCode();
        Assert.assertEquals(200, responseStatusCode);
    }

    @Test
    public void getUser35_returnsUser35()
    {
        RestAssured.baseURI = "http://localhost:8080/users/";

        RequestSpecification httpRequest = given();

        Response response = httpRequest.request(Method.GET, "/35");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        Assert.assertEquals("{\"id\":35,\"name\":\"yellow duck\",\"password\":\"pass\",\"email\":\"some@email.com\"}", responseBody);
    }

    @Test
    public void getUser999_returnsStatusCode404()
    {
        RestAssured.baseURI = "http://localhost:8080/users/";

        RequestSpecification httpRequest = given();

        Response response = httpRequest.request(Method.GET, "/999");

        int responseStatusCode = response.getStatusCode();
        Assert.assertEquals(404, responseStatusCode);
    }
}