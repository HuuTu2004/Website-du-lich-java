package product.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import product.dao.UserDAO;
import product.entites.Role;
import product.entites.User;
import product.entites.User_Role;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String username) {
		Session session = sessionFactory.openSession();
		try {
			User user = (User) session.createQuery("from User where userName = :userName")
					.setParameter("userName", username).uniqueResult();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean InsertUser(User u) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(u);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<User> findUsersWithoutRole() {
		Session session = sessionFactory.openSession();
		
		try{
			List<User> list = session.createQuery("SELECT u FROM User u WHERE u.id  IN (SELECT ur.user.id FROM User_Role ur)", User.class).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	@Override
	public List<User> findUsersWithoutNoRole() {
		Session session = sessionFactory.openSession();
		
		try{
			List<User> list = session.createQuery("SELECT u FROM User u WHERE u.id Not IN (SELECT ur.user.id FROM User_Role ur)", User.class).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	@Override
	public List<Role> ListUserRole() {
		Session session = sessionFactory.openSession();
		
		try{
			List<Role> list = session.createQuery("From Role", Role.class).getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	@Override
	public boolean InsertUserRole(User_Role u) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(u);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

}
