package com.vastika.uis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
//not needed if you do @Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
@Entity
@Table(name="tbl_address")

public class Address {
	
	@Id 
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	@Column (name="city_name")
	private String city;
	@Column (name="country")
	private String country;
//	@OneToOne
//	private User user;
	
}
