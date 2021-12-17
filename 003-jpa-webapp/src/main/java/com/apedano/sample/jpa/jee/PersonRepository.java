/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.apedano.sample.jpa.jee;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Alessandro
 */
@ApplicationScoped
public class PersonRepository {

   @PersistenceContext(unitName = "MysqlPU")
   private EntityManager em;

   @Transactional(Transactional.TxType.REQUIRED)
   public void create(Person person) {
       em.persist(person);
   }

   public List<Person> findAll() {
       return em.createQuery("SELECT p FROM Person p", Person.class)
                      .getResultList();
   }

   public Person find(Long id) {
       return em.find(Person.class, id);
   }

}
