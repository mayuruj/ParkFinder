package com.appwizards.parkfinder.manager;

import java.util.List;
import java.util.logging.Logger;
import com.appwizards.parkfinder.TO.LoginTO;
import com.appwizards.parkfinder.service.ParkfinderService;



/**
 * @author joe
 * @class  ParkfinderManager
 * @desc   Business logic and server side validations
 *
 */
public class ParkfinderManager {
		/**
		 * Start of variable declaration
		 */
		private 	static	 final		Logger		log		= 	
										Logger.getLogger(ParkfinderManager.class.getName());
		/**
		 * End of variable block
		 */
		
		/**
		 * @method 		validateLogin
		 * @param  		loginTO
		 * @return 		msg
		 * @returnType	String
		 */
		public String validateLogin(LoginTO loginTO){
			String msg="";
			try{
				List<LoginTO> loginTOList=new ParkfinderService().getLogin();
				log.info("Size of loginTO list " + loginTOList.size());
				if(loginTOList!=null && loginTO!=null){
					for(LoginTO loginTO1:loginTOList){
						if(loginTO1.getUserName().equalsIgnoreCase(loginTO.getUserName())){
							if(loginTO1.getLoginValidator().equalsIgnoreCase(loginTO.getLoginValidator())){
								msg="success";
							}
						}
					}
				}
				
			}catch(Exception e){
				msg=e.getMessage();
			}
			return msg;
		}
		
		
		/**
		 * @method  createLogin
		 * @param   loginTO
		 * @return  msg
		 * @desc    mediates between servlet and persist service class
		 */
		public String createLogin(LoginTO loginTO){
			String msg="";
			try{	
				msg=new ParkfinderService().createLogin(loginTO);
				msg="success";
			}
			catch(Exception e){
				msg=e.getLocalizedMessage();
			}
			return msg;
		}
}
