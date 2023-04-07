package com.virtualcave.demo.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_RATES")
public class Tarifa {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false,
            unique = true)	
	private Long brand_id;
	
	@Column(nullable = false,
            unique = true)
	private Long productId;
	
	@Column(nullable = false)
	private Timestamp start_date;
	
	@Column(nullable = false)
	private Timestamp end_date;
	
	private Long price;
	
	private String currency_code;
	
	public Tarifa() {
        super();
    }

	
	public Tarifa(Long id, Long brand_id, Long productId, Timestamp start_date, Timestamp end_date,
			Long price, String currency_code) {
		super();
		this.id = id;
        this.brand_id  = brand_id;
        this.productId = productId;
        this.start_date = start_date;
        this.end_date = end_date;
        this.price = price;
        this.currency_code = currency_code;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Long brand_id) {
		this.brand_id = brand_id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Timestamp getStart_date() {
		return start_date;
	}

	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}

	public Timestamp getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}

}
