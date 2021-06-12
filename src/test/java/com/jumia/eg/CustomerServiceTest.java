package com.jumia.eg;

import com.jumia.eg.services.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerService customerService;


    @Test
    public void TestCustomersList() {
        customerService.getCustomersList();
    }

    @Test
    public void TestCustomersListByCountry() {
        customerService.getCustomersList("Morocco");
    }
}
