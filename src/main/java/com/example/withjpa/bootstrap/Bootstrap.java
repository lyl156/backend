package com.example.withjpa.bootstrap;

import com.example.withjpa.domain.Category;
import com.example.withjpa.domain.Customer;
import com.example.withjpa.repositories.CategoryRepository;
import com.example.withjpa.repositories.CustomerRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRespository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRespository, CustomerRepository customerRepository) {
        this.categoryRespository = categoryRespository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();

    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        // Category dried = new Category();
        // dried.setName("Dried");

        // Category fresh = new Category();
        // fresh.setName("Fresh");

        // Category exotic = new Category();
        // exotic.setName("Exotic");

        // Category nuts = new Category();
        // nuts.setName("Nuts");

        categoryRespository.save(fruits);
        // categoryRespository.save(dried);
        // categoryRespository.save(fresh);
        // categoryRespository.save(exotic);
        // categoryRespository.save(nuts);

        System.out.println("Categories Loaded: " + categoryRespository.count());
    }

    private void loadCustomers() {
        Customer customer1 = new Customer();
        customer1.setId(1l); // not needed
        customer1.setFirstname("Michale");
        customer1.setLastname("Weston");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        // customer2.setId(2l);
        // by @Id
        // @GeneratedValue(strategy = GenerationType.IDENTITY)
        customer2.setFirstname("Sam");
        customer2.setLastname("Axe");

        customerRepository.save(customer2);

        System.out.println("Customers Loaded: " + customerRepository.count());
    }
}