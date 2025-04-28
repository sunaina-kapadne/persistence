package com.backendcodingexercises.quarkus.helper;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Liveness
@ApplicationScoped
public class DatabaseHealthCheck implements HealthCheck {
    @Override
    @Readiness
    public HealthCheckResponse call() {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "sa", "sa")) {
            // Simulate checking the database connection
            if (connection.isValid(2)) {  // Validity check with 2 seconds timeout
                return HealthCheckResponse.named("Database Check").up().build();
            }
        } catch (SQLException e) {
            return HealthCheckResponse.named("Database Check").down().withData("error", e.getMessage()).build();
        }

        return HealthCheckResponse.named("Database Check").down().withData("error", "Unknown").build();
    }

}
