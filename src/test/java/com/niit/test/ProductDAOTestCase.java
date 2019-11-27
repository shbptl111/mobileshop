package com.niit.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class ProductDAOTestCase {

	static ProductDAO productDAO;
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void executeFirst() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		System.out.println(productDAO.getClass());
	}

	@Ignore
	public void addProductTestCase() {
		Product product = new Product();
		product.setProductName("Moto G11");
		product.setProductDesc("Best phone in the world");
		product.setPrice(18000);
		product.setStock(20);
		product.setCategoryId(1);
		product.setSupplierId(1);

		assertTrue("Product Added Successfully!", productDAO.addProduct(product));
	}

	@Ignore
	public void getProductTestCase() {
		Product product = new Product();
		product = productDAO.getProduct(1);
		assertEquals("Product [productName= Samsung J7]", product.toString());
	}

	@Ignore
	public void updateProductTestCase() {
		Product product;
		product = productDAO.getProduct(109);
		product.setProductName("Moto G2 Third Generation");
		product.setProductDesc("The worst phone of all");
		product.setPrice(1000);
		product.setStock(25);
		product.setCategoryId(12);
		product.setSupplierId(6);
		assertTrue("Price changed successfully!", productDAO.updateProduct(product));
	}

	@Ignore
	public void deleteProductTestCase() {
		Product product;
		product = productDAO.getProduct(6);
		assertTrue("Product Deleted!", productDAO.deleteProduct(product));
	}

	@Ignore
	public void listProductTestCase() {
		assertNotNull(productDAO.listProducts());
	}

	@Ignore
	public void listProductByCategoryTestCase() {
		assertNotNull(productDAO.listProductsByCategory(1));
	}
	
	@AfterClass
	public static void executeLast() {
		context.close();
	}
}