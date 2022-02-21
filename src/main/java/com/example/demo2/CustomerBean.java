package com.example.demo2;

import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.persistence.spi.PersistenceUnitInfo;
import java.util.List;

@Stateless
public class CustomerBean{
    @PersistenceContext(unitName = "ris")
    private EntityManager em;

    public void add(Customer user){
        em.persist(user);
        //return em.merge(user);
    }

    public Customer get(long id){
        return em.find(Customer.class, id);
    }

    public void update(Customer user){
        add(user);
    }

    public void delete(long id){
        em.remove(get(id));
    }

    public List<Customer> getAll(){
        TypedQuery<Customer> namedQuery = em.createNamedQuery("Customer.getAll", Customer.class);
        return namedQuery.getResultList();
    }
}
