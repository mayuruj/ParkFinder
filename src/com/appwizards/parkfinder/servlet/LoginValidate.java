package com.appwizards.parkfinder.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mortbay.log.Log;

import com.appwizards.parkfinder.TO.LoginTO;
import com.appwizards.parkfinder.manager.ParkfinderManager;


/**
 * @author joe
 * @class  servlet to validate login
 *
 */
@SuppressWarnings("serial")
public class LoginValidate extends HttpServlet {
		private  static	 final		Logger	log		= 	
									Logger.getLogger(LoginValidate.class.getName());
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			//super.doPost(req, resp);
			String msg="";
			try{
				LoginTO loginTO = new LoginTO();
				String loginValidator=req.getParameter("password");
				String username=req.getParameter("username");
				loginTO.setLoginValidator(loginValidator);
				loginTO.setUserName(username);
				msg=new ParkfinderManager().validateLogin(loginTO);
				if(msg.equalsIgnoreCase("success")){
					//resp.getWriter().println("Login successfull");
					resp.sendRedirect("");
				}
				else
				{
					resp.getWriter().println("Invalid login credentials");
				}
			}
			catch(Exception e){
				resp.getWriter().println(e.getMessage());
				log.info(e.getMessage());
			}
			
			
		}
}
