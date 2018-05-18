package com.udemy.spring.service;

import com.udemy.spring.dao.CustomerDao;
import com.udemy.spring.entity.Customer;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author alexander.shakhov on 18.05.2018 11:02
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(Integer id) {
        return customerDao.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(Integer id) {
        customerDao.deleteCustomer(id);
    }

    @Override
    @Transactional
    public List<Customer> searchCustomers(String searchName) {
        return customerDao.searchCustomers(searchName);
    }
}
