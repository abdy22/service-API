package com.cleaningservice.co.Controller;

import com.cleaningservice.co.Model.Cleaner;
import com.cleaningservice.co.Model.Customer;
import com.cleaningservice.co.Service.CleanerService;
import com.cleaningservice.co.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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

    @GetMapping(value = "/Cleaners/city")
    @ResponseBody
    public List<Cleaner> getCleanerByCity(@RequestParam String cityName) {
        return cleanerService.getCleanersByCity(cityName);
    }

    @PostMapping(value = "/DeleteCleaner")
    public void deleteCleaner(@RequestParam int id) {
        cleanerService.deleteCleaner(id);
    }

    @PostMapping(value = "/BookCleaning")
    public String bookCleaning(@RequestParam int cleanerID, @RequestParam int customerID)  {
        return cleanerService.bookService(cleanerID,customerID);
    }

    @PostMapping(value = "/EndService")
    public String EndService(@RequestParam int cleanerID, @RequestParam int customerID)  {
        return cleanerService.endService(cleanerID,customerID);
    }

    @PostMapping(value = "/DeleteCustomer")
    public void deleteCustomer(@RequestParam int id) {
        customerService.deleteCustomer(id);
    }




}
