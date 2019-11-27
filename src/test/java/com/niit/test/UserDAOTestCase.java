package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UserDAOTestCase {
	
	static UserDAO userDAO;
	static AnnotationConfigApplicationContext context;
	
		@BeforeClass
		public static void executeFirst() {
			context = new AnnotationConfigApplicationContext();
			context.scan("com.niit");
			context.refresh();

			userDAO = (UserDAO) context.getBean("userDAO");
			
		}
		
		@Ignore
		public void registerUserTestCase() {
			User user = new User();
			user.setUserName("hamza");
			user.setCustomerName("Hamza Patel");
			user.setEmailAddress("hmzptl111@gmail.com");
			user.setEnable("true");
			user.setPassword("123");
			user.setPhoneNumber("123");
			user.setRole("ROLE_USER");
			
			assertTrue("User could not be added!", userDAO.registerUser(user));
		}
		
		@Ignore
		public void modifyUserTestCase() {
			User user = new User();
			user = userDAO.getUser("hmzptl111@gmail.com");
			user.setEnable("true");
			user.setCustomerName("Hamza Patel");
			user.setPassword("123");
			user.setPhoneNumber("9892573687");
			user.setRole("ROLE_USER");
			user.setUserName("hmzptl111");
			
			assertTrue("User could not be modified!", userDAO.modifyUser(user));
		}
		
		@Ignore
		public void getUserTestCase() {
			User user = new User();
			user = userDAO.getUser("shoeb");
			assertNotNull(user);
		}
		
		@Ignore
		public void listUserTestCase() {
			List<User> listUser = userDAO.listUser();
			assertNotNull(listUser);
		}
		
		@AfterClass
		public static void executeLast() {
			context.close();
		}
}
