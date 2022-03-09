package com.cleaningservice.co.Service;

import com.cleaningservice.co.Model.Cleaner;
import com.cleaningservice.co.Model.Customer;
import com.cleaningservice.co.Repository.CleanerRepository;
import com.cleaningservice.co.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@Service
public class CleanerService {
    @Autowired
    private CleanerRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Cleaner> GetAllCleaner() {
       return repository.findAll();

    }

    public List<Cleaner> GetCleanersByCity(String cityName) {
        return repository.findByCityOfService(cityName);
    }

    public void AddCleaners(List<Cleaner> cleaners) {
        repository.saveAll(cleaners);
    }
    public void AddCleaner(Cleaner cleaner) {
        repository.save(cleaner);
    }
    public List<Cleaner> getCleanersByCity(String cityName) {
        return repository.findByCityOfService(cityName);
    }

    public boolean bookService(int cleanerID,int customerID) {
        Cleaner c = repository.findById(cleanerID).orElse(null);
        Customer customer = customerRepository.findById(customerID).orElse(null);

        if(c == null || customer == null) return false;
        else {

            if(c.bookService(customer.getName()) == true){
                   customer.setCleaner(c.getName());
                   customerRepository.save(customer);
                   repository.save(c);
                   //System.out.println("List of customers for cleaner: "+c.getCustomers().stream().toList().toString());
                   return  true;
            }
            return false;
        }


    }

    public void deleteCleaner(int id) {
        Cleaner cleaner = repository.findById(id).orElse(null);
        if (cleaner != null) {
            repository.delete(cleaner);
        }

    }
}
