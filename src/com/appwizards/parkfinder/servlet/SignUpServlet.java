package com.appwizards.parkfinder.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appwizards.parkfinder.TO.LoginTO;
import com.appwizards.parkfinder.manager.ParkfinderManager;

public class SignUpServlet extends HttpServlet {
		
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
				// TODO Auto-generated method stub
				String msg="";
				try{
					LoginTO loginTO=new LoginTO();
					loginTO.setLoginValidator(req.getParameter("loginvalidator"));
					loginTO.setUserName(req.getParameter("username"));
					loginTO.setRegistrationId(req.getParameter("regId"));
					msg=new ParkfinderManager().createLogin(loginTO);
					resp.setContentType("text/plain");
					
				}catch(Exception e){
					msg=e.getMessage();
				}
				resp.getWriter().println(msg);
			}
}
