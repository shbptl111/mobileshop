package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierDAOTestCase {

	static SupplierDAO supplierDAO;
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void executeFirst() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}

	@Ignore
	public void addSupplierTestCase() {
		Supplier supplier = new Supplier();
		supplier.setSupplierName("Motorola");
		supplier.setSupplierDesc("The second biggest Supplier");

		assertTrue("Supplier could not be added!", supplierDAO.addSupplier(supplier));
	}

	@Ignore
	public void modifySupplierTestCase() {
		Supplier supplier = new Supplier();
		supplier = supplierDAO.getSupplier(1);
		supplier.setSupplierName("Motorola");
		supplier.setSupplierDesc("The largest Supplier");
		assertTrue("Supplier could not be modified", supplierDAO.modifySupplier(supplier));
	}

	@Ignore
	public void getSupplierTestCase() {
		assertNotNull("Could not retrieve Supplier", supplierDAO.getSupplier(1));
	}

	@Ignore
	public void deleteSupplierTestCase() {
		Supplier supplier = new Supplier();
		supplier = supplierDAO.getSupplier(1);
		assertTrue("Supplier could not be deleted", supplierDAO.deleteSupplier(supplier));
	}

	@Ignore
	public void listSupplierTestCase() {
		assertNotNull("Could not retrieve Supplier List", supplierDAO.listSupplier());
	}
	
	@AfterClass
	public static void executeLast() {
		context.close();
	}

}