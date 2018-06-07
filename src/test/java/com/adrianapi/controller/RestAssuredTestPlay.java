package com.adrianapi.controller;

import com.adrianapi.AdrianapiApplication;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;

import static org.junit.Assert.*;

public class RestAssuredTestPlay {

    @Before
    public void start() {
        SpringApplication.run(AdrianapiApplication.class);
    }

    @Test
    public void GetUser35()
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "http://localhost:8080/users/";

        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.request(Method.GET, "/35");

        // Now let us print the body of the message to see what response
        // we have recieved from the server
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
    }

}