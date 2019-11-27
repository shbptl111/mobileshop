package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.OrderDetail;

@SuppressWarnings("deprecation")
@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean insertOrderDetail(OrderDetail orderDetail) {
		try {
			orderDetail.setOrderDate(new java.util.Date());
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<OrderDetail> retrieveOrderDetails() {
		try {
			Query<OrderDetail> query = sessionFactory.getCurrentSession().createQuery("from OrderDetail");
			List<OrderDetail> orderList = (List<OrderDetail>) query.list();
			return orderList;
		} catch (Exception e) {
			return null;
		}
	}
}
