package com.example.demo2;

import javax.ejb.Local;
import javax.persistence.TypedQuery;
import java.util.List;

@Local
public interface CustomerBeanInt {
    public void add(Customer user);
    public Customer get(long id);
    public void update(Customer user);
    public void delete(long id);
    public List<Customer> getAll();
}
