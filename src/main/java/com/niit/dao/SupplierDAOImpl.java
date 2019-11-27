package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Supplier;

@SuppressWarnings("deprecation")
@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean modifySupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean deleteSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public Supplier getSupplier(int supplierId) {
		try {
			Supplier supplier = (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, supplierId);
			return supplier;
		}
		catch(Exception e) {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Supplier> listSupplier() {
		try {
			Query<Supplier> query = sessionFactory.getCurrentSession().createQuery("from Supplier");
			List<Supplier> listSupplier = (List<Supplier>) query.list();
			return listSupplier;
		} catch (Exception e) {
			return null;
		}
	}

}