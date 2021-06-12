package com.jumia.eg.services;

import com.jumia.eg.dataDTO.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<String> getCurrentCountriesList();

    List<CustomerDTO> getCustomersList();

    List<CustomerDTO> getCustomersList(String country);
}
