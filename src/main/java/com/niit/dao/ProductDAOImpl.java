package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;

@SuppressWarnings("deprecation")
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Product getProduct(int productId) {
		try {
			Product product = (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
			return product;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Product> listProducts() {
		try {
			Query<Product> query = sessionFactory.getCurrentSession().createQuery("from Product");
			List<Product> listProducts = query.list();
			return listProducts;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Product> listProductsByCategory(int categoryId) {
		try {
			Query<Product> query = sessionFactory.getCurrentSession().createQuery("from Product where categoryId=:catId");
			query.setParameter("catId", categoryId);
			List<Product> listProducts = query.list();
			return listProducts;
		} catch (Exception e) {
			return null;
		}
	}

}