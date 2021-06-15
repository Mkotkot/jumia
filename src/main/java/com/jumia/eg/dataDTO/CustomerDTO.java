package com.jumia.eg.dataDTO;

import com.jumia.eg.modle.Customer;
import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {

    private int id;
    private String name;
    private String phone;
    private String country;

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.phone = customer.getPhone();
        this.country = customer.getCountry();
    }

    //todo for testing
    public CustomerDTO(String phone) {
        this.phone = phone;
    }
}
