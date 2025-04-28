package com.backendcodingexercises.quarkus.controller;

import com.backendcodingexercises.quarkus.entity.Person;
import com.backendcodingexercises.quarkus.repository.PersonRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResourceController {
    @Inject
    PersonRepository personRepository;

    // Create a new Person
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(Person person) {
        personRepository.persist(person);
        return Response.status(Response.Status.CREATED).entity(person).build();
    }

    // List all Persons
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons() {
        return personRepository.listAll();
    }

    // Find Person by name
    @GET
    @Path("/search/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPersonByName(@PathParam("name") String name) {
        return personRepository.findByName(name)
                .map(person -> Response.ok(person).build())
                .orElseGet(() -> Response.status(Response.Status.NOT_FOUND).build());
    }

}
