package com.jumia.eg.repositoies;

import com.jumia.eg.modle.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(nativeQuery = true, value = "select country from customer  group by country")
    List<String> getCurrentCountriesList();

    List<Customer> getAllByCountry(String country);

}
