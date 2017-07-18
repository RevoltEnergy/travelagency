package com.travelagency.controller;

import com.travelagency.entity.CustomerEntity;
import com.travelagency.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ace on 07/17/2017.
 */

@Controller
public class CustomersController {
    private CustomersService customersService;

    @Autowired(required = true)
    @Qualifier(value = "customersService")
    public void setCustomersService(CustomersService customersService) {
        this.customersService = customersService;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String listCustomers(Model model) {
        model.addAttribute("customer", new CustomerEntity());
        model.addAttribute("listCustomers", this.customersService.getAllCustomers());

        return "customers";
    }

    @RequestMapping(value = "/customers/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") CustomerEntity customer) {
        if (customer.getId() == 0) {
            this.customersService.addCustomer(customer);
        } else {
            this.customersService.updateCustomer(customer);
        }

        return "redirect: /customers";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeCustomer(@PathVariable("id") int id) {
        this.customersService.deleteCustomer(customersService.getCustomerById(id));

        return "redirect: /customers";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editCustomer(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", this.customersService.getCustomerById(id));
        model.addAttribute("listCustomers", this.customersService.getAllCustomers());

        return "customers";
    }

    @RequestMapping(value = "/customerdata/{id}")
    public String customerData(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", this.customersService.getCustomerById(id));

        return "customerdata";
    }

    @RequestMapping(value = "/customers/search", method = RequestMethod.POST)
    public String searchCustomer(@RequestParam String searchCustomer, Model model) {
        model.addAttribute("customer", new CustomerEntity());
        model.addAttribute("listCustomers",
                this.customersService.getCustomersByColumnNameAndValue("lastname", searchCustomer));

        return "customers";
    }
}
