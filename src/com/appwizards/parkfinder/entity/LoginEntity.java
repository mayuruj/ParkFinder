package com.appwizards.parkfinder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



/**
 * @author joe
 * @class  LoginEntity
 * @desc   Entity to persist
 */
@Entity
public class LoginEntity {
	/**
	 * Start of variable block
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private 							Long 	Id;
	private 							String 	username;
	private 							String	validator;
	private 							String 	registrationId;
	private 							String 	emailId;
	
	/**
	 * End of variable block
	 * @return
	 */
	
	
	/**
	 * Start getters and setters
	 * 
	 */
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getValidator() {
		return validator;
	}
	public void setValidator(String validator) {
		this.validator = validator;
	}
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	
	
	
}
