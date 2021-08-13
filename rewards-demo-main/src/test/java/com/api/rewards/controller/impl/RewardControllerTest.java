package com.api.rewards.controller.impl;

import com.api.rewards.RewardsServiceApplication;
import com.api.rewards.entity.Customer;
import com.api.rewards.repository.CustomerRepository;
import com.api.rewards.service.impl.RewardServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@WebMvcTest (RewardControllerTest.class)
@ContextConfiguration (classes={RewardsServiceApplication.class})
public class RewardControllerTest {

 @InjectMocks
 private RewardServiceImpl rewardService;

 @Mock
 private CustomerRepository customerRepository;



 @Test
 public void testGetAllCustomers() {
 List<Customer> customers = new ArrayList<>();
 Customer customer = new Customer();
 customer.setId(1L);
 customer.setName("test");
 customer.setRewardsPoint(3453);
 customers.add(customer);
 Customer customer1 = new Customer();
 customer.setId(2L);
 customer.setName("test1");
 customer.setRewardsPoint(453);
 customers.add(customer1);
 Mockito.when(customerRepository.findAll()).thenReturn(customers);
 assertNotNull(rewardService.getAllCustomers());
 }

 @Test
 public void testGetEmptyCustomers() {
 Mockito.when(customerRepository.findAll()).thenReturn(null);
 assertNull(rewardService.getAllCustomers());
 }

 @Test
 public void testgetCustomerById() {
 Customer customer = new Customer();
 customer.setId(1L);
 customer.setName("test");
 customer.setRewardsPoint(3453);
 Mockito.when(customerRepository.getById(1L)).thenReturn(customer);
 assertNotNull(customer);
 }

 @Test
 public void testEmptyListCustomerById() {
 Mockito.when(customerRepository.getById(1L)).thenReturn(null);
 assertNull(rewardService.getCustomerById(1));
 }

}