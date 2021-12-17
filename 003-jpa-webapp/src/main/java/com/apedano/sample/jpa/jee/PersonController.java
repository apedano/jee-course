/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apedano.sample.jpa.jee;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Alessandro
 */
@Path("/api/person")
@ApplicationScoped
@Slf4j
public class PersonController {

   @Inject
   private PersonRepository personRepository;

   @POST
   public Response createPerson(Person person) {
       personRepository.create(person);
       return Response.ok(person).build();
   }

   @GET
   public List<Person> getAllPeople() {
       List<Person> people = personRepository.findAll();
       return people;
   }

   @GET
   @Path("/{id}")
   public Response getPerson(@PathParam("id") Long id) {
       log.info("REST request to get Person : {}", id);
       Person person = personRepository.find(id);
       if (person == null) {
           return Response.status(Response.Status.NOT_FOUND).build();
       } else {
           return Response.ok(person).build();
       }
   }

}