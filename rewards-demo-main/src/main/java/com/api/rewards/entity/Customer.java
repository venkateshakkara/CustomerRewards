package com.api.rewards.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private @Setter Long id;
	private @Setter String name;
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private @Setter Set<CustomTransactions>transactions;
	
	@JsonInclude
	@Transient
	private @Setter long rewardsPoint;
	@JsonInclude
	@Transient
	private @Setter double totalPurchase;
	
	public long getRewardsPoint() {
		
		if(transactions == null || transactions.isEmpty()) {
			return 0l;
		}
		
		return transactions.stream().mapToLong(a -> a.getPoints()).sum();
	}
	
	public double getTotalPurchase() {
		if(transactions == null || transactions.isEmpty()) {
			return 0;
		}
		return transactions.stream().mapToDouble(a -> a.getTotal()).sum();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@JsonManagedReference
	public Set<CustomTransactions> getTransactions() {
		return transactions;
	}
	
}
