package com.api.rewards.controller;

import com.api.rewards.constants.CommonConstants;
import com.api.rewards.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping (value = CommonConstants.BASE_PATH)
public interface RewardRest {


 @GetMapping ( value = CommonConstants.GET_CUSTOMER_URL)
 ResponseEntity<List<Customer>> findAllCustomers();

 @GetMapping ( value = CommonConstants.GET_CUSTOMERS_BY_ID_URL)
 ResponseEntity<Customer> getCustomerById(@PathVariable long id);
}