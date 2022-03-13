package com.cleaningservice.co.Service;

import com.cleaningservice.co.Model.Cleaner;
import com.cleaningservice.co.Model.Customer;
import com.cleaningservice.co.Repository.CleanerRepository;
import com.cleaningservice.co.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    public String bookService(int cleanerID,int customerID)  {
        Cleaner c = repository.findById(cleanerID).orElse(null);
        Customer customer = customerRepository.findById(customerID).orElse(null);

        if(c == null || customer == null) return "Cant book service! Customer or the cleaner doest not exists";
        else {

           if (c.getCityOfService().equals(customer.getCityOfResidence())) {
               if (c.bookService(customer.getName())){
                   customer.setCleaner(c.getName());
                   customerRepository.save(customer);
                   repository.save(c);
                   //System.out.println("List of customers for cleaner: "+c.getCustomers().stream().toList().toString());
                   return "Successfully booked service with  "+c.getName();
               }
               return  "Can't book service! Customer is already scheduled with " +c.getName();
           }
            return "Can't book service! Customer and the cleaner are not in the same city";
        }


    }

    public  String endService(int cleanerID,int customerID) {
        Cleaner c = repository.findById(cleanerID).orElse(null);
        Customer customer = customerRepository.findById(customerID).orElse(null);

        if(c == null || customer == null) return " Customer or the cleaner doest not exists";
        else {

            if (c.getCityOfService().equals(customer.getCityOfResidence())) {
                if (c.getCustomers().contains(customer.getName())){
                    customer.getCleaner().remove(c.getName());
                    c.getCustomers().remove(c.getName());
                    customerRepository.save(customer);
                    repository.save(c);
                    return "Successfully ended service "+c.getName();
                }
                return  "Service does not exist " +c.getName();
            }
            return "Service does not exist";
        }

    }

    public void deleteCleaner(int id) {
        Cleaner cleaner = repository.findById(id).orElse(null);
        if (cleaner != null) {
            repository.delete(cleaner);
        }

    }
}
