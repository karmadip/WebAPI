package com.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UnitMaster")
public class UnitMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String unit;
	

}
