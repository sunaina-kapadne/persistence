package com.backendcodingexercises.quarkus.test;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class DatabaseHealthCheckTest {
    @Test
    public void testReadinessHealthCheck() {
        given()
                .when().get("/healthcheck/ready")
                .then()
                .statusCode(200)
                .body("status", equalTo("UP"));
    }

    @Test
    public void testLivenessHealthCheck() {
        given()
                .when().get("/healthcheck/live")
                .then()
                .statusCode(200)
                .body("status", equalTo("UP"));
    }

}
