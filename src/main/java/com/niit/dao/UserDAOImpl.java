package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.User;

@SuppressWarnings("deprecation")
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean registerUser(User user) {
		try {
			user.setRole("ROLE_USER");
			user.setEnable("true");
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}

	public boolean modifyUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public User getUser(String userName) {
		try {
			User user = (User) sessionFactory.getCurrentSession().get(User.class, userName);
			return user;
		}
		catch(Exception e) {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<User> listUser() {
		try {
			Query<User> query = sessionFactory.getCurrentSession().createQuery("from User");
			List<User> listUser = (List<User>) query.list();
			return listUser;
		}
		catch(Exception e) {
			return null;
		}
		
	}

}
