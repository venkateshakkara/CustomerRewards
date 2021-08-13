package com.api.rewards.service;

import com.api.rewards.entity.Customer;
import java.util.List;

public interface RewardService {
 Customer getCustomerById(long customerId);
 List<Customer> getAllCustomers();
}