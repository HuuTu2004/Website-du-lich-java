package product.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product.dao.OrderDetailDAO;
import product.entites.OrderDetail;

@Repository
public class OrderDetailDAOimpl implements OrderDetailDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveOrderDetail(OrderDetail orderDetail) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(orderDetail);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return false;

	}

	@Override
	public boolean updateOrderDetail(OrderDetail orderDetail) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(orderDetail);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}finally {
        	session.close();
		}

	}

	@Override
	public boolean deleteOrderDetail(long orderDetailId) {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public OrderDetail getOrderDetailById(Integer orderDetailId) {
		Session session = sessionFactory.openSession();

		try {

			OrderDetail od = session.get(OrderDetail.class, orderDetailId);

			return od;
		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<OrderDetail> getListOrder(long userId) {
		Session session = sessionFactory.openSession();

		try {

			List<OrderDetail> list = session.createQuery("from OrderDetail where user.id = :userId", OrderDetail.class)
					.setParameter("userId", userId).list();

			return list;
		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			session.close();
		}
		return null;
	}
	@Override
	public List<OrderDetail> getAllListOrder(Boolean status) {
		Session session = sessionFactory.openSession();

		try {

			List<OrderDetail> list = session.createQuery("from OrderDetail where status = :status  ", OrderDetail.class).setParameter("status", status)
			.list();

			return list;
		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			session.close();
		}
		return null;
	}

}
