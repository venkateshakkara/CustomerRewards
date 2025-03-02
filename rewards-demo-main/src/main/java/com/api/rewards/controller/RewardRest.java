package com.api.rewards.controller;

import com.api.rewards.constants.CommonConstants;
import com.api.rewards.entity.Customer;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
 @ApiOperation(value = "Get Sample Data", response = String.class)
 @ApiResponses(value = {
         @ApiResponse(code = 200, message = "Successfully retrieved sample data"),
         @ApiResponse(code = 404, message = "Sample data not found")
 })
 ResponseEntity<List<Customer>> findAllCustomers();

 @GetMapping ( value = CommonConstants.GET_CUSTOMERS_BY_ID_URL)
 ResponseEntity<Customer> getCustomerById(@PathVariable long id);
}