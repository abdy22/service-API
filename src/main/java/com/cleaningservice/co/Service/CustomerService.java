package com.cleaningservice.co.Service;


import com.cleaningservice.co.Model.Cleaner;
import com.cleaningservice.co.Model.Customer;
import com.cleaningservice.co.Repository.CleanerRepository;
import com.cleaningservice.co.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CleanerRepository cleanerRepository;

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public List<Customer> GetCustomersByCity(String name) {
        return repository.findByCityOfResidence(name);
    }

    public void AddCustomers(List<Customer> customers) {
        repository.saveAll(customers);
    }
    public void addCustomer(Customer customer) {
        repository.save(customer);
    }
    public  void deleteCustomer(int id) {
        Customer c = repository.findById(id).orElse(null);
        if (c != null)
            repository.delete(c);
    }
}
