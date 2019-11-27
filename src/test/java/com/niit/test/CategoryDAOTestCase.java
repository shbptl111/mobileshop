package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryDAOTestCase {

	static CategoryDAO categoryDAO;
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void executeFirst() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Ignore
	public void addCategoryTestCase() {
		Category category = new Category();
		category.setCategoryName("Mobiles");
		category.setCategoryDesc("Buy the best mobiles online");

		assertTrue("Category could not be added!", categoryDAO.addCategory(category));
	}

	@Ignore
	public void getCategoryTestCase() {
		boolean condition = false;
		if (categoryDAO.getCategory(1) != null) {
			condition = true;
		}
		assertTrue("Category could not be retrieved", condition);
	}

	@Ignore
	public void updateCategoryTestCase() {
		Category category = new Category();
		category = categoryDAO.getCategory(1);
		category.setCategoryDesc("Enhanced Laptop");
		category.setCategoryName("Smart laptops");
		assertTrue("Category could not be updated.", categoryDAO.updateCategory(category));
	}

	@Ignore
	public void deleteCategoryTestCase() {
		Category category = new Category();
		category = categoryDAO.getCategory(72);
		assertTrue("Could not delete the category", categoryDAO.deleteCategory(category));
	}

	@Ignore
	public void listCategoryTestCase() {
		List<Category> category = categoryDAO.listCategories();
		assertNotNull("Could not retrieve category list", category);
	}

	@AfterClass
	public static void executeLast() {
		if (context != null) {
			context.close();
		}

	}
}