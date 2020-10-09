package com.vastika.uis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="tbl_role")
public class Role {
	
	@Id //@Id should be always on top of the primary key
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	
	@Column (name="role_name")
	private String roleName;
	

}
