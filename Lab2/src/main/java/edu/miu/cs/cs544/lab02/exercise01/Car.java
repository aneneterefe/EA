package edu.miu.cs.cs544.lab02.exercise01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CAR")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(name="BRAND",nullable = false)
	public String brand;
	
	@Column(name="YEAR", nullable = false)
	public Integer year;
	
	@Column(name="PRICE",nullable = false)
	public Double price;
	
}
