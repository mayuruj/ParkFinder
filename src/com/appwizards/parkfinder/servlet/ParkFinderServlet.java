package com.appwizards.parkfinder.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appwizards.parkfinder.TO.LoginTO;
import com.appwizards.parkfinder.manager.ParkfinderManager;


/**
 * @author joe
 * @class  ParkFinderServlet
 * @
 *
 */
@SuppressWarnings("serial")
public class ParkFinderServlet extends HttpServlet {
	private static final	Logger	log		= 	
									Logger.getLogger(ParkFinderServlet.class.getName());
	
	/**
	 * @method  doPost
	 * @desc	servlet post method, performs post function of the servlet
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String msg="";
		try{
			LoginTO loginTO=new LoginTO();
			loginTO.setLoginValidator(req.getParameter("loginvalidator"));
			loginTO.setUserName(req.getParameter("username"));
			loginTO.setRegistrationId(req.getParameter("regId"));
			msg=new ParkfinderManager().createLogin(loginTO);
			resp.setContentType("text/plain");
			resp.getWriter().println(msg);
			
		}
		catch(Exception e){
			msg=e.getLocalizedMessage();
			resp.getWriter().println(msg);
		}
		
	}
}
