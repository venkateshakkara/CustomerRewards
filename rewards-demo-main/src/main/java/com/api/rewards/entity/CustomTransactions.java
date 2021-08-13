package com.api.rewards.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CustomTransactions {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private @Setter Long id;
	@JsonIgnore
	@ManyToOne
	@JoinColumn
	private @Setter Customer customer;
	private @Setter String description;
	private @Setter double total;
	@Temporal(TemporalType.TIMESTAMP)
	private @Setter Date purchaseDate;
	@JsonInclude
	@Transient
	private @Setter long points;
	
	public long getPoints() {
		points = 0l;
		
		if (total > 50 && total <= 100) {
			points += (total - 50) * 1;
			
		} 
		
		if (total > 100) {
			points += 50;  
			points += (total - 100) * 2;
		}
		
		return points;
	}

	@JsonBackReference
	public Customer getCustomer() {
		return customer;
	}

	public String getDescription() {
		return description;
	}

	public double getTotal() {
		return total;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}
	
}
