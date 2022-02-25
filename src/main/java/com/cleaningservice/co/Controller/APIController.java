package com.cleaningservice.co.Controller;

import com.cleaningservice.co.Model.Cleaner;
import com.cleaningservice.co.Model.Customer;
import com.cleaningservice.co.Service.CleanerService;
import com.cleaningservice.co.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    private CleanerService cleanerService;

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/Cleaners")
    public List<Cleaner> GetAllCleaners(){
        return cleanerService.GetAllCleaner();
    }

    @GetMapping(value = "/Customers")
    public List<Customer> GetAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping(value = "/CreateCleaner")
    public void AddCleaner(@RequestBody Cleaner cleaner) {
        cleanerService.AddCleaner(cleaner);
    }

    @PostMapping(value = "/CreateCustomer")
    public void AddCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }


}
