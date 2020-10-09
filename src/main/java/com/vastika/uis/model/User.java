package com.vastika.uis.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import com.vastika.uis.model.Address;
import lombok.*;

@Data
//not needed if you do @Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//for logging @Slf4j
@Entity
@Table(name="tbl_user")


public class User {
	
	@Column (name="user_name") //should be same as on table
	@Size (min=2, max =7)
	private String username;
	
	//@Pattern(regexp="^(?=.*[0-9]).{8, }$", message="should start with string, have number, any character, min 8 chars, end of string")
	private String password;
	
	@Id //@Id should be always on top of the primary key
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id; 
	
	
	//one user can have many address and map or join table on basis of Fetch type eager means always give info
//	@OneToMany (cascade = CascadeType.ALL, mappedBy= "user", fetch=FetchType.EAGER) 
	 
	//@JoinTable
//	(
//			name= "user_address_tbl", 
//			joinColumns= @JoinColumn(name="user_id"), 
//			inverseJoinColumns = @JoinColumn(name= "address_id")
//			)
	
	//private List <Address> addresses;
	@OneToOne (cascade = CascadeType.ALL )
	private Address address;
	@Column (name="mobile_no")
	@Max (value=999, message= "mobile number should be at least 3 digits")
	private Long mobile;
	
	
	//date can be of different format so Spring doesn't understand it
	@DateTimeFormat(pattern="yyyy-mm-dd")
	@Temporal (TemporalType.DATE)
	@Past ( message= "dob can't be in future")
	private Date dob ;
	@NotEmpty
	//@NotNull if not work use @NotEmpty
	@Email
	private String email;
	private String gender;
	private String hobbies;
	private String nationality; 
	
	@OneToOne (cascade = CascadeType.MERGE)
	private Role role;
	
	private String imagePath ;

}
