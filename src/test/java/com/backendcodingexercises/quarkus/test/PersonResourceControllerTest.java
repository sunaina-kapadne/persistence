package com.backendcodingexercises.quarkus.test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@QuarkusTest
public class PersonResourceControllerTest {

    @Test
    public void testCreatePerson() {
        RestAssured.given()
                .body("{\"name\":\"Dylan\",\"birthDate\":\"1999-07-25\"}")
                .header("Content-Type", "application/json")
                .when().post("/persons")
                .then()
                .statusCode(201)
                .body("name", equalTo("Dylan"));
    }

    @Test
    public void testGetAllPersons() {
        RestAssured.given()
                .when().get("/persons")
                .then()
                .statusCode(200)
                .body("$", hasSize(2));
    }

    @Test
    public void testFindPersonByName() {
        RestAssured.given()
                .when().get("/persons/search/Alice")
                .then()
                .statusCode(200)
                .body("name", equalTo("Alice"));
    }
}
