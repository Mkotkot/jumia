package com.jumia.eg.services;

import com.jumia.eg.Constants;
import com.jumia.eg.dataDTO.CustomerDTO;
import com.jumia.eg.modle.Customer;
import com.jumia.eg.repositoies.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<String> getCurrentCountriesList() {
        return this.customerRepository.getCurrentCountriesList();
    }

    @Override
    public List<CustomerDTO> getCustomersList() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = customers.stream().map(CustomerDTO::new).collect(Collectors.toList());
        return customerDTOS;

    }

    @Override
    public List<CustomerDTO> getCustomersListValidPhones() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            for (String reg : Constants.regExList) {
                if (reg.matches(customer.getPhone())) {
                    customerDTOS.add(new CustomerDTO(customer));
                    break;
                }
            }
        }
        return customerDTOS;
    }

    @Override
    public List<CustomerDTO> getCustomersList(String country) {
        if (Constants.ALL.equals(country)) {
            return getCustomersList();
        } else {
            List<Customer> customers = customerRepository.getAllByCountry(country);
            List<CustomerDTO> customerDTOS = customers.stream().map(CustomerDTO::new).collect(Collectors.toList());
            return customerDTOS;
        }
    }
}
