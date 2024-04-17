package product.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import product.dao.TourDAO;
import product.entites.Tour;

@Repository
public class TourDAOImpl implements TourDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Tour findById(int id) {
		Session session = sessionFactory.openSession();
		try {
			Tour tour = session.get(Tour.class, id);
			return tour;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean insert(Tour tour) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(tour);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean update(Tour tour) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(tour);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean delete(Integer tour) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(findById(tour));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public List<Tour> getAllTourStatus() {
		Session session = sessionFactory.openSession();
		try {
			return session.createQuery("FROM Tour where status = 1", Tour.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public List<Tour> getAllTours() {
		Session session = sessionFactory.openSession();
		try  {
			return session.createQuery("FROM Tour", Tour.class).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public List<Tour> getToursByCategory(int categoryId) {
		Session session = sessionFactory.openSession();
		try {
			String hql = "FROM Tour t WHERE t.category.id = :categoryId";
			return session.createQuery(hql, Tour.class).setParameter("categoryId", categoryId).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
	@Override
	public List<Tour> getToursByName(String n) {
		Session session = sessionFactory.openSession();
		String name;
		if(n != null) {
			name = "%"+n+"%";
		}else {
			name = "%";
		}
		try {
			
			String hql = "FROM Tour t WHERE t.tourName like :tourName";
			return session.createQuery(hql, Tour.class).setParameter("tourName", name).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}
}
