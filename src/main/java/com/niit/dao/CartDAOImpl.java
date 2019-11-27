package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.CartItem;

@SuppressWarnings("deprecation")
@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		} catch (Exception e) {
			System.out.println("Exception Arised: " + e);
			return false;
		}
	}

	public boolean deleteCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateCartItem(CartItem cartItem) {
		try {
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<CartItem> retrieveCartItems(String username) {
		try {

			Query<CartItem> query = sessionFactory.getCurrentSession()
					.createQuery("from CartItem where username=:uname and pstatus='NP'");
			query.setParameter("uname", username);
			List<CartItem> listCartItem = (List<CartItem>) query.list();
			return listCartItem;
		} catch (Exception e) {
			return null;
		}

	}

	public CartItem getCartItem(int cartItemId) {
		try {
			CartItem cartItem = sessionFactory.getCurrentSession().get(CartItem.class, cartItemId);
			return cartItem;
		} catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public CartItem getCartItemIfProductExists(int productId, String username) {
		try {
			Query<CartItem> query = sessionFactory.getCurrentSession().createQuery("from CartItem where username=:uname and productId=:pId and pstatus='NP'");
			query.setParameter("uname", username);
			query.setParameter("pId", productId);
			List<CartItem> listCartItem = (List<CartItem>) query.list();
			CartItem cartItem = listCartItem.get(0);
			return cartItem;
		} catch(Exception e) {
			return null;
		}
	}

}
