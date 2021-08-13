package com.api.rewards.controller.impl;

import com.api.rewards.controller.RewardRest;
import com.api.rewards.entity.Customer;
import com.api.rewards.service.RewardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@Slf4j
@RestController
public class RewardController implements RewardRest {

 @Autowired
 private RewardService rewardService;

 @Override
 public ResponseEntity<List<Customer>> findAllCustomers() {
 return new ResponseEntity<>(rewardService.getAllCustomers(), HttpStatus.OK);
 }

 @Override
 public ResponseEntity<Customer> getCustomerById(long id) {
 Customer customer = rewardService.getCustomerById(id);
 if(customer == null) {
 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
 }
 return new ResponseEntity<>(customer, HttpStatus.OK);
 }
}