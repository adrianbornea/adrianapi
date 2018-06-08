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

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserServiceTest {

    @LocalServerPort
    private final int PORT = 8080;

    @Test
    public void getAllUsers_returnsStatusCode200()
    {
        given()
                .when()
                    .get("/users")
                .then()
                    .statusCode(200);
    }

    @Test
    public void getAllUsers_returnsStatusCode204_whenDatabaseIsEmpty()
    {
        given()
                .when()
                    .get("/users")
                .then()
                    .statusCode(204);
    }

//    @Test
//    public void getAllUsers_returnsStatusCode200()
//    {
//        // Specify the base URL to the RESTful web service
//        RestAssured.baseURI = "http://localhost:8080";
//
//        // Get the RequestSpecification of the request that you want to sent
//        // to the server. The server is specified by the BaseURI that we have
//        // specified in the above step.
//        RequestSpecification httpRequest = given();
//
//        // Make a request to the server by specifying the method Type and the method URL.
//        // This will return the Response from the server. Store the response in a variable.
//        Response response = httpRequest.request(Method.GET, "/users");
//
//        // Now let us print the body of the message to see what response
//        // we have recieved from the server
//        int responseStatusCode = response.getStatusCode();
//        Assert.assertEquals(200, responseStatusCode);
//    }

    @Test
    public void getUser44_returnsStatusCode200_simple()
    {
        given()
                .when()
                    .get("/users/44")
                .then()
                    .statusCode(200);
    }

//    @Test
//    public void getUser44_returnsStatusCode200()
//    {
//        RestAssured.baseURI = "http://localhost:8080/users/";
//
//        RequestSpecification httpRequest = given();
//
//        Response response = httpRequest.request(Method.GET, "/44");
//
//        int responseStatusCode = response.getStatusCode();
//        Assert.assertEquals(200, responseStatusCode);
//    }

//    @Test
//    public void getUser35_returnsUser35()
//    {
//        RestAssured.baseURI = "http://localhost:8080/users/";
//
//        RequestSpecification httpRequest = given();
//
//        Response response = httpRequest.request(Method.GET, "/35");
//
//        String responseBody = response.getBody().asString();
//        System.out.println("Response Body is =>  " + responseBody);
//        Assert.assertEquals("{\"id\":35,\"name\":\"yellow duck\",\"password\":\"pass\",\"email\":\"some@email.com\"}", responseBody);
//    }

    @Test
    public void getUser44_returnsUser44() {
        given()
                .when()
                    .get("/users/44")
                .then()
                    .body("name", equalTo("Test User"))
                    .body("password", equalTo("testpassword"))
                    .body("email", equalTo("test@email.com"));
    }


//    @Test
//    public void getUser999_returnsStatusCode404()
//    {
//        RestAssured.baseURI = "http://localhost:8080/users/";
//
//        RequestSpecification httpRequest = given();
//
//        Response response = httpRequest.request(Method.GET, "/999");
//
//        int responseStatusCode = response.getStatusCode();
//        Assert.assertEquals(404, responseStatusCode);
//    }

    @Test
    public void getUser888_returnsStatusCode404() {
        given()
                .when()
                .get("/users/888")
                .then()
                .statusCode(404);
    }

    @Test
    public void addUser_returnsStatusCode201() {
        Map<String, String> user = new HashMap<>();
        user.put("name", "Post Test");
        user.put("password", "pass");
        user.put("email", "email");

        given()
                .contentType("application/json")
                .body(user)
                .when()
                    .post("/users")
                .then()
                .statusCode(201);
    }

    @Test
    public void addUser_returnsStatusCode400_whenMissingAField() {
        Map<String, String> user = new HashMap<>();
        user.put("name", "Post Test");
        user.put("password", "pass");

        given()
                .contentType("application/json")
                .body(user)
                .when()
                    .post("/users")
                .then()
                    .statusCode(400);
    }

    @Test
    public void updateUserFull_returnsStatusCode200() {
        Map<String, String> user = new HashMap<>();
        user.put("id", "42");
        user.put("name", "Updated Name Test");
        user.put("password", "update name test pass");
        user.put("email", "update name test email");

        given()
                .contentType("application/json")
                .body(user)
                .when()
                    .put("/users/42")
                .then()
                    .statusCode(200);
    }

    @Test
    public void updateUserFull_returnsStatusCode400_whenMissingFields() {
        Map<String, String> user = new HashMap<>();
        user.put("id", "42");
        user.put("password", "update name test pass");
        user.put("email", "update name test email");

        given()
                .contentType("application/json")
                .body(user)
                .when()
                    .put("/users/42")
                .then()
                    .statusCode(400);
    }

    @Test
    public void updateUserPartial_returnsStatusCode200() {
        Map<String, String> user = new HashMap<>();
        user.put("id", "42");
        user.put("name", "Updated Only Name Test");

        given()
                .contentType("application/json")
                .body(user)
                .when()
                    .patch("/users/42")
                .then()
                    .statusCode(200);
    }

    @Test
    public void updateUserPartial_returnsStatusCode404_whenUserDoesntExist() {
        Map<String, String> user = new HashMap<>();
        user.put("id", "404");
        user.put("password", "update name test pass");
        user.put("email", "update name test email");

        given()
                .contentType("application/json")
                .body(user)
                .when()
                    .patch("/users/404")
                .then()
                    .statusCode(404);
    }

    @Test
    public void deleteUser_returnsStatusCode404_whenUserDoesntExist() {

        given()
                .when()
                    .delete("/users/404")
                .then()
                    .statusCode(404);
    }

    @Test
    public void deleteUser_returnsStatusCode200_whenDeleted() {

        given()
                .when()
                    .delete("/users/38")
                .then()
                    .statusCode(200);
    }


}