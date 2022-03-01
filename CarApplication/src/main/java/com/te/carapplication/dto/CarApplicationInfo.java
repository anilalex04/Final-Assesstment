package com.te.carapplication.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "CarDetails")
public class CarApplicationInfo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int carId;
	@Column
	private String carName;
	@Column
	private String company_Name;
	@Column
	private String fuel_type;
	@Column
	private String steering;
	@Column
	private String break_System;
	@Column
	private double showroom_Price;
	@Column
	private double onRoad_Price;
	@Column
	private String img_URL;
	@Column
	private double mileage;
	@Column
	private int seating_Capacity;
	@Column
	private int engine_Capacity;
	@Column
	private String gear_Type;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private UserApp userApp;

}
