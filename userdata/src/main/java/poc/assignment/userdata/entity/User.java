package poc.assignment.userdata.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

 @Data
@Entity
@Table(name = "user_data")
//@SQLDelete(sql = "UPDATE user_data SET user_status = 'DELETED' WHERE user_id = ?", check = ResultCheckStyle.COUNT)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "user_name")
	@NotNull(message = "{username}")
	private String userName;
	@Column(name = "sur_name")
	private String surName;
	@DateTimeFormat(pattern = "{dateOfJoining}")
	@JsonFormat(pattern = "dd-mm-yyyy")
	@Column(name="date_of_joining")
	private Date dateOfJoining;
	@DateTimeFormat(pattern = "{dateOfBirth}")
	@JsonFormat(pattern = "dd-mm-yyyy")
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	@Digits(integer = 10, fraction = 0, message = "{MobileNo}")
	@Min(value = 1000000000, message = "{MobileNo}")
	@NotNull(message = "{mobileNo}")
	@Column(name = "mobile_no")
	private Long mobileNo;
	@Email(message = "{email}")
	@NotNull(message = "{email_id}")
	@Column(name = "email_id")
	private String email;
	@NotNull(message = "{city}")
	@Column(name = "city")
	private String city;
	@NotNull(message = "{state}")
	@Column(name = "state")
	private String state;
	@Column(name="user_status")
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
		
	}
	