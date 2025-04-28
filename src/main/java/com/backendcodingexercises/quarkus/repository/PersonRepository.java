package com.backendcodingexercises.quarkus.repository;

import com.backendcodingexercises.quarkus.entity.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {
    public Optional<Person> findByName(String name) {
        return find("name", name).firstResultOptional();
    }

}
