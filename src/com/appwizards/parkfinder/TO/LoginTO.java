package com.appwizards.parkfinder.TO;

/**
 * @author joe
 * @class  LoginTO
 * @desc   Transfer object used to communicate between different layers  	
 */
public class LoginTO {
		/**
		 * Start of variable block
		 */
		private 							String 			userName;
		private								String			loginValidator;
		private 							String			registrationId;
		private 							String 			emailId;
		/**
		 * End of variable block
		 * 
		 */
		
		
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getRegistrationId() {
			return registrationId;
		}
		public void setRegistrationId(String registrationId) {
			this.registrationId = registrationId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getLoginValidator() {
			return loginValidator;
		}
		public void setLoginValidator(String loginValidator) {
			this.loginValidator = loginValidator;
		}
		
		
}
