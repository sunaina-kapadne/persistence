package com.backendcodingexercises.quarkus.helper;

import com.backendcodingexercises.quarkus.entity.Person;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.transaction.Transactional;

import java.time.LocalDate;

@ApplicationScoped
public class DataSeeder {
    @Transactional
    void onStart(@Observes StartupEvent event) {
        Person alice = new Person("Alice", LocalDate.of(1990, 5, 12));
        alice.persist();

        Person bob = new Person("Bob", LocalDate.of(1985, 3, 25));
        bob.persist();
    }
}
