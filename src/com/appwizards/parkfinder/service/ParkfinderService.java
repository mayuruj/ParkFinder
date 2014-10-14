package com.appwizards.parkfinder.service;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.appwizards.parkfinder.TO.LoginTO;
import com.appwizards.parkfinder.entity.LoginEntity;


/**
 * @author joe
 * @class  ParkfinderService
 * @desc   Handle JPA transactions
 */
public class ParkfinderService {
		/**
		 * Start variable block
		 */
		private 								EntityManagerFactory    entityManagerFactory;
		private									EntityManager			entityManager;
		private 	static 	final				Logger					log						= 	
												Logger.getLogger(ParkfinderService.class.getName());
		/**
		 * End of variable block
		 */
		
		
		/**
		 * @method 		createLogin
		 * @param 		loginTO
		 * @return 		msg
		 * @returnType  String
		 * @desc		JPA construct to handle database transactions
		 */
		public String createLogin(LoginTO loginTO){
			String msg="";
			try{
				log.info("Inside createLogin");
				
				//get from loginTO fill into loginEntity
				LoginEntity loginEntity=new LoginEntity();
				loginEntity.setValidator(loginTO.getLoginValidator());
				loginEntity.setUsername(loginTO.getUserName());
				loginEntity.setRegistrationId(loginTO.getRegistrationId());
				
				//Time to persist using entityManager
				entityManagerFactory=Persistence.createEntityManagerFactory("transactions-optional");
				entityManager=entityManagerFactory.createEntityManager();
				entityManager.persist(loginEntity);
				msg="success";
			}
			catch(Exception e){
				msg=e.getLocalizedMessage();
			}
			finally{
				entityManager.close();
			}
			return msg;
			
			
			
		}
		
		/**
		 * @method 		getLogin
		 * @return 		loginTOList
		 * @returnType	List<LoginTO>
		 * @desc		gets all the logged in users 
		 */
		
		public List<LoginTO> getLogin(){
			List<LoginTO> loginTOList=new ArrayList<LoginTO>();
			
			try{
				
				//re-initialize entity manager 
				entityManagerFactory=Persistence.createEntityManagerFactory("transactions-optional");
				entityManager=entityManagerFactory.createEntityManager();
				
				//write a query
				Query q=entityManager.createQuery("select k from LoginEntity k");
				@SuppressWarnings("unchecked")
				List<LoginEntity> loginEntityList=new ArrayList<LoginEntity>(q.getResultList());
				
				//Log the size of lost on the server
				log.info("Size of the list"+loginEntityList.size());
				
				//get from entity and fill the transfer object
				for(int i=0;i<loginEntityList.size();i++){
					LoginTO loginTO=new LoginTO();
					loginTO.setLoginValidator(loginEntityList.get(i).getValidator());
					loginTO.setUserName(loginEntityList.get(i).getUsername());
					loginTO.setRegistrationId(loginEntityList.get(i).getRegistrationId());
					loginTOList.add(loginTO);
				}
				//log.info("")
				
			}
			catch(Exception e){
				log.info("Error : " +e.getLocalizedMessage());
			}
			finally{
				entityManager.close();
			}
			return loginTOList;
				
			
		
		}
		
		
		
		
}
