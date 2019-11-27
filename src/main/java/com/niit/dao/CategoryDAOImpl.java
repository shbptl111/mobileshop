package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
@SuppressWarnings("deprecation")
@Service
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Category getCategory(int categoryId) {
		try {
			Category category = (Category) sessionFactory.getCurrentSession().get(Category.class, categoryId);
			return category;
		} catch (Exception e) {
			return null;
		}
	}

	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Category> listCategories() {
		try {
			Query<Category> query = sessionFactory.getCurrentSession().createQuery("from Category");
			List<Category> listCategories = query.list();
			for(Category category : listCategories) {
				System.out.println(category.getCategoryName());
			}
			return listCategories;
		} catch (Exception e) {
			return null;
		}
	}

}