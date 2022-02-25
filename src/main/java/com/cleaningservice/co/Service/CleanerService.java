package com.cleaningservice.co.Service;

import com.cleaningservice.co.Model.Cleaner;
import com.cleaningservice.co.Model.Customer;
import com.cleaningservice.co.Repository.CleanerRepository;
import com.cleaningservice.co.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean bookService(Cleaner cleaner,Customer customer) {
        Cleaner c = repository.findById(cleaner.getId()).orElse(null);

        if(c == null) return false;
        else {

            if(c.bookService(customer) == true){
                Customer customer1 = customerRepository.findById(customer.getId()).orElse(null);
                if(customer1 == null){
                    customer.setCleaner(c);
                    customerRepository.save(customer);
                }
                else {
                   customerRepository.delete(customer1);
                   customer.setCleaner(c);
                   customerRepository.save(customer);
                }
                repository.delete(c);
                repository.save(c);
                return  true;
            }
            return false;
        }


    }

}
