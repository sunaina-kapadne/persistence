package com.backendcodingexercises.quarkus.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name="person")
public class Person extends PanacheEntity {

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public LocalDate birthDate;

    // Constructor
    public Person() {}

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', birthDate=" + birthDate + "}";
    }

}
