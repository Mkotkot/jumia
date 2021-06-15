package com.jumia.eg.controller;

import com.jumia.eg.dataDTO.CustomerDTO;
import com.jumia.eg.forms.CustomerForm;
import com.jumia.eg.services.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class CustomerController {


    final private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ModelAttribute("customersListData")
    public List<CustomerDTO> getCustomersListData() {
        return customerService.getCustomersList();
    }

    @ModelAttribute("CustomerReportForm")
    public CustomerForm getEmployeeReportForm(CustomerForm customerForm) {
        return customerForm;
    }

    @ModelAttribute("countriesList")
    public List<String> getCountriesList() {
        return customerService.getCurrentCountriesList();
    }

    @GetMapping("view")
    public String getViewCustomerPage(Model model) {
        CustomerForm customerForm = new CustomerForm();
        List<CustomerDTO> customerDTOS = customerService.getCustomersList(customerForm.getCountry());
        model.addAttribute("customersListData", customerDTOS);
        model.addAttribute("CustomersReportForm", customerForm);
        return "/ViewList";
    }

    @GetMapping("view/valid")
    public String getViewCustomerPageValid(Model model) {
        CustomerForm customerForm = new CustomerForm();
        List<CustomerDTO> customerDTOS = customerService.getCustomersListValidPhones();
        model.addAttribute("customersListData", customerDTOS);
        model.addAttribute("CustomersReportForm", customerForm);
        return "/ViewList";
    }

    @GetMapping("view/filter")
    public String getViewFilterCustomerPage(Model model, @ModelAttribute("CustomerReportForm") CustomerForm customerForm) {
        List<CustomerDTO> customerDTOS = customerService.getCustomersList(customerForm.getCountry());
        model.addAttribute("customersListData", customerDTOS);
        model.addAttribute("CustomersReportForm", customerForm);
        return "/ViewList";
    }


}
