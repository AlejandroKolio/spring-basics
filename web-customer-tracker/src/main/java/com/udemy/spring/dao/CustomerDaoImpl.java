package com.udemy.spring.dao;

import com.udemy.spring.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author alexander.shakhov on 17.05.2018 17:03
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

    // Need to inject SessionFactory (from spring-mvc-crud-demo-servlet.xml) bean.
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        // 1. Get Hibernate session.
        Session currentSession = sessionFactory.getCurrentSession();
        // 2 create query and sort it.
        Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);
        // 3. Execute query and get result list
        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public Customer getCustomer(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomer(Integer id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Customer where id=:id");

        query.setParameter("id", id);

        query.executeUpdate();
    }
}
