package com.api.rewards.service.impl;

import java.util.List;

import com.api.rewards.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rewards.entity.Customer;
import com.api.rewards.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RewardServiceImpl implements RewardService {

 @Autowired
 private CustomerRepository repository;

 public Customer getCustomerById(final long customerId) {
 log.debug("CustomerRepository getCustomerById executed");
 return repository.findById(customerId).orElse(null);
 }
 
 public List<Customer> getAllCustomers(){
 log.debug("CustomerRepository getAllCustomers executed");
 return repository.findAll();
 }
}